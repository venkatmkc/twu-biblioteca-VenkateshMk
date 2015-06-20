package com.twu.biblioteca.movie;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.CheckedOutMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.movie.NullMovie;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckedOutMovieTest {
    @Test
    public void returnBookShouldProduceAvailableBook() {
        AvailableMovie movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutMovie checkedOutMovie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0", user);

        AvailableMovie actualMovie = checkedOutMovie.returnMovie();

        assertThat(actualMovie, is(equalTo(movie)));
    }

    @Test
    public void checkoutShouldProduceNullMovie() {
        Movie nullMovie = new NullMovie();
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutMovie movie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0", user);

        NullMovie actualResult = movie.checkout();

        assertThat(actualResult, is(equalTo(nullMovie)));
    }

    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutMovie movie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0", user);

        String actualStatusMessage = movie.getCheckoutMessage();

        assertThat(actualStatusMessage, is(Messages.SUCCESSFUL_MOVIE_CHECKOUT));
    }
}