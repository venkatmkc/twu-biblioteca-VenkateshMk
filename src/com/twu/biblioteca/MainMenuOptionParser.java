package com.twu.biblioteca;

import java.util.HashMap;

public class MainMenuOptionParser {
    private HashMap<String, MainMenuAction> option;

    public MainMenuOptionParser(HashMap<String, MainMenuAction> option) {
        this.option = option;
    }

    public MainMenuAction parseUserInput(String userInput) {
        return option.get(userInput);
    }
}
