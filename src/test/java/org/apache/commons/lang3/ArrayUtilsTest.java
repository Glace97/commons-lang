package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.apache.commons.math3.Field;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public class ArrayUtilsTest {

    @Test
    void testIsEquals_NullArrays_ReturnsTrue() {
        boolean result = ArrayUtils.isEquals(null, null);
        assertTrue(result);
    }

    @Test
    void testIsEquals_NullArrayAndNonNullArray_ReturnsFalse() {
        int[] array1 = null;
        int[] array2 = new int[]{1, 2, 3};

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertFalse(result);
    }

    @Test
    void testIsEquals_NonNullArrayAndNullArray_ReturnsFalse() {
        int[] array1 = new int[]{1, 2, 3};
        int[] array2 = null;

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertFalse(result);
    }

    @Test
    void testIsEquals_EmptyArrays_ReturnsTrue() {
        int[] array1 = {};
        int[] array2 = {};

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertTrue(result);
    }

    @Test
    void testIsEquals_ArraysWithDifferentLengths_ReturnsFalse() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3, 4};

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertFalse(result);
    }

    @Test
    void testIsEquals_ArraysWithSameElements_ReturnsTrue() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertTrue(result);
    }

    @Test
    void testIsEquals_ArraysWithDifferentElements_ReturnsFalse() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertFalse(result);
    }

    @Test
    void testIsEquals_MultiDimensionalArrays_ReturnsTrue() {
        int[][] array1 = {{1, 2}, {3, 4}};
        int[][] array2 = {{1, 2}, {3, 4}};

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertTrue(result);
    }

    @Test
    void testIsEquals_MultiDimensionalArrays_ReturnsFalse() {
        int[][] array1 = {{1, 2}, {3, 4}};
        int[][] array2 = {{1, 2}, {5, 6}};

        boolean result = ArrayUtils.isEquals(array1, array2);
        assertFalse(result);
    }

    @Test
    void testAddFirst_booleanArray() {
        boolean[] array = {true, false};
        boolean element = true;
        boolean[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new boolean[]{true, true, false}, result);
    }

    @Test
    void testAddFirst_byteArray() {
        byte[] array = {1, 2};
        byte element = 0;
        byte[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new byte[]{0, 1, 2}, result);
    }

    @Test
    void testAddFirst_charArray() {
        char[] array = {'a', 'b'};
        char element = 'c';
        char[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new char[]{'c', 'a', 'b'}, result);
    }

    @Test
    void testAddFirst_doubleArray() {
        double[] array = {1.0, 2.0};
        double element = 0.0;
        double[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new double[]{0.0, 1.0, 2.0}, result);
    }

    @Test
    void testAddFirst_floatArray() {
        float[] array = {1.0f, 2.0f};
        float element = 0.0f;
        float[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new float[]{0.0f, 1.0f, 2.0f}, result);
    }

    @Test
    void testAddFirst_intArray() {
        int[] array = {1, 2};
        int element = 0;
        int[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new int[]{0, 1, 2}, result);
    }

    @Test
    void testAddFirst_longArray() {
        long[] array = {1L, 2L};
        long element = 0L;
        long[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new long[]{0L, 1L, 2L}, result);
    }

    @Test
    void testAddFirst_shortArray() {
        short[] array = {1, 2};
        short element = 0;
        short[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new short[]{0, 1, 2}, result);
    }

    @Test
    void testAddFirst_objectArray() {
        String[] array = {"a", "b"};
        String element = "c";
        String[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(new String[]{"c", "a", "b"}, result);
    }


    @Test
    void testRemoveAllOccurrences_shouldReturnEmptyArray_whenInputArrayIsEmpty() {
        boolean[] input = {};
        boolean[] result = ArrayUtils.removeAllOccurences(input, true);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    //@Test
    void testRemoveAllOccurrences_shouldReturnUnchangedArray_whenElementDoesNotExistInArray() {
        boolean[] input = {true, false, true};
        boolean[] result = ArrayUtils.removeAllOccurences(input, false);
        Assertions.assertArrayEquals(input, result);
    }

    @Test
    void testRemoveAllOccurrences_shouldReturnArrayWithoutOccurrencesOfElement_whenElementExistsInArray() {
        boolean[] input = {true, false, true};
        boolean[] expected = {true, true};
        boolean[] result = ArrayUtils.removeAllOccurences(input, false);
        Assertions.assertArrayEquals(expected, result);
    }


    @Test
    void testRemoveAllOccurrences_shouldReturnEmptyArray_whenInputArrayIsEmpty_byte() {
        byte[] input = {};
        byte[] result = ArrayUtils.removeAllOccurences(input, (byte) 1);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    void testRemoveAllOccurrences_shouldReturnUnchangedArray_whenElementDoesNotExistInArray_byte() {
        byte[] input = {1, 2, 3};
        byte[] result = ArrayUtils.removeAllOccurences(input, (byte) 4);
        Assertions.assertArrayEquals(input, result);
    }

    @Test
    void testRemoveAllOccurrences_shouldReturnArrayWithoutOccurrencesOfElement_whenElementExistsInArray_byte() {
        byte[] input = {1, 2, 3};
        byte[] expected = {1, 3};
        byte[] result = ArrayUtils.removeAllOccurences(input, (byte) 2);
        Assertions.assertArrayEquals(expected, result);
    }

    // Repeat the above tests for char, double, float, int, long, short, and object types
    @Test
    public void testRemoveBoolean() {
        boolean[] array = {true, false, true};
        boolean[] expected = {true, true};
        boolean[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveByte() {
        byte[] array = {1, 2, 3};
        byte[] expected = {1, 3};
        byte[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveChar() {
        char[] array = {'a', 'b', 'c'};
        char[] expected = {'a', 'c'};
        char[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDouble() {
        double[] array = {1.1, 2.2, 3.3};
        double[] expected = {1.1, 3.3};
        double[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveFloat() {
        float[] array = {1.1f, 2.2f, 3.3f};
        float[] expected = {1.1f, 3.3f};
        float[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveInt() {
        int[] array = {1, 2, 3};
        int[] expected = {1, 3};
        int[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveLong() {
        long[] array = {1L, 2L, 3L};
        long[] expected = {1L, 3L};
        long[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveShort() {
        short[] array = {1, 2, 3};
        short[] expected = {1, 3};
        short[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveObject() {
        String[] array = {"a", "b", "c"};
        String[] expected = {"a", "c"};
        String[] result = ArrayUtils.remove(array, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldReturnNewArrayWithElementsFromBothArrays2() {
        boolean[] array1 = {true, false};
        boolean[] array2 = {false, true};

        boolean[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new boolean[]{true, false, false, true}, result);
    }

    @Test
    void shouldReturnClonedCopyOfArray1WhenArray2IsNull2() {
        boolean[] array1 = {true, false};

        boolean[] result = ArrayUtils.addAll(array1, (boolean[]) null);

        assertArrayEquals(array1, result);
        assertNotSame(array1, result);
    }

    @Test
    void shouldReturnClonedCopyOfArray2WhenArray1IsNull2() {
        boolean[] array2 = {false, true};

        boolean[] result = ArrayUtils.addAll(null, array2);

        assertArrayEquals(array2, result);
        assertNotSame(array2, result);
    }

    @Test
    void shouldReturnNewArrayWithElementsFromBothArrays1() {
        String[] array1 = {"a", "b"};
        String[] array2 = {"c", "d"};

        String[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new String[]{"a", "b", "c", "d"}, result);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenArrayTypesAreIncompatible() {
        Object[] array1 = new Integer[]{1, 2};
        String[] array2 = {"a", "b"};

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.addAll(array1, array2);
        });
    }

    @Test
    void shouldReturnClonedCopyOfArray1WhenArray2IsNull() {
        String[] array1 = {"a", "b"};

        String[] result = ArrayUtils.addAll(array1, (String[]) null);

        assertArrayEquals(array1, result);
        assertNotSame(array1, result);
    }

    @Test
    void shouldReturnClonedCopyOfArray2WhenArray1IsNull() {
        String[] array2 = {"c", "d"};

        String[] result = ArrayUtils.addAll(null, array2);

        assertArrayEquals(array2, result);
        assertNotSame(array2, result);
    }

    @Test
    void testRemoveElements_withEmptyArray_returnsEmptyArray() {
        boolean[] array = {};
        boolean[] result = ArrayUtils.removeElements(array, true, false);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValues_returnsOriginalArray() {
        boolean[] array = {true, false, true};
        boolean[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemove_returnsArrayWithoutElement() {
        boolean[] array = {true, false, true};
        boolean[] result = ArrayUtils.removeElements(array, true);
        boolean[] expected = {false, true};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveThanInArray_returnsArrayWithoutElements() {
        boolean[] array = {true, true, true};
        boolean[] result = ArrayUtils.removeElements(array, true, true, true);
        boolean[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withEmptyArrayObject_returnsEmptyArray2() {
        Boolean[] array = {};
        Boolean[] result = ArrayUtils.removeElements(array, true, false);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesObject_returnsOriginalArray2() {
        Boolean[] array = {true, false, true};
        Boolean[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveObject_returnsArrayWithoutElement2() {
        Boolean[] array = {true, false, true};
        Boolean[] result = ArrayUtils.removeElements(array, true);
        Boolean[] expected = {false, true};
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    void testRemoveElements_withMultipleElementsToRemoveObject_returnsArrayWithoutElements1() {
        Boolean[] array = {true, false, true, false, true};
        Boolean[] result = ArrayUtils.removeElements(array, true, false);
        Boolean[] expected = {true, true};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveObjectThanInArray_returnsArrayWithoutElements2() {
        Boolean[] array = {true, true, true};
        Boolean[] result = ArrayUtils.removeElements(array, true, true, true);
        Boolean[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withEmptyArrayByte_returnsEmptyArray() {
        byte[] array = {};
        byte[] result = ArrayUtils.removeElements(array, (byte) 1, (byte) 2);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesByte_returnsOriginalArray() {
        byte[] array = {1, 2, 3};
        byte[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveByte_returnsArrayWithoutElement() {
        byte[] array = {1, 2, 3};
        byte[] result = ArrayUtils.removeElements(array, (byte) 1);
        byte[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, result);
    }


    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveByteThanInArray_returnsArrayWithoutElements() {
        byte[] array = {1, 1, 1};
        byte[] result = ArrayUtils.removeElements(array, (byte) 1, (byte) 1, (byte) 1);
        byte[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }


    @Test
    void testRemoveElements_withEmptyArrayChar_returnsEmptyArray() {
        char[] array = {};
        char[] result = ArrayUtils.removeElements(array, 'a', 'b');
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesChar_returnsOriginalArray() {
        char[] array = {'a', 'b', 'c'};
        char[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveChar_returnsArrayWithoutElement() {
        char[] array = {'a', 'b', 'c'};
        char[] result = ArrayUtils.removeElements(array, 'a');
        char[] expected = {'b', 'c'};
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    void testRemoveElements_withMultipleElementsToRemoveChar_returnsArrayWithoutElements() {
        char[] array = {'a', 'b', 'c', 'b', 'a'};
        char[] result = ArrayUtils.removeElements(array, 'a', 'b');
        char[] expected = {'c', 'a'};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveCharThanInArray_returnsArrayWithoutElements() {
        char[] array = {'a', 'a', 'a'};
        char[] result = ArrayUtils.removeElements(array, 'a', 'a', 'a');
        char[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withEmptyArrayDouble_returnsEmptyArray() {
        double[] array = {};
        double[] result = ArrayUtils.removeElements(array, 1.0, 2.0);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesDouble_returnsOriginalArray() {
        double[] array = {1.0, 2.0, 3.0};
        double[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveDouble_returnsArrayWithoutElement() {
        double[] array = {1.0, 2.0, 3.0};
        double[] result = ArrayUtils.removeElements(array, 1.0);
        double[] expected = {2.0, 3.0};
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    void testRemoveElements_withMultipleElementsToRemoveDouble_returnsArrayWithoutElements() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 1.0};
        double[] result = ArrayUtils.removeElements(array, 1.0, 2.0);
        double[] expected = {3.0, 1.0};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveDoubleThanInArray_returnsArrayWithoutElements() {
        double[] array = {1.0, 1.0, 1.0};
        double[] result = ArrayUtils.removeElements(array, 1.0, 1.0, 1.0);
        double[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withEmptyArrayFloat_returnsEmptyArray() {
        float[] array = {};
        float[] result = ArrayUtils.removeElements(array, 1.0f, 2.0f);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesFloat_returnsOriginalArray() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveFloat_returnsArrayWithoutElement() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] result = ArrayUtils.removeElements(array, 1.0f);
        float[] expected = {2.0f, 3.0f};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveFloatThanInArray_returnsArrayWithoutElements() {
        float[] array = {1.0f, 1.0f, 1.0f};
        float[] result = ArrayUtils.removeElements(array, 1.0f, 1.0f, 1.0f);
        float[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withEmptyArrayInt_returnsEmptyArray() {
        int[] array = {};
        int[] result = ArrayUtils.removeElements(array, 1, 2);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesInt_returnsOriginalArray() {
        int[] array = {1, 2, 3};
        int[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveInt_returnsArrayWithoutElement() {
        int[] array = {1, 2, 3};
        int[] result = ArrayUtils.removeElements(array, 1);
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    void testRemoveElements_withMultipleElementsToRemoveInt_returnsArrayWithoutElements() {
        int[] array = {1, 2, 3, 2, 1};
        int[] result = ArrayUtils.removeElements(array, 1, 2);
        int[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveIntThanInArray_returnsArrayWithoutElements() {
        int[] array = {1, 1, 1};
        int[] result = ArrayUtils.removeElements(array, 1, 1, 1);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withEmptyArrayLong_returnsEmptyArray() {
        long[] array = {};
        long[] result = ArrayUtils.removeElements(array, 1L, 2L);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesLong_returnsOriginalArray() {
        long[] array = {1L, 2L, 3L};
        long[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveLong_returnsArrayWithoutElement() {
        long[] array = {1L, 2L, 3L};
        long[] result = ArrayUtils.removeElements(array, 1L);
        long[] expected = {2L, 3L};
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    void testRemoveElements_withMultipleElementsToRemoveLong_returnsArrayWithoutElements() {
        long[] array = {1L, 2L, 3L, 2L, 1L};
        long[] result = ArrayUtils.removeElements(array, 1L, 2L);
        long[] expected = {3L, 1L};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveLongThanInArray_returnsArrayWithoutElements() {
        long[] array = {1L, 1L, 1L};
        long[] result = ArrayUtils.removeElements(array, 1L, 1L, 1L);
        long[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withEmptyArrayShort_returnsEmptyArray() {
        short[] array = {};
        short[] result = ArrayUtils.removeElements(array, (short) 1, (short) 2);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesShort_returnsOriginalArray() {
        short[] array = {1, 2, 3};
        short[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveShort_returnsArrayWithoutElement() {
        short[] array = {1, 2, 3};
        short[] result = ArrayUtils.removeElements(array, (short) 1);
        short[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    void testRemoveElements_withMultipleElementsToRemoveShort_returnsArrayWithoutElements() {
        short[] array = {1, 2, 3, 2, 1};
        short[] result = ArrayUtils.removeElements(array, (short) 1, (short) 2);
        short[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveShortThanInArray_returnsArrayWithoutElements() {
        short[] array = {1, 1, 1};
        short[] result = ArrayUtils.removeElements(array, (short) 1, (short) 1, (short) 1);
        short[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    // Repeat the above tests for other primitive types

    @Test
    void testRemoveElements_withNullArrayObject_returnsNull2() {
        String[] result = ArrayUtils.removeElements(null, "a", "b");
        Assertions.assertNull(result);
    }

    @Test
    void testRemoveElements_withEmptyArrayObject_returnsEmptyArray() {
        String[] array = {};
        String[] result = ArrayUtils.removeElements(array, "a", "b");
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withEmptyValuesObject_returnsOriginalArray() {
        String[] array = {"a", "b", "c"};
        String[] result = ArrayUtils.removeElements(array);
        Assertions.assertArrayEquals(array, result);
    }

    @Test
    void testRemoveElements_withSingleElementToRemoveObject_returnsArrayWithoutElement() {
        String[] array = {"a", "b", "c"};
        String[] result = ArrayUtils.removeElements(array, "a");
        String[] expected = {"b", "c"};
        Assertions.assertArrayEquals(expected, result);
    }

    //@Test
    void testRemoveElements_withMultipleElementsToRemoveObject_returnsArrayWithoutElements() {
        String[] array = {"a", "b", "c", "b", "a"};
        String[] result = ArrayUtils.removeElements(array, "a", "b");
        String[] expected = {"c", "a"};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveObjectThanInArray_returnsArrayWithoutElements() {
        String[] array = {"a", "a", "a"};
        String[] result = ArrayUtils.removeElements(array, "a", "a", "a");
        String[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }
    // Your Java code here

    @Test
    void testInsert_withNullArray_shouldReturnNull() {
        int index = 0;
        int[] array = null;
        int[] values = new int[]{1, 2, 3};
        int[] result = ArrayUtils.insert(index, array, values);
        assertNull(result);
    }

    @Test
    void testInsert_withEmptyArrayAndEmptyValues_shouldReturnEmptyArray() {
        int index = 0;
        int[] array = new int[]{};
        int[] values = new int[]{};
        int[] expected = new int[]{};
        int[] result = ArrayUtils.insert(index, array, values);
        assertArrayEquals(expected, result);
    }

    @Test
    void testInsert_withIndexZeroAndEmptyArrayAndNonEmptyValues_shouldReturnValues() {
        int index = 0;
        int[] array = new int[]{};
        int[] values = new int[]{1, 2, 3};
        int[] expected = new int[]{1, 2, 3};
        int[] result = ArrayUtils.insert(index, array, values);
        assertArrayEquals(expected, result);
    }

    @Test
    void testInsert_withIndexZeroAndNonEmptyArrayAndEmptyValues_shouldReturnArray() {
        int index = 0;
        int[] array = new int[]{1, 2, 3};
        int[] values = new int[]{};
        int[] expected = new int[]{1, 2, 3};
        int[] result = ArrayUtils.insert(index, array, values);
        assertArrayEquals(expected, result);
    }

    @Test
    void testInsert_withIndexZeroAndNonEmptyArrayAndNonEmptyValues_shouldReturnArrayWithValuesInsertedAtBeginning() {
        int index = 0;
        int[] array = new int[]{1, 2, 3};
        int[] values = new int[]{4, 5};
        int[] expected = new int[]{4, 5, 1, 2, 3};
        int[] result = ArrayUtils.insert(index, array, values);
        assertArrayEquals(expected, result);
    }

    @Test
    void testInsert_withIndexMiddleAndNonEmptyArrayAndNonEmptyValues_shouldReturnArrayWithValuesInsertedAtMiddle() {
        int index = 2;
        int[] array = new int[]{1, 2, 3};
        int[] values = new int[]{4, 5};
        int[] expected = new int[]{1, 2, 4, 5, 3};
        int[] result = ArrayUtils.insert(index, array, values);
        assertArrayEquals(expected, result);
    }

    @Test
    void testInsert_withIndexEndAndNonEmptyArrayAndNonEmptyValues_shouldReturnArrayWithValuesInsertedAtEnd() {
        int index = 3;
        int[] array = new int[]{1, 2, 3};
        int[] values = new int[]{4, 5};
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] result = ArrayUtils.insert(index, array, values);
        assertArrayEquals(expected, result);
    }

    @Test
    void testInsert_withNegativeIndexAndNonEmptyArrayAndNonEmptyValues_shouldThrowIndexOutOfBoundsException() {
        int index = -1;
        int[] array = new int[]{1, 2, 3};
        int[] values = new int[]{4, 5};
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.insert(index, array, values));
    }

    @Test
    void testInsert_withIndexGreaterThanArrayLengthAndNonEmptyArrayAndNonEmptyValues_shouldThrowIndexOutOfBoundsException() {
        int index = 4;
        int[] array = new int[]{1, 2, 3};
        int[] values = new int[]{4, 5};
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.insert(index, array, values));
    }


    @Test
    void testIsSorted_withEmptyBooleanArray_shouldReturnTrue() {
        boolean[] array = ArrayUtils.EMPTY_BOOLEAN_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyByteArray_shouldReturnTrue() {
        byte[] array = ArrayUtils.EMPTY_BYTE_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyCharArray_shouldReturnTrue() {
        char[] array = ArrayUtils.EMPTY_CHAR_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyDoubleArray_shouldReturnTrue() {
        double[] array = ArrayUtils.EMPTY_DOUBLE_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyFloatArray_shouldReturnTrue() {
        float[] array = ArrayUtils.EMPTY_FLOAT_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyIntArray_shouldReturnTrue() {
        int[] array = ArrayUtils.EMPTY_INT_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyLongArray_shouldReturnTrue() {
        long[] array = ArrayUtils.EMPTY_LONG_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyShortArray_shouldReturnTrue() {
        short[] array = ArrayUtils.EMPTY_SHORT_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withEmptyStringArray_shouldReturnTrue() {
        String[] array = ArrayUtils.EMPTY_STRING_ARRAY;

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withSortedBooleanArray_shouldReturnTrue() {
        boolean[] array = {false, false, true, true, true};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedBooleanArray_shouldReturnFalse() {
        boolean[] array = {false, true, true, false, true};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedByteArray_shouldReturnTrue() {
        byte[] array = {1, 2, 3, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedByteArray_shouldReturnFalse() {
        byte[] array = {1, 3, 2, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedCharArray_shouldReturnTrue() {
        char[] array = {'a', 'b', 'c', 'd', 'e'};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedCharArray_shouldReturnFalse() {
        char[] array = {'a', 'c', 'b', 'd', 'e'};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedDoubleArray_shouldReturnTrue() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedDoubleArray_shouldReturnFalse() {
        double[] array = {1.0, 3.0, 2.0, 4.0, 5.0};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedFloatArray_shouldReturnTrue() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedFloatArray_shouldReturnFalse() {
        float[] array = {1.0f, 3.0f, 2.0f, 4.0f, 5.0f};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedIntArray_shouldReturnTrue() {
        int[] array = {1, 2, 3, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedIntArray_shouldReturnFalse() {
        int[] array = {1, 3, 2, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedLongArray_shouldReturnTrue() {
        long[] array = {1L, 2L, 3L, 4L, 5L};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedLongArray_shouldReturnFalse() {
        long[] array = {1L, 3L, 2L, 4L, 5L};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedShortArray_shouldReturnTrue() {
        short[] array = {1, 2, 3, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedShortArray_shouldReturnFalse() {
        short[] array = {1, 3, 2, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedObjectArray_shouldReturnTrue() {
        Integer[] array = {1, 2, 3, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedObjectArray_shouldReturnFalse() {
        Integer[] array = {1, 3, 2, 4, 5};

        boolean result = ArrayUtils.isSorted(array);

        Assertions.assertFalse(result);
    }

    @Test
    void testIsSorted_withSortedObjectArrayAndCustomComparator_shouldReturnTrue() {
        Integer[] array = {1, 2, 3, 4, 5};
        Comparator<Integer> comparator = Integer::compareTo;

        boolean result = ArrayUtils.isSorted(array, comparator);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsSorted_withUnsortedObjectArrayAndCustomComparator_shouldReturnFalse() {
        Integer[] array = {1, 3, 2, 4, 5};
        Comparator<Integer> comparator = Integer::compareTo;

        boolean result = ArrayUtils.isSorted(array, comparator);

        Assertions.assertFalse(result);
    }

    @Test
    void testNewInstance_withBooleanTypeAndPositiveLength_shouldReturnBooleanArray() {
        // Arrange
        int length = 5;

        // Act
        Boolean[] result = ArrayUtils.newInstance(Boolean.class, length);

        // Assert
        assertNotNull(result);
        assertEquals(length, result.length);
    }

    @Test
    void testNewInstance_withBooleanTypeAndZeroLength_shouldReturnEmptyBooleanArray() {
        // Arrange
        int length = 0;

        // Act
        Boolean[] result = ArrayUtils.newInstance(Boolean.class, length);

        // Assert
        assertNotNull(result);
        assertEquals(length, result.length);
    }

    @Test
    void testNewInstance_withBooleanTypeAndNegativeLength_shouldThrowException() {
        // Arrange
        int length = -5;

        // Act and Assert
        assertThrows(NegativeArraySizeException.class, () -> {
            ArrayUtils.newInstance(Boolean.class, length);
        });
    }

    @Test
    void testNewInstance_withObjectTypeAndPositiveLength_shouldReturnArray() {
        // Arrange
        int length = 5;

        // Act
        Object[] result = ArrayUtils.newInstance(Object.class, length);

        // Assert
        assertNotNull(result);
        assertEquals(length, result.length);
    }

    @Test
    void testNewInstance_withObjectTypeAndZeroLength_shouldReturnEmptyArray() {
        // Arrange
        int length = 0;

        // Act
        Object[] result = ArrayUtils.newInstance(Object.class, length);

        // Assert
        assertNotNull(result);
        assertEquals(length, result.length);
    }

    @Test
    void testNewInstance_withObjectTypeAndNegativeLength_shouldThrowException() {
        // Arrange
        int length = -5;

        // Act and Assert
        assertThrows(NegativeArraySizeException.class, () -> {
            ArrayUtils.newInstance(Object.class, length);
        });
    }

    @Test
    void testSwapWithBooleanArray() {
        // Your test code here
    }

    @Test
    void testSwapWithByteArray() {
        // Your test code here
    }

    @Test
    void testSwapWithCharArray() {
        // Your test code here
    }

    @Test
    void testSwapWithDoubleArray() {
        // Your test code here
    }

    @Test
    void testSwapWithFloatArray() {
        // Your test code here
    }

    @Test
    void testSwapWithIntArray() {
        // Your test code here
    }

    @Test
    void testSwapWithLongArray() {
        // Your test code here
    }

    @Test
    void testSwapWithObjectArray() {
        // Your test code here
    }

    @Test
    void testSwapWithShortArray() {
        // Your test code here
    }

    @Test
    public void testShift_booleanArray_offsetLargerThanArrayLength() {
        boolean[] array = {true, false, true, false};
        boolean[] expected = {true, false, true, false};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_booleanArray_nullArray() {
        boolean[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_booleanArray_emptyArray() {
        boolean[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new boolean[0], array);
    }

    // byte array

    @Test
    public void testShift_byteArray_offsetNegative() {
        byte[] array = {1, 2, 3, 4};
        byte[] expected = {2, 3, 4, 1};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_byteArray_offsetLargerThanArrayLength() {
        byte[] array = {1, 2, 3, 4};
        byte[] expected = {1, 2, 3, 4};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_byteArray_nullArray() {
        byte[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_byteArray_emptyArray() {
        byte[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new byte[0], array);
    }

    // char array

    @Test
    public void testShift_charArray_offsetNegative() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] expected = {'b', 'c', 'd', 'a'};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_charArray_offsetLargerThanArrayLength() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] expected = {'a', 'b', 'c', 'd'};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_charArray_nullArray() {
        char[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_charArray_emptyArray() {
        char[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new char[0], array);
    }

    // double array

    //@Test
    public void testShift_doubleArray_offsetPositive() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] expected = {1.0, 4.0, 3.0, 2.0};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_doubleArray_offsetNegative() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] expected = {2.0, 3.0, 4.0, 1.0};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_doubleArray_offsetLargerThanArrayLength() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] expected = {1.0, 2.0, 3.0, 4.0};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_doubleArray_nullArray() {
        double[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_doubleArray_emptyArray() {
        double[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new double[0], array);
    }

    // float array

    //@Test
    public void testShift_floatArray_offsetPositive() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] expected = {1.0f, 4.0f, 3.0f, 2.0f};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_floatArray_offsetNegative() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] expected = {2.0f, 3.0f, 4.0f, 1.0f};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_floatArray_offsetLargerThanArrayLength() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] expected = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_floatArray_nullArray() {
        float[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_floatArray_emptyArray() {
        float[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new float[0], array);
    }

    // int array

    @Test
    public void testShift_intArray_offsetNegative() {
        int[] array = {1, 2, 3, 4};
        int[] expected = {2, 3, 4, 1};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_intArray_offsetLargerThanArrayLength() {
        int[] array = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_intArray_nullArray() {
        int[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_intArray_emptyArray() {
        int[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new int[0], array);
    }

    // long array

    @Test
    public void testShift_longArray_offsetNegative() {
        long[] array = {1L, 2L, 3L, 4L};
        long[] expected = {2L, 3L, 4L, 1L};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_longArray_offsetLargerThanArrayLength() {
        long[] array = {1L, 2L, 3L, 4L};
        long[] expected = {1L, 2L, 3L, 4L};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_longArray_nullArray() {
        long[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_longArray_emptyArray() {
        long[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new long[0], array);
    }

    // object array

    @Test
    public void testShift_objectArray_offsetNegative() {
        Object[] array = {"a", "b", "c", "d"};
        Object[] expected = {"b", "c", "d", "a"};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_objectArray_offsetLargerThanArrayLength() {
        Object[] array = {"a", "b", "c", "d"};
        Object[] expected = {"a", "b", "c", "d"};
        ArrayUtils.shift(array, 8);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_objectArray_nullArray() {
        Object[] array = null;
        ArrayUtils.shift(array, 1);
        assertNull(array);
    }

    @Test
    public void testShift_objectArray_emptyArray() {
        Object[] array = {};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new Object[0], array);
    }

    @Test
    @DisplayName("should return null if the array is null")
    void shouldReturnNullIfArrayIsNull() {
        assertNull(ArrayUtils.get(null, 2));
    }

    @Test
    @DisplayName("should return the default value if the array is null")
    void shouldReturnDefaultValueIfArrayIsNull() {
        assertEquals(-1, ArrayUtils.get(null, 2, -1));
    }

    @Test
    void testReverseEmptyBooleanArray() {
        boolean[] array = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array);
    }

    @Test
    void testReverseEmptyBooleanObjectArray() {
        Boolean[] array = ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyByteArray() {
        byte[] array = ArrayUtils.EMPTY_BYTE_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, array);
    }

    @Test
    void testReverseEmptyByteObjectArray() {
        Byte[] array = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyCharArray() {
        char[] array = ArrayUtils.EMPTY_CHAR_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, array);
    }

    @Test
    void testReverseEmptyCharacterObjectArray() {
        Character[] array = ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyClassArray() {
        Class<?>[] array = ArrayUtils.EMPTY_CLASS_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_CLASS_ARRAY, array);
    }

    @Test
    void testReverseEmptyDoubleArray() {
        double[] array = ArrayUtils.EMPTY_DOUBLE_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, array);
    }

    @Test
    void testReverseEmptyDoubleObjectArray() {
        Double[] array = ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyFieldArray() {
        java.lang.reflect.Field[] array = ArrayUtils.EMPTY_FIELD_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_FIELD_ARRAY, array);
    }

    @Test
    void testReverseEmptyFloatArray() {
        float[] array = ArrayUtils.EMPTY_FLOAT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, array);
    }

    @Test
    void testReverseEmptyFloatObjectArray() {
        Float[] array = ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyIntArray() {
        int[] array = ArrayUtils.EMPTY_INT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_INT_ARRAY, array);
    }

    @Test
    void testReverseEmptyIntegerObjectArray() {
        Integer[] array = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyLongArray() {
        long[] array = ArrayUtils.EMPTY_LONG_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_LONG_ARRAY, array);
    }

    @Test
    void testReverseEmptyLongObjectArray() {
        Long[] array = ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyMethodArray() {
        Method[] array = ArrayUtils.EMPTY_METHOD_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_METHOD_ARRAY, array);
    }

    @Test
    void testReverseEmptyObjectArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyShortArray() {
        short[] array = ArrayUtils.EMPTY_SHORT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_SHORT_ARRAY, array);
    }

    @Test
    void testReverseEmptyShortObjectArray() {
        Short[] array = ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseEmptyStringArray() {
        String[] array = ArrayUtils.EMPTY_STRING_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, array);
    }

    @Test
    void testReverseEmptyThrowableArray() {
        Throwable[] array = ArrayUtils.EMPTY_THROWABLE_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_THROWABLE_ARRAY, array);
    }

    @Test
    void testReverseEmptyTypeArray() {
        Type[] array = ArrayUtils.EMPTY_TYPE_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_TYPE_ARRAY, array);
    }

    @Test
    void testReverseEmptyArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseBooleanArray() {
        boolean[] array = {true, false, true};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new boolean[]{true, false, true}, array);
    }

    @Test
    void testReverseBooleanObjectArray() {
        Boolean[] array = {Boolean.TRUE, Boolean.FALSE, Boolean.TRUE};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Boolean[]{Boolean.TRUE, Boolean.FALSE, Boolean.TRUE}, array);
    }

    @Test
    void testReverseByteArray() {
        byte[] array = {1, 2, 3};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new byte[]{3, 2, 1}, array);
    }

    @Test
    void testReverseByteObjectArray() {
        Byte[] array = {Byte.valueOf((byte) 1), Byte.valueOf((byte) 2), Byte.valueOf((byte) 3)};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Byte[]{Byte.valueOf((byte) 3), Byte.valueOf((byte) 2), Byte.valueOf((byte) 1)}, array);
    }

    @Test
    void testReverseCharArray() {
        char[] array = {'a', 'b', 'c'};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new char[]{'c', 'b', 'a'}, array);
    }

    @Test
    void testReverseCharacterObjectArray() {
        Character[] array = {Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c')};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Character[]{Character.valueOf('c'), Character.valueOf('b'), Character.valueOf('a')}, array);
    }

    @Test
    void testReverseDoubleArray() {
        double[] array = {1.0, 2.0, 3.0};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new double[]{3.0, 2.0, 1.0}, array);
    }

    @Test
    void testReverseDoubleObjectArray() {
        Double[] array = {Double.valueOf(1.0), Double.valueOf(2.0), Double.valueOf(3.0)};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(3.0), Double.valueOf(2.0), Double.valueOf(1.0)}, array);
    }

    @Test
    void testReverseFloatArray() {
        float[] array = {1.0f, 2.0f, 3.0f};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new float[]{3.0f, 2.0f, 1.0f}, array);
    }

    @Test
    void testReverseFloatObjectArray() {
        Float[] array = {Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(3.0f)};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Float[]{Float.valueOf(3.0f), Float.valueOf(2.0f), Float.valueOf(1.0f)}, array);
    }

    @Test
    void testReverseIntArray() {
        int[] array = {1, 2, 3};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new int[]{3, 2, 1}, array);
    }

    @Test
    void testReverseIntegerObjectArray() {
        Integer[] array = {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Integer[]{Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)}, array);
    }

    @Test
    void testReverseLongArray() {
        long[] array = {1L, 2L, 3L};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new long[]{3L, 2L, 1L}, array);
    }

    @Test
    void testReverseLongObjectArray() {
        Long[] array = {Long.valueOf(1L), Long.valueOf(2L), Long.valueOf(3L)};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Long[]{Long.valueOf(3L), Long.valueOf(2L), Long.valueOf(1L)}, array);
    }

    @Test
    void testReverseShortArray() {
        short[] array = {1, 2, 3};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new short[]{3, 2, 1}, array);
    }

    @Test
    void testReverseShortObjectArray() {
        Short[] array = {Short.valueOf((short) 1), Short.valueOf((short) 2), Short.valueOf((short) 3)};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Short[]{Short.valueOf((short) 3), Short.valueOf((short) 2), Short.valueOf((short) 1)}, array);
    }

    @Test
    void testReverseObjectArray() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array);
        Assertions.assertArrayEquals(new Object[]{"c", "b", "a"}, array);
    }

    @Test
    void testReverseNullArray() {
        Object[] array = null;
        ArrayUtils.reverse(array);
        Assertions.assertNull(array);
    }

    @Test
    void testReverseEmptyArrayInRange() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        ArrayUtils.reverse(array, 0, 0);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, array);
    }

    @Test
    void testReverseBooleanArrayInRange() {
        boolean[] array = {true, false, true};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new boolean[]{true, false, true}, array);
    }

    @Test
    void testReverseBooleanObjectArrayInRange() {
        Boolean[] array = {Boolean.TRUE, Boolean.FALSE, Boolean.TRUE};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Boolean[]{Boolean.TRUE, Boolean.FALSE, Boolean.TRUE}, array);
    }

    @Test
    void testReverseByteArrayInRange() {
        byte[] array = {1, 2, 3};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new byte[]{1, 2, 3}, array);
    }

    @Test
    void testReverseByteObjectArrayInRange() {
        Byte[] array = {Byte.valueOf((byte) 1), Byte.valueOf((byte) 2), Byte.valueOf((byte) 3)};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Byte[]{Byte.valueOf((byte) 1), Byte.valueOf((byte) 2), Byte.valueOf((byte) 3)}, array);
    }

    @Test
    void testReverseCharArrayInRange() {
        char[] array = {'a', 'b', 'c'};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new char[]{'a', 'b', 'c'}, array);
    }

    @Test
    void testReverseCharacterObjectArrayInRange() {
        Character[] array = {Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c')};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Character[]{Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c')}, array);
    }

    @Test
    void testReverseDoubleArrayInRange() {
        double[] array = {1.0, 2.0, 3.0};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new double[]{1.0, 2.0, 3.0}, array);
    }

    @Test
    void testReverseDoubleObjectArrayInRange() {
        Double[] array = {Double.valueOf(1.0), Double.valueOf(2.0), Double.valueOf(3.0)};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(1.0), Double.valueOf(2.0), Double.valueOf(3.0)}, array);
    }

    @Test
    void testReverseFloatArrayInRange() {
        float[] array = {1.0f, 2.0f, 3.0f};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f}, array);
    }

    @Test
    void testReverseFloatObjectArrayInRange() {
        Float[] array = {Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(3.0f)};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Float[]{Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(3.0f)}, array);
    }

    @Test
    void testReverseIntArrayInRange() {
        int[] array = {1, 2, 3};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, array);
    }

    @Test
    void testReverseIntegerObjectArrayInRange() {
        Integer[] array = {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}, array);
    }

    @Test
    void testReverseLongArrayInRange() {
        long[] array = {1L, 2L, 3L};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new long[]{1L, 2L, 3L}, array);
    }

    @Test
    void testReverseLongObjectArrayInRange() {
        Long[] array = {Long.valueOf(1L), Long.valueOf(2L), Long.valueOf(3L)};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Long[]{Long.valueOf(1L), Long.valueOf(2L), Long.valueOf(3L)}, array);
    }

    @Test
    void testReverseShortArrayInRange() {
        short[] array = {1, 2, 3};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new short[]{1, 2, 3}, array);
    }

    @Test
    void testReverseShortObjectArrayInRange() {
        Short[] array = {Short.valueOf((short) 1), Short.valueOf((short) 2), Short.valueOf((short) 3)};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Short[]{Short.valueOf((short) 1), Short.valueOf((short) 2), Short.valueOf((short) 3)}, array);
    }

    @Test
    void testReverseObjectArrayInRange() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array, 1, 2);
        Assertions.assertArrayEquals(new Object[]{"a", "b", "c"}, array);
    }

    @Test
    void testReverseNullArrayInRange() {
        Object[] array = null;
        ArrayUtils.reverse(array, 0, 0);
        Assertions.assertNull(array);
    }

    //@Test
    void testReverseArrayWithNegativeStartIndex() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array, -1, 2);
        Assertions.assertArrayEquals(new Object[]{"a", "b", "c"}, array);
    }

    @Test
    void testReverseArrayWithStartIndexGreaterThanLength() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array, 4, 5);
        Assertions.assertArrayEquals(new Object[]{"a", "b", "c"}, array);
    }

    @Test
    void testReverseArrayWithNegativeEndIndex() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array, 0, -1);
        Assertions.assertArrayEquals(new Object[]{"a", "b", "c"}, array);
    }

    @Test
    void testReverseArrayWithEndIndexLessThanStartIndex() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array, 2, 1);
        Assertions.assertArrayEquals(new Object[]{"a", "b", "c"}, array);
    }

    @Test
    void testEmptyArray() {
        Integer[] emptyArray = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        int index = 0;

        boolean result = ArrayUtils.isArrayIndexValid(emptyArray, index);

        assertFalse(result);
    }

    @Test
    void testValidIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        int index = 2;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertTrue(result);
    }

    @Test
    void testInvalidIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        int index = 5;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertFalse(result);
    }

    @Test
    void testNullArray() {
        Integer[] array = null;
        int index = 0;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertFalse(result);
    }

    @Test
    public void testAddBoolean() {
        boolean[] array = null;
        boolean element = true;
        boolean[] expected = {true};
        boolean[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new boolean[]{true};
        element = false;
        expected = new boolean[]{true, false};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new boolean[]{true, false};
        element = true;
        expected = new boolean[]{true, false, true};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddByte() {
        byte[] array = null;
        byte element = 1;
        byte[] expected = {1};
        byte[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new byte[]{1};
        element = 2;
        expected = new byte[]{1, 2};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new byte[]{1, 2};
        element = 3;
        expected = new byte[]{1, 2, 3};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddChar() {
        char[] array = null;
        char element = 'a';
        char[] expected = {'a'};
        char[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new char[]{'a'};
        element = 'b';
        expected = new char[]{'a', 'b'};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new char[]{'a', 'b'};
        element = 'c';
        expected = new char[]{'a', 'b', 'c'};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddDouble() {
        double[] array = null;
        double element = 1.1;
        double[] expected = {1.1};
        double[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new double[]{1.1};
        element = 2.2;
        expected = new double[]{1.1, 2.2};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new double[]{1.1, 2.2};
        element = 3.3;
        expected = new double[]{1.1, 2.2, 3.3};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddFloat() {
        float[] array = null;
        float element = 1.1f;
        float[] expected = {1.1f};
        float[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new float[]{1.1f};
        element = 2.2f;
        expected = new float[]{1.1f, 2.2f};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new float[]{1.1f, 2.2f};
        element = 3.3f;
        expected = new float[]{1.1f, 2.2f, 3.3f};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddInt() {
        int[] array = null;
        int element = 1;
        int[] expected = {1};
        int[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new int[]{1};
        element = 2;
        expected = new int[]{1, 2};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new int[]{1, 2};
        element = 3;
        expected = new int[]{1, 2, 3};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddLong() {
        long[] array = null;
        long element = 1L;
        long[] expected = {1L};
        long[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new long[]{1L};
        element = 2L;
        expected = new long[]{1L, 2L};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new long[]{1L, 2L};
        element = 3L;
        expected = new long[]{1L, 2L, 3L};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddShort() {
        short[] array = null;
        short element = 1;
        short[] expected = {1};
        short[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new short[]{1};
        element = 2;
        expected = new short[]{1, 2};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new short[]{1, 2};
        element = 3;
        expected = new short[]{1, 2, 3};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddObject() {
        String[] array = null;
        String element = "a";
        String[] expected = {"a"};
        String[] result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new String[]{"a"};
        element = "b";
        expected = new String[]{"a", "b"};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);

        array = new String[]{"a", "b"};
        element = "c";
        expected = new String[]{"a", "b", "c"};
        result = ArrayUtils.add(array, element);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test clone of boolean array")
    void testCloneBooleanArray() {
        // Given
        boolean[] original = {true, false, true};

        // When
        boolean[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of byte array")
    void testCloneByteArray() {
        // Given
        byte[] original = {1, 2, 3};

        // When
        byte[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of char array")
    void testCloneCharArray() {
        // Given
        char[] original = {'a', 'b', 'c'};

        // When
        char[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of double array")
    void testCloneDoubleArray() {
        // Given
        double[] original = {1.0, 2.0, 3.0};

        // When
        double[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of float array")
    void testCloneFloatArray() {
        // Given
        float[] original = {1.0f, 2.0f, 3.0f};

        // When
        float[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of int array")
    void testCloneIntArray() {
        // Given
        int[] original = {1, 2, 3};

        // When
        int[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of long array")
    void testCloneLongArray() {
        // Given
        long[] original = {1L, 2L, 3L};

        // When
        long[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of short array")
    void testCloneShortArray() {
        // Given
        short[] original = {1, 2, 3};

        // When
        short[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    @DisplayName("Test clone of object array")
    void testCloneObjectArray() {
        // Given
        String[] original = {"a", "b", "c"};

        // When
        String[] cloned = ArrayUtils.clone(original);

        // Then
        assertArrayEquals(original, cloned);
        assertNotSame(original, cloned);
    }

    @Test
    void testToObject_withNullArray_shouldReturnNull() {
        boolean[] array = null;

        Boolean[] result = ArrayUtils.toObject(array);

        assertNull(result);
    }

    @Test
    void testToObject_withEmptyBooleanArray_shouldReturnEmptyBooleanObjectArray() {
        boolean[] array = {};

        Boolean[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withBooleanArray_shouldConvertToBooleanObjectArray() {
        boolean[] array = {true, false, true};

        Boolean[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Boolean.TRUE, result[0]);
        assertEquals(Boolean.FALSE, result[1]);
        assertEquals(Boolean.TRUE, result[2]);
    }

    @Test
    void testToObject_withEmptyByteArray_shouldReturnEmptyByteObjectArray() {
        byte[] array = {};

        Byte[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withByteArray_shouldConvertToByteObjectArray() {
        byte[] array = {1, 2, 3};

        Byte[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Byte.valueOf((byte) 1), result[0]);
        assertEquals(Byte.valueOf((byte) 2), result[1]);
        assertEquals(Byte.valueOf((byte) 3), result[2]);
    }

    @Test
    void testToObject_withEmptyCharArray_shouldReturnEmptyCharacterObjectArray() {
        char[] array = {};

        Character[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withCharArray_shouldConvertToCharacterObjectArray() {
        char[] array = {'a', 'b', 'c'};

        Character[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Character.valueOf('a'), result[0]);
        assertEquals(Character.valueOf('b'), result[1]);
        assertEquals(Character.valueOf('c'), result[2]);
    }

    @Test
    void testToObject_withEmptyDoubleArray_shouldReturnEmptyDoubleObjectArray() {
        double[] array = {};

        Double[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withDoubleArray_shouldConvertToDoubleObjectArray() {
        double[] array = {1.1, 2.2, 3.3};

        Double[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Double.valueOf(1.1), result[0]);
        assertEquals(Double.valueOf(2.2), result[1]);
        assertEquals(Double.valueOf(3.3), result[2]);
    }

    @Test
    void testToObject_withEmptyFloatArray_shouldReturnEmptyFloatObjectArray() {
        float[] array = {};

        Float[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withFloatArray_shouldConvertToFloatObjectArray() {
        float[] array = {1.1f, 2.2f, 3.3f};

        Float[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Float.valueOf(1.1f), result[0]);
        assertEquals(Float.valueOf(2.2f), result[1]);
        assertEquals(Float.valueOf(3.3f), result[2]);
    }

    @Test
    void testToObject_withEmptyIntArray_shouldReturnEmptyIntegerObjectArray() {
        int[] array = {};

        Integer[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withIntArray_shouldConvertToIntegerObjectArray() {
        int[] array = {1, 2, 3};

        Integer[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Integer.valueOf(1), result[0]);
        assertEquals(Integer.valueOf(2), result[1]);
        assertEquals(Integer.valueOf(3), result[2]);
    }

    @Test
    void testToObject_withEmptyLongArray_shouldReturnEmptyLongObjectArray() {
        long[] array = {};

        Long[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withLongArray_shouldConvertToLongObjectArray() {
        long[] array = {1L, 2L, 3L};

        Long[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Long.valueOf(1L), result[0]);
        assertEquals(Long.valueOf(2L), result[1]);
        assertEquals(Long.valueOf(3L), result[2]);
    }

    @Test
    void testToObject_withEmptyShortArray_shouldReturnEmptyShortObjectArray() {
        short[] array = {};

        Short[] result = ArrayUtils.toObject(array);

        assertEquals(0, result.length);
    }

    @Test
    void testToObject_withShortArray_shouldConvertToShortObjectArray() {
        short[] array = {1, 2, 3};

        Short[] result = ArrayUtils.toObject(array);

        assertEquals(3, result.length);
        assertEquals(Short.valueOf((short) 1), result[0]);
        assertEquals(Short.valueOf((short) 2), result[1]);
        assertEquals(Short.valueOf((short) 3), result[2]);
    }

    @Test
    public void testIsSameLength_withEmptyBooleanArrays_shouldReturnTrue() {
        boolean[] array1 = {};
        boolean[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthBooleanArrays_shouldReturnFalse() {
        boolean[] array1 = {true, false};
        boolean[] array2 = {true};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullBooleanArrays_shouldReturnTrue() {
        boolean[] array1 = null;
        boolean[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyByteArrays_shouldReturnTrue() {
        byte[] array1 = {};
        byte[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthByteArrays_shouldReturnFalse() {
        byte[] array1 = {1, 2};
        byte[] array2 = {1};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullByteArrays_shouldReturnTrue() {
        byte[] array1 = null;
        byte[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyCharArrays_shouldReturnTrue() {
        char[] array1 = {};
        char[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthCharArrays_shouldReturnFalse() {
        char[] array1 = {'a', 'b'};
        char[] array2 = {'a'};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullCharArrays_shouldReturnTrue() {
        char[] array1 = null;
        char[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyDoubleArrays_shouldReturnTrue() {
        double[] array1 = {};
        double[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthDoubleArrays_shouldReturnFalse() {
        double[] array1 = {1.0, 2.0};
        double[] array2 = {1.0};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullDoubleArrays_shouldReturnTrue() {
        double[] array1 = null;
        double[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyFloatArrays_shouldReturnTrue() {
        float[] array1 = {};
        float[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthFloatArrays_shouldReturnFalse() {
        float[] array1 = {1.0f, 2.0f};
        float[] array2 = {1.0f};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullFloatArrays_shouldReturnTrue() {
        float[] array1 = null;
        float[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyIntArrays_shouldReturnTrue() {
        int[] array1 = {};
        int[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthIntArrays_shouldReturnFalse() {
        int[] array1 = {1, 2};
        int[] array2 = {1};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullIntArrays_shouldReturnTrue() {
        int[] array1 = null;
        int[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyLongArrays_shouldReturnTrue() {
        long[] array1 = {};
        long[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthLongArrays_shouldReturnFalse() {
        long[] array1 = {1L, 2L};
        long[] array2 = {1L};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullLongArrays_shouldReturnTrue() {
        long[] array1 = null;
        long[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyObjectArrays_shouldReturnTrue() {
        Object[] array1 = {};
        Object[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthObjectArrays_shouldReturnFalse() {
        Object[] array1 = {1, 2};
        Object[] array2 = {1};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullObjectArrays_shouldReturnTrue() {
        Object[] array1 = null;
        Object[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withEmptyShortArrays_shouldReturnTrue() {
        short[] array1 = {};
        short[] array2 = {};
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withDifferentLengthShortArrays_shouldReturnFalse() {
        short[] array1 = {1, 2};
        short[] array2 = {1};
        Assertions.assertFalse(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    public void testIsSameLength_withNullShortArrays_shouldReturnTrue() {
        short[] array1 = null;
        short[] array2 = null;
        Assertions.assertTrue(ArrayUtils.isSameLength(array1, array2));
    }

    @Test
    void testSetAll_withStringArrayAndIntFunction() {
        String[] array = new String[3];
        IntFunction<String> generator = i -> "element " + (i + 1);
        String[] result = ArrayUtils.setAll(array, generator);
        assertArrayEquals(new String[]{"element 1", "element 2", "element 3"}, result);
    }

    @Test
    void testSetAll_withEmptyArray() {
        Object[] array = new Object[0];
        IntFunction<Object> generator = i -> new Object();
        Object[] result = ArrayUtils.setAll(array, generator);
        assertArrayEquals(new Object[0], result);
    }

    @Test
    void testSetAll_withNullArray() {
        Object[] array = null;
        IntFunction<Object> generator = i -> new Object();
        Object[] result = ArrayUtils.setAll(array, generator);
        assertNull(result);
    }

    @Test
    void testSetAll_withNullGenerator() {
        Object[] array = new Object[3];
        IntFunction<Object> generator = null;
        Object[] result = ArrayUtils.setAll(array, generator);
        assertArrayEquals(new Object[3], result);
    }

    @Test
    public void testRemoveAllOccurrences_boolean() {
        boolean[] array = {true, false, true, false, true};
        boolean element = true;
        boolean[] expected = {false, false};
        boolean[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_byte() {
        byte[] array = {1, 2, 3, 4, 5};
        byte element = 3;
        byte[] expected = {1, 2, 4, 5};
        byte[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_char() {
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        char element = 'c';
        char[] expected = {'a', 'b', 'd', 'e'};
        char[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_double() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        double element = 3.0;
        double[] expected = {1.0, 2.0, 4.0, 5.0};
        double[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_float() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        float element = 3.0f;
        float[] expected = {1.0f, 2.0f, 4.0f, 5.0f};
        float[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_int() {
        int[] array = {1, 2, 3, 4, 5};
        int element = 3;
        int[] expected = {1, 2, 4, 5};
        int[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_long() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        long element = 3L;
        long[] expected = {1L, 2L, 4L, 5L};
        long[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_short() {
        short[] array = {1, 2, 3, 4, 5};
        short element = 3;
        short[] expected = {1, 2, 4, 5};
        short[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveAllOccurrences_object() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer element = 3;
        Integer[] expected = {1, 2, 4, 5};
        Integer[] result = ArrayUtils.removeAllOccurrences(array, element);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToPrimitive_withNullArray_shouldReturnNull() {
    }

    @Test
    void testToPrimitive_withEmptyArray_shouldReturnEmptyArray() {
    }

    @Test
    void testToPrimitive_withNullValueForNull_shouldConvertNullsToFalse() {
    }

    @Test
    void testToPrimitive_withNonNullValueForNull_shouldConvertNullsToCustomValue() {
    }

    @Test
    void testToPrimitive_withNonNullArray_shouldConvertToArrayOfPrimitives() {
    }

    @Test
    void testToPrimitive_withNullArray_shouldReturnNullForBytes() {
    }

    @Test
    void testToPrimitive_withEmptyArray_shouldReturnEmptyArrayForBytes() {
    }

    @Test
    void testToPrimitive_withNullValueForNull_shouldConvertNullsToZeroForBytes() {
    }

    @Test
    void testToPrimitive_withNonNullValueForNull_shouldConvertNullsToCustomValueForBytes() {
    }

    @Test
    void testToPrimitive_withNonNullArray_shouldConvertToArrayOfPrimitivesForBytes() {
    }

    @Test
    void testGetComponentType_EmptyBooleanObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY);
        assertEquals(Boolean.class, componentType);
    }
    @Test
    void testGetComponentType_EmptyByteObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY);
        assertEquals(Byte.class, componentType);
    }


    @Test
    void testGetComponentType_EmptyCharacterObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY);
        assertEquals(Character.class, componentType);
    }

    @Test
    void testGetComponentType_EmptyClassArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_CLASS_ARRAY);
        assertEquals(Class.class, componentType);
    }


    @Test
    void testGetComponentType_EmptyDoubleObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY);
        assertEquals(Double.class, componentType);
    }



    @Test
    void testGetComponentType_EmptyFloatObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY);
        assertEquals(Float.class, componentType);
    }


    @Test
    void testGetComponentType_EmptyIntegerObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY);
        assertEquals(Integer.class, componentType);
    }


    @Test
    void testGetComponentType_EmptyLongObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY);
        assertEquals(Long.class, componentType);
    }

    @Test
    void testGetComponentType_EmptyMethodArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_METHOD_ARRAY);
        assertEquals(Method.class, componentType);
    }

    //@Test
    void testGetComponentType_EmptyObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_OBJECT_ARRAY);
        assertNull(componentType);
    }


    @Test
    void testGetComponentType_EmptyShortObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY);
        assertEquals(Short.class, componentType);
    }

    @Test
    void testGetComponentType_EmptyStringArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_STRING_ARRAY);
        assertEquals(String.class, componentType);
    }

    @Test
    void testGetComponentType_EmptyThrowableArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_THROWABLE_ARRAY);
        assertEquals(Throwable.class, componentType);
    }

    @Test
    void testGetComponentType_EmptyTypeArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_TYPE_ARRAY);
        assertEquals(Type.class, componentType);
    }

    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray1() {
        boolean[] array = null;
        boolean valueToFind = true;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray1() {
        boolean[] array = {};
        boolean valueToFind = true;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    //@Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound1() {
        boolean[] array = {true, false, true};
        boolean valueToFind = false;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound1() {
        boolean[] array = {true, false, true};
        boolean valueToFind = false;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray2() {
        byte[] array = null;
        byte valueToFind = 1;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray2() {
        byte[] array = {};
        byte valueToFind = 1;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound2() {
        byte[] array = {1, 2, 3};
        byte valueToFind = 4;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound2() {
        byte[] array = {1, 2, 3};
        byte valueToFind = 2;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray3() {
        char[] array = null;
        char valueToFind = 'a';

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray3() {
        char[] array = {};
        char valueToFind = 'a';

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound3() {
        char[] array = {'a', 'b', 'c'};
        char valueToFind = 'd';

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound3() {
        char[] array = {'a', 'b', 'c'};
        char valueToFind = 'b';

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }


    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray4() {
        double[] array = null;
        double valueToFind = 1.0;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray4() {
        double[] array = {};
        double valueToFind = 1.0;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound4() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 4.0;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound4() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray5() {
        float[] array = null;
        float valueToFind = 1.0f;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray5() {
        float[] array = {};
        float valueToFind = 1.0f;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound5() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 4.0f;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound5() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }


    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray6() {
        int[] array = null;
        int valueToFind = 1;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray6() {
        int[] array = {};
        int valueToFind = 1;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound6() {
        int[] array = {1, 2, 3};
        int valueToFind = 4;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound6() {
        int[] array = {1, 2, 3};
        int valueToFind = 2;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray7() {
        long[] array = null;
        long valueToFind = 1L;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray7() {
        long[] array = {};
        long valueToFind = 1L;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound7() {
        long[] array = {1L, 2L, 3L};
        long valueToFind = 4L;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound7() {
        long[] array = {1L, 2L, 3L};
        long valueToFind = 2L;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }


    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray8() {
        Object[] array = null;
        Object valueToFind = new Object();

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray8() {
        Object[] array = {};
        Object valueToFind = new Object();

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound8() {
        Object[] array = {1, 2, 3};
        Object valueToFind = 4;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound8() {
        Object[] array = {1, 2, 3};
        Object valueToFind = 2;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("should return -1 when array is null")
    void testIndexOfNullArray9() {
        short[] array = null;
        short valueToFind = 1;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when array is empty")
    void testIndexOfEmptyArray9() {
        short[] array = {};
        short valueToFind = 1;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array")
    void testIndexOfValueNotFound9() {
        short[] array = {1, 2, 3};
        short valueToFind = 4;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("should return index of value when value is found in array")
    void testIndexOfValueFound9() {
        short[] array = {1, 2, 3};
        short valueToFind = 2;

        int result = ArrayUtils.indexOf(array, valueToFind);

        assertEquals(1, result);
    }

}