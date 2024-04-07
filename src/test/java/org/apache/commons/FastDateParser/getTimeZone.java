import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.TimeZone;

class getTimeZoneTest {

    @Test
    void testGetTimeZone() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.US);
        
        // Test valid time zones
        TimeZone timeZone1 = parser.getTimeZone();
        Assertions.assertEquals(TimeZone.getTimeZone("GMT"), timeZone1);
        
        TimeZone timeZone2 = parser.getTimeZone();
        Assertions.assertEquals(TimeZone.getTimeZone("GMT"), timeZone2);
        
        TimeZone timeZone3 = parser.getTimeZone();
        Assertions.assertEquals(TimeZone.getTimeZone("GMT"), timeZone3);
        
        // Test invalid time zone
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("Invalid"), Locale.US);
        TimeZone timeZone4 = parser2.getTimeZone();
        Assertions.assertEquals(TimeZone.getTimeZone("GMT"), timeZone4);
    }
}