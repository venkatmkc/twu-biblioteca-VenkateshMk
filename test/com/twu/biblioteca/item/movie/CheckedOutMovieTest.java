package com.twu.biblioteca.item.movie;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static com.twu.biblioteca.io.Messages.ITEM_UNAVAILABLE;
import static com.twu.biblioteca.io.Messages.SUCCESSFUL_MOVIE_CHECKOUT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckedOutMovieTest {
    @Test
    public void returnBookShouldProduceAvailableBook() {
        BorrowableItem movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutMovie checkedOutMovie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0", user);

        BorrowableItem actualMovie = checkedOutMovie.returnItem(user);

        assertThat(actualMovie, is(equalTo(movie)));
    }

    @Test
    public void checkoutShouldProduceNullMovie() {
        BorrowableItem nullMovie = new UnAvailableMovie();
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutMovie movie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0", user);

        BorrowableItem actualResult = movie.checkout(user);
        String actualStatusMessage = actualResult.getCheckoutMessage();

        assertThat(actualStatusMessage, is(equalTo(ITEM_UNAVAILABLE)));
    }

    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutMovie movie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0", user);

        String actualStatusMessage = movie.getCheckoutMessage();

        assertThat(actualStatusMessage, is(SUCCESSFUL_MOVIE_CHECKOUT));
    }
}