package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class BooksToConsoleTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    Books books;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
        MockitoAnnotations.initMocks(this);
        when(books.toString())
                .thenReturn("book list");
    }


    @Test
    public void listOfBooksShouldBeDisplayed() {
        BooksToConsole booksToConsole = new BooksToConsole(books);

        booksToConsole.displayBookList();
        String actualBookList = outputStreamContent.toString();

        assertThat(actualBookList, is(equalTo("book list")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
