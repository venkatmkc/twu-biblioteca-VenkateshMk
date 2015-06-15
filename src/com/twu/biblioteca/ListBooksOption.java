package com.twu.biblioteca;

public class ListBooksOption implements MainMenuAction {
    private ConsoleInputOutput consoleInputOutput;
    private Library library;

    public ListBooksOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult() {
        consoleInputOutput.displayOutputToUser(library);
    }
}
