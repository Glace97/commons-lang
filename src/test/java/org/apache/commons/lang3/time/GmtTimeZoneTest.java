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

public class GmtTimeZoneTest {
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
    void testHashCodeDifferentZoneId() {
        GmtTimeZone gmtTimeZone2 = new GmtTimeZone(false, 0, 0);
        gmtTimeZone2.zoneId = "GMT+01:00";
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
        @DisplayName("should throw IllegalArgumentException if era is out of range")
        void shouldThrowIllegalArgumentExceptionForOutOfRangeEra() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    gmtTimeZone.getOffset(0, 2022, Calendar.JANUARY, 1, Calendar.SATURDAY, 0));
        }
    
        @Test
        @DisplayName("should throw IllegalArgumentException if year is out of range")
        void shouldThrowIllegalArgumentExceptionForOutOfRangeYear() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    gmtTimeZone.getOffset(1, 10000, Calendar.JANUARY, 1, Calendar.SATURDAY, 0));
        }
    
        @Test
        @DisplayName("should throw IllegalArgumentException if month is out of range")
        void shouldThrowIllegalArgumentExceptionForOutOfRangeMonth() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    gmtTimeZone.getOffset(1, 2022, 13, 1, Calendar.SATURDAY, 0));
        }
    
        @Test
        @DisplayName("should throw IllegalArgumentException if day is out of range")
        void shouldThrowIllegalArgumentExceptionForOutOfRangeDay() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    gmtTimeZone.getOffset(1, 2022, Calendar.JANUARY, 32, Calendar.SATURDAY, 0));
        }
    
        @Test
        @DisplayName("should throw IllegalArgumentException if dayOfWeek is out of range")
        void shouldThrowIllegalArgumentExceptionForOutOfRangeDayOfWeek() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    gmtTimeZone.getOffset(1, 2022, Calendar.JANUARY, 1, 7, 0));
        }
    
        @Test
        @DisplayName("should return correct offset for a given milliseconds")
        void shouldReturnCorrectOffsetForMilliseconds() {
            int offset = gmtTimeZone.getOffset(1, 2022, Calendar.JANUARY, 1, Calendar.SATURDAY, 5000);
            Assertions.assertEquals(0, offset);
        }
    @Test
    public void testSetRawOffset_PositiveOffset_Success() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 2, 30);
        int offsetMillis = 7200000;
        
        gmtTimeZone.setRawOffset(offsetMillis);
        
        Assertions.assertEquals(offsetMillis, gmtTimeZone.offset);
    }
    
    @Test
    public void testSetRawOffset_NegativeOffset_Success() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 1, 45);
        int offsetMillis = -6300000;
        
        gmtTimeZone.setRawOffset(offsetMillis);
        
        Assertions.assertEquals(offsetMillis, gmtTimeZone.offset);
    }
    
    @Test
    public void testSetRawOffset_ZeroOffset_Success() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 0);
        int offsetMillis = 0;
        
        gmtTimeZone.setRawOffset(offsetMillis);
        
        Assertions.assertEquals(offsetMillis, gmtTimeZone.offset);
    }
    
    @Test
    public void testSetRawOffset_MaxHoursOutOfRange_ExceptionThrown() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 24, 0);
        int offsetMillis = 0;
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gmtTimeZone.setRawOffset(offsetMillis);
        });
    }
    
    @Test
    public void testSetRawOffset_MaxMinutesOutOfRange_ExceptionThrown() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 60);
        int offsetMillis = 0;
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gmtTimeZone.setRawOffset(offsetMillis);
        });
    }
    
    @Test
    public void testSetRawOffset_NegativeMaxHoursOutOfRange_ExceptionThrown() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 25, 0);
        int offsetMillis = 0;
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gmtTimeZone.setRawOffset(offsetMillis);
        });
    }
    
    @Test
    public void testSetRawOffset_NegativeMaxMinutesOutOfRange_ExceptionThrown() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 0, 61);
        int offsetMillis = 0;
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gmtTimeZone.setRawOffset(offsetMillis);
        });
    }
    
    @Test
    public void testSetRawOffset_LargePositiveOffset_Success() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 0);
        int offsetMillis = 86400000;
        
        gmtTimeZone.setRawOffset(offsetMillis);
        
        Assertions.assertEquals(offsetMillis, gmtTimeZone.offset);
    }
    
    @Test
    public void testSetRawOffset_LargeNegativeOffset_Success() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 0, 0);
        int offsetMillis = -86400000;
        
        gmtTimeZone.setRawOffset(offsetMillis);
        
        Assertions.assertEquals(offsetMillis, gmtTimeZone.offset);
    }
    // Your Java code here
    
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    class GmtTimeZoneTest {
    
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
        void testInDaylightTimeWithInvalidDate() {
            GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 0);
            Date date = null;
    
            assertThrows(NullPointerException.class, () -> {
                gmtTimeZone.inDaylightTime(date);
            });
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
    public void testGetRawOffset_OutOfRangeHours_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 25, 0);
        });
    
        assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, -1, 0);
        });
    }
    
    @Test
    public void testGetRawOffset_OutOfRangeMinutes_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 0, 60);
        });
    
        assertThrows(IllegalArgumentException.class, () -> {
            new GmtTimeZone(false, 0, -1);
        });
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
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertThrows;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class GmtTimeZoneTest {
    
        private GmtTimeZone gmtTimeZone;
    
        @BeforeEach
        void setUp() {
            gmtTimeZone = new GmtTimeZone(false, 0, 0);
        }
    
        @Nested
        @DisplayName("toString method")
        class ToStringMethod {
    
            @Test
            @DisplayName("should return the expected string representation")
            void shouldReturnExpectedStringRepresentation() {
                String expected = "[GmtTimeZone id=\"+00:00\",offset=0]";
                String actual = gmtTimeZone.toString();
                assertEquals(expected, actual);
            }
    
            @Test
            @DisplayName("should handle negative offset")
            void shouldHandleNegativeOffset() {
                GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 1, 30);
                String expected = "[GmtTimeZone id=\"-01:30\",offset=-5400000]";
                String actual = gmtTimeZone.toString();
                assertEquals(expected, actual);
            }
        }
    
        @Nested
        @DisplayName("constructor")
        class Constructor {
    
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
        }
    }
    import org.junit.jupiter.api.Test;
    
    class GmtTimeZoneTest {
    
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
    }
    // Your Java code here
    
    @Test
    @DisplayName("Returns correct two-digit string for single-digit number")
    void testTwoDigitsSingleDigit() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, 5);
        Assertions.assertEquals("05", sb.toString());
    }
    
    @Test
    @DisplayName("Returns correct two-digit string for double-digit number")
    void testTwoDigitsDoubleDigit() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, 15);
        Assertions.assertEquals("15", sb.toString());
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
    
    @Test
    @DisplayName("Creates GmtTimeZone object with correct offset and zoneId when negate is false")
    void testGmtTimeZoneNegateFalse() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 2, 30);
        Assertions.assertEquals(9000000, gmtTimeZone.offset);
        Assertions.assertEquals("GMT+02:30", gmtTimeZone.zoneId);
    }
    
    @Test
    @DisplayName("Creates GmtTimeZone object with correct offset and zoneId when negate is true")
    void testGmtTimeZoneNegateTrue() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 5, 45);
        Assertions.assertEquals(-21300000, gmtTimeZone.offset);
        Assertions.assertEquals("GMT-05:45", gmtTimeZone.zoneId);
    }

}