import org.junit.jupiter.api.*;
import java.util.Calendar;
import java.util.Date;

class setMinutesTest {
    
    @Test
    void testSetMinutes_ValidInput_ReturnsNewDateWithSpecifiedMinutes() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 30);
        Date date = calendar.getTime();
        int minutes = 45;
        
        // Act
        Date newDate = DateUtils.setMinutes(date, minutes);
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(newDate);
        int newMinutes = newCalendar.get(Calendar.MINUTE);
        
        // Assert
        Assertions.assertEquals(minutes, newMinutes);
    }
    
    @Test
    void testSetMinutes_InvalidInput_ThrowsIllegalArgumentException() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 30);
        Date date = calendar.getTime();
        int minutes = 70;
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setMinutes(date, minutes);
        });
    }
    
    @Test
    void testSetMinutes_NullDate_ThrowsNullPointerException() {
        // Arrange
        Date date = null;
        int minutes = 45;
        
        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            DateUtils.setMinutes(date, minutes);
        });
    }
    
    @Test
    void testSetMinutes_EdgeCase_MinimumValue_ReturnsNewDateWithMinimumMinutes() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 30);
        Date date = calendar.getTime();
        int minutes = 0;
        
        // Act
        Date newDate = DateUtils.setMinutes(date, minutes);
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(newDate);
        int newMinutes = newCalendar.get(Calendar.MINUTE);
        
        // Assert
        Assertions.assertEquals(minutes, newMinutes);
    }
    
    @Test
    void testSetMinutes_EdgeCase_MaximumValue_ReturnsNewDateWithMaximumMinutes() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 30);
        Date date = calendar.getTime();
        int minutes = 59;
        
        // Act
        Date newDate = DateUtils.setMinutes(date, minutes);
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(newDate);
        int newMinutes = newCalendar.get(Calendar.MINUTE);
        
        // Assert
        Assertions.assertEquals(minutes, newMinutes);
    }
    
    @Test
    void testSetMinutes_EdgeCase_NegativeValue_ThrowsIllegalArgumentException() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 30);
        Date date = calendar.getTime();
        int minutes = -10;
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.setMinutes(date, minutes);
        });
    }
}