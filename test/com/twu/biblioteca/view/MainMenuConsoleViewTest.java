package com.twu.biblioteca.view;

import com.twu.biblioteca.model.MainMenu;

import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class MainMenuConsoleViewTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private MainMenu mainMenu;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mainMenu.listOptions()).
                thenReturn("List Books");
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void mainMenuShouldBeDisplayed() {
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);

        mainMenuConsoleView.displayMainMenu();
        String actualMainMenu = outputStreamContent.toString();

        assertThat(actualMainMenu, is(equalTo("List Books\n")));
    }

    @Test
    public void selectedOptionShouldBePerformed() {
        ByteArrayInputStream inputStreamContent = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(inputStreamContent);
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);

        mainMenuConsoleView.performUserSelectedOption();

        Mockito.verify(mainMenu).chooseOption("List Books");
    }

    @Test
    public void invalidOptionShouldDisplayInvalidOptionMessage() {
        ByteArrayInputStream inputStreamContent = new ByteArrayInputStream("delete\nList Books".getBytes());
        System.setIn(inputStreamContent);
        MainMenuConsoleView mainMenuConsoleView = new MainMenuConsoleView(mainMenu);

        mainMenuConsoleView.performUserSelectedOption();
        String actualInvalidOptionMessage = outputStreamContent.toString();

        assertThat(actualInvalidOptionMessage, is(equalTo(Messages.INVALID_MENU_OPTION)));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
