package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ListBooksOptionTest {
    @Mock
    private Books books;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(books.toString()).
                thenReturn("book list");
    }

    @Test
    public void bookListShouldBeChosen() {
        ListBooksOption listBooksOption = new ListBooksOption(books);

        String actualBookList = listBooksOption.obtainOptionResult();

        assertThat(actualBookList, is(equalTo("book list")));
    }
}