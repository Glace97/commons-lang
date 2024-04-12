package org.apache.commons.lang3.tuple;

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

import java.util.AbstractMap;
import java.util.Map;

import org.junit.jupiter.api.*;

public class ImmutablePairTest {
    ImmutablePair<String, Integer> pair;
    @BeforeEach
    void setup() {
        pair = new ImmutablePair<>("Hello", 123);
    }

//    @Test
//    void testRightWithNonNullValue() {
//
//        pair = ImmutablePair.right(10);
//        Assertions.assertNull(pair.getLeft());
//        Assertions.assertEquals(10, pair.getRight());
//    }
//
//    @Test
//    void testRightWithNullValue() {
//        pair = ImmutablePair.right(null);
//        Assertions.assertNull(pair.getLeft());
//        Assertions.assertNull(pair.getRight());
//    }

    //@Test
    void getLeft_shouldReturnLeftValue() {
        assertEquals(10, pair.getLeft());
    }

    @Test
    void getLeft_shouldReturnNullIfLeftIsNull() {
        ImmutablePair<Integer, String> nullPair = new ImmutablePair<>(null, "Hello");
        assertNull(nullPair.getLeft());
    }

    @Test
    void getLeft_shouldReturnNullIfBothLeftAndRightAreNull() {
        ImmutablePair<Integer, String> nullPair = new ImmutablePair<>(null, null);
        assertNull(nullPair.getLeft());
    }

    @Test
    void testNullPair1() {
        ImmutablePair<?, ?> pair = ImmutablePair.nullPair();

        assertNull(pair.left);
        assertNull(pair.right);
    }

