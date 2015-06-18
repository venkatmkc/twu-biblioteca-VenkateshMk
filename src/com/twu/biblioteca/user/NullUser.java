package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_LOGIN;

public class NullUser extends User{
    public NullUser() {
        super("111-1111", "letmein", "venkatesh", "", "");
    }

    public String getLoginMessage() {
        return UNSUCCESSFUL_LOGIN;
    }

    public void visit(MainMenu mainMenu) {
    }

    public void visit(LibrarianMainMenu librarianMainMenu){}
}
