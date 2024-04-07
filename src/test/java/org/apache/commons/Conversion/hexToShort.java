import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hexToShortTest {

    @Test
    void testHexToShort() {
        // Test case 1: Empty string
        assertEquals(0, Conversion.hexToShort("", 0, (short) 0, 0, 0));

        // Test case 2: Only one character
        assertEquals(0x0F, Conversion.hexToShort("F", 0, (short) 0, 0, 1));
        assertEquals(0x0A, Conversion.hexToShort("A", 0, (short) 0, 0, 1));
        assertEquals(0x00, Conversion.hexToShort("0", 0, (short) 0, 0, 1));

        // Test case 3: Multiple characters
        assertEquals(0x0FF0, Conversion.hexToShort("FF", 0, (short) 0, 0, 2));
        assertEquals(0x0A30, Conversion.hexToShort("A3", 0, (short) 0, 0, 2));
        assertEquals(0x0070, Conversion.hexToShort("07", 0, (short) 0, 0, 2));

        // Test case 4: Maximum number of characters
        assertEquals(0xFFFF, Conversion.hexToShort("FFFF", 0, (short) 0, 0, 4));

        // Test case 5: Maximum number of characters with offset
        assertEquals(0x0FFF, Conversion.hexToShort("FFFF", 1, (short) 0, 0, 3));

        // Test case 6: Maximum number of characters with offset and bit position
        assertEquals(0x03FF, Conversion.hexToShort("FFFF", 1, (short) 0, 2, 3));

        // Test case 7: Exception case
        assertThrows(IllegalArgumentException.class,
                () -> Conversion.hexToShort("FFFF", 0, (short) 0, 13, 4));
    }
}