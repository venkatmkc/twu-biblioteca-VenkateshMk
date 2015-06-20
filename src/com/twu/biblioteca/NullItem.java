package com.twu.biblioteca;

import com.twu.biblioteca.user.User;

public class NullItem implements BorrowableItem {
    @Override
    public BorrowableItem checkout(User user) {
        return null;
    }

    @Override
    public BorrowableItem returnItem(User user) {
        return null;
    }

    @Override
    public String getCheckoutMessage() {
        return null;
    }

    @Override
    public String getReturnMessage() {
        return null;
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
