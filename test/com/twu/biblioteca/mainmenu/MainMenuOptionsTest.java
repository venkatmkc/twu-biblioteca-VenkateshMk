package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.mainmenu.MainMenuOptions;
import org.junit.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuOptionsTest {
    @Test
    public void formattedMainMenuOptionListShouldBeProduced() {
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MainMenuOptions mainMenuOptions = new MainMenuOptions(mainMenuOptionsList);

        String actualFormattedOptionList = mainMenuOptions.toString();

        assertThat(actualFormattedOptionList, is(equalTo("1. List Library\n")));
    }
}
