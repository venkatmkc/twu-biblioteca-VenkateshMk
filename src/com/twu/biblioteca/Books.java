package com.twu.biblioteca;

import java.util.HashMap;

public class Books {
    private HashMap<Book, Boolean> bookList;

    public Books(HashMap<Book, Boolean> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        String formattedBookList = new String();
        int maximumNameLength = 0, maximumAuthorLength = 0;
        for (Book book : bookList.keySet()) {
            if(bookList.get(book)) {
                if (book.nameLength() > maximumNameLength)
                    maximumNameLength = book.nameLength();
                if (book.authorLength() > maximumAuthorLength)
                    maximumAuthorLength = book.authorLength();
            }
        }

        for (Book book : bookList.keySet()) {
            if(bookList.get(book)) {
                formattedBookList += book.formattedBookDetails(maximumNameLength, maximumAuthorLength) + "\n";
            }
        }
        return formattedBookList;
    }

    public boolean checkout(Book book) {
        if(bookList.get(book)) {
            bookList.put(book, false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        bookList.put(book, true);
        return true;
    }
}
