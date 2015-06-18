package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.MainMenu;

import static com.twu.biblioteca.io.Messages.SUCCESSFUL_LOGIN;

public class UserAccount implements Visitor {
    private String libraryNumber;
    private String password;

    public UserAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserAccount user = (UserAccount) o;

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
    public void visit(MainMenu mainMenu) {
        mainMenu.dispatch(this);
    }
}
