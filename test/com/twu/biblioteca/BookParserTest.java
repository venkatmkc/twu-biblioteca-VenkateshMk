package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookParserTest {
    @Test
    public void parseUserInputShouldProduceBook() {
        Book book = new Book("Kite Runner", "Khaled Hosseini", "2003");
        HashMap<String, Book>  books = new HashMap<String, Book>();
        books.put("Kite Runner", book);
        BookParser bookParser = new BookParser(books);

        Book actualBook = bookParser.parseUserInput("Kite Runner");

        assertThat(actualBook, is(book));
    }
}