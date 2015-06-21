package com.twu.biblioteca.item.book;

import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.user.User;

import static com.twu.biblioteca.io.Messages.*;

public class AvailableBook extends Book {
    public AvailableBook(String name, String author, String year) {
        super(name, author, year);
    }

    @Override
    public Book checkout(User user) {
        return CheckedOutBook.create(name, author, year, user);
    }

    public static AvailableBook create(String name, String author, String year) {
        return new AvailableBook(name, author, year);
    }

    @Override
    public Book returnItem(User user) {
        return new UnAvailableBook();
    }

    @Override
    public String getCheckoutMessage() {
        return UNSUCCESSFUL_BOOK_CHECKOUT;
    }

    @Override
    public String getReturnMessage() {
        return SUCCESSFUL_BOOK_RETURN;
    }

    @Override
    public void appendToAvailableItems(ItemPresenter itemPresenter) {
        itemPresenter.addAvailableBook(name, author, year);
    }

    @Override
    public void appendToCheckedOutItems(ItemPresenter itemPresenter) {
    }
}
