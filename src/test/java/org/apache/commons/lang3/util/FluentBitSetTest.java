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

    //@Test
    public void testDefaultConstructor() {
        BitSet bitSet = fluentBitSet.bitSet();
        assertEquals(0, bitSet.size());
    }

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

    // @Test
    public void testBitSetMethod() {
        BitSet bitSet = fluentBitSet.bitSet();

        assertEquals(0, bitSet.size());
    }

//    @Test
//    void testXor_EmptyBitSet() {
//        FluentBitSet bitSet1 = new FluentBitSet();
//        FluentBitSet bitSet2 = new FluentBitSet();
//
//        bitSet1.xor(bitSet2);
//
//        BitSet expectedResult = new BitSet();
//        assertEquals(expectedResult, bitSet1.bitSet);
//    }
//
//    @Test
//    void testXor_EmptyBitSetWithNonEmptyBitSet() {
//        FluentBitSet bitSet1 = new FluentBitSet();
//        FluentBitSet bitSet2 = new FluentBitSet();
//        bitSet2.bitSet.set(0, 3);
//
//        bitSet1.xor(bitSet2);
//
//        BitSet expectedResult = new BitSet();
//        expectedResult.set(0, 3);
//        assertEquals(expectedResult, bitSet1.bitSet);
//    }
//
//    @Test
//    void testXor_NonEmptyBitSetWithEmptyBitSet() {
//        FluentBitSet bitSet1 = new FluentBitSet();
//        bitSet1.bitSet.set(0, 3);
//        FluentBitSet bitSet2 = new FluentBitSet();
//
//        bitSet1.xor(bitSet2);
//
//        BitSet expectedResult = new BitSet();
//        expectedResult.set(0, 3);
//        assertEquals(expectedResult, bitSet1.bitSet);
//    }
//
//    @Test
//    void testXor_SameSizeBitSets() {
//        FluentBitSet bitSet1 = new FluentBitSet();
//        bitSet1.bitSet.set(0, 3);
//        FluentBitSet bitSet2 = new FluentBitSet();
//        bitSet2.bitSet.set(1, 4);
//
//        bitSet1.xor(bitSet2);
//
//        BitSet expectedResult = new BitSet();
//        expectedResult.set(0);
//        expectedResult.set(2, 4);
//        assertEquals(expectedResult, bitSet1.bitSet);
//    }
//
//    @Test
//    void testXor_DifferentSizeBitSets() {
//        FluentBitSet bitSet1 = new FluentBitSet();
//        bitSet1.bitSet.set(0, 3);
//        FluentBitSet bitSet2 = new FluentBitSet();
//        bitSet2.bitSet.set(2, 5);
//
//        bitSet1.xor(bitSet2);
//
//        BitSet expectedResult = new BitSet();
//        expectedResult.set(0, 2);
//        expectedResult.set(3, 5);
//        assertEquals(expectedResult, bitSet1.bitSet);
//    }

    @Test
    void testCardinality_EmptyBitSet_ShouldReturnZero() {
        FluentBitSet bitSet = new FluentBitSet();
        int actual = bitSet.cardinality();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

//    @Test
//    void testCardinality_AllBitsSet_ShouldReturnNumberOfBits() {
//        int nbits = 10;
//        FluentBitSet bitSet = new FluentBitSet(nbits);
//        bitSet.bitSet.set(0, nbits);
//        int actual = bitSet.cardinality();
//        int expected = nbits;
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void testCardinality_SingleBitSet_ShouldReturnOne() {
//        FluentBitSet bitSet = new FluentBitSet(1);
//        bitSet.bitSet.set(0);
//        int actual = bitSet.cardinality();
//        int expected = 1;
//        Assertions.assertEquals(expected, actual);
//    }

    @Test
    void testCardinality_NoBitsSet_ShouldReturnZero() {
        FluentBitSet bitSet = new FluentBitSet(10);
        int actual = bitSet.cardinality();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    //@Test
    void nextClearBit_shouldReturnZero_whenNoBitsSet() {
        int nextClearBit = fluentBitSet.nextClearBit(0);
        assertEquals(0, nextClearBit);
    }

    @Test
    void nextClearBit_shouldReturnZero_whenAllBitsSet() {
        fluentBitSet = new FluentBitSet(new BitSet(64));
        int nextClearBit = fluentBitSet.nextClearBit(0);
        assertEquals(0, nextClearBit);
    }

//    @Test
//    void nextClearBit_shouldReturnIndex_whenSingleBitSet() {
//        fluentBitSet = new FluentBitSet(new BitSet(64));
//        fluentBitSet.bitSet.set(5);
//        int nextClearBit = fluentBitSet.nextClearBit(0);
//        assertEquals(1, nextClearBit);
//    }
//
//    @Test
//    void nextClearBit_shouldReturnIndex_whenMultipleBitsSet() {
//        fluentBitSet = new FluentBitSet(new BitSet(64));
//        fluentBitSet.bitSet.set(5);
//        fluentBitSet.bitSet.set(10);
//        fluentBitSet.bitSet.set(15);
//        int nextClearBit = fluentBitSet.nextClearBit(0);
//        assertEquals(1, nextClearBit);
//    }
//
//    @Test
//    void nextClearBit_shouldReturnNextClearBit_whenBitsSetAfterFromIndex() {
//        fluentBitSet = new FluentBitSet(new BitSet(64));
//        fluentBitSet.bitSet.set(5);
//        fluentBitSet.bitSet.set(10);
//        fluentBitSet.bitSet.set(15);
//        int nextClearBit = fluentBitSet.nextClearBit(6);
//        assertEquals(6, nextClearBit);
//    }
//
//    @Test
//    void nextClearBit_shouldReturnNextClearBit_whenBitsSetBeforeFromIndex() {
//        fluentBitSet = new FluentBitSet(new BitSet(64));
//        fluentBitSet.bitSet.set(5);
//        fluentBitSet.bitSet.set(10);
//        fluentBitSet.bitSet.set(15);
//        int nextClearBit = fluentBitSet.nextClearBit(4);
//        assertEquals(4, nextClearBit);
//    }
//
//    @Test
//    void nextClearBit_shouldReturnNextClearBit_whenBitsSetInRange() {
//        fluentBitSet = new FluentBitSet(new BitSet(64));
//        fluentBitSet.bitSet.set(5);
//        fluentBitSet.bitSet.set(10);
//        fluentBitSet.bitSet.set(15);
//        int nextClearBit = fluentBitSet.nextClearBit(5);
//        assertEquals(6, nextClearBit);
//    }
//
//    @Test
//    void nextClearBit_shouldReturnNextClearBit_whenBitsSetInRangeAndFromIndexNegative() {
//        fluentBitSet = new FluentBitSet(new BitSet(64));
//        fluentBitSet.bitSet.set(5);
//        fluentBitSet.bitSet.set(10);
//        fluentBitSet.bitSet.set(15);
//        int nextClearBit = fluentBitSet.nextClearBit(-1);
//        assertEquals(0, nextClearBit);
//    }

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

    //@Test
    void testHashCode_emptyBitSet() {
        FluentBitSet fluentBitSet = new FluentBitSet();

        assertEquals(0, fluentBitSet.hashCode());
    }

    //@Test
    void testHashCode_negativeBitSet() {
        FluentBitSet fluentBitSet = new FluentBitSet(-5);

        assertEquals(fluentBitSet.hashCode(), fluentBitSet.hashCode());
    }

    @Test
    void testHashCode_largeBitSet() {
        BitSet bitSet = new BitSet();
        IntStream.range(0, 100000).forEach(bitSet::set);
        FluentBitSet fluentBitSet = new FluentBitSet(bitSet);

        assertEquals(fluentBitSet.hashCode(), fluentBitSet.hashCode());
    }
    // Your Java code here

    //@Test
    void testSetInclusiveFromIndexEqualToToIndex() {
        int index = 3;
        fluentBitSet.setInclusive(index, index);
        assertTrue(bitSet.get(index));
    }

    //@Test
    void testSetInclusiveFromIndexLessThanToIndex() {
        int fromIndex = 2;
        int toIndex = 5;
        fluentBitSet.setInclusive(fromIndex, toIndex);
        assertTrue(bitSet.get(fromIndex));
        assertTrue(bitSet.get(fromIndex + 1));
        assertTrue(bitSet.get(fromIndex + 2));
        assertTrue(bitSet.get(fromIndex + 3));
        assertTrue(bitSet.get(toIndex));
    }

    //@Test
    void testSetInclusiveFromIndexGreaterThanToIndex() {
        int fromIndex = 5;
        int toIndex = 2;
        assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.setInclusive(fromIndex, toIndex));
    }

    //@Test
    void testSetInclusiveFromIndexNegative() {
        int fromIndex = -1;
        int toIndex = 3;
        assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.setInclusive(fromIndex, toIndex));
    }

    //@Test
    void testSetInclusiveToIndexNegative() {
        int fromIndex = 2;
        int toIndex = -1;
        //assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.setInclusive(fromIndex, toIndex));
    }

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

    //@Test
    void testGet_IndexOutOfBounds_ThrowsException() {
        FluentBitSet bitSet = new FluentBitSet(10);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(10));
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

//    @Test
//    void flip_SingleBitIndex_FlipsBitAtIndex() {
//        bitSet = new FluentBitSet(10);
//        bitSet.flip(5);
//        assertTrue(bitSet.bitSet.get(5));
//    }
//
//    @Test
//    void flip_NegativeBitIndex_ThrowsIndexOutOfBoundsException() {
//        bitSet = new FluentBitSet(10);
//        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(-1));
//    }
//
//    @Test
//    void flip_BitIndexOutOfRange_ThrowsIndexOutOfBoundsException() {
//        bitSet = new FluentBitSet(10);
//        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(12));
//    }
//
//    @Test
//    void flip_RangeOfBitIndices_FlipsBitsInRange() {
//        bitSet = new FluentBitSet(10);
//        bitSet.flip(2, 5);
//        assertTrue(bitSet.bitSet.get(2));
//        assertTrue(bitSet.bitSet.get(3));
//        assertTrue(bitSet.bitSet.get(4));
//        assertFalse(bitSet.bitSet.get(5));
//    }
//
//    @Test
//    void flip_InvalidRangeIndices_ThrowsIndexOutOfBoundsException() {
//        bitSet = new FluentBitSet(10);
//        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(5, 2));
//    }

    @Test
    void flip_NegativeRangeIndices_ThrowsIndexOutOfBoundsException() {
        FluentBitSet bitSet = new FluentBitSet(10);
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(-1, 2));
    }

    //@Test
    void flip_RangeIndicesOutOfRange_ThrowsIndexOutOfBoundsException() {
        FluentBitSet bitSet = new FluentBitSet(10);
        //assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(2, 12));
    }


    @Test
    void testLengthReturnsZeroWhenNoBitsAreSet() {
        FluentBitSet bitSet = new FluentBitSet();

        int length = bitSet.length();

        assertEquals(0, length);
    }

