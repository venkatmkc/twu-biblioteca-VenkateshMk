package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.user.User;

public class CheckoutBookOption implements MainMenuAction {

    private ConsoleInputOutput consoleInputOutput;;
    private Library library;

    public CheckoutBookOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult(User user) {
        String bookTitle = consoleInputOutput.getUserInput();
        String returnStatus = library.checkoutBook(bookTitle, user);
        consoleInputOutput.displayOutputToUser(returnStatus);
    }
}
