package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.book.BookPresenter;
import com.twu.biblioteca.book.CheckedOutBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.CheckedOutBookPresenter;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.movie.CheckedOutMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashSet;

import static org.mockito.Mockito.verify;

public class ListCheckedOutBooksOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void checkedOutBookListShouldBeDisplayedToTheUser() {
        User user = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        Book book = new CheckedOutBook("book name", "book author", "2012", user);

        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        books.add(book);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new CheckedOutMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);
        BookPresenter bookPresenter = new CheckedOutBookPresenter("");
        MainMenuAction listCheckedOutBooksOption = new ListCheckedOutBooksOption(consoleInputOutput, library, bookPresenter);

        listCheckedOutBooksOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser("book name            | book author          | 2012 | 111-1111\n");
    }

}