package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> bookList;

    public Books(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        String formattedBookList = new String();
        for (Book book : bookList) {
            formattedBookList += book + "\n";
        }
        return formattedBookList;
    }
}
