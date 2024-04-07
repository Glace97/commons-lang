import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DateUtilsTest {

    @Nested
    @DisplayName("Tests for truncatedCompareTo(Calendar, Calendar, int)")
    class TruncatedCompareToCalendarTest {
        
        private Calendar cal1;
        private Calendar cal2;
        
        @BeforeEach
        void setUp() {
            cal1 = Calendar.getInstance();
            cal2 = Calendar.getInstance();
        }
        
        @Test
        @DisplayName("Returns 0 when both calendars are equal up to the specified field")
        void testTruncatedCompareToEqualCalendars() {
            cal1.set(2022, Calendar.JANUARY, 1);
            cal2.set(2022, Calendar.JANUARY, 1);
            int result = DateUtils.truncatedCompareTo(cal1, cal2, Calendar.YEAR);
            assertEquals(0, result);
        }
        
        @Test
        @DisplayName("Returns negative value when first calendar is before the second calendar up to the specified field")
        void testTruncatedCompareToFirstBeforeSecondCalendars() {
            cal1.set(2021, Calendar.DECEMBER, 31);
            cal2.set(2022, Calendar.JANUARY, 1);
            int result = DateUtils.truncatedCompareTo(cal1, cal2, Calendar.YEAR);
            assertTrue(result < 0);
        }
        
        @Test
        @DisplayName("Returns positive value when first calendar is after the second calendar up to the specified field")
        void testTruncatedCompareToFirstAfterSecondCalendars() {
            cal1.set(2022, Calendar.JANUARY, 1);
            cal2.set(2021, Calendar.DECEMBER, 31);
            int result = DateUtils.truncatedCompareTo(cal1, cal2, Calendar.YEAR);
            assertTrue(result > 0);
        }
    }
    
    @Nested
    @DisplayName("Tests for truncatedCompareTo(Date, Date, int)")
    class TruncatedCompareToDateTest {
        
        private Date date1;
        private Date date2;
        
        @BeforeEach
        void setUp() {
            date1 = new Date();
            date2 = new Date();
        }
        
        @Test
        @DisplayName("Returns 0 when both dates are equal up to the specified field")
        void testTruncatedCompareToEqualDates() {
            date1.setTime(1640995200000L); // January 1, 2022
            date2.setTime(1640995200000L); // January 1, 2022
            int result = DateUtils.truncatedCompareTo(date1, date2, Calendar.YEAR);
            assertEquals(0, result);
        }
        
        @Test
        @DisplayName("Returns negative value when first date is before the second date up to the specified field")
        void testTruncatedCompareToFirstBeforeSecondDates() {
            date1.setTime(1640918800000L); // December 31, 2021
            date2.setTime(1640995200000L); // January 1, 2022
            int result = DateUtils.truncatedCompareTo(date1, date2, Calendar.YEAR);
            assertTrue(result < 0);
        }
        
        @Test
        @DisplayName("Returns positive value when first date is after the second date up to the specified field")
        void testTruncatedCompareToFirstAfterSecondDates() {
            date1.setTime(1640995200000L); // January 1, 2022
            date2.setTime(1640918800000L); // December 31, 2021
            int result = DateUtils.truncatedCompareTo(date1, date2, Calendar.YEAR);
            assertTrue(result > 0);
        }
    }
    
}