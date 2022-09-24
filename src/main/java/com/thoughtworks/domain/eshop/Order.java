package com.thoughtworks.domain.eshop;

import java.util.ArrayList;

public class Order {
    ArrayList<Product> orderList =  new ArrayList<>();
    public void add(Product product) {
        orderList.add(product);
    }
}
