package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class ListCheckedOutBooksOption implements MainMenuAction {
    private ConsoleInputOutput consoleInputOutput;
    private Library library;

    public ListCheckedOutBooksOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult(User user) {
        consoleInputOutput.displayOutputToUser(library.checkedOutBooks());
    }
}
