package com.twu.biblioteca;

public class MoviesPresenter {
    private String formattedMovies;

    public MoviesPresenter(String formattedMovies) {
        this.formattedMovies = formattedMovies;
    }

    @Override
    public String toString() {
        return formattedMovies;
    }

    public void addMovie(String movieName, String year, String director, String rating) {
        formattedMovies += movieName + ", ";
        formattedMovies += year + ", ";
        formattedMovies += director + ", ";
        formattedMovies += rating + "\n";
    }
}
