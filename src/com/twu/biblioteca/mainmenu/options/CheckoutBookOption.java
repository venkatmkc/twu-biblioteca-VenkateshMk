package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class CheckoutBookOption implements MainMenuAction {

    private ConsoleInputOutput consoleInputOutput;;
    private Section section;

    public CheckoutBookOption(ConsoleInputOutput consoleInputOutput, Section section) {
        this.consoleInputOutput = consoleInputOutput;
        this.section = section;
    }

    @Override
    public void obtainOptionResult(User User) {
        String bookTitle = consoleInputOutput.getUserInput();
        String checkoutStatus = section.checkoutItem(bookTitle, User);
        consoleInputOutput.displayOutputToUser(checkoutStatus);
    }
}
