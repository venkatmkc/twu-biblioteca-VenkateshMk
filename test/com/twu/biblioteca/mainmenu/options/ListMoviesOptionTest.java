package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.*;
import org.mockito.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashSet;

import static org.mockito.Mockito.*;


public class ListMoviesOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void movieListShouldBeDisplayedToTheUser() {
        Book book = new AvailableBook("book name", "book author", "2012");

        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        books.add(book);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        Library library = new Library(books, movies);
        MainMenuAction listMoviesOption = new ListMoviesOption(consoleInputOutput, library);

        listMoviesOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(library.formattedMovies());
    }
}