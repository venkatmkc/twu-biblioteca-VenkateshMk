package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

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
        when(mainMenuOptionParser.parseUserInput("List Library")).
                thenReturn(listBookOption);
    }

    @Test
    public void dispatchShouldGetInputFromUser() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void dispatchShouldParseUserInputToOption() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Library", "Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(mainMenuOptionParser).parseUserInput("List Library");
    }

    @Test
    public void dispatchShouldProduceMainMenuOptionList() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Library", "Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(consoleInputOutput, times(2)).displayOutputToUser(mainMenuOptions);
    }

    @Test
    public void dispatchShouldPerformSelectedOption() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Library", "Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(listBookOption).obtainOptionResult();
    }

    @Test
    public void dispatchShouldProduceInvalidOptionMessageOnInvalidOption() {
        when(consoleInputOutput.getUserInput()).thenReturn("delete", "List Library", "Quit");

        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(consoleInputOutput).displayOutputToUser(Messages.INVALID_MENU_OPTION);
    }

    @Test
    public void dispatchShouldQuitWhenQuitOptionIsSelected() {
        when(consoleInputOutput.getUserInput()).thenReturn("Quit");

        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(mainMenuOptionParser, times(0)).parseUserInput("Quit");
    }
}
