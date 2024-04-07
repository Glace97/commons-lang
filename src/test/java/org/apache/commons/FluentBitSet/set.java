import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.BitSet;
import static org.junit.jupiter.api.Assertions.*;

class setTest {
    private FluentBitSet fluentBitSet;

    @BeforeEach
    void setUp() {
        fluentBitSet = new FluentBitSet();
    }

    @Test
    void testSetSingleBit() {
        fluentBitSet.set(0);
        assertTrue(fluentBitSet.bitSet.get(0));
    }

    @Test
    void testSetMultipleBits() {
        fluentBitSet.set(0, 2);
        assertTrue(fluentBitSet.bitSet.get(0));
        assertTrue(fluentBitSet.bitSet.get(1));
        assertTrue(fluentBitSet.bitSet.get(2));
    }

    @Test
    void testSetBitWithBooleanValue() {
        fluentBitSet.set(0, true);
        assertTrue(fluentBitSet.bitSet.get(0));
    }

    @Test
    void testSetBitsWithBooleanValue() {
        fluentBitSet.set(0, 2, true);
        assertTrue(fluentBitSet.bitSet.get(0));
        assertTrue(fluentBitSet.bitSet.get(1));
        assertFalse(fluentBitSet.bitSet.get(2));
    }

    @Test
    void testSetBitIndexArray() {
        int[] bitIndexArray = {0, 2};
        fluentBitSet.set(bitIndexArray);
        assertTrue(fluentBitSet.bitSet.get(0));
        assertFalse(fluentBitSet.bitSet.get(1));
        assertTrue(fluentBitSet.bitSet.get(2));
    }

    @Test
    void testSetNegativeBitIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.set(-1));
    }

    @Test
    void testSetNegativeFromIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.set(-1, 2));
    }

    @Test
    void testSetNegativeToIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.set(0, -1));
    }

    @Test
    void testSetFromIndexGreaterThanToIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.set(2, 0));
    }
}