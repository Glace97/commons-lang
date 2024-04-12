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

    //@Test
    void testGetMaxLengthEstimate_NullLocale() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            FastDateFormat nullLocale = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), null);
            nullLocale.getMaxLengthEstimate();
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

    //@Test
    void testGetDateInstance_FullStyle_DefaultLocale_DefaultTimeZone() {
        FastDateFormat format = FastDateFormat.getDateInstance(DateFormat.FULL);
        Calendar calendar = Calendar.getInstance();

        String formattedDate = format.format(calendar);
        Date parsedDate = assertDoesNotThrow(() -> format.parse(formattedDate));

        assertEquals(calendar.getTime(), parsedDate);
    }

    //@Test
    void testGetDateInstance_LongStyle_DefaultLocale_DefaultTimeZone() {
        FastDateFormat format = FastDateFormat.getDateInstance(DateFormat.LONG);
        Calendar calendar = Calendar.getInstance();

        String formattedDate = format.format(calendar);
        Date parsedDate = assertDoesNotThrow(() -> format.parse(formattedDate));

        assertEquals(calendar.getTime(), parsedDate);
    }

    //@Test
    void testGetDateInstance_MediumStyle_DefaultLocale_DefaultTimeZone() {
        FastDateFormat format = FastDateFormat.getDateInstance(DateFormat.MEDIUM);
        Calendar calendar = Calendar.getInstance();

        String formattedDate = format.format(calendar);
        Date parsedDate = assertDoesNotThrow(() -> format.parse(formattedDate));

        assertEquals(calendar.getTime(), parsedDate);
    }

    //@Test
    void testGetDateInstance_ShortStyle_DefaultLocale_DefaultTimeZone() {
        FastDateFormat format = FastDateFormat.getDateInstance(DateFormat.SHORT);
        Calendar calendar = Calendar.getInstance();

        String formattedDate = format.format(calendar);
        Date parsedDate = assertDoesNotThrow(() -> format.parse(formattedDate));

        assertEquals(calendar.getTime(), parsedDate);
    }

    @Test
    void testGetDateInstance_InvalidStyle() {
        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(-1));
    }

    //@Test
    void testGetDateInstance_FullStyle_InvalidLocale_DefaultTimeZone() {
        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.FULL, new Locale("invalid")));
    }

    //@Test
    void testGetDateInstance_LongStyle_InvalidLocale_DefaultTimeZone() {
        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.LONG, new Locale("invalid")));
    }

    //@Test
    void testGetDateInstance_MediumStyle_InvalidLocale_DefaultTimeZone() {
        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("invalid")));
    }

    //@Test
    void testGetDateInstance_ShortStyle_InvalidLocale_DefaultTimeZone() {
        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.SHORT, new Locale("invalid")));
    }

    ////@Test
    void testGetDateInstance_FullStyle_DefaultLocale_InvalidTimeZone() {
        assertThrows(NullPointerException.class, () -> FastDateFormat.getDateInstance(DateFormat.FULL, TimeZone.getTimeZone("invalid")));
    }

    //@Test
    void testGetDateInstance_LongStyle_DefaultLocale_InvalidTimeZone() {
        assertThrows(NullPointerException.class, () -> FastDateFormat.getDateInstance(DateFormat.LONG, TimeZone.getTimeZone("invalid")));
    }

    //@Test
    void testGetDateInstance_MediumStyle_DefaultLocale_InvalidTimeZone() {
        assertThrows(NullPointerException.class, () -> FastDateFormat.getDateInstance(DateFormat.MEDIUM, TimeZone.getTimeZone("invalid")));
    }

    //@Test
    void testGetDateInstance_ShortStyle_DefaultLocale_InvalidTimeZone() {
        assertThrows(NullPointerException.class, () -> FastDateFormat.getDateInstance(DateFormat.SHORT, TimeZone.getTimeZone("invalid")));
    }

