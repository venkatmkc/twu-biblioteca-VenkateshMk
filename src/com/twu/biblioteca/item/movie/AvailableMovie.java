package com.twu.biblioteca.item.movie;

import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.user.User;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_MOVIE_RETURN;

public class AvailableMovie extends Movie {
    public AvailableMovie(String name, String year, String director, String rating) {
        super(name, year, director, rating);
    }

    @Override
    public BorrowableItem checkout(User user) {
        return CheckedOutMovie.create(name, year, director, rating, user);
    }

    @Override
    public BorrowableItem returnItem(User user) {
        return new NullMovie();
    }

    @Override
    public String getCheckoutMessage() {
        return null;
    }

    public String getReturnMessage() {
        return SUCCESSFUL_MOVIE_RETURN;
    }

    @Override
    public void appendToCheckedOutItems(ItemPresenter itemPresenter) {

    }

    @Override
    public void appendToAvailableItems(ItemPresenter itemPresenter) {
        itemPresenter.addAvailableMovie(name, year, director, rating);
    }


    public static AvailableMovie create(String name, String year, String director, String rating) {
        return new AvailableMovie(name, year, director, rating);
    }
}
