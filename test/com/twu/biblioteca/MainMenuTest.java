package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class MainMenuTest {
    @Mock
    private MainMenuOptions mainMenuOptions;

    @Mock
    private MainMenuAction listBooksOption;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mainMenuOptions.selectOption("list books")).
                thenReturn(listBooksOption);
        when(listBooksOption.obtainOptionResult()).
                thenReturn("book List");
    }
    @Test
    public void chooseOptionShouldProduceOptionResult() {
        MainMenu mainMenu = new MainMenu(mainMenuOptions);
        String actualOptionResult = mainMenu.chooseOption("list books");
        assertThat(actualOptionResult, is(equalTo("book List")));
    }
}
