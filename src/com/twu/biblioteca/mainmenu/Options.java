package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.mainmenu.options.MainMenuAction;

import java.util.LinkedHashMap;

public class Options {
    private LinkedHashMap<String, MainMenuAction> options;

    public Options(LinkedHashMap<String, MainMenuAction> options) {
        this.options = options;
    }

    public MainMenuAction parseUserInput(String userInput) {
        return options.get(userInput);
    }

    public void addOptions(MenuPresenter menuPresenter) {
        menuPresenter.addMenu(options.keySet());
    }
}
