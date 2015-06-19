package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;

public class Biblioteca implements Visitable {
    private ConsoleInputOutput consoleInputOutput;
    private MainMenu mainMenu;
    private UserMainMenu userMainMenu;
    private LibrarianMainMenu librarianMainMenu;
    private Login login;

    public Biblioteca(ConsoleInputOutput consoleInputOutput, MainMenu mainMenu, UserMainMenu userMainMenu, LibrarianMainMenu librarianMainMenu, Login login) {
        this.consoleInputOutput = consoleInputOutput;
        this.mainMenu = mainMenu;
        this.userMainMenu = userMainMenu;
        this.librarianMainMenu = librarianMainMenu;
        this.login = login;
    }

    public void start() {
        consoleInputOutput.displayOutputToUser(Messages.WELCOME_MESSAGE);
        User user = new NullUser();
        accept(user);
    }

    @Override
    public void accept(User user) {
        user.visit(mainMenu);
        user.visit(userMainMenu);
        user.visit(librarianMainMenu);
    }
}
