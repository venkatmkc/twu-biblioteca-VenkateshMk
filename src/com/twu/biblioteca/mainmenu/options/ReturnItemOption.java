package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class ReturnItemOption implements MainMenuAction {
    private final ConsoleInputOutput consoleInputOutput;
    private final Section section;

    public ReturnItemOption(ConsoleInputOutput consoleInputOutput, Section section) {
        this.consoleInputOutput = consoleInputOutput;
        this.section = section;
    }

    @Override
    public void obtainOptionResult(User user) {
        String bookTitle = consoleInputOutput.getUserInput();
        String returnStatus = section.returnItem(bookTitle, user);
        consoleInputOutput.displayOutputToUser(returnStatus);
    }
}
