package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;

import java.util.HashSet;

public class Login {
    private HashSet<User> users;
    private ConsoleInputOutput consoleInputOutput;

    public Login(HashSet<User> users, ConsoleInputOutput consoleInputOutput) {
        this.users = users;
        this.consoleInputOutput = consoleInputOutput;
    }

    public User validate() {
        String libraryNumber = consoleInputOutput.getUserInput();
        String password = consoleInputOutput.getUserInput();
        return search(libraryNumber, password);
    }

    private User search(String libraryNumber, String password) {
        for (User user : users) {
            if (user.isSameLibraryNumber(libraryNumber) && user.isSamePassword(password))
                return user;
        }
        return new NullUser();
    }

}
