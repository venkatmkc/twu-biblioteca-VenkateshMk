package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AvailableMovieTest {
    @Test
    public void checkoutShouldProduceCheckedOutMovie() {
        Movie checkedOutMovie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0");
        AvailableMovie movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");

        Movie actualMovie = movie.checkout();

        assertThat(actualMovie, is(equalTo(checkedOutMovie)));
    }

    @Test
    public void returnMovieShouldProduceNullMovie() {
        Movie nullMovie = new NullMovie();
        AvailableMovie movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");

        Movie actualResult = movie.returnMovie();

        assertThat(actualResult, is(equalTo(nullMovie)));
    }

}
