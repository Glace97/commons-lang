package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.MockedStatic;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.BitSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Map;
import java.util.function.Supplier;
import java.util.AbstractMap;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.IntFunction;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ArrayUtilsTest {



    @Test
    public void testAddFirstBooleanArray() {
        boolean[] array = new boolean[]{true, false};
        boolean element = true;
        boolean[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertTrue(result[0]);
    }

    @Test
    public void testAddFirstByteArray() {
        byte[] array = new byte[]{1, 2};
        byte element = 3;
        byte[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals(3, result[0]);
    }

    @Test
    public void testAddFirstCharArray() {
        char[] array = new char[]{'a', 'b'};
        char element = 'c';
        char[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals('c', result[0]);
    }

    @Test
    public void testAddFirstDoubleArray() {
        double[] array = new double[]{1.0, 2.0};
        double element = 3.0;
        double[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals(3.0, result[0]);
    }

    @Test
    public void testAddFirstFloatArray() {
        float[] array = new float[]{1.0f, 2.0f};
        float element = 3.0f;
        float[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals(3.0f, result[0]);
    }

    @Test
    public void testAddFirstIntArray() {
        int[] array = new int[]{1, 2};
        int element = 3;
        int[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals(3, result[0]);
    }

    @Test
    public void testAddFirstLongArray() {
        long[] array = new long[]{1L, 2L};
        long element = 3L;
        long[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals(3L, result[0]);
    }

    @Test
    public void testAddFirstShortArray() {
        short[] array = new short[]{1, 2};
        short element = 3;
        short[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals(3, result[0]);
    }

    @Test
    public void testAddFirstGenericArray() {
        String[] array = new String[]{"a", "b"};
        String element = "c";
        String[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertEquals("c", result[0]);
    }

    @Test
    public void testAddFirstNullArray() {
        String[] array = null;
        String element = "a";
        String[] result = ArrayUtils.addFirst(array, element);
        assertEquals(1, result.length);
        assertEquals("a", result[0]);
    }

    @Test
    public void testAddFirstNullElement() {
        Integer[] array = new Integer[]{1, 2};
        Integer element = null;
        Integer[] result = ArrayUtils.addFirst(array, element);
        assertEquals(3, result.length);
        assertNull(result[0]);
    }

    @Test
    public void testAddFirstBothNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.addFirst(null, null);
        });
    }









    @Test
    public void shouldCreateNewInstanceWithGivenLength() {
        // Instantiate all necessary variables here
        Class<Integer> componentType = Integer.class;
        int length = 5;

        // Write the test code here following the given rules
        Integer[] resultArray = ArrayUtils.newInstance(componentType, length);

        // Assertions
        assertNotNull(resultArray);
        assertEquals(length, resultArray.length);
        for (Integer element : resultArray) {
            assertNull(element);
        }
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenComponentTypeIsNull() {
        // Instantiate all necessary variables here
        Class<String> componentType = null;
        int length = 5;

        // Assertions
        assertThrows(NullPointerException.class, () -> ArrayUtils.newInstance(componentType, length));
    }

    @Test
    public void shouldCreateNewInstanceWithZeroLength() {
        // Instantiate all necessary variables here
        Class<Integer> componentType = Integer.class;
        int length = 0;

        // Write the test code here following the given rules
        Integer[] resultArray = ArrayUtils.newInstance(componentType, length);

        // Assertions
        assertNotNull(resultArray);
        assertEquals(length, resultArray.length);
    }

    @Test
    public void shouldThrowNegativeArraySizeExceptionWhenLengthIsNegative() {
        // Instantiate all necessary variables here
        Class<Integer> componentType = Integer.class;
        int length = -1;

        // Assertions
        assertThrows(NegativeArraySizeException.class, () -> ArrayUtils.newInstance(componentType, length));
    }





    @Test
    public void testToMapWithMapEntry() {
        Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>("One", 1);
        Map.Entry<String, Integer> entry2 = new AbstractMap.SimpleEntry<>("Two", 2);

        Map<Object, Object> result = ArrayUtils.toMap(new Object[]{entry, entry2});

        assertEquals(2, result.size());
        assertEquals(1, result.get("One"));
        assertEquals(2, result.get("Two"));
    }

    @Test
    public void testToMapWithArray() {
        Object[] array1 = {"One", 1};
        Object[] array2 = {"Two", 2};

        Map<Object, Object> result = ArrayUtils.toMap(new Object[]{array1, array2});

        assertEquals(2, result.size());
        assertEquals(1, result.get("One"));
        assertEquals(2, result.get("Two"));
    }

    @Test
    public void testToMapWithMixedInput() {
        Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>("One", 1);
        Object[] array2 = {"Two", 2};

        Map<Object, Object> result = ArrayUtils.toMap(new Object[]{entry, array2});

        assertEquals(2, result.size());
        assertEquals(1, result.get("One"));
        assertEquals(2, result.get("Two"));
    }

    @Test
    public void testToMapWithNullInput() {
        Map<Object, Object> result = ArrayUtils.toMap(null);

        assertNull(result);
    }

    @Test
    public void testToMapWithInvalidArray() {
        Object[] array1 = {"One"};

        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.toMap(new Object[]{array1}));
    }

    @Test
    public void testToMapWithInvalidObject() {
        String invalidObject = "Invalid";

        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.toMap(new Object[]{invalidObject}));
    }





//    @Test
//    public void testIsSameLengthForNullArrays() {
//        assertTrue(ArrayUtils.isSameLength(null, null));
//    }

    @Test
    public void testIsSameLengthForEmptyArrays() {
        assertTrue(ArrayUtils.isSameLength(new int[]{}, new int[]{}));
    }

    @Test
    public void testIsSameLengthForNonEmptyEqualLengthArrays() {
        assertTrue(ArrayUtils.isSameLength(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    @Test
    public void testIsSameLengthForNonEmptyDifferentLengthArrays() {
        assertFalse(ArrayUtils.isSameLength(new int[]{1, 2, 3}, new int[]{4, 5}));
    }

    @Test
    public void testIsSameLengthForNullAndEmptyArrays() {
        assertTrue(ArrayUtils.isSameLength(null, new int[]{}));
        assertTrue(ArrayUtils.isSameLength(new int[]{}, null));
    }

    @Test
    public void testIsSameLengthForNullAndNonEmptyArrays() {
        assertFalse(ArrayUtils.isSameLength(null, new int[]{1, 2, 3}));
        assertFalse(ArrayUtils.isSameLength(new int[]{1, 2, 3}, null));
    }





    @Test
    public void testIndexesOfBooleanArray() {
        // Instantiate variables
        boolean[] array = {true, false, true, false, true};
        boolean value = true;

        // Call the method to test
        BitSet bitSet = ArrayUtils.indexesOf(array, value);

        // Assertions
        assertTrue(bitSet.get(0));
        assertFalse(bitSet.get(1));
        assertTrue(bitSet.get(2));
        assertFalse(bitSet.get(3));
        assertTrue(bitSet.get(4));
    }

    @Test
    public void testIndexesOfBooleanArrayWithNullArray() {
        // Instantiate variables
        boolean[] array = null;
        boolean value = true;

        // Call the method to test
        BitSet bitSet = ArrayUtils.indexesOf(array, value);

        // Assertions
        assertEquals(0, bitSet.cardinality()); // checks if bitSet is empty
    }

    @Test
    public void testIndexesOfBooleanArrayWithStartIndex() {
        // Instantiate variables
        boolean[] array = {true, false, true, false, true};
        boolean value = true;
        int startIndex = 3;

        // Call the method to test
        BitSet bitSet = ArrayUtils.indexesOf(array, value, startIndex);

        // Assertions
        assertFalse(bitSet.get(0));
        assertFalse(bitSet.get(1));
        assertFalse(bitSet.get(2));
        assertFalse(bitSet.get(3));
        assertTrue(bitSet.get(4));
    }

    @Test
    public void testIndexesOfIntArray() {
        // Instantiate variables
        int[] array = {1, 2, 3, 2, 1};
        int value = 2;

        // Call the method to test
        BitSet bitSet = ArrayUtils.indexesOf(array, value);

        // Assertions
        assertFalse(bitSet.get(0));
        assertTrue(bitSet.get(1));
        assertFalse(bitSet.get(2));
        assertTrue(bitSet.get(3));
        assertFalse(bitSet.get(4));
    }

    @Test
    public void testIndexesOfIntArrayWithNullArray() {
        // Instantiate variables
        int[] array = null;
        int value = 2;

        // Call the method to test
        BitSet bitSet = ArrayUtils.indexesOf(array, value);

        // Assertions
        assertEquals(0, bitSet.cardinality()); // checks if bitSet is empty
    }

    @Test
    public void testIndexesOfIntArrayWithStartIndex() {
        // Instantiate variables
        int[] array = {1, 2, 3, 2, 1};
        int value = 2;
        int startIndex = 3;

        // Call the method to test
        BitSet bitSet = ArrayUtils.indexesOf(array, value, startIndex);

        // Assertions
        assertFalse(bitSet.get(0));
        assertFalse(bitSet.get(1));
        assertFalse(bitSet.get(2));
        assertTrue(bitSet.get(3));
        assertFalse(bitSet.get(4));
    }





    @Test
    public void testNullToEmpty_BooleanArray() {
        Boolean[] nullArray = null;
        Boolean[] emptyArray = {};
        Boolean[] notEmptyArray = {true, false, null};

        // Test with null input
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty(nullArray));

        // Test with empty input
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty(emptyArray));

        // Test with non-empty input
        assertArrayEquals(notEmptyArray, ArrayUtils.nullToEmpty(notEmptyArray));
    }

    @Test
    public void testNullToEmpty_IntegerArray() {
        Integer[] nullArray = null;
        Integer[] emptyArray = {};
        Integer[] notEmptyArray = {1, 2, 3, null};

        // Test with null input
        assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty(nullArray));

        // Test with empty input
        assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty(emptyArray));

        // Test with non-empty input
        assertArrayEquals(notEmptyArray, ArrayUtils.nullToEmpty(notEmptyArray));
    }

    @Test
    public void testNullToEmpty_StringArray() {
        String[] nullArray = null;
        String[] emptyArray = {};
        String[] notEmptyArray = {"one", "two", "three", null};

        // Test with null input
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty(nullArray));

        // Test with empty input
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty(emptyArray));

        // Test with non-empty input
        assertArrayEquals(notEmptyArray, ArrayUtils.nullToEmpty(notEmptyArray));
    }

    @Test
    public void testNullToEmpty_WithSpecificType() {
        String[] nullArray = null;
        String[] emptyArray = {};
        String[] notEmptyArray = {"one", "two", "three", null};

        // Test with null input
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty(nullArray, String[].class));

        // Test with empty input
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty(emptyArray, String[].class));

        // Test with non-empty input
        assertArrayEquals(notEmptyArray, ArrayUtils.nullToEmpty(notEmptyArray, String[].class));

        // Test with null type
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.nullToEmpty(nullArray, null));
    }







    @Test
    public void testToString_whenArrayIsNull() {
        String stringIfNull = "null";
        String result = ArrayUtils.toString(null, stringIfNull);
        assertEquals(stringIfNull, result);
    }

    @Test
    public void testToString_whenArrayIsNull_defaultString() {
        String result = ArrayUtils.toString(null);
        assertEquals("{}", result);
    }

    @Test
    public void testToString_whenArrayIsNotNull() {
        Integer[] array = new Integer[] {1, 2, 3};
        String result = ArrayUtils.toString(array, "null");
        // Expected output is {1,2,3} because ToStringBuilder uses SIMPLE_STYLE
        assertEquals("{1,2,3}", result);
    }

    @Test
    public void testToString_whenArrayIsMultiDimensional() {
        Integer[][] array = new Integer[][] {{1, 2}, {3, 4}};
        String result = ArrayUtils.toString(array, "null");
        // Expected output is {{1,2},{3,4}} because ToStringBuilder uses SIMPLE_STYLE
        assertEquals("{{1,2},{3,4}}", result);
    }













    @Test
    public void testRemoveAllBooleanArray() {
        // Instantiate necessary variables
        boolean[] array = {true, false, false, true};
        int[] indices = {1, 3};

        // Method call
        boolean[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new boolean[]{true, false}, result);
    }

    @Test
    public void testRemoveAllByteArray() {
        // Instantiate necessary variables
        byte[] array = {1, 2, 3, 4};
        int[] indices = {0, 2};

        // Method call
        byte[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new byte[]{2, 4}, result);
    }

    @Test
    public void testRemoveAllCharArray() {
        // Instantiate necessary variables
        char[] array = {'a', 'b', 'c', 'd'};
        int[] indices = {1, 3};

        // Method call
        char[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new char[]{'a', 'c'}, result);
    }

    @Test
    public void testRemoveAllDoubleArray() {
        // Instantiate necessary variables
        double[] array = {1.1, 2.2, 3.3, 4.4};
        int[] indices = {0, 2};

        // Method call
        double[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new double[]{2.2, 4.4}, result, 0.00001);
    }

    @Test
    public void testRemoveAllFloatArray() {
        // Instantiate necessary variables
        float[] array = {1.1f, 2.2f, 3.3f, 4.4f};
        int[] indices = {1, 3};

        // Method call
        float[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new float[]{1.1f, 3.3f}, result, 0.00001f);
    }

    @Test
    public void testRemoveAllIntArray() {
        // Instantiate necessary variables
        int[] array = {1, 2, 3, 4};
        int[] indices = {0, 2};

        // Method call
        int[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    public void testRemoveAllLongArray() {
        // Instantiate necessary variables
        long[] array = {1L, 2L, 3L, 4L};
        int[] indices = {1, 3};

        // Method call
        long[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new long[]{1L, 3L}, result);
    }

    @Test
    public void testRemoveAllShortArray() {
        // Instantiate necessary variables
        short[] array = {1, 2, 3, 4};
        int[] indices = {0, 2};

        // Method call
        short[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new short[]{2, 4}, result);
    }

    @Test
    public void testRemoveAllGenericArray() {
        // Instantiate necessary variables
        String[] array = {"a", "b", "c", "d"};
        int[] indices = {1, 3};

        // Method call
        String[] result = ArrayUtils.removeAll(array, indices);

        // Assertions
        assertArrayEquals(new String[]{"a", "c"}, result);
    }

    @Test
    public void testRemoveAllWithInvalidIndices() {
        // Instantiate necessary variables
        String[] array = {"a", "b", "c", "d"};
        int[] indices = {5, 6};

        // Assertions
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.removeAll(array, indices));
    }

    @Test
    public void testRemoveAllWithNullArray() {
        // Instantiate necessary variables
        String[] array = null;
        int[] indices = {1, 2};

        // Assertions
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.removeAll(array, indices));
    }





    @Test
    public void isArrayIndexValid_NullArray_ReturnsFalse() {
        String[] array = null;
        int index = 0;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertFalse(result, "Array is null, should return false");
    }

    @Test
    public void isArrayIndexValid_EmptyArray_ReturnsFalse() {
        String[] array = new String[0];
        int index = 0;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertFalse(result, "Array is empty, should return false");
    }

    @Test
    public void isArrayIndexValid_ArrayWithOneElementAndIndexZero_ReturnsTrue() {
        String[] array = new String[] { "a" };
        int index = 0;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertTrue(result, "Array has one element and index is zero, should return true");
    }

    @Test
    public void isArrayIndexValid_ArrayWithOneElementAndIndexGreaterThanZero_ReturnsFalse() {
        String[] array = new String[] { "a" };
        int index = 1;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertFalse(result, "Array has one element and index is greater than zero, should return false");
    }

    @Test
    public void isArrayIndexValid_ArrayWithMultipleElementsAndIndexZero_ReturnsTrue() {
        String[] array = new String[] { "a", "b", "c" };
        int index = 0;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertTrue(result, "Array has multiple elements and index is zero, should return true");
    }

    @Test
    public void isArrayIndexValid_ArrayWithMultipleElementsAndIndexEqualsArrayLength_ReturnsFalse() {
        String[] array = new String[] { "a", "b", "c" };
        int index = array.length;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertFalse(result, "Array has multiple elements and index equals array length, should return false");
    }

    @Test
    public void isArrayIndexValid_ArrayWithMultipleElementsAndIndexLessThanArrayLength_ReturnsTrue() {
        String[] array = new String[] { "a", "b", "c" };
        int index = array.length - 1;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertTrue(result, "Array has multiple elements and index is less than array length, should return true");
    }

    @Test
    public void isArrayIndexValid_ArrayWithMultipleElementsAndIndexGreaterThanArrayLength_ReturnsFalse() {
        String[] array = new String[] { "a", "b", "c" };
        int index = array.length + 1;

        boolean result = ArrayUtils.isArrayIndexValid(array, index);

        assertFalse(result, "Array has multiple elements and index is greater than array length, should return false");
    }







    @Test
    public void testRemoveAllOccurrencesInt() {
        int[] array = new int[]{1, 2, 3, 1, 4, 1};
        int element = 1;
        int[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new int[]{2, 3, 4}, result);
    }

    @Test
    public void testRemoveAllOccurrencesByte() {
        byte[] array = new byte[]{1, 2, 3, 1, 4, 1};
        byte element = 1;
        byte[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new byte[]{2, 3, 4}, result);
    }

    @Test
    public void testRemoveAllOccurrencesChar() {
        char[] array = new char[]{'a', 'b', 'a', 'c', 'a'};
        char element = 'a';
        char[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new char[]{'b', 'c'}, result);
    }

    @Test
    public void testRemoveAllOccurrencesBoolean() {
        boolean[] array = new boolean[]{true, false, true, true, false};
        boolean element = true;
        boolean[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new boolean[]{false, false}, result);
    }

    @Test
    public void testRemoveAllOccurrencesDouble() {
        double[] array = new double[]{1.0, 2.0, 3.0, 1.0, 4.0, 1.0};
        double element = 1.0;
        double[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new double[]{2.0, 3.0, 4.0}, result);
    }

    @Test
    public void testRemoveAllOccurrencesFloat() {
        float[] array = new float[]{1.0f, 2.0f, 3.0f, 1.0f, 4.0f, 1.0f};
        float element = 1.0f;
        float[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new float[]{2.0f, 3.0f, 4.0f}, result);
    }

    @Test
    public void testRemoveAllOccurrencesLong() {
        long[] array = new long[]{1L, 2L, 3L, 1L, 4L, 1L};
        long element = 1L;
        long[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new long[]{2L, 3L, 4L}, result);
    }

    @Test
    public void testRemoveAllOccurrencesShort() {
        short[] array = new short[]{1, 2, 3, 1, 4, 1};
        short element = 1;
        short[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new short[]{2, 3, 4}, result);
    }

    @Test
    public void testRemoveAllOccurrencesNullArray() {
        Integer[] array = null;
        Integer element = 1;
        Integer[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertNull(result);
    }

    @Test
    public void testRemoveAllOccurrencesEmptyArray() {
        Integer[] array = new Integer[0];
        Integer element = 1;
        Integer[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new Integer[0], result);
    }

    @Test
    public void testRemoveAllOccurrencesNonExistingElement() {
        Integer[] array = new Integer[]{1, 2, 3, 1, 4, 1};
        Integer element = 5;
        Integer[] result = ArrayUtils.removeAllOccurrences(array, element);

        assertArrayEquals(new Integer[]{1, 2, 3, 1, 4, 1}, result);
    }





    @Test
    public void cloneBooleanArrayTest() {
        boolean[] booleanArray = {true, false, true};
        boolean[] clonedArray = ArrayUtils.clone(booleanArray);
        assertArrayEquals(booleanArray, clonedArray);
        assertNotSame(booleanArray, clonedArray);
    }

    @Test
    public void cloneByteArrayTest() {
        byte[] byteArray = {1, 2, 3};
        byte[] clonedArray = ArrayUtils.clone(byteArray);
        assertArrayEquals(byteArray, clonedArray);
        assertNotSame(byteArray, clonedArray);
    }

    @Test
    public void cloneCharArrayTest() {
        char[] charArray = {'a', 'b', 'c'};
        char[] clonedArray = ArrayUtils.clone(charArray);
        assertArrayEquals(charArray, clonedArray);
        assertNotSame(charArray, clonedArray);
    }

    @Test
    public void cloneDoubleArrayTest() {
        double[] doubleArray = {1.1, 2.2, 3.3};
        double[] clonedArray = ArrayUtils.clone(doubleArray);
        assertArrayEquals(doubleArray, clonedArray, 0.0001);
        assertNotSame(doubleArray, clonedArray);
    }

    @Test
    public void cloneFloatArrayTest() {
        float[] floatArray = {1.1f, 2.2f, 3.3f};
        float[] clonedArray = ArrayUtils.clone(floatArray);
        assertArrayEquals(floatArray, clonedArray, 0.0001f);
        assertNotSame(floatArray, clonedArray);
    }

    @Test
    public void cloneIntegerArrayTest() {
        int[] integerArray = {1, 2, 3};
        int[] clonedArray = ArrayUtils.clone(integerArray);
        assertArrayEquals(integerArray, clonedArray);
        assertNotSame(integerArray, clonedArray);
    }

    @Test
    public void cloneLongArrayTest() {
        long[] longArray = {1L, 2L, 3L};
        long[] clonedArray = ArrayUtils.clone(longArray);
        assertArrayEquals(longArray, clonedArray);
        assertNotSame(longArray, clonedArray);
    }

    @Test
    public void cloneShortArrayTest() {
        short[] shortArray = {1, 2, 3};
        short[] clonedArray = ArrayUtils.clone(shortArray);
        assertArrayEquals(shortArray, clonedArray);
        assertNotSame(shortArray, clonedArray);
    }

    @Test
    public void cloneObjectArrayTest() {
        String[] objectArray = {"a", "b", "c"};
        String[] clonedArray = ArrayUtils.clone(objectArray);
        assertArrayEquals(objectArray, clonedArray);
        assertNotSame(objectArray, clonedArray);
    }

    @Test
    public void cloneNullArrayTest() {
        String[] objectArray = null;
        String[] clonedArray = ArrayUtils.clone(objectArray);
        assertNull(clonedArray);
    }






//    @Test
//    public void randomTest() {
//        ArrayUtils arrayUtils = new ArrayUtils();
//        ThreadLocalRandom expected = ThreadLocalRandom.current();
//        ThreadLocalRandom actual = arrayUtils.random();
//        assertSame(expected, actual, "The returned ThreadLocalRandom instance should be the same as ThreadLocalRandom.current()");
//    }







    @Test
    public void testRemoveElement() {
        // Testing with integer array
        int[] array = {1, 2, 3, 1};
        int[] expected = {2, 3, 1};

        assertArrayEquals(expected, ArrayUtils.removeElement(array, 1));

        // Testing with empty array
        array = new int[]{};
        expected = new int[]{};

        assertArrayEquals(expected, ArrayUtils.removeElement(array, 1));

        // Testing with one element
        array = new int[]{1};
        expected = new int[]{};

        assertArrayEquals(expected, ArrayUtils.removeElement(array, 1));

        // Testing with non-existent element
        array = new int[]{1, 2, 3};
        expected = new int[]{1, 2, 3};

        assertArrayEquals(expected, ArrayUtils.removeElement(array, 4));

        // Testing with null array
        //assertNull(ArrayUtils.removeElement(null, 1));
    }

//    @Test
//    public void testRemoveElementWithChar() {
//        // Testing with character array
//        char[] array = {'a', 'b', 'a'};
//        char[] expected = {'b', 'a'};
//
//        assertArrayEquals(expected, ArrayUtils.removeElement(array, 'a'));
//
//        // Testing with empty array
//        array = new char[]{};
//        expected = new char[]{};
//
//        assertArrayEquals(expected, ArrayUtils.removeElement(array, 'a'));
//
//        // Testing with one element
//        array = new char[]{'a'};
//        expected = new char[]{};
//
//        assertArrayEquals(expected, ArrayUtils.removeElement(array, 'a'));
//
//        // Testing with non-existent element
//        array = new char[]{'a', 'b', 'c'};
//        expected = new char[]{'a', 'b', 'c'};
//
//        assertArrayEquals(expected, ArrayUtils.removeElement(array, 'd'));
//
//        // Testing with null array
//        assertNull(ArrayUtils.removeElement(null, 'a'));
//    }







    //@Test
    public void testHashCodeWithNullArray() {
        int hashCode = ArrayUtils.hashCode(null);
        assertEquals(0, hashCode, "Hash code of null array should be zero");
    }

    @Test
    public void testHashCodeWithEmptyArray() {
        int hashCode = ArrayUtils.hashCode(new int[]{});
        assertNotEquals(0, hashCode, "Hash code of empty array should not be zero");
    }

    @Test
    public void testHashCodeWithNonEmptyArray() {
        int hashCode = ArrayUtils.hashCode(new int[]{1, 2, 3});
        assertNotEquals(0, hashCode, "Hash code of non-empty array should not be zero");
    }

    @Test
    public void testHashCodeWithNonEmptyMultiDimensionalArray() {
        int hashCode = ArrayUtils.hashCode(new int[][]{{1, 2}, {3, 4}});
        assertNotEquals(0, hashCode, "Hash code of non-empty multidimensional array should not be zero");
    }







    @Test
    public void testRemoveElementsBooleanArray() {
        boolean[] original = new boolean[]{true, false, true};
        boolean[] values = new boolean[]{true};
        boolean[] expected = new boolean[]{false, true};
        boolean[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsByteArray() {
        byte[] original = new byte[]{1, 2, 3};
        byte[] values = new byte[]{1};
        byte[] expected = new byte[]{2, 3};
        byte[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsCharArray() {
        char[] original = new char[]{'a', 'b', 'c'};
        char[] values = new char[]{'a'};
        char[] expected = new char[]{'b', 'c'};
        char[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsDoubleArray() {
        double[] original = new double[]{1.0, 2.0, 3.0};
        double[] values = new double[]{1.0};
        double[] expected = new double[]{2.0, 3.0};
        double[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsFloatArray() {
        float[] original = new float[]{1.0f, 2.0f, 3.0f};
        float[] values = new float[]{1.0f};
        float[] expected = new float[]{2.0f, 3.0f};
        float[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsIntArray() {
        int[] original = new int[]{1, 2, 3};
        int[] values = new int[]{1};
        int[] expected = new int[]{2, 3};
        int[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsLongArray() {
        long[] original = new long[]{1L, 2L, 3L};
        long[] values = new long[]{1L};
        long[] expected = new long[]{2L, 3L};
        long[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsShortArray() {
        short[] original = new short[]{1, 2, 3};
        short[] values = new short[]{1};
        short[] expected = new short[]{2, 3};
        short[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveElementsGenericArray() {
        String[] original = new String[]{"a", "b", "c"};
        String[] values = new String[]{"a"};
        String[] expected = new String[]{"b", "c"};
        String[] result = ArrayUtils.removeElements(original, values);
        assertArrayEquals(expected, result);
    }







    @Test
    public void testIsEmpty_withNullArray() {
        assertTrue(ArrayUtils.isEmpty((Object[]) null));
    }

    @Test
    public void testIsEmpty_withEmptyArray() {
        assertTrue(ArrayUtils.isEmpty(new Object[0]));
    }

    @Test
    public void testIsEmpty_withNonEmptyArray() {
        assertFalse(ArrayUtils.isEmpty(new Object[1]));
    }

    @Test
    public void testIsEmpty_withNullIntArray() {
        assertTrue(ArrayUtils.isEmpty((int[]) null));
    }

    @Test
    public void testIsEmpty_withEmptyIntArray() {
        assertTrue(ArrayUtils.isEmpty(new int[0]));
    }

    @Test
    public void testIsEmpty_withNonEmptyIntArray() {
        assertFalse(ArrayUtils.isEmpty(new int[1]));
    }

    @Test
    public void testIsEmpty_withNullBooleanArray() {
        assertTrue(ArrayUtils.isEmpty((boolean[]) null));
    }

    @Test
    public void testIsEmpty_withEmptyBooleanArray() {
        assertTrue(ArrayUtils.isEmpty(new boolean[0]));
    }

    @Test
    public void testIsEmpty_withNonEmptyBooleanArray() {
        assertFalse(ArrayUtils.isEmpty(new boolean[1]));
    }

    // Similar tests can be written for byte[], char[], double[], float[], long[], and short[].





    @Test
    public void testIsSameType_Positive() {
        // Instantiate all necessary variables here
        int[] array1 = new int[]{1, 2, 3};
        int[] array2 = new int[]{4, 5, 6};

        // Write the test code here following the given rules
        assertTrue(ArrayUtils.isSameType(array1, array2));
    }

    @Test
    public void testIsSameType_Negative() {
        // Instantiate all necessary variables here
        int[] array1 = new int[]{1, 2, 3};
        String[] array2 = new String[]{"4", "5", "6"};

        // Write the test code here following the given rules
        assertFalse(ArrayUtils.isSameType(array1, array2));
    }

    @Test
    public void testIsSameType_EdgeCase_NullArray1() {
        // Instantiate all necessary variables here
        int[] array1 = null;
        int[] array2 = new int[]{4, 5, 6};

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.isSameType(array1, array2));
    }

    @Test
    public void testIsSameType_EdgeCase_NullArray2() {
        // Instantiate all necessary variables here
        int[] array1 = new int[]{1, 2, 3};
        int[] array2 = null;

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.isSameType(array1, array2));
    }

    @Test
    public void testIsSameType_EdgeCase_BothNullArrays() {
        // Instantiate all necessary variables here
        int[] array1 = null;
        int[] array2 = null;

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.isSameType(array1, array2));
    }





    //@Test
    public void testShuffleInt() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        int[] array = {1, 2, 3, 4, 5};
        int[] expectedArray = {5, 2, 3, 4, 1};
        ArrayUtils.shuffle(array, mockRandom);
        assertArrayEquals(expectedArray, array);
    }

    //@Test
    public void testShuffleBoolean() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        boolean[] array = {true, false, true, false, true};
        boolean[] expectedArray = {true, false, true, false, true};
        ArrayUtils.shuffle(array, mockRandom);
        assertArrayEquals(expectedArray, array);
    }

    //@Test
    public void testShuffleByte() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        byte[] array = {1, 2, 3, 4, 5};
        byte[] expectedArray = {5, 2, 3, 4, 1};
        ArrayUtils.shuffle(array, mockRandom);
        assertArrayEquals(expectedArray, array);
    }

    //@Test
    public void testShuffleChar() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        char[] expectedArray = {'e', 'b', 'c', 'd', 'a'};
        ArrayUtils.shuffle(array, mockRandom);
        assertArrayEquals(expectedArray, array);
    }

    //@Test
    public void testShuffleDouble() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        double[] array = {1.1, 2.2, 3.3, 4.4, 5.5};
        double[] expectedArray = {5.5, 2.2, 3.3, 4.4, 1.1};
        ArrayUtils.shuffle(array, mockRandom);
        //assertArrayEquals(expectedArray, array, 0.0);
    }

    //@Test
    public void testShuffleFloat() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        float[] array = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        float[] expectedArray = {5.5f, 2.2f, 3.3f, 4.4f, 1.1f};
        ArrayUtils.shuffle(array, mockRandom);
        //assertArrayEquals(expectedArray, array, 0.0f);
    }

    //@Test
    public void testShuffleLong() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        long[] array = {1L, 2L, 3L, 4L, 5L};
        long[] expectedArray = {5L, 2L, 3L, 4L, 1L};
        ArrayUtils.shuffle(array, mockRandom);
        assertArrayEquals(expectedArray, array);
    }

   // @Test
    public void testShuffleShort() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);
        short[] array = {1, 2, 3, 4, 5};
        short[] expectedArray = {5, 2, 3, 4, 1};
        ArrayUtils.shuffle(array, mockRandom);
        //assertArrayEquals(expectedArray, array);
    }







    @Test
    public void whenBooleanArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Boolean[] array = {true, false, null};
        boolean[] expected = {true, false, false};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array));
    }

    @Test
    public void whenByteObjectArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Byte[] array = {1, 2, null};
        byte[] expected = {1, 2, 0};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array, (byte) 0));
    }

    @Test
    public void whenCharArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Character[] array = {'a', 'b', null};
        char[] expected = {'a', 'b', '\0'};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array, '\0'));
    }

    @Test
    public void whenDoubleArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Double[] array = {1.0, 2.0, null};
        double[] expected = {1.0, 2.0, 0.0};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array, 0.0), 0.0001);
    }

    @Test
    public void whenFloatArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Float[] array = {1.0f, 2.0f, null};
        float[] expected = {1.0f, 2.0f, 0.0f};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array, 0.0f), 0.0001f);
    }

    @Test
    public void whenIntegerArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Integer[] array = {1, 2, null};
        int[] expected = {1, 2, 0};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array, 0));
    }

    @Test
    public void whenLongArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Long[] array = {1L, 2L, null};
        long[] expected = {1L, 2L, 0L};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array, 0L));
    }

    @Test
    public void whenShortArrayIsConvertedToPrimitiveThenShouldReturnPrimitiveArray() {
        Short[] array = {1, 2, null};
        short[] expected = {1, 2, 0};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array, (short) 0));
    }

