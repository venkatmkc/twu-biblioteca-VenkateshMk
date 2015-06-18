package com.twu.biblioteca;

import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.CheckedOutBook;
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
    @Test
    public void formattedBookListShouldBeProduced() {
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
        Library library = new Library(books, movies);

        String actualBookList = library.AvailableBooks();

        assertThat(actualBookList, is(equalTo("Kite Runner          | Khaled Hosseini      | 2003\nThe Sky Is Falling   | Sidney Sheldon       | 2001\n")));
    }



    @Test
    public void checkoutShouldProduceSuccessOnSuccesfulCheckout() {
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
        User user = new User("222-2222", "logmein");
        Library library = new Library(books, movies);

        String actualCheckoutStatus = library.checkoutBook("Kite Runner", user);

        assertThat(actualCheckoutStatus , is(SUCCESSFUL_BOOK_CHECKOUT));
    }

    @Test
    public void checkoutShouldProduceFailureOnUnSuccessfulCheckout() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        User user = new User("222-2222", "logmein");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        String actualCheckoutStatus = library.checkoutBook("Kite Runner", user);

        assertThat(actualCheckoutStatus , is(UNSUCCESSFUL_BOOK_CHECKOUT));
    }

    @Test
    public void returnBookShouldProduceSuccessOnSuccesfulBookReturn() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        User user = new User("222-2222", "logmein");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        String actualReturnStatus = library.returnBook("Kite Runner", user);

        assertThat(actualReturnStatus , is(SUCCESSFUL_BOOK_RETURN));
    }

    @Test
    public void returnBookShouldProduceFailureOnUnSuccessfulReturn() {
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
        User user = new User("222-2222", "logmein");
        Library library = new Library(books, movies);

        String actualReturnStatus = library.returnBook("Kite Runner", user);

        assertThat(actualReturnStatus , is(UNSUCCESSFUL_BOOK_RETURN));
    }

    @Test
    public void searchBookShouldGiveBook() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        User user = new User("222-2222", "logmein");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        Book actualBook = library.searchBook("Kite Runner");

        assertThat(actualBook, is(bookOne));
    }

    @Test
    public void formattedMovieListShouldBeProduced() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        User user = new User("222-2222", "logmein");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        String actualBookList = library.formattedMovies();

        assertThat(actualBookList, is(equalTo("Inception, 2010, Christopher Nolan, 9\nFollowing, 1998, Christopher Nolan, 8\n")));
    }

    @Test
    public void searchMovieShouldGiveMovie() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        User user = new User("222-2222", "logmein");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        Movie actualMovie = library.searchMovie("Inception");

        assertThat(actualMovie, is(movieOne));
    }


    @Test
    public void checkoutMovieShouldProduceSuccessOnSuccesfulCheckout() {
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
        Library library = new Library(books, movies);

        String actualCheckoutStatus = library.checkoutMovie("Inception");

        assertThat(actualCheckoutStatus , is(SUCCESSFUL_MOVIE_CHECKOUT));
    }

    @Test
    public void returnMovieShouldProduceSuccessOnSuccesfulMovieReturn() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        User user = new User("222-2222", "logmein");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new CheckedOutMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        String actualReturnStatus = library.returnMovie("Inception");

        assertThat(actualReturnStatus , is(SUCCESSFUL_MOVIE_RETURN));
    }
}