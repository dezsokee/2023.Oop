package oop.lab3_extra;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Library {
    private final String name;
    private String address;
    private static final int MAX_BOOKS_NUMBER = 10;

    private int bookCount;
    private Book books[] = new Book[MAX_BOOKS_NUMBER];

    public Library(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book[] getBooks() {
        return this.books;
    }

    public void addBook (Book book) {
        if (bookCount == MAX_BOOKS_NUMBER) {
            System.out.println("You can't add more books in the library");
            return;
        }
        else {
            books[bookCount] = book;
            bookCount++;
        }
    }

    public void removeBook (Book book)
    {
        int ok = -1;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] == book) {
                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount --;
                ok = 0;
            }
        }

        if (ok == -1) {
            System.out.println("Can't find the specific book in the library!");
        }
    }

    public void checkoutBook(Book book) {

        int ok = -1;

        for (int i = 0; i < bookCount; i++) {
            if (books[i] == book) {
                books[i].setCheckedOut(true);
            }
        }

        if (ok == -1) {
            System.out.println("Can't find the specific book in the libaray!");
        }
    }

    public void returnBook(Book book) {

        int ok = -1;

        for (int i = 0; i < bookCount; i++) {
            if (books[i] == book) {
                books[i].setCheckedOut(false);
                ok = 0;
            }
        }

        if (ok == -1) {
            System.out.println("Can't find the specific book in the library!");
        }
    }

    public Book findBook(String title) {

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }

        return null;
    }

    public int countBook () {
        return this.bookCount;
    }

}
