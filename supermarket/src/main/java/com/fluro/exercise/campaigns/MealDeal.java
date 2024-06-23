package com.fluro.exercise.campaigns;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

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

    /**
     * This method is responsible for calculating the discount price for a set of items that are in the cart,
     * after processing the set of items we remove them from the cart. We do this until there are no more sets of items to
     * remove
     * @param cart
     * @return the new discounted price
     */
    @Override
    public int calculateDiscount(Map<String, Integer> cart) {

        int res = 0;

        // all items defined in the campaign must be in the cart
        while(containsAll(cart)) {

            res += this.price;
            //remove one item from each sku and continue processing if there are more items
            for (String s : this.skus) {
                cart.put(s, cart.get(s) - 1);
            }
        }


        return res;
    }

    private boolean containsAll(Map<String, Integer> cart) {

        for(String sku : this.skus) {
            if(cart.get(sku) < 1)
                return false;
        }

        return true;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealDeal that = (MealDeal) o;
        return price == that.price &&
                Arrays.equals(skus, that.skus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(skus), price);
    }
}
