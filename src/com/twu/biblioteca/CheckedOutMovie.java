package com.twu.biblioteca;

public class CheckedOutMovie extends Movie {
    public CheckedOutMovie(String name, String year, String director, String rating) {
        super(name, year, director, rating);
    }

    @Override
    public void appendToMovies(MoviesPresenter moviesPresenter) {

    }

    public static Movie create(String name, String year, String director, String rating) {
        return new CheckedOutMovie(name, year, director, rating);
    }

    public AvailableMovie returnMovie() {
        return AvailableMovie.create(name, year, director, rating);
    }

    public NullMovie checkout() {
        return new NullMovie();
    }

    public String getCheckoutMessage() {
        return Messages.SUCCESSFUL_MOVIE_CHECKOUT;
    }

    @Override
    public String getReturnMessage() {
        return null;
    }
}
