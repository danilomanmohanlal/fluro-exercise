package com.fluro.exercise;

import com.fluro.exercise.campaigns.BuyNGet1;
import com.fluro.exercise.campaigns.Campaign;
import com.fluro.exercise.campaigns.MealDeal;
import com.fluro.exercise.campaigns.Multipriced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Main m = new Main();

        //m.part1();
        m.part2();

    }

    private void part1() {

        int total = 0;
        String[] cart = new String[]{"A","B","C","D","E","B", "B", "B", "B", "C", "C", "C", "C", "D"};

        Map<String, Integer> cartMap = new HashMap<>();
        Map<String, Campaign> activeCampaigns = getCampaigns();
        Map<String, Product> products = getProducts();


        // map with skus and their quantity
        for (String item: cart) {
            cartMap.put(item, cartMap.getOrDefault(item, 0) + 1);
        }


        // loop over active product campaigns
        for (Map.Entry<String, Campaign> entry : activeCampaigns.entrySet()) {
            String key = entry.getKey();
            Campaign value = entry.getValue();

            //check if cart has any of the products in campaign
            // the cartMap will be updated after processing the discount
            if (cartMap.containsKey(key)) {
                total += value.calculateDiscount(cartMap);
            }
        }

        //loop over remaining products to calculate total
        for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            total += products.get(key).getPrice() * value;
        }

        System.out.println("Total " + total);
    }

    private Map<String, Product> getProducts() {

        Map<String, Product> res = new HashMap<>();
        Product p1 = new Product("A", 50);
        Product p2 = new Product("B", 75);
        Product p3 = new Product("C", 25);
        Product p4 = new Product("D", 150);
        Product p5 = new Product("E", 200);

        res.put("A", p1);
        res.put("B", p2);
        res.put("C", p3);
        res.put("D", p4);
        res.put("E", p5);

        return res;
    }

    private Map<String, Campaign> getCampaigns() {

        Map<String, Campaign> res = new HashMap<>();

        Multipriced multipriced = new Multipriced("B", 2, 125);
        BuyNGet1 buyNGet1 = new BuyNGet1("C", 3);
        MealDeal mealDeal = new MealDeal(new String[]{"D", "E"}, 300);


        res.put("B", multipriced);
        res.put("C", buyNGet1);
        res.put("D", mealDeal);

        return res;
    }

    private void part2() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the products in the cart separated by comma (ex: A,B,B,C,C,C,C,C,C,C,C,D,E,E,B,B,B)");

        String inputCart = sc.nextLine();
        String[] cart = inputCart.trim().split(",");

        System.out.println("Enter the promotions that are active separated by comma (ex: multipriced:B:2:125,buynget1:C:3,mealdeal:D:E:300) ");
        String inputPromos = sc.nextLine();
        String[] promos = inputPromos.trim().split(",");

        int total = 0;

        Map<String, Campaign> activeCampaigns = parsePromotions(promos);
        Map<String, Product> products = getProducts();
        Map<String, Integer> cartMap = parseCart(cart);

        // loop over active product campaigns
        for (Map.Entry<String, Campaign> entry : activeCampaigns.entrySet()) {
            String key = entry.getKey();
            Campaign value = entry.getValue();

            //check if cart has any of the products in campaign
            // the cartMap will be updated after processing the discount
            if (cartMap.containsKey(key)) {
                total += value.calculateDiscount(cartMap);
            }
        }

        //loop over remaining products to calculate total
        for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            total += products.get(key).getPrice() * value;
        }

        System.out.println("Total " + total);


    }

    private Map<String, Campaign> parsePromotions(String[] promos) {

        Map<String, Campaign> res = new HashMap<>();

        // ex: promo => multipriced:B:2:125
        for(String promo: promos) {
            String[] temp = promo.split(":");
            switch (temp[0]) {

                case "multipriced":
                    Campaign multipriced = new Multipriced(temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
                    res.put(temp[1], multipriced);
                    break;
                default:
                    System.out.println("No promotion found.");
                    break;
            }
        }

        return res;
    }

    private Map<String, Integer> parseCart(String[] cart) {

        Map<String, Integer> res = new HashMap<>();

        // map with skus and their quantity
        for (String item: cart) {
            res.put(item, res.getOrDefault(item, 0) + 1);
        }

        return res;
    }

}