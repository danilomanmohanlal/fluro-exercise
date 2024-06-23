package com.fluro.exercise.campaigns;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MultipricedTest {


    @Test
    public void test_CalculateMultipricedExactQuantity() {

        Map<String, Integer> cart = new HashMap<>();
        cart.put("A", 1);
        cart.put("B", 2);

        String sku = "B";
        int skuQuantity = 2;
        int multipriceDeal = 125;

        Multipriced multipriced = new Multipriced(sku, skuQuantity, multipriceDeal);
        int discountedPrice = multipriced.calculateDiscount(cart);

        assertEquals(discountedPrice, multipriceDeal);
        assertFalse(cart.containsKey("B"));
    }

    @Test
    public void test_CalculateMultipricedNotEnoughQuantity() {

        Map<String, Integer> cart = new HashMap<>();
        cart.put("A", 1);
        cart.put("B", 1);

        String sku = "B";
        int skuQuantity = 2;
        int multipriceDeal = 125;

        Multipriced multipriced = new Multipriced(sku, skuQuantity, multipriceDeal);
        int discountedPrice = multipriced.calculateDiscount(cart);

        assertNotEquals(discountedPrice, multipriceDeal);
        assertTrue(cart.containsKey("B"));
    }

    @Test
    public void test_CalculateMultipricedMultipleQuantityAndMore() {

        Map<String, Integer> cart = new HashMap<>();
        int productQuantityInCart = 5;
        cart.put("A", 1);
        cart.put("B", productQuantityInCart);

        String sku = "B";
        int skuQuantity = 2;
        int multipriceDeal = 125;
        int timesDeal = productQuantityInCart / skuQuantity;

        Multipriced multipriced = new Multipriced(sku, skuQuantity, multipriceDeal);
        int discountedPrice = multipriced.calculateDiscount(cart);

        assertEquals(discountedPrice, timesDeal * multipriceDeal);
        assertTrue(cart.containsKey("B"));
    }

}