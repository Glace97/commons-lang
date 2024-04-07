import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toLongTest {
    
    @Test
    void testToLongWithNullString() {
        String str = null;
        long result = NumberUtils.toLong(str);
        assertEquals(0L, result);
    }
    
    @Test
    void testToLongWithEmptyString() {
        String str = "";
        long result = NumberUtils.toLong(str);
        assertEquals(0L, result);
    }
    
    @Test
    void testToLongWithValidString() {
        String str = "1";
        long result = NumberUtils.toLong(str);
        assertEquals(1L, result);
    }
    
    @Test
    void testToLongWithInvalidString() {
        String str = "abc";
        long defaultValue = 0L;
        long result = NumberUtils.toLong(str, defaultValue);
        assertEquals(defaultValue, result);
    }
    
    @Test
    void testToLongWithDefaultValue() {
        String str = null;
        long defaultValue = 1L;
        long result = NumberUtils.toLong(str, defaultValue);
        assertEquals(defaultValue, result);
    }
    
    @Test
    void testToLongWithMaxValue() {
        String str = String.valueOf(Long.MAX_VALUE);
        long result = NumberUtils.toLong(str);
        assertEquals(Long.MAX_VALUE, result);
    }
    
    @Test
    void testToLongWithMinValue() {
        String str = String.valueOf(Long.MIN_VALUE);
        long result = NumberUtils.toLong(str);
        assertEquals(Long.MIN_VALUE, result);
    }
    
    @Test
    void testToLongWithNegativeMaxValue() {
        String str = String.valueOf(Long.MAX_VALUE * -1);
        long result = NumberUtils.toLong(str);
        assertEquals(Long.MAX_VALUE * -1, result);
    }
    
    @Test
    void testToLongWithNegativeMinValue() {
        String str = String.valueOf(Long.MIN_VALUE * -1);
        long result = NumberUtils.toLong(str);
        assertEquals(Long.MIN_VALUE * -1, result);
    }
    
    @Test
    void testToLongWithZero() {
        String str = "0";
        long result = NumberUtils.toLong(str);
        assertEquals(0L, result);
    }
}