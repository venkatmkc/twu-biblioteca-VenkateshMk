package com.twu.biblioteca.view;

import org.junit.*;
import org.mockito.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ListBooksOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private BooksToConsole booksToConsole;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void bookListShouldBeChosen() {
        ListBooksOption listBooksOption = new ListBooksOption(booksToConsole);

        listBooksOption.obtainOptionResult();

        Mockito.verify(booksToConsole).displayBookList();
    }
}