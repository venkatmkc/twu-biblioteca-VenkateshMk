package com.twu.biblioteca;

public class CheckedOutBook extends Book{
    public CheckedOutBook(String name, String author, String year) {
        super(name, author, year);
    }

    public static CheckedOutBook create(String name, String author, String year) {
        return new CheckedOutBook(name, author, year);
    }
}
