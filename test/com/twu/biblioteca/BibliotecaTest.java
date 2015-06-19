package com.twu.biblioteca;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import com.twu.biblioteca.mainmenu.MainMenu;
import com.twu.biblioteca.mainmenu.UserMainMenu;
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
    private UserMainMenu userMainMenu;

    @Mock
    private Login login;

    @Mock
    private User user;

    @Mock
    private MainMenu mainMenu;

    @Mock
    private LibrarianMainMenu librarianMainMenu;
    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu, userMainMenu, librarianMainMenu, login);
        when(login.validate()).thenReturn(user);

        biblioteca.start();

        verify(consoleInputOutput).displayOutputToUser(Messages.WELCOME_MESSAGE);
    }

}
