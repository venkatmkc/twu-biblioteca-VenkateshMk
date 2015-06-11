package com.twu.biblioteca;

public class Biblioteca {
    private ConsoleInputOutput consoleInputOutput;
    private MainMenu mainMenu;

    public Biblioteca(ConsoleInputOutput consoleInputOutput, MainMenu mainMenu) {
        this.consoleInputOutput = consoleInputOutput;
        this.mainMenu = mainMenu;
    }

    public void start() {
        consoleInputOutput.displayOutputToUser(Messages.WELCOME_MESSAGE);
        mainMenu.dispatch();
    }
}
