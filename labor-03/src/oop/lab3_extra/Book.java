package oop.lab3_extra;

public class Book {
    private final String title;
    private final String author;
    private String isbn;
    private int numPages;
    private boolean checkedOut;

    public Book(String title, String author, String isbn, int numPages, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numPages = numPages;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumPages() {
        return numPages;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public String toString() {
        return this.title + " by " + this.author;
    }

}
