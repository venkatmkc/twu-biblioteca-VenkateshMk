package com.twu.biblioteca;

public class MainMenuToConsole {

    private String mainMenu;

    public MainMenuToConsole(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void displayMainMenu() {
        System.out.println(mainMenu);
    }
}
