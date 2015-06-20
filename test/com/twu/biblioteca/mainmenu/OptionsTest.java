package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.BorrowableItem;
import com.twu.biblioteca.ItemPresenter;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.CheckedOutBook;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.options.ListBooksOption;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionsTest {
    @Test
    public void parseUserInputShouldProduceMainMenuOption() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(movies);
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        ItemPresenter bookPresenter = new ItemPresenter("");
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library);
        LinkedHashMap<String, MainMenuAction> mainMenuOptions = new LinkedHashMap<String, MainMenuAction>();
        mainMenuOptions.put("List Library", listBooksOption);
        Options options = new Options(mainMenuOptions);

        MainMenuAction actualMenuOption = options.parseUserInput("List Library");

        assertThat(actualMenuOption, is(listBooksOption));
    }
}
