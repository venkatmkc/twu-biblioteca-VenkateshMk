package com.twu.biblioteca;

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
        boolean isInvalidOption;
        do {
            consoleInputOutput.displayOutputToUser(mainMenuOptions);
            String userInput = consoleInputOutput.getUserInput();
            option = mainMenuOptionParser.parseUserInput(userInput);
            if (checkValidOption(option)) {
                consoleInputOutput.displayOutputToUser(Messages.INVALID_MENU_OPTION);
                isInvalidOption = true;
            } else
                isInvalidOption = false;
        } while (isInvalidOption);
        option.obtainOptionResult();
    }

    private boolean checkValidOption(MainMenuAction option) {
        return option == null;
    }
}
