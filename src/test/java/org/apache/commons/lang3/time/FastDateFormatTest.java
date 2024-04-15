package org.apache.commons.lang3.time;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class FastDateFormatTest {

    @Test
    void testGetMaxLengthEstimate() {
        FastDateFormat fastDateFormat = new FastDateFormat("dd/MM/yyyy", TimeZone.getDefault(), Locale.getDefault());
        int maxLength = fastDateFormat.getMaxLengthEstimate();
        Assertions.assertTrue(maxLength >= 10 && maxLength <= 12);
    }

    @Test
    void testGetMaxLengthEstimate_CustomPattern() {
        FastDateFormat customFormat = new FastDateFormat("dd/MM/yyyy HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        int maxLength = customFormat.getMaxLengthEstimate();
        Assertions.assertEquals(19, maxLength);
    }

    @Test
    void testGetMaxLengthEstimate_CustomLocale() {
        FastDateFormat customLocale = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.FRENCH);
        int maxLength = customLocale.getMaxLengthEstimate();
        Assertions.assertTrue(maxLength >= 9 && maxLength <= 11);
    }

    @Test
    void testGetMaxLengthEstimate_CustomTimeZone() {
        FastDateFormat customTimeZone = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("PST"), Locale.ENGLISH);
        int maxLength = customTimeZone.getMaxLengthEstimate();
        Assertions.assertTrue(maxLength >= 10 && maxLength <= 12);
    }

    @Test
    void testGetMaxLengthEstimate_CenturyStart() throws ParseException {
        Calendar centuryStart = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        FastDateFormat centuryFormat = new FastDateFormat("yy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.ENGLISH, centuryStart.getTime());
        int maxLength = centuryFormat.getMaxLengthEstimate();
        Assertions.assertTrue(maxLength >= 8 && maxLength <= 10);
    }

    @Test
    void testGetMaxLengthEstimate_NullPattern() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            FastDateFormat nullPattern = new FastDateFormat(null, TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
            nullPattern.getMaxLengthEstimate();
        });
    }

    @Test
    void testGetMaxLengthEstimate_NullTimeZone() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            FastDateFormat nullTimeZone = new FastDateFormat("yyyy-MM-dd", null, Locale.ENGLISH);
            nullTimeZone.getMaxLengthEstimate();
        });
    }

    @Test
    void testHashCode() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;

        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", timeZone, locale);
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", timeZone, locale);
        FastDateFormat format3 = new FastDateFormat("MM-dd-yyyy", timeZone, locale);

        Assertions.assertEquals(format1.hashCode(), format2.hashCode());
        Assertions.assertNotEquals(format1.hashCode(), format3.hashCode());
    }

    @Test
    void testGetDateInstance_InvalidStyle() {
        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(-1));
    }

    @Test
    void getTimeZoneNotNull() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("UTC"), Locale.US);
        assertNotNull(fastDateFormat.getTimeZone());
    }

    @Test
    void getTimeZoneReturnsCorrectTimeZone() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("UTC"), Locale.US);
        assertEquals(TimeZone.getTimeZone("UTC"), fastDateFormat.getTimeZone());
    }

    @Test
    void testGetPatternWithDifferentPattern() {
        FastDateFormat fastDateFormat = new FastDateFormat("dd/MM/yyyy", TimeZone.getDefault(), Locale.getDefault());
        String pattern = fastDateFormat.getPattern();
        assertEquals("dd/MM/yyyy", pattern);
    }

    @Test
    void testGetPatternWithDifferentTimeZone() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.getDefault());
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd HH:mm:ss", pattern);
    }

    @Test
    void testGetPatternWithDifferentLocale() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.US);
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd HH:mm:ss", pattern);
    }


    @Test
    void testGetTimeInstanceFullStyle() {
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.FULL);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceLongStyle() {
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.LONG);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceMediumStyle() {
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceShortStyle() {
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.SHORT);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceFullStyleWithCustomLocale() {
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.FULL, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceLongStyleWithCustomLocale() {
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.LONG, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceMediumStyleWithCustomLocale() {
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceShortStyleWithCustomLocale() {
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.SHORT, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceFullStyleWithCustomTimeZone() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.FULL, timeZone);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceLongStyleWithCustomTimeZone() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.LONG, timeZone);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceMediumStyleWithCustomTimeZone() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM, timeZone);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceShortStyleWithCustomTimeZone() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.SHORT, timeZone);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceFullStyleWithCustomTimeZoneAndLocale() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.FULL, timeZone, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceLongStyleWithCustomTimeZoneAndLocale() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.LONG, timeZone, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceMediumStyleWithCustomTimeZoneAndLocale() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM, timeZone, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testGetTimeInstanceShortStyleWithCustomTimeZoneAndLocale() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getTimeInstance(FastDateFormat.SHORT, timeZone, locale);
        Assertions.assertNotNull(format);
    }

    @Test
    void testEquals() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        FastDateFormat format3 = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        FastDateFormat format4 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.getDefault());

        // Test equal objects
        assertTrue(format1.equals(format1));
        assertTrue(format1.equals(format2));

        // Test different patterns
        assertFalse(format1.equals(format3));

        // Test different time zones
        assertFalse(format1.equals(format4));

        // Test different types of objects
        assertFalse(format1.equals("yyyy-MM-dd"));
        assertFalse(format1.equals(null));
    }

    @Test
    @DisplayName("Test getLocale returns non-null value")
    void testGetLocaleNotNull() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        assertNotNull(fastDateFormat.getLocale());
    }

    @Test
    @DisplayName("Test getLocale returns the same locale as the one used during initialization")
    void testGetLocale() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        assertEquals(Locale.getDefault(), fastDateFormat.getLocale());
    }

    @Test
    void testGetInstance() {
        FastDateFormat format = FastDateFormat.getInstance();
        assertNotNull(format);
    }

    @Test
    void testGetInstanceWithPattern() {
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd");
        assertNotNull(format);
    }

    @Test
    void testGetInstanceWithPatternAndLocale() {
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd", Locale.US);
        assertNotNull(format);
    }

    @Test
    void testGetInstanceWithPatternAndTimeZone() {
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd", TimeZone.getTimeZone("GMT"));
        assertNotNull(format);
    }

    @Test
    void testGetInstanceWithPatternTimeZoneAndLocale() {
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        assertNotNull(format);
    }

    @Test
    void testGetInstanceWithInvalidPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            FastDateFormat.getInstance("invalid_pattern");
        });
    }


    @Test
    void testGetDateTimeInstanceWithInvalidDateStyle() {
        assertThrows(IllegalArgumentException.class, () ->
                FastDateFormat.getDateTimeInstance(-1, DateFormat.MEDIUM));
    }

    @Test
    void testGetDateTimeInstanceWithInvalidTimeStyle() {
        assertThrows(IllegalArgumentException.class, () ->
                FastDateFormat.getDateTimeInstance(DateFormat.MEDIUM, -1));
    }


    @Test
    void testParseWithInvalidInput() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String input = "2022/01/01 12:00:00";
        assertThrows(ParseException.class, () -> fastDateFormat.parse(input));
    }

}