package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.UNSUCCESSFUL_MOVIE_CHECKOUT;

public class NullMovie extends Movie {
    public NullMovie() {
        super("", "", "", "");
    }

    @Override
    public Movie returnMovie() {
        return null;
    }

    public String getCheckoutMessage() {
        return UNSUCCESSFUL_MOVIE_CHECKOUT;
    }
}
