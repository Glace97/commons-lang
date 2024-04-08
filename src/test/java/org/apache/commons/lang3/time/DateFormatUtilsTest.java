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

public class DateFormatUtilsTest {
    @Test
    @DisplayName("Should return TimeZone object when calendar is not null")
    void shouldReturnTimeZoneWhenCalendarIsNotNull() {
        TimeZone timeZone = DateFormatUtils.getTimeZone(calendar);
        assertNotNull(timeZone);
    }
    
    @Test
    @DisplayName("Should return null when calendar is null")
    void shouldReturnNullWhenCalendarIsNull() {
        TimeZone timeZone = DateFormatUtils.getTimeZone(null);
        assertNull(timeZone);
    }
    @Test
    void testFormatWithCalendarAndPattern() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        String pattern = "yyyy-MM-dd";
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(calendar, pattern);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithCalendarPatternAndLocale() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        String pattern = "yyyy-MM-dd";
        Locale locale = Locale.US;
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(calendar, pattern, locale);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithCalendarPatternAndTimeZone() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(calendar, pattern, timeZone);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithCalendarPatternTimeZoneAndLocale() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(calendar, pattern, timeZone, locale);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithDateAndPattern() {
        Date date = new Date(1609459200000L); // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(date, pattern);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithDatePatternAndLocale() {
        Date date = new Date(1609459200000L); // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        Locale locale = Locale.US;
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(date, pattern, locale);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithDatePatternAndTimeZone() {
        Date date = new Date(1609459200000L); // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(date, pattern, timeZone);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithDatePatternTimeZoneAndLocale() {
        Date date = new Date(1609459200000L); // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(date, pattern, timeZone, locale);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithMillisAndPattern() {
        long millis = 1609459200000L; // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(millis, pattern);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithMillisPatternAndLocale() {
        long millis = 1609459200000L; // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        Locale locale = Locale.US;
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(millis, pattern, locale);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithMillisPatternAndTimeZone() {
        long millis = 1609459200000L; // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(millis, pattern, timeZone);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    
    @Test
    void testFormatWithMillisPatternTimeZoneAndLocale() {
        long millis = 1609459200000L; // January 1, 2021, 00:00:00 GMT
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        String expected = "2021-01-01";
    
        String result = dateFormatUtils.format(millis, pattern, timeZone, locale);
    
        assertNotNull(result);
        assertEquals(expected, result);
    }
    @Test
    void testFormatUTC_WithDateAndPattern_ShouldReturnFormattedDate() {
        // Arrange
        Date date = new Date();
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
    
        // Act
        String formattedDate = dateFormatUtils.formatUTC(date, pattern);
    
        // Assert
        assertEquals(pattern, formattedDate);
    }
    
    @Test
    void testFormatUTC_WithDatePatternAndLocale_ShouldReturnFormattedDate() {
        // Arrange
        Date date = new Date();
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        Locale locale = Locale.US;
    
        // Act
        String formattedDate = dateFormatUtils.formatUTC(date, pattern, locale);
    
        // Assert
        assertEquals(pattern, formattedDate);
    }
    
    @Test
    void testFormatUTC_WithMillisAndPattern_ShouldReturnFormattedDate() {
        // Arrange
        long millis = System.currentTimeMillis();
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
    
        // Act
        String formattedDate = dateFormatUtils.formatUTC(millis, pattern);
    
        // Assert
        assertEquals(pattern, formattedDate);
    }
    
    @Test
    void testFormatUTC_WithMillisPatternAndLocale_ShouldReturnFormattedDate() {
        // Arrange
        long millis = System.currentTimeMillis();
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        Locale locale = Locale.US;
    
        // Act
        String formattedDate = dateFormatUtils.formatUTC(millis, pattern, locale);
    
        // Assert
        assertEquals(pattern, formattedDate);
    }

}