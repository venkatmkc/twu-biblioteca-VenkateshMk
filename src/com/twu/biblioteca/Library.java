package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedoutBooks;

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedoutBooks) {
        this.availableBooks = availableBooks;
        this.checkedoutBooks = checkedoutBooks;
    }

    @Override
    public String toString() {
        String formattedBookList = new String();
        BooksPresenter booksPresenter = new BooksPresenter(formattedBookList);
        for (Book book : availableBooks) {
                book.appendToBooks(booksPresenter);
        }
        return booksPresenter.toString();
    }

    public synchronized boolean checkout(Book book) {
        if(availableBooks.contains(book)) {
            availableBooks.remove(book);
            checkedoutBooks.add(book);
            return true;
        }
        return false;
    }

    public synchronized boolean returnBook(Book book) {
        if(checkedoutBooks.contains(book)) {
            checkedoutBooks.remove(book);
            availableBooks.add(book);
            return true;
        }
        return  false;
    }

}
