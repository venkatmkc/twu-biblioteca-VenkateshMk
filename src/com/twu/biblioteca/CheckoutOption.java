package com.twu.biblioteca;

public class CheckoutOption implements MainMenuAction{

    private ConsoleInputOutput consoleInputOutput;
    private BookParser bookParser;

    public CheckoutOption(ConsoleInputOutput consoleInputOutput, BookParser bookParser) {
        this.consoleInputOutput = consoleInputOutput;
        this.bookParser = bookParser;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
        Book book = bookParser.parseUserInput(bookTitle);
    }
}
