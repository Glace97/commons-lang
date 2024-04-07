import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getTest {
    
    @Test
    void testGetWithValidIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        int index = 2;
        Integer expected = 3;
        Integer result = ArrayUtils.get(array, index);
        assertEquals(expected, result);
    }
    
    @Test
    void testGetWithInvalidIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        int index = 10;
        Integer defaultValue = 0;
        Integer result = ArrayUtils.get(array, index, defaultValue);
        assertEquals(defaultValue, result);
    }
    
    @Test
    void testGetWithNullArray() {
        Integer[] array = null;
        int index = 2;
        Integer defaultValue = 0;
        Integer result = ArrayUtils.get(array, index, defaultValue);
        assertEquals(defaultValue, result);
    }
    
    @Test
    void testGetWithEmptyArray() {
        Integer[] array = {};
        int index = 2;
        Integer defaultValue = 0;
        Integer result = ArrayUtils.get(array, index, defaultValue);
        assertEquals(defaultValue, result);
    }
    
    @Test
    void testGetWithEmptyStringArray() {
        String[] array = {};
        int index = 0;
        String defaultValue = "";
        String result = ArrayUtils.get(array, index, defaultValue);
        assertEquals(defaultValue, result);
    }
}