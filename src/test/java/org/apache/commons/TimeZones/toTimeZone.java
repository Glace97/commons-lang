import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TimeZonesTest {

    @Nested
    @DisplayName("toTimeZone method")
    class ToTimeZoneMethod {

        private TimeZone timeZone;

        @BeforeEach
        void setUp() {
            timeZone = TimeZone.getTimeZone("GMT");
        }

        @Test
        @DisplayName("should return the given TimeZone if non-null")
        void shouldReturnGivenTimeZoneIfNonNull() {
            TimeZone result = TimeZones.toTimeZone(timeZone);
            assertSame(timeZone, result);
        }

        @Test
        @DisplayName("should return default TimeZone if given TimeZone is null")
        void shouldReturnDefaultTimeZoneIfNull() {
            TimeZone result = TimeZones.toTimeZone(null);
            assertEquals(TimeZone.getDefault(), result);
        }

        @Test
        @DisplayName("should return non-null TimeZone")
        void shouldReturnNonNullTimeZone() {
            TimeZone result = TimeZones.toTimeZone(timeZone);
            assertTrue(result != null);
        }
    }
}