import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getLengthTest {

    @Test
    void testGetLength_NullArray_ReturnsZero() {
        Object array = null;
        int expected = 0;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_EmptyArray_ReturnsZero() {
        Object array = new Object[0];
        int expected = 0;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_ArrayWithNullElement_ReturnsOne() {
        Object[] array = {null};
        int expected = 1;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_BooleanArray_ReturnsLength() {
        boolean[] array = {true, false};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_ByteArray_ReturnsLength() {
        byte[] array = {1, 2, 3};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_CharArray_ReturnsLength() {
        char[] array = {'a', 'b', 'c'};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_DoubleArray_ReturnsLength() {
        double[] array = {1.0, 2.0, 3.0};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_FloatArray_ReturnsLength() {
        float[] array = {1.0f, 2.0f, 3.0f};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_IntArray_ReturnsLength() {
        int[] array = {1, 2, 3};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_LongArray_ReturnsLength() {
        long[] array = {1L, 2L, 3L};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_ShortArray_ReturnsLength() {
        short[] array = {1, 2, 3};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_StringArray_ReturnsLength() {
        String[] array = {"a", "b", "c"};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_ObjectArray_ReturnsLength() {
        Object[] array = {new Object(), new Object(), new Object()};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_MixedArray_ReturnsLength() {
        Object[] array = {1, "a", true};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_NestedArray_ReturnsLength() {
        Object[] array = {new Object[2], new Object[3], new Object[4]};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetLength_MultiDimensionalArray_ReturnsLength() {
        Object[][] array = {{"a", "b"}, {"c", "d"}, {"e", "f"}};
        int expected = array.length;
        
        int actual = ArrayUtils.getLength(array);
        
        assertEquals(expected, actual);
    }
}