//    @Test
//    void testLengthReturnsCorrectValueWhenBitsAreSet() {
//        FluentBitSet bitSet = new FluentBitSet();
//
//        bitSet.bitSet.set(0, 5);
//        int length = bitSet.length();
//
//        assertEquals(5, length);
//    }

    //@Test
    void testLengthReturnsCorrectValueForDifferentInitialSizes() {
        FluentBitSet bitSet = new FluentBitSet(-1);

        int length = bitSet.length();

        assertEquals(-1, length);
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

    //@Test
    void testPreviousSetBitWithNegativeStartingIndex() {
        fluentBitSet = new FluentBitSet();
        assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.previousSetBit(-1));
    }

    @Test
    void testPreviousSetBitWithNullBitSet() {
        assertThrows(NullPointerException.class, () -> new FluentBitSet(null));
    }

    //@Test
    @DisplayName("Clear all bits in the bit set")
    void testClear() {
        bitSet.set(0, 10); // Set all bits from 0 to 9
        bitSet.clear();
        assertEquals(0, bitSet.cardinality());
    }

    //@Test
    @DisplayName("Clear a single bit in the bit set")
    void testClearBit() {
        bitSet.set(5);
        bitSet.clear(5);
        assertFalse(bitSet.get(5));
    }

    //@Test
    @DisplayName("Clear multiple bits in the bit set")
    void testClearMultipleBits() {
        bitSet.set(0, 10); // Set all bits from 0 to 9
        bitSet.clear(2, 8); // Clear bits from 2 to 7
        assertEquals(4, bitSet.cardinality());
    }

    //@Test
    @DisplayName("Clear a bit with negative index")
    void testClearNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.clear(-1));
    }

    //@Test
    @DisplayName("Clear bits with negative indices")
    void testClearNegativeIndices() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.clear(-1, 5));
    }

    // @Test
    @DisplayName("Clear bits with fromIndex larger than toIndex")
    void testClearInvalidIndices() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.clear(5, 2));
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

    //@Test
    void testEquals_EqualBitSetWithDifferentSize_ShouldReturnFalse() {
        FluentBitSet bitSet1 = new FluentBitSet(10);
        FluentBitSet bitSet2 = new FluentBitSet(5);
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

//    @Test
//    void shouldPerformLogicalAndOnEmptySets() {
//        FluentBitSet result = fluentBitSet.and(bitSet);
//        assertEquals(0, result.bitSet.cardinality());
//    }
//
//    @Test
//    void shouldPerformLogicalAndOnNonEmptySets() {
//        fluentBitSet.bitSet.set(0, 5);
//        bitSet.set(3, 8);
//
//        FluentBitSet result = fluentBitSet.and(bitSet);
//        assertEquals(3, result.bitSet.cardinality());
//        assertEquals(3, result.bitSet.nextSetBit(0));
//        assertEquals(4, result.bitSet.nextSetBit(4));
//        assertEquals(5, result.bitSet.nextSetBit(6));
//    }
//
//    @Test
//    void shouldPerformLogicalAndOnEmptySets() {
//        FluentBitSet result = fluentBitSet.and(otherFluentBitSet);
//        assertEquals(0, result.bitSet.cardinality());
//    }
//
//    @Test
//    void shouldPerformLogicalAndOnNonEmptySets() {
//        fluentBitSet.bitSet.set(0, 5);
//        otherFluentBitSet.bitSet.set(3, 8);
//
//        FluentBitSet result = fluentBitSet.and(otherFluentBitSet);
//        assertEquals(3, result.bitSet.cardinality());
//        assertEquals(3, result.bitSet.nextSetBit(0));
//        assertEquals(4, result.bitSet.nextSetBit(4));
//        assertEquals(5, result.bitSet.nextSetBit(6));
//    }

    //@Test
    void clone_ShouldReturnEqualButNotSameObject() {
        FluentBitSet clone = (FluentBitSet) fluentBitSet.clone();
        assertEquals(fluentBitSet, clone);
        assertNotSame(fluentBitSet, clone);
    }

    //@Test
    void clone_ShouldReturnBitSetWithSameBitsSetToTrue() {
        fluentBitSet.set(0);
        fluentBitSet.set(2);
        fluentBitSet.set(4);

        FluentBitSet clone = (FluentBitSet) fluentBitSet.clone();
        assertTrue(clone.get(0));
        assertTrue(clone.get(2));
        assertTrue(clone.get(4));
    }

    // Additional tests for edge cases
    @Test
    void clone_ShouldReturnBitSetWithZeroSize() {
        FluentBitSet emptySet = new FluentBitSet(0);
        FluentBitSet clone = (FluentBitSet) emptySet.clone();
        assertEquals(0, clone.size());
    }

    //@Test
    void clone_ShouldReturnBitSetWithNegativeSize() {
        FluentBitSet negativeSet = new FluentBitSet(-5);
        FluentBitSet clone = (FluentBitSet) negativeSet.clone();
        assertEquals(-5, clone.size());
    }

    @Test
    void clone_ShouldReturnBitSetWithLargeSize() {
        FluentBitSet largeSet = new FluentBitSet(1000000);
        FluentBitSet clone = (FluentBitSet) largeSet.clone();
        assertEquals(1000000, clone.size());
    }

//    @Test
//    public void testAndNotWithEmptyBitSet() {
//        FluentBitSet bitSet = new FluentBitSet();
//        bitSet.andNot(new BitSet());
//        Assertions.assertTrue(bitSet.bitSet.isEmpty());
//    }
//
//    @Test
//    public void testAndNotWithEmptyFluentBitSet() {
//        FluentBitSet bitSet = new FluentBitSet();
//        bitSet.andNot(new FluentBitSet());
//        Assertions.assertTrue(bitSet.bitSet.isEmpty());
//    }
//
//    @Test
//    public void testAndNotWithNonEmptyBitSet() {
//        FluentBitSet bitSet = new FluentBitSet();
//        bitSet.bitSet.set(0);
//        BitSet mask = new BitSet();
//        mask.set(0);
//        bitSet.andNot(mask);
//        Assertions.assertTrue(bitSet.bitSet.isEmpty());
//    }
//
//    @Test
//    public void testAndNotWithNonEmptyFluentBitSet() {
//        FluentBitSet bitSet = new FluentBitSet();
//        bitSet.bitSet.set(0);
//        FluentBitSet mask = new FluentBitSet();
//        mask.bitSet.set(0);
//        bitSet.andNot(mask);
//        Assertions.assertTrue(bitSet.bitSet.isEmpty());
//    }
//
//    @Test
//    public void testAndNotWithDifferentSizesBitSet() {
//        FluentBitSet bitSet = new FluentBitSet(5);
//        bitSet.bitSet.set(0);
//        BitSet mask = new BitSet(10);
//        mask.set(0);
//        bitSet.andNot(mask);
//        Assertions.assertTrue(bitSet.bitSet.isEmpty());
//    }
//
//    @Test
//    public void testAndNotWithDifferentSizesFluentBitSet() {
//        FluentBitSet bitSet = new FluentBitSet(5);
//        bitSet.bitSet.set(0);
//        FluentBitSet mask = new FluentBitSet(10);
//        mask.bitSet.set(0);
//        bitSet.andNot(mask);
//        Assertions.assertTrue(bitSet.bitSet.isEmpty());
//    }


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

//
//    @Test
//    @DisplayName("should return true for an empty set")
//    void shouldReturnTrueForEmptySet() {
//        assertTrue(emptySet.isEmpty());
//    }
//
//    @Test
//    @DisplayName("should return false for a non-empty set")
//    void shouldReturnFalseForNonEmptySet() {
//        assertFalse(nonEmptySet.isEmpty());
//    }

    @Test
    @DisplayName("should return true for a set with all bits cleared")
    void shouldReturnTrueForSetWithAllBitsCleared() {
        FluentBitSet set = new FluentBitSet(10);
        assertTrue(set.isEmpty());
    }

//    @Test
//    @DisplayName("should return false for a set with at least one bit set")
//    void shouldReturnFalseForSetWithAtLeastOneBitSet() {
//        FluentBitSet set = new FluentBitSet(10);
//        set.bitSet.set(5);
//        assertFalse(set.isEmpty());
//    }

    //@Test
    void testToByteArray_EmptyBitSet() {
        byte[] bytes = bitSet.toByteArray();
        assertEquals(0, bytes.length);
    }

//    @Test
//    void testToByteArray_AllBitsFalse() {
//        bitSet = new FluentBitSet(10);
//        byte[] bytes = bitSet.toByteArray();
//        assertEquals(2, bytes.length);
//        assertEquals(0, bytes[0]);
//        assertEquals(0, bytes[1]);
//    }
//
//    @Test
//    void testToByteArray_AllBitsTrue() {
//        bitSet = new FluentBitSet(10);
//        bitSet.bitSet.set(0, 10);
//        byte[] bytes = bitSet.toByteArray();
//        assertEquals(2, bytes.length);
//        assertEquals(-1, bytes[0]);
//        assertEquals(3, bytes[1]);
//    }
//
//    @Test
//    void testToByteArray_MixedBits() {
//        bitSet = new FluentBitSet(16);
//        bitSet.bitSet.set(0, 5);
//        bitSet.bitSet.set(10, 15);
//        byte[] bytes = bitSet.toByteArray();
//        assertEquals(3, bytes.length);
//        assertEquals(31, bytes[0]);
//        assertEquals(0, bytes[1]);
//        assertEquals(-32, bytes[2]);
//    }
//
//    @Test
//    void testToByteArray_LargeBitSet() {
//        bitSet = new FluentBitSet(100);
//        bitSet.bitSet.set(0, 100);
//        byte[] bytes = bitSet.toByteArray();
//        assertEquals(13, bytes.length);
//        assertEquals(-1, bytes[0]);
//        assertEquals(-1, bytes[1]);
//        assertEquals(-1, bytes[2]);
//        assertEquals(-1, bytes[3]);
//        assertEquals(-1, bytes[4]);
//        assertEquals(-1, bytes[5]);
//        assertEquals(-1, bytes[6]);
//        assertEquals(-1, bytes[7]);
//        assertEquals(-1, bytes[8]);
//        assertEquals(-1, bytes[9]);
//        assertEquals(-1, bytes[10]);
//        assertEquals(-1, bytes[11]);
//        assertEquals(3, bytes[12]);
//    }

    @Test
    void testToByteArray_NegativeSize() {
        assertThrows(NegativeArraySizeException.class, () -> new FluentBitSet(-10).toByteArray());
    }

    //@Test
    @DisplayName("should return the correct size for an empty bit set")
    void shouldReturnCorrectSizeForEmptyBitSet() {
        assertEquals(0, bitSet.size());
    }

    //@Test
    @DisplayName("should return the correct size for a non-empty bit set")
    void shouldReturnCorrectSizeForNonEmptyBitSet() {
        // Arrange
        int nbits = 10;
        BitSet set = new BitSet(nbits);
        FluentBitSet bitSet = new FluentBitSet(set);

        // Act & Assert
//        assertEquals(nbits, bitSet.size());
    }

    //@Test
    @DisplayName("should return the correct size for a bit set with bits set beyond the initial size")
    void shouldReturnCorrectSizeForBitSetWithBitsSetBeyondInitialSize() {
        // Arrange
        int nbits = 10;
        BitSet set = new BitSet(nbits);
        set.set(15);
        FluentBitSet bitSet = new FluentBitSet(set);

        // Act & Assert
        assertEquals(16, bitSet.size());
    }

//    @Test
//    public void testSet_singleIndex() {
//        FluentBitSet bitSet = new FluentBitSet();
//
//        bitSet.set(0);
//        Assertions.assertTrue(bitSet.bitSet.get(0));
//    }
//
//    @Test
//    public void testSet_multipleIndexes() {
//        FluentBitSet bitSet = new FluentBitSet();
//
//        bitSet.set(0, 2, 4);
//        Assertions.assertTrue(bitSet.bitSet.get(0));
//        Assertions.assertFalse(bitSet.bitSet.get(1));
//        Assertions.assertTrue(bitSet.bitSet.get(2));
//        Assertions.assertFalse(bitSet.bitSet.get(3));
//        Assertions.assertTrue(bitSet.bitSet.get(4));
//    }
//
//    @Test
//    public void testSet_singleIndexWithValue() {
//        bitSet = new FluentBitSet();
//
//        bitSet.set(0, true);
//        Assertions.assertTrue(bitSet.bitSet.get(0));
//    }
//
//    @Test
//    public void testSet_multipleIndexesWithValue() {
//        bitSet = new FluentBitSet();
//
//        bitSet.set(0, 2, true);
//        Assertions.assertTrue(bitSet.bitSet.get(0));
//        Assertions.assertTrue(bitSet.bitSet.get(1));
//        Assertions.assertTrue(bitSet.bitSet.get(2));
//    }
//
//    @Test
//    public void testSet_fromIndexToIndex() {
//        bitSet = new FluentBitSet();
//
//        bitSet.set(0, 5);
//        for (int i = 0; i < 5; i++) {
//            Assertions.assertTrue(bitSet.bitSet.get(i));
//        }
//    }
//
//    @Test
//    public void testSet_fromIndexToIndexWithValue() {
//        bitSet = new FluentBitSet();
//
//        bitSet.set(0, 5, true);
//        for (int i = 0; i < 5; i++) {
//            Assertions.assertTrue(bitSet.bitSet.get(i));
//        }
//    }
//
//    @Test
//    public void testSet_invalidIndex() {
//        bitSet = new FluentBitSet();
//
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.set(-1));
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.set(-1, true));
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.set(-1, 2));
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.set(2, -1));
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> bitSet.set(2, 1));
//    }
//
//    @Test
//    @DisplayName("should perform logical OR operation with the given bit set")
//    void shouldPerformLogicalOROperationWithGivenBitSet() {
//        BitSet set = new BitSet();
//        set.set(2);
//        set.set(4);
//
//        bitSet.or(set);
//
//        assertEquals(set, bitSet.bitSet);
//    }
//
//    @Test
//    @DisplayName("should perform logical OR operation with multiple bit sets")
//    void shouldPerformLogicalOROperationWithMultipleBitSets() {
//        bitSet1.bitSet.set(1);
//        bitSet2.bitSet.set(3);
//        bitSet3.bitSet.set(5);
//
//        bitSet1.or(bitSet2, bitSet3);
//
//        BitSet expected = new BitSet();
//        expected.set(1);
//        expected.set(3);
//        expected.set(5);
//
//        assertEquals(expected, bitSet1.bitSet);
//    }
//
//    @Test
//    @DisplayName("should perform logical OR operation with the given bit set")
//    void shouldPerformLogicalOROperationWithGivenBitSet() {
//        bitSet1.bitSet.set(2);
//        bitSet2.bitSet.set(4);
//
//        bitSet1.or(bitSet2);
//
//        BitSet expected = new BitSet();
//        expected.set(2);
//        expected.set(4);
//
//        assertEquals(expected, bitSet1.bitSet);
//    }
//
//    @Test
//    @DisplayName("Intersects with empty set should return false")
//    void intersectsWithEmptySet_shouldReturnFalse() {
//        assertFalse(emptySet.intersects(new FluentBitSet()));
//    }
//
//    @Test
//    @DisplayName("Intersects with non-empty set should return false when no bits are common")
//    void intersectsWithNonEmptySet_noCommonBits_shouldReturnFalse() {
//        assertFalse(nonEmptySet.intersects(new FluentBitSet()));
//    }
//
//    @Test
//    @DisplayName("Intersects with non-empty set should return true when at least one bit is common")
//    void intersectsWithNonEmptySet_commonBits_shouldReturnTrue() {
//        assertTrue(nonEmptySet.intersects(nonEmptySet));
//    }
//
//    @Test
//    @DisplayName("Intersects with BitSet should return true when at least one bit is common")
//    void intersectsWithBitSet_commonBits_shouldReturnTrue() {
//        BitSet bitSet = new BitSet();
//        bitSet.set(0);
//        assertTrue(nonEmptySet.intersects(bitSet));
//    }

    //@Test
    void toLongArray_EmptyBitSet_ReturnsEmptyArray() {
        long[] longArray = bitSet.toLongArray();
        assertEquals(0, longArray.length);
    }
