package com.twu.biblioteca;

import com.twu.biblioteca.item.book.*;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.library.Biblioteca;
import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.mainmenu.*;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
import com.twu.biblioteca.mainmenu.options.*;
import com.twu.biblioteca.item.movie.AvailableMovie;
import com.twu.biblioteca.item.movie.CheckedOutMovie;
import com.twu.biblioteca.item.movie.Movie;
import com.twu.biblioteca.user.Librarian;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserAccounts;

import java.util.*;

public class EntryPoint {
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);

        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");
        User userTwo = new User("222-2222", "logmein", "chip", "abc@def.com", "9989898989");
        User librarian = new Librarian("333-3333", "superuser", "superman", "super@super.com", "77777777777");
        users.add(userOne);
        users.add(userTwo);
        users.add(librarian);
        UserAccounts userAccounts = new UserAccounts(users, consoleInputOutput);

        Book bookOne = new AvailableBook("java tutorial", "venkatesh", "2012");
        Book bookTwo = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookThree = new CheckedOutBook("The Sky Is Falling", "Sidney Sheldon", "2001", userOne);
        Book bookFour = new AvailableBook("Outliers", "Marrisa Meyer", "2007");
        Book bookFive = new CheckedOutBook("Harry potter", "JK Rowling", "2002", librarian);
        LinkedHashSet<BorrowableItem> books = new LinkedHashSet<BorrowableItem>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        books.add(bookFour);
        books.add(bookFive);

        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie("Following", "1998", "Christopher Nolan", "unrated");
        Movie movieThree = new CheckedOutMovie("Goodfellas", "1995", "Quentin Tarantino", "unrated", userTwo);
        movies.add(movieOne);
        movies.add(movieTwo);
        movies.add(movieThree);

        Section bookSection = new Section(books);

        Section movieSection = new Section(movies);

        MainMenuAction listBooksOption = new ListItemsOption(consoleInputOutput, bookSection);

        CheckoutItemOption checkoutBookOption = new CheckoutItemOption(consoleInputOutput, bookSection);

        ReturnItemOption returnItemOption = new ReturnItemOption(consoleInputOutput, bookSection);

        MainMenuAction listMoviesOption = new ListItemsOption(consoleInputOutput, movieSection);

        CheckoutItemOption checkoutMovieOption = new CheckoutItemOption(consoleInputOutput, movieSection);

        ReturnItemOption returnMovieOption = new ReturnItemOption(consoleInputOutput, movieSection);

        LinkedHashMap<String, MainMenuAction> options = new LinkedHashMap<String, MainMenuAction>();
        options.put("List Books", listBooksOption);
        options.put("Checkout Book", checkoutBookOption);
        options.put("Return Book", returnItemOption);
        options.put("List Movies", listMoviesOption);
        options.put("Checkout Movie", checkoutMovieOption);
        options.put("Return Movie", returnMovieOption);
        options.put("Logout", null);
        Options userOptions = new Options(options);

        LinkedHashMap<String, MainMenuAction> librarianOptionsList = new LinkedHashMap<String, MainMenuAction>();

        MainMenuAction checkedOutBooksOption = new ListCheckedOutItemsOption(consoleInputOutput, bookSection);

        MainMenuAction checkedOutMoviesOption = new ListCheckedOutItemsOption(consoleInputOutput, movieSection);

        librarianOptionsList.put("CheckedOut Books", checkedOutBooksOption);
        librarianOptionsList.put("CheckedOut Movies", checkedOutMoviesOption);
        librarianOptionsList.put("List Books", listBooksOption);
        librarianOptionsList.put("Checkout Book", checkoutBookOption);
        librarianOptionsList.put("Return Book", returnItemOption);
        librarianOptionsList.put("List Movies", listMoviesOption);
        librarianOptionsList.put("Checkout Movie", checkoutMovieOption);
        librarianOptionsList.put("Return Movie", returnMovieOption);
        librarianOptionsList.put("Logout", null);

        MenuPresenter menuPresenter = new MenuPresenter("");
        Options librarianOptions = new Options(librarianOptionsList);
        UserMainMenu userMainMenu = new UserMainMenu(consoleInputOutput, userOptions, menuPresenter);
        LibrarianMainMenu librarianMainMenu = new LibrarianMainMenu(consoleInputOutput, librarianOptions, menuPresenter);
        LinkedHashMap<String, MainMenuAction> guestOptionsList = new LinkedHashMap<String, MainMenuAction>();
        LoginOption loginOption = new LoginOption(userAccounts, userMainMenu, librarianMainMenu, consoleInputOutput);

        guestOptionsList.put("List Books", listBooksOption);
        guestOptionsList.put("List Movies", listMoviesOption);
        guestOptionsList.put("Login", loginOption);
        guestOptionsList.put("Quit", null);
        Options guestOptions = new Options(guestOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, guestOptions, menuPresenter);

        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu, userMainMenu, librarianMainMenu);
        biblioteca.start();
    }
}