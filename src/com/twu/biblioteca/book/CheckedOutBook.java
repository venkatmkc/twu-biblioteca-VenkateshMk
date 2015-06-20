package com.twu.biblioteca.book;

import com.twu.biblioteca.ItemPresenter;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;

public class CheckedOutBook extends Book {
    private User user;

    public CheckedOutBook(String name, String author, String year, User user) {
        super(name, author, year);
        this.user = user;
    }

    public static CheckedOutBook create(String name, String author, String year, User user) {
        return new CheckedOutBook(name, author, year, user);
    }

    public Book returnItem(User visitingUser) {
        if(user.equals(visitingUser))
            return AvailableBook.create(name, author, year);
        return new NullBook();
    }

    public Book checkout(User user) {
        return new NullBook();
    }

    public String getCheckoutMessage() {
        return Messages.SUCCESSFUL_BOOK_CHECKOUT;
    }

    @Override
    public String getReturnMessage() {
        return Messages.UNSUCCESSFUL_BOOK_RETURN;
    }


    @Override
    public void appendToCheckedOutItems(ItemPresenter itemPresenter) {
        itemPresenter.addCheckedOutBook(name, author, year, user);
    }

    @Override
    public void appendToAvailableItems(ItemPresenter itemPresenter) {}
}
