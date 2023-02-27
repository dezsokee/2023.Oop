package oop.lab3_2;

import oop.lab3_1.BankAccount;

public class Customer {
    private final String firstName;
    private String lastName;
    public static final int MAX_ACCOUNTS = 10;
    // number of accounts
    private int numAccounts;
    // an array for the accounts
    private BankAccount accounts[] = new BankAccount[ MAX_ACCOUNTS ];

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAccount (BankAccount account)
    {
        if (numAccounts == MAX_ACCOUNTS)
        {
            System.out.println("Can't open a new bank account because you're reached the max limit!");
            return;
        }
        accounts[numAccounts] = account;
        numAccounts ++;
    }

    public BankAccount getAccount (String accountNumber)
    {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber))
            {
                return accounts[i];
            }
        }
        return null;
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

    public void closeAccount (String accountNumber)
    {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber))
            {
                accounts[i] = accounts[numAccounts - 1];
                accounts[numAccounts - 1] = null;
                numAccounts --;
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");
        for(int i=0; i<numAccounts; ++i){
            result.append( "\t" + accounts[i] +"\n");
        }
        return result.toString();
    }

    public int getNumAccounts ()
    {
        return this.numAccounts;
    }
}
