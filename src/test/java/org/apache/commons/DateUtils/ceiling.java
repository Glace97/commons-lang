import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Calendar;

class CeilingTest {
    
    @Test
    void testCeilingWithSecondField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 30);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.SECOND, 31);
        
        Calendar result = DateUtils.ceiling(calendar, Calendar.SECOND);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testCeilingWithMinuteField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 30);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.MINUTE, 31);
        expected.set(Calendar.SECOND, 0);
        
        Calendar result = DateUtils.ceiling(calendar, Calendar.MINUTE);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testCeilingWithHourField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.HOUR_OF_DAY, 13);
        expected.set(Calendar.MINUTE, 0);
        expected.set(Calendar.SECOND, 0);
        
        Calendar result = DateUtils.ceiling(calendar, Calendar.HOUR_OF_DAY);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testCeilingWithDateField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 15);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.DATE, 16);
        expected.set(Calendar.HOUR_OF_DAY, 0);
        expected.set(Calendar.MINUTE, 0);
        expected.set(Calendar.SECOND, 0);
        
        Calendar result = DateUtils.ceiling(calendar, Calendar.DATE);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testCeilingWithMonthField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 5);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.MONTH, 6);
        expected.set(Calendar.DATE, 1);
        expected.set(Calendar.HOUR_OF_DAY, 0);
        expected.set(Calendar.MINUTE, 0);
        expected.set(Calendar.SECOND, 0);
        
        Calendar result = DateUtils.ceiling(calendar, Calendar.MONTH);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testCeilingWithYearField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2021);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.YEAR, 2022);
        expected.set(Calendar.MONTH, 0);
        expected.set(Calendar.DATE, 1);
        expected.set(Calendar.HOUR_OF_DAY, 0);
        expected.set(Calendar.MINUTE, 0);
        expected.set(Calendar.SECOND, 0);
        
        Calendar result = DateUtils.ceiling(calendar, Calendar.YEAR);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testCeilingWithSemiMonthField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.DATE, 15);
        Calendar expected = Calendar.getInstance();
        expected.set(Calendar.MONTH, 5);
        expected.set(Calendar.DATE, 16);
        expected.set(Calendar.HOUR_OF_DAY, 0);
        expected.set(Calendar.MINUTE, 0);
        expected.set(Calendar.SECOND, 0);
        
        Calendar result = DateUtils.ceiling(calendar, DateUtils.SEMI_MONTH);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testCeilingWithInvalidField() {
        Calendar calendar = Calendar.getInstance();
        
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.ceiling(calendar, Calendar.DAY_OF_WEEK);
        });
    }
    
    @Test
    void testCeilingWithNullCalendar() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.ceiling(null, Calendar.MONTH);
        });
    }
    
    @Test
    void testCeilingWithNullDate() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.ceiling(null, Calendar.YEAR);
        });
    }
    
    @Test
    void testCeilingWithInvalidType() {
        Object obj = new Object();
        
        assertThrows(ClassCastException.class, () -> {
            DateUtils.ceiling(obj, Calendar.MONTH);
        });
    }
    
}
