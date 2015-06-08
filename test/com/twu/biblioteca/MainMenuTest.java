package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainMenuTest {
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
    private final String mainMenu = new String("List Books");
    private final MainMenuAction listBooksOption = new ListBooksOption();
    HashMap<String, MainMenuAction> mainMenuOptions = new HashMap<String, MainMenuAction>();


    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamContent));
        mainMenuOptions.put("List Books", listBooksOption);
    }

}
