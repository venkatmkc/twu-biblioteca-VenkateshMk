package com.twu.biblioteca;

import com.twu.biblioteca.model.MainMenuAction;

import java.util.HashMap;

public class MainMenuOptionParser {
    private HashMap<String, MainMenuAction> mainMenuOptions;

    public MainMenuOptionParser(HashMap<String, MainMenuAction> mainMenuOptions) {
        this.mainMenuOptions = mainMenuOptions;
    }

    public MainMenuAction parseUserInput(String userInput) {
        return mainMenuOptions.get(userInput);
    }
}
