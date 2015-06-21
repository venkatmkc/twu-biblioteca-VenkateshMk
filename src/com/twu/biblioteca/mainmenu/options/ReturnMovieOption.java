package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class ReturnMovieOption implements MainMenuAction {
    private final ConsoleInputOutput consoleInputOutput;
    private final Section section;

    public ReturnMovieOption(ConsoleInputOutput consoleInputOutput, Section section) {
        this.consoleInputOutput = consoleInputOutput;
        this.section = section;
    }

    public void obtainOptionResult(User user) {
        String title = consoleInputOutput.getUserInput();
        String returnMovieStatus = section.returnItem(title, user);
        consoleInputOutput.displayOutputToUser(returnMovieStatus);
    }
}
