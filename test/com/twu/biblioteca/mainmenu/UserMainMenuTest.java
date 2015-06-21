package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class UserMainMenuTest {
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
    public void dispatchShouldGetInputFromUser() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("8");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");
        UserMainMenu userMainMenu = new UserMainMenu(consoleInputOutput, options, menuPresenter);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");

        userMainMenu.dispatch(user);

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void dispatchShouldParseUserInputToOption() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Section", "8");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");
        UserMainMenu userMainMenu = new UserMainMenu(consoleInputOutput, options, menuPresenter);

        userMainMenu.dispatch(user);

        verify(options).parseUserInput("List Section");
    }

    @Test
    public void dispatchShouldProduceMainMenuOptionList() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Section", "8");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");
        UserMainMenu userMainMenu = new UserMainMenu(consoleInputOutput, options, menuPresenter);

        userMainMenu.dispatch(user);

        verify(consoleInputOutput, times(2)).displayOutputToUser(userMainMenu);
    }

    @Test
    public void dispatchShouldPerformSelectedOption() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Section", "8");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");
        UserMainMenu userMainMenu = new UserMainMenu(consoleInputOutput, options, menuPresenter);

        userMainMenu.dispatch(user);

        verify(listBookOption).obtainOptionResult(user);
    }

    @Test
    public void dispatchShouldProduceInvalidOptionMessageOnInvalidOption() {
        when(consoleInputOutput.getUserInput()).thenReturn("delete", "List Section", "8");

        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");
        UserMainMenu userMainMenu = new UserMainMenu(consoleInputOutput, options, menuPresenter);

        userMainMenu.dispatch(user);

        verify(consoleInputOutput).displayOutputToUser(Messages.INVALID_MENU_OPTION);
    }

    @Test
    public void dispatchShould8WhenQuitOptionIsSelected() {
        when(consoleInputOutput.getUserInput()).thenReturn("8");

        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Section");
        MenuPresenter menuPresenter = new MenuPresenter("");
        UserMainMenu userMainMenu = new UserMainMenu(consoleInputOutput, options, menuPresenter);

        userMainMenu.dispatch(user);

        verify(options, times(0)).parseUserInput("8");
    }
}
