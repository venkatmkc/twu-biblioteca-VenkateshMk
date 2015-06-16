package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static com.twu.biblioteca.Messages.UNSUCCESSFUL_CHECKOUT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NullBookTest {
    @Test
    public void unsuccessfulCheckoutShouldProduceFailureMessage() {
        NullBook nullBook = new NullBook();

        String actualStatus = nullBook.getCheckoutMessage();

        assertThat(actualStatus, is(UNSUCCESSFUL_CHECKOUT));
    }

    @Test
    public void unsuccessfulBookReturnShouldProduceFailureMessage() {
        NullBook nullBook = new NullBook();

        String actualStatus = nullBook.getReturnMessage();

        assertThat(actualStatus, is(UNSUCCESSFUL_BOOK_RETURN));
    }
}