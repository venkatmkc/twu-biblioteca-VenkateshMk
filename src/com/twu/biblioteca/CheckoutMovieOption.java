package com.twu.biblioteca;

public class CheckoutMovieOption implements MainMenuAction{
    private final ConsoleInputOutput consoleInputOutput;
    private final Library library;

    public CheckoutMovieOption(ConsoleInputOutput consoleInputOutput, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.library = library;
    }

    @Override
    public void obtainOptionResult() {
        String movieTitle = consoleInputOutput.getUserInput();
        String checkoutStatus = library.checkoutMovie(movieTitle);
        consoleInputOutput.displayOutputToUser(checkoutStatus);
    }
}
