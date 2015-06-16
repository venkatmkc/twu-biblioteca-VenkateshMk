package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckedOutBookTest {
    @Test
    public void returnBookShouldProduceAvailableBook() {
        AvailableBook availableBook = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");

        AvailableBook actualBook = book.returnBook();

        assertThat(actualBook, is(equalTo(availableBook)));
    }

    @Test
    public void checkoutShouldProduceNullBook() {
        NullBook nullBook = new NullBook();
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");

        NullBook actualResult = book.checkout();

        assertThat(actualResult, is(equalTo(nullBook)));
    }

    @Test
    public void successfulCheckoutShouldProduceSuccesMessage() {
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");

        String actualStatusMessage = book.getCheckoutMessage();

        assertThat(actualStatusMessage, is(Messages.SUCCESSFUL_CHECKOUT));
    }
}