    @Test
    void testNonNullPair() {
        Integer left = 5;
        String right = "test";
        ImmutablePair<Integer, String> pair = new ImmutablePair<>(left, right);

        assertEquals(left, pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testEmptyArray1() {
        ImmutablePair<?, ?>[] array = ImmutablePair.EMPTY_ARRAY;

        assertNotNull(array);
        assertEquals(0, array.length);
    }

//    @Test
//    void testSerializationVersion() {
//        ImmutablePair<?, ?> pair = ImmutablePair.nullPair();
//
//        assertEquals(4954918890077093841L, pair.serialVersionUID);
//    }
//
//    @Test
//    void testLeftWithNonNullValue() {
//        // Arrange
//        String expectedLeft = "Hello";
//
//        // Act
//        ImmutablePair<String, Integer> pair = ImmutablePair.left(expectedLeft);
//
//        // Assert
//        assertEquals(expectedLeft, pair.left);
//        assertNull(pair.right);
//    }
//
//    @Test
//    void testLeftWithNullValue() {
//        // Arrange
//        String expectedLeft = null;
//
//        // Act
//        ImmutablePair<String, Integer> pair = ImmutablePair.left(expectedLeft);
//
//        // Assert
//        assertNull(pair.left);
//        assertNull(pair.right);
//    }
//
//    @Test
//    void testLeftWithNonNullValueAndNonNullRightValue() {
//        // Arrange
//        String expectedLeft = "Hello";
//        Integer expectedRight = 10;
//
//        // Act
//        ImmutablePair<String, Integer> pair = ImmutablePair.left(expectedLeft).right(expectedRight);
//
//        // Assert
//        assertEquals(expectedLeft, pair.left);
//        assertEquals(expectedRight, pair.right);
//    }
//
//    @Test
//    void testLeftWithNonNullValueAndNullRightValue() {
//        // Arrange
//        String expectedLeft = "Hello";
//
//        // Act
//        ImmutablePair<String, Integer> pair = ImmutablePair.left(expectedLeft).right(null);
//
//        // Assert
//        assertEquals(expectedLeft, pair.left);
//        assertNull(pair.right);
//    }
//
//    @Test
//    void testLeftWithNullValueAndNonNullRightValue() {
//        // Arrange
//        Integer expectedRight = 10;
//
//        // Act
//        ImmutablePair<String, Integer> pair = ImmutablePair.<String, Integer>left(null).right(expectedRight);
//
//        // Assert
//        assertNull(pair.left);
//        assertEquals(expectedRight, pair.right);
//    }
//
//    @Test
//    void testLeftWithNullValueAndNullRightValue() {
//        // Act
//        ImmutablePair<String, Integer> pair = ImmutablePair.<String, Integer>left(null).right(null);
//
//        // Assert
//        assertNull(pair.left);
//        assertNull(pair.right);
//    }

    @Test
    void testConstructorWithNonNullValues() {
        // Arrange
        String expectedLeft = "Hello";
        Integer expectedRight = 10;

        // Act
        ImmutablePair<String, Integer> pair = new ImmutablePair<>(expectedLeft, expectedRight);

        // Assert
        assertEquals(expectedLeft, pair.left);
        assertEquals(expectedRight, pair.right);
    }

    @Test
    void testConstructorWithNullValues() {
        // Act
        ImmutablePair<String, Integer> pair = new ImmutablePair<>(null, null);

        // Assert
        assertNull(pair.left);
        assertNull(pair.right);
    }
    // Your Java code here

    @Test
    void testSetValueThrowsUnsupportedOperationException() {
        pair = new ImmutablePair<>("left", 1);
        assertThrows(UnsupportedOperationException.class, () -> pair.setValue(2));
    }

    @Test
    void testOfNonNull_withNonNullValues_shouldReturnImmutablePair() {
        // Arrange
        Integer left = 1;
        String right = "value";

        // Act
        ImmutablePair immutablePair = ImmutablePair.ofNonNull(left, right);

        // Assert
        assertNotNull(immutablePair);
        assertEquals(left, immutablePair.left);
        assertEquals(right, immutablePair.right);
    }

    @Test
    void testOfNonNull_withNullLeftValue_shouldThrowNullPointerException() {
        // Arrange
        Integer left = null;
        String right = "value";

        // Act and Assert
        assertThrows(NullPointerException.class, () -> ImmutablePair.ofNonNull(left, right));
    }

    @Test
    void testOfNonNull_withNullRightValue_shouldThrowNullPointerException() {
        // Arrange
        Integer left = 1;
        String right = null;

        // Act and Assert
        assertThrows(NullPointerException.class, () -> ImmutablePair.ofNonNull(left, right));
    }

    @Test
    void testOfNonNull_withBothNullValues_shouldThrowNullPointerException() {
        // Arrange
        Integer left = null;
        String right = null;

        // Act and Assert
        assertThrows(NullPointerException.class, () -> ImmutablePair.ofNonNull(left, right));
    }

    @Test
    void shouldCreatePairWithNonNullValues() {
        // Arrange
        Integer left = 1;
        String right = "two";

        // Act
        ImmutablePair<Integer, String> pair = ImmutablePair.of(left, right);

        // Assert
        assertEquals(left, pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void shouldCreatePairWithNullValues() {
        // Arrange
        Integer left = null;
        String right = null;

        // Act
        ImmutablePair<Integer, String> pair = ImmutablePair.of(left, right);

        // Assert
        assertNull(pair.left);
        assertNull(pair.right);
    }

    //@Test
    void shouldReturnNullPairWhenBothValuesAreNull() {
        // Arrange
        Integer left = null;
        String right = null;

        // Act
        ImmutablePair<Integer, String> pair = ImmutablePair.of(left, right);

        // Assert
        assertNull(pair);
    }

    @Test
    void shouldCreatePairFromMapEntry() {
        // Arrange
        Map.Entry<Integer, String> entry = new AbstractMap.SimpleEntry<>(1, "two");

        // Act
        ImmutablePair<Integer, String> pair = ImmutablePair.of(entry);

        // Assert
        assertEquals(entry.getKey(), pair.left);
        assertEquals(entry.getValue(), pair.right);
    }

    //@Test
    void shouldReturnNullPairWhenMapEntryIsNull() {
        // Arrange
        Map.Entry<Integer, String> entry = null;

        // Act
        ImmutablePair<Integer, String> pair = ImmutablePair.of(entry);

        // Assert
        assertNull(pair);
    }

    @Test
    void testEmptyArray() {
        ImmutablePair<?, ?>[] emptyArray = ImmutablePair.emptyArray();
        assertNotNull(emptyArray);
        assertEquals(0, emptyArray.length);
    }

//    @Test
//    void testNullPair() {
//        ImmutablePair<?, ?> nullPair = ImmutablePair.NULL;
//        assertNull(nullPair.left);
//        assertNull(nullPair.right);
//    }

    @Test
    void testCreatePairWithNulls() {
        ImmutablePair<?, ?> pair = new ImmutablePair<>(null, null);
        assertNull(pair.left);
        assertNull(pair.right);
    }

    @Test
    void testCreatePairWithNonNulls() {
        Integer left = 1;
        String right = "Hello";
        ImmutablePair<Integer, String> pair = new ImmutablePair<>(left, right);
        assertEquals(left, pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testCreatePairWithNullLeft() {
        String right = "Hello";
        ImmutablePair<String, String> pair = new ImmutablePair<>(null, right);
        assertNull(pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testCreatePairWithNullRight() {
        Integer left = 1;
        ImmutablePair<Integer, Integer> pair = new ImmutablePair<>(left, null);
        assertEquals(left, pair.left);
        assertNull(pair.right);
    }

    @Test
    void testGetRight() {
        assertEquals(123, pair.getRight());
    }

    @Test
    void testGetRight_Null() {
        ImmutablePair<String, Integer> nullPair = new ImmutablePair<>(null, null);
        assertNull(nullPair.getRight());
    }

//    @Test
//    void testGetRight_EmptyArray() {
//        ImmutablePair<String, Integer>[] emptyArray = ImmutablePair.EMPTY_ARRAY;
//        assertEquals(0, emptyArray.length);
//    }
//
//    @Test
//    void testGetRight_SerialVersionUID() {
//        long serialVersionUID = 4954918890077093841L;
//        assertEquals(serialVersionUID, pair.serialVersionUID);
//    }

    @Test
    void testGetRight_Left() {
        assertEquals("Hello", pair.left);
    }

}