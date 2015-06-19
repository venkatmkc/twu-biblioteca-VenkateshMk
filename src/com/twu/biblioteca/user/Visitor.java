package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;

public interface Visitor {
    void visit(UserMainMenu userMainMenu);
    void visit(LibrarianMainMenu librarianMainMenu);
    void visit(MainMenu mainMenu);
}
