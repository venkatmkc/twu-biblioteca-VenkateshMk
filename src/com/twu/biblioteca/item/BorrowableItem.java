package com.twu.biblioteca.item;

import com.twu.biblioteca.user.User;

public interface BorrowableItem {
    BorrowableItem checkout(User user);

    BorrowableItem returnItem(User user);

    String getCheckoutMessage();

    String getReturnMessage();

    boolean isSameItem(String itemName);

    void appendToCheckedOutItems(ItemPresenter itemPresenter);

    void appendToAvailableItems(ItemPresenter itemPresenter);
}
