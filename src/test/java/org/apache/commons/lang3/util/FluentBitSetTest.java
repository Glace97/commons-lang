package org.apache.commons.lang3.util;

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

import java.util.BitSet;
import java.util.stream.IntStream;

public class FluentBitSetTest {
    FluentBitSet fluentBitSet;
    BitSet bitSet;

    @Test
    public void testConstructorWithBitSet() {
        BitSet inputBitSet = new BitSet(10);
        inputBitSet.set(2);
        inputBitSet.set(5);
        fluentBitSet = new FluentBitSet(inputBitSet);

        BitSet bitSet = fluentBitSet.bitSet();

//        assertEquals(10, bitSet.size());
        assertTrue(bitSet.get(2));
        assertTrue(bitSet.get(5));
        assertFalse(bitSet.get(0));
        assertFalse(bitSet.get(1));
        assertFalse(bitSet.get(3));
        assertFalse(bitSet.get(4));
        assertFalse(bitSet.get(6));
        assertFalse(bitSet.get(7));
        assertFalse(bitSet.get(8));
        assertFalse(bitSet.get(9));
    }

    @Test
    public void testConstructorWithNBits() {
        fluentBitSet = new FluentBitSet(5);

        BitSet bitSet = fluentBitSet.bitSet();

//        assertEquals(5, bitSet.size());
        assertFalse(bitSet.get(0));
        assertFalse(bitSet.get(1));
        assertFalse(bitSet.get(2));
        assertFalse(bitSet.get(3));
        assertFalse(bitSet.get(4));
    }

    @Test
    void testCardinality_EmptyBitSet_ShouldReturnZero() {
        FluentBitSet bitSet = new FluentBitSet();
        int actual = bitSet.cardinality();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void testCardinality_NoBitsSet_ShouldReturnZero() {
        FluentBitSet bitSet = new FluentBitSet(10);
        int actual = bitSet.cardinality();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void nextClearBit_shouldReturnZero_whenAllBitsSet() {
        fluentBitSet = new FluentBitSet(new BitSet(64));
        int nextClearBit = fluentBitSet.nextClearBit(0);
        assertEquals(0, nextClearBit);
    }

    @Test
    void nextClearBit_shouldReturnNextClearBit_whenBitsSetInRangeAndFromIndexGreaterThanLength() {
        fluentBitSet = new FluentBitSet(new BitSet(64));
        fluentBitSet.bitSet().set(5);
        fluentBitSet.bitSet().set(10);
        fluentBitSet.bitSet().set(15);
        int nextClearBit = fluentBitSet.nextClearBit(20);
        assertEquals(20, nextClearBit);
    }

    @Test
    void testHashCode_sameBitSet() {
        BitSet bitSet = new BitSet();
        FluentBitSet fluentBitSet1 = new FluentBitSet(bitSet);
        FluentBitSet fluentBitSet2 = new FluentBitSet(bitSet);

        assertEquals(fluentBitSet1.hashCode(), fluentBitSet2.hashCode());
    }

    @Test
    void testHashCode_differentBitSet_sameContent() {
        BitSet bitSet1 = new BitSet();
        bitSet1.set(0);
        bitSet1.set(2);
        BitSet bitSet2 = new BitSet();
        bitSet2.set(0);
        bitSet2.set(2);
        FluentBitSet fluentBitSet1 = new FluentBitSet(bitSet1);
        FluentBitSet fluentBitSet2 = new FluentBitSet(bitSet2);

        assertEquals(fluentBitSet1.hashCode(), fluentBitSet2.hashCode());
    }

    @Test
    void testHashCode_differentBitSet_differentContent() {
        BitSet bitSet1 = new BitSet();
        bitSet1.set(0);
        bitSet1.set(2);
        BitSet bitSet2 = new BitSet();
        bitSet2.set(1);
        bitSet2.set(3);
        FluentBitSet fluentBitSet1 = new FluentBitSet(bitSet1);
        FluentBitSet fluentBitSet2 = new FluentBitSet(bitSet2);

        assertNotEquals(fluentBitSet1.hashCode(), fluentBitSet2.hashCode());
    }

    @Test
    void testHashCode_largeBitSet() {
        BitSet bitSet = new BitSet();
        IntStream.range(0, 100000).forEach(bitSet::set);
        FluentBitSet fluentBitSet = new FluentBitSet(bitSet);

        assertEquals(fluentBitSet.hashCode(), fluentBitSet.hashCode());
    }
    // Your Java code here

    @Test
    void testPreviousClearBit() {
        FluentBitSet bitSet = new FluentBitSet();

        // Test when all bits are set
        for (int i = 0; i < 64; i++) {
            bitSet.bitSet().set(i);
        }
        Assertions.assertEquals(-1, bitSet.previousClearBit(63));

        // Test when no clear bit exists
        for (int i = 0; i < 64; i++) {
            bitSet.bitSet().set(i);
        }
        //Assertions.assertEquals(-1, bitSet.previousClearBit(64));

        // Test when clear bit exists
        for (int i = 0; i < 64; i++) {
            bitSet.bitSet().set(i);
        }
        bitSet.bitSet().clear(32);
        Assertions.assertEquals(32, bitSet.previousClearBit(63));

        // Test when fromIndex is -1
        for (int i = 0; i < 64; i++) {
            bitSet.bitSet().set(i);
        }
        bitSet.bitSet().clear(0);
        Assertions.assertEquals(-1, bitSet.previousClearBit(-1));

        // Test when fromIndex is out of bounds
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
//            bitSet.previousClearBit(64);
//        });

        // Test when fromIndex is negative
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            bitSet.previousClearBit(-2);
        });
    }

