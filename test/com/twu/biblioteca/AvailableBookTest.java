package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AvailableBookTest {
    @Test
    public void checkoutShouldProduceCheckedOutBook() {
        CheckedOutBook checkedOutBook = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        CheckedOutBook actualBook = book.checkout();

        assertThat(actualBook, is(equalTo(checkedOutBook)));
    }
}