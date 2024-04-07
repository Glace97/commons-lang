import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class getTest {

    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testGetReturnsFalseForEmptyBitSet() {
        assertFalse(bitSet.get(0));
    }

    @Test
    void testGetReturnsTrueForSetBit() {
        bitSet.bitSet.set(0);
        assertTrue(bitSet.get(0));
    }

    @Test
    void testGetThrowsIndexOutOfBoundsExceptionForNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(-1));
    }

    @Test
    void testGetReturnsFalseForIndexOutOfRange() {
        assertFalse(bitSet.get(100));
    }

    @Test
    void testGetReturnsCorrectValueForBitSetWithMultipleBitsSet() {
        bitSet.bitSet.set(0);
        bitSet.bitSet.set(2);
        bitSet.bitSet.set(4);
        assertTrue(bitSet.get(0));
        assertFalse(bitSet.get(1));
        assertTrue(bitSet.get(2));
        assertFalse(bitSet.get(3));
        assertTrue(bitSet.get(4));
    }

    @Test
    void testGetReturnsCorrectValueForBitSetWithRangeOfBitsSet() {
        bitSet.bitSet.set(0, 10);
        for (int i = 0; i < 10; i++) {
            assertTrue(bitSet.get(i));
        }
        assertFalse(bitSet.get(10));
    }

    @Test
    void testGetThrowsIndexOutOfBoundsExceptionForNegativeFromIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(-1, 10));
    }

    @Test
    void testGetThrowsIndexOutOfBoundsExceptionForNegativeToIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(0, -1));
    }

    @Test
    void testGetThrowsIndexOutOfBoundsExceptionForFromIndexLargerThanToIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.get(10, 0));
    }

    @Test
    void testGetReturnsEmptyBitSetForEmptyRange() {
        FluentBitSet result = bitSet.get(0, 0);
        assertEquals(new FluentBitSet(), result);
    }

    @Test
    void testGetReturnsBitSetWithRangeOfBits() {
        bitSet.bitSet.set(0, 10);
        FluentBitSet result = bitSet.get(2, 7);
        BitSet expectedBitSet = new BitSet();
        expectedBitSet.set(2, 7);
        FluentBitSet expected = new FluentBitSet(expectedBitSet);
        assertEquals(expected, result);
    }
}