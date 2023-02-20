package oop.labor02;

public class Main {
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount("IBAN1");
        System.out.println("Account1 Number:" + account1.getAccountNumber());
        System.out.println("Account1 balance:" + account1.getBalance());
        System.out.println("Account1 details:" + account1.toString());
    }
}
