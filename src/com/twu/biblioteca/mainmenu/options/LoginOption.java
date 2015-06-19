package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Login;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;

public class LoginOption implements MainMenuAction {

    private Login login;
    private UserMainMenu userMainMenu;
    private LibrarianMainMenu librarianMainMenu;
    private ConsoleInputOutput consoleInputOutput;

    public LoginOption(Login login,UserMainMenu userMainMenu, LibrarianMainMenu librarianMainMenu,ConsoleInputOutput consoleInputOutput) {
        this.login = login;
        this.userMainMenu = userMainMenu;
        this.librarianMainMenu = librarianMainMenu;
        this.consoleInputOutput = consoleInputOutput;
    }

    @Override
    public void obtainOptionResult(User user) {
        user = login.validate();
        consoleInputOutput.displayOutputToUser(user.getLoginMessage());
        if(user instanceof NullUser)
            return;
        user.visit(userMainMenu);
        user.visit(librarianMainMenu);
    }
}