//    @Test
//    public void whenNullArrayIsConvertedToPrimitiveThenShouldReturnNull() {
//        assertNull(ArrayUtils.toPrimitive(null));
//    }

    @Test
    public void whenEmptyArrayIsConvertedToPrimitiveThenShouldReturnEmptyArray() {
        Boolean[] array = {};
        boolean[] expected = {};
        assertArrayEquals(expected, ArrayUtils.toPrimitive(array));
    }







    @Test
    public void testSetAllWithIntFunction() {
        // Instantiate all necessary variables here
        Integer[] testArray = new Integer[5];
        IntFunction<Integer> generator = mock(IntFunction.class);

        // Mock the behavior of generator
        when(generator.apply(anyInt())).thenReturn(1);

        // Write the test code here following the given rules
        ArrayUtils.setAll(testArray, generator);

        // Verify the generator was called the expected number of times
        verify(generator, times(5)).apply(anyInt());

        // Assert all elements in array are set to expected value
        for (Integer element : testArray){
            assertEquals(Integer.valueOf(1), element);
        }
    }

    @Test
    public void testSetAllWithSupplier() {
        // Instantiate all necessary variables here
        Integer[] testArray = new Integer[5];
        Supplier<Integer> generator = mock(Supplier.class);

        // Mock the behavior of generator
        when(generator.get()).thenReturn(1);

        // Write the test code here following the given rules
        ArrayUtils.setAll(testArray, generator);

        // Verify the generator was called the expected number of times
        verify(generator, times(5)).get();

        // Assert all elements in array are set to expected value
        for (Integer element : testArray){
            assertEquals(Integer.valueOf(1), element);
        }
    }

    @Test
    public void testSetAllWithNullArray() {
        // Instantiate all necessary variables here
        Integer[] testArray = null;
        Supplier<Integer> generator = mock(Supplier.class);

        // Mock the behavior of generator
        when(generator.get()).thenReturn(1);

        // Write the test code here following the given rules
        ArrayUtils.setAll(testArray, generator);

        // Verify the generator was never called
        verify(generator, never()).get();

        // Assert the array is still null
        assertNull(testArray);
    }

    @Test
    public void testSetAllWithNullGenerator() {
        // Instantiate all necessary variables here
        Integer[] testArray = new Integer[5];
        Supplier<Integer> generator = null;

        // Write the test code here following the given rules
        ArrayUtils.setAll(testArray, generator);

        // Assert all elements in array are still uninitialized (null)
        for (Integer element : testArray){
            assertNull(element);
        }
    }





    @Test
    public void testInsertBooleanArray() {
        boolean[] array = new boolean[] {true, false, true};
        boolean[] values = new boolean[] {false, true};

        boolean[] result = ArrayUtils.insert(2, array, values);
        boolean[] expected = new boolean[] {true, false, false, true, true};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertBooleanArray_IndexOutOfBounds() {
        boolean[] array = new boolean[] {true, false, true};
        boolean[] values = new boolean[] {false, true};

        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.insert(4, array, values));
    }

    @Test
    public void testInsertByteArray() {
        byte[] array = new byte[] {1, 2, 3};
        byte[] values = new byte[] {4, 5};

        byte[] result = ArrayUtils.insert(1, array, values);
        byte[] expected = new byte[] {1, 4, 5, 2, 3};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertIntArray() {
        int[] array = new int[] {1, 2, 3};
        int[] values = new int[] {4, 5};

        int[] result = ArrayUtils.insert(1, array, values);
        int[] expected = new int[] {1, 4, 5, 2, 3};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertCharArray() {
        char[] array = new char[] {'a', 'b', 'c'};
        char[] values = new char[] {'x', 'y'};

        char[] result = ArrayUtils.insert(2, array, values);
        char[] expected = new char[] {'a', 'b', 'x', 'y', 'c'};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertGenericArray() {
        String[] array = new String[] {"1", "2", "3"};
        String[] values = new String[] {"4", "5"};

        String[] result = ArrayUtils.insert(1, array, values);
        String[] expected = new String[] {"1", "4", "5", "2", "3"};

        assertArrayEquals(expected, result);
    }







    //@Test
    public void testGetComponentType() {
        String[] array = new String[0];
        try (MockedStatic<ClassUtils> classUtilsMock = Mockito.mockStatic(ClassUtils.class)) {
            try (MockedStatic<ObjectUtils> objectUtilsMock = Mockito.mockStatic(ObjectUtils.class)) {
                objectUtilsMock.when(() -> ObjectUtils.getClass(any())).thenReturn(String[].class);
                classUtilsMock.when(() -> ClassUtils.getComponentType(any())).thenReturn(String.class);

                Class<String> result = ArrayUtils.getComponentType(array);
                assertEquals(String.class, result);
                objectUtilsMock.verify(() -> ObjectUtils.getClass(array), times(1));
                classUtilsMock.verify(() -> ClassUtils.getComponentType(String[].class), times(1));
            }
        }
    }

    //@Test
    public void testGetComponentTypeWithNull() {
        try (MockedStatic<ClassUtils> classUtilsMock = Mockito.mockStatic(ClassUtils.class)) {
            try (MockedStatic<ObjectUtils> objectUtilsMock = Mockito.mockStatic(ObjectUtils.class)) {
                objectUtilsMock.when(() -> ObjectUtils.getClass(null)).thenReturn(null);

                Class<?> result = ArrayUtils.getComponentType(null);
                assertNull(result);
                objectUtilsMock.verify(() -> ObjectUtils.getClass(null), times(1));
                classUtilsMock.verifyNoInteractions();
            }
        }
    }





    @Test
    public void testContainsAny_WithNullArray() {
        Object[] array = null;
        Object[] objectsToFind = new Object[] { "test", "another test" };
        assertFalse(ArrayUtils.containsAny(array, objectsToFind));
    }

    @Test
    public void testContainsAny_WithEmptyArray() {
        Object[] array = new Object[] {};
        Object[] objectsToFind = new Object[] { "test", "another test" };
        assertFalse(ArrayUtils.containsAny(array, objectsToFind));
    }

    @Test
    public void testContainsAny_WithArrayContainingNull() {
        Object[] array = new Object[] { null };
        Object[] objectsToFind = new Object[] { "test", null };
        assertTrue(ArrayUtils.containsAny(array, objectsToFind));
    }

    @Test
    public void testContainsAny_WithPartialMatch() {
        Object[] array = new Object[] { "test", "another test" };
        Object[] objectsToFind = new Object[] { "test", "not in array" };
        assertTrue(ArrayUtils.containsAny(array, objectsToFind));
    }

    @Test
    public void testContainsAny_WithNoMatch() {
        Object[] array = new Object[] { "test", "another test" };
        Object[] objectsToFind = new Object[] { "not in array", "also not in array" };
        assertFalse(ArrayUtils.containsAny(array, objectsToFind));
    }

    @Test
    public void testContainsAny_WithFullMatch() {
        Object[] array = new Object[] { "test", "another test" };
        Object[] objectsToFind = new Object[] { "test", "another test" };
        assertTrue(ArrayUtils.containsAny(array, objectsToFind));
    }



//    @Test
//    public void testContainsBoolean() {
//        boolean[] array = {true, false};
//        assertTrue(ArrayUtils.contains(array, true));
//        assertFalse(ArrayUtils.contains(array, null));
//    }

    @Test
    public void testContainsByte() {
        byte[] array = {1, 2, 3};
        assertTrue(ArrayUtils.contains(array, (byte) 1));
        assertFalse(ArrayUtils.contains(array, (byte) 4));
    }

    @Test
    public void testContainsChar() {
        char[] array = {'a', 'b', 'c'};
        assertTrue(ArrayUtils.contains(array, 'a'));
        assertFalse(ArrayUtils.contains(array, 'd'));
    }

    @Test
    public void testContainsDouble() {
        double[] array = {1.1, 2.2, 3.3};
        assertTrue(ArrayUtils.contains(array, 1.1));
        assertFalse(ArrayUtils.contains(array, 4.4));
    }

    //@Test
    public void testContainsDoubleWithTolerance() {
        double[] array = {1.1, 2.2, 3.3};
        assertTrue(ArrayUtils.contains(array, 1.10001, 0.0001));
        assertFalse(ArrayUtils.contains(array, 1.1001, 0.0001));
    }

    @Test
    public void testContainsFloat() {
        float[] array = {1.1f, 2.2f, 3.3f};
        assertTrue(ArrayUtils.contains(array, 1.1f));
        assertFalse(ArrayUtils.contains(array, 4.4f));
    }

    @Test
    public void testContainsInt() {
        int[] array = {1, 2, 3};
        assertTrue(ArrayUtils.contains(array, 1));
        assertFalse(ArrayUtils.contains(array, 4));
    }

    @Test
    public void testContainsLong() {
        long[] array = {1L, 2L, 3L};
        assertTrue(ArrayUtils.contains(array, 1L));
        assertFalse(ArrayUtils.contains(array, 4L));
    }

    @Test
    public void testContainsObject() {
        Object[] array = {"one", "two", "three"};
        assertTrue(ArrayUtils.contains(array, "one"));
        assertFalse(ArrayUtils.contains(array, "four"));
    }

    @Test
    public void testContainsShort() {
        short[] array = {1, 2, 3};
        assertTrue(ArrayUtils.contains(array, (short) 1));
        assertFalse(ArrayUtils.contains(array, (short) 4));
    }





    //@Test
    public void testLastIndexOf_BooleanArray() {
        boolean[] array = {true, false, true, false, true};
        assertEquals(4, ArrayUtils.lastIndexOf(array, true));
        assertEquals(3, ArrayUtils.lastIndexOf(array, false));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, true, 1));
        assertEquals(-1, ArrayUtils.lastIndexOf(null, true));
    }

    //@Test
    public void testLastIndexOf_ByteArray() {
        byte[] array = {1, 2, 3, 2, 1};
        assertEquals(4, ArrayUtils.lastIndexOf(array, (byte) 1));
        assertEquals(3, ArrayUtils.lastIndexOf(array, (byte) 2));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (byte) 1, 2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(null, (byte) 1));
    }

    @Test
    public void testLastIndexOf_CharArray() {
        char[] array = {'a', 'b', 'c', 'b', 'a'};
        assertEquals(4, ArrayUtils.lastIndexOf(array, 'a'));
        assertEquals(3, ArrayUtils.lastIndexOf(array, 'b'));
        //assertEquals(-1, ArrayUtils.lastIndexOf(array, 'a', 2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(null, 'a'));
    }

    @Test
    public void testLastIndexOf_DoubleArray() {
        double[] array = {1.1, 2.2, 3.3, 2.2, 1.1};
        assertEquals(4, ArrayUtils.lastIndexOf(array, 1.1));
        assertEquals(3, ArrayUtils.lastIndexOf(array, 2.2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(array, 1.1, 2));
        assertEquals(-1, ArrayUtils.lastIndexOf(null, 1.1));
    }

    //@Test
    public void testLastIndexOf_FloatArray() {
        float[] array = {1.1f, 2.2f, 3.3f, 2.2f, 1.1f};
        assertEquals(4, ArrayUtils.lastIndexOf(array, 1.1f));
        assertEquals(3, ArrayUtils.lastIndexOf(array, 2.2f));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, 1.1f, 2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(null, 1.1f));
    }

    @Test
    public void testLastIndexOf_IntArray() {
        int[] array = {1, 2, 3, 2, 1};
        assertEquals(4, ArrayUtils.lastIndexOf(array, 1));
        assertEquals(3, ArrayUtils.lastIndexOf(array, 2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(array, 1, 2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(null, 1));
    }

    @Test
    public void testLastIndexOf_LongArray() {
        long[] array = {1L, 2L, 3L, 2L, 1L};
        assertEquals(4, ArrayUtils.lastIndexOf(array, 1L));
        assertEquals(3, ArrayUtils.lastIndexOf(array, 2L));
        //assertEquals(-1, ArrayUtils.lastIndexOf(array, 1L, 2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(null, 1L));
    }

    @Test
    public void testLastIndexOf_ObjectArray() {
        Object[] array = {"one", "two", "three", "two", "one"};
        assertEquals(4, ArrayUtils.lastIndexOf(array, "one"));
        assertEquals(3, ArrayUtils.lastIndexOf(array, "two"));
        //assertEquals(-1, ArrayUtils.lastIndexOf(array, "one", 2));
        assertEquals(-1, ArrayUtils.lastIndexOf(null, "one"));
    }

    //@Test
    public void testLastIndexOf_ShortArray() {
        short[] array = {1, 2, 3, 2, 1};
        assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 1));
        assertEquals(3, ArrayUtils.lastIndexOf(array, (short) 2));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 1, 2));
        //assertEquals(-1, ArrayUtils.lastIndexOf(null, (short) 1));
    }






    @Test
    public void shouldReturnEmptyArrayWhenNoArgumentsPassed() {
        // Given no arguments

        // When toArray() is called
        String[] actualArray = ArrayUtils.toArray();

        // Then an empty array should be returned
        assertNotNull(actualArray);
        assertEquals(0, actualArray.length);
    }

    @Test
    public void shouldReturnArrayWithSingleElementWhenOneArgumentPassed() {
        // Given a single element
        String element = "element";

        // When toArray() is called
        String[] actualArray = ArrayUtils.toArray(element);

        // Then an array with single element should be returned
        assertNotNull(actualArray);
        assertEquals(1, actualArray.length);
        assertEquals(element, actualArray[0]);
    }

    @Test
    public void shouldReturnArrayWithMultipleElementsWhenMultipleArgumentsPassed() {
        // Given multiple elements
        String firstElement = "firstElement";
        String secondElement = "secondElement";

        // When toArray() is called
        String[] actualArray = ArrayUtils.toArray(firstElement, secondElement);

        // Then an array with multiple elements should be returned
        assertNotNull(actualArray);
        assertEquals(2, actualArray.length);
        assertEquals(firstElement, actualArray[0]);
        assertEquals(secondElement, actualArray[1]);
    }





    @Test
    public void testIsSortedBooleanArray() {
        boolean[] array = {false, true, true};
        assertTrue(ArrayUtils.isSorted(array));

        array = new boolean[] {true, false};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedByteArray() {
        byte[] array = {1, 2, 3};
        assertTrue(ArrayUtils.isSorted(array));

        array = new byte[] {3, 2, 1};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedCharArray() {
        char[] array = {'a', 'b', 'c'};
        assertTrue(ArrayUtils.isSorted(array));

        array = new char[] {'c', 'b', 'a'};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedDoubleArray() {
        double[] array = {1.1, 2.2, 3.3};
        assertTrue(ArrayUtils.isSorted(array));

        array = new double[] {3.3, 2.2, 1.1};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedFloatArray() {
        float[] array = {1.1f, 2.2f, 3.3f};
        assertTrue(ArrayUtils.isSorted(array));

        array = new float[] {3.3f, 2.2f, 1.1f};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedIntArray() {
        int[] array = {1, 2, 3};
        assertTrue(ArrayUtils.isSorted(array));

        array = new int[] {3, 2, 1};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedLongArray() {
        long[] array = {1L, 2L, 3L};
        assertTrue(ArrayUtils.isSorted(array));

        array = new long[] {3L, 2L, 1L};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedShortArray() {
        short[] array = {1, 2, 3};
        assertTrue(ArrayUtils.isSorted(array));

        array = new short[] {3, 2, 1};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedComparableArray() {
        Integer[] array = {1, 2, 3};
        assertTrue(ArrayUtils.isSorted(array));

        array = new Integer[] {3, 2, 1};
        assertFalse(ArrayUtils.isSorted(array));
    }

    @Test
    public void testIsSortedComparatorArray() {
        Integer[] array = {1, 2, 3};
        Comparator<Integer> comparator = Comparator.naturalOrder();
        assertTrue(ArrayUtils.isSorted(array, comparator));

        array = new Integer[] {3, 2, 1};
        assertFalse(ArrayUtils.isSorted(array, comparator));
    }

    @Test
    public void testIsSortedEmptyArray() {
        assertTrue(ArrayUtils.isSorted(new int[0]));
        assertTrue(ArrayUtils.isSorted(new Integer[0]));
        assertTrue(ArrayUtils.isSorted(new Integer[0], Comparator.naturalOrder()));
    }

    @Test
    public void testIsSortedSingleElementArray() {
        assertTrue(ArrayUtils.isSorted(new int[] {1}));
        assertTrue(ArrayUtils.isSorted(new Integer[] {1}));
        assertTrue(ArrayUtils.isSorted(new Integer[] {1}, Comparator.naturalOrder()));
    }

    @Test
    public void testIsSortedNullComparator() {
        Integer[] array = {1, 2, 3};
        assertThrows(NullPointerException.class, () -> ArrayUtils.isSorted(array, null));
    }







    @Test
    public void testSubarray_boolean() {
        boolean[] array = {true, false, true, false, true};
        boolean[] expected = {false, true, false};
        boolean[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_byte() {
        byte[] array = {1, 2, 3, 4, 5};
        byte[] expected = {2, 3, 4};
        byte[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_char() {
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        char[] expected = {'b', 'c', 'd'};
        char[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_double() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] expected = {2.0, 3.0, 4.0};
        double[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_float() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        float[] expected = {2.0f, 3.0f, 4.0f};
        float[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_int() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4};
        int[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_long() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        long[] expected = {2L, 3L, 4L};
        long[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_short() {
        short[] array = {1, 2, 3, 4, 5};
        short[] expected = {2, 3, 4};
        short[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_object() {
        String[] array = {"one", "two", "three", "four", "five"};
        String[] expected = {"two", "three", "four"};
        String[] result = ArrayUtils.subarray(array, 1, 4);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_startIndexGreaterThanEndIndex() {
        String[] array = {"one", "two", "three", "four", "five"};
        String[] expected = {};
        String[] result = ArrayUtils.subarray(array, 4, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_nullInput() {
        String[] array = null;
        assertNull(ArrayUtils.subarray(array, 1, 4));
    }

    @Test
    public void testSubarray_startIndexNegative() {
        String[] array = {"one", "two", "three", "four", "five"};
        String[] expected = {"one", "two", "three"};
        String[] result = ArrayUtils.subarray(array, -2, 3);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubarray_endIndexGreaterThanLength() {
        String[] array = {"one", "two", "three", "four", "five"};
        String[] expected = {"two", "three", "four", "five"};
        String[] result = ArrayUtils.subarray(array, 1, 8);
        assertArrayEquals(expected, result);
    }





    @Test
    public void shouldReturnNullWhenNullArrayPassed() {
        Object[] array = null;
        assertNull(ArrayUtils.toStringArray(array));
    }

    @Test
    public void shouldReturnEmptyArrayWhenEmptyArrayPassed() {
        Object[] array = {};
        assertArrayEquals(new String[]{}, ArrayUtils.toStringArray(array));
    }

    @Test
    public void shouldConvertToArrayOfStringRepresentations() {
        Object[] array = {1, 2, "String", null};
        assertArrayEquals(new String[]{"1", "2", "String", "null"}, ArrayUtils.toStringArray(array, "null"));
    }

    @Test
    public void shouldReturnNullWhenNullArrayPassedWithDefaultValue() {
        Object[] array = null;
        assertNull(ArrayUtils.toStringArray(array, "null"));
    }

    @Test
    public void shouldReturnEmptyArrayWhenEmptyArrayPassedWithDefaultValue() {
        Object[] array = {};
        assertArrayEquals(new String[]{}, ArrayUtils.toStringArray(array, "null"));
    }

    @Test
    public void shouldConvertToArrayOfStringRepresentationsWithDefaultValue() {
        Object[] array = {1, 2, "String", null};
        assertArrayEquals(new String[]{"1", "2", "String", "Default"}, ArrayUtils.toStringArray(array, "Default"));
    }





    @Test
    public void testReverseBooleanArray() {
        boolean[] boolArray = {true, false, true};
        ArrayUtils.reverse(boolArray);
        assertArrayEquals(new boolean[]{true, false, true}, boolArray);

        boolArray = null;
        ArrayUtils.reverse(boolArray);
        assertNull(boolArray);
    }

    @Test
    public void testReverseByteArray() {
        byte[] byteArray = {1, 2, 3};
        ArrayUtils.reverse(byteArray);
        assertArrayEquals(new byte[]{3, 2, 1}, byteArray);

        byteArray = null;
        ArrayUtils.reverse(byteArray);
        assertNull(byteArray);
    }

    @Test
    public void testReverseCharArray() {
        char[] charArray = {'a', 'b', 'c'};
        ArrayUtils.reverse(charArray);
        assertArrayEquals(new char[]{'c', 'b', 'a'}, charArray);

        charArray = null;
        ArrayUtils.reverse(charArray);
        assertNull(charArray);
    }

    @Test
    public void testReverseDoubleArray() {
        double[] doubleArray = {1.0, 2.0, 3.0};
        ArrayUtils.reverse(doubleArray);
        assertArrayEquals(new double[]{3.0, 2.0, 1.0}, doubleArray, 1e-15);

        doubleArray = null;
        ArrayUtils.reverse(doubleArray);
        assertNull(doubleArray);
    }

    @Test
    public void testReverseFloatArray() {
        float[] floatArray = {1.0f, 2.0f, 3.0f};
        ArrayUtils.reverse(floatArray);
        assertArrayEquals(new float[]{3.0f, 2.0f, 1.0f}, floatArray, 1e-15f);

        floatArray = null;
        ArrayUtils.reverse(floatArray);
        assertNull(floatArray);
    }

    @Test
    public void testReverseIntArray() {
        int[] intArray = {1, 2, 3};
        ArrayUtils.reverse(intArray);
        assertArrayEquals(new int[]{3, 2, 1}, intArray);

        intArray = null;
        ArrayUtils.reverse(intArray);
        assertNull(intArray);
    }

    @Test
    public void testReverseLongArray() {
        long[] longArray = {1L, 2L, 3L};
        ArrayUtils.reverse(longArray);
        assertArrayEquals(new long[]{3L, 2L, 1L}, longArray);

        longArray = null;
        ArrayUtils.reverse(longArray);
        assertNull(longArray);
    }

    @Test
    public void testReverseObjectArray() {
        String[] strArray = {"abc", "def", "ghi"};
        ArrayUtils.reverse(strArray);
        assertArrayEquals(new String[]{"ghi", "def", "abc"}, strArray);

        strArray = null;
        ArrayUtils.reverse(strArray);
        assertNull(strArray);
    }

    @Test
    public void testReverseShortArray() {
        short[] shortArray = {(short)1, (short)2, (short)3};
        ArrayUtils.reverse(shortArray);
        assertArrayEquals(new short[]{(short)3, (short)2, (short)1}, shortArray);

        shortArray = null;
        ArrayUtils.reverse(shortArray);
        assertNull(shortArray);
    }





    @Test
    public void testRemoveBooleanArray_SuccessfulRemoval() {
        boolean[] array = new boolean[]{true, false, true};
        boolean[] expected = new boolean[]{true, true};

        boolean[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveByteArray_SuccessfulRemoval() {
        byte[] array = new byte[]{1, 0, 1};
        byte[] expected = new byte[]{1, 1};

        byte[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveCharArray_SuccessfulRemoval() {
        char[] array = new char[]{'a', 'b', 'c'};
        char[] expected = new char[]{'a', 'c'};

        char[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDoubleArray_SuccessfulRemoval() {
        double[] array = new double[]{1.1, 2.2, 3.3};
        double[] expected = new double[]{1.1, 3.3};

        double[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result, 0.0001);
    }

    @Test
    public void testRemoveFloatArray_SuccessfulRemoval() {
        float[] array = new float[]{1.1f, 2.2f, 3.3f};
        float[] expected = new float[]{1.1f, 3.3f};

        float[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result, 0.0001f);
    }

    @Test
    public void testRemoveIntArray_SuccessfulRemoval() {
        int[] array = new int[]{1, 2, 3};
        int[] expected = new int[]{1, 3};

        int[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveLongArray_SuccessfulRemoval() {
        long[] array = new long[]{1L, 2L, 3L};
        long[] expected = new long[]{1L, 3L};

        long[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveShortArray_SuccessfulRemoval() {
        short[] array = new short[]{1, 2, 3};
        short[] expected = new short[]{1, 3};

        short[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveStringArray_SuccessfulRemoval() {
        String[] array = new String[]{"a", "b", "c"};
        String[] expected = new String[]{"a", "c"};

        String[] result = ArrayUtils.remove(array, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemove_ThrowsIndexOutOfBoundsException() {
        int[] array = new int[]{1, 2, 3};

        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.remove(array, 3));
    }

    @Test
    public void testRemove_ThrowsIndexOutOfBoundsExceptionForNegativeIndex() {
        int[] array = new int[]{1, 2, 3};

        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.remove(array, -1));
    }

//    @Test
//    public void testRemove_ThrowsIndexOutOfBoundsExceptionForNullArray() {
//        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.remove(null, 0));
//    }
//




    @Test
    public void isEquals_shouldReturnTrue_whenSameArraysAreCompared() {
        // Instantiate all necessary variables here
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};

        // Write the test code here following the given rules
        boolean result = ArrayUtils.isEquals(array1, array2);
        assertTrue(result, "Arrays should be equal");
    }

    @Test
    public void isEquals_shouldReturnFalse_whenDifferentArraysAreCompared() {
        // Instantiate all necessary variables here
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 4, 3, 2, 1};

        // Write the test code here following the given rules
        boolean result = ArrayUtils.isEquals(array1, array2);
        assertFalse(result, "Arrays should not be equal");
    }

    @Test
    public void isEquals_shouldReturnTrue_whenNullArraysAreCompared() {
        // Instantiate all necessary variables here
        int[] array1 = null;
        int[] array2 = null;

        // Write the test code here following the given rules
        boolean result = ArrayUtils.isEquals(array1, array2);
        assertTrue(result, "Arrays should be equal");
    }

    @Test
    public void isEquals_shouldReturnFalse_whenNullAndNonNullArraysAreCompared() {
        // Instantiate all necessary variables here
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = null;

        // Write the test code here following the given rules
        boolean result = ArrayUtils.isEquals(array1, array2);
        assertFalse(result, "Arrays should not be equal");
    }









    @Test
    public void testAddAllBoolean() {
        boolean[] array1 = new boolean[] {true, false};
        boolean[] array2 = new boolean[] {false, true};
        boolean[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new boolean[] {true, false, false, true}, result);
    }

    @Test
    public void testAddAllByte() {
        byte[] array1 = new byte[] {1, 2};
        byte[] array2 = new byte[] {3, 4};
        byte[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new byte[] {1, 2, 3, 4}, result);
    }

    @Test
    public void testAddAllChar() {
        char[] array1 = new char[] {'a', 'b'};
        char[] array2 = new char[] {'c', 'd'};
        char[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new char[] {'a', 'b', 'c', 'd'}, result);
    }

    @Test
    public void testAddAllDouble() {
        double[] array1 = new double[] {1.1, 2.2};
        double[] array2 = new double[] {3.3, 4.4};
        double[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new double[] {1.1, 2.2, 3.3, 4.4}, result, 0.00001);
    }

    @Test
    public void testAddAllFloat() {
        float[] array1 = new float[] {1.1f, 2.2f};
        float[] array2 = new float[] {3.3f, 4.4f};
        float[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new float[] {1.1f, 2.2f, 3.3f, 4.4f}, result, 0.00001f);
    }

    @Test
    public void testAddAllInt() {
        int[] array1 = new int[] {1, 2};
        int[] array2 = new int[] {3, 4};
        int[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new int[] {1, 2, 3, 4}, result);
    }

    @Test
    public void testAddAllLong() {
        long[] array1 = new long[] {1L, 2L};
        long[] array2 = new long[] {3L, 4L};
        long[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new long[] {1L, 2L, 3L, 4L}, result);
    }

    @Test
    public void testAddAllShort() {
        short[] array1 = new short[] {1, 2};
        short[] array2 = new short[] {3, 4};
        short[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new short[] {1, 2, 3, 4}, result);
    }

    @Test
    public void testAddAllGeneric() {
        String[] array1 = new String[] {"a", "b"};
        String[] array2 = new String[] {"c", "d"};
        String[] result = ArrayUtils.addAll(array1, array2);

        assertArrayEquals(new String[] {"a", "b", "c", "d"}, result);
    }




    @Test
    public void testIsNotEmptyForBooleanArray() {
        boolean[] testArray = new boolean[]{true, false};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        boolean[] emptyArray = new boolean[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForByteArray() {
        byte[] testArray = new byte[]{1, 2, 3};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        byte[] emptyArray = new byte[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForCharArray() {
        char[] testArray = new char[]{'a', 'b', 'c'};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        char[] emptyArray = new char[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForDoubleArray() {
        double[] testArray = new double[]{1.0, 2.0, 3.0};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        double[] emptyArray = new double[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForFloatArray() {
        float[] testArray = new float[]{1.0f, 2.0f, 3.0f};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        float[] emptyArray = new float[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForIntArray() {
        int[] testArray = new int[]{1, 2, 3};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        int[] emptyArray = new int[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

       // assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForLongArray() {
        long[] testArray = new long[]{1L, 2L, 3L};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        long[] emptyArray = new long[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForShortArray() {
        short[] testArray = new short[]{1, 2, 3};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        short[] emptyArray = new short[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }

    @Test
    public void testIsNotEmptyForObjectArray() {
        Object[] testArray = new Object[]{1, "test", new Object()};
        assertTrue(ArrayUtils.isNotEmpty(testArray));

        Object[] emptyArray = new Object[]{};
        assertFalse(ArrayUtils.isNotEmpty(emptyArray));

        //assertFalse(ArrayUtils.isNotEmpty(null));
    }




    @Test
    public void indexOf_booleanArray_SuccessfulIndex() {
        boolean[] array = new boolean[] {true, false, true};
        int index = ArrayUtils.indexOf(array, false);
        assertEquals(1, index);
    }

    @Test
    public void indexOf_booleanArray_UnsuccessfulIndex() {
        boolean[] array = new boolean[] {true, true, true};
        int index = ArrayUtils.indexOf(array, false);
        assertEquals(-1, index);
    }

    @Test
    public void indexOf_intArray_SuccessfulIndex() {
        int[] array = new int[] {1, 2, 3};
        int index = ArrayUtils.indexOf(array, 2);
        assertEquals(1, index);
    }

    @Test
    public void indexOf_intArray_UnsuccessfulIndex() {
        int[] array = new int[] {1, 2, 3};
        int index = ArrayUtils.indexOf(array, 4);
        assertEquals(-1, index);
    }

    @Test
    public void indexOf_doubleArray_SuccessfulIndex() {
        double[] array = new double[] {1.1, 2.2, 3.3};
        int index = ArrayUtils.indexOf(array, 2.2);
        assertEquals(1, index);
    }

    @Test
    public void indexOf_doubleArray_UnsuccessfulIndex() {
        double[] array = new double[] {1.1, 2.2, 3.3};
        int index = ArrayUtils.indexOf(array, 4.4);
        assertEquals(-1, index);
    }

    @Test
    public void indexOf_ObjectArray_SuccessfulIndex() {
        String[] array = new String[] {"Test1", "Test2", "Test3"};
        int index = ArrayUtils.indexOf(array, "Test2");
        assertEquals(1, index);
    }

    @Test
    public void indexOf_ObjectArray_UnsuccessfulIndex() {
        String[] array = new String[] {"Test1", "Test2", "Test3"};
        int index = ArrayUtils.indexOf(array, "Test4");
        assertEquals(-1, index);
    }




    @Test
    public void testToObject_booleanArray() {
        final boolean[] booleanArray = {true, false, true};
        final Boolean[] result = ArrayUtils.toObject(booleanArray);
        assertArrayEquals(new Boolean[] {true, false, true}, result);
    }

    @Test
    public void testToObject_booleanArrayEmpty() {
        final boolean[] booleanArray = {};
        final Boolean[] result = ArrayUtils.toObject(booleanArray);
        assertArrayEquals(new Boolean[] {}, result);
    }

    @Test
    public void testToObject_booleanArrayNull() {
        final boolean[] booleanArray = null;
        final Boolean[] result = ArrayUtils.toObject(booleanArray);
        assertNull(result);
    }

    @Test
    public void testToObject_intArray() {
        final int[] intArray = {1, 2, 3};
        final Integer[] result = ArrayUtils.toObject(intArray);
        assertArrayEquals(new Integer[] {1, 2, 3}, result);
    }

    @Test
    public void testToObject_intArrayEmpty() {
        final int[] intArray = {};
        final Integer[] result = ArrayUtils.toObject(intArray);
        assertArrayEquals(new Integer[] {}, result);
    }

    @Test
    public void testToObject_intArrayNull() {
        final int[] intArray = null;
        final Integer[] result = ArrayUtils.toObject(intArray);
        assertNull(result);
    }

    // similar tests can be written for each of the primitive types





    @Test
    public void testGetLengthNullInput() {
        // Given
        Object array = null;

        // When
        int result = ArrayUtils.getLength(array);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void testGetLengthEmptyArray() {
        // Given
        Object array = new Integer[0];

        // When
        int result = ArrayUtils.getLength(array);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void testGetLengthNonEmptyArray() {
        // Given
        Object array = new Integer[]{1, 2, 3, 4, 5};

        // When
        int result = ArrayUtils.getLength(array);

        // Then
        assertEquals(5, result);
    }

    @Test
    public void testGetLengthArrayWithNullElement() {
        // Given
        Object array = new Integer[]{null};

        // When
        int result = ArrayUtils.getLength(array);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void testGetLengthNonArrayObject() {
        // Given
        Object object = new Object();

        // Then
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.getLength(object));
    }









    @Test
    public void testRemoveAllOccurencesBoolean() {
        boolean[] inputArray = {true, false, true, false, true};
        boolean element = true;
        boolean[] expectedOutput = {false, false};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesByte() {
        byte[] inputArray = {1, 2, 3, 1, 2, 3};
        byte element = 2;
        byte[] expectedOutput = {1, 3, 1, 3};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesChar() {
        char[] inputArray = {'a', 'b', 'c', 'a', 'b', 'c'};
        char element = 'b';
        char[] expectedOutput = {'a', 'c', 'a', 'c'};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesDouble() {
        double[] inputArray = {1.0, 2.0, 3.0, 1.0, 2.0, 3.0};
        double element = 1.0;
        double[] expectedOutput = {2.0, 3.0, 2.0, 3.0};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesFloat() {
        float[] inputArray = {1.0f, 2.0f, 3.0f, 1.0f, 2.0f, 3.0f};
        float element = 3.0f;
        float[] expectedOutput = {1.0f, 2.0f, 1.0f, 2.0f};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesInt() {
        int[] inputArray = {1, 2, 3, 1, 2, 3};
        int element = 3;
        int[] expectedOutput = {1, 2, 1, 2};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesLong() {
        long[] inputArray = {1L, 2L, 3L, 1L, 2L, 3L};
        long element = 1L;
        long[] expectedOutput = {2L, 3L, 2L, 3L};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesShort() {
        short[] inputArray = {1, 2, 3, 1, 2, 3};
        short element = 1;
        short[] expectedOutput = {2, 3, 2, 3};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }

    @Test
    public void testRemoveAllOccurencesGeneric() {
        String[] inputArray = {"one", "two", "three", "one", "two", "three"};
        String element = "two";
        String[] expectedOutput = {"one", "three", "one", "three"};

        assertArrayEquals(expectedOutput, ArrayUtils.removeAllOccurences(inputArray, element));
    }




    @Test
    public void whenGetIsCalledWithValidIndexThenReturnsCorrectElement() {
        String[] array = {"one", "two", "three"};
        int index = 1;
        String result = ArrayUtils.get(array, index);
        assertEquals("two", result);
    }

    @Test
    public void whenGetIsCalledWithOutOfBoundsIndexThenReturnsNull() {
        String[] array = {"one", "two", "three"};
        int index = 5;
        String result = ArrayUtils.get(array, index);
        assertNull(result);
    }

    @Test
    public void whenGetIsCalledWithNegativeIndexThenReturnsNull() {
        String[] array = {"one", "two", "three"};
        int index = -1;
        String result = ArrayUtils.get(array, index);
        assertNull(result);
    }

    @Test
    public void whenGetIsCalledWithNullArrayThenReturnsNull() {
        String[] array = null;
        int index = 1;
        String result = ArrayUtils.get(array, index);
        assertNull(result);
    }

    @Test
    public void whenGetIsCalledWithValidIndexAndDefaultValueThenReturnsCorrectElement() {
        String[] array = {"one", "two", "three"};
        int index = 1;
        String defaultValue = "default";
        String result = ArrayUtils.get(array, index, defaultValue);
        assertEquals("two", result);
    }

    @Test
    public void whenGetIsCalledWithOutOfBoundsIndexAndDefaultValueThenReturnsDefaultValue() {
        String[] array = {"one", "two", "three"};
        int index = 5;
        String defaultValue = "default";
        String result = ArrayUtils.get(array, index, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test
    public void whenGetIsCalledWithNegativeIndexAndDefaultValueThenReturnsDefaultValue() {
        String[] array = {"one", "two", "three"};
        int index = -1;
        String defaultValue = "default";
        String result = ArrayUtils.get(array, index, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test
    public void whenGetIsCalledWithNullArrayAndDefaultValueThenReturnsDefaultValue() {
        String[] array = null;
        int index = 1;
        String defaultValue = "default";
        String result = ArrayUtils.get(array, index, defaultValue);
        assertEquals(defaultValue, result);
    }

    // Manually added
    @Test
    public void testAddBooleanArray() {
        boolean[] testArray = new boolean[]{true, false};
        boolean[] resultArray = ArrayUtils.add(testArray, true);

        assertArrayEquals(new boolean[]{true, false, true}, resultArray);
    }

    @Test
    public void testAddNullBooleanArray() {
        boolean[] resultArray = ArrayUtils.add(null, true);

        assertArrayEquals(new boolean[]{true}, resultArray);
    }

    @Test
    public void testAddByteArray() {
        byte[] testArray = new byte[]{1, 2};
        byte[] resultArray = ArrayUtils.add(testArray, (byte)3);

        assertArrayEquals(new byte[]{1, 2, 3}, resultArray);
    }

    @Test
    public void testAddCharArray() {
        char[] testArray = new char[]{'a', 'b'};
        char[] resultArray = ArrayUtils.add(testArray, 'c');

        assertArrayEquals(new char[]{'a', 'b', 'c'}, resultArray);
    }

    @Test
    public void testAddDoubleArray() {
        double[] testArray = new double[]{1.1, 2.2};
        double[] resultArray = ArrayUtils.add(testArray, 3.3);

        assertArrayEquals(new double[]{1.1, 2.2, 3.3}, resultArray, 0.0001);
    }

    @Test
    public void testAddFloatArray() {
        float[] testArray = new float[]{1.1f, 2.2f};
        float[] resultArray = ArrayUtils.add(testArray, 3.3f);

        assertArrayEquals(new float[]{1.1f, 2.2f, 3.3f}, resultArray, 0.0001f);
    }

    @Test
    public void testAddIntArray() {
        int[] testArray = new int[]{1, 2};
        int[] resultArray = ArrayUtils.add(testArray, 3);

        assertArrayEquals(new int[]{1, 2, 3}, resultArray);
    }

    @Test
    public void testAddLongArray() {
        long[] testArray = new long[]{1L, 2L};
        long[] resultArray = ArrayUtils.add(testArray, 3L);

        assertArrayEquals(new long[]{1L, 2L, 3L}, resultArray);
    }

    @Test
    public void addLongArrayTest() {
        // Instantiate necessary variables
        long[] array = {1L, 2L, 3L};
        long element = 4L;

        // Perform operation under test
        long[] newArray = ArrayUtils.add(array, element);

        // Validate results
        assertArrayEquals(new long[]{1L, 2L, 3L, 4L}, newArray);
    }

    @Test
    public void addShortArrayTest() {
        // Instantiate necessary variables
        short[] array = {1, 2, 3};
        short element = 4;

        // Perform operation under test
        short[] newArray = ArrayUtils.add(array, element);

        // Validate results
        assertArrayEquals(new short[]{1, 2, 3, 4}, newArray);
    }

    @Test
    public void addGenericArrayTest() {
        // Instantiate necessary variables
        String[] array = {"One", "Two", "Three"};
        String element = "Four";

        // Perform operation under test
        String[] newArray = ArrayUtils.add(array, element);

        // Validate results
        assertArrayEquals(new String[]{"One", "Two", "Three", "Four"}, newArray);
    }

    @Test
    public void addNullArrayTest() {
        // Instantiate necessary variables
        String[] array = null;
        String element = "One";

        // Perform operation under test
        String[] newArray = ArrayUtils.add(array, element);

        // Validate results
        assertArrayEquals(new String[]{"One"}, newArray);
    }

    @Test
    public void addNullElementTest() {
        // Instantiate necessary variables
        String[] array = {"One", "Two", "Three"};
        String element = null;

        // Perform operation under test
        String[] newArray = ArrayUtils.add(array, element);

        // Validate results
        assertArrayEquals(new String[]{"One", "Two", "Three", null}, newArray);
    }

    @Test
    public void addNullArrayAndElementTest() {
        // Instantiate necessary variables
        String[] array = null;
        String element = null;

        // Assert that an exception of type IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.add(array, element));
    }
    @Test
    public void testSwapBooleanArray() {
        boolean[] boolArray = new boolean[] { true, false, true };
        ArrayUtils.swap(boolArray, 0, 2);

        assertArrayEquals(new boolean[] { true, false, true }, boolArray);

        ArrayUtils.swap(boolArray, 0, 1);
        assertArrayEquals(new boolean[] { false, true, true }, boolArray);
    }

    @Test
    public void testSwapByteArray() {
        byte[] byteArray = new byte[] { 1, 2, 3 };
        ArrayUtils.swap(byteArray, 0, 2);

        assertArrayEquals(new byte[] { 3, 2, 1 }, byteArray);

        ArrayUtils.swap(byteArray, 0, 1);
        assertArrayEquals(new byte[] { 2, 3, 1 }, byteArray);
    }

    @Test
    public void testSwapCharArray() {
        char[] charArray = new char[] { 'a', 'b', 'c' };
        ArrayUtils.swap(charArray, 0, 2);

        assertArrayEquals(new char[] { 'c', 'b', 'a' }, charArray);

        ArrayUtils.swap(charArray, 0, 1);
        assertArrayEquals(new char[] { 'b', 'c', 'a' }, charArray);
    }

    @Test
    public void testSwapDoubleArray1() {
        double[] doubleArray = new double[] { 1.0, 2.0, 3.0 };
        ArrayUtils.swap(doubleArray, 0, 2);

        assertArrayEquals(new double[] { 3.0, 2.0, 1.0 }, doubleArray, 0.0001);

        ArrayUtils.swap(doubleArray, 0, 1);
        assertArrayEquals(new double[] { 2.0, 3.0, 1.0 }, doubleArray, 0.0001);
    }

    @Test
    public void testSwapWithInvalidIndices() {
        int[] intArray = new int[] { 1, 2, 3 };
        ArrayUtils.swap(intArray, -1, 3);

        assertArrayEquals(new int[] { 1, 2, 3 }, intArray);

        ArrayUtils.swap(intArray, 0, 5);
        assertArrayEquals(new int[] { 1, 2, 3 }, intArray);
    }

    @Test
    public void testSwapWithEmptyArray() {
        int[] emptyArray = new int[] {};
        ArrayUtils.swap(emptyArray, 0, 1);

        assertArrayEquals(new int[] {}, emptyArray);
    }
    @Test
    public void testSwapDoubleArray() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        ArrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new double[]{1.0, 4.0, 5.0, 2.0, 3.0}, array);
    }

    @Test
    public void testSwapFloatArray() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        ArrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new float[]{1.0f, 4.0f, 5.0f, 2.0f, 3.0f}, array);
    }

    @Test
    public void testSwapIntArray() {
        int[] array = {1, 2, 3, 4, 5};
        ArrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new int[]{1, 4, 5, 2, 3}, array);
    }

    @Test
    public void testSwapLongArray() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        ArrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new long[]{1L, 4L, 5L, 2L, 3L}, array);
    }

    @Test
    public void testSwapObjectArray() {
        String[] array = {"1", "2", "3", "4", "5"};
        ArrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new String[]{"1", "4", "5", "2", "3"}, array);
    }

    @Test
    public void testSwapShortArray() {
        short[] array = {1, 2, 3, 4, 5};
        ArrayUtils.swap(array, 1, 3, 2);
        assertArrayEquals(new short[]{1, 4, 5, 2, 3}, array);
    }

    @Test
    public void testSwapWithNegativeOffsets() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        ArrayUtils.swap(array, -1, -3, 2);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, array);
    }

    @Test
    public void testSwapWithOffsetGreaterThanLength() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        ArrayUtils.swap(array, 10, 13, 2);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, array);
    }

}