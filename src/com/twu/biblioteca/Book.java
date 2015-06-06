package com.twu.biblioteca;

public class Book {

    private String name, author, year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + "," + author + "," + year;
    }
}
