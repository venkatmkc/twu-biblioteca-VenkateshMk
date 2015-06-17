package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedHashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CheckoutMovieOptionTest {
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
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        CheckoutMovieOption checkoutMovieOption = new CheckoutMovieOption(consoleInputOutput, library);

        checkoutMovieOption.obtainOptionResult();

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void checkoutShouldBeDoneWithTheGivenTitle() {
        when(consoleInputOutput.getUserInput()).thenReturn("Inception");
        CheckoutMovieOption checkoutMovieOption = new CheckoutMovieOption(consoleInputOutput, library);

        checkoutMovieOption.obtainOptionResult();

        verify(library).checkoutMovie("Inception");
    }
}