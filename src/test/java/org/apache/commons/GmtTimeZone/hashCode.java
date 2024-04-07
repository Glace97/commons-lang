import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class hashCodeTest {

    @Test
    void testHashCode() {
        GmtTimeZone gmtTimeZone1 = new GmtTimeZone(false, 0, 0);
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 0, 0);
        
        assertEquals(gmtTimeZone1.hashCode(), gmtTimeZone2.hashCode());
    }

    @Test
    void testHashCodeWithDifferentOffset() {
        GmtTimeZone gmtTimeZone1 = new GmtTimeZone(false, 1, 0);
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 2, 0);

        assertNotEquals(gmtTimeZone1.hashCode(), gmtTimeZone2.hashCode());
    }

    @Test
    void testHashCodeWithDifferentZoneId() {
        GmtTimeZone gmtTimeZone1 = new GmtTimeZone(false, 0, 0);
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 0, 0);
        gmtTimeZone2.zoneId = "GMT+01:00";

        assertNotEquals(gmtTimeZone1.hashCode(), gmtTimeZone2.hashCode());
    }

    @Test
    void testHashCodeWithNullZoneId() {
        GmtTimeZone gmtTimeZone1 = new GmtTimeZone(false, 0, 0);
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 0, 0);
        gmtTimeZone2.zoneId = null;

        assertNotEquals(gmtTimeZone1.hashCode(), gmtTimeZone2.hashCode());
    }

    @Test
    void testHashCodeWithDifferentOffsetAndZoneId() {
        GmtTimeZone gmtTimeZone1 = new GmtTimeZone(false, 1, 0);
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 2, 0);
        gmtTimeZone2.zoneId = "GMT+01:00";

        assertNotEquals(gmtTimeZone1.hashCode(), gmtTimeZone2.hashCode());
    }
}