package com.twu.biblioteca.mainmenu;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.AvailableBookPresenter;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookPresenter;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.mainmenu.options.ListBooksOption;
import com.twu.biblioteca.mainmenu.options.MainMenuAction;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.Movie;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserOptionsTest {
    @Test
    public void parseUserInputShouldProduceMainMenuOption() {
        Book book = new AvailableBook("java tutorial", "aravind", "2012");

        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        books.add(book);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);
        Scanner consoleInput = new Scanner(System.in);
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput(consoleInput);
        BookPresenter bookPresenter = new AvailableBookPresenter("");
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library, bookPresenter);
        LinkedHashMap<String, MainMenuAction> mainMenuOptions = new LinkedHashMap<String, MainMenuAction>();
        mainMenuOptions.put("List Library", listBooksOption);
        UserOptions userOptions = new UserOptions(mainMenuOptions);

        MainMenuAction actualMenuOption = userOptions.parseUserInput("List Library");

        assertThat(actualMenuOption, is(listBooksOption));
    }
}
