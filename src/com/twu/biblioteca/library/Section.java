package com.twu.biblioteca.library;

import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.item.UnAvailableItem;
import com.twu.biblioteca.user.User;

import java.util.LinkedHashSet;

public class Section {
    private LinkedHashSet<BorrowableItem> items;

    public Section(LinkedHashSet<BorrowableItem> items) {
        this.items = items;
    }

    public String availableItems(ItemPresenter itemPresenter) {
        itemPresenter.flush();
        for (BorrowableItem item : items) {
            item.appendToAvailableItems(itemPresenter);
        }
        return itemPresenter.toString();
    }

    public String checkedOutItems(ItemPresenter itemPresenter) {
        itemPresenter.flush();
        for (BorrowableItem item : items) {
            item.appendToCheckedOutItems(itemPresenter);
        }
        return itemPresenter.toString();
    }

    public synchronized String checkoutItem(String title, User user) {
        BorrowableItem item = searchItem(title);
        item = item.checkout(user);
        items.remove(item);
        items.add(item);
        return item.getCheckoutMessage();

    }

    public synchronized String returnItem(String title, User user) {
        BorrowableItem item = searchItem(title);
        item = item.returnItem(user);
        items.remove(item);
        items.add(item);
        return item.getReturnMessage();
    }

    public BorrowableItem searchItem(String itemName) {
        for (BorrowableItem item : items) {
            if (item.isSameItem(itemName))
                return item;
        }
        return new UnAvailableItem();
    }
}
