package com.twu.biblioteca;

public class BibliotecaApp {
    private String welcomeMessage = "Welcome to Biblioteca!";
    private String mainMenu;
    private Books books;

    public BibliotecaApp(Books books, String welcomeMessage, String mainMenu) {
        this.books = books;
        this.welcomeMessage = welcomeMessage;
        this.mainMenu = mainMenu;
    }

    public void displayWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void displayBookList() {
        System.out.print(books);
    }

    public void displayMainMenu() {
        System.out.println(mainMenu);
    }
}
