package com.twu.biblioteca.mainmenu;

import org.junit.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuPresenterTest {
    @Test
    public void formattedMainMenuOptionListShouldBeProduced() {
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuPresenter mainMenuPresenter = new MainMenuPresenter(mainMenuOptionsList);

        String actualFormattedOptionList = mainMenuPresenter.toString();

        assertThat(actualFormattedOptionList, is(equalTo("1. List Library\n")));
    }
}
