package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckedOutMovieTest {
    @Test
    public void returnBookShouldProduceAvailableBook() {
        AvailableMovie movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        CheckedOutMovie checkedOutMovie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0");

        AvailableMovie actualMovie = checkedOutMovie.returnMovie();

        assertThat(actualMovie, is(equalTo(movie)));
    }

    @Test
    public void checkoutShouldProduceNullMovie() {
        Movie nullMovie = new NullMovie();
        CheckedOutMovie movie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0");

        NullMovie actualResult = movie.checkout();

        assertThat(actualResult, is(equalTo(nullMovie)));
    }

    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        CheckedOutMovie movie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0");

        String actualStatusMessage = movie.getCheckoutMessage();

        assertThat(actualStatusMessage, is(Messages.SUCCESSFUL_MOVIE_CHECKOUT));
    }
}