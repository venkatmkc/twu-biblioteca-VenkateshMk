package com.twu.biblioteca.model;

import com.twu.biblioteca.MainMenuOptionParser;
import com.twu.biblioteca.view.ConsoleInputOutput;
import com.twu.biblioteca.view.ListBooksOption;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MainMenuTest {
    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Mock
    MainMenuOptionParser mainMenuOptionParser;

    @Mock
    MainMenuAction listBookOption;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(consoleInputOutput.getUserInput()).thenReturn("List Books");
        when(mainMenuOptionParser.parseUserInput("List Books")).thenReturn(listBookOption);
    }

    @Test
    public void dispatchShouldGetInputFromUser() {
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void dispatchShouldParseUserInputToOption() {
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(mainMenuOptionParser).parseUserInput("List Books");
    }

    @Test
    public void dispatchShouldProduceMainMenuOptionList() {
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(consoleInputOutput).displayOutputToUser(mainMenuOptions);
    }

    @Test
    public void dispatchShouldPerformSelectedOption() {
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();
        
        verify(listBookOption).obtainOptionResult();
    }
}
