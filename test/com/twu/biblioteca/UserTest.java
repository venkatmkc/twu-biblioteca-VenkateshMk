package com.twu.biblioteca;

import com.twu.biblioteca.book.AvailableBook;
import com.twu.biblioteca.book.Book;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void testForReflexivity() {
        User firstObject = new User("111-5555", "biblioteca");

        assertEquals(firstObject, firstObject);
    }

    @Test
    public void testForComparingNullObjectsWithAUser() {
        User firstObject = new User("111-5555", "biblioteca");

        assertThat(firstObject, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        User firstObject = new User("111-5555", "biblioteca");
        User secondObject = new User("111-5555", "biblioteca");

        assertEquals(firstObject, secondObject);
    }

    @Test
    public void testForDifferentObjects() {
        User firstObject = new User("111-5555", "biblioteca");
        Object one = new Integer(1);

        assertThat(firstObject, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        User firstObject = new User("111-5555", "biblioteca");
        User secondObject = new User("111-5555", "biblioteca");
        User thirdObject = new User("111-5555", "biblioteca");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
        assertEquals(firstObject, thirdObject);
    }

    @Test
    public void testForSymmetry() {
        User firstObject = new User("111-5555", "biblioteca");
        User secondObject = new User("111-5555", "biblioteca");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
    }

    @Test
    public void equalityTestForHashCode() {
        User firstObject = new User("111-5555", "biblioteca");
        User secondObject = new User("111-5555", "biblioteca");

        assertEquals(firstObject.hashCode(), secondObject.hashCode());
    }

    @Test
    public void sameLibraryNumberShouldMapToSameUser() {
        User user = new User("111-5555", "biblioteca");

        boolean actualCheckResult = user.isSameLibraryNumber("111-5555");

        assertThat(actualCheckResult, is(true));
    }

    @Test
    public void samePasswordShouldMapToSameUser() {
        User user = new User("111-5555", "biblioteca");

        boolean actualCheckResult = user.isSamePassword("biblioteca");

        assertThat(actualCheckResult, is(true));
    }
}
