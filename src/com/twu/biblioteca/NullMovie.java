package com.twu.biblioteca;

public class NullMovie extends Movie {
    public NullMovie() {
        super("", "", "", "");
    }

    @Override
    public Movie returnMovie() {
        return null;
    }
}
