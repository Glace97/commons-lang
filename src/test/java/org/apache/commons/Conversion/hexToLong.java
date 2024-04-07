import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hexToLongTest {

    @Test
    void testHexToLongWithEmptyString() {
        long result = Conversion.hexToLong("", 0, 0L, 0, 0);
        assertEquals(0L, result);
    }

    @Test
    void testHexToLongWithZeroLength() {
        long result = Conversion.hexToLong("ABCDEF", 0, 0L, 0, 0);
        assertEquals(0L, result);
    }

    @Test
    void testHexToLongWithValidString() {
        long result = Conversion.hexToLong("ABCDEF", 0, 0L, 0, 6);
        assertEquals(11259375L, result);
    }

    @Test
    void testHexToLongWithOutOfRangePosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToLong("ABCDEF", 0, 0L, 64, 6);
        });
    }

    @Test
    void testHexToLongWithNegativePosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToLong("ABCDEF", 0, 0L, -1, 6);
        });
    }

    @Test
    void testHexToLongWithInvalidHexString() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToLong("GHIJKL", 0, 0L, 0, 6);
        });
    }
    
    @Test
    void testHexToLongWithInvalidHexDigit() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToLong("ABCDEF", 0, 0L, 0, 7);
        });
    }
    
    @Test
    void testHexToLongWithMaxDigits() {
        long result = Conversion.hexToLong("FFFFFFFFFFFFFFFF", 0, 0L, 0, 16);
        assertEquals(-1L, result);
    }
    
    @Test
    void testHexToLongWithMinDigits() {
        long result = Conversion.hexToLong("0", 0, 0L, 0, 1);
        assertEquals(0L, result);
    }
    
    @Test
    void testHexToLongWithRandomDigits() {
        long result = Conversion.hexToLong("123456789ABCDEF", 0, 0L, 0, 15);
        assertEquals(81985529216486895L, result);
    }
    
    @Test
    void testHexToLongWithRandomPosition() {
        long result = Conversion.hexToLong("ABCDEF", 1, 0L, 3, 4);
        assertEquals(50331648L, result);
    }
}