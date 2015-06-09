package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Books;
import org.junit.*;
import org.mockito.*;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BooksTest {
    @Mock
    Book bookOne, bookTwo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(bookOne.nameLength()).
                thenReturn(5);
        when(bookOne.authorLength()).
                thenReturn(5);
        when(bookOne.nameLength()).
                thenReturn(5);
        when(bookOne.authorLength()).
                thenReturn(5);
        when(bookOne.formattedBookDetails(5, 5)).
                thenReturn("book one");
        when(bookTwo.formattedBookDetails(5,5)).
                thenReturn("book two");
    }

    @Test
    public void formattedBookListShouldBeProduced() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);
        Books books = new Books(bookList);

        String actualBookList = books.toString();

        assertThat(actualBookList, is(equalTo("book one\nbook two\n")));
    }


}