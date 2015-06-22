package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.LibrarianMainMenu;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LibrarianTest {
    @Mock
    private LibrarianMainMenu librarianMainMenu;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void librarianShouldBeAbleToVisitLibrarianMainMenu() {
        Librarian librarian = new Librarian("111-1111", "superuser", "brutal", "emai@sjdfs", "546546464");

        librarian.visitMenu(librarianMainMenu);

        Mockito.verify(librarianMainMenu).dispatch(librarian);
    }
}