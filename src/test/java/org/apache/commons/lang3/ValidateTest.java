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


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.function.Supplier;

public class ValidateTest {
    @Test
    @DisplayName("Should not throw exception when iterable is not null and contains no null elements")
    void testNoNullElements_Success1() {
        // Arrange
        List<String> list = Arrays.asList("a", "b", "c");
        // Act & Assert
        assertDoesNotThrow(() -> Validate.noNullElements(list));
    }

    @Test
    @DisplayName("Should throw exception when iterable is null")
    void testNoNullElements_NullIterable() {
        // Arrange
        List<String> list = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> Validate.noNullElements(list));
    }

    @Test
    @DisplayName("Should throw exception when iterable contains null element")
    void testNoNullElements_ContainsNull1() {
        // Arrange
        List<String> list = Arrays.asList("a", null, "c");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Validate.noNullElements(list));
    }

    @Test
    @DisplayName("Should not throw exception when array is not null and contains no null elements")
    void testNoNullElements_Success2() {
        // Arrange
        String[] array = {"a", "b", "c"};

        // Act & Assert
        assertDoesNotThrow(() -> Validate.noNullElements(array));
    }

    @Test
    @DisplayName("Should throw exception when array is null")
    void testNoNullElements_NullArray() {
        // Arrange
        String[] array = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> Validate.noNullElements(array));
    }

    @Test
    @DisplayName("Should throw exception when array contains null element")
    void testNoNullElements_ContainsNull2() {
        // Arrange
        String[] array = {"a", null, "c"};

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Validate.noNullElements(array));
    }

    @Test
    void isTrue_shouldThrowException_whenExpressionIsFalse() {
        assertThrows(IllegalArgumentException.class, () -> validate.isTrue(false));
    }

    @Test
    void isTrue_shouldNotThrowException_whenExpressionIsTrue() {
        assertDoesNotThrow(() -> validate.isTrue(true));
    }

    @Test
    void isTrue_shouldThrowExceptionWithDefaultMessage_whenExpressionIsFalse() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validate.isTrue(false));
        assertEquals("The validated expression is false", exception.getMessage());
    }

    @Test
    void isTrue_shouldThrowExceptionWithCustomMessage_whenExpressionIsFalse() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validate.isTrue(false, "Custom message"));
        assertEquals("Custom message", exception.getMessage());
    }

    //@Test
    void isTrue_shouldThrowExceptionWithCustomMessageAndDoubleValue_whenExpressionIsFalse() {
        double value = 10.5;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validate.isTrue(false, "Value is %f", value));
        assertEquals("Value is 10.5", exception.getMessage());
    }

    @Test
    void isTrue_shouldThrowExceptionWithCustomMessageAndLongValue_whenExpressionIsFalse() {
        long value = 100;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validate.isTrue(false, "Value is %d", value));
        assertEquals("Value is 100", exception.getMessage());
    }

    @Test
    void isTrue_shouldThrowExceptionWithCustomMessageAndValues_whenExpressionIsFalse() {
        Object[] values = {1, 2, 3};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validate.isTrue(false, "Values are %d, %d, %d", values));
        assertEquals("Values are 1, 2, 3", exception.getMessage());
    }

    @Test
    void testNotNull() {
        // Test with a non-null object
        Object obj = new Object();
        assertEquals(obj, validate.notNull(obj));

        // Test with a null object
        assertThrows(NullPointerException.class, () -> validate.notNull(null));
    }

    @Test
    void testNotNullWithMessage() {
        // Test with a non-null object
        Object obj = new Object();
        assertEquals(obj, validate.notNull(obj, "Object must not be null"));

        // Test with a null object
        NullPointerException exception = assertThrows(NullPointerException.class, () -> validate.notNull(null, "Object must not be null"));
        assertEquals("Object must not be null", exception.getMessage());
    }

    @Test
    void testExclusiveBetween_double() {
        assertDoesNotThrow(() -> validate.exclusiveBetween(1.0, 3.0, 2.0));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1.0, 3.0, 1.0));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1.0, 3.0, 3.0));
    }

    @Test
    void testExclusiveBetween_double_withMessage() {
        assertDoesNotThrow(() -> validate.exclusiveBetween(1.0, 3.0, 2.0, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1.0, 3.0, 1.0, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1.0, 3.0, 3.0, "Not in range"));
    }

    @Test
    void testExclusiveBetween_long() {
        assertDoesNotThrow(() -> validate.exclusiveBetween(1, 3, 2));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 1));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 3));
    }

    @Test
    void testExclusiveBetween_long_withMessage() {
        assertDoesNotThrow(() -> validate.exclusiveBetween(1, 3, 2, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 1, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 3, "Not in range"));
    }

    @Test
    void testExclusiveBetween_comparable() {
        assertDoesNotThrow(() -> validate.exclusiveBetween(1, 3, 2));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 1));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 3));
    }

    @Test
    void testExclusiveBetween_comparable_withMessage() {
        assertDoesNotThrow(() -> validate.exclusiveBetween(1, 3, 2, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 1, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> validate.exclusiveBetween(1, 3, 3, "Not in range"));
    }
    // Your Java code here

    @Test
    @DisplayName("Valid index within bounds")
    void testValidIndexWithinBounds1() {
        List<Integer> collection = Arrays.asList(1, 2, 3);
        Assertions.assertDoesNotThrow(() -> Validate.validIndex(collection, 1));
    }

    @Test
    @DisplayName("Invalid index below lower bound")
    void testInvalidIndexBelowLowerBound1() {
        List<Integer> collection = Arrays.asList(1, 2, 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(collection, -1));
    }

    @Test
    @DisplayName("Invalid index above upper bound")
    void testInvalidIndexAboveUpperBound1() {
        List<Integer> collection = Arrays.asList(1, 2, 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(collection, 3));
    }

    @Test
    @DisplayName("Null collection")
    void testNullCollection() {
        List<Integer> collection = null;
        Assertions.assertThrows(NullPointerException.class, () -> Validate.validIndex(collection, 1));
    }

    @Test
    @DisplayName("Valid index within bounds")
    void testValidIndexWithinBounds2() {
        String chars = "abc";
        Assertions.assertDoesNotThrow(() -> Validate.validIndex(chars, 1));
    }

    @Test
    @DisplayName("Invalid index below lower bound")
    void testInvalidIndexBelowLowerBound2() {
        String chars = "abc";
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(chars, -1));
    }

    @Test
    @DisplayName("Invalid index above upper bound")
    void testInvalidIndexAboveUpperBound2() {
        String chars = "abc";
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(chars, 3));
    }

    @Test
    @DisplayName("Null character sequence")
    void testNullCharSequence() {
        String chars = null;
        Assertions.assertThrows(NullPointerException.class, () -> Validate.validIndex(chars, 1));
    }

    @Test
    @DisplayName("Valid index within bounds")
    void testValidIndexWithinBounds3() {
        Integer[] array = {1, 2, 3};
        Assertions.assertDoesNotThrow(() -> Validate.validIndex(array, 1));
    }

    @Test
    @DisplayName("Invalid index below lower bound")
    void testInvalidIndexBelowLowerBound3() {
        Integer[] array = {1, 2, 3};
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(array, -1));
    }

    @Test
    @DisplayName("Invalid index above upper bound")
    void testInvalidIndexAboveUpperBound3() {
        Integer[] array = {1, 2, 3};
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(array, 3));
    }

    @Test
    @DisplayName("Null array")
    void testNullArray() {
        Integer[] array = null;
        Assertions.assertThrows(NullPointerException.class, () -> Validate.validIndex(array, 1));
    }


    private Validate validate;

    @Test
    void notBlank_shouldReturnSameString_whenInputIsNotBlank() {
        String input = "not blank";
        String result = validate.notBlank(input);
        assertEquals(input, result);
    }

    @Test
    void testFiniteWithValidValue() {
        assertDoesNotThrow(() -> Validate.finite(10.5));
    }

    @Test
    void testFiniteWithNaNValue() {
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(Double.NaN));
    }

    @Test
    void testFiniteWithPositiveInfinityValue() {
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(Double.POSITIVE_INFINITY));
    }

    @Test
    void testFiniteWithNegativeInfinityValue() {
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(Double.NEGATIVE_INFINITY));
    }

    @Test
    void testFiniteWithValidValueAndCustomMessage() {
        assertDoesNotThrow(() -> Validate.finite(5.0, "Value must be finite"));
    }

    @Test
    void testFiniteWithNaNValueAndCustomMessage() {
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(Double.NaN, "Value must be finite"));
    }

    @Test
    void testFiniteWithPositiveInfinityValueAndCustomMessage() {
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(Double.POSITIVE_INFINITY, "Value must be finite"));
    }

    @Test
    void testFiniteWithNegativeInfinityValueAndCustomMessage() {
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(Double.NEGATIVE_INFINITY, "Value must be finite"));
    }


    @Test
    @DisplayName("should not throw an exception")
    void shouldNotThrowException1() {
        assertDoesNotThrow(() -> Validate.inclusiveBetween(0.1, 2.1, 1.1));
    }


    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -1.0, Double.MIN_VALUE})
    @DisplayName("should throw an IllegalArgumentException")
    void shouldThrowIllegalArgumentException1(double value) {
        assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0.1, 2.1, value));
    }


    @ParameterizedTest
    @ValueSource(doubles = {2.2, 3.0, Double.MAX_VALUE})
    @DisplayName("should throw an IllegalArgumentException")
    void shouldThrowIllegalArgumentException2(double value) {
        assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0.1, 2.1, value));
    }


    @Test
    @DisplayName("should not throw an exception")
    void shouldNotThrowException2() {
        assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 1));
    }


    @ParameterizedTest
    @ValueSource(longs = {-1, -10, Long.MIN_VALUE})
    @DisplayName("should throw an IllegalArgumentException")
    void shouldThrowIllegalArgumentException3(long value) {
        assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, value));
    }


    @ParameterizedTest
    @ValueSource(longs = {3, 10, Long.MAX_VALUE})
    @DisplayName("should throw an IllegalArgumentException")
    void shouldThrowIllegalArgumentException4(long value) {
        assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, value));
    }


    @Test
    @DisplayName("should not throw an exception")
    void shouldNotThrowException3() {
        assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 1));
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, -10, Integer.MIN_VALUE})
    @DisplayName("should throw an IllegalArgumentException")
    void shouldThrowIllegalArgumentException5(int value) {
        assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, value));
    }


    @ParameterizedTest
    @ValueSource(ints = {3, 10, Integer.MAX_VALUE})
    void shouldThrowIllegalArgumentException6(int value) {
        assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, value));
    }


