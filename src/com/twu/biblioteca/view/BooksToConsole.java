package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Books;

public class BooksToConsole {
    private Books books;

    public BooksToConsole(Books books) {
        this.books = books;
    }

    public void displayBookList() {
        System.out.print(books);
    }
}
