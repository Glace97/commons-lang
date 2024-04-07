import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EqualsTest {

    @Test
    void testEquals() {
        // Create instances of FastDateFormat with different patterns, time zones, and locales
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateFormat format2 = new FastDateFormat("dd/MM/yyyy", TimeZone.getTimeZone("PST"), Locale.CANADA);
        FastDateFormat format3 = new FastDateFormat("dd MMM yyyy", TimeZone.getTimeZone("JST"), Locale.JAPAN);

        // Create instances of FastDateFormat with the same patterns, time zones, and locales
        FastDateFormat format4 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateFormat format5 = new FastDateFormat("dd/MM/yyyy", TimeZone.getTimeZone("PST"), Locale.CANADA);
        FastDateFormat format6 = new FastDateFormat("dd MMM yyyy", TimeZone.getTimeZone("JST"), Locale.JAPAN);

        // Create an instance of FastDateFormat with a different pattern, time zone, and locale
        FastDateFormat format7 = new FastDateFormat("MM/dd/yyyy", TimeZone.getTimeZone("PST"), Locale.US);

        // Test equality of instances with different patterns, time zones, and locales
        assertFalse(format1.equals(format2));
        assertFalse(format2.equals(format3));
        assertFalse(format3.equals(format1));

        // Test equality of instances with the same patterns, time zones, and locales
        assertTrue(format1.equals(format4));
        assertTrue(format2.equals(format5));
        assertTrue(format3.equals(format6));

        // Test equality of instance with a different pattern, time zone, and locale
        assertFalse(format1.equals(format7));
    }
}