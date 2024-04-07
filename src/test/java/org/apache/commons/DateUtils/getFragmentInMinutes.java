import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getFragmentInMinutesTest {

    private DateUtils dateUtils;
    private Calendar calendar;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
        calendar = Calendar.getInstance();
    }

    @Nested
    @DisplayName("Tests for getFragmentInMinutes(Calendar calendar, int fragment)")
    class GetFragmentInMinutesWithCalendar {

        @Test
        @DisplayName("When fragment is Calendar.YEAR, should return 0")
        void getFragmentInMinutesWithCalendar_Year_ReturnsZero() {
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MINUTE, 30);

            long result = dateUtils.getFragmentInMinutes(calendar, Calendar.YEAR);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.MONTH, should return minutes of the past day(s) and hour(s)")
        void getFragmentInMinutesWithCalendar_Month_ReturnsMinutesOfPastDaysAndHours() {
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 30);

            long result = dateUtils.getFragmentInMinutes(calendar, Calendar.MONTH);

            assertEquals(435, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.DATE, should return minutes of the past hour(s)")
        void getFragmentInMinutesWithCalendar_Date_ReturnsMinutesOfPastHours() {
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 30);

            long result = dateUtils.getFragmentInMinutes(calendar, Calendar.DATE);

            assertEquals(30, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.HOUR_OF_DAY, should return minutes of the current hour")
        void getFragmentInMinutesWithCalendar_HourOfDay_ReturnsMinutesOfCurrentHour() {
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 30);

            long result = dateUtils.getFragmentInMinutes(calendar, Calendar.HOUR_OF_DAY);

            assertEquals(30, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.MINUTE, should return minutes of the current hour")
        void getFragmentInMinutesWithCalendar_Minute_ReturnsMinutesOfCurrentHour() {
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 30);

            long result = dateUtils.getFragmentInMinutes(calendar, Calendar.MINUTE);

            assertEquals(30, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.SECOND, should return 0")
        void getFragmentInMinutesWithCalendar_Second_ReturnsZero() {
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.SECOND, 45);

            long result = dateUtils.getFragmentInMinutes(calendar, Calendar.SECOND);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.MILLISECOND, should return 0")
        void getFragmentInMinutesWithCalendar_Millisecond_ReturnsZero() {
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.MILLISECOND, 500);

            long result = dateUtils.getFragmentInMinutes(calendar, Calendar.MILLISECOND);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("When calendar is null, should throw NullPointerException")
        void getFragmentInMinutesWithCalendar_NullCalendar_ThrowsNullPointerException() {
            assertThrows(NullPointerException.class, () -> {
                dateUtils.getFragmentInMinutes(null, Calendar.HOUR_OF_DAY);
            });
        }

        @Test
        @DisplayName("When fragment is not supported, should throw IllegalArgumentException")
        void getFragmentInMinutesWithCalendar_InvalidFragment_ThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> {
                dateUtils.getFragmentInMinutes(calendar, Calendar.DAY_OF_WEEK);
            });
        }
    }

    @Nested
    @DisplayName("Tests for getFragmentInMinutes(Date date, int fragment)")
    class GetFragmentInMinutesWithDate {

        @Test
        @DisplayName("When fragment is Calendar.YEAR, should return 0")
        void getFragmentInMinutesWithDate_Year_ReturnsZero() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            long result = dateUtils.getFragmentInMinutes(date, Calendar.YEAR);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.MONTH, should return minutes of the past day(s) and hour(s)")
        void getFragmentInMinutesWithDate_Month_ReturnsMinutesOfPastDaysAndHours() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            long result = dateUtils.getFragmentInMinutes(date, Calendar.MONTH);

            assertEquals(30, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.DATE, should return minutes of the past hour(s)")
        void getFragmentInMinutesWithDate_Date_ReturnsMinutesOfPastHours() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            long result = dateUtils.getFragmentInMinutes(date, Calendar.DATE);

            assertEquals(30, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.HOUR_OF_DAY, should return minutes of the current hour")
        void getFragmentInMinutesWithDate_HourOfDay_ReturnsMinutesOfCurrentHour() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            long result = dateUtils.getFragmentInMinutes(date, Calendar.HOUR_OF_DAY);

            assertEquals(30, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.MINUTE, should return minutes of the current hour")
        void getFragmentInMinutesWithDate_Minute_ReturnsMinutesOfCurrentHour() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            long result = dateUtils.getFragmentInMinutes(date, Calendar.MINUTE);

            assertEquals(30, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.SECOND, should return 0")
        void getFragmentInMinutesWithDate_Second_ReturnsZero() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            long result = dateUtils.getFragmentInMinutes(date, Calendar.SECOND);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("When fragment is Calendar.MILLISECOND, should return 0")
        void getFragmentInMinutesWithDate_Millisecond_ReturnsZero() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            long result = dateUtils.getFragmentInMinutes(date, Calendar.MILLISECOND);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("When date is null, should throw NullPointerException")
        void getFragmentInMinutesWithDate_NullDate_ThrowsNullPointerException() {
            assertThrows(NullPointerException.class, () -> {
                dateUtils.getFragmentInMinutes(null, Calendar.HOUR_OF_DAY);
            });
        }

        @Test
        @DisplayName("When fragment is not supported, should throw IllegalArgumentException")
        void getFragmentInMinutesWithDate_InvalidFragment_ThrowsIllegalArgumentException() {
            Date date = mock(Date.class);
            when(date.getMinutes()).thenReturn(30);

            assertThrows(IllegalArgumentException.class, () -> {
                dateUtils.getFragmentInMinutes(date, Calendar.DAY_OF_WEEK);
            });
        }
    }
}