// Argumenten fel ordning
//    @Test
//    void testGetDateInstance_FullStyle_InvalidLocale_InvalidTimeZone() {
//        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.FULL, new Locale("invalid"), TimeZone.getTimeZone("invalid")));
//    }
//
//    @Test
//    void testGetDateInstance_LongStyle_InvalidLocale_InvalidTimeZone() {
//        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.LONG, new Locale("invalid"), TimeZone.getTimeZone("invalid")));
//    }
//
//    @Test
//    void testGetDateInstance_MediumStyle_InvalidLocale_InvalidTimeZone() {
//        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("invalid"), TimeZone.getTimeZone("invalid")));
//    }
//
//    @Test
//    void testGetDateInstance_ShortStyle_InvalidLocale_InvalidTimeZone() {
//        assertThrows(IllegalArgumentException.class, () -> FastDateFormat.getDateInstance(DateFormat.SHORT, new Locale("invalid"), TimeZone.getTimeZone("invalid")));
//    }

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

//    Accessar privata funktioner
//    @Test
//    void testCreateInstance() {
//        FastDateFormat instance = fastDateFormat.createInstance("yyyy/MM/dd", TimeZone.getTimeZone("GMT+1"), Locale.GERMANY);
//        assertEquals("yyyy/MM/dd", instance.getPattern());
//        assertEquals(TimeZone.getTimeZone("GMT+1"), instance.getTimeZone());
//        assertEquals(Locale.GERMANY, instance.getLocale());
//    }
//
//    @Test
//    void testCreateInstance_NullPattern() {
//        assertThrows(NullPointerException.class, () -> fastDateFormat.createInstance(null, TimeZone.getTimeZone("GMT"), Locale.ENGLISH));
//    }
//
//    @Test
//    void testCreateInstance_NullTimeZone() {
//        assertThrows(NullPointerException.class, () -> fastDateFormat.createInstance("yyyy-MM-dd", null, Locale.ENGLISH));
//    }

