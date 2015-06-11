package com.twu.biblioteca.model;

import com.twu.biblioteca.MainMenuOptionParser;
import com.twu.biblioteca.view.ConsoleInputOutput;
import com.twu.biblioteca.view.ListBooksOption;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MainMenuTest {
    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Mock
    MainMenuOptionParser mainMenuOptionParser;

    @Mock
    MainMenuOptions mainMenuOptions;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(consoleInputOutput.getUserInput()).thenReturn("List Books");
    }

    @Test
    public void dispatchShouldGetInputFromUser() {
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void dispatchShouldParseUserInputToOption() {
        MainMenu mainMenu = new MainMenu(consoleInputOutput, mainMenuOptionParser, mainMenuOptions);

        mainMenu.dispatch();

        verify(mainMenuOptionParser).parseUserInput("List Books");
    }
}
