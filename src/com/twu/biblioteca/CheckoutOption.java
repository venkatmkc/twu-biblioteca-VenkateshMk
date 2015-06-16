package com.twu.biblioteca;

public class CheckoutOption implements MainMenuAction{

    private ConsoleInputOutput consoleInputOutput;;
    private Library library;

    public CheckoutOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
        String returnStatus = library.checkoutBook(bookTitle);
        consoleInputOutput.displayOutputToUser(returnStatus);
    }
}
