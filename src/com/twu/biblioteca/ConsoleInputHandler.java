package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleInputHandler {
    private Scanner consoleInput;

    public ConsoleInputHandler(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }

    public String getMainMenuOptionFromUser() {
        return consoleInput.nextLine();
    }
}
