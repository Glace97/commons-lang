import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isArrayTest {

    @Test
    void testIsNull() {
        assertFalse(ObjectUtils.isArray(null));
    }
    
    @Test
    void testIsEmptyString() {
        assertFalse(ObjectUtils.isArray(""));
    }
    
    @Test
    void testIsString() {
        assertFalse(ObjectUtils.isArray("ab"));
    }
    
    @Test
    void testIsIntPrimitiveArray() {
        assertTrue(ObjectUtils.isArray(new int[] {}));
    }
    
    @Test
    void testIsIntObjectArray() {
        assertTrue(ObjectUtils.isArray(new Integer[] {1, 2, 3}));
    }
    
    @Test
    void testIsInt() {
        assertFalse(ObjectUtils.isArray(1234));
    }
}