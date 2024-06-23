package com.fluro.exercise;

import com.fluro.exercise.campaigns.BuyNGet1;
import com.fluro.exercise.campaigns.Campaign;
import com.fluro.exercise.campaigns.MealDeal;
import com.fluro.exercise.campaigns.Multipriced;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void test_parseCart() {

        String[] cart = new String[]{"A", "B", "C", "D", "E", "B", "B", "B", "B", "C", "C", "C", "C", "D"};

        Main m = new Main();
        Map<String, Integer> cartMap = m.parseCart(cart);

        assertNotNull(cartMap);
        assertEquals(cart.length, cartMap.values().stream().mapToInt(Integer::intValue).sum());
        assertEquals(1, cartMap.get("A"));
        assertEquals(5, cartMap.get("B"));
        assertEquals(5, cartMap.get("C"));
        assertEquals(2, cartMap.get("D"));
        assertEquals(1, cartMap.get("E"));

    }

    @Test
    public void test_parsePromotions() {

        String inputPromos = "multipriced:B:2:125,buynget1:C:3,mealdeal:D:E:300";
        String[] promos = inputPromos.trim().split(",");

        Main m = new Main();
        Map<String, Campaign> activeCampaigns = m.parsePromotions(promos);

        assertEquals(promos.length, activeCampaigns.size());
        assertInstanceOf(Multipriced.class, activeCampaigns.get("B"));
        assertInstanceOf(BuyNGet1.class, activeCampaigns.get("C"));
        assertInstanceOf(MealDeal.class, activeCampaigns.get("D"));
    }

    @Test
    public void test_getCampaigns() {


        Multipriced multipriced = new Multipriced("B", 2, 125);
        BuyNGet1 buyNGet1 = new BuyNGet1("C", 3);
        MealDeal mealDeal = new MealDeal(new String[]{"D", "E"}, 300);

        Main m = new Main();
        Map<String, Campaign> campaigns = m.getCampaigns();

        assertEquals(3, campaigns.size());
        assertEquals(campaigns.get("B"), multipriced);
        assertEquals(campaigns.get("C"), buyNGet1);
        assertEquals(campaigns.get("D"), mealDeal);
    }

    @Test
    public void test_getProducts() {

        Map<String, Product> productMap = new HashMap<>();
        Product p1 = new Product("A", 50);
        Product p2 = new Product("B", 75);
        Product p3 = new Product("C", 25);
        Product p4 = new Product("D", 150);
        Product p5 = new Product("E", 200);
        productMap.put("A", p1);
        productMap.put("B", p2);
        productMap.put("C", p3);
        productMap.put("D", p4);
        productMap.put("E", p5);

        Main m = new Main();
        Map<String, Product> products = m.getProducts();

        assertEquals(productMap.size(), products.size());
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            assertEquals(entry.getValue().getPrice(), products.get(entry.getKey()).getPrice());
        }
    }

    @Test
    public void test_part1() {

        String expected = "Total: 9 pounds and 25 pence";
        Main m = new Main();
        String result = m.part1();

        assertEquals(expected, result);
    }

}