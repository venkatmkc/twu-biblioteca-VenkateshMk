package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.book.BookPresenter;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class ListCheckedOutBooksOption implements MainMenuAction {
    private ConsoleInputOutput consoleInputOutput;
    private Library library;
    private BookPresenter bookPresenter;

    public ListCheckedOutBooksOption(ConsoleInputOutput consoleInputOutput, Library library, BookPresenter bookPresenter) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
        this.bookPresenter = bookPresenter;
    }

    @Override
    public void obtainOptionResult(User user) {
        consoleInputOutput.displayOutputToUser(library.checkedOutBooks());
    }
}