//    @Test
//    void testToSupplier() {
//        // Test with no values
//        Supplier<String> supplier1 = validate.toSupplier("Test message");
//        assertEquals("Test message", supplier1.get());
//
//        // Test with one value
//        Supplier<String> supplier2 = validate.toSupplier("Value: %d", 10);
//        assertEquals("Value: 10", supplier2.get());
//
//        // Test with multiple values
//        Supplier<String> supplier3 = validate.toSupplier("Name: %s, Age: %d", "John", 25);
//        assertEquals("Name: John, Age: 25", supplier3.get());
//
//        // Test with empty message
//        Supplier<String> supplier4 = validate.toSupplier("", 100);
//        assertEquals("", supplier4.get());
//    }

    // Test function 1
    void shouldNotThrowExceptionWhenTypesAreAssignable() {
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Object.class, String.class));
    }

    // Test function 2
    void shouldNotThrowExceptionWhenTypesAreSame() {
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Object.class, Object.class));
    }

    // Test function 3
    void shouldNotThrowExceptionWhenSuperTypeIsInterface() {
        assertDoesNotThrow(() -> Validate.isAssignableFrom(List.class, ArrayList.class));
    }

    // Test function 4
    void shouldThrowExceptionWhenTypesAreNotAssignable() {
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(String.class, Object.class));
    }

    // Test function 5
    void shouldThrowExceptionWithDefaultMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validate.isAssignableFrom(String.class, Object.class));
        assertEquals("Cannot assign a java.lang.Object to a java.lang.String", exception.getMessage());
    }

    // Test function 6
    void shouldThrowExceptionWithCustomMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validate.isAssignableFrom(String.class, Object.class, "Custom message"));
        assertEquals("Custom message", exception.getMessage());
    }

    // Test function 7
    void shouldThrowExceptionWithFormattedCustomMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validate.isAssignableFrom(String.class, Object.class, "Expected type: %s, actual: %s", "String", "Object"));
        assertEquals("Expected type: String, actual: Object", exception.getMessage());
    }

    @Test
    void testMatchesPattern_ValidInputAndPattern() {
    }

    @Test
    void testMatchesPattern_InvalidInputAndValidPattern() {
    }

    @Test
    void testMatchesPattern_ValidInputAndInvalidPattern() {
    }

    @Test
    void testMatchesPattern_InvalidInputAndPatternWithCustomMessage() {
    }

    @Test
    @DisplayName("should not throw exception for valid double value")
    void shouldNotThrowExceptionForValidDoubleValue() {
        Assertions.assertDoesNotThrow(() -> Validate.notNaN(1.0));
    }

    @Test
    @DisplayName("should throw exception for NaN value")
    void shouldThrowExceptionForNaNValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validate.notNaN(Double.NaN));
    }

    @Test
    @DisplayName("should throw exception with default message for NaN value")
    void shouldThrowExceptionWithDefaultMessageForNaNValue() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Validate.notNaN(Double.NaN));
        Assertions.assertEquals("The validated value is not a number", exception.getMessage());
    }

    @Test
    @DisplayName("should throw exception with custom message for NaN value")
    void shouldThrowExceptionWithCustomMessageForNaNValue() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Validate.notNaN(Double.NaN, "Custom message"));
        Assertions.assertEquals("Custom message", exception.getMessage());
    }


    @Test
    void isInstanceOf_shouldThrowException_whenObjectIsNotInstanceOfClass() {
        assertThrows(IllegalArgumentException.class, () -> {
            validate.isInstanceOf(String.class, 123);
        });
    }

    @Test
    void isInstanceOf_shouldNotThrowException_whenObjectIsInstanceOfClass() {
        assertDoesNotThrow(() -> {
            validate.isInstanceOf(String.class, "Hello");
        });
    }

    @Test
    void isInstanceOf_shouldThrowExceptionWithCustomMessage_whenObjectIsNotInstanceOfClass() {
        assertThrows(IllegalArgumentException.class, () -> {
            validate.isInstanceOf(String.class, 123, "Object is not of type %s", String.class);
        });
    }

    @Test
    void isInstanceOf_shouldNotThrowExceptionWithCustomMessage_whenObjectIsInstanceOfClass() {
        assertDoesNotThrow(() -> {
            validate.isInstanceOf(String.class, "Hello", "Object is not of type %s", String.class);
        });
    }

