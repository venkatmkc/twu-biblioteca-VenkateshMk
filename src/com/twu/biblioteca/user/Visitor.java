package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;

public interface Visitor {
    void visitMenu(UserMainMenu userMainMenu);

    void visitMenu(LibrarianMainMenu librarianMainMenu);

    void visitMenu(MainMenu mainMenu);
}
