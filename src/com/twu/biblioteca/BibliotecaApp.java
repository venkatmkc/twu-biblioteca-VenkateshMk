package com.twu.biblioteca;

import com.twu.biblioteca.*;
import com.twu.biblioteca.ConsoleInputOutput;
import com.twu.biblioteca.ListBooksOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String []args) {
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        Book book = new Book("java tutorial", "aravind", "2012");
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        bookList.put(book, true);
        Books books = new Books(bookList);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, books);
        HashMap<String, MainMenuAction> options = new HashMap<String, MainMenuAction>();
        options.put("List Books", listBooksOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(options);
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        mainMenuOptionsList.add("Quit");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu);
        biblioteca.start();
    }
}
