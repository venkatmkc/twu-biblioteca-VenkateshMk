package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BooksPresenterTest {
    @Test
    public void formattedBooksShouldBeProduced() {
        String formattedBooks = "harry potter\nkite runner";
        BooksPresenter booksPresenter = new BooksPresenter(formattedBooks);

        String actualFormattedBooks = booksPresenter.toString();

        assertThat(actualFormattedBooks, is("harry potter\nkite runner"));
    }

    @Test
    public void addBookShouldAddMovieToTheFormattedBooks() {
        String formattedBooks = new String();
        BooksPresenter booksPresenter = new BooksPresenter(formattedBooks);

        booksPresenter.addBook("Kite Runner", "Khaled Hosseini", "2003");
        booksPresenter.addBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        String actualFormattedBooks = booksPresenter.toString();

        assertThat(actualFormattedBooks, is("Kite Runner          | Khaled Hosseini      | 2003\nThe Sky Is Falling   | Sidney Sheldon       | 2001\n"));
    }
}
