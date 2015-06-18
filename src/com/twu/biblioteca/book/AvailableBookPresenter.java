package com.twu.biblioteca.book;

import com.twu.biblioteca.user.User;

public class AvailableBookPresenter implements BookPresenter{
    private String formattedBooks;
    private final int maximumNameLength = 20;
    private final int maximumAuthorLength = 20;

    public AvailableBookPresenter(String formattedBooks) {
        this.formattedBooks = formattedBooks;
    }

    @Override
    public String toString() {
        return formattedBooks;
    }

    @Override
    public void addBook(String name, String author, String year, User user) {
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
