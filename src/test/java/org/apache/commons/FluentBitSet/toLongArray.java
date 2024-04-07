import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class toLongArrayTest {
    private FluentBitSet bitSet;

    @Test
    void testEmptyBitSet() {
        bitSet = new FluentBitSet();
        long[] result = bitSet.toLongArray();
        assertEquals(0, result.length);
    }

    @Test
    void testBitSetWithSingleBit() {
        bitSet = new FluentBitSet(1);
        long[] result = bitSet.toLongArray();
        assertEquals(1, result.length);
        assertEquals(0L, result[0]);
    }

    @Test
    void testBitSetWithMultipleBits() {
        bitSet = new FluentBitSet(128);
        bitSet.bitSet.set(0, 64);
        bitSet.bitSet.set(70, 105);
        bitSet.bitSet.set(120, 128);
        long[] result = bitSet.toLongArray();
        assertEquals(2, result.length);
        assertEquals(9223372036854775807L, result[0]);
        assertEquals(8388607L, result[1]);
    }

    @Test
    void testBitSetWithAllBitsSet() {
        bitSet = new FluentBitSet(64);
        bitSet.bitSet.set(0, 64);
        long[] result = bitSet.toLongArray();
        assertEquals(1, result.length);
        assertEquals(-1L, result[0]);
    }
}