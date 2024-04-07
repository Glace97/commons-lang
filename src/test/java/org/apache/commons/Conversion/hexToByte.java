import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hexToByteTest {

    @Test
    void testHexToByteWithEmptyString() {
        byte result = Conversion.hexToByte("", 0, (byte) 0, 0, 0);
        assertEquals((byte) 0, result);
    }

    @Test
    void testHexToByteWithValidHexString() {
        byte result = Conversion.hexToByte("FF", 0, (byte) 0, 0, 1);
        assertEquals((byte) 0xFF, result);
    }

    @Test
    void testHexToByteWithInvalidHexString() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToByte("FF", 0, (byte) 0, 4, 1);
        });
    }

    @Test
    void testHexToByteWithMultipleHexDigits() {
        byte result = Conversion.hexToByte("ABCD", 0, (byte) 0, 0, 2);
        assertEquals((byte) 0xCD, result);
    }

    @Test
    void testHexToByteWithNegativeDstInit() {
        byte result = Conversion.hexToByte("FF", 0, (byte) -1, 0, 1);
        assertEquals((byte) 0xFF, result);
    }

    @Test
    void testHexToByteWithNonZeroDstPos() {
        byte result = Conversion.hexToByte("FF", 0, (byte) 0, 2, 1);
        assertEquals((byte) 0xC0, result);
    }

    @Test
    void testHexToByteWithMultipleHexDigitsAndNonZeroDstPos() {
        byte result = Conversion.hexToByte("ABCD", 0, (byte) 0, 2, 2);
        assertEquals((byte) 0x30, result);
    }

    @Test
    void testHexToByteWithSrcPosGreaterThanZero() {
        byte result = Conversion.hexToByte("ABCD", 1, (byte) 0, 0, 1);
        assertEquals((byte) 0xBC, result);
    }
    
    @Test
    void testHexToByteWithSrcPosGreaterThanZeroAndMultipleHexDigits() {
        byte result = Conversion.hexToByte("ABCD", 1, (byte) 0, 0, 2);
        assertEquals((byte) 0xBC, result);
    }
    
    @Test
    void testHexToByteWithSrcPosGreaterThanZeroAndNonZeroDstPos() {
        byte result = Conversion.hexToByte("ABCD", 1, (byte) 0, 2, 1);
        assertEquals((byte) 0x30, result);
    }
    
    @Test
    void testHexToByteWithSrcPosGreaterThanZeroAndMultipleHexDigitsAndNonZeroDstPos() {
        byte result = Conversion.hexToByte("ABCD", 1, (byte) 0, 2, 2);
        assertEquals((byte) 0x03, result);
    }
}