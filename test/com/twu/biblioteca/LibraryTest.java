package com.twu.biblioteca;

import org.junit.*;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void formattedBookListShouldBeProduced() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Library library = new Library(bookList);

        String actualBookList = library.toString();

        assertThat(actualBookList, is(equalTo("The Sky Is Falling | Sidney Sheldon  | 2001\nKite Runner        | Khaled Hosseini | 2003\n")));
    }

    @Test
    public void checkoutShouldStopAddingCheckedoutBookToFormattedBookList() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Library library = new Library(bookList);

        library.checkout(bookOne);
        String actualBookList = library.toString();

        assertThat(actualBookList, is(equalTo("The Sky Is Falling | Sidney Sheldon | 2001\n")));
    }

    @Test
    public void checkoutShouldProduceSuccessOnSuccesfulCheckout() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Library library = new Library(bookList);

        boolean actualCheckoutStatus = library.checkout(bookOne);

        assertThat(actualCheckoutStatus , is(true));
    }

    @Test
    public void checkoutShouldProduceFailureOnUnSuccessfulCheckout() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        Library library = new Library(bookList);

        library.checkout(bookOne);
        boolean actualCheckoutStatus = library.checkout(bookOne);

        assertThat(actualCheckoutStatus , is(false));
    }

    @Test
    public void returnBookShouldAddReturnedBookToFormattedBookList() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, false);
        bookList.put(bookTwo, true);
        Library library = new Library(bookList);

        library.returnBook(bookOne);
        String actualBookList = library.toString();

        assertThat(actualBookList, is(equalTo("The Sky Is Falling | Sidney Sheldon  | 2001\nKite Runner        | Khaled Hosseini | 2003\n")));
    }

    @Test
    public void returnBookShouldProduceSuccessOnSuccesfulBookReturn() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, false);
        bookList.put(bookTwo, true);
        Library library = new Library(bookList);

        boolean actualReturnStatus = library.returnBook(bookOne);

        assertThat(actualReturnStatus , is(true));
    }

    @Test
    public void returnBookShouldProduceFailureOnUnSuccessfulReturn() {
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        bookList.put(bookOne, false);
        bookList.put(bookTwo, true);
        Library library = new Library(bookList);

        library.returnBook(bookOne);
        boolean actualReturnStatus = library.returnBook(bookOne);

        assertThat(actualReturnStatus , is(false));
    }
}