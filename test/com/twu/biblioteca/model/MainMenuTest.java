package com.twu.biblioteca.model;

import org.junit.*;
import org.mockito.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class MainMenuTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private MainMenuOptions mainMenuOptions;

    @Mock
    private MainMenuAction listBooksOption;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
        MockitoAnnotations.initMocks(this);
        when(mainMenuOptions.selectOption("list books")).
                thenReturn(listBooksOption);
        when(mainMenuOptions.toString()).
                thenReturn("option list");
    }

    @Test
    public void chooseOptionShouldProduceSelectedOption() {
        MainMenu mainMenu = new MainMenu(mainMenuOptions);

        MainMenuAction actualSelectedOption = mainMenu.chooseOption("list books");

        assertThat(actualSelectedOption, is(equalTo(listBooksOption)));
    }

    @Test
    public void performSelectedOptionShouldProduceOptionResult() {
        MainMenu mainMenu = new MainMenu(mainMenuOptions);

        mainMenu.performSelectedOption(listBooksOption);

        Mockito.verify(listBooksOption).obtainOptionResult();
    }

    @Test
    public void mainMenuShouldListOptions() {
        MainMenu mainMenu = new MainMenu((mainMenuOptions));

        String actualOptionList = mainMenu.listOptions();

        assertThat(actualOptionList, is(equalTo("option list")));
    }
}
