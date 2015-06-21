package com.twu.biblioteca.item.movie;

import com.twu.biblioteca.io.Messages;
import org.junit.Test;

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