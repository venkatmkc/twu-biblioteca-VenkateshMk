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
    public void checkOutShouldStopAddingCheckedoutBookToFormattedBookList() {
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
}