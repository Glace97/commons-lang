
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class getDayOfYearTest {
    private CalendarUtils calendarUtils;
    private Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        calendarUtils = new CalendarUtils(calendar, Locale.getDefault());
    }

    @Test
    void testGetDayOfYear() {
        assertEquals(1, calendarUtils.getDayOfYear());
    }

    @Test
    void testGetDayOfYearAfterLeapYear() {
        calendar.set(2024, Calendar.JANUARY, 1);
        assertEquals(1, calendarUtils.getDayOfYear());
    }

    @Test
    void testGetDayOfYearOnLastDayOfYear() {
        calendar.set(2022, Calendar.DECEMBER, 31);
        assertEquals(365, calendarUtils.getDayOfYear());
    }

    @Test
    void testGetDayOfYearOnLeapYear() {
        calendar.set(2024, Calendar.FEBRUARY, 28);
        assertEquals(59, calendarUtils.getDayOfYear());
    }

    @Test
    void testGetDayOfYearOnLeapYearAfterFebruary29() {
        calendar.set(2024, Calendar.MARCH, 1);
        assertEquals(61, calendarUtils.getDayOfYear());
    }

    @Test
    void testGetDayOfYearOnNonLeapYear() {
        calendar.set(2023, Calendar.MARCH, 1);
        assertEquals(60, calendarUtils.getDayOfYear());
    }
}
