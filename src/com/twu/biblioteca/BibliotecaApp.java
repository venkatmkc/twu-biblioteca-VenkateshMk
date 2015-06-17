package com.twu.biblioteca;

import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.CheckedOutBook;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.MainMenuOptionParser;
import com.twu.biblioteca.mainmenu.MainMenuOptions;
import com.twu.biblioteca.mainmenu.options.*;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.user.User;

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
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library);
        HashMap<String, Book> booksTitleToBook = new HashMap<String, Book>();
        booksTitleToBook.put("java tutorial", bookOne);
        booksTitleToBook.put("Kite Runner", bookTwo);
        booksTitleToBook.put("The Sky Is Falling", bookThree);
        CheckoutBookOption checkoutBookOption = new CheckoutBookOption(consoleInputOutput, library);
        ReturnBookOption returnBookOption = new ReturnBookOption(consoleInputOutput, library);
        MainMenuAction listMoviesOption = new ListMoviesOption(consoleInputOutput, library);
        CheckoutMovieOption checkoutMovieOption = new CheckoutMovieOption(consoleInputOutput, library);
        ReturnMovieOption returnMovieOption = new ReturnMovieOption(consoleInputOutput, library);
        HashMap<String, MainMenuAction> options = new HashMap<String, MainMenuAction>();
        options.put("List Books", listBooksOption);
        options.put("Checkout Book", checkoutBookOption);
        options.put("Return Book", returnBookOption);
        options.put("List Movies", listMoviesOption);
        options.put("Checkout Movie", checkoutMovieOption);
        options.put("Return Movie", returnMovieOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(options);
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        mainMenuOptionsList.add("Checkout Book");
        mainMenuOptionsList.add("Return Book");
        mainMenuOptionsList.add("List Movies");
        mainMenuOptionsList.add("Checkout Movie");
        mainMenuOptionsList.add("Return Movie");
        mainMenuOptionsList.add("Quit");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);
        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-0000", "biblioteca");
        User userTwo = new User("222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users, consoleInputOutput);
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu, login);
        biblioteca.start();
    }
}