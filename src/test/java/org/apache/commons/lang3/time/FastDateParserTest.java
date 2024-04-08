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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class FastDateParserTest {
    import org.junit.jupiter.api.Test;
    
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    public class FastDateParserTest {
    
        private FastDateParser parser;
    
        @Test
        public void testSetCalendarInvalidInput() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, "2022-13-01 12:00:00");
            assertEquals(2022, calendar.get(Calendar.YEAR));
            // Month is 0-based, so December is represented as 11
            assertEquals(11, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    
        @Test
        public void testSetCalendarInvalidDate() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, "2022-02-30 12:00:00");
            assertEquals(2022, calendar.get(Calendar.YEAR));
            // Month is 0-based, so March is represented as 2
            assertEquals(2, calendar.get(Calendar.MONTH));
            assertEquals(2, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    
        @Test
        public void testSetCalendarInvalidTime() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, "2022-01-01 25:00:00");
            assertEquals(2022, calendar.get(Calendar.YEAR));
            assertEquals(0, calendar.get(Calendar.MONTH));
            assertEquals(2, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(1, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    
        @Test
        public void testSetCalendarInvalidFormat() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, "2022-01-01");
            assertEquals(2022, calendar.get(Calendar.YEAR));
            assertEquals(0, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    
        @Test
        public void testSetCalendarEmptyInput() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, "");
            assertEquals(1970, calendar.get(Calendar.YEAR));
            assertEquals(0, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    
        @Test
        public void testSetCalendarNullInput() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, null);
            assertEquals(1970, calendar.get(Calendar.YEAR));
            assertEquals(0, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    
        @Test
        public void testSetCalendarInvalidTimeZone() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, "2022-01-01 12:00:00 EST");
            assertEquals(2022, calendar.get(Calendar.YEAR));
            assertEquals(0, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(17, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    
        @Test
        public void testSetCalendarValidTimeZone() {
            Calendar calendar = new GregorianCalendar();
            parser.setCalendar(calendar, "2022-01-01 12:00:00 GMT");
            assertEquals(2022, calendar.get(Calendar.YEAR));
            assertEquals(0, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
        }
    }
    @Test
    @DisplayName("Should return true for number strategies")
    void shouldReturnTrueForNumberStrategies() {
        FastDateParser.NumberStrategy numberStrategy = new FastDateParser.NumberStrategy(Calendar.YEAR);
        assertTrue(numberStrategy.isNumber());
    }
    
    @Test
    @DisplayName("Should return false for non-number strategies")
    void shouldReturnFalseForNonNumberStrategies() {
        FastDateParser.Strategy strategy = new FastDateParser.Strategy() {
            @Override
            boolean parse(FastDateParser parser, Calendar calendar, String source, ParsePosition pos, int maxWidth) {
                return false;
            }
        };
        assertFalse(strategy.isNumber());
    }
    @Test
    @DisplayName("Test parsing of a valid date and time")
    void testParseObject_ValidDateTime() throws ParseException {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        Date expectedDate = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 30, 45).getTime();
        String dateString = "2022-01-01 12:30:45";
        Date actualDate = (Date) parser.parseObject(dateString);
        assertEquals(expectedDate, actualDate);
    }
    
    @Test
    @DisplayName("Test parsing of an invalid date and time")
    void testParseObject_InvalidDateTime() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        String dateString = "2022-01-01 12:30"; // Missing seconds
        assertThrows(ParseException.class, () -> {
            parser.parseObject(dateString);
        });
    }
    
    @Test
    @DisplayName("Test parsing of a valid date")
    void testParseObject_ValidDate() throws ParseException {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Date expectedDate = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        String dateString = "2022-01-01";
        Date actualDate = (Date) parser.parseObject(dateString);
        assertEquals(expectedDate, actualDate);
    }
    
    @Test
    @DisplayName("Test parsing of an invalid date")
    void testParseObject_InvalidDate() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String dateString = "2022-01"; // Missing day
        assertThrows(ParseException.class, () -> {
            parser.parseObject(dateString);
        });
    }
    
    @Test
    @DisplayName("Test parsing of a valid time")
    void testParseObject_ValidTime() throws ParseException {
        FastDateParser parser = new FastDateParser("HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        Date expectedDate = new GregorianCalendar(1970, Calendar.JANUARY, 1, 12, 30, 45).getTime();
        String timeString = "12:30:45";
        Date actualDate = (Date) parser.parseObject(timeString);
        assertEquals(expectedDate, actualDate);
    }
    
    @Test
    @DisplayName("Test parsing of an invalid time")
    void testParseObject_InvalidTime() {
        FastDateParser parser = new FastDateParser("HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        String timeString = "12:30"; // Missing seconds
        assertThrows(ParseException.class, () -> {
            parser.parseObject(timeString);
        });
    }
    
    @Test
    @DisplayName("Test parsing of a valid year with two digits")
    void testParseObject_ValidTwoDigitYear() throws ParseException {
        FastDateParser parser = new FastDateParser("yy", TimeZone.getDefault(), Locale.getDefault());
        Date expectedDate = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        String yearString = "22";
        Date actualDate = (Date) parser.parseObject(yearString);
        assertEquals(expectedDate, actualDate);
    }
    
    @Test
    @DisplayName("Test parsing of an invalid year with two digits")
    void testParseObject_InvalidTwoDigitYear() {
        FastDateParser parser = new FastDateParser("yy", TimeZone.getDefault(), Locale.getDefault());
        String yearString = "100"; // Out of range
        assertThrows(ParseException.class, () -> {
            parser.parseObject(yearString);
        });
    }
    
    @Test
    @DisplayName("Test parsing of a valid time zone")
    void testParseObject_ValidTimeZone() throws ParseException {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss Z", TimeZone.getDefault(), Locale.getDefault());
        Date expectedDate = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 30, 45).getTime();
        String dateString = "2022-01-01 12:30:45 GMT+00:00";
        Date actualDate = (Date) parser.parseObject(dateString);
        assertEquals(expectedDate, actualDate);
    }
    
    @Test
    @DisplayName("Test parsing of an invalid time zone")
    void testParseObject_InvalidTimeZone() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss Z", TimeZone.getDefault(), Locale.getDefault());
        String dateString = "2022-01-01 12:30:45 GMT"; // Missing offset
        assertThrows(ParseException.class, () -> {
            parser.parseObject(dateString);
        });
    }
    @Test
    public void testHashCode() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
    
        assertEquals(parser1.hashCode(), parser2.hashCode());
    }
    
    @Test
    public void testHashCode_DifferentPattern() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("dd-MM-yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
    
        assertNotEquals(parser1.hashCode(), parser2.hashCode());
    }
    
    @Test
    public void testHashCode_DifferentTimeZone() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("PST"), Locale.US);
    
        assertNotEquals(parser1.hashCode(), parser2.hashCode());
    }
    
    @Test
    public void testHashCode_DifferentLocale() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.UK);
    
        assertNotEquals(parser1.hashCode(), parser2.hashCode());
    }
    
    @Test
    public void testEquals() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
    
        assertTrue(parser1.equals(parser2));
    }
    
    @Test
    public void testEquals_SameObject() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
    
        assertTrue(parser1.equals(parser1));
    }
    
    @Test
    public void testEquals_NullObject() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
    
        assertFalse(parser1.equals(null));
    }
    
    @Test
    public void testEquals_DifferentClass() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
    
        assertFalse(parser1.equals("yyyy-MM-dd"));
    }
    
    @Test
    public void testEquals_DifferentPattern() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("dd-MM-yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
    
        assertFalse(parser1.equals(parser2));
    }
    
    @Test
    public void testEquals_DifferentTimeZone() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("PST"), Locale.US);
    
        assertFalse(parser1.equals(parser2));
    }
    
    @Test
    public void testEquals_DifferentLocale() {
        FastDateParser parser1 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateParser parser2 = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.UK);
    
        assertFalse(parser1.equals(parser2));
    }
    @Test
        public void testGetTimeZone() {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.US);
    
            // Test cases for valid time zones
            assertEquals(TimeZone.getTimeZone("GMT"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("PST"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("EST"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("CST"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("MST"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("PDT"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("EDT"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("CDT"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("MDT"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("Australia/Sydney"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("America/Los_Angeles"), parser.getTimeZone());
            assertEquals(TimeZone.getTimeZone("Europe/London"), parser.getTimeZone());
        }
    @Test
    @DisplayName("Test getPattern with valid pattern")
    void testGetPatternValidPattern() {
        String pattern = fastDateParser.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }
    
    @Test
    @DisplayName("Test getPattern with null pattern")
    void testGetPatternNullPattern() {
        fastDateParser = new FastDateParser(null, TimeZone.getDefault(), Locale.getDefault());
        String pattern = fastDateParser.getPattern();
        assertEquals("", pattern);
    }
    
    @Test
    @DisplayName("Test getPattern with empty pattern")
    void testGetPatternEmptyPattern() {
        fastDateParser = new FastDateParser("", TimeZone.getDefault(), Locale.getDefault());
        String pattern = fastDateParser.getPattern();
        assertEquals("", pattern);
    }
    
    @Test
    @DisplayName("Test getPattern with different locale")
    void testGetPatternDifferentLocale() {
        fastDateParser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.JAPANESE);
        String pattern = fastDateParser.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }
    
    @Test
    @DisplayName("Test getPattern with different time zone")
    void testGetPatternDifferentTimeZone() {
        fastDateParser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.getDefault());
        String pattern = fastDateParser.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }
    import org.junit.jupiter.api.Test;
    import java.text.ParseException;
    import java.util.Calendar;
    import java.util.Date;
    import java.util.TimeZone;
    import static org.junit.jupiter.api.Assertions.*;
    
    class FastDateParserTest {
    
        @Test
        void testParse() throws ParseException {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd");
            Date date = parser.parse("2022-01-01");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            assertEquals(2022, calendar.get(Calendar.YEAR));
            assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
        }
    
        @Test
        void testParseWithTimezone() throws ParseException {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss z");
            parser.setTimeZone(TimeZone.getTimeZone("GMT+0"));
            Date date = parser.parse("2022-01-01 12:00:00 GMT+0");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            assertEquals(2022, calendar.get(Calendar.YEAR));
            assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
            assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
            assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
            assertEquals(0, calendar.get(Calendar.SECOND));
            assertEquals("GMT+0", calendar.getTimeZone().getID());
        }
    
        @Test
        void testParseInvalidDate() {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd");
            assertThrows(ParseException.class, () -> parser.parse("2022-01-32"));
        }
    
        @Test
        void testParseInvalidPattern() {
            assertThrows(IllegalArgumentException.class, () -> new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT+0"), null));
        }
    }
    @Test
    void testModifyAbbreviatedYear() {
        parser = new FastDateParser("yy", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(2021, parser.modify(parser, 21));
    }
    
    @Test
    void testModifyNumberMonth() {
        parser = new FastDateParser("M", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(0, parser.modify(parser, 1));
    }
    
    @Test
    void testModifyLiteralYear() {
        parser = new FastDateParser("yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(2021, parser.modify(parser, 2021));
    }
    
    @Test
    void testModifyWeekOfYear() {
        parser = new FastDateParser("w", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(52, parser.modify(parser, 1));
    }
    
    @Test
    void testModifyWeekOfMonth() {
        parser = new FastDateParser("W", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(5, parser.modify(parser, 1));
    }
    
    @Test
    void testModifyDayOfYear() {
        parser = new FastDateParser("D", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(31, parser.modify(parser, 1));
    }
    
    @Test
    void testModifyDayOfMonth() {
        parser = new FastDateParser("d", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(1, parser.modify(parser, 1));
    }
    
    @Test
    void testModifyDayOfWeek() {
        parser = new FastDateParser("E", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(Calendar.MONDAY, parser.modify(parser, 1));
    }
    
    @Test
    void testModifyDayOfWeekInMonth() {
        parser = new FastDateParser("F", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(1, parser.modify(parser, 1));
    }
    
    @Test
    void testModifyHourOfDay() {
        parser = new FastDateParser("H", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(0, parser.modify(parser, 24));
    }
    
    @Test
    void testModifyHour24OfDay() {
        parser = new FastDateParser("k", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(0, parser.modify(parser, 24));
    }
    
    @Test
    void testModifyHour12() {
        parser = new FastDateParser("h", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(0, parser.modify(parser, 12));
    }
    
    @Test
    void testModifyHour() {
        parser = new FastDateParser("K", TimeZone.getTimeZone("GMT"), Locale.US);
        assertEquals(0, parser.modify(parser, 12));
    }
    
    @Test
    void testParseAbbreviatedYear() throws ParseException {
        parser = new FastDateParser("yy", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("21"));
    }
    
    @Test
    void testParseNumberMonth() throws ParseException {
        parser = new FastDateParser("M", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("1"));
    }
    
    @Test
    void testParseLiteralYear() throws ParseException {
        parser = new FastDateParser("yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("2021"));
    }
    
    @Test
    void testParseWeekOfYear() throws ParseException {
        parser = new FastDateParser("w", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.DECEMBER, 27, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("1"));
    }
    
    @Test
    void testParseWeekOfMonth() throws ParseException {
        parser = new FastDateParser("W", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.DECEMBER, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("5"));
    }
    
    @Test
    void testParseDayOfYear() throws ParseException {
        parser = new FastDateParser("D", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.JANUARY, 2, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("2"));
    }
    
    @Test
    void testParseDayOfMonth() throws ParseException {
        parser = new FastDateParser("d", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.JANUARY, 2, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("2"));
    }
    
    @Test
    void testParseDayOfWeek() throws ParseException {
        parser = new FastDateParser("E", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2022, Calendar.JANUARY, 3, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("Mon"));
    }
    
    @Test
    void testParseDayOfWeekInMonth() throws ParseException {
        parser = new FastDateParser("F", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("1"));
    }
    
    @Test
    void testParseHourOfDay() throws ParseException {
        parser = new FastDateParser("H", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("0"));
    }
    
    @Test
    void testParseHour24OfDay() throws ParseException {
        parser = new FastDateParser("k", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("0"));
    }
    
    @Test
    void testParseHour12() throws ParseException {
        parser = new FastDateParser("h", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("12"));
    }
    
    @Test
    void testParseHour() throws ParseException {
        parser = new FastDateParser("K", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("0"));
    }
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    class FastDateParserTestSuite {
    
        @Test
        void testToStringAll() {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
            String expected = "FastDateParser [pattern=yyyy-MM-dd, timeZone=" + TimeZone.getDefault() + ", locale=" + Locale.getDefault() + ", century=20, startYear=20, patterns=" + null + "]";
            assertEquals(expected, parser.toStringAll());
        }
    
        @Test
        void testToStringAllWithCenturyStart() {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault(), new Date());
            String expected = "FastDateParser [pattern=yyyy-MM-dd, timeZone=" + TimeZone.getDefault() + ", locale=" + Locale.getDefault() + ", century=20, startYear=20, patterns=" + null + "]";
            assertEquals(expected, parser.toStringAll());
        }
    
        @Test
        void testToStringAllWithJapaneseImperialLocale() {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), new Locale("ja", "JP", "JP"));
            String expected = "FastDateParser [pattern=yyyy-MM-dd, timeZone=" + TimeZone.getDefault() + ", locale=ja_JP_JP, century=20, startYear=20, patterns=" + null + "]";
            assertEquals(expected, parser.toStringAll());
        }
    
        @Test
        void testToStringAllWithPatterns() {
            FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
            parser.patterns = new ArrayList<>();
            parser.patterns.add(new StrategyAndWidth(new NumberStrategy(Calendar.YEAR), 4));
            parser.patterns.add(new StrategyAndWidth(new CaseInsensitiveTextStrategy(Calendar.MONTH, Calendar.getInstance(), Locale.getDefault()), 2));
            parser.patterns.add(new StrategyAndWidth(new NumberStrategy(Calendar.DAY_OF_MONTH), 2));
            String expected = "FastDateParser [pattern=yyyy-MM-dd, timeZone=" + TimeZone.getDefault() + ", locale=" + Locale.getDefault() + ", century=20, startYear=20, patterns=[StrategyAndWidth [strategy=NumberStrategy [field=1], width=4], StrategyAndWidth [strategy=CaseInsensitiveTextStrategy [field=2, locale=" + Locale.getDefault() + ", lKeyValues={}, pattern=(?iu)], width=2], StrategyAndWidth [strategy=NumberStrategy [field=5], width=2]]]";
            assertEquals(expected, parser.toStringAll());
        }
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertFalse;
    import static org.junit.jupiter.api.Assertions.assertTrue;
    
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Locale;
    import java.util.TimeZone;
    
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    
    public class FastDateParserTest {
    
        private static final TimeZone TIMEZONE = TimeZone.getTimeZone("GMT");
        private static final Locale LOCALE = Locale.US;
    
        private static FastDateParser parser;
    
        @BeforeAll
        static void setUp() {
            parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TIMEZONE, LOCALE);
        }
    
        @Test
        void testEquals() {
            FastDateParser other = new FastDateParser("yyyy-MM-dd HH:mm:ss", TIMEZONE, LOCALE);
            assertTrue(parser.equals(other));
        }
    
        @Test
        void testNotEqualsWithDifferentPattern() {
            FastDateParser other = new FastDateParser("yyyy-MM-dd", TIMEZONE, LOCALE);
            assertFalse(parser.equals(other));
        }
    
        @Test
        void testNotEqualsWithDifferentTimeZone() {
            TimeZone otherTimeZone = TimeZone.getTimeZone("PST");
            FastDateParser other = new FastDateParser("yyyy-MM-dd HH:mm:ss", otherTimeZone, LOCALE);
            assertFalse(parser.equals(other));
        }
    
        @Test
        void testNotEqualsWithDifferentLocale() {
            Locale otherLocale = Locale.CANADA;
            FastDateParser other = new FastDateParser("yyyy-MM-dd HH:mm:ss", TIMEZONE, otherLocale);
            assertFalse(parser.equals(other));
        }
    
        @Test
        void testParse() throws Exception {
            Date expected = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LOCALE).parse("2022-01-01 12:00:00");
            Date actual = parser.parse("2022-01-01 12:00:00");
            assertEquals(expected, actual);
        }
    
        @Test
        void testParseWithDifferentPattern() throws Exception {
            FastDateParser customParser = new FastDateParser("dd/MM/yyyy", TIMEZONE, LOCALE);
            Date expected = new SimpleDateFormat("dd/MM/yyyy", LOCALE).parse("01/01/2022");
            Date actual = customParser.parse("01/01/2022");
            assertEquals(expected, actual);
        }
    }
    @Test
    void testGetStrategy_AbbreviatedYear() {
        Strategy strategy = fastDateParser.getStrategy('y', 2, calendar);
        assertEquals(fastDateParser.ABBREVIATED_YEAR_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_NumberMonth() {
        Strategy strategy = fastDateParser.getStrategy('M', 2, calendar);
        assertEquals(fastDateParser.NUMBER_MONTH_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_LiteralYear() {
        Strategy strategy = fastDateParser.getStrategy('y', 4, calendar);
        assertEquals(fastDateParser.LITERAL_YEAR_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_WeekOfYear() {
        Strategy strategy = fastDateParser.getStrategy('w', 2, calendar);
        assertEquals(fastDateParser.WEEK_OF_YEAR_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_WeekOfMonth() {
        Strategy strategy = fastDateParser.getStrategy('W', 2, calendar);
        assertEquals(fastDateParser.WEEK_OF_MONTH_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_DayOfYear() {
        Strategy strategy = fastDateParser.getStrategy('D', 2, calendar);
        assertEquals(fastDateParser.DAY_OF_YEAR_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_DayOfMonth() {
        Strategy strategy = fastDateParser.getStrategy('d', 2, calendar);
        assertEquals(fastDateParser.DAY_OF_MONTH_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_DayOfWeek() {
        Strategy strategy = fastDateParser.getStrategy('E', 2, calendar);
        assertEquals(fastDateParser.DAY_OF_WEEK_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_DayOfWeekInMonth() {
        Strategy strategy = fastDateParser.getStrategy('F', 2, calendar);
        assertEquals(fastDateParser.DAY_OF_WEEK_IN_MONTH_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_HourOfDay() {
        Strategy strategy = fastDateParser.getStrategy('H', 2, calendar);
        assertEquals(fastDateParser.HOUR_OF_DAY_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_Hour24OfDay() {
        Strategy strategy = fastDateParser.getStrategy('k', 2, calendar);
        assertEquals(fastDateParser.HOUR24_OF_DAY_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_Hour12() {
        Strategy strategy = fastDateParser.getStrategy('h', 2, calendar);
        assertEquals(fastDateParser.HOUR12_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_Hour() {
        Strategy strategy = fastDateParser.getStrategy('K', 2, calendar);
        assertEquals(fastDateParser.HOUR_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_Minute() {
        Strategy strategy = fastDateParser.getStrategy('m', 2, calendar);
        assertEquals(fastDateParser.MINUTE_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_Second() {
        Strategy strategy = fastDateParser.getStrategy('s', 2, calendar);
        assertEquals(fastDateParser.SECOND_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_Millisecond() {
        Strategy strategy = fastDateParser.getStrategy('S', 3, calendar);
        assertEquals(fastDateParser.MILLISECOND_STRATEGY, strategy);
    }
    
    @Test
    void testGetStrategy_TimeZoneStrategy() {
        Strategy strategy = fastDateParser.getStrategy('Z', 1, calendar);
        assertEquals(fastDateParser.TimeZoneStrategy.class, strategy.getClass());
    }
    
    @Test
    void testGetStrategy_TextStrategy() {
        Strategy strategy = fastDateParser.getStrategy('a', 2, calendar);
        assertEquals(fastDateParser.CaseInsensitiveTextStrategy.class, strategy.getClass());
    }
    
    @Test
    void testGetStrategy_CopyQuotedStrategy() {
        Strategy strategy = fastDateParser.getStrategy('\'', 5, calendar);
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategy.getClass());
    }
    
    @Test
    void testGetStrategy_InvalidLetter() {
        Strategy strategy = fastDateParser.getStrategy('x', 2, calendar);
        assertEquals(null, strategy);
    }
    
    @Test
    void testGetStrategyAndWidth() {
        StrategyAndWidth strategyAndWidth = fastDateParser.getStrategyAndWidth("yyyy", 0, calendar);
        assertEquals(fastDateParser.LITERAL_YEAR_STRATEGY, strategyAndWidth.strategy);
        assertEquals(4, strategyAndWidth.width);
    }
    
    @Test
    void testGetStrategyAndWidth_InvalidPattern() {
        StrategyAndWidth strategyAndWidth = fastDateParser.getStrategyAndWidth("xxxx", 0, calendar);
        assertEquals(null, strategyAndWidth);
    }
    
    @Test
    void testGetStrategyAndWidth_Quote() {
        StrategyAndWidth strategyAndWidth = fastDateParser.getStrategyAndWidth("''", 0, calendar);
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
        assertEquals(1, strategyAndWidth.width);
    }
    
    @Test
    void testGetStrategyAndWidth_Literal() {
        StrategyAndWidth strategyAndWidth = fastDateParser.getStrategyAndWidth("abc", 0, calendar);
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
        assertEquals(3, strategyAndWidth.width);
    }
    
    @Test
    void testGetStrategyAndWidth_Text() {
        StrategyAndWidth strategyAndWidth = fastDateParser.getStrategyAndWidth("MMM", 0, calendar);
        assertEquals(fastDateParser.CaseInsensitiveTextStrategy.class, strategyAndWidth.strategy.getClass());
        assertEquals(3, strategyAndWidth.width);
    }
    
    @Test
    void testGetStrategyAndWidth_InvalidLetter() {
        StrategyAndWidth strategyAndWidth = fastDateParser.getStrategyAndWidth("xxx", 0, calendar);
        assertEquals(null, strategyAndWidth);
    }
    
    @Test
    void testGetStrategyParser() {
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        assertEquals(fastDateParser.pattern, strategyParser.pattern);
    }
    
    @Test
    void testGetStrategyParser_Literal() {
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testGetStrategyParser_Literal_Quote() {
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testGetStrategyParser_Text() {
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CaseInsensitiveTextStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testGetStrategyParser_InvalidLetter() {
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(null, strategyAndWidth);
    }
    
    @Test
    void testGetStrategyParser_Text_Literal() {
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CaseInsensitiveTextStrategy.class, strategyAndWidth.strategy.getClass());
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testGetStrategyParser_Literal_Text() {
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CaseInsensitiveTextStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testGetStrategyParser_InvalidPattern() {
        String pattern = "xxxx";
        FastDateParser fastDateParser = new FastDateParser(pattern, TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(null, strategyAndWidth);
    }
    
    @Test
    void testGetStrategyParser_PatternWithTimezone() {
        String pattern = "yyyy-MM-dd Z";
        FastDateParser fastDateParser = new FastDateParser(pattern, TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.LITERAL_YEAR_STRATEGY, strategyAndWidth.strategy);
        assertEquals(4, strategyAndWidth.width);
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CaseInsensitiveTextStrategy.class, strategyAndWidth.strategy.getClass());
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.TimeZoneStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testGetStrategyParser_PatternWithText() {
        String pattern = "yyyy-MMM-dd";
        FastDateParser fastDateParser = new FastDateParser(pattern, TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.LITERAL_YEAR_STRATEGY, strategyAndWidth.strategy);
        assertEquals(4, strategyAndWidth.width);
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CaseInsensitiveTextStrategy.class, strategyAndWidth.strategy.getClass());
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testGetStrategyParser_PatternWithInvalidLetter() {
        String pattern = "xxxx-yyyy";
        FastDateParser fastDateParser = new FastDateParser(pattern, TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(null, strategyAndWidth);
    }
    
    @Test
    void testGetStrategyParser_PatternWithQuote() {
        String pattern = "'yyyy'-MM-dd";
        FastDateParser fastDateParser = new FastDateParser(pattern, TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        StrategyParser strategyParser = fastDateParser.getStrategyParser(calendar);
        StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.LITERAL_YEAR_STRATEGY, strategyAndWidth.strategy);
        assertEquals(4, strategyAndWidth.width);
        strategyAndWidth = strategyParser.getNextStrategy();
        assertEquals(fastDateParser.CopyQuotedStrategy.class, strategyAndWidth.strategy.getClass());
    }
    
    @Test
    void testInit() {
        Calendar definingCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        FastDateParser fastDateParser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        fastDateParser.init(definingCalendar);
        assertEquals(definingCalendar, fastDateParser.calendar);
        assertEquals(century, fastDateParser.century);
        assertEquals(startYear, fastDateParser.startYear);
    }
    @Test
    public void testGetLocale() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.US);
        assertEquals(Locale.US, parser.getLocale());
    }
    
    @Test
    public void testGetLocale_DefaultLocale() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), null);
        assertEquals(Locale.getDefault(), parser.getLocale());
    }
    
    @Test
    public void testGetLocale_JapaneseImperial() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), new Locale("ja", "JP", "JP"));
        assertEquals(new Locale("ja", "JP", "JP"), parser.getLocale());
    }
    @Test
    void testIsFormatLetter() {
        assertTrue(FastDateParser.isFormatLetter('A'));
        assertTrue(FastDateParser.isFormatLetter('z'));
        assertFalse(FastDateParser.isFormatLetter('1'));
        assertFalse(FastDateParser.isFormatLetter(' '));
        assertFalse(FastDateParser.isFormatLetter('-'));
    }
    
    @Test
    void testConstructor() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FastDateParser parser = new FastDateParser(sdf.toPattern(), TimeZone.getDefault(), Locale.getDefault());
        assertNotNull(parser);
    }
    
    @Test
    void testConstructorWithCenturyStart() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date centuryStart = new Date();
        FastDateParser parser = new FastDateParser(sdf.toPattern(), TimeZone.getDefault(), Locale.getDefault(), centuryStart);
        assertNotNull(parser);
    }
    
    @Test
    void testGetNextStrategy() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FastDateParser parser = new FastDateParser(sdf.toPattern(), TimeZone.getDefault(), Locale.getDefault());
        FastDateParser.StrategyAndWidth strategyAndWidth = parser.getNextStrategy();
        assertNotNull(strategyAndWidth);
    }
    
    @Test
    void testGetMaxWidth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FastDateParser parser = new FastDateParser(sdf.toPattern(), TimeZone.getDefault(), Locale.getDefault());
        FastDateParser.StrategyAndWidth strategyAndWidth = parser.getNextStrategy();
        ListIterator<FastDateParser.StrategyAndWidth> lt = null;
        int maxWidth = strategyAndWidth.getMaxWidth(lt);
        assertEquals(0, maxWidth);
    }
    @Test
    public void testParse_validDate() throws ParseException {
        String dateString = "2022-01-01 12:00:00";
        calendar.clear();
        calendar.set(2022, Calendar.JANUARY, 1, 12, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    
        assertEquals(calendar.getTime(), parser.parse(dateString));
    }
    
    @Test
    public void testParse_invalidDate() {
        String dateString = "2022-01-01 12:00"; // missing seconds
        assertThrows(ParseException.class, () -> parser.parse(dateString));
    }
    
    @Test
    public void testParse_withTimezone() throws ParseException {
        String dateString = "2022-01-01 12:00:00 GMT";
        calendar.clear();
        calendar.set(2022, Calendar.JANUARY, 1, 12, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    
        assertEquals(calendar.getTime(), parser.parse(dateString));
    }
    
    @Test
    public void testParse_withLocale() throws ParseException {
        String dateString = "2022-01-01 12:00:00";
        calendar.clear();
        calendar.set(2022, Calendar.JANUARY, 1, 12, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    
        assertEquals(calendar.getTime(), parser.parse(dateString));
    }
    
    @Test
    public void testParse_invalidPattern() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        String dateString = "2022/01/01 12:00:00"; // invalid separator
        assertThrows(ParseException.class, () -> new FastDateParser(pattern, timeZone, locale).parse(dateString));
    }
    
    @Test
    public void testParse_invalidTimezone() {
        String pattern = "yyyy-MM-dd HH:mm:ss z";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        String dateString = "2022-01-01 12:00:00 GMTX"; // invalid timezone
        assertThrows(ParseException.class, () -> new FastDateParser(pattern, timeZone, locale).parse(dateString));
    }
    
    @Test
    public void testParse_missingDate() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        String dateString = "12:00:00"; // missing date
        assertThrows(ParseException.class, () -> new FastDateParser(pattern, timeZone, locale).parse(dateString));
    }
    @Test
    public void testToString() {
        assertEquals("FastDateParser[yyyy-MM-dd HH:mm:ss, en_US, Etc/UTC]", parser.toString());
    }
    
    @Test
    public void testParse() throws ParseException {
        Date date = parser.parse("2022-01-01 00:00:00");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
        calendar.setTime(date);
        assertEquals(2022, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));
    }
    
    @Test
    public void testParse_invalidFormat() {
        assertThrows(ParseException.class, () -> parser.parse("2022/01/01 00:00:00"));
    }
    
    @Test
    public void testParse_nullValue() {
        assertThrows(NullPointerException.class, () -> parser.parse(null));
    }

}