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
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        checkedoutBooks.add(bookThree);
        Library library = new Library(availableBooks, checkedoutBooks);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library);
        HashMap<String, Book> booksTitleToBook = new HashMap<String, Book>();
        booksTitleToBook.put("java tutorial", bookOne);
        booksTitleToBook.put("Kite Runner", bookTwo);
        booksTitleToBook.put("The Sky Is Falling", bookThree);
        BookParser bookParser = new BookParser(booksTitleToBook);
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser, library);
        ReturnOption returnOption = new ReturnOption(consoleInputOutput, bookParser, library);
        HashMap<String, MainMenuAction> options = new HashMap<String, MainMenuAction>();
        options.put("List Library", listBooksOption);
        options.put("Checkout", checkoutOption);
        options.put("Return Book", returnOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(options);
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        mainMenuOptionsList.add("Checkout");
        mainMenuOptionsList.add("Return Book");
        mainMenuOptionsList.add("Quit");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu);
        biblioteca.start();
    }
}