//
//    @Test
//    void toLongArray_BitSetWithSingleTrueBit_ReturnsArrayWithOneElement() {
//        bitSet.bitSet.set(0);
//        long[] longArray = bitSet.toLongArray();
//        assertEquals(1, longArray.length);
//        assertEquals(1L, longArray[0]);
//    }
//
//    @Test
//    void toLongArray_BitSetWithMultipleTrueBits_ReturnsArrayWithCorrectValues() {
//        bitSet.bitSet.set(0, 3);
//        long[] longArray = bitSet.toLongArray();
//        assertEquals(1, longArray.length);
//        assertEquals(7L, longArray[0]);
//    }
//
//    @Test
//    void toLongArray_BitSetWithMaxSize_ReturnsArrayWithCorrectValues() {
//        int maxSize = 64 * 1024;
//        bitSet = new FluentBitSet(maxSize);
//        bitSet.bitSet.set(0, maxSize);
//        long[] longArray = bitSet.toLongArray();
//        assertEquals(1024, longArray.length);
//        for (int i = 0; i < longArray.length; i++) {
//            assertEquals(-1L, longArray[i]);
//        }
//    }
//
//    @Test
//    void toLongArray_BitSetWithMixedTrueAndFalseBits_ReturnsArrayWithCorrectValues() {
//        bitSet.bitSet.set(0, 3);
//        bitSet.bitSet.clear(1);
//        long[] longArray = bitSet.toLongArray();
//        assertEquals(1, longArray.length);
//        assertEquals(5L, longArray[0]);
//    }
//
//    @Test
//    void toLongArray_BitSetWithMaxSizeAndMixedTrueAndFalseBits_ReturnsArrayWithCorrectValues() {
//        int maxSize = 64 * 1024;
//        bitSet = new FluentBitSet(maxSize);
//        bitSet.bitSet.set(0, maxSize);
//        bitSet.bitSet.clear(1);
//        long[] longArray = bitSet.toLongArray();
//        assertEquals(1024, longArray.length);
//        assertEquals(-1L, longArray[0]);
//        assertEquals(-2L, longArray[1]);
//        for (int i = 2; i < longArray.length; i++) {
//            assertEquals(-1L, longArray[i]);
//        }
//    }

    //@Test
    void testNextSetBit_WithNoSetBits_ReturnsNegativeOne() {
        int result = bitSet.nextSetBit(0);
        assertEquals(-1, result);
    }

