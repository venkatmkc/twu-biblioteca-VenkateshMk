package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.SUCCESSFUL_BOOK_RETURN;

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

    public String getReturnMessage() {
        return SUCCESSFUL_BOOK_RETURN;
    }
}
