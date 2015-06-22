package com.twu.biblioteca.user;

import com.twu.biblioteca.io.Messages;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GuestTest {
    @Test
    public void unSuccessfulLoginShouldProduceFailureMessage() {
        User nullUser = new Guest();

        String actualLoginMessage = nullUser.getLoginMessage();

        assertThat(actualLoginMessage, is(Messages.UNSUCCESSFUL_LOGIN));
    }
}