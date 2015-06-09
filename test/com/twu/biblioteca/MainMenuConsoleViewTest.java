package com.twu.biblioteca;

import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class MainMenuConsoleViewTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private MainMenu mainMenu;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mainMenu.listOptions()).
                thenReturn("List Books");
        when(mainMenu.chooseOption("List Books")).
                thenReturn("book List");
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void mainMenuShouldBeDisplayed() {
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);

        mainMenuConsoleView.displayMainMenu();
        String actualMainMenu = outputStreamContent.toString();

        assertThat(actualMainMenu, is(equalTo("List Books\n")));
    }

    @Test
    public void selectedOptionShouldBePerformed() {
        ByteArrayInputStream inputStreamContent = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(inputStreamContent);
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);

        mainMenuConsoleView.performSelectedOption();
        String actualOption = outputStreamContent.toString();

        assertThat(actualOption, is(equalTo("book List\n")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}