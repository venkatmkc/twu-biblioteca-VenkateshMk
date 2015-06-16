package com.twu.biblioteca;

public class BooksPresenter {
    private String formattedBooks;
    private final int maximumNameLength = 30;
    private final int maximumAuthorLength = 30;

    public BooksPresenter(String formattedBooks) {
        this.formattedBooks = formattedBooks;
    }

    @Override
    public String toString() {
        return formattedBooks;
    }

    public void addBook(String name, String author, String year) {
        formattedBooks += String.format("%-" + maximumNameLength + "s", name)
                + " | " +
                String.format("%-" + maximumAuthorLength + "s", author)
                + " | " +
                year
                + "\n";
    }
}
