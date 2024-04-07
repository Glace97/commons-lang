import org.junit.jupiter.api.*;
import java.util.*;

class setMillisecondsTest {

    @Test
    void testSetMilliseconds() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        
        // Test with valid amount
        Date newDate = DateUtils.setMilliseconds(date, 500);
        calendar.setTime(newDate);
        Assertions.assertEquals(500, calendar.get(Calendar.MILLISECOND));
        
        // Test with amount less than 0
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setMilliseconds(date, -100);
        });
        
        // Test with amount greater than 999
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setMilliseconds(date, 1000);
        });
        
        // Test with null date
        Assertions.assertThrows(NullPointerException.class, () -> {
            DateUtils.setMilliseconds(null, 500);
        });
    }
}