//    @Test
//    void testCreateInstance_NullLocale() {
//        FastDateFormat fastDateFormat = new FastDateFormat("dd/MM/yyyy", TimeZone.getTimeZone("GMT"), Locale.getDefault());
//        assertThrows(NullPointerException.class, () -> fastDateFormat.createInstance("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), null));
//    }

    //@Test
    void testGetPattern() {
        FastDateFormat fastDateFormat = new FastDateFormat("dd/MM/yyyy", TimeZone.getDefault(), Locale.getDefault());
        String pattern = fastDateFormat.getPattern();
        assertEquals("yyyy-MM-dd HH:mm:ss", pattern);
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

    //@Test
    void testParse() throws ParseException {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());

        // Test valid date string
        String validDateString = "2021-10-01";
        Date expectedValidDate = format.parse(validDateString);
        assertEquals(expectedValidDate, format.parse(validDateString));

        // Test invalid date string
        String invalidDateString = "2021-13-01";
        assertThrows(ParseException.class, () -> format.parse(invalidDateString));

        // Test null input
        assertThrows(NullPointerException.class, () -> format.parse(null));
    }

    //@Test
    void testParseWithParsePosition() throws ParseException {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());

        String dateString = "2021-10-01";
        ParsePosition pos = new ParsePosition(0);
        Date expectedDate = format.parse(dateString);

        assertEquals(expectedDate, format.parse(dateString, pos));
        assertEquals(10, pos.getIndex());

        // Test invalid date string
        String invalidDateString = "2021-13-01";
        ParsePosition invalidPos = new ParsePosition(0);

        assertNull(format.parse(invalidDateString, invalidPos));
        assertEquals(0, invalidPos.getErrorIndex());
    }

    //@Test
    void testParseWithParsePositionAndCalendar() throws ParseException {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());

        String dateString = "2021-10-01";
        ParsePosition pos = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance();
        Date expectedDate = format.parse(dateString);

        assertTrue(format.parse(dateString, pos, calendar));
        assertEquals(expectedDate, calendar.getTime());
        assertEquals(10, pos.getIndex());

        // Test invalid date string
        String invalidDateString = "2021-13-01";
        ParsePosition invalidPos = new ParsePosition(0);
        Calendar invalidCalendar = Calendar.getInstance();

        assertFalse(format.parse(invalidDateString, invalidPos, invalidCalendar));
        assertEquals(0, invalidPos.getErrorIndex());
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

    //@Test
    void testFormatCalendar() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30, 45);
        String expected = "2021/01/15 12:30:45";
        String actual = fastDateFormat.format(calendar);
        assertEquals(expected, actual);
    }

    //@Test
    void testFormatDate() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Date date = new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30, 45).getTime();
        String expected = "2021/01/15 12:30:45";
        String actual = fastDateFormat.format(date);
        assertEquals(expected, actual);
    }

    //@Test
    void testFormatMillis() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        long millis = 1642288245000L; // 2022/01/15 12:30:45
        String expected = "2022/01/15 12:30:45";
        String actual = fastDateFormat.format(millis);
        assertEquals(expected, actual);
    }

    //@Test
    void testFormatObject() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30, 45);
        StringBuffer buffer = new StringBuffer();
        fastDateFormat.format(calendar, buffer);
        String expected = "2021/01/15 12:30:45";
        String actual = buffer.toString();
        assertEquals(expected, actual);
    }

    //@Test
    @DisplayName("Test toString method")
    void testToString() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String expected = "FastDateFormat[yyyy-MM-dd HH:mm:ss, en, GMT]";
        String actual = fastDateFormat.toString();
        assertEquals(expected, actual);
    }

    //@Test
    @DisplayName("Test toString method with different pattern")
    void testToStringWithDifferentPattern() {
        FastDateFormat fastDateFormat = new FastDateFormat("MM/dd/yyyy", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        String expected = "FastDateFormat[MM/dd/yyyy, en, GMT]";
        String actual = fastDateFormat.toString();
        assertEquals(expected, actual);
    }

    //@Test
    @DisplayName("Test toString method with different timezone")
    void testToStringWithDifferentTimeZone() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("PST"), Locale.ENGLISH);
        String expected = "FastDateFormat[yyyy-MM-dd HH:mm:ss, en, PST]";
        String actual = fastDateFormat.toString();
        assertEquals(expected, actual);
    }

    //@Test
    @DisplayName("Test toString method with different locale")
    void testToStringWithDifferentLocale() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.FRENCH);
        String expected = "FastDateFormat[yyyy-MM-dd HH:mm:ss, fr, GMT]";
        String actual = fastDateFormat.toString();
        assertEquals(expected, actual);
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

    //@Test
    void testGetInstanceWithNullPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            FastDateFormat.getInstance(null);
        });
    }

    @Test
    void testGetInstanceWithInvalidPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            FastDateFormat.getInstance("invalid_pattern");
        });
    }

    // Saknar annotering
