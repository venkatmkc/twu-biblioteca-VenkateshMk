package com.twu.biblioteca.user;

import static com.twu.biblioteca.io.Messages.UNSUCCESSFUL_LOGIN;

public class NullUser extends User{
    public NullUser() {
        super("", "");
    }

    public String getLoginMessage() {
        return UNSUCCESSFUL_LOGIN;
    }
}
