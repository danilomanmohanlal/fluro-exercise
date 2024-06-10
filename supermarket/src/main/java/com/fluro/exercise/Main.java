package com.fluro.exercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Main m = new Main();

        int total = 0;
        String[] cart = new String[]{"A","B","C","D","E","B", "B", "B", "B"};

        Map<String, Integer> cartMap = new HashMap<>();
        Map<String, Campaign> activeCampaigns = m.getCampaigns();
        Map<String, Product> products = m.getProducts();


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

        res.put("B", multipriced);

        return res;
    }

}