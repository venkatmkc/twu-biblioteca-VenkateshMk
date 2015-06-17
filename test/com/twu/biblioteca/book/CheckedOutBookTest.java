package com.twu.biblioteca.book;

import com.sun.xml.internal.xsom.impl.WildcardImpl;
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

        Book actualBook = book.returnBook(user);

        assertThat(actualBook, is(equalTo((Book) availableBook)));
    }

    @Test
    public void checkoutShouldProduceNullBook() {
        NullBook nullBook = new NullBook();
        User user = new User("222-2222", "logmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        Book actualResult = book.checkout(user);

        assertThat(actualResult, is(equalTo((Book) nullBook)));
    }

    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        User user = new User("222-2222", "logmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);

        String actualStatusMessage = book.getCheckoutMessage();

        assertThat(actualStatusMessage, is(Messages.SUCCESSFUL_BOOK_CHECKOUT));
    }

    @Test
    public void returnBookShouldProduceNullBookIfOwnerIsDifferent() {
        User user = new User("222-2222", "logmein");
        User otherUser = new User("555-5555", "letmein");
        CheckedOutBook book = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book nullBook = new NullBook();

        Book actualResult = book.returnBook(otherUser);

        assertThat(actualResult, is(nullBook));
    }
}