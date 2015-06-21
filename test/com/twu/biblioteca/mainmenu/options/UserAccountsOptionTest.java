package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.user.UserAccounts;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserAccountsOptionTest {
    @Mock
    private UserAccounts userAccounts;

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
        LoginOption loginOption  = new LoginOption(userAccounts, userMainMenu, librarianMainMenu, consoleInputOutput);
        when(userAccounts.validate()).thenReturn(user);

        loginOption.obtainOptionResult(user);

        verify(userAccounts).validate();
    }
}