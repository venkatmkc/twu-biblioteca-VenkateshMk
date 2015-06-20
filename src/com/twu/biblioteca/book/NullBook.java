package com.twu.biblioteca.book;

import com.twu.biblioteca.ItemPresenter;
import com.twu.biblioteca.user.User;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_CHECKOUT;

public class NullBook extends Book {
    public NullBook() {
        super("", "", "");
    }

    @Override
    public Book checkout(User user) {
        return new NullBook();
    }

    @Override
    public Book returnItem(User user) {
        return new NullBook();
    }

    public String getCheckoutMessage() {
        return UNSUCCESSFUL_BOOK_CHECKOUT;
    }

    public String getReturnMessage() {
        return UNSUCCESSFUL_BOOK_RETURN;
    }

    @Override
    public boolean isSameItem(String itemName) {
        return name.equals(itemName);
    }

    @Override
    public void appendToCheckedOutItems(ItemPresenter itemPresenter) {

    }

    @Override
    public void appendToAvailableItems(ItemPresenter itemPresenter) {

    }
}
