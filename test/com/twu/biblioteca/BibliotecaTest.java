package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.user.Librarian;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;
import org.junit.*;
import org.mockito.Mock;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_LOGIN;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class BibliotecaTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    private MainMenu mainMenu;

    @Mock
    private Login login;

    @Mock
    private User user;

    @Mock
    private NullUser nullUser;

    @Mock
    private LibrarianMainMenu librarianMainMenu;
    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu, librarianMainMenu, login);
        when(login.validate()).thenReturn(user);

        biblioteca.start();

        verify(consoleInputOutput).displayOutputToUser(Messages.WELCOME_MESSAGE);
    }

    @Test
    public void userShouldLoginToContinue() {
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu, librarianMainMenu, login);
        when(login.validate()).thenReturn(user);

        biblioteca.start();

        verify(login).validate();
    }

    @Test
    public void userShouldNotBeAllowedToLoginWithInvalidCredentials() {
        when(login.validate()).
                thenReturn(nullUser, user);
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu, librarianMainMenu, login);

        biblioteca.start();

        verify(login, times(2)).validate();
    }

    @Test
    public void loginMessageShouldBeProduced() {
        when(login.validate()).
                thenReturn(user);
        when(user.getLoginMessage()).
                thenReturn(SUCCESSFUL_LOGIN);
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu, librarianMainMenu, login);

        biblioteca.start();

        verify(consoleInputOutput).displayOutputToUser(SUCCESSFUL_LOGIN);
    }
}
