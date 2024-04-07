import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class formatDurationHMSTest {

    @Test
    void testFormatDurationHMS() {
        // Test cases with positive duration
        assertEquals("00:00:00.000", DurationFormatUtils.formatDurationHMS(0));
        assertEquals("00:00:01.000", DurationFormatUtils.formatDurationHMS(1000));
        assertEquals("00:01:00.000", DurationFormatUtils.formatDurationHMS(60000));
        assertEquals("01:00:00.000", DurationFormatUtils.formatDurationHMS(3600000));
        assertEquals("24:00:00.000", DurationFormatUtils.formatDurationHMS(86400000));
        assertEquals("8760:00:00.000", DurationFormatUtils.formatDurationHMS(31536000000L));
        
        // Test case with negative duration
        assertThrows(IllegalArgumentException.class, () -> {
            DurationFormatUtils.formatDurationHMS(-1000);
        });
    }
}