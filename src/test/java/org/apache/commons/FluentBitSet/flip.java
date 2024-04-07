import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class flipTest {

    @Test
    void testFlipSingleBit() {
        FluentBitSet bitSet = new FluentBitSet();
        assertFalse(bitSet.bitSet.get(0)); // Initial value is false

        bitSet.flip(0);
        assertTrue(bitSet.bitSet.get(0)); // Bit is flipped to true

        bitSet.flip(0);
        assertFalse(bitSet.bitSet.get(0)); // Bit is flipped back to false
    }

    @Test
    void testFlipRange() {
        FluentBitSet bitSet = new FluentBitSet(5);
        assertFalse(bitSet.bitSet.get(0)); // Initial value is false
        assertFalse(bitSet.bitSet.get(1));
        assertFalse(bitSet.bitSet.get(2));
        assertFalse(bitSet.bitSet.get(3));
        assertFalse(bitSet.bitSet.get(4));

        bitSet.flip(1, 4);
        assertFalse(bitSet.bitSet.get(0)); // Bit 0 remains false
        assertTrue(bitSet.bitSet.get(1)); // Bit 1 is flipped to true
        assertTrue(bitSet.bitSet.get(2)); // Bit 2 is flipped to true
        assertTrue(bitSet.bitSet.get(3)); // Bit 3 is flipped to true
        assertFalse(bitSet.bitSet.get(4)); // Bit 4 remains false

        bitSet.flip(1, 4);
        assertFalse(bitSet.bitSet.get(0)); // Bit 0 remains false
        assertFalse(bitSet.bitSet.get(1)); // Bit 1 is flipped back to false
        assertFalse(bitSet.bitSet.get(2)); // Bit 2 is flipped back to false
        assertFalse(bitSet.bitSet.get(3)); // Bit 3 is flipped back to false
        assertFalse(bitSet.bitSet.get(4)); // Bit 4 remains false
    }

    @Test
    void testFlipOutOfBounds() {
        FluentBitSet bitSet = new FluentBitSet(3);
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(-1)); // Negative index
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(3)); // Index greater than size

        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(1, -1)); // Negative index
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(1, 4)); // Index greater than size
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.flip(3, 1)); // fromIndex greater than toIndex
    }
}