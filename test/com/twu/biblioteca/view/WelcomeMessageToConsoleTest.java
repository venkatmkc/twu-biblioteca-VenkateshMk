package com.twu.biblioteca.view;

import org.junit.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class WelcomeMessageToConsoleTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
    private String welcomeMessage = new String("Welcome to Biblioteca!");

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        WelcomeMessageToConsole welcomeMessageToConsole = new WelcomeMessageToConsole(welcomeMessage);

        welcomeMessageToConsole.displayWelcomeMessage();
        String actualMessage = outputStreamContent.toString();

        assertThat(actualMessage, is(equalTo("Welcome to Biblioteca!\n")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}