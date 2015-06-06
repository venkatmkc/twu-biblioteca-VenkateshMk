package com.twu.biblioteca;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BooksTest {
    @Mock
    Book bookOne, bookTwo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(bookOne.toString()).
                thenReturn("Kite Runner         |Khaled Hosseini     |2003");
        when(bookTwo.toString()).
                thenReturn("The Sky Is Falling  |Sidney Sheldon      |2001");
    }

    @Test
    public void formattedStringShouldBeProducedRepresentingBookList() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);

        Books books = new Books(bookList);

        String actualBookList = books.toString();

        assertThat(actualBookList, is(equalTo("Kite Runner         |Khaled Hosseini     |2003\n" +
                "The Sky Is Falling  |Sidney Sheldon      |2001\n")));
    }
}