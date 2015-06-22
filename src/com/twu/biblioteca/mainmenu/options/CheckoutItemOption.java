package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class CheckoutItemOption implements MainMenuAction {

    private ConsoleInputOutput consoleInputOutput;
    private Section section;

    public CheckoutItemOption(ConsoleInputOutput consoleInputOutput, Section section) {
        this.consoleInputOutput = consoleInputOutput;
        this.section = section;
    }

    @Override
    public void obtainOptionResult(User User) {
        String itemTitle = consoleInputOutput.getUserInput();
        String checkoutStatus = section.checkoutItem(itemTitle, User);
        consoleInputOutput.displayOutputToUser(checkoutStatus);
    }
}
