package com.twu.biblioteca.book;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_BOOK_RETURN;

public class AvailableBook extends Book {
    public AvailableBook(String name, String author, String year) {
        super(name, author, year);
    }

    @Override
    public void appendToBooks(BooksPresenter booksPresenter) {
        booksPresenter.addBook(name, author, year);
    }

    @Override
    public Book checkout() {
        return CheckedOutBook.create(name, author, year);
    }

    public static AvailableBook create(String name, String author, String year) {
        return new AvailableBook(name, author, year);
    }

    @Override
    public Book returnBook() {
        return new NullBook();
    }

    @Override
    public String getCheckoutMessage() {
        return null;
    }

    @Override
    public String getReturnMessage() {
        return SUCCESSFUL_BOOK_RETURN;
    }
}
