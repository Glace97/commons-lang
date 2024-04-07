import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class parseIntTest {

    @Test
    void testNullInput() {
        int result = FastTimeZone.parseInt(null);
        assertEquals(0, result);
    }

    @Test
    void testEmptyInput() {
        int result = FastTimeZone.parseInt("");
        assertEquals(0, result);
    }

    @Test
    void testPositiveNumber() {
        int result = FastTimeZone.parseInt("123");
        assertEquals(123, result);
    }

    @Test
    void testNegativeNumber() {
        int result = FastTimeZone.parseInt("-456");
        assertEquals(-456, result);
    }

    @Test
    void testZero() {
        int result = FastTimeZone.parseInt("0");
        assertEquals(0, result);
    }

    @Test
    void testLeadingZeros() {
        int result = FastTimeZone.parseInt("000789");
        assertEquals(789, result);
    }

    @Test
    void testInvalidInput() {
        assertThrows(NumberFormatException.class, () -> {
            FastTimeZone.parseInt("abc");
        });
    }
}