package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.options.ListBooksOption;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.item.movie.AvailableMovie;
import com.twu.biblioteca.item.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionsTest {
    @Test
    public void parseUserInputShouldProduceMainMenuOption() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");
        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Section section = new Section(movies);
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, section);
        LinkedHashMap<String, MainMenuAction> mainMenuOptions = new LinkedHashMap<String, MainMenuAction>();
        mainMenuOptions.put("List Section", listBooksOption);
        Options options = new Options(mainMenuOptions);

        MainMenuAction actualMenuOption = options.parseUserInput("1");

        assertThat(actualMenuOption, is(listBooksOption));
    }
}
