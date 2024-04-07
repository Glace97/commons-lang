import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getDayOfMonthTest {

    private CalendarUtils calendarUtils;

    @BeforeEach
    void setUp() {
        calendarUtils = new CalendarUtils(new GregorianCalendar());
    }

    @Nested
    @DisplayName("When getting day of month")
    class GetDayOfMonth {

        @Test
        @DisplayName("Should return correct day of month when calendar is set to current date")
        void shouldBeCurrentDayOfMonth() {
            int expected = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int actual = calendarUtils.getDayOfMonth();
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should return correct day of month when calendar is set to a specific date")
        void shouldBeSpecificDayOfMonth() {
            Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1);
            calendarUtils = new CalendarUtils(calendar);
            int expected = 1;
            int actual = calendarUtils.getDayOfMonth();
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should return correct day of month when calendar is set to a different time zone")
        void shouldBeCorrectDayOfMonthWithDifferentTimeZone() {
            Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/New_York"));
            calendarUtils = new CalendarUtils(calendar);
            int expected = Calendar.getInstance(TimeZone.getTimeZone("America/New_York")).get(Calendar.DAY_OF_MONTH);
            int actual = calendarUtils.getDayOfMonth();
            assertEquals(expected, actual);
        }
    }
}