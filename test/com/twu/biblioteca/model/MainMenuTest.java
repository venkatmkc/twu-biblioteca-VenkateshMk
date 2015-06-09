package com.twu.biblioteca.model;

import com.twu.biblioteca.model.MainMenu;
import com.twu.biblioteca.model.MainMenuAction;
import com.twu.biblioteca.model.MainMenuOptions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
    public void chooseOptionShouldProduceOptionResult() {
        MainMenu mainMenu = new MainMenu(mainMenuOptions);

        mainMenu.chooseOption("list books");

        Mockito.verify(mainMenuOptions).selectOption("list books");
    }

    @Test
    public void mainMenuShouldListOptions() {
        MainMenu mainMenu = new MainMenu((mainMenuOptions));

        String actualOptionList = mainMenu.listOptions();

        assertThat(actualOptionList, is(equalTo("option list")));
    }
}
