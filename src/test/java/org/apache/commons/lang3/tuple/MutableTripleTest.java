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


import org.junit.jupiter.api.*;

public class MutableTripleTest {
    //@Test
    void testGetLeft() {
        assertEquals("left", triple.getLeft());
    }

    @Test
    void testGetLeft_Null() {
        MutableTriple<String, Integer, Double> nullTriple = new MutableTriple<>(null, 5, 3.14);
        assertNull(nullTriple.getLeft());
    }

    @Test
    void testGetLeft_Empty() {
        MutableTriple<String, Integer, Double> emptyTriple = new MutableTriple<>("", 5, 3.14);
        assertEquals("", emptyTriple.getLeft());
    }

    @Test
    void testGetLeft_Integer() {
        MutableTriple<Integer, Integer, Double> intTriple = new MutableTriple<>(10, 5, 3.14);
        assertEquals(10, intTriple.getLeft());
    }

    @Test
    void testGetLeft_Double() {
        MutableTriple<Double, Integer, Double> doubleTriple = new MutableTriple<>(3.14, 5, 3.14);
        assertEquals(3.14, doubleTriple.getLeft());
    }

    //@Test
    void setMiddle_shouldSetMiddleElement() {
        assertNull(triple.middle);
        triple.setMiddle("middle");
        assertEquals("middle", triple.middle);
    }

    //@Test
    void setMiddle_shouldSetMiddleElementToNull() {
        triple.setMiddle("middle");
        assertNotNull(triple.middle);
        triple.setMiddle(null);
        assertNull(triple.middle);
    }

    //@Test
    public void testGetMiddle() {
        assertEquals("middle", triple.getMiddle());
    }

    @Test
    public void testGetMiddle_Null() {
        MutableTriple<String, String, String> nullTriple = new MutableTriple<>(null, null, null);
        assertNull(nullTriple.getMiddle());
    }

    @Test
    public void testGetMiddle_EmptyString() {
        MutableTriple<String, String, String> emptyTriple = new MutableTriple<>("", "", "");
        assertEquals("", emptyTriple.getMiddle());
    }

    @Test
    public void testGetMiddle_Integer() {
        MutableTriple<Integer, Integer, Integer> intTriple = new MutableTriple<>(1, 2, 3);
        assertEquals(2, intTriple.getMiddle());
    }

    @Test
    public void testGetMiddle_Object() {
        MutableTriple<Object, Object, Object> objTriple = new MutableTriple<>(new Object(), new Object(), new Object());
        assertSame(objTriple.middle, objTriple.getMiddle());
    }

    @Test
    void testOfNonNull() {
        // Test case 1: All non-null values
        MutableTriple<Integer, String, Double> triple1 = MutableTriple.ofNonNull(1, "two", 3.0);
        assertNotNull(triple1);
        assertEquals(1, triple1.left);
        assertEquals("two", triple1.middle);
        assertEquals(3.0, triple1.right);

        // Test case 2: Null left value
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull(null, "two", 3.0));

        // Test case 3: Null middle value
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull(1, null, 3.0));

        // Test case 4: Null right value
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull(1, "two", null));
    }

    //@Test
    public void testSetLeft() {
        // Test setting left to null
        triple.setLeft(null);
        Assertions.assertNull(triple.left);

        // Test setting left to a non-null value
        triple.setLeft("newLeft");
        Assertions.assertEquals("newLeft", triple.left);
    }

    //@Test
    public void testSetLeftEdgeCases() {
        // Test setting left when it is already null
        triple.setLeft(null);
        triple.setLeft("newLeft");
        Assertions.assertEquals("newLeft", triple.left);

        // Test setting left when it is already a non-null value
        triple.setLeft("left");
        triple.setLeft("newLeft");
        Assertions.assertEquals("newLeft", triple.left);
    }
    // Your Java code here


    private static final Object NULL_OBJECT = null;
    private static final Object NON_NULL_OBJECT = new Object();

    private MutableTriple<Object, Object, Object> triple;

    @Test
    void of_ShouldCreateTripleWithNonNullValues() {
        // Test logic here
    }

    @Test
    void of_ShouldCreateTripleWithNullValues() {
        // Test logic here
    }

    @Test
    void of_ShouldCreateTripleWithMixedNullAndNonNullValues() {
        // Test logic here
    }

    // Add other @Test methods here
    @Test
    void testEmptyArray() {
        MutableTriple<?, ?, ?>[] emptyArray = MutableTriple.emptyArray();

        assertNotNull(emptyArray);
        assertEquals(0, emptyArray.length);
    }

    @Test
    void testEmptyArrayInstance() {
        MutableTriple<?, ?, ?>[] emptyArray1 = MutableTriple.emptyArray();
        MutableTriple<?, ?, ?>[] emptyArray2 = MutableTriple.emptyArray();

        assertSame(emptyArray1, emptyArray2);
    }

//    @Test
//    void testGetRight() {
//        Double expected = 3.0;
//        Double actual = triple.getRight();
//        assertEquals(expected, actual);
//    }

    @Test
    void testGetRightWithNull() {
        MutableTriple<Integer, String, Double> nullTriple = new MutableTriple<>(1, "two", null);
        assertNull(nullTriple.getRight());
    }

    @Test
    void testGetRightWithEmptyTriple() {
        MutableTriple<Integer, String, Double> emptyTriple = new MutableTriple<>();
        assertNull(emptyTriple.getRight());
    }

//    @Test
//    void testGetRightAfterSetRight() {
//        Double expected = 4.0;
//        triple.setRight(4.0);
//        Double actual = triple.getRight();
//        assertEquals(expected, actual);
//    }

    @Test
    void testGetRightAfterSetRightWithNull() {
        MutableTriple<Integer, String, Double> nullTriple = new MutableTriple<>();
        nullTriple.setRight(null);
        assertNull(nullTriple.getRight());
    }

    @Test
    void testGetRightAfterSetRightWithEmptyTriple() {
        MutableTriple<Integer, String, Double> emptyTriple = new MutableTriple<>();
        emptyTriple.setRight(5.0);
        Double expected = 5.0;
        Double actual = emptyTriple.getRight();
        assertEquals(expected, actual);
    }

    @Test
    void testSetRight() {
        // Arrange
        triple = new MutableTriple<>("abc", 123, true);

        // Act
        triple.setRight(null);

        // Assert
        assertNull(triple.right);
    }

    @Test
    void testSetRightWithNonNullValue() {
        // Arrange
        triple = new MutableTriple<>("abc", 123, true);

        // Act
        triple.setRight(false);

        // Assert
        assertEquals(false, triple.right);
    }

}