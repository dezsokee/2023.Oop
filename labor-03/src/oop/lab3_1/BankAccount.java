package oop.lab3_1;

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

    public void deposit (double deposit_balance)
    {

        this.balance += deposit_balance;
    }

    public boolean withdraw (double withdraw_balance)
    {
        if (this.balance < withdraw_balance)
        {
            return false;
        }
        else
        {
            this.balance -= withdraw_balance;
            return true;
        }
    }
}
