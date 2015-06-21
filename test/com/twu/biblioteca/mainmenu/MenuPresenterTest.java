package com.twu.biblioteca.mainmenu;

import org.junit.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MenuPresenterTest {
    @Test
    public void formattedMainMenuOptionListShouldBeProduced() {
        Set<String> options = new LinkedHashSet<String>();
        options.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");

        menuPresenter.addMenu(options);
        String actualFormattedOptionList = menuPresenter.toString();

        assertThat(actualFormattedOptionList, is(equalTo("1. List Section\n")));
    }

    @Test
    public void flushShouldClearTheMenu() {
        Set<String> options = new LinkedHashSet<String>();
        options.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("list");

        menuPresenter.flush();
        String actualFormattedOptionList = menuPresenter.toString();

        assertThat(actualFormattedOptionList, is(equalTo("")));
    }
}
