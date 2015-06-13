package com.twu.biblioteca;

import java.util.Stack;

public class ReturnOption implements MainMenuAction{
    private final ConsoleInputOutput consoleInputOutput;
    private final BookParser bookParser;
    private final Books books;

    public ReturnOption(ConsoleInputOutput consoleInputOutput, BookParser bookParser, Books books) {
        this.consoleInputOutput = consoleInputOutput;
        this.bookParser = bookParser;
        this.books = books;
    }

    @Override
    public void obtainOptionResult() {
        String bookTitle = consoleInputOutput.getUserInput();
        Book book = bookParser.parseUserInput(bookTitle);
        books.returnBook(book);
    }
}
