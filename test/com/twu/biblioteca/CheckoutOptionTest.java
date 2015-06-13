package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class CheckoutOptionTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    BookParser bookParser;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void bookTitleShouldBeObtainedFromTheUser() {
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser);

        checkoutOption.obtainOptionResult();

        verify(consoleInputOutput).getUserInput();
    }

    @Test
    public void checkoutShouldParseUserInputToBook() {
        when(consoleInputOutput.getUserInput()).thenReturn("Kite Runner");
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput, bookParser);

        checkoutOption.obtainOptionResult();

        verify(bookParser).parseUserInput("Kite Runner");
    }
}
