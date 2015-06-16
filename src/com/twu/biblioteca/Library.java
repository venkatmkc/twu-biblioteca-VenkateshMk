package com.twu.biblioteca;

import java.util.HashMap;

public class Library {
    private HashMap<Book, Boolean> bookList;

    public Library(HashMap<Book, Boolean> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        String formattedBookList = new String();
        BooksPresenter booksPresenter = new BooksPresenter(formattedBookList);
        for (Book book : bookList.keySet()) {
            if(bookList.get(book)) {
                book.appendToBooks(booksPresenter);
            }
        }
        return booksPresenter.toString();
    }

    public boolean checkout(Book book) {
        if(bookList.get(book)) {
            bookList.put(book, false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if(!bookList.get(book)) {
            bookList.put(book, true);
            return true;
        }
        return  false;
    }

}
