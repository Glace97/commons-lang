import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setShortTest {

    @Test
    void testSetShortWithMaskZero() {
        BitField bitField = new BitField(0);
        short holder = 0;
        short result = bitField.setShort(holder);
        assertEquals(holder, result);
    }

    @Test
    void testSetShortWithMaskOne() {
        BitField bitField = new BitField(1);
        short holder = 0;
        short result = bitField.setShort(holder);
        assertEquals((short) 1, result);
    }

    @Test
    void testSetShortWithMaskMaxValue() {
        BitField bitField = new BitField(Short.MAX_VALUE);
        short holder = 0;
        short result = bitField.setShort(holder);
        assertEquals(Short.MAX_VALUE, result);
    }

    @Test
    void testSetShortWithMaskMinValue() {
        BitField bitField = new BitField(Short.MIN_VALUE);
        short holder = 0;
        short result = bitField.setShort(holder);
        assertEquals(Short.MIN_VALUE, result);
    }

    @Test
    void testSetShortWithMaskNegativeValue() {
        BitField bitField = new BitField(-5);
        short holder = 0;
        short result = bitField.setShort(holder);
        assertEquals((short) -5, result);
    }

    @Test
    void testSetShortWithMaskPositiveValue() {
        BitField bitField = new BitField(10);
        short holder = 0;
        short result = bitField.setShort(holder);
        assertEquals((short) 10, result);
    }

    @Test
    void testSetShortWithMaskAllBitsSet() {
        BitField bitField = new BitField(Short.MAX_VALUE);
        short holder = Short.MAX_VALUE;
        short result = bitField.setShort(holder);
        assertEquals(Short.MAX_VALUE, result);
    }

}