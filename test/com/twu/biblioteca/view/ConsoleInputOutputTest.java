package com.twu.biblioteca.view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConsoleInputOutputTest {
    @Test
    public void inputShouldBeObtainedFromTheUser() {
        ByteArrayInputStream inputStreamContent = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(inputStreamContent);
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);

        String actualUserInput = consoleInputOutput.getUserInput();

        assertThat(actualUserInput, is("List Books"));
    }
}
