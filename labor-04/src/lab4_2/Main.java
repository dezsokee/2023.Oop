package lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        int i = -1;

        try (Scanner scanner = new Scanner(new File("lab4_2_input.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                String type = items[0].trim();
                if (type.equals("Customer")) {
                    String firstName = items[1].trim();
                    String lastName = items[2].trim();
                    Customer actual_customer = new Customer(firstName, lastName);
                    customers.add(actual_customer);
                    i++;

                }
                else {
                    String accountNumber = items[1].trim();
                    int balance = Integer.parseInt(items[2].trim());
                    BankAccount actual_account = new BankAccount(accountNumber);
                    actual_account.deposit(balance);
                    customers.get(i).addAccount(actual_account);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(customers);

    }
}
