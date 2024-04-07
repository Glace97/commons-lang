import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(Lifecycle.PER_CLASS)
class createInstanceTest {
    private FastDateFormat fastDateFormat;

    @BeforeEach
    void setUp() {
        fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    void createInstance_ValidPatternAndTimeZoneAndLocale_ReturnsFastDateFormatObject() {
        FastDateFormat instance = fastDateFormat.createInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        assertNotNull(instance);
        assertEquals("yyyy-MM-dd HH:mm:ss", instance.printer.getPattern());
        assertEquals(TimeZone.getDefault(), instance.printer.getTimeZone());
        assertEquals(Locale.getDefault(), instance.printer.getLocale());
        assertEquals(null, instance.parser.getCenturyStart());
    }

    @Test
    void createInstance_ValidPatternAndTimeZoneAndLocaleAndCenturyStart_ReturnsFastDateFormatObject() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date centuryStart = sdf.parse("2000-01-01");
        FastDateFormat instance = fastDateFormat.createInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault(), centuryStart);
        assertNotNull(instance);
        assertEquals("yyyy-MM-dd HH:mm:ss", instance.printer.getPattern());
        assertEquals(TimeZone.getDefault(), instance.printer.getTimeZone());
        assertEquals(Locale.getDefault(), instance.printer.getLocale());
        assertEquals(centuryStart, instance.parser.getCenturyStart());
    }

    @Test
    void createInstance_NullPattern_ThrowsNullPointerException() {
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Locale.getDefault();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fastDateFormat.createInstance(null, timeZone, locale);
        });
        assertEquals("pattern cannot be null", exception.getMessage());
    }

    @Test
    void createInstance_NullTimeZone_ThrowsNullPointerException() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        Locale locale = Locale.getDefault();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fastDateFormat.createInstance(pattern, null, locale);
        });
        assertEquals("timeZone cannot be null", exception.getMessage());
    }

    @Test
    void createInstance_NullLocale_ThrowsNullPointerException() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        TimeZone timeZone = TimeZone.getDefault();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fastDateFormat.createInstance(pattern, timeZone, null);
        });
        assertEquals("locale cannot be null", exception.getMessage());
    }
}