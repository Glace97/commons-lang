import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class CloneTest {
    
    @Test
    void testClone_NullObject_ReturnsNull() {
        Object original = null;
        Object cloned = ObjectUtils.clone(original);
        assertNull(cloned);
    }
    
    @Test
    void testClone_NonCloneableType_ReturnsNull() {
        NonCloneableType original = new NonCloneableType();
        NonCloneableType cloned = ObjectUtils.clone(original);
        assertNull(cloned);
    }
    
    @Test
    void testClone_PrimitiveArray_ReturnsClonedArray() {
        int[] original = {1, 2, 3};
        int[] cloned = ObjectUtils.clone(original);
        assertNotSame(original, cloned);
        assertTrue(Arrays.equals(original, cloned));
    }
    
    @Test
    void testClone_ObjectArray_ReturnsClonedArray() {
        Object[] original = {new Object(), new Object()};
        Object[] cloned = ObjectUtils.clone(original);
        assertNotSame(original, cloned);
        assertNotSame(original[0], cloned[0]);
        assertNotSame(original[1], cloned[1]);
        assertTrue(Arrays.equals(original, cloned));
    }
    
    @Test
    void testClone_CloneableType_ReturnsClonedObject() {
        CloneableType original = new CloneableType();
        CloneableType cloned = ObjectUtils.clone(original);
        assertNotSame(original, cloned);
        assertEquals(original, cloned);
    }
    
    private static class NonCloneableType {
        // non-cloneable type
    }
    
    private static class CloneableType implements Cloneable {
        // cloneable type
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}