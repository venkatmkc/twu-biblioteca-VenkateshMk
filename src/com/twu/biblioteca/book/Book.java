package com.twu.biblioteca.book;

import com.twu.biblioteca.BorrowableItem;
import com.twu.biblioteca.user.User;

public abstract class Book implements BorrowableItem {

    protected String name, author, year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        Book book = (Book) o;

        return !(name != null ? !name.equals(book.name) : book.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public abstract Book checkout(User user);

    public abstract Book returnItem(User user);

    public abstract String getCheckoutMessage();

    public abstract String getReturnMessage();

    @Override
    public boolean isSameItem(String itemName) {
        return name.equals(itemName);
    }
}
