package com.thoughtworks.domain.eshop;

import java.util.Currency;

public class Price {
    private final double amount;
    private final Currency currency;

    public Price(double amount) {
        this.amount = amount;
        currency = Currency.getInstance("USD");
    }

    public double getAmount() {
        return amount;
    }
}
