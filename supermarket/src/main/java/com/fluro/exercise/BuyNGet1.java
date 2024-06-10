package com.fluro.exercise;

import java.util.Map;

public class BuyNGet1 extends Campaign {

    private String sku;
    private int quantity;

    public BuyNGet1(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public int calculateDiscount(Map<String, Integer> cart) {

        int res = 0;

        int count = cart.get(this.sku);

        // we only remove if the quantity of sku bought is greater or equal from the defined value
        // otherwise we pay normal price
        if (count >= this.quantity + 1) {
            int toRemove = count / this.quantity + 1;

            cart.put(this.sku, count - toRemove);
        }

        return res;
    }
}
