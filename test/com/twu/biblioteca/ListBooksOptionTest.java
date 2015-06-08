package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ListBooksOptionTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
    }

    @Test
    public void bookListShouldBeDisplayed() {
        ListBooksOption listBooksOption = new ListBooksOption();

        listBooksOption.perform();
        String actualbookList = outputStreamContent.toString();

        assertThat(actualbookList, is(equalTo("Kite Runner         |Khaled Hosseini    |2003\n" +
                "The Sky Is Falling  |Sidney Sheldon      |2001\n")));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}