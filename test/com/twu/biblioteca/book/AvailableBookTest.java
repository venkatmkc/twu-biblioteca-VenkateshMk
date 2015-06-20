package com.twu.biblioteca.book;

import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.io.Messages.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AvailableBookTest {
    private User user;

    @Before
    public void setUp() {
        user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
    }
    @Test
    public void checkoutShouldProduceCheckedOutBook() {
        Book checkedOutBook = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        Book actualBook = book.checkout(user);

        assertThat(actualBook, is(equalTo(checkedOutBook)));
    }

    @Test
    public void returnBookShouldProduceNullBook() {
        Book nullBook = new NullBook();
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        Book actualResult = book.returnItem(user);

        assertThat(actualResult, is(equalTo(nullBook)));
    }

    @Test
    public void successfulReturnShouldProduceSuccessMessage() {
        AvailableBook book = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");

        String actualStatus = book.getReturnMessage();

        assertThat(actualStatus, is(equalTo(SUCCESSFUL_BOOK_RETURN)));
    }
}