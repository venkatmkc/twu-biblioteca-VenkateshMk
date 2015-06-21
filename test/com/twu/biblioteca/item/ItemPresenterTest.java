package com.twu.biblioteca.item;

import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemPresenterTest {
    @Test
    public void availableBooksShouldBeProduced() {
        String formattedItems = "harry potter\nkite runner";
        ItemPresenter availableBookPresenter = new ItemPresenter(formattedItems);

        String actualFormattedBooks = availableBookPresenter.toString();

        assertThat(actualFormattedBooks, is("harry potter\nkite runner"));
    }

    @Test
    public void addBookShouldAddBookToTheFormattedItems() {
        String formattedBooks = new String();
        ItemPresenter availableBookPresenter = new ItemPresenter(formattedBooks);

        availableBookPresenter.addAvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        availableBookPresenter.addAvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        String actualFormattedBooks = availableBookPresenter.toString();

        assertThat(actualFormattedBooks, is("Kite Runner          | Khaled Hosseini      | 2003\nThe Sky Is Falling   | Sidney Sheldon       | 2001\n"));
    }

    @Test
    public void addBookShouldAddBookToTheFormattedBooks() {
        String formattedBooks = new String();
        User user = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        ItemPresenter checkedOutBookPresenter = new ItemPresenter(formattedBooks);

        checkedOutBookPresenter.addCheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        checkedOutBookPresenter.addCheckedOutBook("The Sky Is Falling", "Sidney Sheldon", "2001", user);
        String actualFormattedBooks = checkedOutBookPresenter.toString();

        assertThat(actualFormattedBooks, is("Kite Runner          | Khaled Hosseini      | 2003 | 111-1111 | venkatesh\n" +
                "The Sky Is Falling   | Sidney Sheldon       | 2001 | 111-1111 | venkatesh\n"));
    }

    @Test
    public void formattedMoviesShouldBeProduced() {
        String formattedMovies = "inception\nfollowing";
        ItemPresenter moviesPresenter = new ItemPresenter(formattedMovies);

        String actualFormattedMovies = moviesPresenter.toString();

        assertThat(actualFormattedMovies, is("inception\nfollowing"));
    }

    @Test
    public void addMovieShouldAddMovieToTheFormattedMovies() {
        String formattedMovies = new String();
        User user = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        ItemPresenter moviesPresenter = new ItemPresenter(formattedMovies);

        moviesPresenter.addCheckedOutMovie("Inception", "2010", "Christopher Nolan", "9", user);
        moviesPresenter.addAvailableMovie("Following", "1998", "Christopher Nolan", "8");
        String actualFormattedMovies = moviesPresenter.toString();

        assertThat(actualFormattedMovies, is("Inception, 2010, Christopher Nolan, 9 | 111-1111 | venkatesh\nFollowing, 1998, Christopher Nolan, 8\n"));
    }
}