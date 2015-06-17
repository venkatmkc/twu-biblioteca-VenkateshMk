package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;

public class Biblioteca {
    private ConsoleInputOutput consoleInputOutput;
    private MainMenu mainMenu;
    private Login login;

    public Biblioteca(ConsoleInputOutput consoleInputOutput, MainMenu mainMenu, Login login) {
        this.consoleInputOutput = consoleInputOutput;
        this.mainMenu = mainMenu;
        this.login = login;
    }

    public void start() {
        consoleInputOutput.displayOutputToUser(Messages.WELCOME_MESSAGE);
        User user;
        do {
            user = login.validate();
            consoleInputOutput.displayOutputToUser(user.getLoginMessage());
            mainMenu.accept(user);
        } while (user instanceof NullUser);
//        mainMenu.dispatch();
    }
}
