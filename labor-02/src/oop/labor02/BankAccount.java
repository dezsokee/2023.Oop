package oop.labor02;

public class BankAccount {
    private String accountNumber; //szamlaszam
    private double balance; //osszeg

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return "Bankszamla { szamlaszam " + accountNumber + ", egyenleg: " + balance + "}";
    }
}
