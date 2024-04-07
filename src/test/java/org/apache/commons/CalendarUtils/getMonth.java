import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getMonthTest {

    private CalendarUtils calendarUtils;

    @BeforeEach
    void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendarUtils = new CalendarUtils(calendar);
    }

    @Nested
    @DisplayName("Test getMonth method")
    class GetMonth {

        @Test
        @DisplayName("Should return the current month")
        void shouldReturnCurrentMonth() {
            Calendar mockCalendar = mock(Calendar.class);
            when(mockCalendar.get(Calendar.MONTH)).thenReturn(Calendar.JANUARY);
            CalendarUtils mockCalendarUtils = new CalendarUtils(mockCalendar);

            int expectedMonth = Calendar.JANUARY;
            int actualMonth = mockCalendarUtils.getMonth();

            assertEquals(expectedMonth, actualMonth);
        }
    }
}