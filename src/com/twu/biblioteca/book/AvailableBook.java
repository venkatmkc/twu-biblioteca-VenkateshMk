package com.twu.biblioteca.book;

import com.twu.biblioteca.user.User;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_BOOK_RETURN;

public class AvailableBook extends Book {
    public AvailableBook(String name, String author, String year) {
        super(name, author, year);
    }

    @Override
    public void appendToBooks(AvailableBookPresenter availableBookPresenter) {
        availableBookPresenter.addBook(name, author, year);
    }

    @Override
    public void appendToBooks(CheckedOutBookPresenter checkedOutBookPresenter) {}

    @Override
    public Book checkout(User user) {
        return CheckedOutBook.create(name, author, year, user);
    }

    public static AvailableBook create(String name, String author, String year) {
        return new AvailableBook(name, author, year);
    }

    @Override
    public Book returnBook(User user) {
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
