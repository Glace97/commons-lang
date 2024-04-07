import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class modeTest {
    
    @Test
    void testModeWithEmptyArray() {
        // Arrange
        Integer[] items = {};
        
        // Act
        Integer result = ObjectUtils.mode(items);
        
        // Assert
        Assertions.assertNull(result);
    }
    
    @Test
    void testModeWithNonUniqueItems() {
        // Arrange
        Integer[] items = {1, 2, 2, 3, 3, 3};
        
        // Act
        Integer result = ObjectUtils.mode(items);
        
        // Assert
        Assertions.assertNull(result);
    }
    
    @Test
    void testModeWithUniqueItems() {
        // Arrange
        Integer[] items = {1, 2, 3, 4, 5};
        
        // Act
        Integer result = ObjectUtils.mode(items);
        
        // Assert
        Assertions.assertEquals(1, result);
    }
    
    @Test
    void testModeWithNullItems() {
        // Arrange
        Integer[] items = {null, null, null};
        
        // Act
        Integer result = ObjectUtils.mode(items);
        
        // Assert
        Assertions.assertNull(result);
    }
    
    @Test
    void testModeWithStringItems() {
        // Arrange
        String[] items = {"apple", "banana", "banana", "cherry", "cherry", "cherry"};
        
        // Act
        String result = ObjectUtils.mode(items);
        
        // Assert
        Assertions.assertEquals("cherry", result);
    }
}