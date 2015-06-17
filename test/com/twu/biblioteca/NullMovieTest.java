package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.Messages.UNSUCCESSFUL_BOOK_CHECKOUT;
import static com.twu.biblioteca.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NullMovieTest {
    @Test
    public void unsuccessfulCheckoutShouldProduceFailureMessage() {
        NullMovie nullMovie = new NullMovie();

        String actualStatus = nullMovie.getCheckoutMessage();

        assertThat(actualStatus, is(Messages.UNSUCCESSFUL_MOVIE_CHECKOUT));
    }

    @Test
    public void unsuccessfulMovieReturnShouldProduceFailureMessage() {
        NullMovie nullMovie = new NullMovie();

        String actualStatus = nullMovie.getReturnMessage();

        assertThat(actualStatus, is(Messages.UNSUCCESSFUL_MOVIE_RETURN));
    }
}