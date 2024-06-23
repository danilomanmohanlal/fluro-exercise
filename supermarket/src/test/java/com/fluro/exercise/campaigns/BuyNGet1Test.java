package com.fluro.exercise.campaigns;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BuyNGet1Test {

    @Test
    public void test_CalculateBuyNGet1_NotApplied() {

        Map<String, Integer> cart = new HashMap<>();
        cart.put("A", 1);
        cart.put("B", 2);
        cart.put("C", 3);
        cart.put("D", 1);
        cart.put("E", 1);

        BuyNGet1 buyNGet1 = new BuyNGet1("C", 3);

        //this campaign always returns 0, we need to check the cart
        buyNGet1.calculateDiscount(cart);

        assertTrue(cart.containsKey("C"));
        assertEquals(3, cart.get("C"));
        
    }

}