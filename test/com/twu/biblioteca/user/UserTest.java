package com.twu.biblioteca.user;

import com.twu.biblioteca.mainmenu.Options;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserTest {
    @Mock
    private Options options;

    @Before
    public void setUp() {
        initMocks(this);
    }
    @Test
    public void testForReflexivity() {
        User firstObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        assertEquals(firstObject, firstObject);
    }

    @Test
    public void testForComparingNullObjectsWithAUser() {
        User firstObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        assertThat(firstObject, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        User firstObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        User secondObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        assertEquals(firstObject, secondObject);
    }

    @Test
    public void testForDifferentObjects() {
        User firstObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        Object one = new Integer(1);

        assertThat(firstObject, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        User firstObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        User secondObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        User thirdObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
        assertEquals(firstObject, thirdObject);
    }

    @Test
    public void testForSymmetry() {
        User firstObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        User secondObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        assertEquals(firstObject, secondObject);
        assertEquals(secondObject, firstObject);
    }

    @Test
    public void equalityTestForHashCode() {
        User firstObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");
        User secondObject = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        assertEquals(firstObject.hashCode(), secondObject.hashCode());
    }

    @Test
    public void sameLibraryNumberShouldMapToSameUser() {
        User user = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        boolean actualCheckResult = user.isSameLibraryNumber("111-1111");

        assertThat(actualCheckResult, is(true));
    }

    @Test
    public void samePasswordShouldMapToSameUser() {
        User user = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        boolean actualCheckResult = user.isSamePassword("letmein");

        assertThat(actualCheckResult, is(true));
    }

    @Test
    public void userInformationShouldBeProduced() {
        User user = new User("111-1111", "letmein", "venkatesh", "111-5555", "biblioteca");

        String actualLibraryNumber = user.toString();

        assertThat(actualLibraryNumber, is("111-1111 | venkatesh"));
    }

    @Test
    public void userAccountDetailsShouldBeProduced() {
        User user = new User("111-1111", "letmein", "venkatesh", "venkatmk@thoughtworks.com", "9566011847");

        String actualLibraryNumber = user.userInformation();

        assertThat(actualLibraryNumber, is("Name : venkatesh\nEmail : venkatmk@thoughtworks.com\nPhone number : 9566011847"));
    }
}
