package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> bookList;

    public Books(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        String formattedBookList = new String();
        int maximumNameLength = 0, maximumAuthorLength = 0;
        for (Book book : bookList) {
            if (book.nameLength() > maximumNameLength)
                maximumNameLength = book.nameLength();
            if (book.authorLength() > maximumAuthorLength)
                maximumAuthorLength = book.authorLength();
        }

        for (Book book : bookList) {
            formattedBookList += book.formattedBookDetails(maximumNameLength, maximumAuthorLength) + "\n";
        }
        return formattedBookList;
    }
}
