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
//    @Test
//    void testIsFalse_WithStringTrue_ReturnsFalse() {
//        assertFalse(BooleanUtils.isFalse(BooleanUtils.TRUE));
//    }
//
//    @Test
//    void testIsFalse_WithStringFalse_ReturnsTrue() {
//        assertTrue(BooleanUtils.isFalse(BooleanUtils.FALSE));
//    }
    @Test
    void testIsFalse_WithStringNull_ReturnsFalse() {
        assertFalse(BooleanUtils.isFalse(null));
    }
    
//    @Test
//    void testIsFalse_WithStringYes_ReturnsFalse() {
//        assertFalse(BooleanUtils.isFalse(BooleanUtils.YES));
//    }
//
//    @Test
//    void testIsFalse_WithStringNo_ReturnsFalse() {
//        assertFalse(BooleanUtils.isFalse(BooleanUtils.NO));
//    }
//
//    @Test
//    void testIsFalse_WithStringOn_ReturnsFalse() {
//        assertFalse(BooleanUtils.isFalse(BooleanUtils.ON));
//    }
//
//    @Test
//    void testIsFalse_WithStringOff_ReturnsFalse() {
//        assertFalse(BooleanUtils.isFalse(BooleanUtils.OFF));
//    }
//
//    @Test
//    void testIsFalse_WithStringNumber_ReturnsFalse() {
//        assertFalse(BooleanUtils.isFalse(NumberUtils.INTEGER_ONE));
//    }
//
//    @Test
//    void testIsFalse_WithStringEmpty_ReturnsFalse() {
//        assertFalse(BooleanUtils.isFalse(""));
//    }
//    @Test
//    void testXorWithTwoBooleans() {
//        assertFalse(booleanUtils.xor(true, true));
//        assertFalse(booleanUtils.xor(false, false));
//        assertTrue(booleanUtils.xor(true, false));
//        assertTrue(booleanUtils.xor(false, true));
//    }
//
//    @Test
//    void testXorWithThreeBooleans() {
//        assertFalse(booleanUtils.xor(true, true, true));
//        assertFalse(booleanUtils.xor(false, false, false));
//        assertTrue(booleanUtils.xor(true, false, true));
//        assertTrue(booleanUtils.xor(false, true, false));
//    }
//
//    @Test
//    void testXorWithFourBooleans() {
//        assertFalse(booleanUtils.xor(true, true, true, true));
//        assertFalse(booleanUtils.xor(false, false, false, false));
//        assertTrue(booleanUtils.xor(true, false, true, false));
//        assertTrue(booleanUtils.xor(false, true, false, true));
//    }
//
//    @Test
//    void testXorWithBooleanArray() {
//        assertFalse(booleanUtils.xor(new Boolean[] { true, true }));
//        assertFalse(booleanUtils.xor(new Boolean[] { false, false }));
//        assertTrue(booleanUtils.xor(new Boolean[] { true, false }));
//        assertTrue(booleanUtils.xor(new Boolean[] { false, true }));
//    }
//
//    @Test
//    void testXorWithBooleanArrayAndNull() {
//        assertFalse(booleanUtils.xor(new Boolean[] { false, null }));
//        assertTrue(booleanUtils.xor(new Boolean[] { true, null }));
//    }
//
//    @Test
//    void testXorWithEmptyBooleanArray() {
//        assertThrows(IllegalArgumentException.class, () -> booleanUtils.xor(new Boolean[] {}));
//    }
//
//    @Test
//    void testXorWithNullBooleanArray() {
//        assertThrows(NullPointerException.class, () -> booleanUtils.xor((Boolean[]) null));
//    }
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
//    @Test
//    void testIsTrueWithTrueBoolean() {
//        assertTrue(booleanUtils.isTrue(Boolean.TRUE));
//    }
//
//    @Test
//    void testIsTrueWithFalseBoolean() {
//        assertFalse(booleanUtils.isTrue(Boolean.FALSE));
//    }
//
//    @Test
//    void testIsTrueWithNullBoolean() {
//        assertFalse(booleanUtils.isTrue(null));
//    }
//
//    @Test
//    void testIsTrueWithStringTrue() {
//        assertTrue(booleanUtils.isTrue(BooleanUtils.TRUE));
//    }
//
//    @Test
//    void testIsTrueWithStringFalse() {
//        assertFalse(booleanUtils.isTrue(BooleanUtils.FALSE));
//    }
//
//    @Test
//    void testIsTrueWithStringYes() {
//        assertFalse(booleanUtils.isTrue(BooleanUtils.YES));
//    }
//
//    @Test
//    void testIsTrueWithStringNo() {
//        assertFalse(booleanUtils.isTrue(BooleanUtils.NO));
//    }
//
//    @Test
//    void testIsTrueWithStringOn() {
//        assertFalse(booleanUtils.isTrue(BooleanUtils.ON));
//    }
//
//    @Test
//    void testIsTrueWithStringOff() {
//        assertFalse(booleanUtils.isTrue(BooleanUtils.OFF));
//    }
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
//    @Test
//    void testNegate_WithTrue_ReturnsFalse() {
//        // Arrange
//        Boolean bool = Boolean.TRUE;
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void testNegate_WithFalse_ReturnsTrue() {
//        // Arrange
//        Boolean bool = Boolean.FALSE;
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    void testNegate_WithNull_ReturnsNull() {
//        // Arrange
//        Boolean bool = null;
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertNull(result);
//    }
//
//    @Test
//    void testNegate_WithPrimitiveTrue_ReturnsFalse() {
//        // Arrange
//        boolean bool = true;
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void testNegate_WithPrimitiveFalse_ReturnsTrue() {
//        // Arrange
//        boolean bool = false;
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    void testNegate_WithTrueString_ReturnsFalse() {
//        // Arrange
//        String bool = "true";
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void testNegate_WithFalseString_ReturnsTrue() {
//        // Arrange
//        String bool = "false";
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    void testNegate_WithYesString_ReturnsFalse() {
//        // Arrange
//        String bool = "yes";
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void testNegate_WithNoString_ReturnsTrue() {
//        // Arrange
//        String bool = "no";
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    void testNegate_WithOnString_ReturnsFalse() {
//        // Arrange
//        String bool = "on";
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void testNegate_WithOffString_ReturnsTrue() {
//        // Arrange
//        String bool = "off";
//
//        // Act
//        Boolean result = booleanUtils.negate(bool);
//
//        // Assert
//        assertTrue(result);
//    }
//    // Only @Test test functions
//
//    @Test
//    public void testToBooleanObjectInt() {
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(0));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(1));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(2));
//    }
//
//    @Test
//    public void testToBooleanObjectIntWithValues() {
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(0, 0, 2, 3));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(0, 0, 0, 3));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(0, 0, 0, 0));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(2, 1, 2, 3));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(2, 1, 2, 2));
//        assertNull(booleanUtils.toBooleanObject(3, 1, 2, 3));
//    }
//
//    @Test
//    public void testToBooleanObjectInteger() {
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(Integer.valueOf(0)));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(Integer.valueOf(1)));
//        assertNull(booleanUtils.toBooleanObject(Integer.valueOf(null)));
//    }
//
//    @Test
//    public void testToBooleanObjectIntegerWithValues() {
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(3)));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2)));
//        assertNull(booleanUtils.toBooleanObject(Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)));
//    }
//
//    @Test
//    public void testToBooleanObjectString() {
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("true"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("T"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("false"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("f"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("No"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("n"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("on"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("ON"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("off"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("oFf"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("yes"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("Y"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("1"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("0"));
//        assertNull(booleanUtils.toBooleanObject("blue"));
//        assertNull(booleanUtils.toBooleanObject("true "));
//        assertNull(booleanUtils.toBooleanObject("ono"));
//    }
//
//    @Test
//    public void testToBooleanObjectStringWithValues() {
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject("true", "true", "false", "null"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(null, null, "false", "null"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(null, null, null, "null"));
//        assertEquals(Boolean.TRUE, booleanUtils.toBooleanObject(null, null, null, null));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("false", "true", "false", "null"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject("false", "true", "false", "false"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(null, "true", null, "false"));
//        assertEquals(Boolean.FALSE, booleanUtils.toBooleanObject(null, "true", null, null));
//        assertNull(booleanUtils.toBooleanObject("null", "true", "false", "null"));
//    }
//    @Test
//    void testIsNotTrue_WithTrue_ReturnsFalse() {
//        assertFalse(booleanUtils.isNotTrue(Boolean.TRUE));
//    }
//
//    @Test
//    void testIsNotTrue_WithFalse_ReturnsTrue() {
//        assertTrue(booleanUtils.isNotTrue(Boolean.FALSE));
//    }
//
//    @Test
//    void testIsNotTrue_WithNull_ReturnsTrue() {
//        assertTrue(booleanUtils.isNotTrue(null));
//    }
//
//    @Test
//    void testIsNotTrue_WithStringTrue_ReturnsFalse() {
//        assertFalse(booleanUtils.isNotTrue(BooleanUtils.TRUE));
//    }
//
//    @Test
//    void testIsNotTrue_WithStringFalse_ReturnsTrue() {
//        assertTrue(booleanUtils.isNotTrue(BooleanUtils.FALSE));
//    }
//
//    @Test
//    void testIsNotTrue_WithStringYes_ReturnsFalse() {
//        assertFalse(booleanUtils.isNotTrue(BooleanUtils.YES));
//    }
//
//    @Test
//    void testIsNotTrue_WithStringNo_ReturnsTrue() {
//        assertTrue(booleanUtils.isNotTrue(BooleanUtils.NO));
//    }
//
//    @Test
//    void testIsNotTrue_WithStringOn_ReturnsFalse() {
//        assertFalse(booleanUtils.isNotTrue(BooleanUtils.ON));
//    }
//
//    @Test
//    void testIsNotTrue_WithStringOff_ReturnsTrue() {
//        assertTrue(booleanUtils.isNotTrue(BooleanUtils.OFF));
//    }
//    // Your Java code here
//
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
//    @Test
//    void testToStringTrueFalse_withTrue_shouldReturnTrue() {
//        assertEquals("true", booleanUtils.toStringTrueFalse(true));
//    }
//
//    @Test
//    void testToStringTrueFalse_withFalse_shouldReturnFalse() {
//        assertEquals("false", booleanUtils.toStringTrueFalse(false));
//    }
//
//    @Test
//    void testToStringTrueFalse_withTrueBoolean_shouldReturnTrue() {
//        assertEquals("true", booleanUtils.toStringTrueFalse(Boolean.TRUE));
//    }
//
//    @Test
//    void testToStringTrueFalse_withFalseBoolean_shouldReturnFalse() {
//        assertEquals("false", booleanUtils.toStringTrueFalse(Boolean.FALSE));
//    }
//
//    @Test
//    void testToStringTrueFalse_withNullBoolean_shouldReturnNull() {
//        assertNull(booleanUtils.toStringTrueFalse(null));
//    }
//
//    @Test
//    void testToStringTrueFalse_withInvalidBoolean_shouldThrowException() {
//        assertThrows(IllegalArgumentException.class, () -> booleanUtils.toStringTrueFalse(NumberUtils.INTEGER_ONE));
//    }
//    @Test
//    @DisplayName("should return unmodifiable list of booleans")
//    void shouldReturnUnmodifiableListOfBooleans() {
//        List<Boolean> expected = Arrays.asList(Boolean.FALSE, Boolean.TRUE);
//        List<Boolean> actual = booleanUtils.values();
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("should return list with size 2")
//    void shouldReturnListWithSizeTwo() {
//        List<Boolean> actual = booleanUtils.values();
//
//        assertEquals(2, actual.size());
//    }
//
//    @Test
//    @DisplayName("should contain Boolean.FALSE")
//    void shouldContainFalseBoolean() {
//        List<Boolean> actual = booleanUtils.values();
//
//        assertTrue(actual.contains(Boolean.FALSE));
//    }
//
//    @Test
//    @DisplayName("should contain Boolean.TRUE")
//    void shouldContainTrueBoolean() {
//        List<Boolean> actual = booleanUtils.values();
//
//        assertTrue(actual.contains(Boolean.TRUE));
//    }
//    @Test
//    void testIsNotFalse_Null_ReturnsTrue() {
//        Boolean bool = null;
//
//        assertTrue(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_True_ReturnsTrue() {
//        Boolean bool = Boolean.TRUE;
//
//        assertTrue(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_False_ReturnsFalse() {
//        Boolean bool = Boolean.FALSE;
//
//        assertFalse(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_Other_ReturnsTrue() {
//        Boolean bool = Boolean.valueOf("other");
//
//        assertTrue(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_TrueString_ReturnsTrue() {
//        Boolean bool = BooleanUtils.TRUE;
//
//        assertTrue(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_FalseString_ReturnsFalse() {
//        Boolean bool = BooleanUtils.FALSE;
//
//        assertFalse(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_YesString_ReturnsTrue() {
//        Boolean bool = BooleanUtils.YES;
//
//        assertTrue(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_NoString_ReturnsFalse() {
//        Boolean bool = BooleanUtils.NO;
//
//        assertFalse(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_OnString_ReturnsTrue() {
//        Boolean bool = BooleanUtils.ON;
//
//        assertTrue(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_OffString_ReturnsFalse() {
//        Boolean bool = BooleanUtils.OFF;
//
//        assertFalse(booleanUtils.isNotFalse(bool));
//    }
//
//    @Test
//    void testIsNotFalse_OtherString_ReturnsTrue() {
//        Boolean bool = BooleanUtils.YES + "other";
//
//        assertTrue(booleanUtils.isNotFalse(bool));
//    }
    // Your Java code here
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
    
//    @Test
//    @DisplayName("Should throw NullPointerException when array is null")
//    void testAndNullArray() {
//        assertThrows(NullPointerException.class, () -> BooleanUtils.and(null));
//    }
//
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
    // Your Java code here
//    @Test
//    @DisplayName("Should return 1 when input is true")
//    void shouldReturnOneWhenInputIsTrue() {
//        int result = booleanUtils.toInteger(true);
//        assertEquals(1, result);
//    }
//
//    @Test
//    @DisplayName("Should return 0 when input is false")
//    void shouldReturnZeroWhenInputIsFalse() {
//        int result = booleanUtils.toInteger(false);
//        assertEquals(0, result);
//    }
//
//    @Test
//    @DisplayName("Should return trueValue when input is true")
//    void shouldReturnTrueValueWhenInputIsTrue() {
//        int result = booleanUtils.toInteger(true, 10, 20);
//        assertEquals(10, result);
//    }
//
//    @Test
//    @DisplayName("Should return falseValue when input is false")
//    void shouldReturnFalseValueWhenInputIsFalse() {
//        int result = booleanUtils.toInteger(false, 10, 20);
//        assertEquals(20, result);
//    }
//
//    @Test
//    @DisplayName("Should return trueValue when input is Boolean.TRUE")
//    void shouldReturnTrueValueWhenInputIsBooleanTrue() {
//        int result = booleanUtils.toInteger(Boolean.TRUE, 10, 20, 30);
//        assertEquals(10, result);
//    }
//
//    @Test
//    @DisplayName("Should return falseValue when input is Boolean.FALSE")
//    void shouldReturnFalseValueWhenInputIsBooleanFalse() {
//        int result = booleanUtils.toInteger(Boolean.FALSE, 10, 20, 30);
//        assertEquals(20, result);
//    }
//
//    @Test
//    @DisplayName("Should return nullValue when input is null")
//    void shouldReturnNullValueWhenInputIsNull() {
//        int result = booleanUtils.toInteger(null, 10, 20, 30);
//        assertEquals(30, result);
//    }
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
    
//    @Test
//    @DisplayName("should return false when bool is null")
//    void shouldReturnFalseWhenBoolIsNull() {
//        boolean result = BooleanUtils.toBoolean(null);
//        assertEquals(false, result);
//    }
    
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
    
    @Test
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
    @DisplayName("should return false when value is null and trueValue is null")
    void shouldReturnFalseWhenValueIsNullAndTrueValueIsNull() {
        boolean result = BooleanUtils.toBoolean(null, null, 0);
        assertEquals(false, result);
    }
    
    @Test
    @DisplayName("should return true when value is null and falseValue is null")
    void shouldReturnTrueWhenValueIsNullAndFalseValueIsNull() {
        boolean result = BooleanUtils.toBoolean(null, 1, null);
        assertEquals(true, result);
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
    
//    @Test
//    @DisplayName("should return false when str is null")
//    void shouldReturnFalseWhenStrIsNull() {
//        boolean result = BooleanUtils.toBoolean(null);
//        assertEquals(false, result);
//    }
    
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
//    @Test
//    void testToStringYesNo_withTrue_returnsYes() {
//        String result = booleanUtils.toStringYesNo(true);
//        assertEquals("yes", result);
//    }
//
//    @Test
//    void testToStringYesNo_withFalse_returnsNo() {
//        String result = booleanUtils.toStringYesNo(false);
//        assertEquals("no", result);
//    }
//
//    @Test
//    void testToStringYesNo_withTrueBoolean_returnsYes() {
//        String result = booleanUtils.toStringYesNo(Boolean.TRUE);
//        assertEquals("yes", result);
//    }
//
//    @Test
//    void testToStringYesNo_withFalseBoolean_returnsNo() {
//        String result = booleanUtils.toStringYesNo(Boolean.FALSE);
//        assertEquals("no", result);
//    }
//
//    @Test
//    void testToStringYesNo_withNullBoolean_returnsNull() {
//        String result = booleanUtils.toStringYesNo(null);
//        assertNull(result);
//    }
//
//    @Test
//    void testToStringYesNo_withInvalidBoolean_returnsNull() {
//        String result = booleanUtils.toStringYesNo(NumberUtils.INTEGER_ONE);
//        assertNull(result);
//    }
//    @Test
//    @DisplayName("Should throw NullPointerException when array is null")
//    void shouldThrowNullPointerException() {
//        assertThrows(NullPointerException.class, () -> booleanUtils.oneHot((boolean[]) null));
//    }
//
//    @Test
//    @DisplayName("Should throw IllegalArgumentException when array is empty")
//    void shouldThrowIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> booleanUtils.oneHot());
//    }
//
//    @Test
//    @DisplayName("Should return false when all elements are false")
//    void shouldReturnFalseWhenAllElementsAreFalse() {
//        boolean result = booleanUtils.oneHot(false, false, false);
//        assertFalse(result);
//    }
//
//    @Test
//    @DisplayName("Should return true when one element is true")
//    void shouldReturnTrueWhenOneElementIsTrue() {
//        boolean result = booleanUtils.oneHot(false, true, false);
//        assertTrue(result);
//    }
//
//    @Test
//    @DisplayName("Should return false when multiple elements are true")
//    void shouldReturnFalseWhenMultipleElementsAreTrue() {
//        boolean result = booleanUtils.oneHot(true, true, false);
//        assertFalse(result);
//    }
//
//    @Test
//    @DisplayName("Should return true when first element is true and others are false")
//    void shouldReturnTrueWhenFirstElementIsTrueAndOthersAreFalse() {
//        boolean result = booleanUtils.oneHot(true, false, false);
//        assertTrue(result);
//    }
//
//    @Test
//    @DisplayName("Should return true when last element is true and others are false")
//    void shouldReturnTrueWhenLastElementIsTrueAndOthersAreFalse() {
//        boolean result = booleanUtils.oneHot(false, false, true);
//        assertTrue(result);
//    }
//
//    @Test
//    @DisplayName("Should throw NullPointerException when array is null")
//    void shouldThrowNullPointerException() {
//        assertThrows(NullPointerException.class, () -> booleanUtils.oneHot((Boolean[]) null));
//    }
//
//    @Test
//    @DisplayName("Should throw IllegalArgumentException when array is empty")
//    void shouldThrowIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> booleanUtils.oneHot());
//    }
//
//    @Test
//    @DisplayName("Should return false when all elements are false")
//    void shouldReturnFalseWhenAllElementsAreFalse() {
//        Boolean result = booleanUtils.oneHot(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
//        assertFalse(result);
//    }
//
//    @Test
//    @DisplayName("Should return true when one element is true")
//    void shouldReturnTrueWhenOneElementIsTrue() {
//        Boolean result = booleanUtils.oneHot(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
//        assertTrue(result);
//    }
//
//    @Test
//    @DisplayName("Should return false when multiple elements are true")
//    void shouldReturnFalseWhenMultipleElementsAreTrue() {
//        Boolean result = booleanUtils.oneHot(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
//        assertFalse(result);
//    }
//
//    @Test
//    @DisplayName("Should return true when first element is true and others are false")
//    void shouldReturnTrueWhenFirstElementIsTrueAndOthersAreFalse() {
//        Boolean result = booleanUtils.oneHot(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
//        assertTrue(result);
//    }
//
//    @Test
//    @DisplayName("Should return true when last element is true and others are false")
//    void shouldReturnTrueWhenLastElementIsTrueAndOthersAreFalse() {
//        Boolean result = booleanUtils.oneHot(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE);
//        assertTrue(result);
//    }
//    // Your Java code here
//
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
    @DisplayName("Should return nullString when bool is null")
    void shouldReturnNullStringWhenBoolIsNull() {
        // Arrange
        Boolean bool = null;
        String trueString = "true";
        String falseString = "false";
        String nullString = "null";
    
        // Act
        String result = BooleanUtils.toString(bool, trueString, falseString, nullString);
    
        // Assert
        assertNull(result);
    }
//    @Test
//    void testOr_withArrayOfBooleans_shouldReturnTrueIfAnyIsTrue() {
//        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.TRUE));
//        assertFalse(BooleanUtils.or(Boolean.FALSE, Boolean.FALSE));
//        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.FALSE));
//        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE));
//        assertTrue(BooleanUtils.or(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
//        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
//        assertFalse(BooleanUtils.or(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
//    }
    
    @Test
    void testOr_withArrayOfBooleans_shouldReturnTrueIfAnyIsTrueAndNullIsFalse() {
        assertTrue(BooleanUtils.or(Boolean.TRUE, null));
        assertFalse(BooleanUtils.or(Boolean.FALSE, null));
    }
    
    @Test
    void testOr_withArrayOfBooleans_shouldThrowNullPointerExceptionIfArrayIsNull() {
        assertThrows(NullPointerException.class, () -> BooleanUtils.or((Boolean[]) null));
    }
    
//    @Test
//    void testOr_withArrayOfBooleans_shouldThrowIllegalArgumentExceptionIfArrayIsEmpty() {
//        assertThrows(IllegalArgumentException.class, () -> BooleanUtils.or());
//    }
//
//    @Test
//    void testOr_withArrayOfPrimitives_shouldReturnTrueIfAnyIsTrue() {
//        assertTrue(BooleanUtils.or(true, true));
//        assertFalse(BooleanUtils.or(false, false));
//        assertTrue(BooleanUtils.or(true, false));
//        assertTrue(BooleanUtils.or(true, true, false));
//        assertTrue(BooleanUtils.or(true, true, true));
//        assertFalse(BooleanUtils.or(false, false, false));
//    }
//
    @Test
    void testOr_withArrayOfPrimitives_shouldThrowNullPointerExceptionIfArrayIsNull() {
        assertThrows(NullPointerException.class, () -> BooleanUtils.or((boolean[]) null));
    }
    
//    @Test
//    void testOr_withArrayOfPrimitives_shouldThrowIllegalArgumentExceptionIfArrayIsEmpty() {
//        assertThrows(IllegalArgumentException.class, () -> BooleanUtils.or());
////    }
//    @Test
//    void testToBooleanDefaultIfNull() {
//        // Test with non-null Boolean and different valueIfNull
//        assertTrue(booleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false));
//        assertTrue(booleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true));
//        assertFalse(booleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true));
//        assertFalse(booleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, false));
//
//        // Test with null Boolean and different valueIfNull
//        assertTrue(booleanUtils.toBooleanDefaultIfNull(null, true));
//        assertFalse(booleanUtils.toBooleanDefaultIfNull(null, false));
//    }
//
//    @Test
//    void testToBooleanDefaultIfNull_EdgeCases() {
//        // Test with null Boolean and valueIfNull = true
//        assertTrue(booleanUtils.toBooleanDefaultIfNull(null, true));
//
//        // Test with null Boolean and valueIfNull = false
//        assertFalse(booleanUtils.toBooleanDefaultIfNull(null, false));
//
//        // Test with Boolean.TRUE and valueIfNull = true
//        assertTrue(booleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true));
//
//        // Test with Boolean.TRUE and valueIfNull = false
//        assertTrue(booleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false));
//
//        // Test with Boolean.FALSE and valueIfNull = true
//        assertFalse(booleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true));
//
//        // Test with Boolean.FALSE and valueIfNull = false
//        assertFalse(booleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, false));
//    }
//    @Test
//    void testBooleanValues() {
//        Boolean[] expected = {Boolean.FALSE, Boolean.TRUE};
//        assertArrayEquals(expected, booleanUtils.booleanValues());
//    }
//
//    @Test
//    void testBooleanValuesUnmodifiable() {
//        assertThrows(UnsupportedOperationException.class, () -> {
//            booleanUtils.BOOLEAN_LIST.add(Boolean.FALSE);
//        });
//    }
//
//    @Test
//    void testBooleanValuesCoverage() {
//        Boolean[] expected = {Boolean.FALSE, Boolean.TRUE};
//        Boolean[] actual = booleanUtils.booleanValues();
//        assertEquals(expected.length, actual.length);
//        for (int i = 0; i < expected.length; i++) {
//            assertEquals(expected[i], actual[i]);
//        }
//    }
//
//    @Test
//    void testBooleanValuesStrings() {
//        String[] expected = {"false", "true"};
//        String[] actual = new String[booleanUtils.BOOLEAN_LIST.size()];
//        for (int i = 0; i < actual.length; i++) {
//            actual[i] = booleanUtils.BOOLEAN_LIST.get(i).toString();
//        }
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testBooleanValuesStringsCoverage() {
//        String[] expected = {"false", "true"};
//        String[] actual = new String[booleanUtils.BOOLEAN_LIST.size()];
//        for (int i = 0; i < actual.length; i++) {
//            actual[i] = booleanUtils.BOOLEAN_LIST.get(i).toString();
//        }
//        assertEquals(expected.length, actual.length);
//        for (int i = 0; i < expected.length; i++) {
//            assertEquals(expected[i], actual[i]);
//        }
//    }
//
//    @Test
//    void testBooleanValuesStringsConstants() {
//        assertEquals("false", booleanUtils.FALSE);
//        assertEquals("no", booleanUtils.NO);
//        assertEquals("off", booleanUtils.OFF);
//        assertEquals("on", booleanUtils.ON);
//        assertEquals("true", booleanUtils.TRUE);
//        assertEquals("yes", booleanUtils.YES);
//    }
//
//    @Test
//    void testBooleanValuesStringsConstantsCoverage() {
//        assertEquals("false", booleanUtils.FALSE);
//        assertEquals("no", booleanUtils.NO);
//        assertEquals("off", booleanUtils.OFF);
//        assertEquals("on", booleanUtils.ON);
//        assertEquals("true", booleanUtils.TRUE);
//        assertEquals("yes", booleanUtils.YES);
//    }

}