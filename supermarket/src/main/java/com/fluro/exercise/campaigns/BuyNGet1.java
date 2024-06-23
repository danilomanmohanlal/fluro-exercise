package com.fluro.exercise.campaigns;

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


    /**
     * This method is responsible for checking in the cart if we have enough quantity to apply the promotion that is
     * one item free. For each multiple of enough quantity we apply the discount
     * @param cart
     * @return 0, in this promotion we only remove the free item from the cart
     */
    @Override
    public int calculateDiscount(Map<String, Integer> cart) {

        int res = 0;

        int toSubtract = 0;
        int count = cart.get(this.sku);

        int numberOfSkuPackFound = 0;

        while (count > 0) {
            numberOfSkuPackFound++;

            if (numberOfSkuPackFound == this.quantity + 1) {
                numberOfSkuPackFound = 0;
                toSubtract++;
            }

            count--;
        }

        cart.put(this.sku, cart.get(this.sku) - toSubtract);

        return res;
    }
}
