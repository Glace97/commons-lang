import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class toMillisIntTest {

    private static DurationUtils durationUtils;

    @BeforeAll
    static void setUp() {
        durationUtils = new DurationUtils();
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        @ParameterizedTest
        @MethodSource("positiveTestData")
        void testToMillisInt(Duration duration, int expected) {
            int result = durationUtils.toMillisInt(duration);
            assertEquals(expected, result);
        }

        static Stream<Arguments> positiveTestData() {
            return Stream.of(
                    Arguments.of(Duration.ZERO, 0),
                    Arguments.of(Duration.ofMillis(1), 1),
                    Arguments.of(Duration.ofSeconds(1), 1000),
                    Arguments.of(Duration.ofMinutes(1), 60000),
                    Arguments.of(Duration.ofHours(1), 3600000),
                    Arguments.of(Duration.ofDays(1), 86400000),
                    Arguments.of(Duration.ofSeconds(Integer.MAX_VALUE), Integer.MAX_VALUE),
                    Arguments.of(Duration.ofMillis(Integer.MAX_VALUE + 1L), Integer.MAX_VALUE)
            );
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTests {

        @Test
        void testToMillisInt_NullDuration() {
            assertThrows(NullPointerException.class, () -> durationUtils.toMillisInt(null));
        }
    }
}