package com.twu.biblioteca.book;

import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class CheckedOutBookPresenterTest {
    @Test
    public void formattedBooksShouldBeProduced() {
        String formattedBooks = "harry potter\nkite runner";
        CheckedOutBookPresenter checkedOutBookPresenter = new CheckedOutBookPresenter(formattedBooks);

        String actualFormattedBooks = checkedOutBookPresenter.toString();

        assertThat(actualFormattedBooks, is("harry potter\nkite runner"));
    }

    @Test
    public void addBookShouldAddBookToTheFormattedBooks() {
        String formattedBooks = new String();
        User user = new User("111-5555", "biblioteca");
        CheckedOutBookPresenter checkedOutBookPresenter = new CheckedOutBookPresenter(formattedBooks);

        checkedOutBookPresenter.addBook("Kite Runner", "Khaled Hosseini", "2003", user);
        checkedOutBookPresenter.addBook("The Sky Is Falling", "Sidney Sheldon", "2001", user);
        String actualFormattedBooks = checkedOutBookPresenter.toString();

        assertThat(actualFormattedBooks, is("Kite Runner          | Khaled Hosseini      | 2003 | 111-5555\nThe Sky Is Falling   | Sidney Sheldon       | 2001 | 111-5555\n"));
    }
}