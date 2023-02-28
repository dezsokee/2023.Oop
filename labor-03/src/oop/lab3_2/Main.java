package oop.lab3_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Dezso", "Szabolcs");

        Customer customer2 = new Customer("Cseh", "Barna");

        for (int i = 0; i < 5; i++) {
            customer1.addAccount(new BankAccount("OTP000" + i));
        }

        int start = customer1.getNumAccounts();
        System.out.println(start);
        int end = start + 9;

        for (int i = start; i < end; i++) {
            customer2.addAccount(new BankAccount("OTP000" + i));
        }

        System.out.println(customer1);
        System.out.println(customer2);

        Random random = new Random();

        int i = 0;

        while (i != customer1.getNumAccounts())
        {
            int rand_int = random.nextInt(1000);
            customer1.getAccount("OTP000" + i).deposit(rand_int);
            i++;
        }

        i = customer1.getNumAccounts();

        while (i != (customer2.getNumAccounts() + customer1.getNumAccounts()))
        {
            int rand_int = random.nextInt(1000);
            customer2.getAccount("OTP000" + i).deposit(rand_int);
            i++;
        }

        System.out.println(customer1);
        System.out.println(customer2);

        i = 0;
        customer1.closeAccount("OTP000" + i);
        customer2.closeAccount("OTP000" + customer2.getNumAccounts());

        System.out.println(customer1);
        System.out.println(customer2);
    }
}
