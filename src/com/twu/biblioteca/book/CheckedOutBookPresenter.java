package com.twu.biblioteca.book;

import com.twu.biblioteca.user.User;

public class CheckedOutBookPresenter {
    private String formattedBooks;
    private final int maximumNameLength = 20;
    private final int maximumAuthorLength = 20;

    public CheckedOutBookPresenter(String formattedBooks) {
        this.formattedBooks = formattedBooks;
    }

    public void addBook(String name, String author, String year, User user) {
        formattedBooks += String.format("%-" + maximumNameLength + "s", name)
                + " | " +
                String.format("%-" + maximumAuthorLength + "s", author)
                + " | " +
                year
                + " | " + user +
                "\n";
    }

    @Override
    public String toString() {
        return formattedBooks;
    }
}
