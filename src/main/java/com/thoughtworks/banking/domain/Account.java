package com.thoughtworks.banking.domain;

public class Account {
    private String name;
    private Address address;

    public Account(String name, Address address) {

        this.name = name;
        this.address = address;
    }

    protected void updateAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}