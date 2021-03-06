package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.item.book.AvailableBook;
import com.twu.biblioteca.item.book.Book;
import com.twu.biblioteca.item.book.CheckedOutBook;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashSet;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_BOOK_RETURN;
import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_BOOK_RETURN;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ReturnItemOptionTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    Section section;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void bookTitleShouldBeObtainedFromTheUser() {
        HashSet<Book> books = new HashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        when(section.returnItem("Kite Runner", user)).thenReturn(UNSUCCESSFUL_BOOK_RETURN);
        ReturnItemOption returnItemOption = new ReturnItemOption(consoleInputOutput, section);

        returnItemOption.obtainOptionResult(user);

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void returnBookShouldPerformBookReturn() {
        HashSet<Book> books = new HashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        ReturnItemOption returnItemOption = new ReturnItemOption(consoleInputOutput, section);

        returnItemOption.obtainOptionResult(user);

        verify(section).returnItem("Kite Runner", user);
    }

    @Test
    public void successfulBookReturnShouldProduceSuccessMessage() {
        HashSet<Book> books = new HashSet<Book>();
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        Book bookOne = new CheckedOutBook("Kite Runner", "Khaled Hosseini", "2003", user);
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        when(section.returnItem("Kite Runner", user)).thenReturn(SUCCESSFUL_BOOK_RETURN);
        ReturnItemOption returnItemOption = new ReturnItemOption(consoleInputOutput, section);

        returnItemOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(SUCCESSFUL_BOOK_RETURN);
    }

    @Test
    public void unsuccessfulBookReturnShouldProduceFailureMessage() {
        HashSet<Book> books = new HashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        when(section.returnItem("Kite Runner", user)).thenReturn(UNSUCCESSFUL_BOOK_RETURN);
        ReturnItemOption returnItemOption = new ReturnItemOption(consoleInputOutput, section);

        returnItemOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(UNSUCCESSFUL_BOOK_RETURN);
    }

    @Test
    public void invalidBookNameShouldProduceFailureMessage() {
        HashSet<Book> books = new HashSet<Book>();
        Book bookOne = new AvailableBook("Kite Runner", "Khaled Hosseini", "2003");
        Book bookTwo = new AvailableBook("The Sky Is Falling", "Sidney Sheldon", "2001");
        books.add(bookOne);
        books.add(bookTwo);
        User user = new User("111-1111", "letmein", "venkatesh", "222-2222", "logmein");
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runn");
        when(section.returnItem("Kite Runn", user)).thenReturn(UNSUCCESSFUL_BOOK_RETURN);
        ReturnItemOption returnItemOption = new ReturnItemOption(consoleInputOutput, section);

        returnItemOption.obtainOptionResult(user);

        verify(consoleInputOutput).displayOutputToUser(UNSUCCESSFUL_BOOK_RETURN);
    }
}
