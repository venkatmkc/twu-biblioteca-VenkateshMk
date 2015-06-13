package com.twu.biblioteca;

public class ListBooksOption implements MainMenuAction {
    private ConsoleInputOutput consoleInputOutput;
    private Books books;

    public ListBooksOption(ConsoleInputOutput consoleInputOutput, Books books) {
        this.consoleInputOutput = consoleInputOutput;
        this.books = books;
    }

    @Override
    public void obtainOptionResult() {
        consoleInputOutput.displayOutputToUser(books);
    }
}