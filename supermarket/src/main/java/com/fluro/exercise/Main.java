package com.fluro.exercise;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Main m = new Main();



    }


    private ArrayList<Product> getProducts() {

        ArrayList<Product> res = new ArrayList<>();
        Product p1 = new Product("A", 50);
        Product p2 = new Product("B", 75);
        Product p3 = new Product("C", 25);
        Product p4 = new Product("D", 150);
        Product p5 = new Product("E", 200);

        res.add(p1);
        res.add(p2);
        res.add(p3);
        res.add(p4);
        res.add(p5);

        return res;
    }

}