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

//
//    @Test
//    @DisplayName("should return null when input array is null")
//    void testRemoveElementNullArray() {
//        boolean[] array = null;
//        boolean element = true;
//
//        boolean[] result = ArrayUtils.removeElement(array, element);
//
//        Assertions.assertNull(result);
//    }
//
//    @Test
//    @DisplayName("should return empty array when input array is empty")
//    void testRemoveElementEmptyArray() {
//        boolean[] array = {};
//        boolean element = true;
//
//        boolean[] result = arrayUtils.removeElement(array, element);
//
//        Assertions.assertArrayEquals(new boolean[0], result);
//    }
//
//    @Test
//    @DisplayName("should return original array when element is not found")
//    void testRemoveElementElementNotFound() {
//        boolean[] array = {true};
//        boolean element = false;
//
//        boolean[] result = arrayUtils.removeElement(array, element);
//
//        Assertions.assertArrayEquals(array, result);
//    }
//
//    @Test
//    @DisplayName("should return array without the first occurrence of the element")
//    void testRemoveElement() {
//        boolean[] array = {true, false, true};
//        boolean element = true;
//
//        boolean[] result = arrayUtils.removeElement(array, element);
//
//        Assertions.assertArrayEquals(new boolean[]{false, true}, result);
//    }
//
//    @Test
//    @DisplayName("should return null when input array is null")
//    void testRemoveElementNullArray() {
//        byte[] array = null;
//        byte element = 1;
//
//        byte[] result = arrayUtils.removeElement(array, element);
//
//        Assertions.assertNull(result);
//    }
//
//    @Test
//    @DisplayName("should return empty array when input array is empty")
//    void testRemoveElementEmptyArray() {
//        byte[] array = {};
//        byte element = 1;
//
//        byte[] result = arrayUtils.removeElement(array, element);
//
//        Assertions.assertArrayEquals(new byte[0], result);
//    }
//
//    @Test
//    @DisplayName("should return original array when element is not found")
//    void testRemoveElementElementNotFound() {
//        byte[] array = {1};
//        byte element = 0;
//
//        byte[] result = arrayUtils.removeElement(array, element);
//
//        Assertions.assertArrayEquals(array, result);
//    }
//
//    @Test
//    @DisplayName("should return array without the first occurrence of the element")
//    void testRemoveElement() {
//        byte[] array = {1, 0, 1};
//        byte element = 1;
//
//        byte[] result = arrayUtils.removeElement(array, element);
//
//        Assertions.assertArrayEquals(new byte[]{0, 1}, result);
//    }

    // Similar test functions for other data types

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
    void testRemoveAllOccurrences_shouldReturnEmptyArray_whenInputArrayIsNull() {
        boolean[] result = ArrayUtils.removeAllOccurences(null, true);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    @Test
    void testRemoveAllOccurrences_shouldReturnEmptyArray_whenInputArrayIsEmpty() {
        boolean[] input = {};
        boolean[] result = ArrayUtils.removeAllOccurences(input, true);
        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

    @Test
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

//    @Test
//    void testRemoveAllOccurrences_shouldReturnEmptyArray_whenInputArrayIsNull_byte() {
//        byte[] result = ArrayUtils.removeAllOccurences(null, (byte) 1);
//        Assertions.assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result);
//    }

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

//    @Test
    @DisplayName("Test shuffle boolean array")
//    void testShuffleBooleanArray() {
//        boolean[] original = booleanArray.clone();
//        ArrayUtils.shuffle(booleanArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(booleanArray));
//        Arrays.sort(original);
//        Arrays.sort(booleanArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(booleanArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle byte array")
//    void testShuffleByteArray() {
//        byte[] original = byteArray.clone();
//        ArrayUtils.shuffle(byteArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(byteArray));
//        Arrays.sort(original);
//        Arrays.sort(byteArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(byteArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle char array")
//    void testShuffleCharArray() {
//        char[] original = charArray.clone();
//        ArrayUtils.shuffle(charArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(charArray));
//        Arrays.sort(original);
//        Arrays.sort(charArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(charArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle double array")
//    void testShuffleDoubleArray() {
//        double[] original = doubleArray.clone();
//        ArrayUtils.shuffle(doubleArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(doubleArray));
//        Arrays.sort(original);
//        Arrays.sort(doubleArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(doubleArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle float array")
//    void testShuffleFloatArray() {
//        float[] original = floatArray.clone();
//        ArrayUtils.shuffle(floatArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(floatArray));
//        Arrays.sort(original);
//        Arrays.sort(floatArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(floatArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle int array")
//    void testShuffleIntArray() {
//        int[] original = intArray.clone();
//        ArrayUtils.shuffle(intArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(intArray));
//        Arrays.sort(original);
//        Arrays.sort(intArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(intArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle long array")
//    void testShuffleLongArray() {
//        long[] original = longArray.clone();
//        ArrayUtils.shuffle(longArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(longArray));
//        Arrays.sort(original);
//        Arrays.sort(longArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(longArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle object array")
//    void testShuffleObjectArray() {
//        Object[] original = objectArray.clone();
//        ArrayUtils.shuffle(objectArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(objectArray));
//        Arrays.sort(original);
//        Arrays.sort(objectArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(objectArray));
//    }
//
//    @Test
//    @DisplayName("Test shuffle short array")
//    void testShuffleShortArray() {
//        short[] original = shortArray.clone();
//        ArrayUtils.shuffle(shortArray);
//        assertNotEquals(Arrays.toString(original), Arrays.toString(shortArray));
//        Arrays.sort(original);
//        Arrays.sort(shortArray);
//        assertEquals(Arrays.toString(original), Arrays.toString(shortArray));
//    }


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


//    @Test
//    void testRemoveElements_withNullArray_returnsNull() {
//        boolean[] result = ArrayUtils.removeElements(null, true, false);
//        Assertions.assertNull(result);
//    }

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
    void testRemoveElements_withMultipleElementsToRemove_returnsArrayWithoutElements() {
        boolean[] array = {true, false, true, false, true};
        boolean[] result = ArrayUtils.removeElements(array, true, false);
        boolean[] expected = {true, true};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveThanInArray_returnsArrayWithoutElements() {
        boolean[] array = {true, true, true};
        boolean[] result = ArrayUtils.removeElements(array, true, true, true);
        boolean[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    // Repeat the above tests for other primitive types
//
//    @Test
//    void testRemoveElements_withNullArrayObject_returnsNull() {
//        Boolean[] result = ArrayUtils.removeElements(null, true, false);
//        Assertions.assertNull(result);
//    }

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

    @Test
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

    // Repeat the above tests for other non-primitive types
//
//    @Test
//    void testRemoveElements_withNullArrayByte_returnsNull() {
//        byte[] result = ArrayUtils.removeElements(null, (byte) 1, (byte) 2);
//        Assertions.assertNull(result);
//    }

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
    void testRemoveElements_withMultipleElementsToRemoveByte_returnsArrayWithoutElements() {
        byte[] array = {1, 2, 3, 2, 1};
        byte[] result = ArrayUtils.removeElements(array, (byte) 1, (byte) 2);
        byte[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveByteThanInArray_returnsArrayWithoutElements() {
        byte[] array = {1, 1, 1};
        byte[] result = ArrayUtils.removeElements(array, (byte) 1, (byte) 1, (byte) 1);
        byte[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    // Repeat the above tests for other primitive types

//    @Test
//    void testRemoveElements_withNullArrayChar_returnsNull() {
//        char[] result = ArrayUtils.removeElements(null, 'a', 'b');
//        Assertions.assertNull(result);
//    }

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

    @Test
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

    // Repeat the above tests for other primitive types
//
//    @Test
//    void testRemoveElements_withNullArrayDouble_returnsNull() {
//        double[] result = ArrayUtils.removeElements(null, 1.0, 2.0);
//        Assertions.assertNull(result);
//    }

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

    @Test
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

    // Repeat the above tests for other primitive types
//
//    @Test
//    void testRemoveElements_withNullArrayFloat_returnsNull() {
//        float[] result = ArrayUtils.removeElements(null, 1.0f, 2.0f);
//        Assertions.assertNull(result);
//    }

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
    void testRemoveElements_withMultipleElementsToRemoveFloat_returnsArrayWithoutElements() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 1.0f};
        float[] result = ArrayUtils.removeElements(array, 1.0f, 2.0f);
        float[] expected = {3.0f, 1.0f};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveElements_withMoreOccurrencesToRemoveFloatThanInArray_returnsArrayWithoutElements() {
        float[] array = {1.0f, 1.0f, 1.0f};
        float[] result = ArrayUtils.removeElements(array, 1.0f, 1.0f, 1.0f);
        float[] expected = {};
        Assertions.assertArrayEquals(expected, result);
    }

    // Repeat the above tests for other primitive types
//
//    @Test
//    void testRemoveElements_withNullArrayInt_returnsNull() {
//        int[] result = ArrayUtils.removeElements(null, 1, 2);
//        Assertions.assertNull(result);
//    }

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

    @Test
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

    // Repeat the above tests for other primitive types
//
//    @Test
//    void testRemoveElements_withNullArrayLong_returnsNull() {
//        long[] result = ArrayUtils.removeElements(null, 1L, 2L);
//        Assertions.assertNull(result);
//    }

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

    @Test
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

    // Repeat the above tests for other primitive types
//
//    @Test
//    void testRemoveElements_withNullArrayShort_returnsNull() {
//        short[] result = ArrayUtils.removeElements(null, (short) 1, (short) 2);
//        Assertions.assertNull(result);
//    }

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

    @Test
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

    @Test
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
    void testInsert_withEmptyArrayAndNullValues_shouldReturnNull() {
        int index = 0;
        int[] array = new int[]{};
        int[] values = null;
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
    void testHashCode_emptyBooleanArray_returnsZero() {
        boolean[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyBooleanObjectArray_returnsZero() {
        Boolean[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyByteArray_returnsZero() {
        byte[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyByteObjectArray_returnsZero() {
        Byte[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyCharArray_returnsZero() {
        char[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyCharacterObjectArray_returnsZero() {
        Character[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyClassArray_returnsZero() {
        Class<?>[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyDoubleArray_returnsZero() {
        double[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyDoubleObjectArray_returnsZero() {
        Double[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyFieldArray_returnsZero() {
        Field[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyFloatArray_returnsZero() {
        float[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyFloatObjectArray_returnsZero() {
        Float[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyIntArray_returnsZero() {
        int[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyIntegerObjectArray_returnsZero() {
        Integer[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyLongArray_returnsZero() {
        long[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyLongObjectArray_returnsZero() {
        Long[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyMethodArray_returnsZero() {
        Method[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyObjectArray_returnsZero() {
        Object[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyShortArray_returnsZero() {
        short[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyShortObjectArray_returnsZero() {
        Short[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyStringArray_returnsZero() {
        String[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyThrowableArray_returnsZero() {
        Throwable[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_emptyTypeArray_returnsZero() {
        Type[] array = {};
        int expectedHashCode = 0;

        int actualHashCode = ArrayUtils.hashCode(array);

        assertEquals(expectedHashCode, actualHashCode);
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

//    @Test
//    void testIsSorted_withEmptyObjectArray_shouldReturnTrue() {
//        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
//
//        boolean result = ArrayUtils.isSorted(array);
//
//        Assertions.assertTrue(result);
//    }

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

//    @Test
//    @DisplayName("should return an empty array")
//    void testEmptyArray() {
//        assertEquals(0, result.length);
//    }
//
//    @Test
//    @DisplayName("should return an array of Object type")
//    void testObjectType() {
//        assertTrue(result instanceof Object[]);
//    }
//
//    @Test
//    @DisplayName("should return an array with the same number of elements as the input arguments")
//    void testArraySize() {
//        assertEquals(3, result.length);
//    }
//
//    @Test
//    @DisplayName("should return an array containing the same elements as the input arguments")
//    void testArrayElements() {
//        assertEquals("1", result[0]);
//        assertEquals("2", result[1]);
//        assertEquals("3", result[2]);
//    }
//
//    @Test
//    @DisplayName("should return an array with a single null element")
//    void testArraySize() {
//        assertEquals(1, result.length);
//    }
//
//    @Test
//    @DisplayName("should return an array containing a null element")
//    void testArrayElement() {
//        assertNull(result[0]);
//    }
//
//    @Test
//    @DisplayName("should return a new array with the same elements as the input array")
//    void testArrayElements() {
//        assertNotSame(inputArray, result);
//        assertEquals(Arrays.toString(inputArray), Arrays.toString(result));
//    }
//
//    @Test
//    @DisplayName("should return an array of Object type")
//    void testObjectType() {
//        assertTrue(result instanceof Object[]);
//    }
//
//    @Test
//    @DisplayName("should return an array with the same number of elements as the input arguments")
//    void testArraySize() {
//        assertEquals(3, result.length);
//    }
//
//    @Test
//    @DisplayName("should return an array containing the same elements as the input arguments")
//    void testArrayElements() {
//        assertEquals(1, result[0]);
//        assertEquals(2, result[1]);
//        assertEquals(3, result[2]);
//    }
//
//    @Test
//    @DisplayName("should return an array of Integer type")
//    void testIntegerType() {
//        assertTrue(result instanceof Integer[]);
//    }
//
//    @Test
//    void removeAll_booleanArray() {
//        boolean[] result = ArrayUtils.removeAll(booleanArray, 0, 2);
//        assertArrayEquals(new boolean[]{false}, result);
//    }
//
//    @Test
//    void removeAll_byteArray() {
//        byte[] result = ArrayUtils.removeAll(byteArray, 0, 2);
//        assertArrayEquals(new byte[]{2}, result);
//    }
//
//    @Test
//    void removeAll_charArray() {
//        char[] result = ArrayUtils.removeAll(charArray, 0, 2);
//        assertArrayEquals(new char[]{'b'}, result);
//    }
//
//    @Test
//    void removeAll_doubleArray() {
//        double[] result = ArrayUtils.removeAll(doubleArray, 0, 2);
//        assertArrayEquals(new double[]{2.0}, result);
//    }
//
//    @Test
//    void removeAll_floatArray() {
//        float[] result = ArrayUtils.removeAll(floatArray, 0, 2);
//        assertArrayEquals(new float[]{2.0f}, result);
//    }
//
//    @Test
//    void removeAll_intArray() {
//        int[] result = ArrayUtils.removeAll(intArray, 0, 2);
//        assertArrayEquals(new int[]{2}, result);
//    }
//
//    @Test
//    void removeAll_longArray() {
//        long[] result = ArrayUtils.removeAll(longArray, 0, 2);
//        assertArrayEquals(new long[]{2L}, result);
//    }
//
//    @Test
//    void removeAll_shortArray() {
//        short[] result = ArrayUtils.removeAll(shortArray, 0, 2);
//        assertArrayEquals(new short[]{2}, result);
//    }
//
//    @Test
//    void removeAll_stringArray() {
//        String[] result = ArrayUtils.removeAll(stringArray, 0, 2);
//        assertArrayEquals(new String[]{"b"}, result);
//    }

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
    public void testShift_booleanArray_offsetPositive() {
        boolean[] array = {true, false, true, false};
        boolean[] expected = {true, true, false, false};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testShift_booleanArray_offsetNegative() {
        boolean[] array = {true, false, true, false};
        boolean[] expected = {false, false, true, true};
        ArrayUtils.shift(array, -1);
        assertArrayEquals(expected, array);
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
    public void testShift_byteArray_offsetPositive() {
        byte[] array = {1, 2, 3, 4};
        byte[] expected = {1, 4, 3, 2};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

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
    public void testShift_charArray_offsetPositive() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] expected = {'a', 'd', 'c', 'b'};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

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

    @Test
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

    @Test
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
    public void testShift_intArray_offsetPositive() {
        int[] array = {1, 2, 3, 4};
        int[] expected = {1, 4, 3, 2};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

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
    public void testShift_longArray_offsetPositive() {
        long[] array = {1L, 2L, 3L, 4L};
        long[] expected = {1L, 4L, 3L, 2L};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

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
    public void testShift_objectArray_offsetPositive() {
        Object[] array = {"a", "b", "c", "d"};
        Object[] expected = {"a", "d", "c", "b"};
        ArrayUtils.shift(array, 1);
        assertArrayEquals(expected, array);
    }

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
//
//    @Test
//    @DisplayName("should return the nth element of the array")
//    void shouldReturnNthElement() {
//        assertEquals(3, ArrayUtils.get(array, 2));
//    }
//
//    @Test
//    @DisplayName("should return null if the index is out of bounds")
//    void shouldReturnNullIfIndexOutOfBounds() {
//        assertNull(ArrayUtils.get(array, 5));
//    }
//
//    @Test
//    @DisplayName("should return the default value if the index is out of bounds")
//    void shouldReturnDefaultValueIfIndexOutOfBounds() {
//        assertEquals(-1, ArrayUtils.get(array, 5, -1));
//    }

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
//
//    @Test
//    void testToMap_withNullArray_shouldReturnNull() {
//        // Arrange
//        Object[] array = null;
//
//        // Act
//        Map<Object, Object> result = arrayUtils.toMap(array);
//
//        // Assert
//        assertNull(result);
//    }
//
//    @Test
//    void testToMap_withEmptyArray_shouldReturnEmptyMap() {
//        // Arrange
//        Object[] array = {};
//
//        // Act
//        Map<Object, Object> result = arrayUtils.toMap(array);
//
//        // Assert
//        assertNotNull(result);
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    void testToMap_withArrayContainingMapEntries_shouldReturnMapWithEntries() {
//        // Arrange
//        Object[] array = {Map.entry("key1", "value1"), Map.entry("key2", "value2")};
//
//        // Act
//        Map<Object, Object> result = arrayUtils.toMap(array);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsKey("key1"));
//        assertTrue(result.containsValue("value1"));
//        assertTrue(result.containsKey("key2"));
//        assertTrue(result.containsValue("value2"));
//    }
//
//    @Test
//    void testToMap_withArrayContainingArrays_shouldReturnMapWithEntries() {
//        // Arrange
//        Object[] array = {new Object[]{"key1", "value1"}, new Object[]{"key2", "value2"}};
//
//        // Act
//        Map<Object, Object> result = arrayUtils.toMap(array);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsKey("key1"));
//        assertTrue(result.containsValue("value1"));
//        assertTrue(result.containsKey("key2"));
//        assertTrue(result.containsValue("value2"));
//    }
//
//    @Test
//    void testToMap_withArrayContainingArraysOfLengthLessThanTwo_shouldThrowIllegalArgumentException() {
//        // Arrange
//        Object[] array = {new Object[]{"key1"}, new Object[]{"key2", "value2"}};
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> arrayUtils.toMap(array));
//    }
//
//    @Test
//    void testToMap_withArrayContainingElementsOtherThanMapEntriesAndArrays_shouldThrowIllegalArgumentException() {
//        // Arrange
//        Object[] array = {"key1", "value1", "key2", "value2"};
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> arrayUtils.toMap(array));
//    }
//
//    @Test
//    void shouldReturnTrueWhenArrayContainsAnyObjects() {
//        // Arrange
//        Object[] array = {1, 2, 3, 4, 5};
//        Object[] objectsToFind = {3, 5};
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    void shouldReturnFalseWhenArrayDoesNotContainAnyObjects() {
//        // Arrange
//        Object[] array = {1, 2, 3, 4, 5};
//        Object[] objectsToFind = {6, 7};
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void shouldReturnFalseWhenArrayIsNull() {
//        // Arrange
//        Object[] array = null;
//        Object[] objectsToFind = {1, 2};
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void shouldReturnFalseWhenObjectsToFindIsNull() {
//        // Arrange
//        Object[] array = {1, 2, 3};
//        Object[] objectsToFind = null;
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void shouldReturnFalseWhenBothArrayAndObjectsToFindAreNull() {
//        // Arrange
//        Object[] array = null;
//        Object[] objectsToFind = null;
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void shouldReturnFalseWhenArrayIsEmpty() {
//        // Arrange
//        Object[] array = {};
//        Object[] objectsToFind = {1, 2};
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void shouldReturnFalseWhenObjectsToFindIsEmpty() {
//        // Arrange
//        Object[] array = {1, 2, 3};
//        Object[] objectsToFind = {};
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void shouldReturnFalseWhenBothArrayAndObjectsToFindAreEmpty() {
//        // Arrange
//        Object[] array = {};
//        Object[] objectsToFind = {};
//
//        // Act
//        boolean result = arrayUtils.containsAny(array, objectsToFind);
//
//        // Assert
//        assertFalse(result);
//    }

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

    @Test
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
    void testReverseArrayWithEndIndexGreaterThanLength() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array, 0, 4);
        Assertions.assertArrayEquals(new Object[]{"a", "b", "c"}, array);
    }

    @Test
    void testReverseArrayWithEndIndexLessThanStartIndex() {
        Object[] array = {"a", "b", "c"};
        ArrayUtils.reverse(array, 2, 1);
        Assertions.assertArrayEquals(new Object[]{"a", "b", "c"}, array);
    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, true));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, false));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new boolean[]{}, true));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new boolean[]{}, false));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, (byte) 2));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, (byte) 4));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new byte[]{}, (byte) 1));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new byte[]{}, (byte) 2));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, 'b'));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, 'd'));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new char[]{}, 'a'));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new char[]{}, 'b'));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, 2.0));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, 4.0));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new double[]{}, 1.0));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new double[]{}, 2.0));
//    }
//
//    @Test
//    public void testContainsValueWithinTolerance() {
//        assertTrue(arrayUtils.contains(array, 2.5, 0.5));
//    }
//
//    @Test
//    public void testDoesNotContainValueWithinTolerance() {
//        assertFalse(arrayUtils.contains(array, 4.0, 0.5));
//    }
//
//    @Test
//    public void testContainsValueWithinToleranceInEmptyArray() {
//        assertFalse(arrayUtils.contains(new double[]{}, 1.0, 0.5));
//    }
//
//    @Test
//    public void testDoesNotContainValueWithinToleranceInEmptyArray() {
//        assertFalse(arrayUtils.contains(new double[]{}, 2.0, 0.5));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, 2.0f));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, 4.0f));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new float[]{}, 1.0f));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new float[]{}, 2.0f));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, 2));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, 4));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new int[]{}, 1));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new int[]{}, 2));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, 2L));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, 4L));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new long[]{}, 1L));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new long[]{}, 2L));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, "b"));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, "d"));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new Object[]{}, "a"));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new Object[]{}, "b"));
//    }
//
//    @Test
//    public void testContainsValue() {
//        assertTrue(arrayUtils.contains(array, (short) 2));
//    }
//
//    @Test
//    public void testDoesNotContainValue() {
//        assertFalse(arrayUtils.contains(array, (short) 4));
//    }
//
//    @Test
//    public void testContainsValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new short[]{}, (short) 1));
//    }
//
//    @Test
//    public void testDoesNotContainValueInEmptyArray() {
//        assertFalse(arrayUtils.contains(new short[]{}, (short) 2));
//    }

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
//
//    @Test
//    void subarray_withValidIndices_returnsSubarray() {
//        boolean[] subarray = arrayUtils.subarray(array, 1, 4);
//        assertArrayEquals(new boolean[]{false, true, false}, subarray);
//    }
//
//    @Test
//    void subarray_withInvalidIndices_returnsEmptyArray() {
//        boolean[] subarray = arrayUtils.subarray(array, 4, 1);
//        assertArrayEquals(new boolean[0], subarray);
//    }
//
//    @Test
//    void subarray_withNullArray_returnsNull() {
//        boolean[] subarray = arrayUtils.subarray(null, 0, 3);
//        assertNull(subarray);
//    }
//
//    @Test
//    void subarray_withValidIndices_returnsSubarray() {
//        byte[] subarray = arrayUtils.subarray(array, 1, 4);
//        assertArrayEquals(new byte[]{2, 3, 4}, subarray);
//    }
//
//    @Test
//    void subarray_withInvalidIndices_returnsEmptyArray() {
//        byte[] subarray = arrayUtils.subarray(array, 4, 1);
//        assertArrayEquals(new byte[0], subarray);
//    }
//
//    @Test
//    void subarray_withNullArray_returnsNull() {
//        byte[] subarray = arrayUtils.subarray(null, 0, 3);
//        assertNull(subarray);
//    }
//
//    @Test
//    void testIsNotEmpty_withEmptyBooleanArray_returnsFalse() {
//        boolean[] array = {};
//        Assertions.assertFalse(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withNonEmptyBooleanArray_returnsTrue() {
//        boolean[] array = {true, false};
//        Assertions.assertTrue(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withNullBooleanArray_returnsFalse() {
//        boolean[] array = null;
//        Assertions.assertFalse(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withEmptyByteArray_returnsFalse() {
//        byte[] array = {};
//        Assertions.assertFalse(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withNonEmptyByteArray_returnsTrue() {
//        byte[] array = {1, 2, 3};
//        Assertions.assertTrue(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withNullByteArray_returnsFalse() {
//        byte[] array = null;
//        Assertions.assertFalse(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withEmptyObjectArray_returnsFalse() {
//        Object[] array = {};
//        Assertions.assertFalse(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withNonEmptyObjectArray_returnsTrue() {
//        Object[] array = {new Object(), new Object()};
//        Assertions.assertTrue(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsNotEmpty_withNullObjectArray_returnsFalse() {
//        Object[] array = null;
//        Assertions.assertFalse(arrayUtils.isNotEmpty(array));
//    }
//
//    @Test
//    void testIsSameType_BothArraysNull_ThrowsIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            arrayUtils.isSameType(null, null);
//        });
//    }
//
//    @Test
//    void testIsSameType_FirstArrayNull_ThrowsIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            arrayUtils.isSameType(null, new int[5]);
//        });
//    }
//
//    @Test
//    void testIsSameType_SecondArrayNull_ThrowsIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            arrayUtils.isSameType(new String[3], null);
//        });
//    }
//
//    @Test
//    void testIsSameType_BothArraysEmpty_ReturnsTrue() {
//        boolean result = arrayUtils.isSameType(new int[0], new int[0]);
//        assertTrue(result);
//    }
//
//    @Test
//    void testIsSameType_ArraysWithDifferentComponentTypes_ReturnsFalse() {
//        boolean result = arrayUtils.isSameType(new int[5], new String[5]);
//        assertFalse(result);
//    }
//
//    @Test
//    void testIsSameType_ArraysWithDifferentDimensions_ReturnsFalse() {
//        int[][] array1 = new int[3][4];
//        int[][][] array2 = new int[3][4][5];
//        boolean result = arrayUtils.isSameType(array1, array2);
//        assertFalse(result);
//    }
//
//    @Test
//    void testIsSameType_ArraysWithSameComponentTypeAndDimensions_ReturnsTrue() {
//        int[][] array1 = new int[3][4];
//        int[][] array2 = new int[3][4];
//        boolean result = arrayUtils.isSameType(array1, array2);
//        assertTrue(result);
//    }
//
//    @Test
//    void testIsSameType_ArraysWithSameComponentTypeButDifferentDimensions_ReturnsFalse() {
//        int[][] array1 = new int[3][4];
//        int[][] array2 = new int[4][3];
//        boolean result = arrayUtils.isSameType(array1, array2);
//        assertFalse(result);
//    }
//
//    @Test
//    void testIsSameType_ArraysWithSameComponentTypeAndDifferentSizes_ReturnsTrue() {
//        int[] array1 = new int[5];
//        int[] array2 = new int[3];
//        boolean result = arrayUtils.isSameType(array1, array2);
//        assertTrue(result);
//    }
//
//    @Test
//    void testIsSameType_ArraysWithDifferentComponentTypesAndSizes_ReturnsFalse() {
//        String[] array1 = new String[5];
//        int[] array2 = new int[5];
//        boolean result = arrayUtils.isSameType(array1, array2);
//        assertFalse(result);
//    }
//
//    @Test
//    void testIsSameType_ArraysWithDifferentComponentTypesAndDifferentSizes_ReturnsFalse() {
//        String[] array1 = new String[5];
//        int[] array2 = new int[3];
//        boolean result = arrayUtils.isSameType(array1, array2);
//        assertFalse(result);
//    }
//
//    @Test
//    public void testToString_withNullArray_shouldReturnStringIfNull() {
//        Object array = null;
//        String stringIfNull = "{}";
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array, stringIfNull);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyBooleanArray_shouldReturnEmptyString() {
//        boolean[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyBooleanObjectArray_shouldReturnEmptyString() {
//        Boolean[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyByteArray_shouldReturnEmptyString() {
//        byte[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyByteObjectArray_shouldReturnEmptyString() {
//        Byte[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyCharArray_shouldReturnEmptyString() {
//        char[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyCharacterObjectArray_shouldReturnEmptyString() {
//        Character[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyClassArray_shouldReturnEmptyString() {
//        Class<?>[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyDoubleArray_shouldReturnEmptyString() {
//        double[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyDoubleObjectArray_shouldReturnEmptyString() {
//        Double[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyFieldArray_shouldReturnEmptyString() {
//        Field[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyFloatArray_shouldReturnEmptyString() {
//        float[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyFloatObjectArray_shouldReturnEmptyString() {
//        Float[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyIntArray_shouldReturnEmptyString() {
//        int[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyIntegerObjectArray_shouldReturnEmptyString() {
//        Integer[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyLongArray_shouldReturnEmptyString() {
//        long[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyLongObjectArray_shouldReturnEmptyString() {
//        Long[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyMethodArray_shouldReturnEmptyString() {
//        Method[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyObjectArray_shouldReturnEmptyString() {
//        Object[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyShortArray_shouldReturnEmptyString() {
//        short[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyShortObjectArray_shouldReturnEmptyString() {
//        Short[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyStringArray_shouldReturnEmptyString() {
//        String[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyThrowableArray_shouldReturnEmptyString() {
//        Throwable[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withEmptyTypeArray_shouldReturnEmptyString() {
//        Type[] array = {};
//        String expected = "{}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withNonNullArray_shouldReturnArrayToString() {
//        int[] array = {1, 2, 3};
//        String expected = "{1, 2, 3}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withNonEmptyArray_shouldReturnArrayToString() {
//        String[] array = {"a", "b", "c"};
//        String expected = "{a, b, c}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testToString_withMultiDimensionalArray_shouldReturnArrayToString() {
//        int[][] array = {{1, 2}, {3, 4}};
//        String expected = "{{1, 2}, {3, 4}}";
//
//        String result = arrayUtils.toString(array);
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void isEmpty_withNonEmptyBooleanArray_returnsFalse() {
//        boolean[] array = {true, false};
//        assertFalse(arrayUtils.isEmpty(array));
//    }
//
//    @Test
//    void isEmpty_withNullBooleanArray_returnsTrue() {
//        assertTrue(arrayUtils.isEmpty(null));
//    }
//
//    @Test
//    void isEmpty_withNonEmptyByteArray_returnsFalse() {
//        byte[] array = {1, 2, 3};
//        assertFalse(arrayUtils.isEmpty(array));
//    }
//
//    @Test
//    void isEmpty_withNullByteArray_returnsTrue() {
//        assertTrue(arrayUtils.isEmpty(null));
//    }
//
//    @Test
//    void testRandom_emptyArray() {
//        int[] emptyArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyArray));
//    }
//
//    @Test
//    void testRandom_singleElementArray() {
//        int[] singleElementArray = {5};
//        assertEquals(5, ArrayUtils.random(singleElementArray));
//    }
//
//    @Test
//    void testRandom_multipleElementArray() {
//        int[] multipleElementArray = {1, 2, 3, 4, 5};
//        int randomValue = ArrayUtils.random(multipleElementArray);
//        assertTrue(Arrays.asList(multipleElementArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_negativeValues() {
//        int[] negativeArray = {-1, -2, -3, -4, -5};
//        int randomValue = ArrayUtils.random(negativeArray);
//        assertTrue(Arrays.asList(negativeArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_largeValues() {
//        int[] largeArray = {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2};
//        int randomValue = ArrayUtils.random(largeArray);
//        assertTrue(Arrays.asList(largeArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_duplicateValues() {
//        int[] duplicateArray = {1, 2, 3, 3, 4, 4, 5};
//        int randomValue = ArrayUtils.random(duplicateArray);
//        assertTrue(Arrays.asList(duplicateArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyObjectArray() {
//        Object[] emptyObjectArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyObjectArray));
//    }
//
//    @Test
//    void testRandom_singleElementObjectArray() {
//        Object[] singleElementObjectArray = {new Object()};
//        assertEquals(singleElementObjectArray[0], ArrayUtils.random(singleElementObjectArray));
//    }
//
//    @Test
//    void testRandom_multipleElementObjectArray() {
//        Object[] multipleElementObjectArray = {new Object(), new Object(), new Object()};
//        Object randomValue = ArrayUtils.random(multipleElementObjectArray);
//        assertTrue(Arrays.asList(multipleElementObjectArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_nullValues() {
//        Object[] nullArray = {null, null, null};
//        Object randomValue = ArrayUtils.random(nullArray);
//        assertTrue(Arrays.asList(nullArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyStringArray() {
//        String[] emptyStringArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyStringArray));
//    }
//
//    @Test
//    void testRandom_singleElementStringArray() {
//        String[] singleElementStringArray = {"Hello"};
//        assertEquals(singleElementStringArray[0], ArrayUtils.random(singleElementStringArray));
//    }
//
//    @Test
//    void testRandom_multipleElementStringArray() {
//        String[] multipleElementStringArray = {"Hello", "World"};
//        String randomValue = ArrayUtils.random(multipleElementStringArray);
//        assertTrue(Arrays.asList(multipleElementStringArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyBooleanArray() {
//        boolean[] emptyBooleanArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyBooleanArray));
//    }
//
//    @Test
//    void testRandom_singleElementBooleanArray() {
//        boolean[] singleElementBooleanArray = {true};
//        assertEquals(true, ArrayUtils.random(singleElementBooleanArray));
//    }
//
//    @Test
//    void testRandom_multipleElementBooleanArray() {
//        boolean[] multipleElementBooleanArray = {true, false};
//        boolean randomValue = ArrayUtils.random(multipleElementBooleanArray);
//        assertTrue(Arrays.asList(multipleElementBooleanArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyByteArray() {
//        byte[] emptyByteArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyByteArray));
//    }
//
//    @Test
//    void testRandom_singleElementByteArray() {
//        byte[] singleElementByteArray = {1};
//        assertEquals(1, ArrayUtils.random(singleElementByteArray));
//    }
//
//    @Test
//    void testRandom_multipleElementByteArray() {
//        byte[] multipleElementByteArray = {1, 2, 3};
//        byte randomValue = ArrayUtils.random(multipleElementByteArray);
//        assertTrue(Arrays.asList(multipleElementByteArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyCharArray() {
//        char[] emptyCharArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyCharArray));
//    }
//
//    @Test
//    void testRandom_singleElementCharArray() {
//        char[] singleElementCharArray = {'a'};
//        assertEquals('a', ArrayUtils.random(singleElementCharArray));
//    }
//
//    @Test
//    void testRandom_multipleElementCharArray() {
//        char[] multipleElementCharArray = {'a', 'b', 'c'};
//        char randomValue = ArrayUtils.random(multipleElementCharArray);
//        assertTrue(Arrays.asList(multipleElementCharArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyShortArray() {
//        short[] emptyShortArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyShortArray));
//    }
//
//    @Test
//    void testRandom_singleElementShortArray() {
//        short[] singleElementShortArray = {1};
//        assertEquals(1, ArrayUtils.random(singleElementShortArray));
//    }
//
//    @Test
//    void testRandom_multipleElementShortArray() {
//        short[] multipleElementShortArray = {1, 2, 3};
//        short randomValue = ArrayUtils.random(multipleElementShortArray);
//        assertTrue(Arrays.asList(multipleElementShortArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyIntArray() {
//        int[] emptyIntArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyIntArray));
//    }
//
//    @Test
//    void testRandom_singleElementIntArray() {
//        int[] singleElementIntArray = {1};
//        assertEquals(1, ArrayUtils.random(singleElementIntArray));
//    }
//
//    @Test
//    void testRandom_multipleElementIntArray() {
//        int[] multipleElementIntArray = {1, 2, 3};
//        int randomValue = ArrayUtils.random(multipleElementIntArray);
//        assertTrue(Arrays.asList(multipleElementIntArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyLongArray() {
//        long[] emptyLongArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyLongArray));
//    }
//
//    @Test
//    void testRandom_singleElementLongArray() {
//        long[] singleElementLongArray = {1L};
//        assertEquals(1L, ArrayUtils.random(singleElementLongArray));
//    }
//
//    @Test
//    void testRandom_multipleElementLongArray() {
//        long[] multipleElementLongArray = {1L, 2L, 3L};
//        long randomValue = ArrayUtils.random(multipleElementLongArray);
//        assertTrue(Arrays.asList(multipleElementLongArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyFloatArray() {
//        float[] emptyFloatArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyFloatArray));
//    }
//
//    @Test
//    void testRandom_singleElementFloatArray() {
//        float[] singleElementFloatArray = {1.0f};
//        assertEquals(1.0f, ArrayUtils.random(singleElementFloatArray));
//    }
//
//    @Test
//    void testRandom_multipleElementFloatArray() {
//        float[] multipleElementFloatArray = {1.0f, 2.0f, 3.0f};
//        float randomValue = ArrayUtils.random(multipleElementFloatArray);
//        assertTrue(Arrays.asList(multipleElementFloatArray).contains(randomValue));
//    }
//
//    @Test
//    void testRandom_emptyDoubleArray() {
//        double[] emptyDoubleArray = {};
//        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random(emptyDoubleArray));
//    }
//
//    @Test
//    void testRandom_singleElementDoubleArray() {
//        double[] singleElementDoubleArray = {1.0};
//        assertEquals(1.0, ArrayUtils.random(singleElementDoubleArray));
//    }
//
//    @Test
//    void testRandom_multipleElementDoubleArray() {
//        double[] multipleElementDoubleArray = {1.0, 2.0, 3.0};
//        double randomValue = ArrayUtils.random(multipleElementDoubleArray);
//        assertTrue(Arrays.asList(multipleElementDoubleArray).contains(randomValue));
//    }

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
//
//    @Test
//    void testSetAll_withIntArrayAndIntFunction() {
//        int[] array = new int[5];
//        IntFunction<Integer> generator = i -> i + 1;
//        int[] result = ArrayUtils.setAll(array, generator);
//        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
//    }
//
//    @Test
//    void testSetAll_withIntArrayAndSupplier() {
//        int[] array = new int[5];
//        Supplier<Integer> generator = () -> 5;
//        int[] result = ArrayUtils.setAll(array, generator);
//        assertArrayEquals(new int[]{5, 5, 5, 5, 5}, result);
//    }

    @Test
    void testSetAll_withStringArrayAndIntFunction() {
        String[] array = new String[3];
        IntFunction<String> generator = i -> "element " + (i + 1);
        String[] result = ArrayUtils.setAll(array, generator);
        assertArrayEquals(new String[]{"element 1", "element 2", "element 3"}, result);
    }

//    @Test
//    void testSetAll_withStringArrayAndSupplier() {
//        String[] array = new String[3];
//        Supplier<String> generator = () -> "hello";
//        String[] result = ArrayUtils.setAll(array, generator);
//        assertArrayEquals(new String[]{"hello", "hello", "hello"}, result);
//    }

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
    void testSetAll_withExceptionInGenerator() {
        Integer[] array = new Integer[5];
        IntFunction<Integer> generator = i -> {
            if (i == 2) {
                throw new RuntimeException("Exception in generator");
            }
            return i + 1;
        };
        assertThrows(RuntimeException.class, () -> ArrayUtils.setAll(array, generator));
        assertArrayEquals(new Integer[5], array);
    }
// Your Java code here
//
//    @Test
//    public void testGetLength_NullArray_ReturnsZero() {
//        int length = arrayUtils.getLength(null);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyBooleanArray_ReturnsZero() {
//        boolean[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyBooleanObjectArray_ReturnsZero() {
//        Boolean[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyByteArray_ReturnsZero() {
//        byte[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyByteObjectArray_ReturnsZero() {
//        Byte[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyCharArray_ReturnsZero() {
//        char[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyCharacterObjectArray_ReturnsZero() {
//        Character[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyClassArray_ReturnsZero() {
//        Class<?>[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyDoubleArray_ReturnsZero() {
//        double[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyDoubleObjectArray_ReturnsZero() {
//        Double[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyFieldArray_ReturnsZero() {
//        Field[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyFloatArray_ReturnsZero() {
//        float[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyFloatObjectArray_ReturnsZero() {
//        Float[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyIntArray_ReturnsZero() {
//        int[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyIntegerObjectArray_ReturnsZero() {
//        Integer[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyLongArray_ReturnsZero() {
//        long[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyLongObjectArray_ReturnsZero() {
//        Long[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyMethodArray_ReturnsZero() {
//        Method[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyObjectArray_ReturnsZero() {
//        Object[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyShortArray_ReturnsZero() {
//        short[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyShortObjectArray_ReturnsZero() {
//        Short[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyStringArray_ReturnsZero() {
//        String[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyThrowableArray_ReturnsZero() {
//        Throwable[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }
//
//    @Test
//    public void testGetLength_EmptyTypeArray_ReturnsZero() {
//        Type[] array = {};
//        int length = arrayUtils.getLength(array);
//        assertEquals(0, length);
//    }

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
// Your Java code here
//
//    @Test
//    void testGetComponentType_EmptyBooleanArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_BOOLEAN_ARRAY);
//        assertEquals(boolean.class, componentType);
//    }

    @Test
    void testGetComponentType_EmptyBooleanObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY);
        assertEquals(Boolean.class, componentType);
    }
//
//    @Test
//    void testGetComponentType_EmptyByteArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_BYTE_ARRAY);
//        assertEquals(byte.class, componentType);
//    }

    @Test
    void testGetComponentType_EmptyByteObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY);
        assertEquals(Byte.class, componentType);
    }

//    @Test
//    void testGetComponentType_EmptyCharArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_CHAR_ARRAY);
//        assertEquals(char.class, componentType);
//    }

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

//    @Test
//    void testGetComponentType_EmptyDoubleArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_DOUBLE_ARRAY);
//        assertEquals(double.class, componentType);
//    }

    @Test
    void testGetComponentType_EmptyDoubleObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY);
        assertEquals(Double.class, componentType);
    }

    @Test
    void testGetComponentType_EmptyFieldArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_FIELD_ARRAY);
        assertEquals(Field.class, componentType);
    }

//    @Test
//    void testGetComponentType_EmptyFloatArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_FLOAT_ARRAY);
//        assertEquals(float.class, componentType);
//    }

    @Test
    void testGetComponentType_EmptyFloatObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY);
        assertEquals(Float.class, componentType);
    }

//    @Test
//    void testGetComponentType_EmptyIntArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_INT_ARRAY);
//        assertEquals(int.class, componentType);
//    }

    @Test
    void testGetComponentType_EmptyIntegerObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY);
        assertEquals(Integer.class, componentType);
    }

//    @Test
//    void testGetComponentType_EmptyLongArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_LONG_ARRAY);
//        assertEquals(long.class, componentType);
//    }

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

    @Test
    void testGetComponentType_EmptyObjectArray() {
        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_OBJECT_ARRAY);
        assertNull(componentType);
    }

//    @Test
//    void testGetComponentType_EmptyShortArray() {
//        Class<?> componentType = ArrayUtils.getComponentType(ArrayUtils.EMPTY_SHORT_ARRAY);
//        assertEquals(short.class, componentType);
//    }

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
// Your Java code here

//    @Test
//    @DisplayName("Should return null when input array is null")
//    void shouldReturnNullWhenInputArrayIsNull() {
//        // Arrange
//        Object[] array = null;
//
//        // Act
//        String[] result = arrayUtils.toStringArray(array);
//
//        // Assert
//        assertNull(result);
//    }
//
//    @Test
//    @DisplayName("Should return an empty array when input array is empty")
//    void shouldReturnEmptyArrayWhenInputArrayIsEmpty() {
//        // Arrange
//        Object[] array = {};
//
//        // Act
//        String[] result = arrayUtils.toStringArray(array);
//
//        // Assert
//        assertEquals(0, result.length);
//    }
//
//    @Test
//    @DisplayName("Should return an array with string representation of each element")
//    void shouldReturnArrayWithStringRepresentationOfEachElement() {
//        // Arrange
//        Object[] array = {1, "hello", true};
//
//        // Act
//        String[] result = arrayUtils.toStringArray(array);
//
//        // Assert
//        assertEquals(3, result.length);
//        assertEquals("1", result[0]);
//        assertEquals("hello", result[1]);
//        assertEquals("true", result[2]);
//    }
//
//    @Test
//    @DisplayName("Should return null when input array is null")
//    void shouldReturnNullWhenInputArrayIsNull() {
//        // Arrange
//        Object[] array = null;
//        String valueForNullElements = "null";
//
//        // Act
//        String[] result = arrayUtils.toStringArray(array, valueForNullElements);
//
//        // Assert
//        assertNull(result);
//    }
//
//    @Test
//    @DisplayName("Should return an empty array when input array is empty")
//    void shouldReturnEmptyArrayWhenInputArrayIsEmpty() {
//        // Arrange
//        Object[] array = {};
//        String valueForNullElements = "null";
//
//        // Act
//        String[] result = arrayUtils.toStringArray(array, valueForNullElements);
//
//        // Assert
//        assertEquals(0, result.length);
//    }
//
//    @Test
//    @DisplayName("Should return an array with string representation of each element")
//    void shouldReturnArrayWithStringRepresentationOfEachElement() {
//        // Arrange
//        Object[] array = {1, null, true};
//        String valueForNullElements = "null";
//
//        // Act
//        String[] result = arrayUtils.toStringArray(array, valueForNullElements);
//
//        // Assert
//        assertEquals(3, result.length);
//        assertEquals("1", result[0]);
//        assertEquals("null", result[1]);
//        assertEquals("true", result[2]);
//    }
//
//    @Test
//    void testNullToEmpty_withNullBooleanArray_returnsEmptyBooleanArray() {
//        boolean[] result = arrayUtils.nullToEmpty((boolean[]) null);
//
//        assertNotNull(result);
//        assertEquals(0, result.length);
//        assertSame(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
//    }
//
//    @Test
//    void testNullToEmpty_withEmptyBooleanArray_returnsSameArray() {
//        boolean[] array = new boolean[0];
//
//        boolean[] result = arrayUtils.nullToEmpty(array);
//
//        assertSame(array, result);
//    }
//
//    @Test
//    void testNullToEmpty_withNonEmptyBooleanArray_returnsSameArray() {
//        boolean[] array = {true, false};
//
//        boolean[] result = arrayUtils.nullToEmpty(array);
//
//        assertSame(array, result);
//    }
//

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

    @Test
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex1() {
        boolean[] array = {true, false, true, false, true};
        boolean valueToFind = false;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex1() {
        boolean[] array = {true, false, true, false, true};
        boolean valueToFind = false;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex2() {
        byte[] array = {1, 2, 3, 2, 1};
        byte valueToFind = 2;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex2() {
        byte[] array = {1, 2, 3, 2, 1};
        byte valueToFind = 2;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex3() {
        char[] array = {'a', 'b', 'c', 'b', 'a'};
        char valueToFind = 'b';
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex3() {
        char[] array = {'a', 'b', 'c', 'b', 'a'};
        char valueToFind = 'b';
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex4() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 1.0};
        double valueToFind = 2.0;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex4() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 1.0};
        double valueToFind = 2.0;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex5() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 1.0f};
        float valueToFind = 2.0f;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex5() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 1.0f};
        float valueToFind = 2.0f;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex6() {
        int[] array = {1, 2, 3, 2, 1};
        int valueToFind = 2;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex6() {
        int[] array = {1, 2, 3, 2, 1};
        int valueToFind = 2;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex7() {
        long[] array = {1L, 2L, 3L, 2L, 1L};
        long valueToFind = 2L;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex7() {
        long[] array = {1L, 2L, 3L, 2L, 1L};
        long valueToFind = 2L;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex8() {
        Object[] array = {1, 2, 3, 2, 1};
        Object valueToFind = 2;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex8() {
        Object[] array = {1, 2, 3, 2, 1};
        Object valueToFind = 2;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
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

    @Test
    @DisplayName("should return index of value when value is found in array starting at the given index")
    void testIndexOfValueFoundStartingAtIndex9() {
        short[] array = {1, 2, 3, 2, 1};
        short valueToFind = 2;
        int startIndex = 1;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("should return -1 when value is not found in array starting at the given index")
    void testIndexOfValueNotFoundStartingAtIndex9() {
        short[] array = {1, 2, 3, 2, 1};
        short valueToFind = 2;
        int startIndex = 3;

        int result = ArrayUtils.indexOf(array, valueToFind, startIndex);

        assertEquals(-1, result);
    }


}