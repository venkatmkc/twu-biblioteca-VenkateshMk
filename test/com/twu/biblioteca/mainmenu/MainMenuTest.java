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

public class MainMenuTest {
    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Mock
    UserOptions userOptions;

    @Mock
    MainMenuAction listBookOption;

    @Mock
    MainMenuAction checkedOutBooksOption;

    private User user;
    private MenuPresenter menuPresenter;
    private LibrarianOptions librarianOptions;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(userOptions.parseUserInput("List Library")).
                thenReturn(listBookOption);
        user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        LinkedHashMap<String, MainMenuAction> librarianOptionsList = new LinkedHashMap<String, MainMenuAction>();
        librarianOptionsList.put("CheckedOut Books", checkedOutBooksOption);
        menuPresenter = new MenuPresenter("");
        librarianOptions = new LibrarianOptions(librarianOptionsList);
    }

    @Test
    public void dispatchShouldGetInputFromUser() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MenuPresenter menuPresenter = new MenuPresenter("");
        MainMenu mainMenu = new MainMenu(consoleInputOutput, userOptions, menuPresenter);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");

        mainMenu.dispatch(user);

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void dispatchShouldParseUserInputToOption() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Library", "Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MenuPresenter menuPresenter = new MenuPresenter("");
        MainMenu mainMenu = new MainMenu(consoleInputOutput, userOptions, menuPresenter);

        mainMenu.dispatch(user);

        verify(userOptions).parseUserInput("List Library");
    }

    @Test
    public void dispatchShouldProduceMainMenuOptionList() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Library", "Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MenuPresenter menuPresenter = new MenuPresenter("");
        MainMenu mainMenu = new MainMenu(consoleInputOutput, userOptions, menuPresenter);

        mainMenu.dispatch(user);

        verify(consoleInputOutput, times(2)).displayOutputToUser(mainMenu);
    }

    @Test
    public void dispatchShouldPerformSelectedOption() {
        when(consoleInputOutput.getUserInput()).
                thenReturn("List Library", "Quit");
        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MenuPresenter menuPresenter = new MenuPresenter("");
        MainMenu mainMenu = new MainMenu(consoleInputOutput, userOptions, menuPresenter);

        mainMenu.dispatch(user);

        verify(listBookOption).obtainOptionResult(user);
    }

    @Test
    public void dispatchShouldProduceInvalidOptionMessageOnInvalidOption() {
        when(consoleInputOutput.getUserInput()).thenReturn("delete", "List Library", "Quit");

        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MenuPresenter menuPresenter = new MenuPresenter("");
        MainMenu mainMenu = new MainMenu(consoleInputOutput, userOptions, menuPresenter);

        mainMenu.dispatch(user);

        verify(consoleInputOutput).displayOutputToUser(Messages.INVALID_MENU_OPTION);
    }

    @Test
    public void dispatchShouldQuitWhenQuitOptionIsSelected() {
        when(consoleInputOutput.getUserInput()).thenReturn("Quit");

        ArrayList<String> mainMenuOptionsList = new ArrayList<String>();
        mainMenuOptionsList.add("List Library");
        MenuPresenter menuPresenter = new MenuPresenter("");
        MainMenu mainMenu = new MainMenu(consoleInputOutput, userOptions, menuPresenter);

        mainMenu.dispatch(user);

        verify(userOptions, times(0)).parseUserInput("Quit");
    }
}
