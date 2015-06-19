package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginOptionTest {
    @Mock
    private Login login;

    @Mock
    private UserMainMenu userMainMenu;

    @Mock
    private LibrarianMainMenu librarianMainMenu;

    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    private User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginValidationShouldBeDone() {
        LoginOption loginOption  = new LoginOption(login, userMainMenu, librarianMainMenu, consoleInputOutput);
        when(login.validate()).thenReturn(user);

        loginOption.obtainOptionResult(user);

        verify(login).validate();
    }
}