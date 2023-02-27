package oop.lab3_2;

import oop.lab3_1.BankAccount;

public class Customer {
    private final String firstName;
    private String lastName;
    private BankAccount account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAccount (BankAccount account)
    {
        this.account = account;
    }

    public BankAccount getAccount ()
    {
        return this.account;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void closeAccount ()
    {
        this.account = null;
    }

    public String toString ()
    {
        return "The customer name: " + lastName + " " + firstName + " and his account is: " + account;
    }
}
