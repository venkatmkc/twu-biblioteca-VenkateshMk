package com.twu.biblioteca;

public class CheckoutOption implements MainMenuAction{

    private ConsoleInputOutput consoleInputOutput;
    private BookParser bookParser;
    private Library library;

    public CheckoutOption(ConsoleInputOutput consoleInputOutput, BookParser bookParser, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.bookParser = bookParser;
        this.library = library;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
        Book book = bookParser.parseUserInput(bookTitle);
        if(book == null) {
            consoleInputOutput.displayOutputToUser(Messages.UNSUCCESSFUL_CHECKOUT);
            return;
        }
        Boolean checkoutStatus = library.checkout(book);
        if(checkoutStatus == true)
            consoleInputOutput.displayOutputToUser(Messages.SUCCESSFUL_CHECKOUT);
        else
            consoleInputOutput.displayOutputToUser(Messages.UNSUCCESSFUL_CHECKOUT);
    }
}
