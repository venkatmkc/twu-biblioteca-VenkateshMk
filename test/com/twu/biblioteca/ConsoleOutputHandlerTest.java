package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ConsoleOutputHandlerTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
    private String welcomeMessage = new String("Welcome to Biblioteca!");
    private String mainMenu = new String("List Books");

    @Mock
    Books books;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
        MockitoAnnotations.initMocks(this);
        when(books.toString())
                .thenReturn("Kite Runner         |Khaled Hosseini     |2003\n" +
                        "The Sky Is Falling  |Sidney Sheldon      |2001\n");
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler(books, welcomeMessage, mainMenu);

        consoleOutputHandler.displayWelcomeMessage();
        String actualMessage = outputStreamContent.toString();

        assertThat(actualMessage, is(equalTo("Welcome to Biblioteca!\n")));
    }

    @Test
    public void listOfBooksShouldBeDisplayed() {
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler(books, welcomeMessage, mainMenu);

        consoleOutputHandler.displayBookList();
        String actualBookList = outputStreamContent.toString();

        assertThat(actualBookList, is(equalTo("Kite Runner         |Khaled Hosseini     |2003\n" +
                "The Sky Is Falling  |Sidney Sheldon      |2001\n")));
    }

    @Test
    public void mainMenuShouldBeDisplayed() {
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler(books, welcomeMessage, mainMenu);

        consoleOutputHandler.displayMainMenu();
        String actualMainMenu = outputStreamContent.toString();

        assertThat(actualMainMenu, is(equalTo("List Books\n")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}