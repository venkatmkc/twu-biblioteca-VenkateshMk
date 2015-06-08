package com.twu.biblioteca;

import org.hamcrest.MatcherAssert;
import org.junit.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MainMenuConsoleViewTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
    private String mainMenu = new String("List Books");

    @Before
    public void setUp() {
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
    public void mainMenuOptionShouldBeObtained() {
        ByteArrayInputStream inputStreamContent = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(inputStreamContent);
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);

        String actualOption = mainMenuConsoleView.getMainMenuOptionFromUser();

        MatcherAssert.assertThat(actualOption, is(equalTo("List Books")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
