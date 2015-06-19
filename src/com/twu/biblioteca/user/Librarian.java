package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;

public class Librarian extends User {


    public Librarian(String libraryNumber, String password, String name, String email, String phoneNumber) {
        super(libraryNumber, password, name, email, phoneNumber);
    }

    @Override
    public void visit(UserMainMenu userMainMenu) {
    }

    @Override
    public void visit(LibrarianMainMenu librarianMainMenu) {
        librarianMainMenu.dispatch(this);
    }

    @Override
    public void visit(MainMenu mainMenu) {}
}