//    // testApplyRules
//
//    void testApplyRules() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2022, Calendar.JANUARY, 1); // A specific date for testing
//
//        StringBuffer expected = new StringBuffer();
//        expected.append("Saturday, January 1, 2022");
//
//        StringBuffer actual = fastDateFormat.applyRules(calendar, new StringBuffer());
//
//        assertEquals(expected.toString(), actual.toString());
//    }
//
//    // testApplyRulesWithDifferentLocale
//    void testApplyRulesWithDifferentLocale() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2022, Calendar.JANUARY, 1); // A specific date for testing
//
//        StringBuffer expected = new StringBuffer();
//        expected.append("sábado, 1 de enero de 2022");
//
//        FastDateFormat fastDateFormatWithLocale = new FastDateFormat("EEEE, d 'de' MMMM 'de' yyyy", TimeZone.getDefault(), Locale.forLanguageTag("es"));
//
//        StringBuffer actual = fastDateFormatWithLocale.applyRules(calendar, new StringBuffer());
//
//        assertEquals(expected.toString(), actual.toString());
//    }
//
//    // testApplyRulesWithDifferentTimeZone
//    void testApplyRulesWithDifferentTimeZone() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2022, Calendar.JANUARY, 1); // A specific date for testing
//
//        StringBuffer expected = new StringBuffer();
//        expected.append("Friday, December 31, 2021");
//
//        FastDateFormat fastDateFormatWithTimeZone = new FastDateFormat("EEEE, MMMM d, yyyy", TimeZone.getTimeZone("America/New_York"), Locale.getDefault());
//
//        StringBuffer actual = fastDateFormatWithTimeZone.applyRules(calendar, new StringBuffer());
//
//        assertEquals(expected.toString(), actual.toString());
//    }
//
//    // testApplyRulesWithCustomPattern
//    void testApplyRulesWithCustomPattern() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2022, Calendar.JANUARY, 1); // A specific date for testing
//
//        StringBuffer expected = new StringBuffer();
//        expected.append("2022-01-01");
//
//        FastDateFormat fastDateFormatWithCustomPattern = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
//
//        StringBuffer actual = fastDateFormatWithCustomPattern.applyRules(calendar, new StringBuffer());
//
//        assertEquals(expected.toString(), actual.toString());
//    }
//
//    // testApplyRulesWithDifferentCenturyStart
//    void testApplyRulesWithDifferentCenturyStart() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2022, Calendar.JANUARY, 1); // A specific date for testing
//
//        StringBuffer expected = new StringBuffer();
//        expected.append("01/01/22");
//
//        Date centuryStart = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
//        FastDateFormat fastDateFormatWithCenturyStart = new FastDateFormat("MM/dd/yy", TimeZone.getDefault(), Locale.getDefault(), centuryStart);
//
//        StringBuffer actual = fastDateFormatWithCenturyStart.applyRules(calendar, new StringBuffer());
//
//        assertEquals(expected.toString(), actual.toString());
//    }
//
//    @Test
//    void testGetDateTimeInstanceWithDefaultLocale() {
//        FastDateFormat dateTimeInstance = FastDateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
//        assertNotNull(dateTimeInstance);
//        assertEquals(Locale.getDefault(), dateTimeInstance.parser.getLocale());
//    }
//
//    @Test
//    void testGetDateTimeInstanceWithCustomLocale() {
//        Locale customLocale = Locale.GERMAN;
//        FastDateFormat dateTimeInstance = FastDateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, customLocale);
//        assertNotNull(dateTimeInstance);
//        assertEquals(customLocale, dateTimeInstance.parser.getLocale());
//    }
//
//    @Test
//    void testGetDateTimeInstanceWithDefaultTimeZone() {
//        FastDateFormat dateTimeInstance = FastDateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
//        assertNotNull(dateTimeInstance);
//        assertEquals(TimeZone.getDefault(), dateTimeInstance.parser.getTimeZone());
//    }
//
//    @Test
//    void testGetDateTimeInstanceWithCustomTimeZone() {
//        TimeZone customTimeZone = TimeZone.getTimeZone("America/New_York");
//        FastDateFormat dateTimeInstance = FastDateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, customTimeZone);
//        assertNotNull(dateTimeInstance);
//        assertEquals(customTimeZone, dateTimeInstance.parser.getTimeZone());
//    }

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

    //@Test
    void testFormatWithCalendar() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1, 12, 0, 0);
        String expected = "2022-01-01 12:00:00";
        assertEquals(expected, fastDateFormat.format(calendar));
    }

    //@Test
    void testFormatWithDate() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Date date = new Date(1640995200000L);
        String expected = "2022-01-01 00:00:00";
        assertEquals(expected, fastDateFormat.format(date));
    }

    //@Test
    void testFormatWithMillisecond() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        long millis = 1640995200000L;
        String expected = "2022-01-01 00:00:00";
        assertEquals(expected, fastDateFormat.format(millis));
    }

    //@Test
    void testParseWithValidInput() throws ParseException {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String input = "2022-01-01 12:00:00";
        Date expected = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-01 12:00:00");
        assertEquals(expected, fastDateFormat.parse(input));
    }

    @Test
    void testParseWithInvalidInput() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String input = "2022/01/01 12:00:00";
        assertThrows(ParseException.class, () -> fastDateFormat.parse(input));
    }

}