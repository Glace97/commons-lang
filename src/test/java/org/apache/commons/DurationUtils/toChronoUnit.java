import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class toChronoUnitTest {

    @Test
    void testToChronoUnit_Nanoseconds() {
        ChronoUnit expected = ChronoUnit.NANOS;
        ChronoUnit actual = DurationUtils.toChronoUnit(TimeUnit.NANOSECONDS);
        assertEquals(expected, actual);
    }

    @Test
    void testToChronoUnit_Microseconds() {
        ChronoUnit expected = ChronoUnit.MICROS;
        ChronoUnit actual = DurationUtils.toChronoUnit(TimeUnit.MICROSECONDS);
        assertEquals(expected, actual);
    }

    @Test
    void testToChronoUnit_Milliseconds() {
        ChronoUnit expected = ChronoUnit.MILLIS;
        ChronoUnit actual = DurationUtils.toChronoUnit(TimeUnit.MILLISECONDS);
        assertEquals(expected, actual);
    }

    @Test
    void testToChronoUnit_Seconds() {
        ChronoUnit expected = ChronoUnit.SECONDS;
        ChronoUnit actual = DurationUtils.toChronoUnit(TimeUnit.SECONDS);
        assertEquals(expected, actual);
    }

    @Test
    void testToChronoUnit_Minutes() {
        ChronoUnit expected = ChronoUnit.MINUTES;
        ChronoUnit actual = DurationUtils.toChronoUnit(TimeUnit.MINUTES);
        assertEquals(expected, actual);
    }

    @Test
    void testToChronoUnit_Hours() {
        ChronoUnit expected = ChronoUnit.HOURS;
        ChronoUnit actual = DurationUtils.toChronoUnit(TimeUnit.HOURS);
        assertEquals(expected, actual);
    }

    @Test
    void testToChronoUnit_Days() {
        ChronoUnit expected = ChronoUnit.DAYS;
        ChronoUnit actual = DurationUtils.toChronoUnit(TimeUnit.DAYS);
        assertEquals(expected, actual);
    }

    @Test
    void testToChronoUnit_InvalidTimeUnit() {
        try {
            DurationUtils.toChronoUnit(TimeUnit.MILLISECONDS);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("MILLISECONDS", e.getMessage());
        }
    }
}
Note: This is a basic test suite that covers the main scenarios and edge cases. You may need to add more specific tests depending on your application's requirements.