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


import org.easymock.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FastDateParserTest {

    private FastDateParser parser;

    private static final TimeZone TIMEZONE = TimeZone.getTimeZone("GMT");
    private static final Locale LOCALE = Locale.US;
    @BeforeEach
    void setUp(){
        parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
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
    public void testEquals2() {
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
    @DisplayName("Test getPattern with empty pattern")
    void testGetPatternEmptyPattern() {
        parser = new FastDateParser("", TimeZone.getDefault(), Locale.getDefault());
        String pattern = parser.getPattern();
        assertEquals("", pattern);
    }

    @Test
    @DisplayName("Test getPattern with different locale")
    void testGetPatternDifferentLocale() {
        parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.JAPANESE);
        String pattern = parser.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
    }

    @Test
    @DisplayName("Test getPattern with different time zone")
    void testGetPatternDifferentTimeZone() {
        parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.getDefault());
        String pattern = parser.getPattern();
        assertEquals("yyyy-MM-dd", pattern);
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
    void testParseLiteralYear() throws ParseException {
        parser = new FastDateParser("yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.US);
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), parser.parse("2021"));
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
    void testParse1() throws Exception {
        Date expected = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LOCALE).parse("2022-01-01 12:00:00");
        Date actual = parser.parse("2022-01-01 12:00:00");
        assertEquals(expected, actual);
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
    public void testParse_invalidDate() {
        String dateString = "2022-01-01 12:00"; // missing seconds
        assertThrows(ParseException.class, () -> parser.parse(dateString));
    }

    @Test
    public void testParse_withTimezone() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        String dateString = "2022-01-01 12:00:00 GMT";
        calendar.clear();
        calendar.set(2022, Calendar.JANUARY, 1, 12, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        assertEquals(calendar.getTime(), parser.parse(dateString));
    }

    @Test
    public void testParse_withLocale() throws ParseException {
        Calendar calendar = Calendar.getInstance();
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
    public void testParse_missingDate() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        String dateString = "12:00:00"; // missing date
        assertThrows(ParseException.class, () -> new FastDateParser(pattern, timeZone, locale).parse(dateString));
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