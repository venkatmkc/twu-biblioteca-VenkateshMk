package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BooksTest {
    @Test
    public void formattedStringShouldBeProducedRepresentingBookList() {
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("Kite Runner");
        bookList.add("The Sky Is Falling");
        Books books = new Books(bookList);

        String actualBookList = books.toString();

        assertThat(actualBookList, is(equalTo("Kite Runner\nThe Sky Is Falling\n")));
    }
}