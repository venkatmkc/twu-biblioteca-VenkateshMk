package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.*;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class MainMenuOptionsTest {
    @Mock
    HashMap<String, MainMenuAction> mainMenuOptionsMap;

    @Mock
    MainMenuAction listBooksOption;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mainMenuOptionsMap.get("List Books")).
                thenReturn(listBooksOption);
    }

    @Test
    public void selectOptionShouldProduceSelectedOption() {
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsMap);

        MainMenuAction actualSelectedOption = mainMenuOptions.selectOption("List Books");

        assertThat(actualSelectedOption, is(equalTo(listBooksOption)));
    }

    @Test
    public void formattedOptionListShouldBeProduced() {
        HashMap<String, MainMenuAction> mainMenuOptionsMap = new HashMap<String, MainMenuAction>();
        mainMenuOptionsMap.put("List Books", listBooksOption);
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsMap);

        String actualFormattedOptionList = mainMenuOptions.toString();

        assertThat(actualFormattedOptionList, is(equalTo("List Books\n")));
    }
}
