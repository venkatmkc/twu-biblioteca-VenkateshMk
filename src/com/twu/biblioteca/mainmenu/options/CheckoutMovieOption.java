package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class CheckoutMovieOption implements MainMenuAction {
    private ConsoleInputOutput consoleInputOutput;
    private Section section;

    public CheckoutMovieOption(ConsoleInputOutput consoleInputOutput, Section section) {
        this.consoleInputOutput = consoleInputOutput;
        this.section = section;
    }

    @Override
    public void obtainOptionResult(User user) {
        String movieTitle = consoleInputOutput.getUserInput();
        String checkoutStatus = section.checkoutItem(movieTitle, user);
        consoleInputOutput.displayOutputToUser(checkoutStatus);
    }
}
