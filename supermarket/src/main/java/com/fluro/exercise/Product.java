package com.fluro.exercise;

/**
 * A product is represented by its sku and price in pence
 */
public class Product {

    private String sku;
    private int price;

    public Product(String sku, int price) {
        this.sku = sku;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
