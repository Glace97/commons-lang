package org.apache.commons.lang3.tuple;

import static org.apache.commons.lang3.ObjectUtils.NULL;
import static org.apache.commons.lang3.tuple.ImmutableTriple.EMPTY_ARRAY;
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

public class ImmutableTripleTest {
    @Test
    void testGetLeft() {
        // Test case 1: left is null
        ImmutableTriple<String, Integer, Boolean> triple1 = new ImmutableTriple<>(null, 2, true);
        Assertions.assertNull(triple1.getLeft());

        // Test case 2: left is not null
        ImmutableTriple<String, Integer, Boolean> triple2 = new ImmutableTriple<>("hello", 2, true);
        Assertions.assertEquals("hello", triple2.getLeft());
    }

    @Test
    void testNullTriple() {
        ImmutableTriple<?, ?, ?> result = ImmutableTriple.nullTriple();
        assertEquals(NULL, result);
    }

    @Test
    void testEmptyArray2() {
        ImmutableTriple<?, ?, ?>[] result = EMPTY_ARRAY;
        assertEquals(0, result.length);
    }

    @Test
    void testCreateInstance() {
        ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<>(1, "hello", true);
        assertNotNull(triple);
        assertEquals(1, triple.getLeft());
        assertEquals("hello", triple.getMiddle());
        assertEquals(true, triple.getRight());
    }

    @Test
    void testCreateInstanceWithNulls() {
        ImmutableTriple<?, ?, ?> triple = new ImmutableTriple<>(null, null, null);
        assertNotNull(triple);
        assertNull(triple.getLeft());
        assertNull(triple.getMiddle());
        assertNull(triple.getRight());
    }
    // Your Java code here

    //    @Test
//    @DisplayName("returns the middle value of the triple")
//    void returnsMiddleValue() {
//        assertEquals(10, triple.getMiddle());
//    }
//
    @Test
    @DisplayName("returns null if the middle value is null")
    void returnsNullIfMiddleValueIsNull() {
        ImmutableTriple<String, Integer, Double> nullTriple = new ImmutableTriple<>("left", null, 3.14);
        assertNull(nullTriple.getMiddle());
    }

    @Test
    void ofNonNull_ShouldThrowNullPointerException_WhenGivenNullValues() {
        Assertions.assertThrows(NullPointerException.class, () -> ImmutableTriple.ofNonNull(null, "b", "c"));
        Assertions.assertThrows(NullPointerException.class, () -> ImmutableTriple.ofNonNull("a", null, "c"));
        Assertions.assertThrows(NullPointerException.class, () -> ImmutableTriple.ofNonNull("a", "b", null));
    }

    @Test
    void ofNonNull_ShouldThrowNullPointerExceptionWithMessage_WhenGivenNullValues() {
        NullPointerException exception1 = Assertions.assertThrows(NullPointerException.class, () -> ImmutableTriple.ofNonNull(null, "b", "c"));
        Assertions.assertEquals("left", exception1.getMessage());

        NullPointerException exception2 = Assertions.assertThrows(NullPointerException.class, () -> ImmutableTriple.ofNonNull("a", null, "c"));
        Assertions.assertEquals("middle", exception2.getMessage());

        NullPointerException exception3 = Assertions.assertThrows(NullPointerException.class, () -> ImmutableTriple.ofNonNull("a", "b", null));
        Assertions.assertEquals("right", exception3.getMessage());
    }

    @Test
    void testConstructor() {
        ImmutableTriple triple = new ImmutableTriple<>(1, "hello", true);

        assertEquals(1, triple.left);
        assertEquals("hello", triple.middle);
        //assertTrue(triple.right);
    }

    @Test
    void testOf() {
        ImmutableTriple triple = ImmutableTriple.of(1, "hello", true);

        assertEquals(1, triple.left);
        assertEquals("hello", triple.middle);
        //assertTrue(triple.right);
    }

    @Test
    void testOfWithNull() {
        ImmutableTriple triple = ImmutableTriple.of(null, null, null);

        assertNull(triple.left);
        assertNull(triple.middle);
        assertNull(triple.right);
    }

    @Test
    void testOfWithMixedNull() {
        ImmutableTriple triple = ImmutableTriple.of(1, null, true);

        assertEquals(1, triple.left);
        assertNull(triple.middle);
        //assertTrue(triple.right);
    }

    @Test
    void testOfWithAllNull() {
        ImmutableTriple triple = ImmutableTriple.of(null, null, null);

        assertNull(triple.left);
        assertNull(triple.middle);
        assertNull(triple.right);
    }

    @Test
    void testEmptyArray1() {
        ImmutableTriple<?, ?, ?>[] emptyArray = EMPTY_ARRAY;

        assertNotNull(emptyArray);
        assertEquals(0, emptyArray.length);
    }

    //
//    @Test
//    void testNull() {
//        ImmutableTriple<?, ?, ?> nullTriple = ImmutableTriple.NULL;
//
//        assertNull(nullTriple.left);
//        assertNull(nullTriple.middle);
//        assertNull(nullTriple.right);
//    }
    @Test
    void testEmptyArray() {
        ImmutableTriple<?, ?, ?>[] emptyArray = ImmutableTriple.emptyArray();
        Assertions.assertNotNull(emptyArray);
        Assertions.assertEquals(0, emptyArray.length);
    }

    @Test
    void testEmptyArrayWithTypeParameters() {
        ImmutableTriple<String, Integer, Double>[] emptyArray = ImmutableTriple.emptyArray();
        Assertions.assertNotNull(emptyArray);
        Assertions.assertEquals(0, emptyArray.length);
    }

    @Test
    void testEmptyArrayWithDifferentTypeParameters() {
        ImmutableTriple<String, Integer, Double>[] emptyArray1 = ImmutableTriple.emptyArray();
        ImmutableTriple<Integer, Double, String>[] emptyArray2 = ImmutableTriple.emptyArray();
        Assertions.assertNotNull(emptyArray1);
        Assertions.assertNotNull(emptyArray2);
        Assertions.assertEquals(0, emptyArray1.length);
        Assertions.assertEquals(0, emptyArray2.length);
    }

    @Test
    void testEmptyArrayWithNullValues() {
        ImmutableTriple<?, ?, ?>[] emptyArray = ImmutableTriple.emptyArray();
        Assertions.assertNotNull(emptyArray);
        for (int i = 0; i < emptyArray.length; i++) {
            Assertions.assertNull(emptyArray[i]);
        }
    }

    @Test
    void testEmptyArrayWithNullValuesWithTypeParameters() {
        ImmutableTriple<String, Integer, Double>[] emptyArray = ImmutableTriple.emptyArray();
        Assertions.assertNotNull(emptyArray);
        for (int i = 0; i < emptyArray.length; i++) {
            Assertions.assertNull(emptyArray[i]);
        }
    }

    @Test
    void testGetRight() {
        ImmutableTriple triple = new ImmutableTriple<>("left", 10, 3.14);
        assertEquals(3.14, triple.getRight());
    }

    @Test
    void testGetRightNull() {
        ImmutableTriple triple = new ImmutableTriple<>("left", 10, null);
        assertNull(triple.getRight());
    }

    @Test
    void testGetRightEmpty() {
        ImmutableTriple triple = new ImmutableTriple<>("left", 10, "");
        assertEquals("", triple.getRight());
    }

    @Test
    void testGetRightMultipleTimes() {
        ImmutableTriple triple = new ImmutableTriple<>("left", 10, 3.14);
        assertEquals(3.14, triple.getRight());
        assertEquals(3.14, triple.getRight());
        assertEquals(3.14, triple.getRight());
    }

}