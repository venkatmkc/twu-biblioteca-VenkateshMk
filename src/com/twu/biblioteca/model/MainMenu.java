package com.twu.biblioteca.model;

import com.twu.biblioteca.MainMenuOptionParser;
import com.twu.biblioteca.view.ConsoleInputOutput;

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
        String option = consoleInputOutput.getUserInput();
    }
}
