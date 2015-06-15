package com.twu.biblioteca;

public class ReturnOption implements MainMenuAction{
    private final ConsoleInputOutput consoleInputOutput;
    private final BookParser bookParser;
    private final Library library;

    public ReturnOption(ConsoleInputOutput consoleInputOutput, BookParser bookParser, Library library) {
        this.consoleInputOutput = consoleInputOutput;
        this.bookParser = bookParser;
        this.library = library;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
        Book book = bookParser.parseUserInput(bookTitle);
        if(book == null) {
            consoleInputOutput.displayOutputToUser(Messages.UNSUCCESSFUL_BOOK_RETURN);
            return;
        }
        Boolean returnBookStatus = library.returnBook(book);
        if(returnBookStatus == true) {
            consoleInputOutput.displayOutputToUser(Messages.SUCCESSFUL_BOOK_RETURN);
        }
        else
            consoleInputOutput.displayOutputToUser(Messages.UNSUCCESSFUL_BOOK_RETURN);
    }
}
