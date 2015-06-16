package com.twu.biblioteca;

public class AvailableMovie extends Movie{
    public AvailableMovie(String name, String year, String director, String rating) {
        super(name, year, director, rating);
    }

    public Movie checkout() {
        return CheckedOutMovie.create(name, year, director, rating);
    }

    public Movie returnMovie() {
        return new NullMovie();
    }
}
