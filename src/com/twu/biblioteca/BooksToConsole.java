package com.twu.biblioteca;

public class BooksToConsole {
    private Books books;

    public BooksToConsole(Books books) {
        this.books = books;
    }

    public void displayBookList() {
        System.out.print(books);
    }
}
