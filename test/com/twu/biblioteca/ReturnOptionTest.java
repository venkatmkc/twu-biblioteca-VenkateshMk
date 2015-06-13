package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ReturnOptionTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    BookParser bookParser;

    @Mock
    Books books;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void bookTitleShouldBeObtainedFromTheUser() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Books books = new Books(bookList);
        ReturnOption returnOption = new ReturnOption(consoleInputOutput, bookParser, books);

        returnOption.obtainOptionResult();

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void checkoutShouldParseUserInputToBook() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        ReturnOption returnOption = new ReturnOption(consoleInputOutput, bookParser, books);

        returnOption.obtainOptionResult();

        verify(bookParser).parseUserInput("Kite Runner");
    }
}