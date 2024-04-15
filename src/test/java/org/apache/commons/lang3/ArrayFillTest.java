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

public class ArrayFillTest {
    @Test
    void testFillByteArray() {
        byte[] array = new byte[5];
        byte value = 10;
        byte[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new byte[]{10, 10, 10, 10, 10}, filledArray);
    }

    @Test
    void testFillCharArray() {
        char[] array = new char[5];
        char value = 'A';
        char[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new char[]{'A', 'A', 'A', 'A', 'A'}, filledArray);
    }

    @Test
    void testFillDoubleArray() {
        double[] array = new double[5];
        double value = 5.5;
        double[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new double[]{5.5, 5.5, 5.5, 5.5, 5.5}, filledArray);
    }

    @Test
    void testFillFloatArray() {
        float[] array = new float[5];
        float value = 3.3f;
        float[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new float[]{3.3f, 3.3f, 3.3f, 3.3f, 3.3f}, filledArray);
    }

    @Test
    void testFillIntArray() {
        int[] array = new int[5];
        int value = 100;
        int[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new int[]{100, 100, 100, 100, 100}, filledArray);
    }

    @Test
    void testFillLongArray() {
        long[] array = new long[5];
        long value = 1000L;
        long[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new long[]{1000L, 1000L, 1000L, 1000L, 1000L}, filledArray);
    }

    @Test
    void testFillShortArray() {
        short[] array = new short[5];
        short value = 20;
        short[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new short[]{20, 20, 20, 20, 20}, filledArray);
    }

    @Test
    void testFillObjectArray() {
        String[] array = new String[5];
        String value = "Test";
        String[] filledArray = ArrayFill.fill(array, value);
        assertArrayEquals(new String[]{"Test", "Test", "Test", "Test", "Test"}, filledArray);
    }


}