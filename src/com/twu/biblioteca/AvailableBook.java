package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.SUCCESSFUL_BOOK_RETURN;

public class AvailableBook extends Book {
    public AvailableBook(String name, String author, String year) {
        super(name, author, year);
    }

    public CheckedOutBook checkout() {
        return CheckedOutBook.create(name, author, year);
    }


    public static AvailableBook create(String name, String author, String year) {
        return new AvailableBook(name, author, year);
    }

    public NullBook returnBook() {
        return new NullBook();
    }

    public String getReturnMessage() {
        return SUCCESSFUL_BOOK_RETURN;
    }
}
