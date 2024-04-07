import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

class addMillisecondsTest {

    @Test
    void testAddMilliseconds_PositiveAmount() {
        // Arrange
        Date initialDate = new Date();
        int amount = 1000;
        Date expectedDate = new Date(initialDate.getTime() + amount);

        // Act
        Date result = DateUtils.addMilliseconds(initialDate, amount);

        // Assert
        assertEquals(expectedDate, result);
    }

    @Test
    void testAddMilliseconds_NegativeAmount() {
        // Arrange
        Date initialDate = new Date();
        int amount = -1000;
        Date expectedDate = new Date(initialDate.getTime() + amount);

        // Act
        Date result = DateUtils.addMilliseconds(initialDate, amount);

        // Assert
        assertEquals(expectedDate, result);
    }

    @Test
    void testAddMilliseconds_ZeroAmount() {
        // Arrange
        Date initialDate = new Date();
        int amount = 0;

        // Act
        Date result = DateUtils.addMilliseconds(initialDate, amount);

        // Assert
        assertEquals(initialDate, result);
    }
    
    @Test
    void testAddMilliseconds_MaxValue() {
        // Arrange
        Date initialDate = new Date(Long.MAX_VALUE);
        int amount = 1000;
        Date expectedDate = new Date(Long.MAX_VALUE); // Adding millisecond will not change the date

        // Act
        Date result = DateUtils.addMilliseconds(initialDate, amount);

        // Assert
        assertEquals(expectedDate, result);
    }
    
    @Test
    void testAddMilliseconds_MinValue() {
        // Arrange
        Date initialDate = new Date(Long.MIN_VALUE);
        int amount = -1000;
        Date expectedDate = new Date(Long.MIN_VALUE); // Subtracting millisecond will not change the date

        // Act
        Date result = DateUtils.addMilliseconds(initialDate, amount);

        // Assert
        assertEquals(expectedDate, result);
    }
}