package com.twu.biblioteca;

public class ReturnMovieOption implements MainMenuAction{
    private final ConsoleInputOutput consoleInputOutput;
    private final Library library;

    public ReturnMovieOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    public void obtainOptionResult() {
        String title = consoleInputOutput.getUserInput();
        String returnMovieStatus = library.returnMovie(title);
    }
}
