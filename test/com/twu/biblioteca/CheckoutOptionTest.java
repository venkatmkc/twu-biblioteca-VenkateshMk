package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class CheckoutOptionTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        initMocks(this);
    }
    @Test
    public void bookTitleShouldBeObtainedFromTheUser() {
        CheckoutOption checkoutOption = new CheckoutOption(consoleInputOutput);

        checkoutOption.obtainOptionResult();

        verify(consoleInputOutput).getUserInput();
    }
}
