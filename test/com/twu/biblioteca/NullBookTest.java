package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.Messages.UNSUCCESSFUL_CHECKOUT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NullBookTest {
    @Test
    public void unsuccessfulCheckoutShouldProduceFailureMessage() {
        NullBook nullBook = new NullBook();

        String actualStatus = nullBook.getCheckoutMessage();

        assertThat(actualStatus, is(UNSUCCESSFUL_CHECKOUT));
    }
}