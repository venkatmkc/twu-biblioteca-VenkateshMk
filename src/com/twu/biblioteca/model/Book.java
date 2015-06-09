package com.twu.biblioteca.model;

public class Book {

    private String name, author, year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String formattedBookDetails(int maximumNameLength, int maximumAuthorLength) {
        return String.format("%-" + maximumNameLength + "s", name)
                + " | " +
                String.format("%-" + maximumAuthorLength + "s", author)
                + " | " +
                year;
    }

    public int nameLength() {
        return name.length();
    }

    public int authorLength() {
        return author.length();
    }
}
