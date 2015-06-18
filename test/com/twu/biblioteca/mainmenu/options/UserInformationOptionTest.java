package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class UserInformationOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void userInformationShouldBeDisplayed() {
        UserInformationOption userInformationOption = new UserInformationOption(consoleInputOutput);
        User user = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");

        userInformationOption.obtainOptionResult(user);
        verify(consoleInputOutput).displayOutputToUser("Name : venkatesh\nEmail : venkatmk@thoughtworks.com\nPhone number : 9566011847");
    }
}