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
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MutablePairTest {


    @Test
    void testSetValueWithNull() {
        MutablePair<Object, Object> pair = new MutablePair<>();
        assertNull(pair.setValue(null));
        assertNull(pair.right);
    }


    @Test
    void testSetValueWithEmptyPair() {
        MutablePair<Integer, String> emptyPair = new MutablePair<>();
        assertNull(emptyPair.setValue("value"));
        assertEquals("value", emptyPair.right);
    }

    @Test
    void testOfNonNull_withNonNullValues_shouldReturnMutablePair() {
        // Arrange
        Integer left = 1;
        String right = "Hello";

        // Act
        MutablePair<Integer, String> pair = MutablePair.ofNonNull(left, right);

        // Assert
        assertNotNull(pair);
        assertEquals(left, pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testOfNonNull_withNullLeftValue_shouldThrowNullPointerException() {
        // Arrange
        Integer left = null;
        String right = "Hello";

        // Act and Assert
        assertThrows(NullPointerException.class, () -> {
            MutablePair.ofNonNull(left, right);
        });
    }

    @Test
    void testOfNonNull_withNullRightValue_shouldThrowNullPointerException() {
        // Arrange
        Integer left = 1;
        String right = null;

        // Act and Assert
        assertThrows(NullPointerException.class, () -> {
            MutablePair.ofNonNull(left, right);
        });
    }

    @Test
    void testOfNonNull_withBothNullValues_shouldThrowNullPointerException() {
        // Arrange
        Integer left = null;
        String right = null;

        // Act and Assert
        assertThrows(NullPointerException.class, () -> {
            MutablePair.ofNonNull(left, right);
        });
    }

    @Test
    void testSetLeft() {
        MutablePair<Object, Object> pair = new MutablePair<>();
        pair.setLeft(null);
        assertNull(pair.left);
    }

    @Test
    void testSetLeftWithValue() {
        MutablePair<Object, Object> pair = new MutablePair<>();
        pair.setLeft("updated");
        assertEquals("updated", pair.left);
    }

    @Test
    void testEmptyConstructor() {
        MutablePair<?, ?> pair = new MutablePair<>();
        assertNull(pair.left);
        assertNull(pair.right);
    }

    @Test
    void testConstructorWithValues() {
        String left = "left";
        Integer right = 10;
        MutablePair<String, Integer> pair = new MutablePair<>(left, right);
        assertEquals(left, pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testOfMethodWithValueParameters() {
        String left = "left";
        Integer right = 10;
        MutablePair<String, Integer> pair = MutablePair.of(left, right);
        assertEquals(left, pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testOfMethodWithNullMapEntry() {
        Map.Entry<String, Integer> entry = null;
        MutablePair<String, Integer> pair = MutablePair.of(entry);
        assertNull(pair.left);
        assertNull(pair.right);
    }

    @Test
    void testEmptyArray() {
        MutablePair<?, ?>[] emptyArray = MutablePair.emptyArray();
        assertEquals(0, emptyArray.length, "Empty array should have length 0");
    }

    @Test
    void testEmptyArrayWithTypeParameters() {
        MutablePair<String, Integer>[] emptyArray = MutablePair.emptyArray();
        assertEquals(0, emptyArray.length, "Empty array should have length 0");
    }

    @Test
    void testEmptyArrayWithDifferentTypeParameters() {
        MutablePair<String, Double>[] emptyArray = MutablePair.emptyArray();
        assertEquals(0, emptyArray.length, "Empty array should have length 0");
    }

    @Test
    void testEmptyArrayWithDifferentTypeParameters2() {
        MutablePair<Integer, Double>[] emptyArray = MutablePair.emptyArray();
        assertEquals(0, emptyArray.length, "Empty array should have length 0");
    }

    @Test
    void testEmptyArrayWithNullTypeParameters() {
        MutablePair<?, ?>[] emptyArray = MutablePair.emptyArray();
        assertArrayEquals(MutablePair.EMPTY_ARRAY, emptyArray, "Empty array should be equal to MutablePair.EMPTY_ARRAY");
    }


    @Test
    void testGetRightWithNull() {
        MutablePair<String, Integer> pairWithNull = new MutablePair<>("left", null);
        assertNull(pairWithNull.getRight());
    }

    @Test
    void testGetRightAfterSetRight() {
        MutablePair<Object, Object> pair = new MutablePair<>();
        pair.setRight(20);
        assertEquals(20, pair.getRight());
    }

    @Test
    void testGetRightAfterSetRightWithNull() {
        MutablePair<Object, Object> pair = new MutablePair<>();
        pair.setRight(null);
        assertNull(pair.getRight());
    }

    @Test
    void testGetRightWithEmptyPair() {
        MutablePair<String, Integer> emptyPair = new MutablePair<>();
        assertNull(emptyPair.getRight());
    }


    @Test
    void testSetRight_Null() {
        MutablePair<String, Integer> pair = new MutablePair<>("left", 10);

        assertNotNull(pair.right);

        pair.setRight(null);

        assertNull(pair.right);
    }

}