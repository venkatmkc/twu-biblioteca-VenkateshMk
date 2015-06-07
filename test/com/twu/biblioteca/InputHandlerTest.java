package com.twu.biblioteca;

import org.junit.*;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class InputHandlerTest {
    @Test
    public void mainMenuOptionShouldBeObtained() {
        ByteArrayInputStream inputStreamContent = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(inputStreamContent);
        Scanner consoleInput = new Scanner(inputStreamContent);
        InputHandler inputHandler = new InputHandler(consoleInput);

        String actualOption = inputHandler.getMainMenuOptionFromUser();

        assertThat(actualOption, is(equalTo("List Books")));
    }
}

