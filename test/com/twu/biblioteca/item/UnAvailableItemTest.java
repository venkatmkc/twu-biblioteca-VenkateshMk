package com.twu.biblioteca.item;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnAvailableItemTest {
    @Test
    public void checkoutShouldProduceUnAvailableItem() {
        User userOne = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");
        UnAvailableItem unAvailableItem = new UnAvailableItem();

        BorrowableItem item = unAvailableItem.checkout(userOne);
        String actualCheckout = item.getCheckoutMessage();

        assertThat(actualCheckout, is(Messages.ITEM_UNAVAILABLE));
    }

    @Test
    public void returnShouldProduceUnAvailableItem() {
        User userOne = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");
        UnAvailableItem unAvailableItem = new UnAvailableItem();

        BorrowableItem item = unAvailableItem.checkout(userOne);
        String actualReturn = item.getReturnMessage();

        assertThat(actualReturn, is(Messages.ITEM_UNAVAILABLE));
    }
}