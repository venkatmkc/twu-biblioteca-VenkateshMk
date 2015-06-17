package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.mainmenu.options.MainMenuAction;

import java.util.HashMap;

public class MainMenuOptionParser {
    private HashMap<String, MainMenuAction> options;

    public MainMenuOptionParser(HashMap<String, MainMenuAction> options) {
        this.options = options;
    }

    public MainMenuAction parseUserInput(String userInput) {
        return options.get(userInput);
    }
}
