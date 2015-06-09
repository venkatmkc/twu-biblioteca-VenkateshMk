package com.twu.biblioteca.view;

import com.twu.biblioteca.model.*;

public class ListBooksOption implements MainMenuAction {
    private BooksToConsole booksToConsole;

    public ListBooksOption(BooksToConsole booksToConsole) {
        this.booksToConsole = booksToConsole;
    }

    @Override
    public void obtainOptionResult() {
        booksToConsole.displayBookList();
    }
}
