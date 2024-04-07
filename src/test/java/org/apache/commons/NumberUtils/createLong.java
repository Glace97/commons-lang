import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class createLongTest {
    
    @Test
    void testCreateLongNull() {
        assertNull(NumberUtils.createLong(null));
    }
    
    @Test
    void testCreateLongEmptyString() {
        assertEquals(0L, NumberUtils.createLong(""));
    }
    
    @Test
    void testCreateLongNegative() {
        assertEquals(-10L, NumberUtils.createLong("-10"));
    }
    
    @Test
    void testCreateLongPositive() {
        assertEquals(10L, NumberUtils.createLong("10"));
    }
    
    @Test
    void testCreateLongHexadecimal() {
        assertEquals(255L, NumberUtils.createLong("0xFF"));
    }
    
    @Test
    void testCreateLongOctal() {
        assertEquals(64L, NumberUtils.createLong("0100"));
    }
    
    @Test
    void testCreateLongInvalidFormat() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createLong("abc");
        });
    }
}