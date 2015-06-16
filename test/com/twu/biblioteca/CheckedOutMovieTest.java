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
}