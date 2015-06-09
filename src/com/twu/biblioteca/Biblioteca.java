package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    public static void main(String args[]) {
        WelcomeMessageToConsole welcomeMessageToConsole = new WelcomeMessageToConsole("Welcome to Biblioteca");
        welcomeMessageToConsole.displayWelcomeMessage();
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);
        Books books = new Books(bookList);
        MainMenuAction mainMenuAction = new ListBooksOption(books);
        HashMap<String, MainMenuAction> mainMenuOptionsMap = new HashMap<String, MainMenuAction>();
        mainMenuOptionsMap.put("List Books", mainMenuAction);
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsMap);
        MainMenu mainMenu = new MainMenu(mainMenuOptions);
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);
        mainMenuConsoleView.displayMainMenu();
        mainMenuConsoleView.performSelectedOption();
    }
}
