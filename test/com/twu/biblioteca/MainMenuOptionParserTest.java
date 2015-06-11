package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Books;
import com.twu.biblioteca.model.MainMenuAction;
import com.twu.biblioteca.view.ConsoleInputOutput;
import com.twu.biblioteca.view.ListBooksOption;
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
        HashMap<Integer, MainMenuAction> mainMenuOptions = new HashMap<Integer, MainMenuAction>();
        mainMenuOptions.put(1, listBooksOption);
        MainMenuOptionParser mainMenuOptionParser = new MainMenuOptionParser(mainMenuOptions);

        MainMenuAction actualMenuOption = mainMenuOptionParser.parseUserInput(1);

        assertThat(actualMenuOption, is(listBooksOption));
    }
}