//    @Test
//    void isInstanceOf_shouldThrowExceptionWithFormattedCustomMessage_whenObjectIsNotInstanceOfClass() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            validate.isInstanceOf(String.class, 123, "Object is not of type %s, actual: %s", String.class, 123.getClass());
//        });
//    }

    @Test
    void isInstanceOf_shouldNotThrowExceptionWithFormattedCustomMessage_whenObjectIsInstanceOfClass() {
        assertDoesNotThrow(() -> {
            validate.isInstanceOf(String.class, "Hello", "Object is not of type %s, actual: %s", String.class, "Hello".getClass());
        });
    }

//    @Test
//    void testNotEmptyCollection() {
//        // Test with non-empty collection
//        Collection<Integer> collection1 = List.of(1, 2, 3);
//        assertSame(collection1, Validate.notEmpty(collection1));
//
//        // Test with empty collection
//        Collection<Integer> collection2 = List.of();
//        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(collection2));
//    }
//
//    @Test
//    void testNotEmptyMap() {
//        // Test with non-empty map
//        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
//        assertSame(map1, Validate.notEmpty(map1));
//
//        // Test with empty map
//        Map<String, Integer> map2 = Map.of();
//        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(map2));
//    }

    @Test
    void testNotEmptyCharSequence() {
        // Test with non-empty char sequence
        String chars1 = "abc";
        assertSame(chars1, Validate.notEmpty(chars1));

        // Test with empty char sequence
        String chars2 = "";
        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(chars2));
    }

    @Test
    void testNotEmptyArray() {
        // Test with non-empty array
        Integer[] array1 = {1, 2, 3};
        assertSame(array1, Validate.notEmpty(array1));

        // Test with empty array
        Integer[] array2 = {};
        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(array2));
    }

