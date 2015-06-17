package com.twu.biblioteca.io;

import java.util.Scanner;

public class ConsoleInputOutput {
    private Scanner consoleInput;

    public ConsoleInputOutput(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }

    public String getUserInput() {
        return consoleInput.nextLine();
    }

    public void displayOutputToUser(Object output) {
        System.out.println(output);
    }
}
