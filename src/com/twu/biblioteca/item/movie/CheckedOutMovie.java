package com.twu.biblioteca.item.movie;

import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.item.UnAvailableItem;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;

public class CheckedOutMovie extends Movie {
    private User user;

    public CheckedOutMovie(String name, String year, String director, String rating, User user) {
        super(name, year, director, rating);
        this.user = user;
    }

    public static Movie create(String name, String year, String director, String rating, User user) {
        return new CheckedOutMovie(name, year, director, rating, user);
    }


    @Override
    public BorrowableItem checkout(User user) {
        return new UnAvailableItem();
    }

    @Override
    public BorrowableItem returnItem(User user) {
        return AvailableMovie.create(name, year, director, rating);
    }

    public String getCheckoutMessage() {
        return Messages.SUCCESSFUL_MOVIE_CHECKOUT;
    }

    @Override
    public String getReturnMessage() {
        return null;
    }

    @Override
    public void appendToCheckedOutItems(ItemPresenter itemPresenter) {
        itemPresenter.addCheckedOutMovie(name, year, director, rating, user);
    }

    @Override
    public void appendToAvailableItems(ItemPresenter itemPresenter) {

    }

}
