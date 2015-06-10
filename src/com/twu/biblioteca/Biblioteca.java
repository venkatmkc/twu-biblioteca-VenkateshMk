package com.twu.biblioteca;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.*;

import java.util.*;

public class Biblioteca {
    private WelcomeMessageToConsole welcomeMessageToConsole;
    private MainMenuConsoleView mainMenuConsoleView;

    public Biblioteca(WelcomeMessageToConsole welcomeMessageToConsole, MainMenuConsoleView mainMenuConsoleView) {
        this.welcomeMessageToConsole = welcomeMessageToConsole;
        this.mainMenuConsoleView = mainMenuConsoleView;
    }

    public void start() {
        welcomeMessageToConsole.displayWelcomeMessage();
        mainMenuConsoleView.displayMainMenu();
      //  mainMenuConsoleView.performUserSelectedOption();
    }

    /*public static void main(String []args) {
        WelcomeMessageToConsole welcomeMessageToConsole = new WelcomeMessageToConsole("Welcome to Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);
        Books books = new Books(bookList);
        BooksToConsole booksToConsole = new BooksToConsole(books);
        MainMenuAction mainMenuAction = new ListBooksOption(booksToConsole);
        HashMap<String, MainMenuAction> mainMenuOptionsMap = new HashMap<String, MainMenuAction>();
        mainMenuOptionsMap.put("List Books", mainMenuAction);
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsMap);
        MainMenu mainMenu = new MainMenu(mainMenuOptions);
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);

        Biblioteca biblioteca = new Biblioteca(welcomeMessageToConsole, mainMenuConsoleView);
        biblioteca.start();
    }*/
}
