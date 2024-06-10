package com.fluro.exercise.campaigns;

import java.util.Map;

public abstract class Campaign {


    public abstract int calculateDiscount(Map<String, Integer> cart);
}
