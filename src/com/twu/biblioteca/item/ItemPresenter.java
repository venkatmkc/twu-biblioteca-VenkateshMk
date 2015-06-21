package com.twu.biblioteca.item;

import com.twu.biblioteca.user.User;

public class ItemPresenter {
    private String formattedItems;
    private final int maximumNameLength = 20;
    private final int maximumAuthorLength = 20;

    public ItemPresenter(String formattedItems) {
        this.formattedItems = formattedItems;
    }

    @Override
    public String toString() {
        return formattedItems;
    }


    public void flush() {
        formattedItems = "";
    }

    public void addAvailableBook(String name, String author, String year) {
        formattedItems += String.format("%-" + maximumNameLength + "s", name)
                + " | " +
                String.format("%-" + maximumAuthorLength + "s", author)
                + " | " +
                year
                + "\n";
    }

    public void addCheckedOutBook(String name, String author, String year, User user) {
        formattedItems += String.format("%-" + maximumNameLength + "s", name)
                + " | " +
                String.format("%-" + maximumAuthorLength + "s", author)
                + " | " +
                year
                + " | " + user +
                "\n";
    }

    public void addAvailableMovie(String name, String year, String director, String rating) {
        formattedItems += name + ", ";
        formattedItems += year + ", ";
        formattedItems += director + ", ";
        formattedItems += rating + "\n";
    }

    public void addCheckedOutMovie(String name, String year, String director, String rating, User user) {
        formattedItems += name + ", ";
        formattedItems += year + ", ";
        formattedItems += director + ", ";
        formattedItems += rating;
        formattedItems += " | " + user + "\n";
    }
}
