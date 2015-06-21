package com.twu.biblioteca.item.book;

import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_CHECKOUT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnAvailableBookTest {
    @Test
    public void unsuccessfulCheckoutShouldProduceFailureMessage() {
        User userOne = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");
        UnAvailableBook unAvailableBook = new UnAvailableBook();

        BorrowableItem actualResult = unAvailableBook.checkout(userOne);
        String actualStatus = actualResult.getCheckoutMessage();

        assertThat(actualStatus, is(UNSUCCESSFUL_BOOK_CHECKOUT));
    }

    @Test
    public void unsuccessfulBookReturnShouldProduceFailureMessage() {
        User userOne = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");
        UnAvailableBook unAvailableBook = new UnAvailableBook();

        BorrowableItem actualResult = unAvailableBook.returnItem(userOne);
        String actualStatus = actualResult.getReturnMessage();

        assertThat(actualStatus, is(UNSUCCESSFUL_BOOK_RETURN));
    }
}