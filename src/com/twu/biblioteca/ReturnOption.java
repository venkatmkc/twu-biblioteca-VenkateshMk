package com.twu.biblioteca;

public class ReturnOption implements MainMenuAction{
    private final ConsoleInputOutput consoleInputOutput;
    private final Library library;

    public ReturnOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
        String returnStatus = library.returnBook(bookTitle);
        consoleInputOutput.displayOutputToUser(returnStatus);
    }
}
