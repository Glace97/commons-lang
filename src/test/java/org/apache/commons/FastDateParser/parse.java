import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class parseTest {

    @Test
    void testParse() {
        // Create a FastDateParser instance
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());

        // Test valid inputs
        assertDoesNotThrow(() -> parser.parse("2022-01-01"));
        assertDoesNotThrow(() -> parser.parse("2022-12-31"));
        assertDoesNotThrow(() -> parser.parse("2000-02-29"));

        // Test invalid inputs
        assertThrows(ParseException.class, () -> parser.parse("2022-13-01")); // Invalid month
        assertThrows(ParseException.class, () -> parser.parse("2022-01-32")); // Invalid day
        assertThrows(ParseException.class, () -> parser.parse("2022-02-30")); // Invalid day for February
    }
}