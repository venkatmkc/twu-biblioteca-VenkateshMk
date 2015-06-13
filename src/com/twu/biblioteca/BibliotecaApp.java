package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String []args) {
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        Book bookOne = new Book("java tutorial", "aravind", "2012");
        Book bookTwo = new Book("Kite Runner", "Khaled Hosseini", "2003");
        Book bookThree = new Book("The Sky Is Falling", "Sidney Sheldon", "2001");
        HashMap<Book, Boolean> bookList = new HashMap<Book, Boolean>();
        bookList.put(bookOne, true);
        bookList.put(bookTwo, true);
        bookList.put(bookThree, false);
        Books books = new Books(bookList);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, books);
        HashMap<String, Book> booksTitleToBook = new HashMap<String, Book>();
        booksTitleToBook.put("java tutorial", bookOne);
        booksTitleToBook.put("Kite Runner", bookTwo);
        booksTitleToBook.put("The Sky Is Falling", bookThree);
        BookParser bookParser = new BookParser(booksTitleToBook);
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser, books);
        ReturnOption returnOption = new ReturnOption(consoleInputOutput, bookParser, books);
        HashMap<String, MainMenuAction> options = new HashMap<String, MainMenuAction>();
        options.put("List Books", listBooksOption);
        options.put("Checkout", checkoutOption);
        options.put("Return Book", returnOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(options);
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        mainMenuOptionsList.add("Checkout");
        mainMenuOptionsList.add("Return Book");
        mainMenuOptionsList.add("Quit");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu);
        biblioteca.start();
    }
}
