package com.twu.biblioteca.view;

import com.twu.biblioteca.model.MainMenu;

import java.util.Scanner;

public class MainMenuConsoleView {

    private MainMenu mainMenu;

    public MainMenuConsoleView(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void displayMainMenu() {
        System.out.println(mainMenu.listOptions());
    }

    public void performSelectedOption() {
        Scanner consoleInput = new Scanner(System.in);
        String option = consoleInput.nextLine();
        mainMenu.chooseOption(option);
    }
}
