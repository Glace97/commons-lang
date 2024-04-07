import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class useDaylightTimeTest {

    @Test
    void testUseDaylightTime_ReturnsFalse() {
        GmtTimeZone timeZone = new GmtTimeZone(false, 0, 0);
        assertFalse(timeZone.useDaylightTime());
    }

    @Test
    void testUseDaylightTime_ReturnsTrue() {
        GmtTimeZone timeZone = new GmtTimeZone(true, 0, 0);
        assertTrue(timeZone.useDaylightTime());
    }

    @Test
    void testUseDaylightTime_ThrowsIllegalArgumentException_HoursOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, 24, 0));
    }

    @Test
    void testUseDaylightTime_ThrowsIllegalArgumentException_MinutesOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, 0, 60));
    }
}