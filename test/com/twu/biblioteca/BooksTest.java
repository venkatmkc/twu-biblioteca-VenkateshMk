package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class BooksTest {
    @Test
    public void formattedBookListShouldBeProduced() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Books books = new Books(bookList);

        String actualBookList = books.toString();

        assertThat(actualBookList, is(equalTo("The Sky Is Falling | Sidney Sheldon  | 2001\nKite Runner        | Khaled Hosseini | 2003\n")));
    }

    @Test
    public void checkoutShouldStopAddingCheckedoutBookToFormattedBookList() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Books books = new Books(bookList);

        books.checkout(bookOne);
        String actualBookList = books.toString();

        assertThat(actualBookList, is(equalTo("The Sky Is Falling | Sidney Sheldon | 2001\n")));
    }

    @Test
    public void checkoutShouldProduceSuccessOnSuccesfulCheckout() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Books books = new Books(bookList);

        boolean actualCheckoutStatus = books.checkout(bookOne);

        assertThat(actualCheckoutStatus , is(true));
    }

    @Test
    public void checkoutShouldProduceFailureOnUnSuccessfulCheckout() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Books books = new Books(bookList);

        books.checkout(bookOne);
        boolean actualCheckoutStatus = books.checkout(bookOne);

        assertThat(actualCheckoutStatus , is(false));
    }

    @Test
    public void returnBookShouldAddReturnedBookToFormattedBookList() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, false);
        bookList.put(bookTwo, true);
        Books books = new Books(bookList);

        books.returnBook(bookOne);
        String actualBookList = books.toString();

        assertThat(actualBookList, is(equalTo("The Sky Is Falling | Sidney Sheldon  | 2001\nKite Runner        | Khaled Hosseini | 2003\n")));
    }

    @Test
    public void returnBookShouldProduceSuccessOnSuccesfulBookReturn() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, false);
        bookList.put(bookTwo, true);
        Books books = new Books(bookList);

        boolean actualCheckoutStatus = books.returnBook(bookOne);

        assertThat(actualCheckoutStatus , is(true));
    }
}