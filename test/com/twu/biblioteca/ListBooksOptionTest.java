package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        Books books = new Books(bookList);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, books);

        listBooksOption.obtainOptionResult();

        verify(consoleInputOutput).displayOutputToUser(books);
    }
}