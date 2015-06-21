package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.user.User;

public class MainMenu {
    protected ConsoleInputOutput consoleInputOutput;
    protected Options options;
    protected MenuPresenter menuPresenter;

    public MainMenu(ConsoleInputOutput consoleInputOutput, Options options, MenuPresenter menuPresenter) {
        this.consoleInputOutput = consoleInputOutput;
        this.options = options;
        this.menuPresenter = menuPresenter;
    }

    public void dispatch(User user) {
        MainMenuAction option;
        do {
            consoleInputOutput.displayOutputToUser(this);
            consoleInputOutput.displayOutputToUser(Messages.MENU_CHOICE);
            String userInput = consoleInputOutput.getUserInput();
            if (userInput.equals("4"))
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

    @Override
    public String toString() {
        menuPresenter.flush();
        options.addOptions(menuPresenter);
        return menuPresenter.toString();
    }
}
