package com.twu.biblioteca;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuOptionParserTest {
    @Test
    public void parseUserInputShouldProduceMainMenuOption() {
        Book book = new AvailableBook("java tutorial", "aravind", "2012");

        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        books.add(book);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library);
        HashMap<String, MainMenuAction> mainMenuOptions = new HashMap<String, MainMenuAction>();
        mainMenuOptions.put("List Library", listBooksOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(mainMenuOptions);

        MainMenuAction actualMenuOption = mainMenuOptionParser.parseUserInput("List Library");

        assertThat(actualMenuOption, is(listBooksOption));
    }
}
