package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ConsoleOutputHandlerTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
    private String welcomeMessage = new String("Welcome to Biblioteca!");

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler(welcomeMessage);

        consoleOutputHandler.displayWelcomeMessage();
        String actualMessage = outputStreamContent.toString();

        assertThat(actualMessage, is(equalTo("Welcome to Biblioteca!\n")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}