package com.twu.biblioteca;

import com.twu.biblioteca.book.*;
import com.twu.biblioteca.movie.AvailableMovie;
import com.twu.biblioteca.movie.CheckedOutMovie;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.user.User;
import org.junit.*;

import java.util.LinkedHashSet;

import static com.twu.biblioteca.io.Messages.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private ItemPresenter itemPresenter;

    @Before
    public void setUp() {
        LinkedHashSet<BorrowableItem> books = new LinkedHashSet<BorrowableItem>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");
        Book bookThree = new CheckedOutBook("harry", "sidney", "3021", user);
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        library = new Library(books);
        itemPresenter = new ItemPresenter("");
    }

    @Test
    public void formattedBookListShouldBeProduced() {
        String actualBookList = library.availableFormattedItems(itemPresenter);

        assertThat(actualBookList, is(equalTo("Kite Runner          | Khaled Hosseini      | 2003\nThe Sky Is Falling   | Sidney Sheldon       | 2001\n")));
    }



    @Test
    public void checkoutShouldProduceSuccessOnSuccesfulCheckout() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");

        String actualCheckoutStatus = library.checkoutItem("Kite Runner", user);

        assertThat(actualCheckoutStatus , is(SUCCESSFUL_BOOK_CHECKOUT));
    }

    @Test
    public void checkoutShouldProduceFailureOnUnSuccessfulCheckout() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");

        String actualCheckoutStatus = library.checkoutItem("harry", user);

        assertThat(actualCheckoutStatus , is(UNSUCCESSFUL_BOOK_CHECKOUT));
    }

    @Test
    public void returnBookShouldProduceSuccessOnSuccesfulBookReturn() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");

        String actualReturnStatus = library.returnItem("harry", user);

        assertThat(actualReturnStatus , is(SUCCESSFUL_BOOK_RETURN));
    }

    @Test
    public void returnBookShouldProduceFailureOnUnSuccessfulReturn() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");

        String actualReturnStatus = library.returnItem("Kite Runner", user);

        assertThat(actualReturnStatus , is(UNSUCCESSFUL_BOOK_RETURN));
    }


    @Test
    public void formattedMovieListShouldBeProduced() {
        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(movies);

        String actualBookList = library.availableFormattedItems(itemPresenter);

        assertThat(actualBookList, is(equalTo("Inception, 2010, Christopher Nolan, 9\nFollowing, 1998, Christopher Nolan, 8\n")));
    }


    @Test
    public void checkoutMovieShouldProduceSuccessOnSuccesfulCheckout() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");
        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(movies);

        String actualCheckoutStatus = library.checkoutItem("Inception", user);

        assertThat(actualCheckoutStatus , is(SUCCESSFUL_MOVIE_CHECKOUT));
    }

    @Test
    public void returnMovieShouldProduceSuccessOnSuccesfulMovieReturn() {
        User user = new User("222-2222", "logmein", "crean", "dsfas@dsfa.com", "99323294932");
        LinkedHashSet<BorrowableItem> movies = new LinkedHashSet<BorrowableItem>();
        Movie movieOne = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9", user);
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(movies);

        String actualReturnStatus = library.returnItem("Inception", user);

        assertThat(actualReturnStatus , is(SUCCESSFUL_MOVIE_RETURN));
    }
}