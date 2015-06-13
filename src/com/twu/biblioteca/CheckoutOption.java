package com.twu.biblioteca;

public class CheckoutOption implements MainMenuAction{

    private ConsoleInputOutput consoleInputOutput;
    private BookParser bookParser;
    private Books books;

    public CheckoutOption(ConsoleInputOutput consoleInputOutput, BookParser bookParser, Books books) {
        this.consoleInputOutput = consoleInputOutput;
        this.bookParser = bookParser;
        this.books = books;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
        Book book = bookParser.parseUserInput(bookTitle);
        if(book == null) {
            consoleInputOutput.displayOutputToUser(Messages.UNSUCCESSFUL_CHECKOUT);
            return;
        }
        Boolean checkoutStatus = books.checkout(book);
        if(checkoutStatus == true)
            consoleInputOutput.displayOutputToUser(Messages.SUCCESSFUL_CHECKOUT);
        else
            consoleInputOutput.displayOutputToUser(Messages.UNSUCCESSFUL_CHECKOUT);
    }
}