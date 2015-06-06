package com.twu.biblioteca;

public class Book {

    private String name, author, year;
    public final int maximumNameLength = 20;
    public final int maximumAuthorLength = 20;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%-" + maximumNameLength + "s", name) + "|" + String.format("%-" + maximumAuthorLength + "s", author) + "|" + year;
    }
}
