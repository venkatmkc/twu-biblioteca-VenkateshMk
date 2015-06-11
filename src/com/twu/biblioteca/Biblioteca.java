package com.twu.biblioteca;

import com.twu.biblioteca.view.ConsoleInputOutput;
import com.twu.biblioteca.view.Messages;

public class Biblioteca {
    private ConsoleInputOutput consoleInputOutput;

    public Biblioteca(ConsoleInputOutput consoleInputOutput) {
        this.consoleInputOutput = consoleInputOutput;
    }

    public void start() {
        consoleInputOutput.displayOutputToUser(Messages.WELCOME_MESSAGE);
    }
}
