import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class sinceTest {

    private Instant startInstant;

    @BeforeEach
    void setup() {
        startInstant = Instant.now();
    }

    @Test
    void testSinceWithInstant() {
        Duration duration = DurationUtils.since(startInstant);
        assertNotNull(duration);
        assertTrue(duration.getSeconds() >= 0);
    }

    @Test
    void testSinceWithTemporal() {
        Temporal temporal = startInstant;
        Duration duration = DurationUtils.since(temporal);
        assertNotNull(duration);
        assertTrue(duration.getSeconds() >= 0);
    }

    @Test
    void testSinceWithPastInstant() {
        Instant pastInstant = startInstant.minus(1, ChronoUnit.DAYS);
        Duration duration = DurationUtils.since(pastInstant);
        assertNotNull(duration);
        assertTrue(duration.getSeconds() >= 0);
    }

    @Test
    void testSinceWithFutureInstant() {
        Instant futureInstant = startInstant.plus(1, ChronoUnit.DAYS);
        Duration duration = DurationUtils.since(futureInstant);
        assertNotNull(duration);
        assertTrue(duration.getSeconds() >= 0);
    }

    @Test
    void testSinceWithNullTemporal() {
        assertThrows(NullPointerException.class, () -> DurationUtils.since(null));
    }
}