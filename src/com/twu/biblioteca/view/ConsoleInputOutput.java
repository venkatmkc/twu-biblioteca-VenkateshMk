package com.twu.biblioteca.view;

import java.util.Scanner;

public class ConsoleInputOutput {
    private Scanner consoleInput;

    public ConsoleInputOutput(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }

    public String getUserInput() {
        return consoleInput.nextLine();
    }

    public void displayOutputToUser(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }
}
