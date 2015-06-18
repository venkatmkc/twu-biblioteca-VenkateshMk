package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.user.User;

public class CheckoutMovieOption implements MainMenuAction {
    private ConsoleInputOutput consoleInputOutput;
    private Library library;

    public CheckoutMovieOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult(User user) {
        String movieTitle = consoleInputOutput.getUserInput();
        String checkoutStatus = library.checkoutMovie(movieTitle);
        consoleInputOutput.displayOutputToUser(checkoutStatus);
    }
}
