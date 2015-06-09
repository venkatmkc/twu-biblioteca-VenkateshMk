package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenuConsoleView {

    private MainMenu mainMenu;

    public MainMenuConsoleView(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void displayMainMenu() {
        System.out.println(mainMenu.listOptions());
    }

    public String getMainMenuOptionFromUser() {
        Scanner consoleInput = new Scanner(System.in);
        return consoleInput.nextLine();
    }
}
