package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.mainmenu.options.MainMenuAction;

import java.util.HashMap;

public class UserOptions {
    private HashMap<String, MainMenuAction> options;

    public UserOptions(HashMap<String, MainMenuAction> options) {
        this.options = options;
    }

    public MainMenuAction UserOptions(String userInput) {
        return options.get(userInput);
    }
}
