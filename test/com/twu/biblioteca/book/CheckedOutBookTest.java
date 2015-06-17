package com.twu.biblioteca.book;

import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.CheckedOutBook;
import com.twu.biblioteca.book.NullBook;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckedOutBookTest {
    @Test
    public void returnBookShouldProduceAvailableBook() {
        User user = new User("222-2222", "logmein");
        AvailableBook availableBook = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        AvailableBook actualBook = book.returnBook(user);

        assertThat(actualBook, is(equalTo(availableBook)));
    }

    @Test
    public void checkoutShouldProduceNullBook() {
        NullBook nullBook = new NullBook();
        User user = new User("222-2222", "logmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        NullBook actualResult = book.checkout(user);

        assertThat(actualResult, is(equalTo(nullBook)));
    }

    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        User user = new User("222-2222", "logmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        String actualStatusMessage = book.getCheckoutMessage();

        assertThat(actualStatusMessage, is(Messages.SUCCESSFUL_BOOK_CHECKOUT));
    }
}