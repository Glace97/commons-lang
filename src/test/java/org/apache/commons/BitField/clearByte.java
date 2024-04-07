import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class clearByteTest {
    private BitField bitField;

    @BeforeEach
    void setUp() {
        bitField = new BitField(0xFF); // Mask with all bits set
    }

    @Test
    void testClearByte() {
        byte holder = (byte) 0b11110000; // Initial value
        byte expected = (byte) 0b00000000; // Expected value
        assertEquals(expected, bitField.clearByte(holder));
    }

    @Test
    void testClearByteWithZeroMask() {
        BitField bitFieldWithZeroMask = new BitField(0x00); // Mask with no bits set
        byte holder = (byte) 0b11110000; // Initial value
        byte expected = (byte) 0b11110000; // Expected value (no change)
        assertEquals(expected, bitFieldWithZeroMask.clearByte(holder));
    }

    @Test
    void testClearByteWithSingleBitMask() {
        BitField bitFieldWithSingleBitMask = new BitField(0x01); // Mask with a single bit set
        byte holder = (byte) 0b11110000; // Initial value
        byte expected = (byte) 0b11110000; // Expected value (no change)
        assertEquals(expected, bitFieldWithSingleBitMask.clearByte(holder));
    }
}