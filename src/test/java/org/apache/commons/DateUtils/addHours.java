import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class addHoursTest {

    @Test
    void testAddHours_positiveAmount() {
        // Arrange
        DateUtils dateUtils = new DateUtils();
        Date date = new Date();
        int amount = 2;

        // Act
        Date result = dateUtils.addHours(date, amount);

        // Assert
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        assertEquals(calendar.get(Calendar.HOUR_OF_DAY), (calendar.get(Calendar.HOUR_OF_DAY) + amount) % 24);
    }

    @Test
    void testAddHours_negativeAmount() {
        // Arrange
        DateUtils dateUtils = new DateUtils();
        Date date = new Date();
        int amount = -2;

        // Act
        Date result = dateUtils.addHours(date, amount);

        // Assert
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        assertEquals(calendar.get(Calendar.HOUR_OF_DAY), (calendar.get(Calendar.HOUR_OF_DAY) + amount + 24) % 24);
    }

    @Test
    void testAddHours_zeroAmount() {
        // Arrange
        DateUtils dateUtils = new DateUtils();
        Date date = new Date();
        int amount = 0;

        // Act
        Date result = dateUtils.addHours(date, amount);

        // Assert
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        assertEquals(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.HOUR_OF_DAY));
    }

    @Test
    void testAddHours_nullDate() {
        // Arrange
        DateUtils dateUtils = new DateUtils();
        Date date = null;
        int amount = 2;

        // Act and Assert
        assertThrows(NullPointerException.class, () -> {
            dateUtils.addHours(date, amount);
        });
    }
    
    @Test
    void testAddHours_endBoundary() {
        // Arrange
        DateUtils dateUtils = new DateUtils();
        Date date = new Date(Long.MAX_VALUE);
        int amount = 2;

        // Act
        Date result = dateUtils.addHours(date, amount);

        // Assert
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        assertEquals(calendar.get(Calendar.HOUR_OF_DAY), (calendar.get(Calendar.HOUR_OF_DAY) + amount) % 24);
    }
    
    @Test
    void testAddHours_startBoundary() {
        // Arrange
        DateUtils dateUtils = new DateUtils();
        Date date = new Date(Long.MIN_VALUE);
        int amount = 2;
        
        // Act
        Date result = dateUtils.addHours(date, amount);
        
        // Assert
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
        assertEquals(calendar.get(Calendar.HOUR_OF_DAY), (calendar.get(Calendar.HOUR_OF_DAY) + amount) % 24);
    }
}