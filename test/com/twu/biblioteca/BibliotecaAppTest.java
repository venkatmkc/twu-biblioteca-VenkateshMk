package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Before
    public void setUpOutputStream() {
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.displayWelcomeMessage();
        String actualMessage = outputStreamContent.toString();

        assertThat(actualMessage, is(equalTo("Welcome to Biblioteca!\n")));
    }

    @After
    public void cleanUpOutputStream() {

        System.setOut(null);
    }
}