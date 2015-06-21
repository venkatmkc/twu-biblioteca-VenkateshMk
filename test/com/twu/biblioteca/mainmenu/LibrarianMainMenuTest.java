package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibrarianMainMenuTest {
    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Mock
    Options options;

    @Mock
    MainMenuAction listBookOption;

    @Mock
    MainMenuAction checkedOutBooksOption;

    private User user;
    private MenuPresenter menuPresenter;
    private Options librarianOptions;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(options.parseUserInput("List Section")).
                thenReturn(listBookOption);
        user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        LinkedHashMap<String, MainMenuAction> librarianOptionsList = new LinkedHashMap<String, MainMenuAction>();
        librarianOptionsList.put("CheckedOut Books", checkedOutBooksOption);
        menuPresenter = new MenuPresenter("");
        librarianOptions = new Options(librarianOptionsList);
    }

    @Test
    public void dispatchShouldPerformSelectedOption() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Section", "9");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");
        UserMainMenu userMainMenu = new LibrarianMainMenu(consoleInputOutput, options, menuPresenter);

        userMainMenu.dispatch(user);

        verify(listBookOption).obtainOptionResult(user);
    }
}