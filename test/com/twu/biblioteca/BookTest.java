package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void formattedBookDetailsShouldBeProduced() {
        Book actualBook = new Book("Kite Runner", "Khaled Hosseini", "2003");

        String actualBookDetails = actualBook.toString();

        assertThat(actualBookDetails, is(equalTo("Kite Runner         |Khaled Hosseini     |2003")));
    }
}