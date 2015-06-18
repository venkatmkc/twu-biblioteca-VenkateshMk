package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.user.Librarian;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;

public class Biblioteca implements Visitable{
    private ConsoleInputOutput consoleInputOutput;
    private MainMenu mainMenu;
    private LibrarianMainMenu librarianMainMenu;
    private Login login;

    public Biblioteca(ConsoleInputOutput consoleInputOutput, MainMenu mainMenu, LibrarianMainMenu librarianMainMenu, Login login) {
        this.consoleInputOutput = consoleInputOutput;
        this.mainMenu = mainMenu;
        this.librarianMainMenu = librarianMainMenu;
        this.login = login;
    }

    public void start() {
        consoleInputOutput.displayOutputToUser(Messages.WELCOME_MESSAGE);
        User user;
        do {
            user = login.validate();
            consoleInputOutput.displayOutputToUser(user.getLoginMessage());
            accept(user);
        } while (user instanceof NullUser);
    }

    @Override
    public void accept(User user) {
        user.visit(mainMenu);
        user.visit(librarianMainMenu);
    }
}
