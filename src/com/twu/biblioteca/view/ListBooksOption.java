package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Books;
import com.twu.biblioteca.model.MainMenuAction;
import com.twu.biblioteca.view.BooksToConsole;

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
