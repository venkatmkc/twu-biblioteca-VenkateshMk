package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.Visitable;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.user.User;

public class MainMenu implements Visitable{
    private ConsoleInputOutput consoleInputOutput;
    private MainMenuOptionParser mainMenuOptionParser;
    private MainMenuOptions mainMenuOptions;

    public MainMenu(ConsoleInputOutput consoleInputOutput, MainMenuOptionParser mainMenuOptionParser, MainMenuOptions mainMenuOptions) {
        this.consoleInputOutput = consoleInputOutput;
        this.mainMenuOptionParser = mainMenuOptionParser;
        this.mainMenuOptions = mainMenuOptions;
    }

    public void dispatch(User user) {
        MainMenuAction option;
        do {
            consoleInputOutput.displayOutputToUser(mainMenuOptions);
            String userInput = consoleInputOutput.getUserInput();
            if (userInput.equals("Quit"))
                return;
            option = mainMenuOptionParser.parseUserInput(userInput);
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
}
