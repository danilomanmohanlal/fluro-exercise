package com.fluro.exercise;

import java.util.Map;

/**
 * This class represents a promotion campaign for multipriced products,
 * If you buy the defined quantity you have a new discounted price
 */
public class Multipriced extends Campaign {

    private String sku;
    private int quantity;
    private int price;

    public Multipriced(String sku, int quantity, int price) {
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int calculateDiscount(Map<String, Integer> cart) {

        int res = 0;
        int count = cart.get(this.sku);

        while (count >= this.quantity) {

            res += this.price;
            count = count - this.quantity;

            //check if we can remove it from the cart and apply the new price
            if (count == 0) {
                cart.remove(this.sku);
            }
            else {
                //update with new count
                cart.put(this.sku, count);
            }
        }

        return res;
    }
}
