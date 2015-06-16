package com.twu.biblioteca;

import org.junit.*;

import java.util.LinkedHashSet;

import static com.twu.biblioteca.Messages.*;
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

        String actualBookList = library.formattedBooks();

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
        Library library = new Library(books, movies);

        String actualCheckoutStatus = library.checkoutBook("Kite Runner");

        assertThat(actualCheckoutStatus , is(SUCCESSFUL_CHECKOUT));
    }

    @Test
    public void checkoutShouldProduceFailureOnUnSuccessfulCheckout() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        String actualCheckoutStatus = library.checkoutBook("Kite Runner");

        assertThat(actualCheckoutStatus , is(UNSUCCESSFUL_CHECKOUT));
    }

    @Test
    public void returnBookShouldProduceSuccessOnSuccesfulBookReturn() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        String actualReturnStatus = library.returnBook("Kite Runner");

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
        Library library = new Library(books, movies);

        String actualReturnStatus = library.returnBook("Kite Runner");

        assertThat(actualReturnStatus , is(UNSUCCESSFUL_BOOK_RETURN));
    }

    @Test
    public void searchShouldGiveBook() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();
        Movie movieOne = new AvailableMovie("Inception", "2010", "Christopher Nolan", "9.0");
        Movie movieTwo = new AvailableMovie( "Following", "1998", "Christopher Nolan", "8");
        movies.add(movieOne);
        movies.add(movieTwo);
        Library library = new Library(books, movies);

        Book book = library.search("Kite Runner");

        assertThat(book, is(book));
    }

    @Test
    public void formattedMovieListShouldBeProduced() {
        LinkedHashSet<Book> books = new LinkedHashSet<Book>();
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003");
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
}