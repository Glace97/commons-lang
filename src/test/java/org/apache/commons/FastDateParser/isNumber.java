import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isNumberTest {

    @Test
    void testIsNumber() {
        FastDateParser parser = new FastDateParser("", TimeZone.getDefault(), Locale.getDefault());

        // Test valid numbers
        assertTrue(parser.isNumber("0"));
        assertTrue(parser.isNumber("12345"));
        assertTrue(parser.isNumber("-6789"));

        // Test invalid numbers
        assertFalse(parser.isNumber("12.34"));
        assertFalse(parser.isNumber("abc"));
        assertFalse(parser.isNumber("123a"));
        assertFalse(parser.isNumber("12-34"));
        assertFalse(parser.isNumber("12 34"));
        assertFalse(parser.isNumber("12,34"));
    }
}