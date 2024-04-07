import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DurationUtilsTest {

    @Nested
    @DisplayName("toDuration method")
    class ToDurationTests {
        
        private DurationUtils durationUtils;
        
        @BeforeEach
        void setUp() {
            durationUtils = new DurationUtils();
        }
        
        @Test
        @DisplayName("should return a Duration for positive amount and TimeUnit")
        void shouldReturnDurationForPositiveAmountAndTimeUnit() {
            long amount = 10;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            
            Duration result = durationUtils.toDuration(amount, timeUnit);
            
            assertEquals(amount, result.getSeconds());
        }
        
        @Test
        @DisplayName("should return a Duration for negative amount and TimeUnit")
        void shouldReturnDurationForNegativeAmountAndTimeUnit() {
            long amount = -10;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            
            Duration result = durationUtils.toDuration(amount, timeUnit);
            
            assertEquals(amount, result.getSeconds());
        }
        
        @Test
        @DisplayName("should return zero Duration for zero amount and TimeUnit")
        void shouldReturnZeroDurationForZeroAmountAndTimeUnit() {
            long amount = 0;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            
            Duration result = durationUtils.toDuration(amount, timeUnit);
            
            assertEquals(amount, result.getSeconds());
        }
        
        @Test
        @DisplayName("should throw IllegalArgumentException for null TimeUnit")
        void shouldThrowIllegalArgumentExceptionForNullTimeUnit() {
            long amount = 10;
            TimeUnit timeUnit = null;
            
            assertThrows(IllegalArgumentException.class, () -> {
                durationUtils.toDuration(amount, timeUnit);
            });
        }
        
        // Add more test cases to cover edge cases and achieve high coverage
        
    }
}