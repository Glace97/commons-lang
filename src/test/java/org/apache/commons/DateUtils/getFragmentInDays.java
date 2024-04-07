import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getFragmentInDaysTest {
    
    @Test
    void testGetFragmentInDays_CalendarFragment_Year() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.YEAR);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_CalendarFragment_Month() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.MONTH);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_CalendarFragment_DayOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.DAY_OF_YEAR);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_CalendarFragment_DayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.DAY_OF_MONTH);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_CalendarFragment_HourOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.HOUR_OF_DAY);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_CalendarFragment_Minute() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.MINUTE);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_CalendarFragment_Second() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0, 0);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.SECOND);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_CalendarFragment_Millisecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0, 0);
        long fragment = DateUtils.getFragmentInDays(calendar, Calendar.MILLISECOND);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_Year() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.YEAR);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_Month() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.MONTH);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_DayOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.DAY_OF_YEAR);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_DayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.DAY_OF_MONTH);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_HourOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.HOUR_OF_DAY);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_Minute() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.MINUTE);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_Second() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0, 0);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.SECOND);
        assertEquals(0, fragment);
    }
    
    @Test
    void testGetFragmentInDays_DateFragment_Millisecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0, 0);
        Date date = calendar.getTime();
        long fragment = DateUtils.getFragmentInDays(date, Calendar.MILLISECOND);
        assertEquals(0, fragment);
    }
    
}