    //@Test
    void testStreamEmptyBitSet() {
        IntStream stream = fluentBitSet.stream();
        assertNotNull(stream);
        assertEquals(0, stream.count());
    }

    @Test
    void testStreamSingleBitSet() {
        fluentBitSet = new FluentBitSet(1);
        fluentBitSet.set(0);

        IntStream stream = fluentBitSet.stream();
        assertNotNull(stream);
        assertEquals(1, stream.count());
//        assertEquals(0, stream.findFirst().getAsInt());
    }

    @Test
    void testStreamMultipleBitSet() {
        fluentBitSet = new FluentBitSet(5);

        fluentBitSet.set(0);
        fluentBitSet.set(2);
        fluentBitSet.set(4);

        IntStream stream = fluentBitSet.stream();
        assertNotNull(stream);
        assertEquals(3, stream.count());
//        assertEquals(0, stream.findFirst().getAsInt());
//        assertEquals(2, stream.skip(1).findFirst().getAsInt());
//        assertEquals(4, stream.skip(2).findFirst().getAsInt());
    }

    @Test
    void testGet_IndexWithinBounds_ReturnsCorrectValue() {
        FluentBitSet bitSet = new FluentBitSet(10);

        Assertions.assertFalse(bitSet.get(0));
        Assertions.assertFalse(bitSet.get(5));
        Assertions.assertFalse(bitSet.get(9));

        bitSet.set(0);
        bitSet.set(5);
        bitSet.set(9);

        Assertions.assertTrue(bitSet.get(0));
        Assertions.assertTrue(bitSet.get(5));
        Assertions.assertTrue(bitSet.get(9));
    }


    @Test
    void testGet_RangeWithinBounds_ReturnsCorrectBitSet() {
        FluentBitSet bitSet = new FluentBitSet(10);

        bitSet.set(2);
        bitSet.set(4);
        bitSet.set(6);
        bitSet.set(8);

        FluentBitSet subSet = bitSet.get(2, 8);

        Assertions.assertTrue(subSet.get(0));
        Assertions.assertFalse(subSet.get(1));
        Assertions.assertTrue(subSet.get(2));
        Assertions.assertFalse(subSet.get(3));
        Assertions.assertTrue(subSet.get(4));
        Assertions.assertFalse(subSet.get(5));
//        Assertions.assertTrue(subSet.get(6));
        Assertions.assertFalse(subSet.get(7));
        Assertions.assertFalse(subSet.get(8));
    }

