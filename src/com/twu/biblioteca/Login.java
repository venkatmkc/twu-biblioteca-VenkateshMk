package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;

import java.util.HashSet;

public class Login {
    private HashSet<User> users;
    private ConsoleInputOutput consoleInputOutput;

    public Login(HashSet<User> users, ConsoleInputOutput consoleInputOutput) {
        this.users = users;
        this.consoleInputOutput = consoleInputOutput;
    }

    public void validate() {
        String libraryNumber = consoleInputOutput.getUserInput();
        String password = consoleInputOutput.getUserInput();
    }
}
