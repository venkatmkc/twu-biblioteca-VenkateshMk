package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_LOGIN;

public class NullUser extends User{
    public NullUser() {
        super("", "", "", "", "");
    }

    public String getLoginMessage() {
        return UNSUCCESSFUL_LOGIN;
    }

    public void visit(MainMenu mainMenu) {
        mainMenu.dispatch(this);
    }

    public void visit(LibrarianMainMenu librarianMainMenu){}

    public void visit(UserMainMenu userMainMenu) {}
}
