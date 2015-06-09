package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption implements MainMenuAction {
    Books books;

    public ListBooksOption(Books books) {
        this.books = books;
    }

    @Override
    public String obtainOptionResult() {
        return books.toString();
    }
}
