package lab4_2;

import java.util.ArrayList;

public class Customer {
    private final String firstName;
    private String lastName;
    // an array for the accounts
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount (BankAccount account)
    {
        this.accounts.add(account);
    }

    public BankAccount getAccount (String accountNumber)
    {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
            {
                return account;
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
        int ok = -1;
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
            {
                accounts.remove(account);
                ok = 0;
            }
        }
        if (ok == -1)
        {
            System.out.println("Can't find an account with the specific account number!");
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();

        result.append(firstName + ' ' + lastName + " accounts:\n");

        for(BankAccount account : accounts){
            result.append( "\t" + account +"\n");
        }
        return result.toString();
    }

    public int getNumAccounts ()
    {
        return accounts.size();
    }
}

