package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.user.Guest;
import com.twu.biblioteca.user.UserAccounts;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
import com.twu.biblioteca.user.User;

public class LoginOption implements MainMenuAction {

    private UserAccounts userAccounts;
    private UserMainMenu userMainMenu;
    private LibrarianMainMenu librarianMainMenu;
    private ConsoleInputOutput consoleInputOutput;

    public LoginOption(UserAccounts userAccounts, UserMainMenu userMainMenu, LibrarianMainMenu librarianMainMenu, ConsoleInputOutput consoleInputOutput) {
        this.userAccounts = userAccounts;
        this.userMainMenu = userMainMenu;
        this.librarianMainMenu = librarianMainMenu;
        this.consoleInputOutput = consoleInputOutput;
    }

    @Override
    public void obtainOptionResult(User user) {
        user = userAccounts.validate();
        consoleInputOutput.displayOutputToUser(user.getLoginMessage());
        if (user instanceof Guest)
            return;
        consoleInputOutput.displayOutputToUser(user.userInformation());
        user.visitMenu(userMainMenu);
        user.visitMenu(librarianMainMenu);
    }
}
