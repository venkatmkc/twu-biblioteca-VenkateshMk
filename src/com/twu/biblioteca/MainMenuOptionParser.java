package com.twu.biblioteca;

import com.twu.biblioteca.model.MainMenuAction;

import java.util.HashMap;

public class MainMenuOptionParser {
    private HashMap<Integer, MainMenuAction> mainMenuOptions;

    public MainMenuOptionParser(HashMap<Integer, MainMenuAction> mainMenuOptions) {
        this.mainMenuOptions = mainMenuOptions;
    }

    public MainMenuAction parseUserInput(Integer userInput) {
        return mainMenuOptions.get(userInput);
    }
}
