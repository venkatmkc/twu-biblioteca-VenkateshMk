package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
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

    @Test
    public void testForReflexivity() {
        Movie firstObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");

        assertEquals(firstObject, firstObject);
    }

    @Test
    public void testForComparingNullObjectsWithAMovie() {
        Movie firstObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");

        assertThat(firstObject, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        Movie firstObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie secondObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");

        assertEquals(firstObject, secondObject);
    }

    @Test
    public void testForTransitivity() {
        Movie firstObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie secondObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie thirdObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
        assertEquals(firstObject, thirdObject);
    }

    @Test
    public void testForSymmetry() {
        Movie firstObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie secondObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
    }

    @Test
    public void equalityTestForHashCode() {
        Movie firstObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie secondObject = new Movie("Inception", "2010", "Christopher Nolan", "9.0");

        assertEquals(firstObject.hashCode(), secondObject.hashCode());
    }
}
