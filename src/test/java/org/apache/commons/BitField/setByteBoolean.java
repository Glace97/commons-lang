import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class setByteBooleanTest {

    @Test
    void testSetByteBooleanWithTrueFlag() {
        BitField bitField = new BitField(0xFF);
        byte holder = 0x00;
        byte expected = 0x01;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result);
    }

    @Test
    void testSetByteBooleanWithFalseFlag() {
        BitField bitField = new BitField(0xFF);
        byte holder = 0x01;
        byte expected = 0x00;
        byte result = bitField.setByteBoolean(holder, false);
        assertEquals(expected, result);
    }

    @Test
    void testSetByteBooleanWithZeroMask() {
        BitField bitField = new BitField(0x00);
        byte holder = 0x01;
        byte expected = 0x01;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result);
    }

    @Test
    void testSetByteBooleanWithNonZeroMask() {
        BitField bitField = new BitField(0xF0);
        byte holder = 0x01;
        byte expected = 0x11;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result);
    }

    @Test
    void testSetByteBooleanWithMaxByte() {
        BitField bitField = new BitField(0xFF);
        byte holder = (byte) 0xFF;
        byte expected = (byte) 0xFF;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result);
    }

    @Test
    void testSetByteBooleanWithMinByte() {
        BitField bitField = new BitField(0xFF);
        byte holder = (byte) 0x00;
        byte expected = (byte) 0x01;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result);
    }

}
