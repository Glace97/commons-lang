import org.junit.jupiter.api.Test;
import java.util.TimeZone;
import static org.junit.jupiter.api.Assertions.*;

class getGmtTimeZoneTest {

    @Test
    void testGetGmtTimeZone() {
        TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone();
        assertNotNull(gmtTimeZone);
        assertEquals(0, gmtTimeZone.getRawOffset());
    }

    @Test
    void testGetGmtTimeZoneWithZ() {
        TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone("Z");
        assertNotNull(gmtTimeZone);
        assertEquals(0, gmtTimeZone.getRawOffset());
    }

    @Test
    void testGetGmtTimeZoneWithUTC() {
        TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone("UTC");
        assertNotNull(gmtTimeZone);
        assertEquals(0, gmtTimeZone.getRawOffset());
    }

    @Test
    void testGetGmtTimeZoneWithPositiveOffset() {
        TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone("GMT+05:30");
        assertNotNull(gmtTimeZone);
        assertEquals(19800000, gmtTimeZone.getRawOffset());
    }

    @Test
    void testGetGmtTimeZoneWithNegativeOffset() {
        TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone("GMT-02:00");
        assertNotNull(gmtTimeZone);
        assertEquals(-7200000, gmtTimeZone.getRawOffset());
    }

    @Test
    void testGetGmtTimeZoneWithInvalidPattern() {
        TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone("GMT+05:70");
        assertNull(gmtTimeZone);
    }
}