package com.twu.biblioteca;

import java.util.HashMap;

public class MainMenu {
    HashMap<String, MainMenuAction> mainMenuOptions;

    public MainMenu(HashMap<String, MainMenuAction> mainMenuOptions) {
        this.mainMenuOptions = mainMenuOptions;
    }

    public void chooseOption() {
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView("List Options");
        String option = mainMenuConsoleView.getMainMenuOptionFromUser();
        mainMenuOptions.get(option).obtainOptionResult();
    }
}
