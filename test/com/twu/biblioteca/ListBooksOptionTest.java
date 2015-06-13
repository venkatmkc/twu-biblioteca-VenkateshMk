package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;


public class ListBooksOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void bookListShouldBeDisplayedToTheUser() {
        Book book = new Book("book name", "book author", "2012");
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        bookList.put(book, true);
        Books books = new Books(bookList);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, books);

        listBooksOption.obtainOptionResult();

        verify(consoleInputOutput).displayOutputToUser(books);
    }
}