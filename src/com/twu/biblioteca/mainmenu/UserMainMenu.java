package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.user.User;

public class UserMainMenu extends MainMenu{

    public UserMainMenu(ConsoleInputOutput consoleInputOutput, UserOptions options, MenuPresenter menuPresenter) {
        super(consoleInputOutput, options, menuPresenter);
    }
}
