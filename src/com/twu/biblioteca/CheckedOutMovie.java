package com.twu.biblioteca;

public class CheckedOutMovie extends Movie {
    public CheckedOutMovie(String name, String year, String director, String rating) {
        super(name, year, director, rating);
    }

    public static Movie create(String name, String year, String director, String rating) {
        return new CheckedOutMovie(name, year, director, rating);
    }
}
