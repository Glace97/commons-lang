import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class modifyTest {

    @Test
    void testModify() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());

        // Test for modifying year
        int modifiedYear = parser.modify(parser, 99);
        assertEquals(1999, modifiedYear);

        // Test for modifying month
        int modifiedMonth = parser.modify(parser, 5);
        assertEquals(4, modifiedMonth);

        // Test for modifying day of week
        int modifiedDayOfWeek = parser.modify(parser, 1);
        assertEquals(Calendar.SUNDAY, modifiedDayOfWeek);

        // Test for modifying hour of day
        int modifiedHourOfDay = parser.modify(parser, 24);
        assertEquals(0, modifiedHourOfDay);

        // Test for modifying hour
        int modifiedHour = parser.modify(parser, 12);
        assertEquals(0, modifiedHour);
    }
}