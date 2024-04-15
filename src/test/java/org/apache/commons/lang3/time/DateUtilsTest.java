package org.apache.commons.lang3.time;

import java.text.ParseException;
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

import java.util.*;

public class DateUtilsTest {
    private DateUtils dateUtils;
    private Calendar calendar;
    private Calendar cal1;
    private Calendar cal2;
    private Date date1;
    private Date date2;
    private DateUtils.DateIterator dateIterator;
    Calendar start;
    Calendar end;
    @BeforeEach
    void setUp() {
         start = Calendar.getInstance();
        start.set(2022, Calendar.JANUARY, 1);

         end = Calendar.getInstance();
        end.set(2022, Calendar.JANUARY, 5);

        dateIterator = new DateUtils.DateIterator(start, end);

        date1 = new Date();
        date2 = new Date();
        calendar = Calendar.getInstance();

        cal1 = Calendar.getInstance();
        cal2 = Calendar.getInstance();
        dateUtils = new DateUtils();
    }


    @Test
    @DisplayName("should throw UnsupportedOperationException when remove() is called")
    void shouldThrowUnsupportedOperationExceptionWhenRemoveCalled() {
        // Arrange
        DateUtils.DateIterator iterator = new DateUtils.DateIterator(start, end);

        // Act & Assert
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    // Your Java code here
    @Test
    void testIsSameDay_sameDayDifferentTime_returnsTrue() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2022, Calendar.JANUARY, 1, 10, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2022, Calendar.JANUARY, 1, 15, 0, 0);

