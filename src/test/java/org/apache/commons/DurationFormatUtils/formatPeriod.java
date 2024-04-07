import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

class formatPeriodTest {
    private static final long MILLISECONDS_PER_SECOND = 1000L;
    private static final long MILLISECONDS_PER_MINUTE = 60 * MILLISECONDS_PER_SECOND;
    private static final long MILLISECONDS_PER_HOUR = 60 * MILLISECONDS_PER_MINUTE;
    private static final long MILLISECONDS_PER_DAY = 24 * MILLISECONDS_PER_HOUR;
    private static final long MILLISECONDS_PER_MONTH = 30 * MILLISECONDS_PER_DAY;
    private static final long MILLISECONDS_PER_YEAR = 365 * MILLISECONDS_PER_DAY;

    private static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
    private static final String y = "y";
    private static final String M = "M";
    private static final String d = "d";
    private static final String H = "H";
    private static final String m = "m";
    private static final String s = "s";
    private static final String S = "S";

    private SimpleDateFormat simpleDateFormat;
    private TimeZone timeZone;

    @BeforeEach
    void setUp() {
        simpleDateFormat = new SimpleDateFormat(ISO_EXTENDED_FORMAT_PATTERN);
        timeZone = TimeZone.getDefault();
    }

    @Test
    void testFormatPeriod_WithValidParameters_ReturnsExpectedValue() {
        long startMillis = 0L;
        long endMillis = MILLISECONDS_PER_YEAR;

        String format = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

        String expected = "P0Y0M1DT0H0M0.000S";
        String actual = DurationFormatUtils.formatPeriod(startMillis, endMillis, format);

        assertEquals(expected, actual);
    }

    @Test
    void testFormatPeriod_WithStartMillisGreaterThanEndMillis_ThrowsIllegalArgumentException() {
        long startMillis = 1000L;
        long endMillis = 0L;

        String format = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

        assertThrows(IllegalArgumentException.class, () -> {
            DurationFormatUtils.formatPeriod(startMillis, endMillis, format);
        });
    }

    @Test
    void testFormatPeriod_WithInvalidFormat_ThrowsIllegalArgumentException() {
        long startMillis = 0L;
        long endMillis = MILLISECONDS_PER_YEAR;

        String format = "invalid format";

        assertThrows(IllegalArgumentException.class, () -> {
            DurationFormatUtils.formatPeriod(startMillis, endMillis, format);
        });
    }

    // Add more test cases to achieve high coverage and cover all edge cases
}