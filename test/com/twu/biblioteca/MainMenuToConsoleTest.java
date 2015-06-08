package com.twu.biblioteca;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainMenuToConsoleTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
    private String mainMenu = new String("List Books");

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void mainMenuShouldBeDisplayed() {
        MainMenuToConsole mainMenuToConsole = new MainMenuToConsole(mainMenu);

        mainMenuToConsole.displayMainMenu();
        String actualMainMenu = outputStreamContent.toString();

        assertThat(actualMainMenu, is(equalTo("List Books\n")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
