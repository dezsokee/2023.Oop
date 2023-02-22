package oop.labor02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

        Rectangle[] rectangles = new Rectangle[10];
        Random rand = new Random();

        double length, width;
        double totalArea = 0;

        for (int i = 0; i < 10; i++) {
            length = 1 + rand.nextInt(10);
            width = 1 + rand.nextInt(10);
            rectangles[i] = new Rectangle(length, width);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + ". rectangle details: " + rectangles[i].getLength() + " x " + rectangles[i].getWidth());
            System.out.println("The area is: " + rectangles[i].area() + " and the perimeter is: " + rectangles[i].perimeter());
            totalArea += rectangles[i].area();
        }

        System.out.println("The total area is: " + totalArea);

        DateUtil dateUtil = new DateUtil();

        int date = 2000;
        System.out.println(dateUtil.loopYear(date));

        System.out.println(DateUtil.isValidDate(2000,2, 29) == true);
        System.out.println(DateUtil.isValidDate(2000,2, 30) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 29) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 28) == true);
        System.out.println(DateUtil.isValidDate(-1900,2, 28) == false);
        System.out.println(DateUtil.isValidDate(0,2, 28) == false);
        System.out.println(DateUtil.isValidDate(2021,2, 29) == false);
        System.out.println(DateUtil.isValidDate(2020,2, 29) == true);
        System.out.println(DateUtil.isValidDate(2020,1, 32) == false);
        System.out.println(DateUtil.isValidDate(2020,1, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,0, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,4, 31) == false);
        System.out.println(DateUtil.isValidDate(2020,1, 31) == true);

        randomDates();
        /*File file = new File("D:\\Egyetem\\2023.Oop\\labor-02\\src\\oop\\labor02\\data.txt");
        Scanner sc = null;
        //sc.useDelimiter(",\n");

        List<Movie> movies = new ArrayList<Movie>();

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
            String title = sc.next();
            String director = sc.next();
            int releaseYear = sc.nextInt();
            double rating = Double.valueOf(sc.next());
            Genre genre = Genre.valueOf(sc.next());

            Movie current_movie = new Movie(title,director,releaseYear,rating,genre);

            movies.add(current_movie);

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }*/
}
    public static void randomDates ()
    {
        int bad_counter = 0;
        for (int i = 0; i < 1000; i++)
        {
            Random rand = new Random();
            int generated_year = 1 + (rand.nextInt(2030 - 1000) + 1000);
            int generated_month = 1 + rand.nextInt(12);
            int generated_day = 1 + rand.nextInt(31);

            DateUtil dateUtil = new DateUtil();
            if (dateUtil.isValidDate(generated_year, generated_month, generated_day))
            {
                System.out.println(generated_year + " - " + generated_month + " - " + generated_day);
            }
            else
            {
                bad_counter ++;
            }
        }

        System.out.println("The system generated " + bad_counter + " invalid dates");

    }
}
