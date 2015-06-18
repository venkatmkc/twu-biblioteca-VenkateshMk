package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;

public interface Visitor {
    void visit(MainMenu mainMenu);
    void visit(LibrarianMainMenu librarianMainMenu);
}
