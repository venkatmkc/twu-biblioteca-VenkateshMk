package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.user.User;

public class LibrarianMainMenu extends UserMainMenu {
    public static final String LOGOUT = "9";

    public LibrarianMainMenu(ConsoleInputOutput consoleInputOutput, Options options, MenuPresenter menuPresenter) {
        super(consoleInputOutput, options, menuPresenter);
    }

    public void dispatch(User user) {
        MainMenuAction option;
        do {
            consoleInputOutput.displayOutputToUser(this);
            consoleInputOutput.displayOutputToUser(Messages.MENU_CHOICE);
            String userInput = consoleInputOutput.getUserInput();
            if (userInput.equals(LOGOUT))
                return;
            option = options.parseUserInput(userInput);
            if (checkValidOption(option)) {
                consoleInputOutput.displayOutputToUser(Messages.INVALID_MENU_OPTION);
            } else
                option.obtainOptionResult(user);
        } while (true);
    }

    private boolean checkValidOption(MainMenuAction option) {
        return option == null;
    }


}
