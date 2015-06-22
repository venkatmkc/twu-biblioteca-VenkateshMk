package com.twu.biblioteca.user;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;

import java.util.HashSet;

import static com.twu.biblioteca.io.Messages.*;

public class UserAccounts {
    private HashSet<User> users;
    private ConsoleInputOutput consoleInputOutput;

    public UserAccounts(HashSet<User> users, ConsoleInputOutput consoleInputOutput) {
        this.users = users;
        this.consoleInputOutput = consoleInputOutput;
    }

    public User validate() {
        consoleInputOutput.displayOutputToUser(LIBRARY_NUMBER);
        String libraryNumber = consoleInputOutput.getUserInput();
        consoleInputOutput.displayOutputToUser(Messages.PASSWORD);
        String password = consoleInputOutput.getUserInput();
        return search(libraryNumber, password);
    }

    private User search(String libraryNumber, String password) {
        for (User user : users) {
            if (user.isSameLibraryNumber(libraryNumber) && user.isSamePassword(password))
                return user;
        }
        return new Guest();
    }

}
