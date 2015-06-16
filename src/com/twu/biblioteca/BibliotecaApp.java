package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    public static void main(String []args) {
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        Book bookOne = new AvailableBook("java tutorial", "aravind", "2012");
        Book bookTwo = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookThree = new CheckedOutBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new Movie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new Movie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library);
        HashMap<String, Book> booksTitleToBook = new HashMap<String, Book>();
        booksTitleToBook.put("java tutorial", bookOne);
        booksTitleToBook.put("Kite Runner", bookTwo);
        booksTitleToBook.put("The Sky Is Falling", bookThree);
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, library);
        ReturnOption returnOption = new ReturnOption(consoleInputOutput, library);
        MainMenuAction listMoviesOption = new ListMoviesOption(consoleInputOutput, library);
        HashMap<String, MainMenuAction> options = new HashMap<String, MainMenuAction>();
        options.put("List Books", listBooksOption);
        options.put("Checkout", checkoutOption);
        options.put("Return Book", returnOption);
        options.put("List Movies", listMoviesOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(options);
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        mainMenuOptionsList.add("Checkout");
        mainMenuOptionsList.add("Return Book");
        mainMenuOptionsList.add("List Movies");
        mainMenuOptionsList.add("Quit");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu);
        biblioteca.start();
    }
}