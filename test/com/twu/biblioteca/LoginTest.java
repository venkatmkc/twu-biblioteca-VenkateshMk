package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginTest {
    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void loginShouldGetLibraryNumberFromUser() {
        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-0000", "biblioteca");
        User userTwo = new User("222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users, consoleInputOutput);

        login.validate();

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void loginShouldGetPasswordFromUser() {
        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-0000", "biblioteca");
        User userTwo = new User("222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users, consoleInputOutput);

        login.validate();

        verify(consoleInputOutput, times(2)).getUserInput();
    }
}