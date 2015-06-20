package com.twu.biblioteca;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;

public class NullItem implements BorrowableItem {
    @Override
    public BorrowableItem checkout(User user) {
        return new NullItem();
    }

    @Override
    public BorrowableItem returnItem(User user) {
        return new NullItem();
    }

    @Override
    public String getCheckoutMessage() {
        return Messages.ITEM_UNAVAILABLE;
    }

    @Override
    public String getReturnMessage() {
        return Messages.ITEM_UNAVAILABLE;
    }

    @Override
    public boolean isSameItem(String itemName) {
        return false;
    }

    @Override
    public void appendToCheckedOutItems(ItemPresenter itemPresenter) {

    }

    @Override
    public void appendToAvailableItems(ItemPresenter itemPresenter) {

    }

}
