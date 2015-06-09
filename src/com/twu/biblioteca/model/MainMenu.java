package com.twu.biblioteca.model;

public class MainMenu {
    private MainMenuOptions mainMenuOptions;

    public MainMenu(MainMenuOptions mainMenuOptions) {
        this.mainMenuOptions = mainMenuOptions;
    }

    public void chooseOption(String option) {
        MainMenuAction mainMenuOption = mainMenuOptions.selectOption(option);
        mainMenuOption.obtainOptionResult();
    }

    public String listOptions() {
        return mainMenuOptions.toString();
    }
}
