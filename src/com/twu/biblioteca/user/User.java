package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.*;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_LOGIN;

public class User implements Visitor{
    private String libraryNumber;
    private String password;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if (libraryNumber != null ? !libraryNumber.equals(user.libraryNumber) : user.libraryNumber != null)
            return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }


    public boolean isSameLibraryNumber(String searchLibraryNumber) {
        return libraryNumber.equals(searchLibraryNumber);
    }

    public boolean isSamePassword(String searchPassword) {
        return password.equals(searchPassword);
    }

    public String getLoginMessage() {
        return SUCCESSFUL_LOGIN;
    }

    @Override
    public String toString() {
        return libraryNumber + " | " + name;
    }

    public void visit(UserMainMenu userMainMenu) {
        userMainMenu.dispatch(this);
    }

    @Override
    public void visit(LibrarianMainMenu librarianMainMenu) {

    }

    @Override
    public void visit(MainMenu mainMenu) {}

    public String userInformation() {
        return "Name : " + name +
                "\nEmail : " + email +
                "\nPhone number : " + phoneNumber;
    }
}
