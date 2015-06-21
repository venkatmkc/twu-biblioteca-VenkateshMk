package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.item.BorrowableItem;
import com.twu.biblioteca.item.book.CheckedOutBook;
import com.twu.biblioteca.item.book.Book;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashSet;

import static org.mockito.Mockito.verify;

public class ListCheckedOutBooksOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void checkedOutBookListShouldBeDisplayedToTheUser() {
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        Book book = new CheckedOutBook("book name", "book author", "2012", user);
        LinkedHashSet<BorrowableItem> books = new LinkedHashSet<BorrowableItem>();
        books.add(book);
        Section section = new Section(books);
        MainMenuAction listCheckedOutBooksOption = new ListCheckedOutBooksOption(consoleInputOutput, section);

        listCheckedOutBooksOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser("book name            | book author          | 2012 | 111-1111 | venkatesh\n");
    }

}