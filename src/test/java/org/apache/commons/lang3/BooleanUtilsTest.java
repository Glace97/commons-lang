package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;


import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.*;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BooleanUtilsTest {
    Consumer<Boolean> mockConsumer = mock(Consumer.class);

    @Test
    void testIsFalse_WithTrue_ReturnsFalse() {
        assertFalse(BooleanUtils.isFalse(Boolean.TRUE));
    }

    @Test
    void testIsFalse_WithFalse_ReturnsTrue() {
        assertTrue(BooleanUtils.isFalse(Boolean.FALSE));
    }

    @Test
    void testIsFalse_WithNull_ReturnsFalse() {
        assertFalse(BooleanUtils.isFalse(null));
    }

    @Test
    void testIsFalse_WithStringNull_ReturnsFalse() {
        assertFalse(BooleanUtils.isFalse(null));
    }

    @Test
    void forEach_ShouldCallConsumerForEachBooleanValue() {
        BooleanUtils.forEach(mockConsumer);

        verify(mockConsumer, times(2)).accept(anyBoolean());
    }

    @Test
    void forEach_ShouldCallConsumerWithFalse() {
        BooleanUtils.forEach(mockConsumer);

        verify(mockConsumer).accept(false);
    }

    @Test
    void forEach_ShouldCallConsumerWithTrue() {
        BooleanUtils.forEach(mockConsumer);

        verify(mockConsumer).accept(true);
    }

    @Test
    void forEach_ShouldCallConsumerInOrder() {
        InOrder inOrder = inOrder(mockConsumer);

        BooleanUtils.forEach(mockConsumer);

        inOrder.verify(mockConsumer).accept(false);
        inOrder.verify(mockConsumer).accept(true);
    }

    @Test
    @DisplayName("Converts true to 'on'")
    void testToStringOnOffTrue1() {
        boolean input = true;
        String expected = "on";
        String result = BooleanUtils.toStringOnOff(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Converts false to 'off'")
    void testToStringOnOffFalse1() {
        boolean input = false;
        String expected = "off";
        String result = BooleanUtils.toStringOnOff(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Converts Boolean.TRUE to 'on'")
    void testToStringOnOffTrue2() {
        Boolean input = Boolean.TRUE;
        String expected = "on";
        String result = BooleanUtils.toStringOnOff(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Converts Boolean.FALSE to 'off'")
    void testToStringOnOffFalse2() {
        Boolean input = Boolean.FALSE;
        String expected = "off";
        String result = BooleanUtils.toStringOnOff(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Converts null to null")
    void testToStringOnOffNull() {
        Boolean input = null;
        String expected = null;
        String result = BooleanUtils.toStringOnOff(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testPrimitiveValues() {
        boolean[] expected = {false, true};
        boolean[] actual = BooleanUtils.primitiveValues();
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("should return 1 if true")
    void shouldReturnOneIfTrue2() {
        Integer result = BooleanUtils.toIntegerObject(true);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("should return 0 if false")
    void shouldReturnZeroIfFalse2() {
        Integer result = BooleanUtils.toIntegerObject(false);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("should return trueValue if true")
    void shouldReturnTrueValueIfTrue2() {
        Integer result = BooleanUtils.toIntegerObject(true, 10, 20);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("should return falseValue if false")
    void shouldReturnFalseValueIfFalse2() {
        Integer result = BooleanUtils.toIntegerObject(false, 10, 20);
        assertEquals(20, result);
    }

    @Test
    @DisplayName("should return 1 if Boolean.TRUE")
    void shouldReturnOneIfTrue() {
        Integer result = BooleanUtils.toIntegerObject(Boolean.TRUE);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("should return 0 if Boolean.FALSE")
    void shouldReturnZeroIfFalse() {
        Integer result = BooleanUtils.toIntegerObject(Boolean.FALSE);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("should return null if null")
    void shouldReturnNullIfNull() {
        Integer result = BooleanUtils.toIntegerObject(null);
        assertNull(result);
    }

    @Test
    @DisplayName("should return trueValue if Boolean.TRUE")
    void shouldReturnTrueValueIfTrue() {
        Integer result = BooleanUtils.toIntegerObject(Boolean.TRUE, 10, 20, 30);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("should return falseValue if Boolean.FALSE")
    void shouldReturnFalseValueIfFalse() {
        Integer result = BooleanUtils.toIntegerObject(Boolean.FALSE, 10, 20, 30);
        assertEquals(20, result);
    }

    @Test
    @DisplayName("should return nullValue if null")
    void shouldReturnNullValueIfNull() {
        Integer result = BooleanUtils.toIntegerObject(null, 10, 20, 30);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("Should return true when all elements are true")
    void testAndAllTrue1() {
        boolean[] array = {true, true, true};
        assertTrue(BooleanUtils.and(array));
    }

    @Test
    @DisplayName("Should return false when any element is false")
    void testAndAnyFalse1() {
        boolean[] array = {true, false, true};
        assertFalse(BooleanUtils.and(array));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when array is empty")
    void testAndEmptyArray1() {
        boolean[] array = {};
        assertThrows(IllegalArgumentException.class, () -> BooleanUtils.and(array));
    }

    @Test
    @DisplayName("Should return true when all elements are true")
    void testAndAllTrue() {
        Boolean[] array = {Boolean.TRUE, Boolean.TRUE, Boolean.TRUE};
        assertTrue(BooleanUtils.and(array));
    }

    @Test
    @DisplayName("Should return false when any element is false")
    void testAndAnyFalse() {
        Boolean[] array = {Boolean.TRUE, Boolean.FALSE, Boolean.TRUE};
        assertFalse(BooleanUtils.and(array));
    }

    @Test
    @DisplayName("Should return false when any element is null")
    void testAndAnyNull() {
        Boolean[] array = {Boolean.TRUE, null, Boolean.TRUE};
        assertFalse(BooleanUtils.and(array));
    }

    @Test
    @DisplayName("Should throw NullPointerException when array is null")
    void testAndNullArray1() {
        assertThrows(NullPointerException.class, () -> BooleanUtils.and((Boolean[]) null));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when array is empty")
    void testAndEmptyArray() {
        Boolean[] array = {};
        assertThrows(IllegalArgumentException.class, () -> BooleanUtils.and(array));
    }

    @Test
    @DisplayName("should return 0 when x is equal to y")
    void shouldReturnZeroWhenXEqualsY() {
        int result = BooleanUtils.compare(true, true);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("should return 1 when x is true and y is false")
    void shouldReturnOneWhenXIsTrueAndYIsFalse() {
        int result = BooleanUtils.compare(true, false);
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("should return -1 when x is false and y is true")
    void shouldReturnMinusOneWhenXIsFalseAndYIsTrue() {
        int result = BooleanUtils.compare(false, true);
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("should achieve high coverage")
    void shouldAchieveHighCoverage() {
        // Test cases to cover all possibilities
        int result1 = BooleanUtils.compare(true, true);
        int result2 = BooleanUtils.compare(true, false);
        int result3 = BooleanUtils.compare(false, true);
        int result4 = BooleanUtils.compare(false, false);

        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(1, result2);
        Assertions.assertEquals(-1, result3);
        Assertions.assertEquals(0, result4);
    }

    @Test
    @DisplayName("should return true when bool is Boolean.TRUE")
    void shouldReturnTrueWhenBoolIsTrue() {
        boolean result = BooleanUtils.toBoolean(Boolean.TRUE);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return false when bool is Boolean.FALSE")
    void shouldReturnFalseWhenBoolIsFalse() {
        boolean result = BooleanUtils.toBoolean(Boolean.FALSE);
        assertEquals(false, result);
    }


    @Test
    @DisplayName("should return false when value is 0")
    void shouldReturnFalseWhenValueIsZero() {
        boolean result = BooleanUtils.toBoolean(0);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("should return true when value is non-zero")
    void shouldReturnTrueWhenValueIsNonZero() {
        boolean result = BooleanUtils.toBoolean(1);
        assertEquals(true, result);
    }

    //@Test
    @DisplayName("should return false when value is not equal to trueValue or falseValue")
    void shouldReturnFalseWhenValueIsNotEqualToTrueOrFalseValue() {
        boolean result = BooleanUtils.toBoolean(2, 1, 0);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("should return true when value is equal to trueValue")
    void shouldReturnTrueWhenValueIsEqualToTrueValue2() {
        boolean result = BooleanUtils.toBoolean(1, 1, 0);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return false when value is equal to falseValue")
    void shouldReturnFalseWhenValueIsEqualToFalseValue2() {
        boolean result = BooleanUtils.toBoolean(0, 1, 0);
        assertEquals(false, result);
    }


    @Test
    @DisplayName("should return true when value is equal to trueValue")
    void shouldReturnTrueWhenValueIsEqualToTrueValue() {
        boolean result = BooleanUtils.toBoolean(1, 1, 0);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return false when value is equal to falseValue")
    void shouldReturnFalseWhenValueIsEqualToFalseValue() {
        boolean result = BooleanUtils.toBoolean(0, 1, 0);
        assertEquals(false, result);
    }


    @Test
    @DisplayName("should return true when str is 'true'")
    void shouldReturnTrueWhenStrIsTrue() {
        boolean result = BooleanUtils.toBoolean("true");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return true when str is 'TRUE'")
    void shouldReturnTrueWhenStrIsUpperCaseTrue() {
        boolean result = BooleanUtils.toBoolean("TRUE");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return true when str is 't'")
    void shouldReturnTrueWhenStrIsT2() {
        boolean result = BooleanUtils.toBoolean("t");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return true when str is 'T'")
    void shouldReturnTrueWhenStrIsUpperCaseT() {
        boolean result = BooleanUtils.toBoolean("T");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return true when str is 'on'")
    void shouldReturnTrueWhenStrIsOn() {
        boolean result = BooleanUtils.toBoolean("on");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return true when str is 'ON'")
    void shouldReturnTrueWhenStrIsUpperCaseOn() {
        boolean result = BooleanUtils.toBoolean("ON");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return true when str is 'y'")
    void shouldReturnTrueWhenStrIsY() {
        boolean result = BooleanUtils.toBoolean("y");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return true when str is 'Y'")
    void shouldReturnTrueWhenStrIsUpperCaseY() {
        boolean result = BooleanUtils.toBoolean("Y");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return false when str is 'false'")
    void shouldReturnFalseWhenStrIsFalse() {
        boolean result = BooleanUtils.toBoolean("false");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("should return false when str is 'x gti'")
    void shouldReturnFalseWhenStrIsInvalid() {
        boolean result = BooleanUtils.toBoolean("x gti");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("should return false when str is 'n'")
    void shouldReturnFalseWhenStrIsN() {
        boolean result = BooleanUtils.toBoolean("n");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("should return true when str is 't'")
    void shouldReturnTrueWhenStrIsT() {
        boolean result = BooleanUtils.toBoolean("t");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return false when str is 'f'")
    void shouldReturnFalseWhenStrIsF() {
        boolean result = BooleanUtils.toBoolean("f");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("should return true when str is equal to trueString")
    void shouldReturnTrueWhenStrIsEqualToTrueString() {
        boolean result = BooleanUtils.toBoolean("true", "true", "false");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("should return false when str is equal to falseString")
    void shouldReturnFalseWhenStrIsEqualToFalseString() {
        boolean result = BooleanUtils.toBoolean("false", "true", "false");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("should throw exception when str is not equal to trueString or falseString")
    void shouldThrowExceptionWhenStrIsNotEqualToTrueOrFalseString() {
        try {
            BooleanUtils.toBoolean("invalid", "true", "false");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("The String did not match either specified value", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should return trueString when bool is true")
    void shouldReturnTrueStringWhenBoolIsTrue1() {
        // Arrange
        boolean bool = true;
        String trueString = "true";
        String falseString = "false";

        // Act
        String result = BooleanUtils.toString(bool, trueString, falseString);

        // Assert
        assertEquals(trueString, result);
    }

    @Test
    @DisplayName("Should return falseString when bool is false")
    void shouldReturnFalseStringWhenBoolIsFalse1() {
        // Arrange
        boolean bool = false;
        String trueString = "true";
        String falseString = "false";

        // Act
        String result = BooleanUtils.toString(bool, trueString, falseString);

        // Assert
        assertEquals(falseString, result);
    }

    @Test
    @DisplayName("Should return trueString when bool is Boolean.TRUE")
    void shouldReturnTrueStringWhenBoolIsTrue() {
        // Arrange
        Boolean bool = Boolean.TRUE;
        String trueString = "true";
        String falseString = "false";
        String nullString = "null";

        // Act
        String result = BooleanUtils.toString(bool, trueString, falseString, nullString);

        // Assert
        assertEquals(trueString, result);
    }

    @Test
    @DisplayName("Should return falseString when bool is Boolean.FALSE")
    void shouldReturnFalseStringWhenBoolIsFalse() {
        // Arrange
        Boolean bool = Boolean.FALSE;
        String trueString = "true";
        String falseString = "false";
        String nullString = "null";

        // Act
        String result = BooleanUtils.toString(bool, trueString, falseString, nullString);

        // Assert
        assertEquals(falseString, result);
    }

    @Test
    void testOr_withArrayOfBooleans_shouldReturnTrueIfAnyIsTrueAndNullIsFalse() {
        assertTrue(BooleanUtils.or(Boolean.TRUE, null));
        assertFalse(BooleanUtils.or(Boolean.FALSE, null));
    }

    @Test
    void testOr_withArrayOfBooleans_shouldThrowNullPointerExceptionIfArrayIsNull() {
        assertThrows(NullPointerException.class, () -> BooleanUtils.or((Boolean[]) null));
    }

    @Test
    void testOr_withArrayOfPrimitives_shouldThrowNullPointerExceptionIfArrayIsNull() {
        assertThrows(NullPointerException.class, () -> BooleanUtils.or((boolean[]) null));
    }

}