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
import java.util.Date;

public class GmtTimeZoneTest {
    private GmtTimeZone gmtTimeZone;

    @BeforeEach
    void setUp() {
        gmtTimeZone = new GmtTimeZone(false, 0, 0);
    }

    @Test
    public void testGetID() {
        Assertions.assertEquals("GMT+00:00", gmtTimeZone.getID());
    }

    @Test
    public void testGetID_NegativeOffset() {
        GmtTimeZone negativeOffsetGmtTimeZone = new GmtTimeZone(true, 0, 0);
        Assertions.assertEquals("GMT-00:00", negativeOffsetGmtTimeZone.getID());
    }

    @Test
    public void testGetID_HoursOutOfRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 25, 0);
        });
    }

    @Test
    public void testGetID_MinutesOutOfRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 0, 60);
        });
    }

    @Test
    public void testGetID_MidnightOffset() {
        GmtTimeZone midnightOffsetGmtTimeZone = new GmtTimeZone(false, 0, 0);
        Assertions.assertEquals("GMT+00:00", midnightOffsetGmtTimeZone.getID());
    }

    @Test
    public void testGetID_MaximumOffset() {
        GmtTimeZone maximumOffsetGmtTimeZone = new GmtTimeZone(false, 23, 59);
        Assertions.assertEquals("GMT+23:59", maximumOffsetGmtTimeZone.getID());
    }

    @Test
    public void testGetID_MinimumOffset() {
        GmtTimeZone minimumOffsetGmtTimeZone = new GmtTimeZone(false, 0, 1);
        Assertions.assertEquals("GMT+00:01", minimumOffsetGmtTimeZone.getID());
    }

    @Test
    void testHashCodeSameObject() {
        assertEquals(gmtTimeZone.hashCode(), gmtTimeZone.hashCode());
    }

    @Test
    void testHashCodeEqualObjects() {
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 0, 0);
        assertEquals(gmtTimeZone.hashCode(), gmtTimeZone2.hashCode());
    }

    @Test
    void testHashCodeDifferentOffset() {
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 1, 0);
        assertNotEquals(gmtTimeZone.hashCode(), gmtTimeZone2.hashCode());
    }

    @Test
    void testHashCodeDifferentObjects() {
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(true, 0, 0);
        assertNotEquals(gmtTimeZone.hashCode(), gmtTimeZone2.hashCode());
    }

    @Test
    @DisplayName("should return correct offset for a given date and time")
    void shouldReturnCorrectOffset() {
        int offset = gmtTimeZone.getOffset(1, 2022, Calendar.JANUARY, 1, Calendar.SATURDAY, 0);
        Assertions.assertEquals(0, offset);
    }


    @Test
    @DisplayName("should return correct offset for a given milliseconds")
    void shouldReturnCorrectOffsetForMilliseconds() {
        int offset = gmtTimeZone.getOffset(1, 2022, Calendar.JANUARY, 1, Calendar.SATURDAY, 5000);
        Assertions.assertEquals(0, offset);
    }


    @Test
    void testInDaylightTime() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 0);
        Date date = new Date();

        boolean result = gmtTimeZone.inDaylightTime(date);

        assertFalse(result);
    }

    @Test
    void testInDaylightTimeWithNegativeOffset() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 0, 0);
        Date date = new Date();

        boolean result = gmtTimeZone.inDaylightTime(date);

        assertFalse(result);
    }

    @Test
    void testInDaylightTimeWithPositiveOffset() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 0);
        Date date = new Date();

        boolean result = gmtTimeZone.inDaylightTime(date);

        assertFalse(result);
    }


    @Test
    void testInDaylightTimeWithOutOfRangeHours() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 25, 0);
        });
    }

    @Test
    void testInDaylightTimeWithOutOfRangeMinutes() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 0, 61);
        });
    }

    @Test
    public void testGetRawOffset_PositiveOffset_ReturnsOffsetInMilliseconds() {
        assertEquals(0, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(false, 1, 0);
        assertEquals(60 * 60 * 1000, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(false, 0, 30);
        assertEquals(30 * 60 * 1000, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(false, 1, 30);
        assertEquals((60 * 60 * 1000) + (30 * 60 * 1000), gmtTimeZone.getRawOffset());
    }

    @Test
    public void testGetRawOffset_NegativeOffset_ReturnsOffsetInMilliseconds() {
        gmtTimeZone = new GmtTimeZone(true, 0, 0);
        assertEquals(0, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(true, 1, 0);
        assertEquals(-60 * 60 * 1000, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(true, 0, 30);
        assertEquals(-30 * 60 * 1000, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(true, 1, 30);
        assertEquals(-((60 * 60 * 1000) + (30 * 60 * 1000)), gmtTimeZone.getRawOffset());
    }


    @Test
    public void testGetRawOffset_EdgeCaseHours_ReturnsCorrectOffset() {
        gmtTimeZone = new GmtTimeZone(false, 0, 0);
        assertEquals(0, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(false, 23, 0);
        assertEquals(23 * 60 * 60 * 1000, gmtTimeZone.getRawOffset());
    }

    @Test
    public void testGetRawOffset_EdgeCaseMinutes_ReturnsCorrectOffset() {
        gmtTimeZone = new GmtTimeZone(false, 0, 0);
        assertEquals(0, gmtTimeZone.getRawOffset());

        gmtTimeZone = new GmtTimeZone(false, 0, 59);
        assertEquals(59 * 60 * 1000, gmtTimeZone.getRawOffset());
    }

    @Test
    void testEqualsEqualObjects() {
        // test code here
    }

    @Test
    void testEqualsDifferentOffsets() {
        // test code here
    }

    @Test
    void testEqualsDifferentZoneIds() {
        // test code here
    }

    @Test
    void testEqualsDifferentTypes() {
        // test code here
    }

    @Test
    void testEqualsEqualObjectsNegativeOffset() {
        // test code here
    }

    @Test
    void testEqualsEqualObjectsMaximumOffset() {
        // test code here
    }

    @Test
    void testEqualsDifferentOffsetsMaximumOffset() {
        // test code here
    }

    @Test
    void testEqualsDifferentZoneIdsMaximumZoneId() {
        // test code here
    }

    @Test
    void testEqualsDifferentZoneIdsNull() {
        // test code here
    }

    @Test
    void testEqualsDifferentZoneIdsNullOnThis() {
        // test code here
    }

    @Test
    void testEqualsDifferentZoneIdsNullOnBoth() {
        // test code here
    }


    @Test
    @DisplayName("should throw IllegalArgumentException for hours out of range")
    void shouldThrowIllegalArgumentExceptionForHoursOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, 24, 0));
    }

    @Test
    @DisplayName("should throw IllegalArgumentException for minutes out of range")
    void shouldThrowIllegalArgumentExceptionForMinutesOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, 0, 60));
    }

    @Test
    void returnsFalseForAllCases() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 0);

        boolean result = gmtTimeZone.useDaylightTime();

        Assertions.assertFalse(result);
    }

    @Test
    void throwsIllegalArgumentExceptionWhenHoursOutOfRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 24, 0);
        });
    }

    @Test
    void throwsIllegalArgumentExceptionWhenMinutesOutOfRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 0, 60);
        });
    }

    @Test
    @DisplayName("Throws exception when hours is out of range")
    void testGmtTimeZoneOutOfRangeHours() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new GmtTimeZone(false, 25, 0));
    }

    @Test
    @DisplayName("Throws exception when minutes is out of range")
    void testGmtTimeZoneOutOfRangeMinutes() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new GmtTimeZone(false, 12, 60));
    }

}