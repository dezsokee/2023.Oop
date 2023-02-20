package oop.labor02;

public class Main {
    public static void main(String[] args)
    {
        /*BankAccount account1 = new BankAccount("IBAN1");
            System.out.println("Account1 Number:" + account1.getAccountNumber());
            System.out.println("Account1 balance:" + account1.getBalance());
            System.out.println("Account1 details:" + account1.toString());*/

        BankAccount account1 = new BankAccount("OTP00001");
        System.out.println("Account1 details: " + account1.getAccountNumber() + " " + account1.getBalance());

        account1.deposit(1000);
        System.out.println("After the deposit, the details of account1 are: " + account1.getAccountNumber() + " " + account1.getBalance());

        boolean result = account1.withdraw(500);
        if (!result)
        {
            System.out.println("You do not have sufficient funds for this operation!");
        }
        else
        {
            System.out.println("After the withdraw, the details of account1 are: " + account1.getAccountNumber() + " " + account1.getBalance());
        }

        result = account1.withdraw(1000);
        if (!result)
        {
            System.out.println("You do not have sufficient funds for this operation!");
        }
        else
        {
            System.out.println("After the withdraw, the details of account1 are: " + account1.getAccountNumber() + " " + account1.getBalance());
        }

        BankAccount account2 = new BankAccount("OTP00002");
        System.out.println("Account2 details: " + account2.getAccountNumber() + " " + account2.getBalance());

        account2.deposit(2000);
        System.out.println("After the deposit, the details of account2 are: " + account2.getAccountNumber() + " " + account2.getBalance());
    }
}
