package com.twu.biblioteca;

public class CheckedOutBook extends Book{
    public CheckedOutBook(String name, String author, String year) {
        super(name, author, year);
    }

    @Override
    public void appendToBooks(BooksPresenter booksPresenter) {
    }

    public static CheckedOutBook create(String name, String author, String year) {
        return new CheckedOutBook(name, author, year);
    }

    public AvailableBook returnBook() {
        return AvailableBook.create(name, author, year);
    }

    public NullBook checkout() {
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
