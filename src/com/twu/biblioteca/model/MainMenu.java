package com.twu.biblioteca.model;

public class MainMenu {
    private MainMenuOptions mainMenuOptions;

    public MainMenu(MainMenuOptions mainMenuOptions) {
        this.mainMenuOptions = mainMenuOptions;
    }

    public MainMenuAction chooseOption(String option) {
        return mainMenuOptions.selectOption(option);
    }

    public void performSelectedOption(MainMenuAction mainMenuAction) {
        mainMenuAction.obtainOptionResult();
    }

    public String listOptions() {
        return mainMenuOptions.toString();
    }
}
