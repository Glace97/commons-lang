import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class isSameInstantTest {

    private Calendar cal1;
    private Calendar cal2;
    private Date date1;
    private Date date2;

    @BeforeEach
    void setUp() {
        cal1 = Calendar.getInstance();
        cal2 = Calendar.getInstance();
        date1 = new Date();
        date2 = new Date();
    }

    @Nested
    @DisplayName("Testing isSameInstant(Calendar, Calendar)")
    class CalendarTests {

        @Test
        @DisplayName("When two calendars represent the same instant, should return true")
        void whenCalendarsAreSameInstant_shouldReturnTrue() {
            assertTrue(DateUtils.isSameInstant(cal1, cal2));
        }

        @Test
        @DisplayName("When two calendars represent different instants, should return false")
        void whenCalendarsAreDifferentInstant_shouldReturnFalse() {
            cal2.add(Calendar.HOUR, 1);
            assertFalse(DateUtils.isSameInstant(cal1, cal2));
        }

        @Test
        @DisplayName("When the first calendar is null, should throw NullPointerException")
        void whenFirstCalendarIsNull_shouldThrowNullPointerException() {
            cal1 = null;
            assertTrue(assertThrows(NullPointerException.class, () -> DateUtils.isSameInstant(cal1, cal2)).getMessage().contains("cal1"));
        }

        @Test
        @DisplayName("When the second calendar is null, should throw NullPointerException")
        void whenSecondCalendarIsNull_shouldThrowNullPointerException() {
            cal2 = null;
            assertTrue(assertThrows(NullPointerException.class, () -> DateUtils.isSameInstant(cal1, cal2)).getMessage().contains("cal2"));
        }
    }

    @Nested
    @DisplayName("Testing isSameInstant(Date, Date)")
    class DateTests {

        @Test
        @DisplayName("When two dates represent the same instant, should return true")
        void whenDatesAreSameInstant_shouldReturnTrue() {
            assertTrue(DateUtils.isSameInstant(date1, date2));
        }

        @Test
        @DisplayName("When two dates represent different instants, should return false")
        void whenDatesAreDifferentInstant_shouldReturnFalse() {
            date2.setTime(date1.getTime() + 1000);
            assertFalse(DateUtils.isSameInstant(date1, date2));
        }

        @Test
        @DisplayName("When the first date is null, should throw NullPointerException")
        void whenFirstDateIsNull_shouldThrowNullPointerException() {
            date1 = null;
            assertTrue(assertThrows(NullPointerException.class, () -> DateUtils.isSameInstant(date1, date2)).getMessage().contains("date1"));
        }

        @Test
        @DisplayName("When the second date is null, should throw NullPointerException")
        void whenSecondDateIsNull_shouldThrowNullPointerException() {
            date2 = null;
            assertTrue(assertThrows(NullPointerException.class, () -> DateUtils.isSameInstant(date1, date2)).getMessage().contains("date2"));
        }
    }
}