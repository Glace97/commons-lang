import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.TimeZone;

class getTimeZoneTest {

    private Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = Calendar.getInstance();
    }

    @Test
    void testGetTimeZoneNotNull() {
        TimeZone timeZone = DateFormatUtils.getTimeZone(calendar);
        assertNotNull(timeZone);
    }

    @Test
    void testGetTimeZoneSameAsCalendar() {
        TimeZone timeZone = DateFormatUtils.getTimeZone(calendar);
        assertEquals(calendar.getTimeZone(), timeZone);
    }

    @Test
    void testGetTimeZoneNullCalendar() {
        TimeZone timeZone = DateFormatUtils.getTimeZone(null);
        assertNull(timeZone);
    }
}