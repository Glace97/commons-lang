
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RoundTest {

    private Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.MARCH, 15, 13, 45, 1);
    }

    @Nested
    @DisplayName("Tests for round(Calendar, int)")
    class RoundCalendarTest {

        @Test
        void shouldRoundToHour() {
            Calendar expected = Calendar.getInstance();
            expected.set(2022, Calendar.MARCH, 15, 14, 0, 0);
            
            Calendar result = DateUtils.round(calendar, Calendar.HOUR_OF_DAY);
            
            assertEquals(expected, result);
        }

        @Test
        void shouldRoundToMonth() {
            Calendar expected = Calendar.getInstance();
            expected.set(2022, Calendar.APRIL, 1, 0, 0, 0);
            
            Calendar result = DateUtils.round(calendar, Calendar.MONTH);
            
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Tests for round(Date, int)")
    class RoundDateTest {

        @Test
        void shouldRoundToHour() {
            Date expected = calendar.getTime();
            expected.setHours(14);
            expected.setMinutes(0);
            expected.setSeconds(0);
            
            Date result = DateUtils.round(calendar.getTime(), Calendar.HOUR_OF_DAY);
            
            assertEquals(expected, result);
        }

        @Test
        void shouldRoundToMonth() {
            Date expected = calendar.getTime();
            expected.setDate(1);
            expected.setHours(0);
            expected.setMinutes(0);
            expected.setSeconds(0);
            
            Date result = DateUtils.round(calendar.getTime(), Calendar.MONTH);
            
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Tests for round(Object, int)")
    class RoundObjectTest {

        @Test
        void shouldRoundToHourWithCalendar() {
            Calendar expected = Calendar.getInstance();
            expected.set(2022, Calendar.MARCH, 15, 14, 0, 0);
            
            Calendar result = DateUtils.round(calendar, Calendar.HOUR_OF_DAY);
            
            assertEquals(expected, result);
        }

        @Test
        void shouldRoundToMonthWithDate() {
            Date expected = calendar.getTime();
            expected.setDate(1);
            expected.setHours(0);
            expected.setMinutes(0);
            expected.setSeconds(0);
            
            Date result = DateUtils.round(calendar.getTime(), Calendar.MONTH);
            
            assertEquals(expected, result);
        }
    }

}
