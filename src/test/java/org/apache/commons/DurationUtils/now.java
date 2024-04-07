import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class nowTest {

    private DurationUtils durationUtils;

    @BeforeEach
    void setUp() {
        durationUtils = new DurationUtils();
    }

    @Test
    @DisplayName("Test now method with valid consumer")
    void testNowWithValidConsumer() {
        Instant start = Instant.now();
        Instant result = durationUtils.now(now -> {
            // Do something with now
        });
        assertTrue(start.isBefore(result) || start.equals(result));
    }

    @Test
    @DisplayName("Test now method with null consumer")
    void testNowWithNullConsumer() {
        Instant start = Instant.now();
        Instant result = durationUtils.now(null);
        assertTrue(start.isBefore(result) || start.equals(result));
    }
    
    @Test
    @DisplayName("Test now method with throwing consumer")
    void testNowWithThrowingConsumer() {
        Instant start = Instant.now();
        Instant result = null;
        try {
            result = durationUtils.now(now -> {
                throw new RuntimeException("Exception");
            });
        } catch (RuntimeException e) {
            // Handle exception
        }
        assertTrue(start.isBefore(result) || start.equals(result));
    }

}