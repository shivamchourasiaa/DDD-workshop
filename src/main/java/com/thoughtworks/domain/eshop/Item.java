package com.thoughtworks.domain.eshop;

import com.thoughtworks.domain.eshop.constants.ProductName;

public class Item {
    private final Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Item(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public ProductName getName() {
        return product.getProductName();
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity() {
        this.quantity += 1;
    }

    public Product getProduct() {
        return product;
    }
}
