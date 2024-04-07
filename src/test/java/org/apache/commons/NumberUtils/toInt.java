import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toIntTest {
    
    @Test
    void testToInt_NullString_ReturnsDefault() {
        int result = NumberUtils.toInt(null, 5);
        assertEquals(5, result);
    }
    
    @Test
    void testToInt_EmptyString_ReturnsDefault() {
        int result = NumberUtils.toInt("", 10);
        assertEquals(10, result);
    }
    
    @Test
    void testToInt_ValidString_ReturnsIntValue() {
        int result = NumberUtils.toInt("15");
        assertEquals(15, result);
    }
    
    @Test
    void testToInt_InvalidString_ReturnsDefault() {
        int result = NumberUtils.toInt("abc", 20);
        assertEquals(20, result);
    }
    
    @Test
    void testToInt_LargeNumber_ReturnsIntValue() {
        int result = NumberUtils.toInt("1000000000");
        assertEquals(1000000000, result);
    }
    
    @Test
    void testToInt_NegativeNumber_ReturnsIntValue() {
        int result = NumberUtils.toInt("-10");
        assertEquals(-10, result);
    }
    
    @Test
    void testToInt_MaxValue_ReturnsMaxIntValue() {
        int result = NumberUtils.toInt(String.valueOf(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, result);
    }
    
    @Test
    void testToInt_MinValue_ReturnsMinIntValue() {
        int result = NumberUtils.toInt(String.valueOf(Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE, result);
    }
    
    @Test
    void testToInt_WhitespaceString_ReturnsDefault() {
        int result = NumberUtils.toInt("   ", 30);
        assertEquals(30, result);
    }
    
    @Test
    void testToInt_LeadingZeros_ReturnsIntValue() {
        int result = NumberUtils.toInt("0000123");
        assertEquals(123, result);
    }
}