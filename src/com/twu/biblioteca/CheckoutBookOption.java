package com.twu.biblioteca;

public class CheckoutBookOption implements MainMenuAction{

    private ConsoleInputOutput consoleInputOutput;;
    private Library library;

    public CheckoutBookOption(ConsoleInputOutput consoleInputOutput, Library library) {
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
