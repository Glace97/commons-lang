import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class byteToHexTest {

    @Test
    void testByteToHex() {
        // Test empty string
        assertEquals("", Conversion.byteToHex((byte) 0, 0, "", 0, 0));

        // Test valid conversions
        assertEquals("0", Conversion.byteToHex((byte) 0, 0, "", 0, 1));
        assertEquals("1", Conversion.byteToHex((byte) 1, 0, "", 0, 1));
        assertEquals("F", Conversion.byteToHex((byte) 15, 0, "", 0, 1));
        assertEquals("FF", Conversion.byteToHex((byte) 255, 0, "", 0, 2));

        // Test invalid conversions
        assertThrows(IllegalArgumentException.class, () -> Conversion.byteToHex((byte) 0, 0, "", 0, 3));
        assertThrows(IllegalArgumentException.class, () -> Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertThrows(StringIndexOutOfBoundsException.class, () -> Conversion.byteToHex((byte) 0, 0, "", 1, 1));
    }
    
    @Test
    void testByteToHexBoundaryCases() {
        // Test boundary cases
        assertEquals("0", Conversion.byteToHex((byte) 0, 0, "", 0, 1));
        assertEquals("1", Conversion.byteToHex((byte) 0, 1, "", 0, 1));
        assertEquals("2", Conversion.byteToHex((byte) 0, 2, "", 0, 1));
        assertEquals("3", Conversion.byteToHex((byte) 0, 3, "", 0, 1));
        assertEquals("4", Conversion.byteToHex((byte) 0, 4, "", 0, 1));
        assertEquals("5", Conversion.byteToHex((byte) 0, 5, "", 0, 1));
        assertEquals("6", Conversion.byteToHex((byte) 0, 6, "", 0, 1));
        assertEquals("7", Conversion.byteToHex((byte) 0, 7, "", 0, 1));
        assertEquals("8", Conversion.byteToHex((byte) 0, 0, "", 0, 1));
        assertEquals("9", Conversion.byteToHex((byte) 0, 1, "", 0, 1));
        assertEquals("A", Conversion.byteToHex((byte) 0, 2, "", 0, 1));
        assertEquals("B", Conversion.byteToHex((byte) 0, 3, "", 0, 1));
        assertEquals("C", Conversion.byteToHex((byte) 0, 4, "", 0, 1));
        assertEquals("D", Conversion.byteToHex((byte) 0, 5, "", 0, 1));
        assertEquals("E", Conversion.byteToHex((byte) 0, 6, "", 0, 1));
        assertEquals("F", Conversion.byteToHex((byte) 0, 7, "", 0, 1));
    }

    @Test
    void testByteToHexEdgeCases() {
        // Test edge cases
        assertEquals("00", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("01", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("02", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("03", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("04", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("05", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("06", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("07", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("08", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("09", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("0A", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("0B", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("0C", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("0D", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("0E", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("0F", Conversion.byteToHex((byte) 0, 0, "", 0, 2));
        assertEquals("00", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("10", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("20", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("30", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("40", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("50", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("60", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("70", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("80", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("90", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("A0", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("B0", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("C0", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("D0", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("E0", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
        assertEquals("F0", Conversion.byteToHex((byte) 0, 1, "", 0, 2));
    }
}