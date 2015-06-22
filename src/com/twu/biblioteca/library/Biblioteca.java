package com.twu.biblioteca.library;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
import com.twu.biblioteca.mainmenu.Visitable;
import com.twu.biblioteca.user.Guest;
import com.twu.biblioteca.user.User;

public class Biblioteca implements Visitable {
    private ConsoleInputOutput consoleInputOutput;
    private MainMenu mainMenu;
    private UserMainMenu userMainMenu;
    private LibrarianMainMenu librarianMainMenu;

    public Biblioteca(ConsoleInputOutput consoleInputOutput, MainMenu mainMenu, UserMainMenu userMainMenu, LibrarianMainMenu librarianMainMenu) {
        this.consoleInputOutput = consoleInputOutput;
        this.mainMenu = mainMenu;
        this.userMainMenu = userMainMenu;
        this.librarianMainMenu = librarianMainMenu;
    }

    public void start() {
        consoleInputOutput.displayOutputToUser(Messages.WELCOME_MESSAGE);
        User user = new Guest();
        accept(user);
    }

    @Override
    public void accept(User user) {
        user.visitMenu(mainMenu);
        user.visitMenu(userMainMenu);
        user.visitMenu(librarianMainMenu);
    }
}
