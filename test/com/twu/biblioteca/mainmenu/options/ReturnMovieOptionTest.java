package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.BorrowableItem;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.CheckedOutBook;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedHashSet;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_MOVIE_RETURN;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ReturnMovieOptionTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    Library library;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void movieTitleShouldBeObtainedFromTheUser() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(movies);
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        ReturnMovieOption returnMovieOption = new ReturnMovieOption(consoleInputOutput, library);

        returnMovieOption.obtainOptionResult(user);

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void returnMovieShouldBeDoneWithTheGivenTitle() {
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        ReturnMovieOption returnMovieOption = new ReturnMovieOption(consoleInputOutput, library);

        returnMovieOption.obtainOptionResult(user);

        verify(library).returnItem("Inception", user);
    }

    @Test
    public void checkoutMessageShouldBeDisplayedToTheUser() {
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(library.returnItem("Inception", user)).thenReturn(SUCCESSFUL_MOVIE_RETURN);
        ReturnMovieOption returnMovieOption = new ReturnMovieOption(consoleInputOutput, library);

        returnMovieOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(SUCCESSFUL_MOVIE_RETURN);
    }
}