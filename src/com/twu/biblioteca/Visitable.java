package com.twu.biblioteca;

import com.twu.biblioteca.user.User;

public interface Visitable {
    void accept(User user);
}
