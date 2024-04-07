
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DurationFormatUtilsTest {

    @Nested
    class FormatDurationWordsTest {

        private DurationFormatUtils durationFormatUtils;

        @BeforeEach
        void setUp() {
            durationFormatUtils = new DurationFormatUtils();
        }

        @Test
        void testFormatDurationWords_withPositiveDuration() {
            long durationMillis = 123456789;
            String expected = "1 day 10 hours 17 minutes 36 seconds";

            String result = durationFormatUtils.formatDurationWords(durationMillis, false, false);

            assertEquals(expected, result);
        }

        @Test
        void testFormatDurationWords_withZeroDuration() {
            long durationMillis = 0;
            String expected = "0 days 0 hours 0 minutes 0 seconds";

            String result = durationFormatUtils.formatDurationWords(durationMillis, false, false);

            assertEquals(expected, result);
        }

        @Test
        void testFormatDurationWords_withNegativeDuration() {
            long durationMillis = -123456789;
            
            assertThrows(IllegalArgumentException.class, () -> {
                durationFormatUtils.formatDurationWords(durationMillis, false, false);
            });
        }

        @Test
        void testFormatDurationWords_withSuppressLeadingZeroElements() {
            long durationMillis = 123456789;
            String expected = "1 day 10 hours 17 minutes 36 seconds";

            String result = durationFormatUtils.formatDurationWords(durationMillis, true, false);

            assertEquals(expected, result);
        }

        @Test
        void testFormatDurationWords_withSuppressTrailingZeroElements() {
            long durationMillis = 123456789;
            String expected = "1 day 10 hours 17 minutes 36 seconds";

            String result = durationFormatUtils.formatDurationWords(durationMillis, false, true);

            assertEquals(expected, result);
        }

        @Test
        void testFormatDurationWords_withSuppressLeadingAndTrailingZeroElements() {
            long durationMillis = 123456789;
            String expected = "1 day 10 hours 17 minutes 36 seconds";

            String result = durationFormatUtils.formatDurationWords(durationMillis, true, true);

            assertEquals(expected, result);
        }

        @Test
        void testFormatDurationWords_withPlurals() {
            long durationMillis = 3601000; // 1 hour 1 second
            String expected = "0 days 1 hour 0 minutes 1 second";

            String result = durationFormatUtils.formatDurationWords(durationMillis, false, false);

            assertEquals(expected, result);
        }
    }
}