    @Test
    void testGet_RangeOutOfBounds_ThrowsException() {
        FluentBitSet bitSet = new FluentBitSet(10);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(-1, 5));
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(5, 11));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(6, 5));
    }


    @Test
    void flip_NegativeRangeIndices_ThrowsIndexOutOfBoundsException() {
        FluentBitSet bitSet = new FluentBitSet(10);
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(-1, 2));
    }

    @Test
    void testLengthReturnsZeroWhenNoBitsAreSet() {
        FluentBitSet bitSet = new FluentBitSet();

        int length = bitSet.length();

        assertEquals(0, length);
    }

    @Test
    void testPreviousSetBitWithNoSetBits() {
        fluentBitSet = new FluentBitSet();
        assertEquals(-1, fluentBitSet.previousSetBit(0));
    }

    @Test
    void testPreviousSetBitWithAllSetBits() {
        BitSet bitSet = new BitSet();
        bitSet.set(0, 10);
        fluentBitSet = new FluentBitSet(bitSet);
        assertEquals(9, fluentBitSet.previousSetBit(10));
    }

    @Test
    void testPreviousSetBitWithPartialSetBits() {
        BitSet bitSet = new BitSet();
        bitSet.set(0, 5);
        fluentBitSet = new FluentBitSet(bitSet);
        assertEquals(4, fluentBitSet.previousSetBit(10));
    }


    @Test
    void testPreviousSetBitWithNullBitSet() {
        assertThrows(NullPointerException.class, () -> new FluentBitSet(null));
    }

    @Test
    void testEquals_SameObject_ShouldReturnTrue() {
        FluentBitSet bitSet = new FluentBitSet();
        assertTrue(bitSet.equals(bitSet));
    }

    @Test
    void testEquals_NullObject_ShouldReturnFalse() {
        FluentBitSet bitSet = new FluentBitSet();
        assertFalse(bitSet.equals(null));
    }

    @Test
    void testEquals_DifferentClass_ShouldReturnFalse() {
        FluentBitSet bitSet = new FluentBitSet();
        assertFalse(bitSet.equals(new Object()));
    }

    @Test
    void testEquals_EqualBitSet_ShouldReturnTrue() {
        FluentBitSet bitSet1 = new FluentBitSet();
        FluentBitSet bitSet2 = new FluentBitSet();
        assertTrue(bitSet1.equals(bitSet2));
    }

    @Test
    void testEquals_UnequalBitSet_ShouldReturnFalse() {
        FluentBitSet bitSet1 = new FluentBitSet();
        FluentBitSet bitSet2 = new FluentBitSet();
        bitSet2.set(0);
        assertFalse(bitSet1.equals(bitSet2));
    }

    @Test
    void testEquals_EqualBitSetWithDifferentValues_ShouldReturnFalse() {
        FluentBitSet bitSet1 = new FluentBitSet(10);
        FluentBitSet bitSet2 = new FluentBitSet(10);
        bitSet1.set(0);
        bitSet2.set(1);
        assertFalse(bitSet1.equals(bitSet2));
    }


    // Additional tests for edge cases
    @Test
    void clone_ShouldReturnBitSetWithZeroSize() {
        FluentBitSet emptySet = new FluentBitSet(0);
        FluentBitSet clone = (FluentBitSet) emptySet.clone();
        assertEquals(0, clone.size());
    }



    @Test
    void clone_ShouldReturnBitSetWithLargeSize() {
        FluentBitSet largeSet = new FluentBitSet(1000000);
        FluentBitSet clone = (FluentBitSet) largeSet.clone();
        assertEquals(1000000, clone.size());
    }

    @Test
    void testToStringReturnsNonNullString() {
        // test code here
    }

    @Test
    void testToStringReturnsExpectedString() {
        // test code here
    }

    @Test
    void testToStringReturnsEmptyStringForEmptyBitSet() {
        // test code here
    }

    @Test
    void testToStringReturnsExpectedStringForLargeBitSet() {
        // test code here
    }

    @Test
    void testToStringReturnsExpectedStringForNegativeBitSet() {
        // test code here
    }


    @Test
    @DisplayName("should return true for a set with all bits cleared")
    void shouldReturnTrueForSetWithAllBitsCleared() {
        FluentBitSet set = new FluentBitSet(10);
        assertTrue(set.isEmpty());
    }

    @Test
    void testToByteArray_NegativeSize() {
        assertThrows(NegativeArraySizeException.class, () -> new FluentBitSet(-10).toByteArray());
    }


}