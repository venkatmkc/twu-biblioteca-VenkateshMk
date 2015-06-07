package com.twu.biblioteca;

import java.util.Scanner;

public class InputHandler {
    private Scanner consoleInput;

    public InputHandler(Scanner consoleInput) {
        this.consoleInput = consoleInput;
    }
    public String getMainMenuOptionFromUser() {
        return consoleInput.nextLine();
    }
}
