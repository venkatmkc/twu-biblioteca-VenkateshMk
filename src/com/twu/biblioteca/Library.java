package com.twu.biblioteca;

import com.twu.biblioteca.book.*;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.movie.NullMovie;
import com.twu.biblioteca.movie.MoviesPresenter;
import com.twu.biblioteca.user.User;

import java.util.LinkedHashSet;

public class Library {
    private LinkedHashSet<Book> books;
    private LinkedHashSet<Movie> movies;

    public Library(LinkedHashSet<Book> books, LinkedHashSet<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public String availableBooks() {
        AvailableBookPresenter availableBookPresenter = new AvailableBookPresenter("");
        for (Book book : books) {
            book.appendToBooks(availableBookPresenter);
        }
        return availableBookPresenter.toString();
    }

    public synchronized String checkoutBook(String title, User user) {
        Book book = searchBook(title);
        book = book.checkout(user);
        books.remove(book);
        books.add(book);
        return book.getCheckoutMessage();

    }

    public synchronized String returnBook(String title, User user) {
        Book book = searchBook(title);
        book = book.returnBook(user);
        books.remove(book);
        books.add(book);
        return book.getReturnMessage();
    }


    public Book searchBook(String bookName) {
        for (Book book : books) {
            if (book.isSameBook(bookName))
                return book;
        }
        return new NullBook();
    }

    public String formattedMovies() {
        MoviesPresenter moviesPresenter = new MoviesPresenter("");
        for (Movie movie : movies) {
            movie.appendToMovies(moviesPresenter);
        }
        return moviesPresenter.toString();
    }

    public Movie searchMovie(String movieName) {
        for (Movie movie : movies) {
            if (movie.isSameMovie(movieName))
                return movie;
        }
        return new NullMovie();
    }

    public String checkoutMovie(String title) {
        Movie movie = searchMovie(title);
        movie = movie.checkout();
        movies.remove(movie);
        movies.add(movie);
        return movie.getCheckoutMessage();
    }

    public String returnMovie(String title) {
        Movie movie = searchMovie(title);
        movie = movie.returnMovie();
        movies.remove(movie);
        movies.add(movie);
        return movie.getReturnMessage();
    }

    public String checkedOutBooks() {
        CheckedOutBookPresenter checkedOutBookPresenter = new CheckedOutBookPresenter("");
        for (Book book : books) {
            book.appendToBooks(checkedOutBookPresenter);
        }
        return checkedOutBookPresenter.toString();
    }
}
