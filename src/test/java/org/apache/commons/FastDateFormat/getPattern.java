import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getPatternTest {

    @Test
    void testGetPattern() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }

    @Test
    void testGetPatternWithDifferentLocale() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.FRANCE);
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }

    @Test
    void testGetPatternWithDifferentTimeZone() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("CST"), Locale.US);
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }

    @Test
    void testGetPatternWithDifferentPattern() {
        FastDateFormat fastDateFormat = new FastDateFormat("dd-MM-yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
        String pattern = fastDateFormat.getPattern();
        assertEquals("dd-MM-yyyy", pattern);
    }

    @Test
    void testGetPatternWithNullPattern() {
        FastDateFormat fastDateFormat = new FastDateFormat(null, TimeZone.getTimeZone("GMT"), Locale.US);
        String pattern = fastDateFormat.getPattern();
        assertEquals(null, pattern);
    }

    @Test
    void testGetPatternWithNullTimeZone() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", null, Locale.US);
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }

    @Test
    void testGetPatternWithNullLocale() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), null);
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }
}