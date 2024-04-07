import static org.junit.jupiter.api.Assertions.*;

import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getTimeZoneTest {
    
    private FastTimeZone fastTimeZone;
    
    @BeforeEach
    void setUp() {
        fastTimeZone = new FastTimeZone();
    }
    
    @Test
    void testGetTimeZoneWithGMTCustomId() {
        TimeZone expected = TimeZone.getTimeZone("GMT+02:30");
        TimeZone actual = fastTimeZone.getTimeZone("GMT+02:30");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithZId() {
        TimeZone expected = TimeZone.getTimeZone("Z");
        TimeZone actual = fastTimeZone.getTimeZone("Z");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithUTCId() {
        TimeZone expected = TimeZone.getTimeZone("UTC");
        TimeZone actual = fastTimeZone.getTimeZone("UTC");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithOlsonId() {
        TimeZone expected = TimeZone.getTimeZone("America/New_York");
        TimeZone actual = fastTimeZone.getTimeZone("America/New_York");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithInvalidId() {
        TimeZone expected = TimeZone.getTimeZone("GMT"); // Default to GMT if invalid id
        TimeZone actual = fastTimeZone.getTimeZone("InvalidId");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithEmptyId() {
        TimeZone expected = TimeZone.getTimeZone("GMT"); // Default to GMT if empty id
        TimeZone actual = fastTimeZone.getTimeZone("");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithNullId() {
        TimeZone expected = TimeZone.getTimeZone("GMT"); // Default to GMT if null id
        TimeZone actual = fastTimeZone.getTimeZone(null);
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithPositiveOffset() {
        TimeZone expected = TimeZone.getTimeZone("GMT+05:00");
        TimeZone actual = fastTimeZone.getTimeZone("+05:00");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithNegativeOffset() {
        TimeZone expected = TimeZone.getTimeZone("GMT-03:30");
        TimeZone actual = fastTimeZone.getTimeZone("-03:30");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithNoMinutes() {
        TimeZone expected = TimeZone.getTimeZone("GMT+06:00");
        TimeZone actual = fastTimeZone.getTimeZone("+06");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithNoColon() {
        TimeZone expected = TimeZone.getTimeZone("GMT-02:00");
        TimeZone actual = fastTimeZone.getTimeZone("-0200");
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetTimeZoneWithInvalidOffset() {
        TimeZone expected = TimeZone.getTimeZone("GMT"); // Default to GMT if invalid offset
        TimeZone actual = fastTimeZone.getTimeZone("+24:00");
        assertEquals(expected, actual);
    }
}