package com.fluro.exercise.campaigns;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MealDealTest {

    @Test
    public void test_CalculateMealDealAppliedExact() {

        Map<String, Integer> cart = new HashMap<>();
        cart.put("A", 1);
        cart.put("B", 2);
        cart.put("D", 1);
        cart.put("E", 1);

        String[] skus = new String[]{"D", "E"};
        int mealDealPrice = 300;

        MealDeal mealDeal = new MealDeal(skus, mealDealPrice);
        int discountPrice = mealDeal.calculateDiscount(cart);

        assertEquals(discountPrice, mealDealPrice);
        assertEquals(0, cart.get("D"));
        assertEquals(0, cart.get("E"));
    }

    @Test
    public void test_CalculateMealDealNotApplied() {

        Map<String, Integer> cart = new HashMap<>();
        cart.put("A", 1);
        cart.put("B", 2);
        cart.put("D", 0);
        cart.put("E", 1);

        String[] skus = new String[]{"D", "E"};
        int mealDealPrice = 300;

        MealDeal mealDeal = new MealDeal(skus, mealDealPrice);
        int discountPrice = mealDeal.calculateDiscount(cart);

        assertNotEquals(discountPrice, mealDealPrice);
        assertEquals(1, cart.get("E"));
    }

    @Test
    public void test_CalculateMealDealApplied_MultipleTimes() {

        Map<String, Integer> cart = new HashMap<>();
        int productDQty = 3;
        int productEQty = 5;

        cart.put("A", 1);
        cart.put("B", 2);
        cart.put("D", productDQty);
        cart.put("E", productEQty);

        String[] skus = new String[]{"D", "E"};
        int mealDealPrice = 300;
        int timesDeal = Math.min(productDQty, productEQty);

        MealDeal mealDeal = new MealDeal(skus, mealDealPrice);
        int discountPrice = mealDeal.calculateDiscount(cart);

        assertEquals(discountPrice, timesDeal * mealDealPrice);
        assertEquals(0, cart.get("D"));
        assertEquals(productEQty - productDQty, cart.get("E"));
    }

}