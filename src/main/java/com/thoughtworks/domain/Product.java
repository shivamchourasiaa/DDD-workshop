package com.thoughtworks.domain;

import com.thoughtworks.domain.constants.ProductName;

public class Product {
    private final ProductName productName;
    private final Price price;


    public Product(ProductName productName, Price price) {

        this.productName = productName;
        this.price = price;
    }

    public Product(ProductName productName) {

        this.productName = productName;
        this.price = new Price(0.0);

    }


    public ProductName getProductName() {
        return productName;
    }
}
