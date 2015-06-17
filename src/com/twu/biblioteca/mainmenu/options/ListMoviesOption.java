package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.Library;

public class ListMoviesOption implements MainMenuAction {
    private final ConsoleInputOutput consoleInputOutput;
    private final Library library;

    public ListMoviesOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult() {
        consoleInputOutput.displayOutputToUser(library.formattedMovies());
    }
}
