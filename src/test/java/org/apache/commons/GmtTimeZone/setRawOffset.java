
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GmtTimeZoneTest {

    @Nested
    @DisplayName("setRawOffset method")
    class SetRawOffsetTest {

        private GmtTimeZone gmtTimeZone;

        @BeforeEach
        void setUp() {
            gmtTimeZone = new GmtTimeZone(true, 0, 0);
        }

        @Test
        @DisplayName("throws UnsupportedOperationException")
        void throwsUnsupportedOperationException() {
            assertThrows(UnsupportedOperationException.class, () -> gmtTimeZone.setRawOffset(0));
        }
    }

    @Nested
    @DisplayName("GmtTimeZone constructor")
    class GmtTimeZoneConstructorTest {

        @Test
        @DisplayName("throws IllegalArgumentException for hours out of range")
        void throwsIllegalArgumentExceptionForHoursOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(true, 24, 0));
        }

        @Test
        @DisplayName("throws IllegalArgumentException for minutes out of range")
        void throwsIllegalArgumentExceptionForMinutesOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(true, 0, 60));
        }

        @Test
        @DisplayName("sets offset correctly for positive hours and minutes")
        void setsOffsetCorrectlyForPositiveHoursAndMinutes() {
            GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 2, 30);
            assertEquals(2 * 60 * 60 * 1000 + 30 * 60 * 1000, gmtTimeZone.offset);
        }

        @Test
        @DisplayName("sets offset correctly for negative hours and minutes")
        void setsOffsetCorrectlyForNegativeHoursAndMinutes() {
            GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 2, 30);
            assertEquals(-2 * 60 * 60 * 1000 - 30 * 60 * 1000, gmtTimeZone.offset);
        }

        @Test
        @DisplayName("sets zoneId correctly for positive hours and minutes")
        void setsZoneIdCorrectlyForPositiveHoursAndMinutes() {
            GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 2, 30);
            assertEquals("GMT+02:30", gmtTimeZone.zoneId);
        }

        @Test
        @DisplayName("sets zoneId correctly for negative hours and minutes")
        void setsZoneIdCorrectlyForNegativeHoursAndMinutes() {
            GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 2, 30);
            assertEquals("GMT-02:30", gmtTimeZone.zoneId);
        }
    }
}
