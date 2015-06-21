package com.twu.biblioteca.item.movie;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnAvailableMovieTest {
    @Test
    public void unsuccessfulCheckoutShouldProduceFailureMessage() {
        User userOne = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");
        UnAvailableMovie unAvailableMovie = new UnAvailableMovie();

        BorrowableItem actualResult = unAvailableMovie.checkout(userOne);
        String actualStatus = actualResult.getCheckoutMessage();

        assertThat(actualStatus, is(Messages.UNSUCCESSFUL_MOVIE_CHECKOUT));
    }

    @Test
    public void unsuccessfulMovieReturnShouldProduceFailureMessage() {
        User userOne = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");
        UnAvailableMovie unAvailableMovie = new UnAvailableMovie();

        BorrowableItem actualResult = unAvailableMovie.returnItem(userOne);
        String actualStatus = actualResult.getReturnMessage();

        assertThat(actualStatus, is(Messages.UNSUCCESSFUL_MOVIE_RETURN));
    }


}