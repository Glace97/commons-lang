import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

class formatPeriodISOTest {

    private static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
    private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getDefault();

    private static Calendar startCalendar;
    private static Calendar endCalendar;
    private static long startMillis;
    private static long endMillis;

    @BeforeAll
    static void setup() {
        startCalendar = new GregorianCalendar();
        startCalendar.set(Calendar.YEAR, 2020);
        startCalendar.set(Calendar.MONTH, 0);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        startMillis = startCalendar.getTimeInMillis();

        endCalendar = new GregorianCalendar();
        endCalendar.set(Calendar.YEAR, 2021);
        endCalendar.set(Calendar.MONTH, 11);
        endCalendar.set(Calendar.DAY_OF_MONTH, 31);
        endCalendar.set(Calendar.HOUR_OF_DAY, 23);
        endCalendar.set(Calendar.MINUTE, 59);
        endCalendar.set(Calendar.SECOND, 59);
        endCalendar.set(Calendar.MILLISECOND, 999);
        endMillis = endCalendar.getTimeInMillis();
    }

    @Nested
    @DisplayName("Positive Test Cases")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class PositiveTestCases {

        @Test
        void testFormatPeriodISO_Year() {
            String expected = "P1Y";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }

        @Test
        void testFormatPeriodISO_YearMonth() {
            startCalendar.set(Calendar.DAY_OF_MONTH, 15);
            endCalendar.set(Calendar.DAY_OF_MONTH, 15);

            String expected = "P1Y";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }

        @Test
        void testFormatPeriodISO_Month() {
            startCalendar.set(Calendar.YEAR, 2020);
            endCalendar.set(Calendar.YEAR, 2020);
            startCalendar.set(Calendar.DAY_OF_MONTH, 15);
            endCalendar.set(Calendar.DAY_OF_MONTH, 15);

            String expected = "P1M";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }

        @Test
        void testFormatPeriodISO_Day() {
            startCalendar.set(Calendar.YEAR, 2020);
            endCalendar.set(Calendar.YEAR, 2020);
            startCalendar.set(Calendar.MONTH, 0);
            endCalendar.set(Calendar.MONTH, 0);
            startCalendar.set(Calendar.HOUR_OF_DAY, 12);
            endCalendar.set(Calendar.HOUR_OF_DAY, 12);

            String expected = "P1D";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }

        @Test
        void testFormatPeriodISO_Hour() {
            startCalendar.set(Calendar.YEAR, 2020);
            endCalendar.set(Calendar.YEAR, 2020);
            startCalendar.set(Calendar.MONTH, 0);
            endCalendar.set(Calendar.MONTH, 0);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            endCalendar.set(Calendar.DAY_OF_MONTH, 1);

            String expected = "PT24H";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }

        @Test
        void testFormatPeriodISO_Minute() {
            startCalendar.set(Calendar.YEAR, 2020);
            endCalendar.set(Calendar.YEAR, 2020);
            startCalendar.set(Calendar.MONTH, 0);
            endCalendar.set(Calendar.MONTH, 0);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            endCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startCalendar.set(Calendar.HOUR_OF_DAY, 0);
            endCalendar.set(Calendar.HOUR_OF_DAY, 0);

            String expected = "PT1440M";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }

        @Test
        void testFormatPeriodISO_Second() {
            startCalendar.set(Calendar.YEAR, 2020);
            endCalendar.set(Calendar.YEAR, 2020);
            startCalendar.set(Calendar.MONTH, 0);
            endCalendar.set(Calendar.MONTH, 0);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            endCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startCalendar.set(Calendar.HOUR_OF_DAY, 0);
            endCalendar.set(Calendar.HOUR_OF_DAY, 0);
            startCalendar.set(Calendar.MINUTE, 0);
            endCalendar.set(Calendar.MINUTE, 0);

            String expected = "PT86400S";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }

        @Test
        void testFormatPeriodISO_Millisecond() {
            startCalendar.set(Calendar.YEAR, 2020);
            endCalendar.set(Calendar.YEAR, 2020);
            startCalendar.set(Calendar.MONTH, 0);
            endCalendar.set(Calendar.MONTH, 0);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            endCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startCalendar.set(Calendar.HOUR_OF_DAY, 0);
            endCalendar.set(Calendar.HOUR_OF_DAY, 0);
            startCalendar.set(Calendar.MINUTE, 0);
            endCalendar.set(Calendar.MINUTE, 0);
            startCalendar.set(Calendar.SECOND, 0);
            endCalendar.set(Calendar.SECOND, 0);

            String expected = "PT86400000S";
            String actual = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class NegativeTestCases {

        @Test
        void testFormatPeriodISO_StartGreaterThanEnd() {
            assertThrows(IllegalArgumentException.class, () -> {
                DurationFormatUtils.formatPeriodISO(endMillis, startMillis);
            });
        }
    }
}