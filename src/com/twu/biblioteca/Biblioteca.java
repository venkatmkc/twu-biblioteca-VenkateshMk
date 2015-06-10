package com.twu.biblioteca;

import com.twu.biblioteca.view.MainMenuConsoleView;
import com.twu.biblioteca.view.WelcomeMessageToConsole;

public class Biblioteca {
    private WelcomeMessageToConsole welcomeMessageToConsole;
    private MainMenuConsoleView mainMenuConsoleView;

    public Biblioteca(WelcomeMessageToConsole welcomeMessageToConsole, MainMenuConsoleView mainMenuConsoleView) {
        this.welcomeMessageToConsole = welcomeMessageToConsole;
        this.mainMenuConsoleView = mainMenuConsoleView;
    }

    public void start() {
        welcomeMessageToConsole.displayWelcomeMessage();
        mainMenuConsoleView.displayMainMenu();
        mainMenuConsoleView.performSelectedOption();
    }
}
