import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class isArrayIndexValidTest {
    
    @Test
    @DisplayName("Test isArrayIndexValid with null array")
    void testIsNullArray() {
        assertFalse(ArrayUtils.isArrayIndexValid(null, 0));
    }
    
    @Test
    @DisplayName("Test isArrayIndexValid with empty array")
    void testIsEmptyArray() {
        assertFalse(ArrayUtils.isArrayIndexValid(new Object[0], 0));
    }
    
    @Test
    @DisplayName("Test isArrayIndexValid with non-empty array and valid index")
    void testValidIndex() {
        assertTrue(ArrayUtils.isArrayIndexValid(new Object[]{"a"}, 0));
    }
    
    @Test
    @DisplayName("Test isArrayIndexValid with negative index")
    void testNegativeIndex() {
        assertFalse(ArrayUtils.isArrayIndexValid(new Object[]{"a"}, -1));
    }
    
    @Test
    @DisplayName("Test isArrayIndexValid with index greater than array size")
    void testIndexGreaterThanSize() {
        assertFalse(ArrayUtils.isArrayIndexValid(new Object[]{"a"}, 1));
    }
}