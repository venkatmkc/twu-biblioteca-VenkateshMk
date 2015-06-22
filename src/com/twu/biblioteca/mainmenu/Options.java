package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.mainmenu.options.MainMenuAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Options {
    private LinkedHashMap<String, MainMenuAction> options;

    public Options(LinkedHashMap<String, MainMenuAction> options) {
        this.options = options;
    }

    public MainMenuAction parseUserInput(String userInput) {
        List<MainMenuAction> optionList = new ArrayList<MainMenuAction>(options.values());
        try {
            return optionList.get(parseInt(userInput) - 1);
        } catch (Exception parseException) {
            return null;
        }
    }

    public void addOptions(MenuPresenter menuPresenter) {
        menuPresenter.addMenu(options.keySet());
    }
}
