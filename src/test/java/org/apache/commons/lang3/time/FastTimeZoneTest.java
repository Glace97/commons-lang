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

import java.util.TimeZone;

public class FastTimeZoneTest {

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
}