package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.UNSUCCESSFUL_CHECKOUT;

public class NullBook extends Book{
    public NullBook() {
        super("", "", "");
    }

    public String getCheckoutMessage() {
        return UNSUCCESSFUL_CHECKOUT;
    }
}
