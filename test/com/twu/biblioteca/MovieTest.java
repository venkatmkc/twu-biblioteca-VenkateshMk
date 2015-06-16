package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class MovieTest {
    @Mock
    MoviesPresenter moviesPresenter;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void appendMovieShouldAppendItselfToTheMoviesList() {
        Movie movie = new Movie("Inception", "2010", "Christopher Nolan", "9.0");

        movie.appendToMovies(moviesPresenter);

        verify(moviesPresenter).addMovie("Inception", "2010", "Christopher Nolan", "9.0");
    }
}
