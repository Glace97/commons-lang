import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class getIDTest {

    private GmtTimeZone gmtTimeZone;

    @BeforeEach
    void setUp() {
        gmtTimeZone = new GmtTimeZone(false, 0, 0);
    }

    @Test
    void testGetID() {
        assertEquals("GMT+00:00", gmtTimeZone.getID());
    }

    @Test
    void testGetIDNegativeOffset() {
        GmtTimeZone gmtTimeZoneNegative = new GmtTimeZone(true, 0, 0);
        assertEquals("GMT-00:00", gmtTimeZoneNegative.getID());
    }

    @Test
    void testGetIDMaxHours() {
        GmtTimeZone gmtTimeZoneMaxHours = new GmtTimeZone(false, 23, 0);
        assertEquals("GMT+23:00", gmtTimeZoneMaxHours.getID());
    }

    @Test
    void testGetIDMaxMinutes() {
        GmtTimeZone gmtTimeZoneMaxMinutes = new GmtTimeZone(false, 0, 59);
        assertEquals("GMT+00:59", gmtTimeZoneMaxMinutes.getID());
    }

    @Test
    void testGetIDMaxOffset() {
        GmtTimeZone gmtTimeZoneMaxOffset = new GmtTimeZone(false, 23, 59);
        assertEquals("GMT+23:59", gmtTimeZoneMaxOffset.getID());
    }

    @Test
    void testGetIDInvalidHours() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 24, 0);
        });
        assertEquals("24 hours out of range", exception.getMessage());
    }

    @Test
    void testGetIDInvalidMinutes() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 0, 60);
        });
        assertEquals("60 minutes out of range", exception.getMessage());
    }

}

Note: The test class assumes that the class `GmtTimeZone` is in a package called `TimeZones`. If the actual package name is different, please update the import statement accordingly.