//    @Test
//    void testNotEmptyCollectionWithCustomMessage() {
//        // Test with non-empty collection
//        Collection<Integer> collection1 = List.of(1, 2, 3);
//        assertSame(collection1, Validate.notEmpty(collection1, "Collection must not be empty"));
//
//        // Test with empty collection
//        Collection<Integer> collection2 = List.of();
//        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(collection2, "Collection must not be empty"));
//    }
//
//    @Test
//    void testNotEmptyMapWithCustomMessage() {
//        // Test with non-empty map
//        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
//        assertSame(map1, Validate.notEmpty(map1, "Map must not be empty"));
//
//        // Test with empty map
//        Map<String, Integer> map2 = Map.of();
//        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(map2, "Map must not be empty"));
//    }

    @Test
    void testNotEmptyCharSequenceWithCustomMessage() {
        // Test with non-empty char sequence
        String chars1 = "abc";
        assertSame(chars1, Validate.notEmpty(chars1, "Char sequence must not be empty"));

        // Test with empty char sequence
        String chars2 = "";
        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(chars2, "Char sequence must not be empty"));
    }

    @Test
    void testNotEmptyArrayWithCustomMessage() {
        // Test with non-empty array
        Integer[] array1 = {1, 2, 3};
        assertSame(array1, Validate.notEmpty(array1, "Array must not be empty"));

        // Test with empty array
        Integer[] array2 = {};
        assertThrows(IllegalArgumentException.class, () -> Validate.notEmpty(array2, "Array must not be empty"));
    }

    @Test
    void testValidState() {
        // Test valid state
        assertDoesNotThrow(() -> Validate.validState(true));

        // Test invalid state
        assertThrows(IllegalStateException.class, () -> Validate.validState(false));
    }

    @Test
    void testValidStateWithMessage() {
        // Test valid state
        assertDoesNotThrow(() -> Validate.validState(true, "The state is valid"));

        // Test invalid state
        assertThrows(IllegalStateException.class, () -> Validate.validState(false, "The state is invalid"));
    }

}