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
        String[] cart = {"A,B,C,D,E"};
        Map<String, Campaign> activeCampaigns = m.getCampaigns();
        Map<String, Product> products = m.getProducts();

        Map<String, Integer> productsWithCampaign = new HashMap<>();

        // process cart and check for campaigns
        for(String item: cart) {

            //has campaign ?
            Campaign c = activeCampaigns.get(item);
            if (c != null) {
                int aux = productsWithCampaign.get(item) == null ? 0 : productsWithCampaign.get(item);
                productsWithCampaign.put(item, aux + 1);
            }
            else {
                total += products.get(item).getPrice();
            }
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