package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuOptionParserTest {
    @Test
    public void parseUserInputShouldProduceMainMenuOption() {
        Book book = new Book("java tutorial", "aravind", "2012");

        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
        availableBooks.add(book);
        Library library = new Library(availableBooks, checkedoutBooks);
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
