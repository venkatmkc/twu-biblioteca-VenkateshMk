package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_LOGIN;

public class Guest extends User {
    public Guest() {
        super("", "", "", "", "");
    }

    public String getLoginMessage() {
        return UNSUCCESSFUL_LOGIN;
    }

    public void visitMenu(MainMenu mainMenu) {
        mainMenu.dispatch(this);
    }

    public void visitMenu(LibrarianMainMenu librarianMainMenu) {
    }

    public void visitMenu(UserMainMenu userMainMenu) {
    }
}
