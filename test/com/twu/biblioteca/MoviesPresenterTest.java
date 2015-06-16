package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoviesPresenterTest {
    @Test
    public void formattedMoviesShouldBeProduced() {
        String formattedMovies = "inception\nfollowing";
        MoviesPresenter moviesPresenter = new MoviesPresenter(formattedMovies);

        String actualFormattedMovies = moviesPresenter.toString();

        assertThat(actualFormattedMovies, is("inception\nfollowing"));
    }

    @Test
    public void addMovieShouldAddMovieToTheFormattedMovies() {
        String formattedMovies = new String();
        MoviesPresenter moviesPresenter = new MoviesPresenter(formattedMovies);

        moviesPresenter.addMovie("Inception", "2010", "Christopher Nolan", "9");
        moviesPresenter.addMovie("Following", "1998", "Christopher Nolan", "8");
        String actualFormattedMovies = moviesPresenter.toString();

        assertThat(actualFormattedMovies, is("Inception, 2010, Christopher Nolan, 9\nFollowing, 1998, Christopher Nolan, 8\n"));
    }

}
