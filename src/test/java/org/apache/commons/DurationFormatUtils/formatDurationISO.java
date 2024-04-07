import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class formatDurationISOTest {

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        private DurationFormatUtils durationFormatUtils;

        @BeforeEach
        void setUp() {
            durationFormatUtils = new DurationFormatUtils();
        }

        @Test
        @DisplayName("Test formatDurationISO with duration less than a second")
        void testFormatDurationISOWithLessThanSecond() {
            long durationMillis = 123;
            String expected = "PT0.123S";
            String actual = durationFormatUtils.formatDurationISO(durationMillis);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test formatDurationISO with duration less than a minute")
        void testFormatDurationISOWithLessThanMinute() {
            long durationMillis = 34567;
            String expected = "PT34.567S";
            String actual = durationFormatUtils.formatDurationISO(durationMillis);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test formatDurationISO with duration less than an hour")
        void testFormatDurationISOWithLessThanHour() {
            long durationMillis = 1234567;
            String expected = "PT20M34.567S";
            String actual = durationFormatUtils.formatDurationISO(durationMillis);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test formatDurationISO with duration less than a day")
        void testFormatDurationISOWithLessThanDay() {
            long durationMillis = 98765432;
            String expected = "PT1H23M45.432S";
            String actual = durationFormatUtils.formatDurationISO(durationMillis);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test formatDurationISO with duration less than a month")
        void testFormatDurationISOWithLessThanMonth() {
            long durationMillis = 1234567890;
            String expected = "P14D6H56M7.89S";
            String actual = durationFormatUtils.formatDurationISO(durationMillis);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test formatDurationISO with duration less than a year")
        void testFormatDurationISOWithLessThanYear() {
            long durationMillis = 9876543210L;
            String expected = "P3M25DT23H31M33.21S";
            String actual = durationFormatUtils.formatDurationISO(durationMillis);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test formatDurationISO with duration more than a year")
        void testFormatDurationISOWithMoreThanYear() {
            long durationMillis = 123456789012L;
            String expected = "P3Y68DT5H43M9.012S";
            String actual = durationFormatUtils.formatDurationISO(durationMillis);
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTests {

        private DurationFormatUtils durationFormatUtils;

        @BeforeEach
        void setUp() {
            durationFormatUtils = new DurationFormatUtils();
        }

        @Test
        @DisplayName("Test formatDurationISO with negative duration")
        void testFormatDurationISOWithNegativeDuration() {
            long durationMillis = -123456789;
            assertThrows(IllegalArgumentException.class, () -> {
                durationFormatUtils.formatDurationISO(durationMillis);
            });
        }
    }
}