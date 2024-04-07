import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class zeroIfNullTest {

    private DurationUtils durationUtils;

    @BeforeEach
    void setUp() {
        durationUtils = new DurationUtils();
    }

    @Nested
    @DisplayName("Tests for zeroIfNull method")
    class zeroIfNullMethodTests {

        @Test
        @DisplayName("Should return the given duration when it is not null")
        void shouldReturnGivenDurationWhenNotNull() {
            // Arrange
            Duration duration = Duration.ofSeconds(10);

            // Act
            Duration result = durationUtils.zeroIfNull(duration);

            // Assert
            assertNotNull(result);
            assertSame(duration, result);
        }

        @ParameterizedTest
        @NullSource
        @DisplayName("Should return Duration.ZERO when the given duration is null")
        void shouldReturnDurationZeroWhenNull(Duration duration) {
            // Act
            Duration result = durationUtils.zeroIfNull(duration);

            // Assert
            assertNotNull(result);
            assertEquals(Duration.ZERO, result);
        }
    }
}