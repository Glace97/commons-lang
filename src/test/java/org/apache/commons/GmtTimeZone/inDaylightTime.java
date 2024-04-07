import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class inDaylightTimeTest {

    private GmtTimeZone gmtTimeZone;

    @BeforeEach
    void setUp() {
        gmtTimeZone = new GmtTimeZone(false, 0, 0);
    }

    @Test
    void testInDaylightTimeReturnsFalse() {
        Date date = new Date();
        assertFalse(gmtTimeZone.inDaylightTime(date));
    }

    @Test
    void testInDaylightTimeReturnsFalseForNullDate() {
        assertFalse(gmtTimeZone.inDaylightTime(null));
    }

    @Test
    void testInDaylightTimeReturnsFalseForFutureDate() {
        Date date = new Date(System.currentTimeMillis() + 86400000); // Adding 1 day
        assertFalse(gmtTimeZone.inDaylightTime(date));
    }

    @Test
    void testInDaylightTimeReturnsFalseForPastDate() {
        Date date = new Date(System.currentTimeMillis() - 86400000); // Subtracting 1 day
        assertFalse(gmtTimeZone.inDaylightTime(date));
    }

    @Test
    void testInDaylightTimeReturnsFalseForEpochDate() {
        Date date = new Date(0);
        assertFalse(gmtTimeZone.inDaylightTime(date));
    }

    @Test
    void testInDaylightTimeReturnsFalseForLeapYearDate() {
        Date date = new Date(2024, 1, 29); // Leap year date
        assertFalse(gmtTimeZone.inDaylightTime(date));
    }

    @Test
    void testInDaylightTimeReturnsFalseForInvalidDate() {
        Date date = new Date(2021, 13, 32); // Invalid date
        assertFalse(gmtTimeZone.inDaylightTime(date));
    }
}