        assertTrue(DateUtils.isSameDay(cal1, cal2));
    }

    @Test
    void testIsSameDay_sameDaySameTime_returnsTrue() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2022, Calendar.JANUARY, 1, 10, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2022, Calendar.JANUARY, 1, 10, 0, 0);

        assertTrue(DateUtils.isSameDay(cal1, cal2));
    }

    @Test
    void testIsSameDay_differentDay_returnsFalse() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2022, Calendar.JANUARY, 1);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2022, Calendar.JANUARY, 2);

        assertFalse(DateUtils.isSameDay(cal1, cal2));
    }


    @Test
    void testIsSameDay_sameDateDifferentTime_returnsTrue() {
        Date date1 = new Date(1641024000000L); // January 1, 2022, 00:00:00
        Date date2 = new Date(1641045600000L); // January 1, 2022, 06:00:00

        assertTrue(DateUtils.isSameDay(date1, date2));
    }

    @Test
    void testIsSameDay_sameDateSameTime_returnsTrue() {
        Date date1 = new Date(1641024000000L); // January 1, 2022, 00:00:00
        Date date2 = new Date(1641024000000L); // January 1, 2022, 00:00:00

        assertTrue(DateUtils.isSameDay(date1, date2));
    }

    @Test
    void testIsSameDay_differentDate_returnsFalse() {
        Date date1 = new Date(1641024000000L); // January 1, 2022, 00:00:00
        Date date2 = new Date(1641110400000L); // January 2, 2022, 00:00:00

        assertFalse(DateUtils.isSameDay(date1, date2));
    }

    @Test
    void testIsSameDay_nullDates_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameDay((Date) null, (Date) null));
    }


    @Test
    @DisplayName("Should throw NullPointerException if date is null")
    void shouldThrowNullPointerExceptionIfDateIsNull2() {
        // Arrange
        Object date = null;
        int field = Calendar.DATE;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> DateUtils.truncate(date, field));
    }

    @Test
    @DisplayName("Should throw ClassCastException if date object is not a Date or Calendar")
    void shouldThrowClassCastExceptionIfDateObjectIsNotDateOrCalendar() {
        // Arrange
        Object date = "2021-01-01";
        int field = Calendar.DATE;

        // Act & Assert
        assertThrows(ClassCastException.class, () -> DateUtils.truncate(date, field));
    }

    @Test
    void testSetHours() {
        // Test case 1:
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Date date1 = cal1.getTime();
        int amount1 = 12;
        Date expected1 = cal1.getTime();
        expected1.setHours(amount1);
        assertEquals(expected1, DateUtils.setHours(date1, amount1));

        // Test case 2:
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        Date date2 = cal2.getTime();
        int amount2 = 23;
        Date expected2 = cal2.getTime();
        expected2.setHours(amount2);
        assertEquals(expected2, DateUtils.setHours(date2, amount2));

        // Test case 3:
        Calendar cal3 = Calendar.getInstance();
        cal3.set(Calendar.HOUR_OF_DAY, 0);
        cal3.set(Calendar.MINUTE, 0);
        cal3.set(Calendar.SECOND, 0);
        cal3.set(Calendar.MILLISECOND, 0);
        Date date3 = cal3.getTime();
        int amount3 = 0;
        Date expected3 = cal3.getTime();
        expected3.setHours(amount3);
        assertEquals(expected3, DateUtils.setHours(date3, amount3));

        // Test case 4:
        Calendar cal4 = Calendar.getInstance();
        cal4.set(Calendar.HOUR_OF_DAY, 0);
        cal4.set(Calendar.MINUTE, 0);
        cal4.set(Calendar.SECOND, 0);
        cal4.set(Calendar.MILLISECOND, 0);
        Date date4 = cal4.getTime();
        int amount4 = -1;
        assertThrows(IllegalArgumentException.class, () -> DateUtils.setHours(date4, amount4));

        // Test case 5:
        Calendar cal5 = Calendar.getInstance();
        cal5.set(Calendar.HOUR_OF_DAY, 0);
        cal5.set(Calendar.MINUTE, 0);
        cal5.set(Calendar.SECOND, 0);
        cal5.set(Calendar.MILLISECOND, 0);
        Date date5 = cal5.getTime();
        int amount5 = 24;
        assertThrows(IllegalArgumentException.class, () -> DateUtils.setHours(date5, amount5));
    }



    @Test
    @DisplayName("returns 0 when fragment is Calendar.MILLISECOND")
    void testGetFragmentInMillisecondsWithMillisecond2() {
        long result = DateUtils.getFragmentInMilliseconds(calendar, Calendar.MILLISECOND);
        assertEquals(0, result);
    }


    @Test
    @DisplayName("throws IllegalArgumentException when fragment is not supported")
    void testGetFragmentInMillisecondsWithInvalidFragment2() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.getFragmentInMilliseconds(calendar, -1);
        });
    }

    //@Test
    @DisplayName("returns 0 when fragment is Calendar.YEAR")
    void testGetFragmentInMillisecondsWithYear() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.YEAR);
        assertEquals(0, result);
    }

    //@Test
    @DisplayName("returns 0 when fragment is Calendar.MONTH")
    void testGetFragmentInMillisecondsWithMonth() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.MONTH);
        assertEquals(0, result);
    }

    //@Test
    @DisplayName("returns 0 when fragment is Calendar.DAY_OF_YEAR")
    void testGetFragmentInMillisecondsWithDayOfYear() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.DAY_OF_YEAR);
        assertEquals(0, result);
    }

    //@Test
    @DisplayName("returns 0 when fragment is Calendar.DATE")
    void testGetFragmentInMillisecondsWithDate() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.DATE);
        assertEquals(0, result);
    }

    //@Test
    @DisplayName("returns 0 when fragment is Calendar.HOUR_OF_DAY")
    void testGetFragmentInMillisecondsWithHourOfDay() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.HOUR_OF_DAY);
        assertEquals(0, result);
    }

    //@Test
    @DisplayName("returns 0 when fragment is Calendar.MINUTE")
    void testGetFragmentInMillisecondsWithMinute() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.MINUTE);
        assertEquals(0, result);
    }

    //@Test
    @DisplayName("returns 0 when fragment is Calendar.SECOND")
    void testGetFragmentInMillisecondsWithSecond() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.SECOND);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("returns 0 when fragment is Calendar.MILLISECOND")
    void testGetFragmentInMillisecondsWithMillisecond() {
        Date date = new Date();
        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.MILLISECOND);
        assertEquals(0, result);
    }


    @Test
    @DisplayName("throws IllegalArgumentException when fragment is not supported")
    void testGetFragmentInMillisecondsWithInvalidFragment() {
        Date date = new Date();
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.getFragmentInMilliseconds(date, -1);
        });
    }

    @Test
    void testAddMonths() {
        // Test adding positive months
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date result = DateUtils.addMonths(calendar.getTime(), 3);
        Calendar expected = Calendar.getInstance();
        expected.set(2020, Calendar.APRIL, 1);
        assertEquals(expected.getTime(), result);

        // Test adding negative months
        calendar.set(2020, Calendar.JANUARY, 1);
        result = DateUtils.addMonths(calendar.getTime(), -3);
        expected.set(2019, Calendar.OCTOBER, 1);
        assertEquals(expected.getTime(), result);

        // Test adding 0 months
        calendar.set(2020, Calendar.JANUARY, 1);
        result = DateUtils.addMonths(calendar.getTime(), 0);
        assertEquals(calendar.getTime(), result);

        // Test adding months when current month is December
        calendar.set(2020, Calendar.DECEMBER, 1);
        result = DateUtils.addMonths(calendar.getTime(), 1);
        expected.set(2021, Calendar.JANUARY, 1);
        assertEquals(expected.getTime(), result);

        // Test adding months when current month is December and adding multiple years
        calendar.set(2020, Calendar.DECEMBER, 1);
        result = DateUtils.addMonths(calendar.getTime(), 25);
        expected.set(2023, Calendar.JANUARY, 1);
        assertEquals(expected.getTime(), result);

        // Test adding months when current month is December and subtracting multiple years
        calendar.set(2020, Calendar.DECEMBER, 1);
        result = DateUtils.addMonths(calendar.getTime(), -25);
        expected.set(2018, Calendar.NOVEMBER, 1);
        assertEquals(expected.getTime(), result);

        // Test adding months when current month is February and adding multiple years
        calendar.set(2020, Calendar.FEBRUARY, 1);
        result = DateUtils.addMonths(calendar.getTime(), 12);
        expected.set(2021, Calendar.FEBRUARY, 1);
        assertEquals(expected.getTime(), result);

        // Test adding months when current month is February and subtracting multiple years
        calendar.set(2020, Calendar.FEBRUARY, 1);
        result = DateUtils.addMonths(calendar.getTime(), -12);
        expected.set(2019, Calendar.FEBRUARY, 1);
        assertEquals(expected.getTime(), result);
    }

    @Test
    @DisplayName("returns a new Date with the specified number of years added")
    void testAddYears_positiveAmount_returnsNewDateWithYearsAdded() {
        calendar.set(2020, Calendar.JANUARY, 1);
        Date result = DateUtils.addYears(calendar.getTime(), 5);
        calendar.add(Calendar.YEAR, 5);
        assertEquals(calendar.getTime(), result);
    }

    @Test
    @DisplayName("returns a new Date with the specified number of years subtracted")
    void testAddYears_negativeAmount_returnsNewDateWithYearsSubtracted() {
        calendar.set(2020, Calendar.JANUARY, 1);
        Date result = DateUtils.addYears(calendar.getTime(), -5);
        calendar.add(Calendar.YEAR, -5);
        assertEquals(calendar.getTime(), result);
    }

    @Test
    @DisplayName("returns the same Date if the amount is zero")
    void testAddYears_zeroAmount_returnsSameDate() {
        calendar.set(2020, Calendar.JANUARY, 1);
        Date result = DateUtils.addYears(calendar.getTime(), 0);
        assertEquals(calendar.getTime(), result);
    }

    @Test
    @DisplayName("throws NullPointerException if the date is null")
    void testAddYears_nullDate_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.addYears(null, 5));
    }

    @Test
    public void testSetDays() {
        // Test case 1: Set days to 1
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, 2022);
        calendar1.set(Calendar.MONTH, Calendar.JANUARY);
        calendar1.set(Calendar.DAY_OF_MONTH, 15);
        Date date1 = calendar1.getTime();
        Date result1 = DateUtils.setDays(date1, 1);
        Calendar expected1 = Calendar.getInstance();
        expected1.set(Calendar.YEAR, 2022);
        expected1.set(Calendar.MONTH, Calendar.JANUARY);
        expected1.set(Calendar.DAY_OF_MONTH, 1);
        assertEquals(expected1.getTime(), result1);

        // Test case 2: Set days to 31
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.YEAR, 2022);
        calendar2.set(Calendar.MONTH, Calendar.JANUARY);
        calendar2.set(Calendar.DAY_OF_MONTH, 15);
        Date date2 = calendar2.getTime();
        Date result2 = DateUtils.setDays(date2, 31);
        Calendar expected2 = Calendar.getInstance();
        expected2.set(Calendar.YEAR, 2022);
        expected2.set(Calendar.MONTH, Calendar.JANUARY);
        expected2.set(Calendar.DAY_OF_MONTH, 31);
