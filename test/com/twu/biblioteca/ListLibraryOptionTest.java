package com.twu.biblioteca;

import org.junit.*;
import org.mockito.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashSet;

import static org.mockito.Mockito.*;


public class ListLibraryOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void bookListShouldBeDisplayedToTheUser() {
        Book book = new AvailableBook("book name", "book author", "2012");

        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        books.add(book);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new Movie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new Movie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);
        MainMenuAction listBooksOption = new ListBooksOption(consoleInputOutput, library);

        listBooksOption.obtainOptionResult();

        verify(consoleInputOutput).displayOutputToUser(library.formattedBooks());
    }
}