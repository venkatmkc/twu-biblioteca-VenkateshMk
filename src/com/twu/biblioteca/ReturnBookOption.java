package com.twu.biblioteca;

public class ReturnBookOption implements MainMenuAction{
    private final ConsoleInputOutput consoleInputOutput;
    private final Library library;

    public ReturnBookOption(ConsoleInputOutput consoleInputOutput, Library library) {
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
