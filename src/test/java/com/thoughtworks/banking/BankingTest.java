package com.thoughtworks.banking;

import com.thoughtworks.banking.domain.Account;
import com.thoughtworks.banking.domain.Address;
import com.thoughtworks.banking.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankingTest {
    @Test
    void shouldUpdateBankAccountAddressWhenCustomerAddressIsUpdates() {
        Customer customer = new Customer("Rahul", new Address("Mumbai"));
        Account account = new Account("Rahul", new Address("Mumbai"));
        customer.addBankAccount(account);

        Address newAddress = new Address("Delhi");
        customer.updateAddress(newAddress);

        assertEquals(account.getAddress(), newAddress);
    }
}
