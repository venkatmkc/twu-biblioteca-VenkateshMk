package com.twu.biblioteca;

import java.util.HashMap;

public class BookParser {
    private HashMap<String, Book> books;

    public BookParser(HashMap<String, Book> books) {
        this.books = books;
    }

    public Book parseUserInput(String title) {
        return books.get(title);
    }
}
