package org.apache.commons.lang3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

public class ArrayUtilsTest {

    @Test
    public void testAdd_booleanArray() {
        boolean[] array = {true, false};
        boolean[] newArray = ArrayUtils.add(array, true);
        boolean[] expectedArray = {true, false, true};
        Assertions.assertArrayEquals(expectedArray, newArray);
    }

    @Test
    public void testAdd_booleanArrayWithNull() {
        boolean[] array = null;
        boolean[] newArray = ArrayUtils.add(array, true);
        boolean[] expectedArray = {true};
        Assertions.assertArrayEquals(expectedArray, newArray);
    }

    @Test
    public void testAdd_byteArray() {
        byte[] array = {1, 2};
        byte[] newArray = ArrayUtils.add(array, (byte) 3);
        byte[] expectedArray = {1, 2, 3};
        Assertions.assertArrayEquals(expectedArray, newArray);
    }

    // Add tests for other primitive types and Object types

    private void assertArrayEquals(Object expected, Object actual) {
        Assertions.assertEquals(Array.getLength(expected), Array.getLength(actual));
        for (int i = 0; i < Array.getLength(expected); i++) {
            Assertions.assertEquals(Array.get(expected, i), Array.get(actual, i));
        }
    }
}
