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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MutablePairTest {
    @Test
    void testGetLeft() {
        assertEquals("Hello", pair.getLeft());
    }
    @Test
    void testSetValue() {
        assertEquals("hello", pair.setValue("world"));
        assertEquals("world", pair.right);
    }
    
    @Test
    void testSetValueWithNull() {
        assertNull(pair.setValue(null));
        assertNull(pair.right);
    }
    
    @Test
    void testSetValueReturnsOldValue() {
        assertEquals(1, pair.setValue(2));
        assertEquals(2, pair.left);
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
        pair.setLeft(null);
        assertNull(pair.left);
    }
    
    @Test
    void testSetLeftWithValue() {
        pair.setLeft("updated");
        assertEquals("updated", pair.left);
    }
    import org.junit.jupiter.api.Test;
    
    class MutablePairTest {
    
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
        void testOfMethodWithMapEntry() {
            Map.Entry<String, Integer> entry = Map.entry("left", 10);
            MutablePair<String, Integer> pair = MutablePair.of(entry);
            assertEquals(entry.getKey(), pair.left);
            assertEquals(entry.getValue(), pair.right);
        }
    
        @Test
        void testOfMethodWithNullMapEntry() {
            Map.Entry<String, Integer> entry = null;
            MutablePair<String, Integer> pair = MutablePair.of(entry);
            assertNull(pair.left);
            assertNull(pair.right);
        }
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
    void testGetRight() {
        assertEquals(10, pair.getRight());
    }
    
    @Test
    void testGetRightWithNull() {
        MutablePair<String, Integer> pairWithNull = new MutablePair<>("left", null);
        assertNull(pairWithNull.getRight());
    }
    
    @Test
    void testGetRightAfterSetRight() {
        pair.setRight(20);
        assertEquals(20, pair.getRight());
    }
    
    @Test
    void testGetRightAfterSetRightWithNull() {
        pair.setRight(null);
        assertNull(pair.getRight());
    }
    
    @Test
    void testGetRightWithEmptyPair() {
        MutablePair<String, Integer> emptyPair = new MutablePair<>();
        assertNull(emptyPair.getRight());
    }
    
    @Test
    void testGetRightAfterSetLeft() {
        pair.setLeft("new left");
        assertEquals(10, pair.getRight());
    }
    
    @Test
    void testGetRightAfterSetLeftWithNull() {
        pair.setLeft(null);
        assertEquals(10, pair.getRight());
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    class MutablePairTest {
    
        @Test
        void testSetRight() {
            MutablePair<String, Integer> pair = new MutablePair<>("left", 10);
    
            assertNull(pair.right);
    
            pair.setRight("right");
    
            assertEquals("right", pair.right);
        }
    
        @Test
        void testSetRight_Null() {
            MutablePair<String, Integer> pair = new MutablePair<>("left", 10);
    
            assertNotNull(pair.right);
    
            pair.setRight(null);
    
            assertNull(pair.right);
        }
    }

}