package com.thoughtworks.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerId;
    private final String name;
    private Address address;

    private List<Account> bankAccounts = new ArrayList<>();

    public Customer(String name, Address address) {
        this.customerId = 0;
        this.name = name;
        this.address = address;
    }

    public void addBankAccount(Account account) {
        bankAccounts.add(account);
    }

    public void updateAddress(Address address) {
        this.address = address;

        for (Account account : bankAccounts) {
            account.updateAddress(address);
        }

    }
}
