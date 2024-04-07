import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setSecondsTest {
    
    @Test
    void testSetSeconds_validInput() {
        Date date = new Date();
        int amount = 30;
        Date result = DateUtils.setSeconds(date, amount);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        int seconds = calendar.get(Calendar.SECOND);
        assertEquals(amount, seconds);
    }
    
    @Test
    void testSetSeconds_lowerBoundary() {
        Date date = new Date();
        int amount = 0;
        Date result = DateUtils.setSeconds(date, amount);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        int seconds = calendar.get(Calendar.SECOND);
        assertEquals(amount, seconds);
    }
    
    @Test
    void testSetSeconds_upperBoundary() {
        Date date = new Date();
        int amount = 59;
        Date result = DateUtils.setSeconds(date, amount);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        int seconds = calendar.get(Calendar.SECOND);
        assertEquals(amount, seconds);
    }
    
    @Test
    void testSetSeconds_negativeInput() {
        Date date = new Date();
        int amount = -10;
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setSeconds(date, amount);
        });
    }
    
    @Test
    void testSetSeconds_greaterThanUpperBoundary() {
        Date date = new Date();
        int amount = 60;
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setSeconds(date, amount);
        });
    }
    
    @Test
    void testSetSeconds_nullDate() {
        int amount = 30;
        assertThrows(NullPointerException.class, () -> {
            DateUtils.setSeconds(null, amount);
        });
    }
}