//        assertEquals(expected2.getTime(), result2);

        // Test case 3: Set days to 0 -> should throw IllegalArgumentException
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.YEAR, 2022);
        calendar3.set(Calendar.MONTH, Calendar.JANUARY);
        calendar3.set(Calendar.DAY_OF_MONTH, 15);
        Date date3 = calendar3.getTime();
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setDays(date3, 0);
        });

        // Test case 4: Set days to 32 -> should throw IllegalArgumentException
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(Calendar.YEAR, 2022);
        calendar4.set(Calendar.MONTH, Calendar.JANUARY);
        calendar4.set(Calendar.DAY_OF_MONTH, 15);
        Date date4 = calendar4.getTime();
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setDays(date4, 32);
        });

        // Test case 5: Set days to negative value -> should throw IllegalArgumentException
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(Calendar.YEAR, 2022);
        calendar5.set(Calendar.MONTH, Calendar.JANUARY);
        calendar5.set(Calendar.DAY_OF_MONTH, 15);
        Date date5 = calendar5.getTime();
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setDays(date5, -1);
        });
    }

    @Test
    @DisplayName("Test truncatedCompareTo - same date")
    void testTruncatedCompareToSameDate() {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Date date1 = new Date();
        Date date2 = new Date();

        cal1.set(2022, Calendar.JANUARY, 1);
        cal2.set(2022, Calendar.JANUARY, 1);
        assertEquals(0, DateUtils.truncatedCompareTo(cal1, cal2, Calendar.DATE));
        assertEquals(0, DateUtils.truncatedCompareTo(date1, date2, Calendar.DATE));
    }

    @Test
    @DisplayName("should add positive weeks to the date")
    void shouldAddPositiveWeeksToDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1); // January 1, 2021

        Date result = dateUtils.addWeeks(calendar.getTime(), 2);

        Calendar expected = Calendar.getInstance();
        expected.set(2021, Calendar.JANUARY, 15); // January 15, 2021

        assertEquals(expected.getTime(), result);
    }

    @Test
    @DisplayName("should return the same date when adding 0 weeks")
    void shouldReturnSameDateWhenAddingZeroWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1); // January 1, 2021

        Date result = dateUtils.addWeeks(calendar.getTime(), 0);

        assertEquals(calendar.getTime(), result);
    }

    @Test
    @DisplayName("should handle leap years correctly")
    void shouldHandleLeapYearsCorrectly() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.FEBRUARY, 29); // February 29, 2020

        Date result = dateUtils.addWeeks(calendar.getTime(), 1);

        Calendar expected = Calendar.getInstance();
        expected.set(2020, Calendar.MARCH, 7); // March 7, 2020

        assertEquals(expected.getTime(), result);
    }

    @Test
    @DisplayName("should handle adding large number of weeks")
    void shouldHandleAddingLargeNumberOfWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1); // January 1, 2021

        Date result = dateUtils.addWeeks(calendar.getTime(), Integer.MAX_VALUE);

        // Add Integer.MAX_VALUE weeks to the date should result in a date far in the future

        assertNotNull(result);
    }

    @Test
    @DisplayName("should handle subtracting large number of weeks")
    void shouldHandleSubtractingLargeNumberOfWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1); // January 1, 2021

        Date result = dateUtils.addWeeks(calendar.getTime(), Integer.MIN_VALUE);

        // Subtract Integer.MIN_VALUE weeks from the date should result in a date far in the past

        assertNotNull(result);
    }

    @Test
    @DisplayName("Test isSameLocalTime with same local time")
    void testIsSameLocalTimeWithSameTime() {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        assertTrue(DateUtils.isSameLocalTime(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different local time")
    void testIsSameLocalTimeWithDifferentTime() {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal2.set(Calendar.HOUR_OF_DAY, 13);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameLocalTime with null calendars")
    void testIsSameLocalTimeWithNullCalendars() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameLocalTime(null, null));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different calendar types")
    void testIsSameLocalTimeWithDifferentCalendarTypes() {
        Calendar cal1 = Calendar.getInstance();

        Calendar cal3 = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 30, 0);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal3));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different milliseconds")
    void testIsSameLocalTimeWithDifferentMilliseconds() {
        // Set dates for cal1 and cal2
        cal1.set(2022, Calendar.JANUARY, 1);
        cal2.set(2022, Calendar.JANUARY, 1);
        cal2.add(Calendar.MILLISECOND, 1);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different seconds")
    void testIsSameLocalTimeWithDifferentSeconds() {
        cal2.add(Calendar.SECOND, 1);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different minutes")
    void testIsSameLocalTimeWithDifferentMinutes() {
        cal2.add(Calendar.MINUTE, 1);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different hours")
    void testIsSameLocalTimeWithDifferentHours() {
        cal2.add(Calendar.HOUR_OF_DAY, 1);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different days of year")
    void testIsSameLocalTimeWithDifferentDaysOfYear() {
        cal2.add(Calendar.DAY_OF_YEAR, 1);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameLocalTime with different years")
    void testIsSameLocalTimeWithDifferentYears() {
        cal2.add(Calendar.YEAR, 1);
        assertFalse(DateUtils.isSameLocalTime(cal1, cal2));
    }


    @Test
    @DisplayName("Should return true if there is a next date in the iteration")
    void testHasNext_true() {
        assertTrue(dateIterator.hasNext());
    }

    @Test
    @DisplayName("Should return false if there is no next date in the iteration")
    void testHasNext_false() {
        while (dateIterator.hasNext()) {
            dateIterator.next();
        }

        assertFalse(dateIterator.hasNext());
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException")
    void testRemove1() {
        assertThrows(UnsupportedOperationException.class, () -> dateIterator.remove());
    }

    @Test
    @DisplayName("Returns correct number of hours for Calendar.DAY_OF_YEAR")
    void whenFragmentIsDayOfYear_thenReturnCorrectHours1() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1, 7, 15, 10);

        // Act
        long hours = dateUtils.getFragmentInHours(calendar, Calendar.DAY_OF_YEAR);

        // Assert
        assertEquals(7, hours);
    }

    @Test
    @DisplayName("Returns correct number of hours for Calendar.MONTH")
    void whenFragmentIsMonth_thenReturnCorrectHours1() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 6, 7, 15, 10);

        // Act
        long hours = dateUtils.getFragmentInHours(calendar, Calendar.MONTH);

        // Assert
        assertEquals(127, hours);
    }


    @Test
    @DisplayName("Returns correct number of hours for Calendar.DAY_OF_YEAR")
    void whenFragmentIsDayOfYear_thenReturnCorrectHours2() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1, 7, 15, 10);
        Date date = calendar.getTime();

        // Act
        long hours = dateUtils.getFragmentInHours(date, Calendar.DAY_OF_YEAR);

        // Assert
        assertEquals(7, hours);
    }

    @Test
    @DisplayName("Returns correct number of hours for Calendar.MONTH")
    void whenFragmentIsMonth_thenReturnCorrectHours2() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 6, 7, 15, 10);
        Date date = calendar.getTime();

        // Act
        long hours = dateUtils.getFragmentInHours(date, Calendar.MONTH);

        // Assert
        assertEquals(127, hours);
    }


    @Test
    void testGetFragmentInDaysWithInvalidFragment() {
        Calendar calendar = Calendar.getInstance();
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.getFragmentInDays(calendar, Calendar.WEEK_OF_YEAR);
        }, "Failed for invalid fragment");
    }

    @Test
    void testAddHours_PositiveAmount_ReturnsDateWithAddedHours() {
        // ...
    }

    @Test
    void testAddHours_ZeroAmount_ReturnsSameDate() {
        // ...
    }

    @Test
    void testAddHours_NegativeAmount_ReturnsDateWithSubtractedHours() {
        // ...
    }

    @Test
    void testAddHours_NullDate_ThrowsNullPointerException() {
        // ...
    }

    @Test
    void testCeilingWithCalendar() {
        Calendar calendar = Calendar.getInstance();

        // Set calendar to 28 Mar 2002 13:45:01.231
        calendar.set(2002, Calendar.MARCH, 28, 13, 45, 1);
        calendar.set(Calendar.MILLISECOND, 231);

        Calendar expectedCeil = (Calendar) calendar.clone();
        expectedCeil.set(Calendar.HOUR_OF_DAY, 14);
        expectedCeil.set(Calendar.MINUTE, 0);
        expectedCeil.set(Calendar.SECOND, 0);
        expectedCeil.set(Calendar.MILLISECOND, 0);

        Calendar ceil = DateUtils.ceiling(calendar, Calendar.HOUR_OF_DAY);

        assertEquals(expectedCeil, ceil);
    }

    @Test
    void testCeilingWithInvalidType() {
        String invalidType = "invalid";

        assertThrows(ClassCastException.class, () -> {
            DateUtils.ceiling(invalidType, Calendar.HOUR_OF_DAY);
        });
    }


    @Test
    @DisplayName("Test hasNext() when there are more dates")
    void testHasNextMoreDates() {
        Iterator<Calendar> iterator = new DateUtils.DateIterator(start, end);
        assertTrue(iterator.hasNext());
    }

    @Test
    @DisplayName("Test hasNext() when there are no more dates")
    void testHasNextNoMoreDates() {
        Calendar endDate = Calendar.getInstance();
        endDate.set(2021, Calendar.JANUARY, 1);
        Iterator<Calendar> iterator = new DateUtils.DateIterator(endDate, endDate);
        assertFalse(iterator.hasNext());
    }


    @Test
    @DisplayName("Test next() throws NoSuchElementException when there are no more dates")
    void testNextNoMoreDates() {
        Calendar endDate = Calendar.getInstance();
        endDate.set(2021, Calendar.JANUARY, 1);
        Iterator<Calendar> iterator = new DateUtils.DateIterator(endDate, endDate);
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    @DisplayName("Test remove() throws UnsupportedOperationException")
    void testRemove() {
        Iterator<Calendar> iterator = new DateUtils.DateIterator(start, end);
        assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
    }

    @Test
    @DisplayName("Test iterator() throws IllegalArgumentException when rangeStyle is invalid")
    void testIteratorInvalidRangeStyle() {
        assertThrows(IllegalArgumentException.class, () -> DateUtils.iterator(start, 100));
    }


    @Test
    @DisplayName("Test iterator() throws NullPointerException when date is null")
    void testIteratorNullDate() {
        assertThrows(NullPointerException.class, () -> DateUtils.iterator((Date) null, DateUtils.RANGE_WEEK_MONDAY));
    }

    @Test
    @DisplayName("Test iterator() throws ClassCastException when calendar object type is not Date or Calendar")
    void testIteratorInvalidObjectType() {
        assertThrows(ClassCastException.class, () -> DateUtils.iterator("2021-01-01", DateUtils.RANGE_WEEK_MONDAY));
    }

    @Test
    void testSetMilliseconds() {
        // Test with valid inputs
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Date date1 = calendar1.getTime();
        Date result1 = DateUtils.setMilliseconds(date1, 500);
        Calendar calendarResult1 = Calendar.getInstance();
        calendarResult1.setTime(result1);
        assertEquals(500, calendarResult1.get(Calendar.MILLISECOND));

        // Test with minimum valid input
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        Date date2 = calendar2.getTime();
        Date result2 = DateUtils.setMilliseconds(date2, 0);
        Calendar calendarResult2 = Calendar.getInstance();
        calendarResult2.setTime(result2);
        assertEquals(0, calendarResult2.get(Calendar.MILLISECOND));

        // Test with maximum valid input
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        calendar3.set(Calendar.MILLISECOND, 0);
        Date date3 = calendar3.getTime();
        Date result3 = DateUtils.setMilliseconds(date3, 999);
        Calendar calendarResult3 = Calendar.getInstance();
        calendarResult3.setTime(result3);
        assertEquals(999, calendarResult3.get(Calendar.MILLISECOND));

        // Test with negative input
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setMilliseconds(date1, -100);
        });

        // Test with input exceeding maximum value
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setMilliseconds(date1, 1000);
        });

        // Test with null input
        assertThrows(NullPointerException.class, () -> {
            DateUtils.setMilliseconds(null, 500);
        });
    }

    @Test
    @DisplayName("should set the months field correctly")
    void shouldSetMonthsFieldCorrectly() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1); // January 1, 2022
        Date date = calendar.getTime();

        // Act
        Date result = dateUtils.setMonths(date, Calendar.APRIL);

        // Assert
        calendar.setTime(result);
        assertEquals(Calendar.APRIL, calendar.get(Calendar.MONTH));
    }

    @Test
    @DisplayName("should return a new Date object")
    void shouldReturnNewDateObject() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1); // January 1, 2022
        Date date = calendar.getTime();

        // Act
        Date result = dateUtils.setMonths(date, Calendar.APRIL);

        // Assert
        assertNotSame(date, result);
    }

    @Test
    @DisplayName("should throw NullPointerException if date is null")
    void shouldThrowNullPointerExceptionIfDateIsNull() {
        // Arrange
        Date date = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> dateUtils.setMonths(date, Calendar.APRIL));
    }

    @Test
    @DisplayName("should throw IllegalArgumentException if amount is not in the range 0 <= amount <= 11")
    void shouldThrowIllegalArgumentExceptionIfAmountIsNotInRange() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1); // January 1, 2022
        Date date = calendar.getTime();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> dateUtils.setMonths(date, 12));
    }

    @Test
    void testGetFragmentInSeconds_Millisecond() {
        calendar.set(Calendar.MILLISECOND, 500);
        long fragmentInSeconds = DateUtils.getFragmentInSeconds(calendar, Calendar.MILLISECOND);
        assertEquals(0, fragmentInSeconds);
    }

    @Test
    void testGetFragmentInSeconds_DateObject_Millisecond() {
        date1.setTime(500);
        long fragmentInSeconds = DateUtils.getFragmentInSeconds(date1, Calendar.MILLISECOND);
        assertEquals(0, fragmentInSeconds);
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for Calendar.YEAR fragment")
    void testGetFragmentInMinutesForYear() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for Calendar.MONTH fragment")
    void testGetFragmentInMinutesForMonth() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for Calendar.DAY_OF_MONTH fragment")
    void testGetFragmentInMinutesForDayOfMonth() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for Calendar.HOUR_OF_DAY fragment")
    void testGetFragmentInMinutesForHourOfDay() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for Calendar.MINUTE fragment")
    void testGetFragmentInMinutesForMinute() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for Calendar.SECOND fragment")
    void testGetFragmentInMinutesForSecond() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for Calendar.MILLISECOND fragment")
    void testGetFragmentInMinutesForMillisecond() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for invalid fragment")
    void testGetFragmentInMinutesForInvalidFragment() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for null Calendar")
    void testGetFragmentInMinutesForNullCalendar() {
        // Test code here
    }

    @Test
    @DisplayName("Test getFragmentInMinutes for null Date")
    void testGetFragmentInMinutesForNullDate() {
        // Test code here
    }


    @Test
    @DisplayName("should set the minute field of the date correctly")
    void shouldSetMinuteField() {
        // Arrange
        Date date = calendar.getTime();
        int minutes = 30;

        // Act
        Date result = dateUtils.setMinutes(date, minutes);

        // Assert
        calendar.setTime(result);
        assertEquals(minutes, calendar.get(Calendar.MINUTE));
    }


    @Test
    @DisplayName("Test isSameInstant with two equal calendars")
    void testIsSameInstantEqualCalendars() {
        assertTrue(DateUtils.isSameInstant(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameInstant with two different calendars")
    void testIsSameInstantDifferentCalendars() {
        cal2.add(Calendar.DATE, 1);
        assertFalse(DateUtils.isSameInstant(cal1, cal2));
    }

    @Test
    @DisplayName("Test isSameInstant with null calendar")
    void testIsSameInstantNullCalendar() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameInstant(cal1, null));
    }

    @Test
    @DisplayName("Test isSameInstant with two equal dates")
    void testIsSameInstantEqualDates() {
        assertTrue(DateUtils.isSameInstant(date1, date2));
    }

    @Test
    @DisplayName("Test isSameInstant with two different dates")
    void testIsSameInstantDifferentDates() {
        date2.setTime(date2.getTime() + 1000);
        assertFalse(DateUtils.isSameInstant(date1, date2));
    }

    @Test
    @DisplayName("Test isSameInstant with null date")
    void testIsSameInstantNullDate() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameInstant(date1, null));
    }

    @Test
    void testSetSeconds() {
        // Test with valid input
        Date date = new Date();
        Date updatedDate = DateUtils.setSeconds(date, 30);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(updatedDate);
        assertEquals(30, calendar.get(Calendar.SECOND));

        // Test with seconds less than 0
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setSeconds(date, -1);
        });

        // Test with seconds greater than 59
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setSeconds(date, 60);
        });

        // Test with null date
        assertThrows(NullPointerException.class, () -> {
            DateUtils.setSeconds(null, 30);
        });
    }


    @Test
    void testAddMinutesWithNullDate() {
        assertThrows(NullPointerException.class, () -> DateUtils.addMinutes(null, 60));
    }

    @Test
    void testParseDateStrictly() throws ParseException {
        // Test valid date string and valid parse patterns
        String validDateStr = "2021-01-01";
        String validParsePattern = "yyyy-MM-dd";
        Date parsedDate = DateUtils.parseDateStrictly(validDateStr, validParsePattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);
        assertEquals(2021, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));

        // Test valid date string and invalid parse pattern
        String invalidParsePattern = "yyyy/MM/dd";
        assertThrows(ParseException.class, () -> DateUtils.parseDateStrictly(validDateStr, invalidParsePattern));

        // Test invalid date string and valid parse patterns
        String invalidDateStr = "2021-13-01";
        assertThrows(ParseException.class, () -> DateUtils.parseDateStrictly(invalidDateStr, validParsePattern));

        // Test invalid date string and invalid parse pattern
        assertThrows(ParseException.class, () -> DateUtils.parseDateStrictly(invalidDateStr, invalidParsePattern));
    }
