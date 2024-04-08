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

public class FastTimeZoneTest {
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    
    class FastTimeZoneTestSuite {
    
        @Test
        @DisplayName("Should return 0 when group is null")
        void shouldReturnZeroWhenGroupIsNull() {
            int result = FastTimeZone.parseInt(null);
            assertEquals(0, result);
        }
    
        @Test
        @DisplayName("Should return the correct integer value when group is a valid number string")
        void shouldReturnCorrectIntegerValueForValidNumberString() {
            int result = FastTimeZone.parseInt("10");
            assertEquals(10, result);
        }
    
        @Test
        @DisplayName("Should return 0 when group is an invalid number string")
        void shouldReturnZeroForInvalidNumberString() {
            int result = FastTimeZone.parseInt("a");
            assertEquals(0, result);
        }
    }
    // Your Java code here
    
    @Test
    @DisplayName("Returns a valid TimeZone object for a valid GMT custom id")
    void testGetTimeZoneWithValidGmtCustomId() {
        String id = "GMT+02:30";
        TimeZone timeZone = FastTimeZone.getTimeZone(id);
        assertNotNull(timeZone);
        assertEquals("GMT+02:30", timeZone.getID());
    }
    
    @Test
    @DisplayName("Returns a valid TimeZone object for a valid Olson id")
    void testGetTimeZoneWithValidOlsonId() {
        String id = "America/New_York";
        TimeZone timeZone = FastTimeZone.getTimeZone(id);
        assertNotNull(timeZone);
        assertEquals("America/New_York", timeZone.getID());
    }
    
    @Test
    @DisplayName("Returns GMT TimeZone object for 'Z' id")
    void testGetTimeZoneWithZId() {
        String id = "Z";
        TimeZone timeZone = FastTimeZone.getTimeZone(id);
        assertNotNull(timeZone);
        assertEquals("GMT", timeZone.getID());
    }
    
    @Test
    @DisplayName("Returns GMT TimeZone object for 'UTC' id")
    void testGetTimeZoneWithUTCId() {
        String id = "UTC";
        TimeZone timeZone = FastTimeZone.getTimeZone(id);
        assertNotNull(timeZone);
        assertEquals("GMT", timeZone.getID());
    }
    
    @Test
    @DisplayName("Returns null for an invalid id")
    void testGetTimeZoneWithInvalidId() {
        String id = "InvalidTimeZoneId";
        TimeZone timeZone = FastTimeZone.getTimeZone(id);
        assertEquals(null, timeZone);
    }
    // Filtered code:
    
    @Test
    void getGmtTimeZone_shouldReturnGreenwichTimeZone() {
        TimeZone timeZone = FastTimeZone.getGmtTimeZone();
        assertEquals(TimeZone.getTimeZone("GMT+00:00"), timeZone);
    }
    @Test
    void testParseSignWithNullGroup() {
        boolean result = FastTimeZone.parseSign(null);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testParseSignWithEmptyGroup() {
        boolean result = FastTimeZone.parseSign("");
        Assertions.assertFalse(result);
    }
    
    @Test
    void testParseSignWithNoSign() {
        boolean result = FastTimeZone.parseSign("0");
        Assertions.assertFalse(result);
    }
    
    @Test
    void testParseSignWithPositiveSign() {
        boolean result = FastTimeZone.parseSign("+1");
        Assertions.assertFalse(result);
    }
    
    @Test
    void testParseSignWithNegativeSign() {
        boolean result = FastTimeZone.parseSign("-1");
        Assertions.assertTrue(result);
    }
    
    @Test
    void testParseSignWithInvalidSign() {
        boolean result = FastTimeZone.parseSign("invalid");
        Assertions.assertFalse(result);
    }

}