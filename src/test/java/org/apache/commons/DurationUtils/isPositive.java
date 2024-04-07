import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class isPositiveTest {

    @Nested
    @DisplayName("Positive Duration")
    class PositiveDuration {

        @Test
        @DisplayName("Returns true for a positive duration")
        void returnsTrueForPositiveDuration() {
            Duration duration = Duration.ofSeconds(10);
            assertTrue(DurationUtils.isPositive(duration));
        }
    }

    @Nested
    @DisplayName("Negative Duration")
    class NegativeDuration {

        @ParameterizedTest
        @ValueSource(longs = {-1, -10, -100})
        @DisplayName("Returns false for a negative duration")
        void returnsFalseForNegativeDuration(long seconds) {
            Duration duration = Duration.ofSeconds(seconds);
            assertFalse(DurationUtils.isPositive(duration));
        }
    }

    @Nested
    @DisplayName("Zero Duration")
    class ZeroDuration {

        @Test
        @DisplayName("Returns false for a zero duration")
        void returnsFalseForZeroDuration() {
            Duration duration = Duration.ZERO;
            assertFalse(DurationUtils.isPositive(duration));
        }
    }
}