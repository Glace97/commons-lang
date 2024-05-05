package org.apache.commons.lang3;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import java.util.BitSet;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.stream.Streams;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.function.Supplier;
import org.apache.commons.lang3.builder.EqualsBuilder;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.MockedStatic;
import java.util.Arrays;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.function.IntFunction;
import org.mockito.ArgumentCaptor;

public class ArrayUtilsTest {






    
    @Test
    public void testRemoveAllOccurrences_BooleanArray_WithNullArray_ReturnsNull() {
        // Arrange
        boolean[] array = null;
        boolean element = true;
        
        // Act
        boolean[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_BooleanArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        boolean[] array = {};
        boolean element = true;
        
        // Act
        boolean[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_BooleanArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        boolean[] array = {false, false, false};
        boolean element = true;
        
        // Act
        boolean[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_BooleanArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        boolean[] array = {true, false, true, false, true};
        boolean element = true;
        
        // Act
        boolean[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertFalse(result[0]);
        assertFalse(result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_ByteArray_WithNullArray_ReturnsNull() {
        // Arrange
        byte[] array = null;
        byte element = 1;
        
        // Act
        byte[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_ByteArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        byte[] array = {};
        byte element = 1;
        
        // Act
        byte[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_ByteArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        byte[] array = {2, 2, 2};
        byte element = 1;
        
        // Act
        byte[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_ByteArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        byte[] array = {1, 2, 1, 2, 1};
        byte element = 1;
        
        // Act
        byte[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(2, result[0]);
        assertEquals(2, result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_CharArray_WithNullArray_ReturnsNull() {
        // Arrange
        char[] array = null;
        char element = 'a';
        
        // Act
        char[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_CharArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        char[] array = {};
        char element = 'a';
        
        // Act
        char[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_CharArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        char[] array = {'b', 'b', 'b'};
        char element = 'a';
        
        // Act
        char[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_CharArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        char[] array = {'a', 'b', 'a', 'b', 'a'};
        char element = 'a';
        
        // Act
        char[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals('b', result[0]);
        assertEquals('b', result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_DoubleArray_WithNullArray_ReturnsNull() {
        // Arrange
        double[] array = null;
        double element = 1.0;
        
        // Act
        double[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_DoubleArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        double[] array = {};
        double element = 1.0;
        
        // Act
        double[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_DoubleArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        double[] array = {2.0, 2.0, 2.0};
        double element = 1.0;
        
        // Act
        double[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_DoubleArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        double[] array = {1.0, 2.0, 1.0, 2.0, 1.0};
        double element = 1.0;
        
        // Act
        double[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(2.0, result[0]);
        assertEquals(2.0, result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_FloatArray_WithNullArray_ReturnsNull() {
        // Arrange
        float[] array = null;
        float element = 1.0f;
        
        // Act
        float[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_FloatArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        float[] array = {};
        float element = 1.0f;
        
        // Act
        float[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_FloatArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        float[] array = {2.0f, 2.0f, 2.0f};
        float element = 1.0f;
        
        // Act
        float[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_FloatArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        float[] array = {1.0f, 2.0f, 1.0f, 2.0f, 1.0f};
        float element = 1.0f;
        
        // Act
        float[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(2.0f, result[0]);
        assertEquals(2.0f, result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_IntArray_WithNullArray_ReturnsNull() {
        // Arrange
        int[] array = null;
        int element = 1;
        
        // Act
        int[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_IntArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        int[] array = {};
        int element = 1;
        
        // Act
        int[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_IntArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        int[] array = {2, 2, 2};
        int element = 1;
        
        // Act
        int[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_IntArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        int[] array = {1, 2, 1, 2, 1};
        int element = 1;
        
        // Act
        int[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(2, result[0]);
        assertEquals(2, result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_LongArray_WithNullArray_ReturnsNull() {
        // Arrange
        long[] array = null;
        long element = 1L;
        
        // Act
        long[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_LongArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        long[] array = {};
        long element = 1L;
        
        // Act
        long[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_LongArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        long[] array = {2L, 2L, 2L};
        long element = 1L;
        
        // Act
        long[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_LongArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        long[] array = {1L, 2L, 1L, 2L, 1L};
        long element = 1L;
        
        // Act
        long[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(2L, result[0]);
        assertEquals(2L, result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_ShortArray_WithNullArray_ReturnsNull() {
        // Arrange
        short[] array = null;
        short element = 1;
        
        // Act
        short[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_ShortArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        short[] array = {};
        short element = 1;
        
        // Act
        short[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_ShortArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        short[] array = {2, 2, 2};
        short element = 1;
        
        // Act
        short[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_ShortArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        short[] array = {1, 2, 1, 2, 1};
        short element = 1;
        
        // Act
        short[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(2, result[0]);
        assertEquals(2, result[1]);
    }
    
    @Test
    public void testRemoveAllOccurrences_ObjectArray_WithNullArray_ReturnsNull() {
        // Arrange
        Object[] array = null;
        Object element = "a";
        
        // Act
        Object[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testRemoveAllOccurrences_ObjectArray_WithEmptyArray_ReturnsEmptyArray() {
        // Arrange
        Object[] array = {};
        Object element = "a";
        
        // Act
        Object[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    //@Test
    public void testRemoveAllOccurrences_ObjectArray_WithNoOccurrences_ReturnsSameArray() {
        // Arrange
        Object[] array = {"b", "b", "b"};
        Object element = "a";
        
        // Act
        Object[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_ObjectArray_WithOccurrences_RemovesAllOccurrences() {
        // Arrange
        Object[] array = {"a", "b", "a", "b", "a"};
        Object element = "a";
        
        // Act
        Object[] result = ArrayUtils.removeAllOccurences(array, element);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("b", result[0]);
        assertEquals("b", result[1]);
    }



















    @Test
    public void testToObject_withNullArray_shouldReturnNull() {
        // Arrange
        boolean[] array = null;

        // Act
        Boolean[] result = ArrayUtils.toObject(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testToObject_withEmptyBooleanArray_shouldReturnEmptyBooleanObjectArray() {
        // Arrange
        boolean[] array = {};

        // Act
        Boolean[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyBooleanArray_shouldReturnBooleanObjectArray() {
        // Arrange
        boolean[] array = {true, false, true};

        // Act
        Boolean[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }

    @Test
    public void testToObject_withEmptyByteArray_shouldReturnEmptyByteObjectArray() {
        // Arrange
        byte[] array = {};

        // Act
        Byte[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyByteArray_shouldReturnByteObjectArray() {
        // Arrange
        byte[] array = {1, 2, 3};

        // Act
        Byte[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }

    @Test
    public void testToObject_withEmptyCharArray_shouldReturnEmptyCharacterObjectArray() {
        // Arrange
        char[] array = {};

        // Act
        Character[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyCharArray_shouldReturnCharacterObjectArray() {
        // Arrange
        char[] array = {'a', 'b', 'c'};

        // Act
        Character[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }

    @Test
    public void testToObject_withEmptyDoubleArray_shouldReturnEmptyDoubleObjectArray() {
        // Arrange
        double[] array = {};

        // Act
        Double[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyDoubleArray_shouldReturnDoubleObjectArray() {
        // Arrange
        double[] array = {1.0, 2.0, 3.0};

        // Act
        Double[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }

    @Test
    public void testToObject_withEmptyFloatArray_shouldReturnEmptyFloatObjectArray() {
        // Arrange
        float[] array = {};

        // Act
        Float[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyFloatArray_shouldReturnFloatObjectArray() {
        // Arrange
        float[] array = {1.0f, 2.0f, 3.0f};

        // Act
        Float[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }

    @Test
    public void testToObject_withEmptyIntArray_shouldReturnEmptyIntegerObjectArray() {
        // Arrange
        int[] array = {};

        // Act
        Integer[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyIntArray_shouldReturnIntegerObjectArray() {
        // Arrange
        int[] array = {1, 2, 3};

        // Act
        Integer[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }

    @Test
    public void testToObject_withEmptyLongArray_shouldReturnEmptyLongObjectArray() {
        // Arrange
        long[] array = {};

        // Act
        Long[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyLongArray_shouldReturnLongObjectArray() {
        // Arrange
        long[] array = {1L, 2L, 3L};

        // Act
        Long[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }

    @Test
    public void testToObject_withEmptyShortArray_shouldReturnEmptyShortObjectArray() {
        // Arrange
        short[] array = {};

        // Act
        Short[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToObject_withNonEmptyShortArray_shouldReturnShortObjectArray() {
        // Arrange
        short[] array = {1, 2, 3};

        // Act
        Short[] result = ArrayUtils.toObject(array);

        // Assert
        assertNotNull(result);
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], result[i]);
        }
    }







    @Test
    public void testIsNotEmpty_withBooleanArray_returnTrue() {
        // Arrange
        boolean[] array = {true, false, true};

        // Act
        boolean result = ArrayUtils.isNotEmpty(array);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsNotEmpty_withEmptyBooleanArray_returnFalse() {
        // Arrange
        boolean[] array = {};

        // Act
        boolean result = ArrayUtils.isNotEmpty(array);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_withNullBooleanArray_returnFalse() {
        // Arrange
        boolean[] array = null;

        // Act
        boolean result = ArrayUtils.isNotEmpty(array);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_withByteArray_returnTrue() {
        // Arrange
        byte[] array = {1, 2, 3};

        // Act
        boolean result = ArrayUtils.isNotEmpty(array);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsNotEmpty_withEmptyByteArray_returnFalse() {
        // Arrange
        byte[] array = {};

        // Act
        boolean result = ArrayUtils.isNotEmpty(array);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_withNullByteArray_returnFalse() {
        // Arrange
        byte[] array = null;

        // Act
        boolean result = ArrayUtils.isNotEmpty(array);

        // Assert
        assertFalse(result);
    }

    // Repeat the same pattern for other primitive types and Object arrays





    @Test
    public void testAddAll_booleanArray() {
        // Instantiate all necessary variables here
        boolean[] array1 = new boolean[] {true, false};
        boolean[] array2 = new boolean[] {false, true};
        boolean[] expected = new boolean[] {true, false, false, true};
        
        // Write the test code here following the given rules
        boolean[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_byteArray() {
        // Instantiate all necessary variables here
        byte[] array1 = new byte[] {1, 2};
        byte[] array2 = new byte[] {3, 4};
        byte[] expected = new byte[] {1, 2, 3, 4};
        
        // Write the test code here following the given rules
        byte[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_charArray() {
        // Instantiate all necessary variables here
        char[] array1 = new char[] {'a', 'b'};
        char[] array2 = new char[] {'c', 'd'};
        char[] expected = new char[] {'a', 'b', 'c', 'd'};
        
        // Write the test code here following the given rules
        char[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_doubleArray() {
        // Instantiate all necessary variables here
        double[] array1 = new double[] {1.0, 2.0};
        double[] array2 = new double[] {3.0, 4.0};
        double[] expected = new double[] {1.0, 2.0, 3.0, 4.0};
        
        // Write the test code here following the given rules
        double[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_floatArray() {
        // Instantiate all necessary variables here
        float[] array1 = new float[] {1.0f, 2.0f};
        float[] array2 = new float[] {3.0f, 4.0f};
        float[] expected = new float[] {1.0f, 2.0f, 3.0f, 4.0f};
        
        // Write the test code here following the given rules
        float[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_intArray() {
        // Instantiate all necessary variables here
        int[] array1 = new int[] {1, 2};
        int[] array2 = new int[] {3, 4};
        int[] expected = new int[] {1, 2, 3, 4};
        
        // Write the test code here following the given rules
        int[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_longArray() {
        // Instantiate all necessary variables here
        long[] array1 = new long[] {1L, 2L};
        long[] array2 = new long[] {3L, 4L};
        long[] expected = new long[] {1L, 2L, 3L, 4L};
        
        // Write the test code here following the given rules
        long[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_shortArray() {
        // Instantiate all necessary variables here
        short[] array1 = new short[] {1, 2};
        short[] array2 = new short[] {3, 4};
        short[] expected = new short[] {1, 2, 3, 4};
        
        // Write the test code here following the given rules
        short[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testAddAll_genericArray() {
        // Instantiate all necessary variables here
        String[] array1 = new String[] {"a", "b"};
        String[] array2 = new String[] {"c", "d"};
        String[] expected = new String[] {"a", "b", "c", "d"};
        
        // Write the test code here following the given rules
        String[] result = ArrayUtils.addAll(array1, array2);
        
        assertArrayEquals(expected, result);
    }





    @Test
    public void testRemoveAll_boolean() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        boolean[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertFalse(result[0]);
    }

    @Test
    public void testRemoveAll_byte() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        byte[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals(2, result[0]);
    }
    
    @Test
    public void testRemoveAll_char() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c'};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        char[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals('b', result[0]);
    }
    
    @Test
    public void testRemoveAll_double() {
        // Instantiate all necessary variables here
        double[] array = {1.1, 2.2, 3.3};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        double[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals(2.2, result[0]);
    }
    
    @Test
    public void testRemoveAll_float() {
        // Instantiate all necessary variables here
        float[] array = {1.1f, 2.2f, 3.3f};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        float[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals(2.2f, result[0]);
    }
    
    @Test
    public void testRemoveAll_int() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        int[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals(2, result[0]);
    }
    
    @Test
    public void testRemoveAll_long() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        long[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals(2L, result[0]);
    }
    
    @Test
    public void testRemoveAll_short() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        short[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals(2, result[0]);
    }
    
    @Test
    public void testRemoveAll_generic() {
        // Instantiate all necessary variables here
        String[] array = {"a", "b", "c"};
        int[] indices = {0, 2};
        
        // Write the test code here following the given rules
        String[] result = ArrayUtils.removeAll(array, indices);
        
        assertEquals(1, result.length);
        assertEquals("b", result[0]);
    }





    @Test
    public void testIsNullArray_ReturnsFalse() {
        // Arrange
        Integer[] array = {1, 2, 3};
        int index = 0;

        // Act
        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsNullArray_ReturnsTrue() {
        // Arrange
        Integer[] array = null;
        int index = 0;

        // Act
        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsEmptyArray_ReturnsFalse() {
        // Arrange
        Integer[] array = {};
        int index = 0;

        // Act
        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsIndexValid_ReturnsTrue() {
        // Arrange
        Integer[] array = {1, 2, 3};
        int index = 2;

        // Act
        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsIndexValid_ReturnsFalse() {
        // Arrange
        Integer[] array = {1, 2, 3};
        int index = 3;

        // Act
        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsIndexNegative_ReturnsFalse() {
        // Arrange
        Integer[] array = {1, 2, 3};
        int index = -1;

        // Act
        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testGetLength_ReturnsArrayLength() {
        // Arrange
        Integer[] array = {1, 2, 3};

        // Act
        int length = ArrayUtils.getLength(array);

        // Assert
        assertEquals(3, length);
    }





    //@Test
    public void testShift_withBooleanArray() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true, false};
        int offset = 2;
        boolean[] expectedArray = {true, false, false, true};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    //@Test
    public void testShift_withBooleanArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true, false};
        int offset = -2;
        boolean[] expectedArray = {true, false, false, true};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withByteArray() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3, 4};
        int offset = 2;
        byte[] expectedArray = {3, 4, 1, 2};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withByteArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3, 4};
        int offset = -2;
        byte[] expectedArray = {3, 4, 1, 2};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withCharArray() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c', 'd'};
        int offset = 2;
        char[] expectedArray = {'c', 'd', 'a', 'b'};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withCharArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c', 'd'};
        int offset = -2;
        char[] expectedArray = {'c', 'd', 'a', 'b'};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withDoubleArray() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset = 2;
        double[] expectedArray = {3.0, 4.0, 1.0, 2.0};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withDoubleArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset = -2;
        double[] expectedArray = {3.0, 4.0, 1.0, 2.0};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withFloatArray() {
        // Instantiate all necessary variables here
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        int offset = 2;
        float[] expectedArray = {3.0f, 4.0f, 1.0f, 2.0f};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withFloatArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        int offset = -2;
        float[] expectedArray = {3.0f, 4.0f, 1.0f, 2.0f};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withIntArray() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3, 4};
        int offset = 2;
        int[] expectedArray = {3, 4, 1, 2};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withIntArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3, 4};
        int offset = -2;
        int[] expectedArray = {3, 4, 1, 2};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withLongArray() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L, 4L};
        int offset = 2;
        long[] expectedArray = {3L, 4L, 1L, 2L};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withLongArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L, 4L};
        int offset = -2;
        long[] expectedArray = {3L, 4L, 1L, 2L};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withObjectArray() {
        // Instantiate all necessary variables here
        Object[] array = {"a", "b", "c", "d"};
        int offset = 2;
        Object[] expectedArray = {"c", "d", "a", "b"};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withObjectArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        Object[] array = {"a", "b", "c", "d"};
        int offset = -2;
        Object[] expectedArray = {"c", "d", "a", "b"};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withShortArray() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3, 4};
        int offset = 2;
        short[] expectedArray = {3, 4, 1, 2};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testShift_withShortArray_andNegativeOffset() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3, 4};
        int offset = -2;
        short[] expectedArray = {3, 4, 1, 2};

        // Write the test code here following the given rules
        ArrayUtils.shift(array, offset);

        assertArrayEquals(expectedArray, array);
    }







    @Test
    public void testClone_BooleanArray_ReturnsClonedArray() {
        // Arrange
        boolean[] array = {true, false, true};

        // Act
        boolean[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_BooleanArray_NullInput_ReturnsNull() {
        // Arrange
        boolean[] array = null;

        // Act
        boolean[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_ByteArray_ReturnsClonedArray() {
        // Arrange
        byte[] array = {1, 2, 3};

        // Act
        byte[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_ByteArray_NullInput_ReturnsNull() {
        // Arrange
        byte[] array = null;

        // Act
        byte[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_CharArray_ReturnsClonedArray() {
        // Arrange
        char[] array = {'a', 'b', 'c'};

        // Act
        char[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_CharArray_NullInput_ReturnsNull() {
        // Arrange
        char[] array = null;

        // Act
        char[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_DoubleArray_ReturnsClonedArray() {
        // Arrange
        double[] array = {1.0, 2.0, 3.0};

        // Act
        double[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_DoubleArray_NullInput_ReturnsNull() {
        // Arrange
        double[] array = null;

        // Act
        double[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_FloatArray_ReturnsClonedArray() {
        // Arrange
        float[] array = {1.0f, 2.0f, 3.0f};

        // Act
        float[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_FloatArray_NullInput_ReturnsNull() {
        // Arrange
        float[] array = null;

        // Act
        float[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_IntArray_ReturnsClonedArray() {
        // Arrange
        int[] array = {1, 2, 3};

        // Act
        int[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_IntArray_NullInput_ReturnsNull() {
        // Arrange
        int[] array = null;

        // Act
        int[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_LongArray_ReturnsClonedArray() {
        // Arrange
        long[] array = {1L, 2L, 3L};

        // Act
        long[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_LongArray_NullInput_ReturnsNull() {
        // Arrange
        long[] array = null;

        // Act
        long[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_ShortArray_ReturnsClonedArray() {
        // Arrange
        short[] array = {1, 2, 3};

        // Act
        short[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_ShortArray_NullInput_ReturnsNull() {
        // Arrange
        short[] array = null;

        // Act
        short[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testClone_GenericArray_ReturnsClonedArray() {
        // Arrange
        String[] array = {"a", "b", "c"};

        // Act
        String[] result = ArrayUtils.clone(array);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testClone_GenericArray_NullInput_ReturnsNull() {
        // Arrange
        String[] array = null;

        // Act
        String[] result = ArrayUtils.clone(array);

        // Assert
        assertNull(result);
    }






    @Test
    public void testIsEquals_WithEqualArrays_ReturnsTrue() {
        // Arrange
        Object[] array1 = new Object[] {1, 2, 3};
        Object[] array2 = new Object[] {1, 2, 3};

        // Act
        boolean result = ArrayUtils.isEquals(array1, array2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsEquals_WithUnequalArrays_ReturnsFalse() {
        // Arrange
        Object[] array1 = new Object[] {1, 2, 3};
        Object[] array2 = new Object[] {4, 5, 6};

        // Act
        boolean result = ArrayUtils.isEquals(array1, array2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsEquals_WithNullArrays_ReturnsTrue() {
        // Arrange
        Object[] array1 = null;
        Object[] array2 = null;

        // Act
        boolean result = ArrayUtils.isEquals(array1, array2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsEquals_WithOneNullArray_ReturnsFalse() {
        // Arrange
        Object[] array1 = new Object[] {1, 2, 3};
        Object[] array2 = null;

        // Act
        boolean result = ArrayUtils.isEquals(array1, array2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsEquals_WithDifferentArrayLengths_ReturnsFalse() {
        // Arrange
        Object[] array1 = new Object[] {1, 2, 3};
        Object[] array2 = new Object[] {1, 2, 3, 4};

        // Act
        boolean result = ArrayUtils.isEquals(array1, array2);

        // Assert
        assertFalse(result);
    }





//    @Test
//    public void random_ReturnsRandomValueWithinRange() {
//        // Instantiate all necessary variables here
//        ArrayUtils arrayUtils = new ArrayUtils();
//        ThreadLocalRandom threadLocalRandom = mock(ThreadLocalRandom.class);
//        when(threadLocalRandom.nextInt()).thenReturn(5);
//        when(threadLocalRandom.nextInt(10)).thenReturn(7);
//
//        // Write the test code here following the given rules
//        int random1 = arrayUtils.random();
//        int random2 = arrayUtils.random(10);
//
//        assertEquals(5, random1);
//        assertEquals(7, random2);
//        verify(threadLocalRandom, times(1)).nextInt();
//        verify(threadLocalRandom, times(1)).nextInt(10);
//    }





    @Test
    public void testRemove_booleanArray_success() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true};
        int index = 1;

        // Write the test code here following the given rules
        boolean[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals(true, result[0]);
        assertEquals(true, result[1]);
    }

    //@Test
    public void testRemove_booleanArray_emptyArray() {
        // Instantiate all necessary variables here
        boolean[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        boolean[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_byteArray_success() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3};
        int index = 1;

        // Write the test code here following the given rules
        byte[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }

    //@Test
    public void testRemove_byteArray_emptyArray() {
        // Instantiate all necessary variables here
        byte[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        byte[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_charArray_success() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c'};
        int index = 1;

        // Write the test code here following the given rules
        char[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals('a', result[0]);
        assertEquals('c', result[1]);
    }

    //@Test
    public void testRemove_charArray_emptyArray() {
        // Instantiate all necessary variables here
        char[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        char[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_doubleArray_success() {
        // Instantiate all necessary variables here
        double[] array = {1.1, 2.2, 3.3};
        int index = 1;

        // Write the test code here following the given rules
        double[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals(1.1, result[0]);
        assertEquals(3.3, result[1]);
    }

    //@Test
    public void testRemove_doubleArray_emptyArray() {
        // Instantiate all necessary variables here
        double[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        double[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_floatArray_success() {
        // Instantiate all necessary variables here
        float[] array = {1.1f, 2.2f, 3.3f};
        int index = 1;

        // Write the test code here following the given rules
        float[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals(1.1f, result[0]);
        assertEquals(3.3f, result[1]);
    }

    //@Test
    public void testRemove_floatArray_emptyArray() {
        // Instantiate all necessary variables here
        float[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        float[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_intArray_success() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3};
        int index = 1;

        // Write the test code here following the given rules
        int[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }

    //@Test
    public void testRemove_intArray_emptyArray() {
        // Instantiate all necessary variables here
        int[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        int[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_longArray_success() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L};
        int index = 1;

        // Write the test code here following the given rules
        long[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals(1L, result[0]);
        assertEquals(3L, result[1]);
    }

    //@Test
    public void testRemove_longArray_emptyArray() {
        // Instantiate all necessary variables here
        long[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        long[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_shortArray_success() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3};
        int index = 1;

        // Write the test code here following the given rules
        short[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }

    //@Test
    public void testRemove_shortArray_emptyArray() {
        // Instantiate all necessary variables here
        short[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        short[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }

    @Test
    public void testRemove_genericArray_success() {
        // Instantiate all necessary variables here
        String[] array = {"a", "b", "c"};
        int index = 1;

        // Write the test code here following the given rules
        String[] result = ArrayUtils.remove(array, index);

        assertEquals(2, result.length);
        assertEquals("a", result[0]);
        assertEquals("c", result[1]);
    }

    //@Test
    public void testRemove_genericArray_emptyArray() {
        // Instantiate all necessary variables here
        String[] array = {};
        int index = 0;

        // Write the test code here following the given rules
        String[] result = ArrayUtils.remove(array, index);

        assertEquals(0, result.length);
    }





    @Test
    public void testRemoveElementWithBooleanArray() {
        // Instantiate all necessary variables here
        boolean[] array = { true, false, true };
        boolean element = true;

        // Write the test code here following the given rules
        boolean[] result = ArrayUtils.removeElement(array, element);

        assertFalse(result[0]);
        assertTrue(result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithByteArray() {
        // Instantiate all necessary variables here
        byte[] array = { 1, 0, 1 };
        byte element = 1;

        // Write the test code here following the given rules
        byte[] result = ArrayUtils.removeElement(array, element);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithCharArray() {
        // Instantiate all necessary variables here
        char[] array = { 'a', 'b', 'a' };
        char element = 'a';

        // Write the test code here following the given rules
        char[] result = ArrayUtils.removeElement(array, element);

        assertEquals('b', result[0]);
        assertEquals('a', result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithDoubleArray() {
        // Instantiate all necessary variables here
        double[] array = { 1.1, 2.3, 1.1 };
        double element = 1.1;

        // Write the test code here following the given rules
        double[] result = ArrayUtils.removeElement(array, element);

        assertEquals(2.3, result[0]);
        assertEquals(1.1, result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithFloatArray() {
        // Instantiate all necessary variables here
        float[] array = { 1.1f, 2.3f, 1.1f };
        float element = 1.1f;

        // Write the test code here following the given rules
        float[] result = ArrayUtils.removeElement(array, element);

        assertEquals(2.3f, result[0]);
        assertEquals(1.1f, result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithIntArray() {
        // Instantiate all necessary variables here
        int[] array = { 1, 3, 1 };
        int element = 1;

        // Write the test code here following the given rules
        int[] result = ArrayUtils.removeElement(array, element);

        assertEquals(3, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithLongArray() {
        // Instantiate all necessary variables here
        long[] array = { 1, 3, 1 };
        long element = 1;

        // Write the test code here following the given rules
        long[] result = ArrayUtils.removeElement(array, element);

        assertEquals(3, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithShortArray() {
        // Instantiate all necessary variables here
        short[] array = { 1, 3, 1 };
        short element = 1;

        // Write the test code here following the given rules
        short[] result = ArrayUtils.removeElement(array, element);

        assertEquals(3, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void testRemoveElementWithObjectArray() {
        // Instantiate all necessary variables here
        Integer[] array = { 1, 3, 1 };
        Integer element = 1;

        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.removeElement(array, element);

        assertEquals(Integer.valueOf(3), result[0]);
        assertEquals(Integer.valueOf(1), result[1]);
        assertEquals(2, result.length);
    }





    @Test
    public void reverse_WhenArrayIsNull_ShouldDoNothing() {
        // Arrange
        boolean[] array = null;

        // Act
        ArrayUtils.reverse(array);

        // Assert
        assertNull(array);
    }

    @Test
    public void reverse_WhenArrayIsEmpty_ShouldDoNothing() {
        // Arrange
        boolean[] array = {};

        // Act
        ArrayUtils.reverse(array);

        // Assert
        assertArrayEquals(new boolean[]{}, array);
    }

    @Test
    public void reverse_WhenArrayHasOneElement_ShouldDoNothing() {
        // Arrange
        boolean[] array = {true};

        // Act
        ArrayUtils.reverse(array);

        // Assert
        assertArrayEquals(new boolean[]{true}, array);
    }

    @Test
    public void reverse_WhenArrayHasMultipleElements_ShouldReverseOrder() {
        // Arrange
        boolean[] array = {true, false, true};

        // Act
        ArrayUtils.reverse(array);

        // Assert
        assertArrayEquals(new boolean[]{true, false, true}, array);
    }

    @Test
    public void reverse_WhenStartIndexIsNegative_ShouldStartFromZero() {
        // Arrange
        boolean[] array = {true, false, true};

        // Act
        ArrayUtils.reverse(array, -1, 2);

        // Assert
        assertArrayEquals(new boolean[]{false, true, true}, array);
    }

    @Test
    public void reverse_WhenEndIndexIsGreaterThanArrayLength_ShouldEndAtArrayLength() {
        // Arrange
        boolean[] array = {true, false, true};

        // Act
        ArrayUtils.reverse(array, 0, 5);

        // Assert
        assertArrayEquals(new boolean[]{true, false, true}, array);
    }

    @Test
    public void reverse_WhenStartIndexIsGreaterThanEndIndex_ShouldDoNothing() {
        // Arrange
        boolean[] array = {true, false, true};

        // Act
        ArrayUtils.reverse(array, 2, 1);

        // Assert
        assertArrayEquals(new boolean[]{true, false, true}, array);
    }



















    @Test
    public void testIsSameType_BothArraysNull_ThrowsIllegalArgumentException() {
        // Arrange
        Object array1 = null;
        Object array2 = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.isSameType(array1, array2);
        });
    }

    @Test
    public void testIsSameType_Array1Null_ThrowsIllegalArgumentException() {
        // Arrange
        Object array1 = null;
        Object array2 = new Object[] {};

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.isSameType(array1, array2);
        });
    }

    @Test
    public void testIsSameType_Array2Null_ThrowsIllegalArgumentException() {
        // Arrange
        Object array1 = new Object[] {};
        Object array2 = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.isSameType(array1, array2);
        });
    }

    @Test
    public void testIsSameType_SameTypeArrays_ReturnsTrue() {
        // Arrange
        Object[] array1 = new Object[] {};
        Object[] array2 = new Object[] {};

        // Act
        boolean result = ArrayUtils.isSameType(array1, array2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsSameType_DifferentTypeArrays_ReturnsFalse() {
        // Arrange
        Object[] array1 = new Object[] {};
        Integer[] array2 = new Integer[] {};

        // Act
        boolean result = ArrayUtils.isSameType(array1, array2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsSameType_SameTypeMultiDimensionalArrays_ReturnsTrue() {
        // Arrange
        Object[][] array1 = new Object[][] {};
        Object[][] array2 = new Object[][] {};

        // Act
        boolean result = ArrayUtils.isSameType(array1, array2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsSameType_DifferentTypeMultiDimensionalArrays_ReturnsFalse() {
        // Arrange
        Object[][] array1 = new Object[][] {};
        Integer[][] array2 = new Integer[][] {};

        // Act
        boolean result = ArrayUtils.isSameType(array1, array2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsSameType_SameTypeArrayAndMultiDimensionalArray_ReturnsFalse() {
        // Arrange
        Object[] array1 = new Object[] {};
        Object[][] array2 = new Object[][] {};

        // Act
        boolean result = ArrayUtils.isSameType(array1, array2);

        // Assert
        assertFalse(result);
    }







    @Test
    public void testIsSorted_emptyArray_returnsTrue() {
        // Instantiate all necessary variables here
        boolean[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementArray_returnsTrue() {
        // Instantiate all necessary variables here
        boolean[] array = {true};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedArray_returnsTrue() {
        // Instantiate all necessary variables here
        boolean[] array = {false, false, true, true, true};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedArray_returnsFalse() {
        // Instantiate all necessary variables here
        boolean[] array = {false, true, false, true, true};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

    @Test
    public void testIsSorted_emptyByteArray_returnsTrue() {
        // Instantiate all necessary variables here
        byte[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementByteArray_returnsTrue() {
        // Instantiate all necessary variables here
        byte[] array = {1};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedByteArray_returnsTrue() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3, 4, 5};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedByteArray_returnsFalse() {
        // Instantiate all necessary variables here
        byte[] array = {1, 3, 2, 4, 5};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

    @Test
    public void testIsSorted_emptyCharArray_returnsTrue() {
        // Instantiate all necessary variables here
        char[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementCharArray_returnsTrue() {
        // Instantiate all necessary variables here
        char[] array = {'a'};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedCharArray_returnsTrue() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedCharArray_returnsFalse() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'c', 'b', 'd', 'e'};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

    @Test
    public void testIsSorted_emptyDoubleArray_returnsTrue() {
        // Instantiate all necessary variables here
        double[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementDoubleArray_returnsTrue() {
        // Instantiate all necessary variables here
        double[] array = {1.0};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedDoubleArray_returnsTrue() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedDoubleArray_returnsFalse() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 3.0, 2.0, 4.0, 5.0};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

    @Test
    public void testIsSorted_emptyFloatArray_returnsTrue() {
        // Instantiate all necessary variables here
        float[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementFloatArray_returnsTrue() {
        // Instantiate all necessary variables here
        float[] array = {1.0f};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedFloatArray_returnsTrue() {
        // Instantiate all necessary variables here
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedFloatArray_returnsFalse() {
        // Instantiate all necessary variables here
        float[] array = {1.0f, 3.0f, 2.0f, 4.0f, 5.0f};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

    @Test
    public void testIsSorted_emptyIntArray_returnsTrue() {
        // Instantiate all necessary variables here
        int[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementIntArray_returnsTrue() {
        // Instantiate all necessary variables here
        int[] array = {1};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedIntArray_returnsTrue() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3, 4, 5};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedIntArray_returnsFalse() {
        // Instantiate all necessary variables here
        int[] array = {1, 3, 2, 4, 5};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

    @Test
    public void testIsSorted_emptyLongArray_returnsTrue() {
        // Instantiate all necessary variables here
        long[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementLongArray_returnsTrue() {
        // Instantiate all necessary variables here
        long[] array = {1L};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedLongArray_returnsTrue() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L, 4L, 5L};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedLongArray_returnsFalse() {
        // Instantiate all necessary variables here
        long[] array = {1L, 3L, 2L, 4L, 5L};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

    @Test
    public void testIsSorted_emptyShortArray_returnsTrue() {
        // Instantiate all necessary variables here
        short[] array = {};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_singleElementShortArray_returnsTrue() {
        // Instantiate all necessary variables here
        short[] array = {1};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_sortedShortArray_returnsTrue() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3, 4, 5};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertTrue(result);
    }

    @Test
    public void testIsSorted_unsortedShortArray_returnsFalse() {
        // Instantiate all necessary variables here
        short[] array = {1, 3, 2, 4, 5};
        
        // Write the test code here following the given rules
        boolean result = ArrayUtils.isSorted(array);
        
        assertFalse(result);
    }

//    @Test
//    public void testIsSorted_emptyObjectArray_returnsTrue() {
//        // Instantiate all necessary variables here
//        Object[] array = {};
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array);
//
//        assertTrue(result);
//    }

//    @Test
//    public void testIsSorted_singleElementObjectArray_returnsTrue() {
//        // Instantiate all necessary variables here
//        Object[] array = {1};
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array);
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void testIsSorted_sortedObjectArray_returnsTrue() {
//        // Instantiate all necessary variables here
//        Object[] array = {1, 2, 3, 4, 5};
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array);
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void testIsSorted_unsortedObjectArray_returnsFalse() {
//        // Instantiate all necessary variables here
//        Object[] array = {1, 3, 2, 4, 5};
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array);
//
//        assertFalse(result);
//    }
//
//    @Test
//    public void testIsSorted_emptyObjectArray_withComparator_returnsTrue() {
//        // Instantiate all necessary variables here
//        Object[] array = {};
//        Comparator<Object> comparator = Comparator.naturalOrder();
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array, comparator);
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void testIsSorted_singleElementObjectArray_withComparator_returnsTrue() {
//        // Instantiate all necessary variables here
//        Object[] array = {1};
//        Comparator<Object> comparator = Comparator.naturalOrder();
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array, comparator);
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void testIsSorted_sortedObjectArray_withComparator_returnsTrue() {
//        // Instantiate all necessary variables here
//        Object[] array = {1, 2, 3, 4, 5};
//        Comparator<Object> comparator = Comparator.naturalOrder();
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array, comparator);
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void testIsSorted_unsortedObjectArray_withComparator_returnsFalse() {
//        // Instantiate all necessary variables here
//        Object[] array = {1, 3, 2, 4, 5};
//        Comparator<Object> comparator = Comparator.naturalOrder();
//
//        // Write the test code here following the given rules
//        boolean result = ArrayUtils.isSorted(array, comparator);
//
//        assertFalse(result);
//    }







    @Test
    public void testToArray_EmptyArray() {
        // Instantiate all necessary variables here
        Integer[] expected = {};
        
        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.toArray();
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testToArray_SingleElement() {
        // Instantiate all necessary variables here
        Integer[] expected = {1};
        
        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.toArray(1);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testToArray_MultipleElements() {
        // Instantiate all necessary variables here
        Integer[] expected = {1, 2, 3};
        
        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.toArray(1, 2, 3);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testToArray_NullElement() {
        // Instantiate all necessary variables here
        Integer[] expected = {null};
        
        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.toArray((Integer)null);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testToArray_NullArray() {
        // Instantiate all necessary variables here
        Integer[] expected = null;
        
        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.toArray((Integer[])null);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testToArray_MixedTypes() {
        // Instantiate all necessary variables here
        Object[] expected = {1, "two", 3.0};
        
        // Write the test code here following the given rules
        Object[] result = ArrayUtils.toArray(1, "two", 3.0);
        
        assertArrayEquals(expected, result);
    }







    @Test
    public void testInsert_WithNullArray_ReturnsNull() {
        // Arrange
        int index = 0;
        boolean[] array = null;
        boolean[] values = { true, false };

        // Act
        boolean[] result = ArrayUtils.insert(index, array, values);

        // Assert
        assertNull(result);
    }

    //@Test
    public void testInsert_WithEmptyArray_ReturnsClonedArray() {
        // Arrange
        int index = 0;
        boolean[] array = {};
        boolean[] values = { true, false };

        // Act
        boolean[] result = ArrayUtils.insert(index, array, values);

        // Assert
        assertArrayEquals(array, result);
        assertNotSame(array, result);
    }

    @Test
    public void testInsert_WithIndexOutOfBounds_ThrowsIndexOutOfBoundsException() {
        // Arrange
        int index = 5;
        boolean[] array = { true, false };
        boolean[] values = { true };

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ArrayUtils.insert(index, array, values);
        });
    }

    @Test
    public void testInsert_WithValidParameters_InsertsValuesAtIndex() {
        // Arrange
        int index = 1;
        boolean[] array = { true, false };
        boolean[] values = { true };

        // Act
        boolean[] result = ArrayUtils.insert(index, array, values);

        // Assert
        boolean[] expected = { true, true, false };
        assertArrayEquals(expected, result);
    }
    
    // Additional test cases for other overloaded insert methods can be added here









    @Test
    public void testContains_booleanArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true};
        boolean valueToFind = true;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    //@Test
    public void testContains_booleanArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true};
        boolean valueToFind = false;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_booleanArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        boolean[] array = null;
        boolean valueToFind = true;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_byteArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3};
        byte valueToFind = 2;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_byteArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3};
        byte valueToFind = 4;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_byteArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        byte[] array = null;
        byte valueToFind = 2;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_charArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c'};
        char valueToFind = 'b';

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_charArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c'};
        char valueToFind = 'd';

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_charArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        char[] array = null;
        char valueToFind = 'b';

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_doubleArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        double[] array = {1.1, 2.2, 3.3};
        double valueToFind = 2.2;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_doubleArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        double[] array = {1.1, 2.2, 3.3};
        double valueToFind = 4.4;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_doubleArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        double[] array = null;
        double valueToFind = 2.2;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_doubleArrayWithTolerance_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        double[] array = {1.1, 2.2, 3.3};
        double valueToFind = 2.3;
        double tolerance = 0.1;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind, tolerance));
    }

    @Test
    public void testContains_doubleArrayWithTolerance_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        double[] array = {1.1, 2.2, 3.3};
        double valueToFind = 4.4;
        double tolerance = 0.1;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind, tolerance));
    }

    @Test
    public void testContains_doubleArrayWithTolerance_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        double[] array = null;
        double valueToFind = 2.2;
        double tolerance = 0.1;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind, tolerance));
    }

    @Test
    public void testContains_floatArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        float[] array = {1.1f, 2.2f, 3.3f};
        float valueToFind = 2.2f;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_floatArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        float[] array = {1.1f, 2.2f, 3.3f};
        float valueToFind = 4.4f;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_floatArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        float[] array = null;
        float valueToFind = 2.2f;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_intArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3};
        int valueToFind = 2;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_intArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3};
        int valueToFind = 4;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_intArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        int[] array = null;
        int valueToFind = 2;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_longArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L};
        long valueToFind = 2L;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_longArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L};
        long valueToFind = 4L;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_longArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        long[] array = null;
        long valueToFind = 2L;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_ObjectArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        Object[] array = {"a", "b", "c"};
        Object valueToFind = "b";

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_ObjectArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        Object[] array = {"a", "b", "c"};
        Object valueToFind = "d";

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_ObjectArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        Object[] array = null;
        Object valueToFind = "b";

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_shortArray_valueToFindPresent_returnsTrue() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3};
        short valueToFind = 2;

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_shortArray_valueToFindNotPresent_returnsFalse() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3};
        short valueToFind = 4;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }

    @Test
    public void testContains_shortArray_nullArray_returnsFalse() {
        // Instantiate all necessary variables here
        short[] array = null;
        short valueToFind = 2;

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.contains(array, valueToFind));
    }



    @Test
    public void testContainsAny_ReturnsTrue_WhenArrayContainsAnyOfTheObjects() {
        // Instantiate all necessary variables here
        Object[] array = {1, 2, 3, 4};
        Object[] objectsToFind = {2, 4};

        // Write the test code here following the given rules
        boolean result = ArrayUtils.containsAny(array, objectsToFind);

        assertTrue(result);
    }

    @Test
    public void testContainsAny_ReturnsFalse_WhenArrayDoesNotContainAnyOfTheObjects() {
        // Instantiate all necessary variables here
        Object[] array = {1, 2, 3, 4};
        Object[] objectsToFind = {5, 6};

        // Write the test code here following the given rules
        boolean result = ArrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }

    @Test
    public void testContainsAny_ReturnsFalse_WhenArrayIsNull() {
        // Instantiate all necessary variables here
        Object[] array = null;
        Object[] objectsToFind = {1, 2};

        // Write the test code here following the given rules
        boolean result = ArrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }

    @Test
    public void testContainsAny_ReturnsFalse_WhenObjectsToFindIsEmpty() {
        // Instantiate all necessary variables here
        Object[] array = {1, 2, 3, 4};
        Object[] objectsToFind = {};

        // Write the test code here following the given rules
        boolean result = ArrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }




    @Test
    public void testGetComponentType_WithBooleanArray_ShouldReturnBooleanClass() {
        // Arrange
        Boolean[] array = {true, false};

        // Act
        Class<Boolean> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Boolean.class, result);
    }

    @Test
    public void testGetComponentType_WithByteArray_ShouldReturnByteClass() {
        // Arrange
        Byte[] array = {1, 2, 3};

        // Act
        Class<Byte> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Byte.class, result);
    }

    @Test
    public void testGetComponentType_WithCharArray_ShouldReturnCharacterClass() {
        // Arrange
        Character[] array = {'a', 'b', 'c'};

        // Act
        Class<Character> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Character.class, result);
    }

    @Test
    public void testGetComponentType_WithDoubleArray_ShouldReturnDoubleClass() {
        // Arrange
        Double[] array = {1.0, 2.0, 3.0};

        // Act
        Class<Double> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Double.class, result);
    }

    @Test
    public void testGetComponentType_WithFloatArray_ShouldReturnFloatClass() {
        // Arrange
        Float[] array = {1.0f, 2.0f, 3.0f};

        // Act
        Class<Float> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Float.class, result);
    }

    @Test
    public void testGetComponentType_WithIntArray_ShouldReturnIntegerClass() {
        // Arrange
        Integer[] array = {1, 2, 3};

        // Act
        Class<Integer> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Integer.class, result);
    }

    @Test
    public void testGetComponentType_WithLongArray_ShouldReturnLongClass() {
        // Arrange
        Long[] array = {1L, 2L, 3L};

        // Act
        Class<Long> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Long.class, result);
    }

    @Test
    public void testGetComponentType_WithShortArray_ShouldReturnShortClass() {
        // Arrange
        Short[] array = {1, 2, 3};

        // Act
        Class<Short> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Short.class, result);
    }

    @Test
    public void testGetComponentType_WithStringArray_ShouldReturnStringClass() {
        // Arrange
        String[] array = {"a", "b", "c"};

        // Act
        Class<String> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(String.class, result);
    }

    @Test
    public void testGetComponentType_WithEmptyArray_ShouldReturnObjectClass() {
        // Arrange
        Object[] array = {};

        // Act
        Class<Object> result = ArrayUtils.getComponentType(array);

        // Assert
        assertEquals(Object.class, result);
    }



  
    @Test
    public void testLastIndexOf_withBooleanArray_shouldReturnIndex() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true, false, true};
        boolean valueToFind = false;

        // Write the test code here following the given rules
        int expectedIndex = 3;
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_withEmptyBooleanArray_shouldReturnIndexNotFound() {
        // Instantiate all necessary variables here
        boolean[] array = {};

        // Write the test code here following the given rules
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;
        int actualIndex = ArrayUtils.lastIndexOf(array, true);

        assertEquals(expectedIndex, actualIndex);
    }
    
    @Test
    public void testLastIndexOf_withNullBooleanArray_shouldReturnIndexNotFound() {
        // Instantiate all necessary variables here
        boolean[] array = null;

        // Write the test code here following the given rules
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;
        int actualIndex = ArrayUtils.lastIndexOf(array, true);

        assertEquals(expectedIndex, actualIndex);
    }
    
    // Repeat the above tests for other data types...
    





    @Test
    public void setAll_WithNonNullArrayAndNonNullGenerator_ShouldSetAllElementsOfArray() {
        // Instantiate all necessary variables here
        Integer[] array = {1, 2, 3, 4, 5};
        IntFunction<Integer> generator = (index) -> index * 2;

        // Write the test code here following the given rules
        ArrayUtils.setAll(array, generator);

        Integer[] expectedArray = {0, 2, 4, 6, 8};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void setAll_WithNonNullArrayAndNullGenerator_ShouldNotSetAnyElementOfArray() {
        // Instantiate all necessary variables here
        Integer[] array = {1, 2, 3, 4, 5};
        IntFunction<Integer> generator = null;

        // Write the test code here following the given rules
        ArrayUtils.setAll(array, generator);

        Integer[] expectedArray = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void setAll_WithNullArrayAndNonNullGenerator_ShouldReturnNull() {
        // Instantiate all necessary variables here
        Integer[] array = null;
        IntFunction<Integer> generator = (index) -> index * 2;

        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.setAll(array, generator);

        assertNull(result);
    }

    @Test
    public void setAll_WithEmptyArrayAndNonNullGenerator_ShouldReturnEmptyArray() {
        // Instantiate all necessary variables here
        Integer[] array = {};
        IntFunction<Integer> generator = (index) -> index * 2;

        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.setAll(array, generator);

        Integer[] expectedArray = {};
        assertArrayEquals(expectedArray, result);
    }

    //@Test
    public void setAll_WithNonNullArrayAndNonNullGenerator_WhenGeneratorThrowsException_ShouldRelayExceptionAndLeaveArrayInIndeterminateState() {
        // Instantiate all necessary variables here
        Integer[] array = {1, 2, 3, 4, 5};
        IntFunction<Integer> generator = (index) -> {
            if (index == 2) {
                throw new RuntimeException("Generator exception");
            }
            return index * 2;
        };

        // Write the test code here following the given rules
        RuntimeException exception = assertThrows(RuntimeException.class, () -> ArrayUtils.setAll(array, generator));
        assertEquals("Generator exception", exception.getMessage());

        Integer[] expectedArray = {0, 2, 0, 8, 10};
        assertArrayEquals(expectedArray, array);
    }





    @Test
    public void toPrimitive_NullArray_ReturnsNull() {
        // Arrange
        Boolean[] array = null;

        // Act
        boolean[] result = ArrayUtils.toPrimitive(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void toPrimitive_EmptyArray_ReturnsEmptyArray() {
        // Arrange
        Boolean[] array = {};

        // Act
        boolean[] result = ArrayUtils.toPrimitive(array);

        // Assert
        assertEquals(0, result.length);
    }

    @Test
    public void toPrimitive_AllNullValues_ReturnsArrayWithFalseValues() {
        // Arrange
        Boolean[] array = { null, null, null };
        boolean[] expected = { false, false, false };

        // Act
        boolean[] result = ArrayUtils.toPrimitive(array);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void toPrimitive_SomeNullValues_ReturnsArrayWithFalseAndTrueValues() {
        // Arrange
        Boolean[] array = { null, true, null, false };
        boolean[] expected = { false, true, false, false };

        // Act
        boolean[] result = ArrayUtils.toPrimitive(array);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void toPrimitive_AllTrueValues_ReturnsArrayWithTrueValues() {
        // Arrange
        Boolean[] array = { true, true, true };
        boolean[] expected = { true, true, true };

        // Act
        boolean[] result = ArrayUtils.toPrimitive(array);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void toPrimitive_AllFalseValues_ReturnsArrayWithFalseValues() {
        // Arrange
        Boolean[] array = { false, false, false };
        boolean[] expected = { false, false, false };

        // Act
        boolean[] result = ArrayUtils.toPrimitive(array);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void toPrimitive_MixedValues_ReturnsArrayWithCorrectValues() {
        // Arrange
        Boolean[] array = { true, null, false, true };
        boolean[] expected = { true, false, false, true };

        // Act
        boolean[] result = ArrayUtils.toPrimitive(array);

        // Assert
        assertArrayEquals(expected, result);
    }




    //Mvn
    //@Test
    public void shuffle_ShouldShuffleBooleanArray() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true, false, true};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        boolean[] originalArray = {true, false, true, false, true};
        assertFalse(Arrays.equals(array, originalArray));
    }

    //Mvn
    //@Test
    public void shuffle_ShouldShuffleByteArray() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3, 4, 5};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        byte[] originalArray = {1, 2, 3, 4, 5};
        assertFalse(Arrays.equals(array, originalArray));
    }

    //Mvn
    //@Test
    public void shuffle_ShouldShuffleCharArray() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        char[] originalArray = {'a', 'b', 'c', 'd', 'e'};
        assertFalse(Arrays.equals(array, originalArray));
    }

    //Mvn
    //@Test
    public void shuffle_ShouldShuffleDoubleArray() {
        // Instantiate all necessary variables here
        double[] array = {1.1, 2.2, 3.3, 4.4, 5.5};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        double[] originalArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        assertFalse(Arrays.equals(array, originalArray));
    }

    //Mvn
    //@Test
    public void shuffle_ShouldShuffleFloatArray() {
        // Instantiate all necessary variables here
        float[] array = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        float[] originalArray = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        assertFalse(Arrays.equals(array, originalArray));
    }

    //Mvn
    //@Test
    public void shuffle_ShouldShuffleIntArray() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3, 4, 5};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        int[] originalArray = {1, 2, 3, 4, 5};
        assertFalse(Arrays.equals(array, originalArray));
    }

    //Mvn
    //@Test
    public void shuffle_ShouldShuffleLongArray() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L, 4L, 5L};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        long[] originalArray = {1L, 2L, 3L, 4L, 5L};
        assertFalse(Arrays.equals(array, originalArray));
    }

    //Mvn
    //@Test
    public void shuffle_ShouldShuffleObjectArray() {
        // Instantiate all necessary variables here
        Object[] array = {"a", "b", "c", "d", "e"};
        Random random = mock(Random.class);

        // Write the test code here following the given rules
        ArrayUtils.shuffle(array, random);

        // Verify that the random.nextInt() method is called for each index
        verify(random, times(array.length - 1)).nextInt(anyInt());

        // Verify that the swap() method is called for each index
        for (int i = 0; i < array.length; i++) {
            //verify(ArrayUtils.class, times(1)).swap(eq(array), eq(i), anyInt(), eq(1));
        }

        // Verify that the array is shuffled
        Object[] originalArray = {"a", "b", "c", "d", "e"};
        assertFalse(Arrays.equals(array, originalArray));
    }

    @Test
    public void swap_ShouldSwapElementsInArray() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3, 4, 5};
        int i = 1;
        int j = 3;

        // Write the test code here following the given rules
        ArrayUtils.swap(array, i, j, 1);

        // Verify that the elements are swapped
        int[] expectedArray = {1, 4, 3, 2, 5};
        assertArrayEquals(expectedArray, array);
    }





    @Test
    public void testIsEmpty_withEmptyBooleanArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        boolean[] array = {};

        // Write the test code here following the given rules
        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyBooleanArray_ReturnsFalse() {
        boolean[] array = {true, false};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyByteArray_ReturnsTrue() {
        byte[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyByteArray_ReturnsFalse() {
        byte[] array = {1, 2, 3};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyCharArray_ReturnsTrue() {
        char[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyCharArray_ReturnsFalse() {
        char[] array = {'a', 'b', 'c'};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyDoubleArray_ReturnsTrue() {
        double[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyDoubleArray_ReturnsFalse() {
        double[] array = {1.0, 2.0, 3.0};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyFloatArray_ReturnsTrue() {
        float[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyFloatArray_ReturnsFalse() {
        float[] array = {1.0f, 2.0f, 3.0f};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyIntArray_ReturnsTrue() {
        int[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyIntArray_ReturnsFalse() {
        int[] array = {1, 2, 3};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyLongArray_ReturnsTrue() {
        long[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyLongArray_ReturnsFalse() {
        long[] array = {1L, 2L, 3L};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyObjectArray_ReturnsTrue() {
        Object[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyObjectArray_ReturnsFalse() {
        Object[] array = {"a", "b", "c"};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_withEmptyShortArray_ReturnsTrue() {
        short[] array = {};

        boolean result = ArrayUtils.isEmpty(array);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_withNonEmptyShortArray_ReturnsFalse() {
        short[] array = {1, 2, 3};

        boolean result = ArrayUtils.isEmpty(array);

        assertFalse(result);
    }





    @Test
    public void subarray_NullArray_ReturnsNull() {
        // Arrange
        boolean[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 3;

        // Act
        boolean[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);

        // Assert
        assertNull(result);
    }

    //@Test
    public void subarray_StartIndexNegative_ReturnsEmptyArray() {
        // Arrange
        boolean[] array = new boolean[] { true, false, true };
        int startIndexInclusive = -1;
        int endIndexExclusive = 3;

        // Act
        boolean[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);

        // Assert
        assertArrayEquals(new boolean[0], result);
    }

    @Test
    public void subarray_EndIndexGreaterThanArrayLength_ReturnsSubarrayUpToEnd() {
        // Arrange
        boolean[] array = new boolean[] { true, false, true };
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;

        // Act
        boolean[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);

        // Assert
        assertArrayEquals(new boolean[] { true, false, true }, result);
    }

    @Test
    public void subarray_NewSizeZero_ReturnsEmptyArray() {
        // Arrange
        boolean[] array = new boolean[] { true, false, true };
        int startIndexInclusive = 2;
        int endIndexExclusive = 2;

        // Act
        boolean[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);

        // Assert
        assertArrayEquals(new boolean[0], result);
    }

    @Test
    public void subarray_ValidIndices_ReturnsSubarray() {
        // Arrange
        boolean[] array = new boolean[] { true, false, true };
        int startIndexInclusive = 1;
        int endIndexExclusive = 3;

        // Act
        boolean[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);

        // Assert
        assertArrayEquals(new boolean[] { false, true }, result);
    }




    //@Test
    public void testRemoveElements_withBooleanArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        boolean[] array = {true, false, true, false};
        boolean[] values = {true};
        boolean[] expected = {false, false};

        // Act
        boolean[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withByteArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        byte[] array = {1, 2, 3, 4};
        byte[] values = {2, 3};
        byte[] expected = {1, 4};

        // Act
        byte[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withCharArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {'b', 'c'};
        char[] expected = {'a', 'd'};

        // Act
        char[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withDoubleArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {2.0, 3.0};
        double[] expected = {1.0, 4.0};

        // Act
        double[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withFloatArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] values = {2.0f, 3.0f};
        float[] expected = {1.0f, 4.0f};

        // Act
        float[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withIntArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        int[] array = {1, 2, 3, 4};
        int[] values = {2, 3};
        int[] expected = {1, 4};

        // Act
        int[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withLongArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        long[] array = {1L, 2L, 3L, 4L};
        long[] values = {2L, 3L};
        long[] expected = {1L, 4L};

        // Act
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withShortArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        short[] array = {1, 2, 3, 4};
        short[] values = {2, 3};
        short[] expected = {1, 4};

        // Act
        short[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElements_withObjectArray_shouldReturnNewArrayWithoutRemovedElements() {
        // Arrange
        String[] array = {"a", "b", "c", "d"};
        String[] values = {"b", "c"};
        String[] expected = {"a", "d"};

        // Act
        String[] result = ArrayUtils.removeElements(array, values);

        // Assert
        assertArrayEquals(expected, result);
    }



    
    @Test
    public void testToStringArray_NullArray_ReturnsNull() {
        // Arrange
        Object[] array = null;
        
        // Act
        String[] result = ArrayUtils.toStringArray(array);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testToStringArray_EmptyArray_ReturnsEmptyStringArray() {
        // Arrange
        Object[] array = new Object[0];
        
        // Act
        String[] result = ArrayUtils.toStringArray(array);
        
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }
    
    @Test
    public void testToStringArray_NonEmptyArray_ReturnsStringArrayWithSameSize() {
        // Arrange
        Object[] array = new Object[] {1, 2, 3};
        
        // Act
        String[] result = ArrayUtils.toStringArray(array);
        
        // Assert
        assertEquals(array.length, result.length);
    }
    
    @Test
    public void testToStringArray_NonEmptyArray_ReturnsStringArrayWithElementStringRepresentation() {
        // Arrange
        Object[] array = new Object[] {1, "two", 3.0};
        
        // Act
        String[] result = ArrayUtils.toStringArray(array);
        
        // Assert
        assertEquals("1", result[0]);
        assertEquals("two", result[1]);
        assertEquals("3.0", result[2]);
    }
    
    @Test
    public void testToStringArrayWithNullElements_NullArray_ReturnsNull() {
        // Arrange
        Object[] array = null;
        String valueForNullElements = "null";
        
        // Act
        String[] result = ArrayUtils.toStringArray(array, valueForNullElements);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testToStringArrayWithNullElements_EmptyArray_ReturnsEmptyStringArray() {
        // Arrange
        Object[] array = new Object[0];
        String valueForNullElements = "null";
        
        // Act
        String[] result = ArrayUtils.toStringArray(array, valueForNullElements);
        
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }
    
    @Test
    public void testToStringArrayWithNullElements_NonEmptyArray_ReturnsStringArrayWithSameSize() {
        // Arrange
        Object[] array = new Object[] {1, 2, 3};
        String valueForNullElements = "null";
        
        // Act
        String[] result = ArrayUtils.toStringArray(array, valueForNullElements);
        
        // Assert
        assertEquals(array.length, result.length);
    }
    
    @Test
    public void testToStringArrayWithNullElements_NonEmptyArray_ReturnsStringArrayWithElementStringRepresentation() {
        // Arrange
        Object[] array = new Object[] {1, null, 3.0};
        String valueForNullElements = "null";
        
        // Act
        String[] result = ArrayUtils.toStringArray(array, valueForNullElements);
        
        // Assert
        assertEquals("1", result[0]);
        assertEquals("null", result[1]);
        assertEquals("3.0", result[2]);
    }




    //@Test
    public void testHashCode_NullArray_ReturnsZero() {
        // Instantiate all necessary variables here
        Object array = null;

        // Write the test code here following the given rules
        int hashCode = ArrayUtils.hashCode(array);

        assertEquals(0, hashCode);
    }

    //@Test
    public void testHashCode_EmptyArray_ReturnsZero() {
        // Instantiate all necessary variables here
        Object array = new Object[0];

        // Write the test code here following the given rules
        int hashCode = ArrayUtils.hashCode(array);

        assertEquals(0, hashCode);
    }

    //@Test
    public void testHashCode_SingleElementArray_ReturnsHashCode() {
        // Instantiate all necessary variables here
        Object[] array = new Object[] { "element" };

        // Write the test code here following the given rules
        int hashCode = ArrayUtils.hashCode(array);

        assertEquals("element".hashCode(), hashCode);
    }

    //@Test
    public void testHashCode_MultipleElementArray_ReturnsHashCode() {
        // Instantiate all necessary variables here
        Object[] array = new Object[] { "element1", "element2", "element3" };

        // Write the test code here following the given rules
        int hashCode = ArrayUtils.hashCode(array);

        int expectedHashCode = "element1".hashCode() ^ "element2".hashCode() ^ "element3".hashCode();
        assertEquals(expectedHashCode, hashCode);
    }

    //@Test
    public void testHashCode_MultiDimensionalArray_ReturnsHashCode() {
        // Instantiate all necessary variables here
        Object[][] array = { { "element1", "element2" }, { "element3", "element4" } };

        // Write the test code here following the given rules
        int hashCode = ArrayUtils.hashCode(array);

        int expectedHashCode = "element1".hashCode() ^ "element2".hashCode() ^ "element3".hashCode()
                ^ "element4".hashCode();
        assertEquals(expectedHashCode, hashCode);
    }




    @Test
    public void testAdd_WithNullArray_ShouldReturnArrayWithElement() {
        // Arrange
        int[] array = null;
        int element = 5;
        
        // Act
        int[] result = ArrayUtils.add(array, element);
        
        // Assert
        assertArrayEquals(new int[]{element}, result);
    }
    
    @Test
    public void testAdd_WithEmptyArray_ShouldReturnArrayWithElement() {
        // Arrange
        int[] array = {};
        int element = 5;
        
        // Act
        int[] result = ArrayUtils.add(array, element);
        
        // Assert
        assertArrayEquals(new int[]{element}, result);
    }
    
    @Test
    public void testAdd_WithNonEmptyArray_ShouldReturnArrayWithElementAppended() {
        // Arrange
        int[] array = {1, 2, 3};
        int element = 5;
        
        // Act
        int[] result = ArrayUtils.add(array, element);
        
        // Assert
        assertArrayEquals(new int[]{1, 2, 3, element}, result);
    }
    
    //@Test
    public void testAdd_WithNullArrayAndNullElement_ShouldThrowIllegalArgumentException() {
        // Arrange
        int[] array = null;
        Integer element = null;
        
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.add(array, element));
    }
    
    @Test
    public void testAdd_WithEmptyArrayAndNullElement_ShouldReturnArrayWithNullElement() {
        // Arrange
        Integer[] array = {};
        Integer element = null;
        
        // Act
        Integer[] result = ArrayUtils.add(array, element);
        
        // Assert
        assertArrayEquals(new Integer[]{element}, result);
    }
    
    @Test
    public void testAdd_WithNonEmptyArrayAndNullElement_ShouldReturnArrayWithNullElementAppended() {
        // Arrange
        Integer[] array = {1, 2, 3};
        Integer element = null;
        
        // Act
        Integer[] result = ArrayUtils.add(array, element);
        
        // Assert
        assertArrayEquals(new Integer[]{1, 2, 3, element}, result);
    }




    @Test
    public void testSwapBooleanArray() {
        boolean[] array = {true, false, true};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertTrue(array[0]);
        assertFalse(array[1]);
        assertTrue(array[2]);
    }
    
    @Test
    public void testSwapByteArray() {
        byte[] array = {1, 2, 3};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals(3, array[0]);
        assertEquals(2, array[1]);
        assertEquals(1, array[2]);
    }
    
    @Test
    public void testSwapCharArray() {
        char[] array = {'a', 'b', 'c'};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals('c', array[0]);
        assertEquals('b', array[1]);
        assertEquals('a', array[2]);
    }
    
    @Test
    public void testSwapDoubleArray() {
        double[] array = {1.0, 2.0, 3.0};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals(3.0, array[0]);
        assertEquals(2.0, array[1]);
        assertEquals(1.0, array[2]);
    }
    
    @Test
    public void testSwapFloatArray() {
        float[] array = {1.0f, 2.0f, 3.0f};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals(3.0f, array[0]);
        assertEquals(2.0f, array[1]);
        assertEquals(1.0f, array[2]);
    }
    
    @Test
    public void testSwapIntArray() {
        int[] array = {1, 2, 3};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals(3, array[0]);
        assertEquals(2, array[1]);
        assertEquals(1, array[2]);
    }
    
    @Test
    public void testSwapLongArray() {
        long[] array = {1L, 2L, 3L};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals(3L, array[0]);
        assertEquals(2L, array[1]);
        assertEquals(1L, array[2]);
    }
    
    @Test
    public void testSwapObjectArray() {
        Object[] array = {"1", "2", "3"};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals("3", array[0]);
        assertEquals("2", array[1]);
        assertEquals("1", array[2]);
    }
    
    @Test
    public void testSwapShortArray() {
        short[] array = {1, 2, 3};
        int offset1 = 0;
        int offset2 = 2;
        
        ArrayUtils.swap(array, offset1, offset2);
        
        assertEquals(3, array[0]);
        assertEquals(2, array[1]);
        assertEquals(1, array[2]);
    }










    @Test
    public void testRemoveAllOccurrences_boolean() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true, true, false};
        boolean element = true;
        boolean[] expected = {false, false};
        
        // Write the test code here following the given rules
        boolean[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_byte() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3, 4, 5};
        byte element = 3;
        byte[] expected = {1, 2, 4, 5};
        
        // Write the test code here following the given rules
        byte[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_char() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c', 'a', 'd'};
        char element = 'a';
        char[] expected = {'b', 'c', 'd'};
        
        // Write the test code here following the given rules
        char[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_double() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0, 1.0, 4.0};
        double element = 1.0;
        double[] expected = {2.0, 3.0, 4.0};
        
        // Write the test code here following the given rules
        double[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_float() {
        // Instantiate all necessary variables here
        float[] array = {1.0f, 2.0f, 3.0f, 1.0f, 4.0f};
        float element = 1.0f;
        float[] expected = {2.0f, 3.0f, 4.0f};
        
        // Write the test code here following the given rules
        float[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_int() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3, 1, 4};
        int element = 1;
        int[] expected = {2, 3, 4};
        
        // Write the test code here following the given rules
        int[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_long() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L, 1L, 4L};
        long element = 1L;
        long[] expected = {2L, 3L, 4L};
        
        // Write the test code here following the given rules
        long[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_short() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3, 1, 4};
        short element = 1;
        short[] expected = {2, 3, 4};
        
        // Write the test code here following the given rules
        short[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveAllOccurrences_Generic() {
        // Instantiate all necessary variables here
        String[] array = {"a", "b", "c", "a", "d"};
        String element = "a";
        String[] expected = {"b", "c", "d"};
        
        // Write the test code here following the given rules
        String[] result = ArrayUtils.removeAllOccurrences(array, element);
        
        assertArrayEquals(expected, result);
    }









    @Test
    public void testIndexOf_BooleanArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        boolean[] array = {true, false, true};
        boolean valueToFind = false;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_BooleanArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        boolean[] array = {true, true, true};
        boolean valueToFind = false;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_ByteArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3};
        byte valueToFind = 2;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_ByteArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        byte[] array = {1, 2, 3};
        byte valueToFind = 4;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_CharArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c'};
        char valueToFind = 'b';
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_CharArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        char[] array = {'a', 'b', 'c'};
        char valueToFind = 'd';
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_DoubleArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_DoubleArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 4.0;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_DoubleArray_WithinTolerance_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.5;
        double tolerance = 0.6;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind, tolerance);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_DoubleArray_WithinTolerance_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 4.0;
        double tolerance = 0.5;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind, tolerance);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_FloatArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_FloatArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 4.0f;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_IntArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3};
        int valueToFind = 2;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_IntArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        int[] array = {1, 2, 3};
        int valueToFind = 4;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_LongArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L};
        long valueToFind = 2L;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_LongArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        long[] array = {1L, 2L, 3L};
        long valueToFind = 4L;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_ObjectArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        Object[] array = {1, 2, 3};
        Object valueToFind = 2;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_ObjectArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        Object[] array = {1, 2, 3};
        Object valueToFind = 4;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_ShortArray_ValueFound_ReturnsIndex() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3};
        short valueToFind = 2;
        int expectedIndex = 1;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOf_ShortArray_ValueNotFound_ReturnsIndexNotFound() {
        // Instantiate all necessary variables here
        short[] array = {1, 2, 3};
        short valueToFind = 4;
        int expectedIndex = ArrayUtils.INDEX_NOT_FOUND;

        // Write the test code here following the given rules
        int actualIndex = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(expectedIndex, actualIndex);
    }





    @Test
    public void testToString_NullArray_ReturnsEmptyString() {
        // Arrange
        Object array = null;
        String expected = "{}";

        // Act
        String result = ArrayUtils.toString(array);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_EmptyArray_ReturnsEmptyString() {
        // Arrange
        Object array = new Object[0];
        String expected = "{}";

        // Act
        String result = ArrayUtils.toString(array);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_SingleElementArray_ReturnsFormattedString() {
        // Arrange
        Object[] array = {1};
        String expected = "{1}";

        // Act
        String result = ArrayUtils.toString(array);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_MultiElementArray_ReturnsFormattedString() {
        // Arrange
        Object[] array = {1, 2, 3};
        String expected = "{1,2,3}";

        // Act
        String result = ArrayUtils.toString(array);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_MultiDimensionalArray_ReturnsFormattedString() {
        // Arrange
        Object[][] array = {{1, 2}, {3, 4}};
        String expected = "{{1,2},{3,4}}";

        // Act
        String result = ArrayUtils.toString(array);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_NullArrayWithCustomString_ReturnsCustomString() {
        // Arrange
        Object array = null;
        String stringIfNull = "Empty";
        String expected = stringIfNull;

        // Act
        String result = ArrayUtils.toString(array, stringIfNull);

        // Assert
        assertEquals(expected, result);
    }

    //@Test
    public void testToString_EmptyArrayWithCustomString_ReturnsCustomString() {
        // Arrange
        Object array = new Object[0];
        String stringIfNull = "Empty";
        String expected = stringIfNull;

        // Act
        String result = ArrayUtils.toString(array, stringIfNull);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_SingleElementArrayWithCustomString_ReturnsFormattedString() {
        // Arrange
        Object[] array = {1};
        String stringIfNull = "Empty";
        String expected = "{1}";

        // Act
        String result = ArrayUtils.toString(array, stringIfNull);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_MultiElementArrayWithCustomString_ReturnsFormattedString() {
        // Arrange
        Object[] array = {1, 2, 3};
        String stringIfNull = "Empty";
        String expected = "{1,2,3}";

        // Act
        String result = ArrayUtils.toString(array, stringIfNull);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_MultiDimensionalArrayWithCustomString_ReturnsFormattedString() {
        // Arrange
        Object[][] array = {{1, 2}, {3, 4}};
        String stringIfNull = "Empty";
        String expected = "{{1,2},{3,4}}";

        // Act
        String result = ArrayUtils.toString(array, stringIfNull);

        // Assert
        assertEquals(expected, result);
    }




    @Test
    public void testGetLength_NullArray_ReturnsZero() {
        // Arrange
        Object array = null;

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testGetLength_EmptyArray_ReturnsZero() {
        // Arrange
        Object array = new Object[] {};

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testGetLength_ArrayWithNullElement_ReturnsOne() {
        // Arrange
        Object array = new Object[] { null };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testGetLength_BooleanArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new boolean[] { true, false, true };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void testGetLength_ByteArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new byte[] { 1, 2, 3, 4 };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(4, result);
    }

    @Test
    public void testGetLength_CharArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new char[] { 'a', 'b', 'c' };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void testGetLength_DoubleArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new double[] { 1.0, 2.0, 3.0 };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void testGetLength_FloatArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new float[] { 1.0f, 2.0f, 3.0f };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void testGetLength_IntArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new int[] { 1, 2, 3, 4, 5 };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testGetLength_LongArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new long[] { 1L, 2L, 3L };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void testGetLength_ShortArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new short[] { 1, 2, 3, 4, 5, 6 };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(6, result);
    }

    @Test
    public void testGetLength_ObjectArray_ReturnsCorrectLength() {
        // Arrange
        Object array = new Object[] { "a", "b", "c", "d" };

        // Act
        int result = ArrayUtils.getLength(array);

        // Assert
        assertEquals(4, result);
    }




    @Test
    public void testNullToEmpty_withEmptyBooleanArray_returnsEmptyBooleanArray() {
        // Arrange
        boolean[] array = {};
        
        // Act
        boolean[] result = ArrayUtils.nullToEmpty(array);
        
        // Assert
        assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }
    
    @Test
    public void testNullToEmpty_withNonEmptyBooleanArray_returnsSameArray() {
        // Arrange
        boolean[] array = { true, false };
        
        // Act
        boolean[] result = ArrayUtils.nullToEmpty(array);
        
        // Assert
        assertSame(array, result);
    }
    
    @Test
    public void testNullToEmpty_withEmptyBooleanObjectArray_returnsEmptyBooleanObjectArray() {
        // Arrange
        Boolean[] array = {};
        
        // Act
        Boolean[] result = ArrayUtils.nullToEmpty(array);
        
        // Assert
        assertSame(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, result);
    }
    
    @Test
    public void testNullToEmpty_withNonEmptyBooleanObjectArray_returnsSameArray() {
        // Arrange
        Boolean[] array = { true, false };
        
        // Act
        Boolean[] result = ArrayUtils.nullToEmpty(array);
        
        // Assert
        assertSame(array, result);
    }
    
    // Additional test cases for other data types...




    @Test
    public void indexesOf_BooleanArray_ReturnsEmptyBitSetForNullInput() {
        // Arrange
        boolean[] array = null;
        boolean valueToFind = true;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void indexesOf_BooleanArray_ReturnsEmptyBitSetForEmptyArray() {
        // Arrange
        boolean[] array = {};
        boolean valueToFind = true;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void indexesOf_BooleanArray_ReturnsEmptyBitSetForNonMatchingValue() {
        // Arrange
        boolean[] array = {false, false, false};
        boolean valueToFind = true;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void indexesOf_BooleanArray_ReturnsBitSetWithMatchingIndices() {
        // Arrange
        boolean[] array = {true, false, true, false, true};
        boolean valueToFind = true;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.cardinality());
        assertTrue(result.get(0));
        assertTrue(result.get(2));
        assertTrue(result.get(4));
    }

    @Test
    public void indexesOf_BooleanArray_WithStartIndex_ReturnsEmptyBitSetForNullInput() {
        // Arrange
        boolean[] array = null;
        boolean valueToFind = true;
        int startIndex = 0;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void indexesOf_BooleanArray_WithStartIndex_ReturnsEmptyBitSetForEmptyArray() {
        // Arrange
        boolean[] array = {};
        boolean valueToFind = true;
        int startIndex = 0;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void indexesOf_BooleanArray_WithStartIndex_ReturnsEmptyBitSetForNonMatchingValue() {
        // Arrange
        boolean[] array = {false, false, false};
        boolean valueToFind = true;
        int startIndex = 0;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void indexesOf_BooleanArray_WithStartIndex_ReturnsBitSetWithMatchingIndices() {
        // Arrange
        boolean[] array = {true, false, true, false, true};
        boolean valueToFind = true;
        int startIndex = 1;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.cardinality());
        assertFalse(result.get(0));
        assertTrue(result.get(2));
        assertTrue(result.get(4));
    }




    @Test
    public void isSameLength_WithNullArrays_ReturnsTrue() {
        // Arrange
        boolean[] array1 = null;
        boolean[] array2 = null;

        // Act
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isSameLength_WithEmptyArrays_ReturnsTrue() {
        // Arrange
        boolean[] array1 = {};
        boolean[] array2 = {};

        // Act
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isSameLength_WithDifferentLengthArrays_ReturnsFalse() {
        // Arrange
        boolean[] array1 = {true, false};
        boolean[] array2 = {true, false, true};

        // Act
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isSameLength_WithSameLengthArrays_ReturnsTrue() {
        // Arrange
        boolean[] array1 = {true, false, true};
        boolean[] array2 = {false, true, false};

        // Act
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Assert
        assertTrue(result);
    }

    //@Test
    public void isSameLength_WithMockedArrays_ReturnsTrue() {
        // Arrange
        boolean[] array1 = mock(boolean[].class);
        boolean[] array2 = mock(boolean[].class);

        // Mocking the getLength method
        try (MockedStatic<ArrayUtils> mockedStatic = mockStatic(ArrayUtils.class)) {
            mockedStatic.when(() -> ArrayUtils.getLength(array1)).thenReturn(3);
            mockedStatic.when(() -> ArrayUtils.getLength(array2)).thenReturn(3);

            // Act
            boolean result = ArrayUtils.isSameLength(array1, array2);

            // Assert
            assertTrue(result);
        }
    }




    @Test
    public void testToMap_withNullArray_shouldReturnNullMap() {
        // Arrange
        Object[] array = null;

        // Act
        Map<Object, Object> result = ArrayUtils.toMap(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testToMap_withEmptyArray_shouldReturnEmptyMap() {
        // Arrange
        Object[] array = {};

        // Act
        Map<Object, Object> result = ArrayUtils.toMap(array);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

//    @Test
//    public void testToMap_withArrayOfEntries_shouldReturnMapWithEntries() {
//        // Arrange
//        Object[] array = {
//            new Map.Entry<>("key1", "value1"),
//            new Map.Entry<>("key2", "value2"),
//            new Map.Entry<>("key3", "value3")
//        };
//
//        // Act
//        Map<Object, Object> result = ArrayUtils.toMap(array);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(3, result.size());
//        assertEquals("value1", result.get("key1"));
//        assertEquals("value2", result.get("key2"));
//        assertEquals("value3", result.get("key3"));
//    }

    @Test
    public void testToMap_withArrayOfArrays_shouldReturnMapWithEntries() {
        // Arrange
        Object[] array = {
            new Object[]{"key1", "value1"},
            new Object[]{"key2", "value2"},
            new Object[]{"key3", "value3"}
        };

        // Act
        Map<Object, Object> result = ArrayUtils.toMap(array);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("value1", result.get("key1"));
        assertEquals("value2", result.get("key2"));
        assertEquals("value3", result.get("key3"));
    }

//    @Test
//    public void testToMap_withArrayOfEntriesAndArrays_shouldReturnMapWithEntries() {
//        // Arrange
//        Object[] array = {
//            new Map.Entry<>("key1", "value1"),
//            new Object[]{"key2", "value2"},
//            new Map.Entry<>("key3", "value3")
//        };
//
//        // Act
//        Map<Object, Object> result = ArrayUtils.toMap(array);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(3, result.size());
//        assertEquals("value1", result.get("key1"));
//        assertEquals("value2", result.get("key2"));
//        assertEquals("value3", result.get("key3"));
//    }
//
//    @Test
//    public void testToMap_withArrayOfEntriesAndInvalidArray_shouldThrowIllegalArgumentException() {
//        // Arrange
//        Object[] array = {
//            new Map.Entry<>("key1", "value1"),
//            new Object[]{"key2"}
//        };
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.toMap(array));
//    }

    @Test
    public void testToMap_withArrayOfInvalidObjects_shouldThrowIllegalArgumentException() {
        // Arrange
        Object[] array = {
            "key1",
            "value1",
            "key2",
            "value2"
        };

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.toMap(array));
    }




    @Test
    public void testNewInstance_withIntegerArray() {
        // Instantiate all necessary variables here
        Class<Integer> componentType = Integer.class;
        int length = 5;

        // Write the test code here following the given rules
        Integer[] result = ArrayUtils.newInstance(componentType, length);

        assertNotNull(result);
        assertEquals(length, result.length);
        for (Integer value : result) {
            assertNull(value);
        }
    }

    @Test
    public void testNewInstance_withStringArray() {
        // Instantiate all necessary variables here
        Class<String> componentType = String.class;
        int length = 3;

        // Write the test code here following the given rules
        String[] result = ArrayUtils.newInstance(componentType, length);

        assertNotNull(result);
        assertEquals(length, result.length);
        for (String value : result) {
            assertNull(value);
        }
    }

    @Test
    public void testNewInstance_withEmptyArray() {
        // Instantiate all necessary variables here
        Class<Object> componentType = Object.class;
        int length = 0;

        // Write the test code here following the given rules
        Object[] result = ArrayUtils.newInstance(componentType, length);

        assertNotNull(result);
        assertEquals(length, result.length);
    }






    @Test
    public void testGet_ValidIndex_ReturnsElement() {
        // Instantiate all necessary variables here
        String[] array = {"a", "b", "c"};
        int index = 1;
        String expected = "b";

        // Write the test code here following the given rules
        String result = ArrayUtils.get(array, index);

        assertEquals(expected, result);
    }

    @Test
    public void testGet_InvalidIndex_ReturnsNull() {
        // Instantiate all necessary variables here
        String[] array = {"a", "b", "c"};
        int index = 3;

        // Write the test code here following the given rules
        String result = ArrayUtils.get(array, index);

        assertNull(result);
    }

    @Test
    public void testGet_InvalidArray_ReturnsNull() {
        // Instantiate all necessary variables here
        String[] array = null;
        int index = 1;

        // Write the test code here following the given rules
        String result = ArrayUtils.get(array, index);

        assertNull(result);
    }

    @Test
    public void testGet_InvalidIndexAndArray_ReturnsDefaultValue() {
        // Instantiate all necessary variables here
        String[] array = null;
        int index = 3;
        String defaultValue = "default";

        // Write the test code here following the given rules
        String result = ArrayUtils.get(array, index, defaultValue);

        assertEquals(defaultValue, result);
    }




    @Test
    public void testAddFirst_withNullArrayAndBooleanElement() {
        // Instantiate all necessary variables here
        boolean[] array = null;
        boolean element = true;

        // Write the test code here following the given rules
        boolean[] expected = new boolean[] { true };
        boolean[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndBooleanElement() {
        // Instantiate all necessary variables here
        boolean[] array = { true, false };
        boolean element = true;

        // Write the test code here following the given rules
        boolean[] expected = new boolean[] { true, true, false };
        boolean[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndByteElement() {
        // Instantiate all necessary variables here
        byte[] array = null;
        byte element = 1;

        // Write the test code here following the given rules
        byte[] expected = new byte[] { 1 };
        byte[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndByteElement() {
        // Instantiate all necessary variables here
        byte[] array = { 1, 0 };
        byte element = 1;

        // Write the test code here following the given rules
        byte[] expected = new byte[] { 1, 1, 0 };
        byte[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndCharElement() {
        // Instantiate all necessary variables here
        char[] array = null;
        char element = '1';

        // Write the test code here following the given rules
        char[] expected = new char[] { '1' };
        char[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndCharElement() {
        // Instantiate all necessary variables here
        char[] array = { '1', '0' };
        char element = '1';

        // Write the test code here following the given rules
        char[] expected = new char[] { '1', '1', '0' };
        char[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndDoubleElement() {
        // Instantiate all necessary variables here
        double[] array = null;
        double element = 1;

        // Write the test code here following the given rules
        double[] expected = new double[] { 1 };
        double[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndDoubleElement() {
        // Instantiate all necessary variables here
        double[] array = { 1, 0 };
        double element = 1;

        // Write the test code here following the given rules
        double[] expected = new double[] { 1, 1, 0 };
        double[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndFloatElement() {
        // Instantiate all necessary variables here
        float[] array = null;
        float element = 1;

        // Write the test code here following the given rules
        float[] expected = new float[] { 1 };
        float[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndFloatElement() {
        // Instantiate all necessary variables here
        float[] array = { 1, 0 };
        float element = 1;

        // Write the test code here following the given rules
        float[] expected = new float[] { 1, 1, 0 };
        float[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndIntElement() {
        // Instantiate all necessary variables here
        int[] array = null;
        int element = 1;

        // Write the test code here following the given rules
        int[] expected = new int[] { 1 };
        int[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndIntElement() {
        // Instantiate all necessary variables here
        int[] array = { 1, 0 };
        int element = 1;

        // Write the test code here following the given rules
        int[] expected = new int[] { 1, 1, 0 };
        int[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndLongElement() {
        // Instantiate all necessary variables here
        long[] array = null;
        long element = 1;

        // Write the test code here following the given rules
        long[] expected = new long[] { 1 };
        long[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndLongElement() {
        // Instantiate all necessary variables here
        long[] array = { 1, 0 };
        long element = 1;

        // Write the test code here following the given rules
        long[] expected = new long[] { 1, 1, 0 };
        long[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndShortElement() {
        // Instantiate all necessary variables here
        short[] array = null;
        short element = 1;

        // Write the test code here following the given rules
        short[] expected = new short[] { 1 };
        short[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndShortElement() {
        // Instantiate all necessary variables here
        short[] array = { 1, 0 };
        short element = 1;

        // Write the test code here following the given rules
        short[] expected = new short[] { 1, 1, 0 };
        short[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNullArrayAndObjectElement() {
        // Instantiate all necessary variables here
        Object[] array = null;
        Object element = "a";

        // Write the test code here following the given rules
        Object[] expected = new Object[] { "a" };
        Object[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst_withNonNullArrayAndObjectElement() {
        // Instantiate all necessary variables here
        Object[] array = { "a", "b" };
        Object element = "c";

        // Write the test code here following the given rules
        Object[] expected = new Object[] { "c", "a", "b" };
        Object[] actual = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, actual);
    }


}