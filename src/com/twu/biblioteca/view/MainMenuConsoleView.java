package com.twu.biblioteca.view;

import com.twu.biblioteca.model.MainMenu;
import com.twu.biblioteca.model.MainMenuAction;

import java.util.Scanner;

public class MainMenuConsoleView {

    private MainMenu mainMenu;

    public MainMenuConsoleView(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void displayMainMenu() {
        System.out.println(mainMenu.listOptions());
    }

    public void performUserSelectedOption() {
        boolean invalidOption = true;
        MainMenuAction mainMenuAction = null;
        String option;
        Scanner consoleInput = new Scanner(System.in);
        while (invalidOption) {
            option = consoleInput.nextLine();
            mainMenuAction = mainMenu.chooseOption(option);
            if (mainMenuAction == null) {
                System.out.println(Messages.INVALID_MENU_OPTION);
            } else {
                invalidOption = false;
            }
        }
        mainMenu.performSelectedOption(mainMenuAction);
    }

}
