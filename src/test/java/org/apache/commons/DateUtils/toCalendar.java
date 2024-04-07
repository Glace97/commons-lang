import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toCalendarTest {

    @Test
    void testToCalendar() {
        // Test with a valid date
        Date date1 = new Date(1220227200000L); // 2021-08-31
        Calendar calendar1 = DateUtils.toCalendar(date1);
        assertEquals(date1, calendar1.getTime());

        // Test with a null date
        assertThrows(NullPointerException.class, () -> DateUtils.toCalendar(null));

        // Test with a valid date and time zone
        Date date2 = new Date(1220227200000L); // 2021-08-31
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Calendar calendar2 = DateUtils.toCalendar(date2, timeZone);
        assertEquals(date2, calendar2.getTime());
        assertEquals(timeZone, calendar2.getTimeZone());

        // Test with a null date and time zone
        assertThrows(NullPointerException.class, () -> DateUtils.toCalendar(null, timeZone));
        assertThrows(NullPointerException.class, () -> DateUtils.toCalendar(date2, null));
    }
}