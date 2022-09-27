package com.thoughtworks.eshop.domain;

import com.thoughtworks.eshop.domain.constants.ProductName;
import com.thoughtworks.eshop.domain.service.CompetitorData;

public class Product {
    private final ProductName productName;
    private final Price price;
    private final Weight weight;


    public Product(ProductName productName, Price price) {

        this.productName = productName;
        this.price = price;
        this.weight = new Weight(0.0);
    }

    public Product(ProductName productName) {

        this.productName = productName;
        this.price = new Price(0.0);
        this.weight = new Weight(0.0);

    }

    public Product(ProductName productName, Price price, Weight weight) {
        this.productName = productName;
        this.price = price;
        this.weight = weight;
    }

    public static Product getProductWithDiscount(ProductName productName) {
        float discountPrice = CompetitorData.getDiscountPrice(productName);
        return new Product(productName, new Price(discountPrice));
    }


    public ProductName getProductName() {
        return productName;
    }

    public Price getPrice() {
        return price;
    }

    public Weight getWeight() {
        return weight;
    }
}