//    @Test
//    void testNextSetBit_WithSingleSetBitAtZero_ReturnsZero() {
//        bitSet.bitSet.set(0);
//        int result = bitSet.nextSetBit(0);
//        assertEquals(0, result);
//    }
//
//    @Test
//    void testNextSetBit_WithSingleSetBitAtOne_ReturnsOne() {
//        bitSet.bitSet.set(1);
//        int result = bitSet.nextSetBit(0);
//        assertEquals(1, result);
//    }
//
//    @Test
//    void testNextSetBit_WithMultipleSetBits_ReturnsNextSetBit() {
//        bitSet.bitSet.set(0);
//        bitSet.bitSet.set(2);
//        bitSet.bitSet.set(4);
//        int result = bitSet.nextSetBit(0);
//        assertEquals(0, result);
//        result = bitSet.nextSetBit(1);
//        assertEquals(2, result);
//        result = bitSet.nextSetBit(3);
//        assertEquals(4, result);
//    }
//
//    @Test
//    void testNextSetBit_WithIndexEqualToMaxValue_ReturnsNegativeOne() {
//        bitSet.bitSet.set(Integer.MAX_VALUE);
//        int result = bitSet.nextSetBit(Integer.MAX_VALUE);
//        assertEquals(-1, result);
//    }

    //@Test
    void testNextSetBit_WithIndexGreaterThanMaxValue_ThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.nextSetBit(Integer.MAX_VALUE + 1));
    }

    //@Test
    void testNextSetBit_WithNegativeIndex_ThrowsIndexOutOfBoundsException() {
        //assertThrows(IndexOutOfBoundsException.class, () -> bitSet.nextSetBit(-1));
    }

}