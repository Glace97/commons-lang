package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class ArraySorterTest {
    @Test
    public void testSortByteArray() {
        byte[] array = {5, 3, 1, 4, 2};
        byte[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortCharArray() {
        char[] array = {'c', 'a', 'b'};
        char[] expected = {'a', 'b', 'c'};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortDoubleArray() {
        double[] array = {5.5, 3.3, 1.1, 4.4, 2.2};
        double[] expected = {1.1, 2.2, 3.3, 4.4, 5.5};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortFloatArray() {
        float[] array = {5.5f, 3.3f, 1.1f, 4.4f, 2.2f};
        float[] expected = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortIntArray() {
        int[] array = {5, 3, 1, 4, 2};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortLongArray() {
        long[] array = {5L, 3L, 1L, 4L, 2L};
        long[] expected = {1L, 2L, 3L, 4L, 5L};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortShortArray() {
        short[] array = {5, 3, 1, 4, 2};
        short[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortObjectArray() {
        String[] array = {"banana", "apple", "orange"};
        String[] expected = {"apple", "banana", "orange"};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }

    @Test
    public void testSortObjectArrayWithComparator() {
        String[] array = {"banana", "apple", "orange"};
        Comparator<String> comparator = Comparator.reverseOrder();
        String[] expected = {"orange", "banana", "apple"};
        assertArrayEquals(expected, ArraySorter.sort(array, comparator));
    }

    @Test
    public void testSortObjectArrayWithNullComparator() {
        String[] array = {"banana", "apple", "orange"};
        Comparator<String> comparator = null;
        String[] expected = {"apple", "banana", "orange"};
        assertArrayEquals(expected, ArraySorter.sort(array, comparator));
    }

    @Test
    public void testSortObjectArrayWithNullArray() {
        String[] array = null;
        assertNull(ArraySorter.sort(array));
    }

    @Test
    public void testSortEmptyObjectArray() {
        String[] array = {};
        String[] expected = {};
        assertArrayEquals(expected, ArraySorter.sort(array));
    }


}