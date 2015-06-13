package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class CheckoutOptionTest {
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
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser, books);

        checkoutOption.obtainOptionResult();

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
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser, books);

        checkoutOption.obtainOptionResult();

        verify(bookParser).parseUserInput("Kite Runner");
    }

    @Test
    public void checkoutShouldPerformBookCheckout() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        when(bookParser.parseUserInput("Kite Runner")).thenReturn(bookOne);
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser, books);

        checkoutOption.obtainOptionResult();

        verify(books).checkout(bookOne);
    }

    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        when(bookParser.parseUserInput("Kite Runner")).thenReturn(bookOne);
        when(books.checkout(bookOne)).thenReturn(true);
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser, books);

        checkoutOption.obtainOptionResult();

        verify(consoleInputOutput).displayOutputToUser(Messages.SUCCESSFUL_CHECKOUT);
    }
}
