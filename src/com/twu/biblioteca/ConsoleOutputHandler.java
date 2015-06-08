package com.twu.biblioteca;

public class ConsoleOutputHandler {
    private String welcomeMessage;

    public ConsoleOutputHandler(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void displayWelcomeMessage() {
        System.out.println(welcomeMessage);
    }
}
