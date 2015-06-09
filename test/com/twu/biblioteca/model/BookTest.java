package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void formattedBookDetailsShouldBeProduced() {
        Book actualBook = new Book("Kite Runner", "Khaled Hosseini", "2003");

        String actualBookDetails = actualBook.formattedBookDetails(20, 20);

        assertThat(actualBookDetails, is(equalTo("Kite Runner          | Khaled Hosseini      | 2003")));
    }

    @Test
    public void nameLengthShouldBeLengthOfName() {
        Book book = new Book("Kite Runner", "Khaled Hosseini", "2003");

        int actualNameLength = book.nameLength();

        assertThat(actualNameLength, is(equalTo(11)));
    }

    @Test
    public void authorLengthShouldBeLengthOfName() {
        Book book = new Book("Kite Runner", "Khaled Hosseini", "2003");

        int actualNameLength = book.authorLength();

        assertThat(actualNameLength, is(equalTo(15)));
    }
}