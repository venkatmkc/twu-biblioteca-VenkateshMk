package com.twu.biblioteca.movie;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_MOVIE_RETURN;

public class AvailableMovie extends Movie {
    public AvailableMovie(String name, String year, String director, String rating) {
        super(name, year, director, rating);
    }

    @Override
    public void appendToMovies(MoviesPresenter moviesPresenter) {
        moviesPresenter.addMovie(name, year, director, rating);
    }

    public Movie checkout() {
        return CheckedOutMovie.create(name, year, director, rating);
    }

    @Override
    public String getCheckoutMessage() {
        return null;
    }

    public Movie returnMovie() {
        return new NullMovie();
    }

    public String getReturnMessage() {
        return SUCCESSFUL_MOVIE_RETURN;
    }

    public static AvailableMovie create(String name, String year, String director, String rating) {
        return new AvailableMovie(name, year, director, rating);
    }
}
