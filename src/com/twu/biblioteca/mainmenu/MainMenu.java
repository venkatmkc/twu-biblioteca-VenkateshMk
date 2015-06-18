package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.Visitable;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.user.User;

public class MainMenu implements Visitable{
    private ConsoleInputOutput consoleInputOutput;
    private UserOptions userOptions;
    private MenuPresenter menuPresenter;

    public MainMenu(ConsoleInputOutput consoleInputOutput, UserOptions userOptions, MenuPresenter menuPresenter) {
        this.consoleInputOutput = consoleInputOutput;
        this.userOptions = userOptions;
        this.menuPresenter = menuPresenter;
    }

    public void dispatch(User user) {
        MainMenuAction option;
        do {
            consoleInputOutput.displayOutputToUser(this);
            String userInput = consoleInputOutput.getUserInput();
            if (userInput.equals("Quit"))
                return;
            option = userOptions.parseUserInput(userInput);
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
    public void accept(User user) {
        user.visit(this);
    }

    @Override
    public String toString() {
        menuPresenter.flush();
        userOptions.addOptions(menuPresenter);
        return menuPresenter.toString();
    }
}
