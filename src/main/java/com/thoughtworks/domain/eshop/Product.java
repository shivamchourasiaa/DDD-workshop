package com.thoughtworks.domain.eshop;

import com.thoughtworks.domain.eshop.constants.ProductName;
import com.thoughtworks.domain.eshop.service.CompetitorData;

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
}
