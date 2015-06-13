package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void formattedBookDetailsShouldBeProduced() {
        Book actualBook = new Book("Kite Runner", "Khaled Hosseini", "2003");

        String actualBookDetails = actualBook.formattedBookDetails(20, 20);

        assertThat(actualBookDetails, is(equalTo("Kite Runner          | Khaled Hosseini      | 2003")));
    }

    @Test
    public void nameLengthShouldBeLengthOfName() {
        Book book = new Book("Kite Runner", "Khaled Hosseini", "2003");

        int actualNameLength = book.nameLength();

        assertThat(actualNameLength, is(equalTo(11)));
    }

    @Test
    public void authorLengthShouldBeLengthOfName() {
        Book book = new Book("Kite Runner", "Khaled Hosseini", "2003");

        int actualNameLength = book.authorLength();

        assertThat(actualNameLength, is(equalTo(15)));
    }

    @Test
    public void testForReflexivity() {
        Book firstObject = new Book("Kite Runner","Khaled Hosseini", "2003");

        assertEquals(firstObject, firstObject);
    }

    @Test
    public void testForComparingNullObjectsWithABook() {
        Book firstObject = new Book("Kite Runner","Khaled Hosseini", "2003");

        assertThat(firstObject, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        Book firstObject = new Book("Kite Runner","Khaled Hosseini", "2003");
        Book secondObject = new Book("Kite Runner","Khaled Hosseini", "2003");

        assertEquals(firstObject, secondObject);
    }

    @Test
    public void testForDifferentObjects() {
        Book firstObject = new Book("Kite Runner","Khaled Hosseini", "2003");
        Object one = new Integer(1);

        assertThat(firstObject, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        Book firstObject = new Book("Kite Runner","Khaled Hosseini", "2003");
        Book secondObject = new Book("Kite Runner","Khaled Hosseini", "2003");
        Book thirdObject = new Book("Kite Runner","Khaled Hosseini", "2003");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
        assertEquals(firstObject, thirdObject);
    }

    @Test
    public void testForSymmetry() {
        Book firstObject = new Book("Kite Runner","Khaled Hosseini", "2003");
        Book secondObject = new Book("Kite Runner","Khaled Hosseini", "2003");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
    }

    @Test
    public void equalityTestForHashCode() {
        Book firstObject = new Book("Kite Runner","Khaled Hosseini", "2003");
        Book secondObject = new Book("Kite Runner","Khaled Hosseini", "2003");

        assertEquals(firstObject.hashCode(), secondObject.hashCode());
    }
}