package com.twu.biblioteca;

import com.twu.biblioteca.model.MainMenuAction;

import java.util.HashMap;

public class MainMenuOptionParser {
    private HashMap<String, MainMenuAction> Options;

    public MainMenuOptionParser(HashMap<String, MainMenuAction> Options) {
        this.Options = Options;
    }

    public MainMenuAction parseUserInput(String userInput) {
        return Options.get(userInput);
    }
}
