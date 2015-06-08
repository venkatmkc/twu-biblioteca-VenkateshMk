package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenuConsoleView {

    private String mainMenu;

    public MainMenuConsoleView(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void displayMainMenu() {
        System.out.println(mainMenu);
    }

    public String getMainMenuOptionFromUser() {
        Scanner consoleInput = new Scanner(System.in);
        return consoleInput.nextLine();
    }
}
