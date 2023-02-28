package oop.lab3_extra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library("Dezso's library", "Kezdivasarhely");

        Book book_1 = new Book("Harry Potter es a bolcsek kove", "J. K. Rowling", "123YT9", 269, true);
        Book book_2 = new Book("Harry Potter es a titkok kamraja", "J. K. Rowling", "BFI26A", 436, false);
        Book book_3 = new Book("Harry Potter es a fonik rendje", "J. K. Rowling", "QAS56AD", 316, false);

        myLibrary.addBook(book_1);
        myLibrary.addBook(book_2);
        myLibrary.addBook(book_3);

        System.out.println("The name of the library is: " + myLibrary.getName() + " and its address is: " + myLibrary.getAddress());

        System.out.println("The list of the books in the library:");

        for (int i = 0; i < myLibrary.countBook(); i++) {
            System.out.println(myLibrary.getBooks()[i]);
        }

        Scanner console = new Scanner(System.in);

        System.out.println("Enter a book title which you want to search!");
        String searchedTitle = console.nextLine();

        System.out.println("The searched book's details:");
        System.out.println(myLibrary.findBook(searchedTitle));

        if (myLibrary.findBook(searchedTitle) != null) {
            myLibrary.findBook(searchedTitle).setCheckedOut(true);
            System.out.println("The book's checkout status is: " + myLibrary.findBook(searchedTitle).isCheckedOut());
            myLibrary.returnBook(myLibrary.findBook(searchedTitle));
        }

        myLibrary.removeBook(myLibrary.findBook(searchedTitle));

        System.out.println("The number of the books after the remove method is: " + myLibrary.countBook());

        for (int i = 0; i < myLibrary.countBook(); i++) {
            System.out.println(myLibrary.getBooks()[i]);
        }

    }
}
