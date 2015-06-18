package com.twu.biblioteca.book;

import com.twu.biblioteca.user.User;

public interface BookPresenter {
    void addBook(String name, String author, String year, User user);

    void addBook(String name, String author, String year);
}
