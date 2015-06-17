package com.twu.biblioteca.user;

import com.twu.biblioteca.io.Messages;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NullUserTest {
    @Test
    public void unSuccessfulLoginShouldProduceFailureMessage() {
        User nullUser = new NullUser();

        String actualLoginMessage = nullUser.getLoginMessage();

        assertThat(actualLoginMessage, is(Messages.UNSUCCESSFUL_LOGIN));
    }
}