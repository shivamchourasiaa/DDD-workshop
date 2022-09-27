package com.thoughtworks.eshop.domain;

import com.thoughtworks.eshop.domain.constants.ProductName;

import java.util.ArrayList;

public class Cart {
    private final ArrayList<Item> items = new ArrayList<>();
    private boolean checkoutStatus = false;

    public void add(Item item) {
        if (items.contains(item)) {
            items.get(items.indexOf(item)).addQuantity();
        } else {
            items.add(item);
        }
    }


    public int getQuantityOf(ProductName productName) {
        for (Item item : items) {
            if (item.getName() == productName)
                return item.getQuantity();
        }
        return 0;
    }


    public boolean getItem(Item item) {
        return items.contains(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public Order checkout() {
        this.checkoutStatus = true;
        Order order = new Order();
        for (Item item : items) {
            order.add(item.getProduct());
        }
        return order;
    }

    public boolean isCheckedOut() {
        return checkoutStatus;
    }
}
