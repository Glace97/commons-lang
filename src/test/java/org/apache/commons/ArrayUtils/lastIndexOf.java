import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class lastIndexOfTest {
    
    private ArrayUtils arrayUtils;
    
    @BeforeEach
    public void setUp() {
        arrayUtils = new ArrayUtils();
    }
    
    @Test
    public void testLastIndexOf_booleanArray_valueFound() {
        boolean[] array = {true, false, true, false};
        boolean valueToFind = true;
        int expectedIndex = 2;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_booleanArray_valueNotFound() {
        boolean[] array = {true, false, true, false};
        boolean valueToFind = false;
        int expectedIndex = 3;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_booleanArray_nullArray() {
        boolean[] array = null;
        boolean valueToFind = true;
        int expectedIndex = -1;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_booleanArray_emptyArray() {
        boolean[] array = {};
        boolean valueToFind = true;
        int expectedIndex = -1;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_booleanArray_startIndexOutOfRange() {
        boolean[] array = {true, false, true, false};
        boolean valueToFind = true;
        int startIndex = 5;
        int expectedIndex = 2;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_booleanArray_startIndexNegative() {
        boolean[] array = {true, false, true, false};
        boolean valueToFind = true;
        int startIndex = -1;
        int expectedIndex = -1;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }
    
    // Repeat the above tests for other data types
    
    @Test
    public void testLastIndexOf_byteArray_valueFound() {
        byte[] array = {1, 2, 3, 4};
        byte valueToFind = 3;
        int expectedIndex = 2;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_byteArray_valueNotFound() {
        byte[] array = {1, 2, 3, 4};
        byte valueToFind = 5;
        int expectedIndex = -1;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    // Repeat the above tests for other data types
    
    @Test
    public void testLastIndexOf_objectArray_valueFound() {
        String[] array = {"apple", "banana", "orange", "apple"};
        String valueToFind = "banana";
        int expectedIndex = 1;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_objectArray_valueNotFound() {
        String[] array = {"apple", "banana", "orange", "apple"};
        String valueToFind = "grape";
        int expectedIndex = -1;
        int actualIndex = arrayUtils.lastIndexOf(array, valueToFind);
        assertEquals(expectedIndex, actualIndex);
    }
    
    // Repeat the above tests for other data types
    
}