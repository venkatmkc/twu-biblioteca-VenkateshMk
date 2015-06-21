package com.twu.biblioteca.item.book;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckedOutBookTest {
    @Test
    public void returnBookShouldProduceAvailableBook() {
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        AvailableBook availableBook = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        Book actualBook = book.returnItem(user);

        assertThat(actualBook, is(equalTo((Book) availableBook)));
    }

    @Test
    public void checkoutShouldProduceNullBook() {
        UnAvailableBook unAvailableBook = new UnAvailableBook();
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        Book actualResult = book.checkout(user);

        assertThat(actualResult, is(equalTo((Book) unAvailableBook)));
    }

    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        String actualStatusMessage = book.getCheckoutMessage();

        assertThat(actualStatusMessage, is(Messages.SUCCESSFUL_BOOK_CHECKOUT));
    }

    @Test
    public void returnBookShouldProduceNullBookIfOwnerIsDifferent() {
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        User otherUser = new User("111-1131", "letmein", "venkatesh", "555-5555", "letmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book nullBook = new UnAvailableBook();

        Book actualResult = book.returnItem(otherUser);

        assertThat(actualResult, is(nullBook));
    }
}