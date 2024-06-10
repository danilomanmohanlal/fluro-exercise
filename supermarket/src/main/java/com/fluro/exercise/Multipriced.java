package com.fluro.exercise;

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

    public int calculateDiscount(int quantityBought) {

        int res = 0;
        while (quantityBought > 0) {

            quantityBought = quantityBought - this.quantity;
            if (quantityBought > 0)
                res += this.price;
        }

        return res;
    }
}
