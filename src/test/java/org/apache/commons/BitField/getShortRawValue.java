import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getShortRawValueTest {
    private BitField bitField = new BitField(0xFF00);

    @Test
    void testGetShortRawValue() {
        short holder = 0xABCD;
        short expected = 0xBC;
        assertEquals(expected, bitField.getShortRawValue(holder));
    }

    @Test
    void testGetShortRawValueWithZeroMask() {
        BitField bitField = new BitField(0);
        short holder = 0xABCD;
        short expected = 0;
        assertEquals(expected, bitField.getShortRawValue(holder));
    }

    @Test
    void testGetShortRawValueWithAllBitsSet() {
        BitField bitField = new BitField(0xFFFF);
        short holder = 0xABCD;
        short expected = holder;
        assertEquals(expected, bitField.getShortRawValue(holder));
    }

    @Test
    void testGetShortRawValueWithNegativeHolder() {
        short holder = -12345;
        short expected = 0;
        assertEquals(expected, bitField.getShortRawValue(holder));
    }
}