package com.twu.biblioteca.item.movie;

import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.user.User;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_MOVIE_CHECKOUT;
import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_MOVIE_RETURN;

public class NullMovie extends Movie {
    public NullMovie() {
        super("", "", "", "");
    }

    @Override
    public BorrowableItem checkout(User user) {
        return null;
    }

    @Override
    public BorrowableItem returnItem(User user) {
        return null;
    }

    public String getCheckoutMessage() {
        return UNSUCCESSFUL_MOVIE_CHECKOUT;
    }

    public String getReturnMessage() {
        return UNSUCCESSFUL_MOVIE_RETURN;
    }

    @Override
    public boolean isSameItem(String itemName) {
        return false;
    }

    @Override
    public void appendToCheckedOutItems(ItemPresenter itemPresenter) {

    }

    @Override
    public void appendToAvailableItems(ItemPresenter itemPresenter) {

    }
}
