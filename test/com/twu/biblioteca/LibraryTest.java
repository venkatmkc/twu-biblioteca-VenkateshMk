package com.twu.biblioteca;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void formattedBookListShouldBeProduced() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        Library library = new Library(availableBooks, checkedoutBooks);

        String actualBookList = library.toString();

        assertThat(actualBookList, is(equalTo("Kite Runner          | Khaled Hosseini      | 2003\nThe Sky Is Falling   | Sidney Sheldon       | 2001\n")));
    }



    @Test
    public void checkoutShouldProduceSuccessOnSuccesfulCheckout() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        Library library = new Library(availableBooks, checkedoutBooks);

        boolean actualCheckoutStatus = library.checkout(bookOne);

        assertThat(actualCheckoutStatus , is(true));
    }

    @Test
    public void checkoutShouldProduceFailureOnUnSuccessfulCheckout() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        Library library = new Library(availableBooks, checkedoutBooks);

        library.checkout(bookOne);
        boolean actualCheckoutStatus = library.checkout(bookOne);

        assertThat(actualCheckoutStatus , is(false));
    }

    @Test
    public void returnBookShouldAddReturnedBookToFormattedBookList() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        checkedoutBooks.add(bookOne);
        availableBooks.add(bookTwo);
        Library library = new Library(availableBooks, checkedoutBooks);

        library.returnBook(bookOne);
        String actualBookList = library.toString();

        assertThat(actualBookList, is(equalTo("The Sky Is Falling   | Sidney Sheldon       | 2001\n" +
                "Kite Runner          | Khaled Hosseini      | 2003\n")));
    }

    @Test
    public void returnBookShouldProduceSuccessOnSuccesfulBookReturn() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        checkedoutBooks.add(bookOne);
        availableBooks.add(bookTwo);
        Library library = new Library(availableBooks, checkedoutBooks);

        boolean actualReturnStatus = library.returnBook(bookOne);

        assertThat(actualReturnStatus , is(true));
    }

    @Test
    public void returnBookShouldProduceFailureOnUnSuccessfulReturn() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        checkedoutBooks.add(bookOne);
        availableBooks.add(bookTwo);
        Library library = new Library(availableBooks, checkedoutBooks);

        library.returnBook(bookOne);
        boolean actualReturnStatus = library.returnBook(bookOne);

        assertThat(actualReturnStatus , is(false));
    }
}