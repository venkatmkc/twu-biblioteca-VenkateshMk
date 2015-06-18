package com.twu.biblioteca.book;

import com.twu.biblioteca.user.User;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_CHECKOUT;

public class NullBook extends Book {
    public NullBook() {
        super("", "", "");
    }

    @Override
    public void appendToBooks(AvailableBookPresenter availableBookPresenter) {
    }

    @Override
    public Book checkout(User  user) {
        return new NullBook();
    }

    @Override
    public Book returnBook(User user) {
        return new NullBook();
    }

    public String getCheckoutMessage() {
        return UNSUCCESSFUL_BOOK_CHECKOUT;
    }

    public String getReturnMessage() {
        return UNSUCCESSFUL_BOOK_RETURN;
    }
}
