package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static com.twu.biblioteca.Messages.UNSUCCESSFUL_BOOK_CHECKOUT;

public class NullBook extends Book{
    public NullBook() {
        super("", "", "");
    }

    @Override
    public void appendToBooks(BooksPresenter booksPresenter) {
    }

    @Override
    public Book checkout() {
        return new NullBook();
    }

    @Override
    public Book returnBook() {
        return new NullBook();
    }

    public String getCheckoutMessage() {
        return UNSUCCESSFUL_BOOK_CHECKOUT;
    }

    public String getReturnMessage() {
        return UNSUCCESSFUL_BOOK_RETURN;
    }
}
