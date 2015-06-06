package com.twu.biblioteca;

public class BibliotecaApp {
    public final String welcomeMessage = "Welcome to Biblioteca!";
    private Books books;

    public BibliotecaApp(Books books) {
        this.books = books;
    }

    public void displayWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void displayBookList() {
        System.out.print(books);
    }
}
