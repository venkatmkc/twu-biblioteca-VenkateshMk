package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;


public class ListLibraryOptionTest {
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

        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        availableBooks.add(book);
        Library library = new Library(availableBooks, checkedoutBooks);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library);

        listBooksOption.obtainOptionResult();

        verify(consoleInputOutput).displayOutputToUser(library);
    }
}