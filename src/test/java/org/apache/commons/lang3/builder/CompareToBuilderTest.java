package org.apache.commons.lang3.builder;

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


import org.junit.jupiter.api.*;

public class CompareToBuilderTest {

    @Test
    void testAppend_boolean() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, true);
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(true, false);
        assertEquals(1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(false, true);
        assertEquals(-1, builder.toComparison());
    }
    
    @Test
    void testAppend_booleanArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new boolean[]{true, true}, new boolean[]{true, true});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new boolean[]{true, true}, new boolean[]{true, false});
        assertEquals(1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new boolean[]{true, false}, new boolean[]{true, true});
        assertEquals(-1, builder.toComparison());
    }
    
    @Test
    void testAppend_byte() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append((byte) 1, (byte) 1);
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append((byte) 1, (byte) 2);
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append((byte) 2, (byte) 1);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_byteArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new byte[]{1, 2}, new byte[]{1, 2});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new byte[]{1, 2}, new byte[]{1, 3});
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new byte[]{2, 2}, new byte[]{1, 2});
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_char() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append('a', 'a');
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append('a', 'b');
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append('b', 'a');
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_charArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'b'}, new char[]{'a', 'b'});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'b'}, new char[]{'a', 'c'});
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new char[]{'b', 'b'}, new char[]{'a', 'b'});
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_double() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1.0, 1.0);
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(1.0, 2.0);
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(2.0, 1.0);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_doubleArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 2.0}, new double[]{1.0, 2.0});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 2.0}, new double[]{1.0, 3.0});
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new double[]{2.0, 2.0}, new double[]{1.0, 2.0});
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_float() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1.0f, 1.0f);
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(1.0f, 2.0f);
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(2.0f, 1.0f);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_floatArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 2.0f}, new float[]{1.0f, 2.0f});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 2.0f}, new float[]{1.0f, 3.0f});
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new float[]{2.0f, 2.0f}, new float[]{1.0f, 2.0f});
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_int() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1, 1);
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(1, 2);
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(2, 1);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_intArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new int[]{1, 2}, new int[]{1, 2});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new int[]{1, 2}, new int[]{1, 3});
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new int[]{2, 2}, new int[]{1, 2});
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_long() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1L, 1L);
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(1L, 2L);
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(2L, 1L);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_longArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new long[]{1L, 2L}, new long[]{1L, 2L});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new long[]{1L, 2L}, new long[]{1L, 3L});
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new long[]{2L, 2L}, new long[]{1L, 2L});
        assertEquals(1, builder.toComparison());
    }

    
    @Test
    void testAppend_short() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append((short) 1, (short) 1);
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append((short) 1, (short) 2);
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append((short) 2, (short) 1);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    void testAppend_shortArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new short[]{1, 2}, new short[]{1, 2});
        assertEquals(0, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new short[]{1, 2}, new short[]{1, 3});
        assertEquals(-1, builder.toComparison());
    
        builder = new CompareToBuilder();
        builder.append(new short[]{2, 2}, new short[]{1, 2});
        assertEquals(1, builder.toComparison());
    }
}