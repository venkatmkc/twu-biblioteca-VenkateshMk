package com.twu.biblioteca;

public class CheckoutOption implements MainMenuAction{

    private ConsoleInputOutput consoleInputOutput;

    public CheckoutOption(ConsoleInputOutput consoleInputOutput) {
        this.consoleInputOutput = consoleInputOutput;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
    }
}
