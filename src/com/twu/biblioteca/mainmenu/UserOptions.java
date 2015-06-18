package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.mainmenu.options.MainMenuAction;

import java.util.LinkedHashMap;

public class UserOptions{
    private LinkedHashMap<String, MainMenuAction> options;

    public UserOptions(LinkedHashMap<String, MainMenuAction> options) {
        this.options = options;
    }

    public MainMenuAction parseUserInput(String userInput) {
        return options.get(userInput);
    }

    public void addOptions(MenuPresenter menuPresenter) {
        menuPresenter.addMenu(options.keySet());
    }
}
