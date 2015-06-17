package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.user.User;

public class ReturnMovieOption implements MainMenuAction {
    private final ConsoleInputOutput consoleInputOutput;
    private final Library library;

    public ReturnMovieOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    public void obtainOptionResult(User user) {
        String title = consoleInputOutput.getUserInput();
        String returnMovieStatus = library.returnMovie(title);
        consoleInputOutput.displayOutputToUser(returnMovieStatus);
    }
}
