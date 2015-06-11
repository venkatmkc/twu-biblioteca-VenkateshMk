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
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        Books books = new Books(bookList);
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, books);
        HashMap<String, MainMenuAction> mainMenuOptions = new HashMap<String, MainMenuAction>();
        mainMenuOptions.put("List Books", listBooksOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(mainMenuOptions);

        MainMenuAction actualMenuOption = mainMenuOptionParser.parseUserInput("List Books");

        assertThat(actualMenuOption, is(listBooksOption));
    }
}
