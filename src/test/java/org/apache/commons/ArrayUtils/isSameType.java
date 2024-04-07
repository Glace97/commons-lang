import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isSameTypeTest {
    
    private final ArrayUtils arrayUtils = new ArrayUtils();
    
    @Test
    void testIsSameType_sameTypeArrays_returnsTrue() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        assertTrue(arrayUtils.isSameType(array1, array2));
        
        String[] array3 = {"a", "b", "c"};
        String[] array4 = {"d", "e", "f"};
        assertTrue(arrayUtils.isSameType(array3, array4));
        
        Object[] array5 = {1, "a", true};
        Object[] array6 = {2, "b", false};
        assertTrue(arrayUtils.isSameType(array5, array6));
    }
    
    @Test
    void testIsSameType_differentTypeArrays_returnsFalse() {
        int[] array1 = {1, 2, 3};
        String[] array2 = {"a", "b", "c"};
        assertFalse(arrayUtils.isSameType(array1, array2));
        
        int[] array3 = {1, 2, 3};
        Object[] array4 = {4, 5, 6};
        assertFalse(arrayUtils.isSameType(array3, array4));
        
        String[] array5 = {"a", "b", "c"};
        Object[] array6 = {1, "a", true};
        assertFalse(arrayUtils.isSameType(array5, array6));
    }
    
    @Test
    void testIsSameType_nullArrays_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> arrayUtils.isSameType(null, null));
        assertThrows(IllegalArgumentException.class, () -> arrayUtils.isSameType(null, new int[3]));
        assertThrows(IllegalArgumentException.class, () -> arrayUtils.isSameType(new int[3], null));
    }
}