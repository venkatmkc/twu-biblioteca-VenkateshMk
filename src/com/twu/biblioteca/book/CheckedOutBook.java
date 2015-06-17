package com.twu.biblioteca.book;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;

public class CheckedOutBook extends Book {
    private User user;

    public CheckedOutBook(String name, String author, String year, User user) {
        super(name, author, year);
        this.user = user;
    }

    @Override
    public void appendToBooks(BooksPresenter booksPresenter) {
    }

    public static CheckedOutBook create(String name, String author, String year, User user) {
        return new CheckedOutBook(name, author, year, user);
    }

    public AvailableBook returnBook(User user) {
        return AvailableBook.create(name, author, year);
    }

    public NullBook checkout(User user) {
        return new NullBook();
    }

    public String getCheckoutMessage() {
        return Messages.SUCCESSFUL_BOOK_CHECKOUT;
    }

    @Override
    public String getReturnMessage() {
        return null;
    }
}
