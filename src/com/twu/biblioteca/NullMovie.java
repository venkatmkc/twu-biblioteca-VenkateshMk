package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.UNSUCCESSFUL_MOVIE_CHECKOUT;
import static com.twu.biblioteca.Messages.UNSUCCESSFUL_MOVIE_RETURN;

public class NullMovie extends Movie {
    public NullMovie() {
        super("", "", "", "");
    }

    @Override
    public Movie returnMovie() {
        return null;
    }

    @Override
    public Movie checkout() {
        return null;
    }

    public String getCheckoutMessage() {
        return UNSUCCESSFUL_MOVIE_CHECKOUT;
    }

    public String getReturnMessage() {
        return UNSUCCESSFUL_MOVIE_RETURN;
    }
}
