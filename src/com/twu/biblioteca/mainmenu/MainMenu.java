package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;

public class MainMenu {
    private ConsoleInputOutput consoleInputOutput;
    private MainMenuOptionParser mainMenuOptionParser;
    private MainMenuOptions mainMenuOptions;

    public MainMenu(ConsoleInputOutput consoleInputOutput, MainMenuOptionParser mainMenuOptionParser, MainMenuOptions mainMenuOptions) {
        this.consoleInputOutput = consoleInputOutput;
        this.mainMenuOptionParser = mainMenuOptionParser;
        this.mainMenuOptions = mainMenuOptions;
    }

    public void dispatch() {
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
                option.obtainOptionResult();
        } while (true);
    }

    private boolean checkValidOption(MainMenuAction option) {
        return option == null;
    }
}
