package com.fluro.exercise;

import java.util.Map;

public class MealDeal extends Campaign {

    private String[] skus;
    private int price;

    public MealDeal(String[] skus, int price) {
        this.skus = skus;
        this.price = price;
    }

    public String[] getSkus() {
        return skus;
    }

    public void setSkus(String[] skus) {
        this.skus = skus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int calculateDiscount(Map<String, Integer> cart) {
        return 0;
    }
}
