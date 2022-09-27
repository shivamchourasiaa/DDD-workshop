package com.thoughtworks.eshop.domain;

import java.util.ArrayList;

public class Order {
    ArrayList<Product> orderList =  new ArrayList<>();
    public void add(Product product) {
        orderList.add(product);
    }

    public double getTotalCost() {
        double totalCost = 0.0;

        for(Product product: orderList){
            totalCost+=product.getPrice().getAmount()+(product.getWeight().getValue()*0.1);
        }

        return totalCost;
    }
}
