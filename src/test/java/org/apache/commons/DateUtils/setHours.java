import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setHoursTest {
    
    private DateUtils dateUtils;
    private Calendar calendar;
    
    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
        calendar = Calendar.getInstance();
    }
    
    @Test
    void testSetHours_validInput() {
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        Date result = dateUtils.setHours(calendar.getTime(), 8);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        assertEquals(calendar.getTime(), result);
    }
    
    @Test
    void testSetHours_lowerBound() {
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        Date result = dateUtils.setHours(calendar.getTime(), 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        assertEquals(calendar.getTime(), result);
    }
    
    @Test
    void testSetHours_upperBound() {
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        Date result = dateUtils.setHours(calendar.getTime(), 23);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        assertEquals(calendar.getTime(), result);
    }
    
    @Test
    void testSetHours_invalidInput() {
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.setHours(calendar.getTime(), -1);
        });
    }
}