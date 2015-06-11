package com.twu.biblioteca.model;

import org.junit.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuOptionsTest {
    @Test
    public void formattedMainMenuOptionListShouldBeProduced() {
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Books");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);

        String actualFormattedOptionList = mainMenuOptions.toString();

        assertThat(actualFormattedOptionList, is(equalTo("1. List Books\n")));
    }
}