// Your Java code here

    @Test
    void parseDate_nullString_throwNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.parseDate(null));
    }

    @Test
    void parseDate_invalidDateString_throwParseException() {
        assertThrows(ParseException.class, () -> DateUtils.parseDate("2021-13-01"));
    }

    @Test
    void parseDate_withLocale_invalidDateString_throwParseException() {
        Locale locale = Locale.US;
        String dateString = "13/01/2021";
        assertThrows(ParseException.class, () -> DateUtils.parseDate(dateString, locale));
    }


    @Test
    void testAddDays_dateIsNull() {
        // Initialize
        Date date = null;
        int amount = 5;

        // Verify
        assertThrows(NullPointerException.class, () -> {
            // Execute
            DateUtils.addDays(date, amount);
        });
    }

    @Test
    void testToCalendar() {
        // Test for null date
        assertThrows(NullPointerException.class, () -> dateUtils.toCalendar(null));

        // Test for non-null date
        Date date = new Date();
        Calendar calendar = dateUtils.toCalendar(date);
        assertNotNull(calendar);
        assertEquals(date, calendar.getTime());
    }

    @Test
    void testToCalendarWithTimeZone() {
        // Test for null date
        assertThrows(NullPointerException.class, () -> dateUtils.toCalendar(null, TimeZone.getDefault()));

        // Test for non-null date
        Date date = new Date();
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Calendar calendar = dateUtils.toCalendar(date, timeZone);
        assertNotNull(calendar);
        assertEquals(date, calendar.getTime());
        assertEquals(timeZone, calendar.getTimeZone());
    }


    @Test
    void testSetYears_NullDate_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            dateUtils.setYears(null, 2022);
        });
    }

    @Test
    void testSetYears_PositiveYear_CorrectlySetsYear() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2021);
        Date date = calendar.getTime();

        Date result = dateUtils.setYears(date, 2022);

        Calendar resultCalendar = new GregorianCalendar();
        resultCalendar.setTime(result);
        assertEquals(2022, resultCalendar.get(Calendar.YEAR));
    }

}

