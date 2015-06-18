package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedHashSet;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class CheckoutBookOptionTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    Library library;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void bookTitleShouldBeObtainedFromTheUser() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        Library library = new Library(books, movies);
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        CheckoutBookOption checkoutBookOption = new CheckoutBookOption(consoleInputOutput, library);

        checkoutBookOption.obtainOptionResult(user);

        verify(consoleInputOutput).getUserInput();
    }


    @Test
    public void successfulCheckoutShouldProduceSuccessMessage() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");

        when(library.checkoutBook("Kite Runner", user)).thenReturn(Messages.SUCCESSFUL_BOOK_CHECKOUT);
        CheckoutBookOption checkoutBookOption = new CheckoutBookOption(consoleInputOutput, library);

        checkoutBookOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(Messages.SUCCESSFUL_BOOK_CHECKOUT);
    }

    @Test
    public void unsuccessfulCheckoutShouldProduceFailureMessage() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        when(library.checkoutBook("Kite Runner", user)).thenReturn(Messages.UNSUCCESSFUL_BOOK_CHECKOUT);
        CheckoutBookOption checkoutBookOption = new CheckoutBookOption(consoleInputOutput, library);

        checkoutBookOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(Messages.UNSUCCESSFUL_BOOK_CHECKOUT);
    }


}
