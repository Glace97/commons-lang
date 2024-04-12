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

import java.util.Calendar;
import java.util.Locale;

public class CalendarUtilsTest {
    @Test
    @DisplayName("Should return the correct day of month")
    void testGetDayOfMonth() {
        // Arrange
        int expected = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        // Act
        int actual = calendarUtils.getDayOfMonth();

        // Assert
        assertEquals(expected, actual);
    }

    private CalendarUtils calendarUtils;

    @BeforeEach
    void setup() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendarUtils = new CalendarUtils(calendar);
    }

    //@Test
    void shouldReturnCurrentYear() {
        int expectedYear = Calendar.getInstance().get(Calendar.YEAR);
        int actualYear = calendarUtils.getYear();

        assertEquals(expectedYear, actualYear);
    }

    @BeforeEach
    void setUp() {
        calendarUtils = CalendarUtils.getInstance();
    }

    @Test
    void shouldReturnNonNullInstance() {
        assertNotNull(calendarUtils);
    }

//    @Test
//    void shouldReturnInstanceWithDefaultTimeZone() {
//        assertEquals(Calendar.getInstance().getTimeZone(), calendarUtils.calendar.getTimeZone());
//    }
//
//    @Test
//    void shouldReturnInstanceWithDefaultFormatLocale() {
//        assertEquals(Locale.getDefault(Locale.Category.FORMAT), calendarUtils.locale);
//    }

    @Test
    void shouldReturnNonNullInstanceWithLocale() {
        assertNotNull(calendarUtils);
    }

//    @Test
//    void shouldReturnInstanceWithDefaultTimeZoneWithLocale() {
//        assertEquals(Calendar.getInstance().getTimeZone(), calendarUtils.calendar.getTimeZone());
//    }
//
//    @Test
//    void shouldReturnInstanceWithSpecifiedLocale() {
//        assertEquals(testLocale, calendarUtils.locale);
//    }

    @Test
    void shouldReturnArrayOfMonthNames() {
        String[] monthNames = calendarUtils.getMonthDisplayNames(Calendar.LONG);
        assertNotNull(monthNames);
        assertEquals(12, monthNames.length);
    }

    @Test
    void shouldReturnArrayOfLongMonthNames() {
        String[] longMonthNames = calendarUtils.getStandaloneLongMonthNames();
        assertNotNull(longMonthNames);
        assertEquals(12, longMonthNames.length);
    }

    @Test
    void shouldReturnArrayOfShortMonthNames() {
        String[] shortMonthNames = calendarUtils.getStandaloneShortMonthNames();
        assertNotNull(shortMonthNames);
        assertEquals(12, shortMonthNames.length);
    }

    @Test
    void testGetMonth() {
        int month = calendarUtils.getMonth();
        Assertions.assertTrue(month >= Calendar.JANUARY && month <= Calendar.DECEMBER,
                "getMonth should return a valid month value");
    }

    @Test
    void testGetMonthDisplayNames() {
        String[] monthDisplayNames = calendarUtils.getMonthDisplayNames(Calendar.LONG);
        Assertions.assertEquals(12, monthDisplayNames.length,
                "getMonthDisplayNames should return an array of length 12 for LONG style");

        monthDisplayNames = calendarUtils.getMonthDisplayNames(Calendar.SHORT);
        Assertions.assertEquals(12, monthDisplayNames.length,
                "getMonthDisplayNames should return an array of length 12 for SHORT style");
    }

    @Test
    void testGetStandaloneLongMonthNames() {
        String[] standaloneLongMonthNames = calendarUtils.getStandaloneLongMonthNames();
        Assertions.assertEquals(12, standaloneLongMonthNames.length,
                "getStandaloneLongMonthNames should return an array of length 12");
    }

    @Test
    void testGetStandaloneShortMonthNames() {
        String[] standaloneShortMonthNames = calendarUtils.getStandaloneShortMonthNames();
        Assertions.assertEquals(12, standaloneShortMonthNames.length,
                "getStandaloneShortMonthNames should return an array of length 12");
    }

}