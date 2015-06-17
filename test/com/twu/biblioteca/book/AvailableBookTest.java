package com.twu.biblioteca.book;

import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.CheckedOutBook;
import com.twu.biblioteca.book.NullBook;
import org.junit.Test;

import static com.twu.biblioteca.io.Messages.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AvailableBookTest {
    @Test
    public void checkoutShouldProduceCheckedOutBook() {
        Book checkedOutBook = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        Book actualBook = book.checkout();

        assertThat(actualBook, is(equalTo(checkedOutBook)));
    }

    @Test
    public void returnBookShouldProduceNullBook() {
        Book nullBook = new NullBook();
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        Book actualResult = book.returnBook();

        assertThat(actualResult, is(equalTo(nullBook)));
    }

    @Test
    public void successfulReturnShouldProduceSuccessMessage() {
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        String actualStatus = book.getReturnMessage();

        assertThat(actualStatus, is(equalTo(SUCCESSFUL_BOOK_RETURN)));
    }
}