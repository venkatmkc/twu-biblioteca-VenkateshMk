package com.twu.biblioteca.item.movie;

import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_MOVIE_RETURN;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AvailableMovieTest {
    @Test
    public void checkoutShouldProduceCheckedOutMovie() {
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        BorrowableItem checkedOutMovie = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0", user);
        AvailableMovie movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");

        BorrowableItem actualMovie = movie.checkout(user);

        assertThat(actualMovie, is(equalTo(checkedOutMovie)));
    }

    @Test
    public void returnMovieShouldProduceNullMovie() {
        BorrowableItem nullMovie = new UnAvailableMovie();
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        AvailableMovie movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");

        BorrowableItem actualResult = movie.returnItem(user);

        assertThat(actualResult, is(equalTo(nullMovie)));
    }

    @Test
    public void successfulReturnShouldProduceSuccessMessage() {
        AvailableMovie movie = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");

        String actualStatus = movie.getReturnMessage();

        assertThat(actualStatus, is(equalTo(SUCCESSFUL_MOVIE_RETURN)));
    }
}
