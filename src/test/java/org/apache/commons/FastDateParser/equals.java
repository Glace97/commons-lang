import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEqualsSameObject() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        assertTrue(parser.equals(parser));
    }
    
    @Test
    void testEqualsEqualObjects() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        assertTrue(parser1.equals(parser2));
        assertTrue(parser2.equals(parser1));
    }
    
    @Test
    void testEqualsDifferentPattern() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("dd-MM-yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
        assertFalse(parser1.equals(parser2));
        assertFalse(parser2.equals(parser1));
    }
    
    @Test
    void testEqualsDifferentTimeZone() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("EST"), Locale.US);
        assertFalse(parser1.equals(parser2));
        assertFalse(parser2.equals(parser1));
    }
    
    @Test
    void testEqualsDifferentLocale() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.CANADA);
        assertFalse(parser1.equals(parser2));
        assertFalse(parser2.equals(parser1));
    }
    
    @Test
    void testEqualsNull() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        assertFalse(parser.equals(null));
    }
    
    @Test
    void testEqualsDifferentClass() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        assertFalse(parser.equals("string"));
    }
}