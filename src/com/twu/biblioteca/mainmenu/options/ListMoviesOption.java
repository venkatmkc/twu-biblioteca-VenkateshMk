package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.ItemPresenter;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.user.User;

public class ListMoviesOption implements MainMenuAction {
    private final ConsoleInputOutput consoleInputOutput;
    private final Library library;

    public ListMoviesOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult(User user) {
        ItemPresenter itemPresenter = new ItemPresenter("");
        consoleInputOutput.displayOutputToUser(library.availableFormattedItems(itemPresenter));
    }
}
