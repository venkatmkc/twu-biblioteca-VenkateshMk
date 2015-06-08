package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption implements MainMenuAction {
    @Override
    public void perform() {
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");;
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");;
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);
        Books books = new Books(bookList);
        BooksToConsole booksToConsole = new BooksToConsole(books);
        booksToConsole.displayBookList();
    }
}
