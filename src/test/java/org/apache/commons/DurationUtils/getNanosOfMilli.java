import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getNanosOfMilliTest {

    private DurationUtils durationUtils;

    @BeforeEach
    void setUp() {
        durationUtils = new DurationUtils();
    }

    @Nested
    @DisplayName("Testing getNanosOfMilli method")
    class TestGetNanosOfMilli {
        
        @Test
        @DisplayName("Test with null duration")
        void testWithNullDuration() {
            Duration duration = null;
            int nanos = durationUtils.getNanosOfMilli(duration);
            
            assertEquals(0, nanos);
        }
        
        @Test
        @DisplayName("Test with duration of 0 nanoseconds")
        void testWithZeroNanoseconds() {
            Duration duration = Duration.ZERO;
            int nanos = durationUtils.getNanosOfMilli(duration);
            
            assertEquals(0, nanos);
        }
        
        @Test
        @DisplayName("Test with duration less than 1 millisecond")
        void testWithDurationLessThanOneMillisecond() {
            Duration duration = Duration.ofNanos(500_000);
            int nanos = durationUtils.getNanosOfMilli(duration);
            
            assertEquals(500_000, nanos);
        }
        
        @Test
        @DisplayName("Test with duration of exactly 1 millisecond")
        void testWithDurationOfOneMillisecond() {
            Duration duration = Duration.ofMillis(1);
            int nanos = durationUtils.getNanosOfMilli(duration);
            
            assertEquals(0, nanos);
        }
        
        @Test
        @DisplayName("Test with duration greater than 1 millisecond")
        void testWithDurationGreaterThanOneMillisecond() {
            Duration duration = Duration.ofMillis(1).plusNanos(500_000);
            int nanos = durationUtils.getNanosOfMilli(duration);
            
            assertEquals(500_000, nanos);
        }
        
        @Test
        @DisplayName("Test with duration of exactly 999 milliseconds and 999,999 nanoseconds")
        void testWithMaxDuration() {
            Duration duration = Duration.ofMillis(999).plusNanos(999_999);
            int nanos = durationUtils.getNanosOfMilli(duration);
            
            assertEquals(999_999, nanos);
        }
        
        @Test
        @DisplayName("Test with duration greater than max duration")
        void testWithDurationGreaterThanMaxDuration() {
            Duration duration = Duration.ofMillis(1_000);
            int nanos = durationUtils.getNanosOfMilli(duration);
            
            assertEquals(0, nanos);
        }
        
    }
}