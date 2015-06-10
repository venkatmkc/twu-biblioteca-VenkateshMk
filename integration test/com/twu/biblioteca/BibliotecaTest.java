package com.twu.biblioteca;

import com.twu.biblioteca.view.MainMenuConsoleView;
import com.twu.biblioteca.view.WelcomeMessageToConsole;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class BibliotecaTest {
    @Mock
    private WelcomeMessageToConsole welcomeMessageToConsole;

    @Mock
    private MainMenuConsoleView mainMenuConsoleView;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void startShouldProduceBibliotecaFunctions() {
        Biblioteca biblioteca = new Biblioteca(welcomeMessageToConsole, mainMenuConsoleView);

        biblioteca.start();

        verify(welcomeMessageToConsole).displayWelcomeMessage();
        verify(mainMenuConsoleView).displayMainMenu();
        verify(mainMenuConsoleView).performSelectedOption();
    }
}
