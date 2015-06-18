package com.twu.biblioteca.book;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;

public class CheckedOutBook extends Book {
    private User user;

    public CheckedOutBook(String name, String author, String year, User user) {
        super(name, author, year);
        this.user = user;
    }

    public void appendToBooks(AvailableBookPresenter availableBookPresenter) {
    }

    public void appendToBooks(CheckedOutBookPresenter checkedOutBookPresenter) {
        checkedOutBookPresenter.addBook(name, author, year, user);
    }

    public static CheckedOutBook create(String name, String author, String year, User user) {
        return new CheckedOutBook(name, author, year, user);
    }

    public Book returnBook(User visitingUser) {
        if(user.equals(visitingUser))
            return AvailableBook.create(name, author, year);
        return new NullBook();
    }

    public Book checkout(User user) {
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
