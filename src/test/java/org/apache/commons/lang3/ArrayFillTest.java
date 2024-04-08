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
    // Your Java code here
    
    @Test
    void shouldFillArrayWithGivenValue() {
        byte value = 3;
        byte[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new byte[]{value, value, value, value, value}, result);
    }
    
    @Test
    void shouldFillArrayWithGivenValue() {
        char value = 'a';
        char[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new char[]{value, value, value, value, value}, result);
    }
    
    @Test
    void shouldFillArrayWithGivenValue() {
        double value = 3.14;
        double[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new double[]{value, value, value, value, value}, result);
    }
    
    @Test
    void shouldFillArrayWithGivenValue() {
        float value = 2.5f;
        float[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new float[]{value, value, value, value, value}, result);
    }
    
    @Test
    void shouldFillArrayWithGivenValue() {
        int value = 42;
        int[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new int[]{value, value, value, value, value}, result);
    }
    
    @Test
    void shouldFillArrayWithGivenValue() {
        long value = 123456789L;
        long[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new long[]{value, value, value, value, value}, result);
    }
    
    @Test
    void shouldFillArrayWithGivenValue() {
        short value = 10;
        short[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new short[]{value, value, value, value, value}, result);
    }
    
    @Test
    void shouldFillArrayWithGivenValue() {
        String value = "test";
        String[] result = ArrayFill.fill(array, value);
        assertArrayEquals(new String[]{value, value, value, value, value}, result);
    }

}