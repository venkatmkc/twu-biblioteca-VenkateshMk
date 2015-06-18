package com.twu.biblioteca.book;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AvailableBookPresenterTest {
    @Test
    public void formattedBooksShouldBeProduced() {
        String formattedBooks = "harry potter\nkite runner";
        AvailableBookPresenter availableBookPresenter = new AvailableBookPresenter(formattedBooks);

        String actualFormattedBooks = availableBookPresenter.toString();

        assertThat(actualFormattedBooks, is("harry potter\nkite runner"));
    }

    @Test
    public void addBookShouldAddBookToTheFormattedBooks() {
        String formattedBooks = new String();
        AvailableBookPresenter availableBookPresenter = new AvailableBookPresenter(formattedBooks);

        availableBookPresenter.addBook("Kite Runner", "Khaled Hosseini", "2003");
        availableBookPresenter.addBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        String actualFormattedBooks = availableBookPresenter.toString();

        assertThat(actualFormattedBooks, is("Kite Runner          | Khaled Hosseini      | 2003\nThe Sky Is Falling   | Sidney Sheldon       | 2001\n"));
    }
}
