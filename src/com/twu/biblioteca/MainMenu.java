package com.twu.biblioteca;

import java.util.HashMap;

public class MainMenu {
    MainMenuOptions mainMenuOptions;

    public MainMenu(MainMenuOptions mainMenuOptions) {
        this.mainMenuOptions = mainMenuOptions;
    }

    public String chooseOption(String option) {
        MainMenuAction mainMenuOption = mainMenuOptions.selectOption(option);
        return mainMenuOption.obtainOptionResult();
    }

    public String listOptions() {
        return mainMenuOptions.toString();
    }
}
