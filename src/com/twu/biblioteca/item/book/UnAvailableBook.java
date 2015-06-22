package com.twu.biblioteca.item.book;

import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.user.User;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_CHECKOUT;

public class UnAvailableBook extends Book {
    public UnAvailableBook() {
        super("", "", "");
    }

    @Override
    public Book checkout(User user) {
        return new UnAvailableBook();
    }

    @Override
    public Book returnItem(User user) {
        return new UnAvailableBook();
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
