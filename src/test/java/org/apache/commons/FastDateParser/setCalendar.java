import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.TimeZone;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class setCalendarTest {

    @Test
    void testSetCalendarWithValidValue() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        parser.setCalendar(parser, calendar, "2022-01-01");
        assertEquals(2022, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void testSetCalendarWithInvalidValue() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        parser.setCalendar(parser, calendar, "2022-13-01");
        assertEquals(2022, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void testSetCalendarWithEmptyValue() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        parser.setCalendar(parser, calendar, "");
        assertEquals(1970, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void testSetCalendarWithNullValue() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        parser.setCalendar(parser, calendar, null);
        assertEquals(1970, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }
}