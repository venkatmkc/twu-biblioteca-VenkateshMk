package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;

public class Librarian extends User {


    public Librarian(String libraryNumber, String password, String name, String email, String phoneNumber) {
        super(libraryNumber, password, name, email, phoneNumber);
    }

    @Override
    public void visit(MainMenu mainMenu) {
    }

    @Override
    public void visit(LibrarianMainMenu librarianMainMenu) {
        librarianMainMenu.dispatch(this);
    }
}
