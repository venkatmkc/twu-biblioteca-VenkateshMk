package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

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
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books);

        bibliotecaApp.displayWelcomeMessage();
        String actualMessage = outputStreamContent.toString();

        assertThat(actualMessage, is(equalTo("Welcome to Biblioteca!\n")));
    }

    @Test
    public void listOfBooksShouldBeDisplayed() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books);

        bibliotecaApp.displayBookList();
        String actualBookList = outputStreamContent.toString();

        assertThat(actualBookList, is(equalTo("Kite Runner         |Khaled Hosseini     |2003\n" +
                "The Sky Is Falling  |Sidney Sheldon      |2001\n")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}