import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isNotEmptyTest {

    @Test
    void testIsNotEmptyWithBooleanArray() {
        boolean[] array = { true, false };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyBooleanArray() {
        boolean[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullBooleanArray() {
        boolean[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithByteArray() {
        byte[] array = { 1, 2, 3 };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyByteArray() {
        byte[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullByteArray() {
        byte[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithCharArray() {
        char[] array = { 'a', 'b', 'c' };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyCharArray() {
        char[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullCharArray() {
        char[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithDoubleArray() {
        double[] array = { 1.0, 2.0, 3.0 };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyDoubleArray() {
        double[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullDoubleArray() {
        double[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithFloatArray() {
        float[] array = { 1.0f, 2.0f, 3.0f };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyFloatArray() {
        float[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullFloatArray() {
        float[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithIntArray() {
        int[] array = { 1, 2, 3 };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyIntArray() {
        int[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullIntArray() {
        int[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithLongArray() {
        long[] array = { 1L, 2L, 3L };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyLongArray() {
        long[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullLongArray() {
        long[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithShortArray() {
        short[] array = { 1, 2, 3 };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyShortArray() {
        short[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullShortArray() {
        short[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithObjectArray() {
        Integer[] array = { 1, 2, 3 };
        assertTrue(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithEmptyObjectArray() {
        Integer[] array = {};
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
    
    @Test
    void testIsNotEmptyWithNullObjectArray() {
        Integer[] array = null;
        assertFalse(ArrayUtils.isNotEmpty(array));
    }
}