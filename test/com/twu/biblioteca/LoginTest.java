package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
        User userOne = new User("111-1111", "letmein", "venkatesh", "111-0000", "biblioteca");
        User userTwo = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users, consoleInputOutput);

        login.validate();

        verify(consoleInputOutput, times(2)).getUserInput();
    }

    @Test
    public void loginShouldGetPasswordFromUser() {
        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-1111", "letmein", "venkatesh", "111-0000", "biblioteca");
        User userTwo = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users, consoleInputOutput);

        login.validate();

        verify(consoleInputOutput, times(2)).getUserInput();
    }

    @Test
    public void loginShouldProduceUser() {
        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-1111", "letmein", "venkatesh", "111-0000", "biblioteca");
        User userTwo = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        when(consoleInputOutput.getUserInput()).
                thenReturn("111-1111", "letmein");
        Login login = new Login(users, consoleInputOutput);

        User actualUser = login.validate();

        assertThat(actualUser, is(equalTo(userOne)));
    }

    @Test
    public void successfulLoginShouldProduceSuccessMessage() {
        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-1111", "letmein", "venkatesh", "111-0000", "biblioteca");
        User userTwo = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        when(consoleInputOutput.getUserInput()).
                thenReturn("111-1111", "letmein");
        Login login = new Login(users, consoleInputOutput);

        User actualUser = login.validate();
        String actualLoginMessage = actualUser.getLoginMessage();

        assertThat(actualLoginMessage, is(Messages.SUCCESSFUL_LOGIN));
    }

    @Test
    public void unSuccessfulLoginShouldProduceFailureMessage() {
        HashSet<User> users = new HashSet<User>();
        User userOne = new User("111-1111", "letmein", "venkatesh", "111-0000", "biblioteca");
        User userTwo = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        users.add(userOne);
        users.add(userTwo);
        when(consoleInputOutput.getUserInput()).
                thenReturn("111-0000", "bibliote");
        Login login = new Login(users, consoleInputOutput);

        User actualUser = login.validate();
        String actualLoginMessage = actualUser.getLoginMessage();

        assertThat(actualLoginMessage, is(Messages.UNSUCCESSFUL_LOGIN));
    }
}