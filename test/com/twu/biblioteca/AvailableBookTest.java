package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AvailableBookTest {
    @Test
    public void checkoutShouldProduceCheckedOutBook() {
        Book checkedOutBook = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        Book actualBook = book.checkout();

        assertThat(actualBook, is(equalTo(checkedOutBook)));
    }

    @Test
    public void returnBookShouldProduceNullBook() {
        Book nullBook = new NullBook();
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        Book actualResult = book.returnBook();

        assertThat(actualResult, is(equalTo(nullBook)));
    }

    @Test
    public void successfulReturnShouldProduceSuccessMessage() {
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        String actualStatus = book.getReturnMessage();

        assertThat(actualStatus, is(equalTo(SUCCESSFUL_BOOK_RETURN)));
    }
}