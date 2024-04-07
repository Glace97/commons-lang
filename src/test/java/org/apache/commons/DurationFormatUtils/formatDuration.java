import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

class formatDurationTest {

    @Test
    void testFormatDuration_PositiveDuration() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";
        String result = DurationFormatUtils.formatDuration(durationMillis, format);
        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_NegativeDuration() {
        long durationMillis = -123456789;
        String format = "HH:mm:ss.SSS";
        assertThrows(IllegalArgumentException.class, () -> {
            DurationFormatUtils.formatDuration(durationMillis, format);
        });
    }

    @Test
    void testFormatDuration_NoDays() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";
        String result = DurationFormatUtils.formatDuration(durationMillis, format);
        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_OnlyDays() {
        long durationMillis = 86400000;
        String format = "d";
        String expected = "1";
        String result = DurationFormatUtils.formatDuration(durationMillis, format);
        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_DaysAndHours() {
        long durationMillis = 97200000;
        String format = "d H";
        String expected = "1 3";
        String result = DurationFormatUtils.formatDuration(durationMillis, format);
        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_DaysHoursMinutes() {
        long durationMillis = 123456789;
        String format = "d H:mm";
        String expected = "1 10:17";
        String result = DurationFormatUtils.formatDuration(durationMillis, format);
        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_FullFormat() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";
        String result = DurationFormatUtils.formatDuration(durationMillis, format);
        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_PadWithZeros() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";
        String result = DurationFormatUtils.formatDuration(durationMillis, format, true);
        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_DoNotPadWithZeros() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";
        String result = DurationFormatUtils.formatDuration(durationMillis, format, false);
        assertEquals(expected, result);
    }
}