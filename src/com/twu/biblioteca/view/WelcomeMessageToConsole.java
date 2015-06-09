package com.twu.biblioteca.view;

public class WelcomeMessageToConsole {
    private String welcomeMessage;

    public WelcomeMessageToConsole(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void displayWelcomeMessage() {
        System.out.println(welcomeMessage);
    }
}
