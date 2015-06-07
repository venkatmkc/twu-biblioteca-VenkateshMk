package com.twu.biblioteca;

import org.junit.*;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsoleInputHandlerTest {
    @Test
    public void mainMenuOptionShouldBeObtained() {
        ByteArrayInputStream inputStreamContent = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(inputStreamContent);
        Scanner consoleInput = new Scanner(inputStreamContent);
        ConsoleInputHandler inputHandler = new ConsoleInputHandler(consoleInput);

        String actualOption = inputHandler.getMainMenuOptionFromUser();

        assertThat(actualOption, is(equalTo("List Books")));
    }
}

