package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.item.movie.AvailableMovie;
import com.twu.biblioteca.item.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedHashSet;

import static com.twu.biblioteca.io.Messages.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CheckoutMovieOptionTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    Section section;

    @Before
    public void setUp() {
        initMocks(this);

    }

    @Test
    public void movieTitleShouldBeObtainedFromTheUser() {
        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie("Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        Section section = new Section(movies);
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        CheckoutMovieOption checkoutMovieOption = new CheckoutMovieOption(consoleInputOutput, section);

        checkoutMovieOption.obtainOptionResult(user);

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void checkoutShouldBeDoneWithTheGivenTitle() {
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckoutMovieOption checkoutMovieOption = new CheckoutMovieOption(consoleInputOutput, section);

        checkoutMovieOption.obtainOptionResult(user);

        verify(section).checkoutItem("Inception", user);
    }

    @Test
    public void checkoutMessageShouldBeDisplayedToTheUser() {
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(section.checkoutItem("Inception", user)).thenReturn(SUCCESSFUL_MOVIE_CHECKOUT);
        CheckoutMovieOption checkoutMovieOption = new CheckoutMovieOption(consoleInputOutput, section);

        checkoutMovieOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(SUCCESSFUL_MOVIE_CHECKOUT);
    }
}