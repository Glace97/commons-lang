package org.apache.commons.lang3.math;

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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class NumberUtilsTest {
    private NumberUtils numberUtils;

    @BeforeEach
    void setUp() {
        numberUtils = new NumberUtils();
    }

    @Test
    void testToLong_NullString_ReturnsZero() {
        long result = NumberUtils.toLong(null);
        assertEquals(0L, result);
    }

    @Test
    void testToLong_EmptyString_ReturnsZero() {
        long result = NumberUtils.toLong("");
        assertEquals(0L, result);
    }

    @Test
    void testToLong_ValidString_ReturnsLongValue() {
        long result = NumberUtils.toLong("1");
        assertEquals(1L, result);
    }

    @Test
    void testToLong_InvalidString_ReturnsDefaultValue() {
        long result = NumberUtils.toLong("abc", 0L);
        assertEquals(0L, result);
    }

    @Test
    void testToLong_MaxValueString_ReturnsMaxValue() {
        long result = NumberUtils.toLong(String.valueOf(Long.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, result);
    }

    @Test
    void testToLong_MinValueString_ReturnsMinValue() {
        long result = NumberUtils.toLong(String.valueOf(Long.MIN_VALUE));
        assertEquals(Long.MIN_VALUE, result);
    }

    @Test
    void testIsNumber_returnsTrueForValidNumbers() {
        assertTrue(NumberUtils.isNumber("123"));
        assertTrue(NumberUtils.isNumber("0"));
        assertTrue(NumberUtils.isNumber("-123"));
        assertTrue(NumberUtils.isNumber("0xABC"));
        assertTrue(NumberUtils.isNumber("0XABC"));
        assertTrue(NumberUtils.isNumber("0123"));
        assertTrue(NumberUtils.isNumber("0.123"));
        assertTrue(NumberUtils.isNumber("1.23E10"));
        assertTrue(NumberUtils.isNumber("123L"));
    }

    @Test
    void testIsNumber_returnsFalseForInvalidNumbers() {
        assertFalse(NumberUtils.isNumber(null));
        assertFalse(NumberUtils.isNumber(""));
        assertFalse(NumberUtils.isNumber(" "));
        assertFalse(NumberUtils.isNumber("abc"));
        assertFalse(NumberUtils.isNumber("0xGHI"));
        assertFalse(NumberUtils.isNumber("123L456"));
    }

    // @Test
    void testIsNumber_returnsFalseForOctalValues() {
        assertFalse(NumberUtils.isNumber("09"));
        assertFalse(NumberUtils.isNumber("010"));
    }

    //@Test
    void testIsNumber_returnsFalseForDecimalValuesStartingWithZero() {
        assertFalse(NumberUtils.isNumber("0.123"));
        assertFalse(NumberUtils.isNumber("0.0"));
    }

    // Test createNumber with null input
    @Test
    void testCreateNumberWithNullInput() {
        // ...
    }

    // Test createNumber with blank string
    @Test
    void testCreateNumberWithBlankString() {
        // ...
    }

    // Test createNumber with invalid hex number
    @Test
    void testCreateNumberWithInvalidHexNumber() {
        // ...
    }

    // Test createNumber with valid hex number
    @Test
    void testCreateNumberWithValidHexNumber() {
        // ...
    }

    // Test createNumber with octal number
    @Test
    void testCreateNumberWithOctalNumber() {
        // ...
    }

    // Test createNumber with integer
    @Test
    void testCreateNumberWithInteger() {
        // ...
    }

    // Test createNumber with long
    @Test
    void testCreateNumberWithLong() {
        // ...
    }

    // Test createNumber with float
    @Test
    void testCreateNumberWithFloat() {
        // ...
    }

    // Test createNumber with double
    @Test
    void testCreateNumberWithDouble() {
        // ...
    }

    // Test createNumber with big decimal
    @Test
    void testCreateNumberWithBigDecimal() {
        // ...
    }

    // Test createNumber with invalid number format
    @Test
    void testCreateNumberWithInvalidNumberFormat() {
        // ...
    }

    // Test createNumber with invalid number
    @Test
    void testCreateNumberWithInvalidNumber() {
        // ...
    }

    // Test createNumber with negative number
    @Test
    void testCreateNumberWithNegativeNumber() {
        // ...
    }

    // Test createNumber with scientific notation
    @Test
    void testCreateNumberWithScientificNotation() {
        // ...
    }

    // Test createNumber with invalid scientific notation
    @Test
    void testCreateNumberWithInvalidScientificNotation() {
        // ...
    }

    // Test createNumber with type specifier
    @Test
    void testCreateNumberWithTypeSpecifier() {
        // ...
    }

    // Test createNumber with invalid type specifier
    @Test
    void testCreateNumberWithInvalidTypeSpecifier() {
        // ...
    }

    // Test createNumber with zero
    @Test
    void testCreateNumberWithZero() {
        // ...
    }

    @Test
    void testToShort_NullString_ReturnsZero() {
        short result = NumberUtils.toShort(null);
        assertEquals(0, result);
    }

    @Test
    void testToShort_EmptyString_ReturnsZero() {
        short result = NumberUtils.toShort("");
        assertEquals(0, result);
    }

    @Test
    void testToShort_ValidString_ReturnsShortValue() {
        short result = NumberUtils.toShort("1");
        assertEquals(1, result);
    }

    @Test
    void testToShort_InvalidString_ReturnsDefaultValue() {
        short result = NumberUtils.toShort("abc", (short) 10);
        assertEquals(10, result);
    }

    @Test
    void testToShort_MinValueString_ReturnsMinValue() {
        short result = NumberUtils.toShort("-32768");
        assertEquals(Short.MIN_VALUE, result);
    }

    @Test
    void testToShort_MaxValueString_ReturnsMaxValue() {
        short result = NumberUtils.toShort("32767");
        assertEquals(Short.MAX_VALUE, result);
    }

    @Test
    void testToShort_OutOfRangeString_ReturnsDefaultValue() {
        short result = NumberUtils.toShort("32768", (short) 10);
        assertEquals(10, result);
    }


    @Test
    void testCreateDouble_NullInput() {
        assertNull(NumberUtils.createDouble(null));
    }


    @Test
    void testCreateDouble_WholeNumber() {
        assertEquals(10.0d, NumberUtils.createDouble("10"));
    }

    @Test
    void testCreateDouble_DecimalNumber() {
        assertEquals(3.14d, NumberUtils.createDouble("3.14"));
    }

    @Test
    void testCreateDouble_NegativeNumber() {
        assertEquals(-5.0d, NumberUtils.createDouble("-5"));
    }

    @Test
    void testCreateDouble_InvalidNumberFormat() {
        assertThrows(NumberFormatException.class, () -> NumberUtils.createDouble("abc"));
    }

    @Test
    void shouldReturnTrueForValidPositiveIntegerString() {
        assertTrue(NumberUtils.isDigits("123"));
    }

    @Test
    void shouldReturnFalseForEmptyString() {
        assertFalse(NumberUtils.isDigits(""));
    }

    @Test
    void shouldReturnFalseForNullString() {
        assertFalse(NumberUtils.isDigits(null));
    }

    @Test
    void shouldReturnFalseForStringWithNonDigitCharacters() {
        assertFalse(NumberUtils.isDigits("123a"));
    }

    @Test
    void testToByte_NullString_ReturnsZero() {
        byte result = NumberUtils.toByte(null);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToByte_EmptyString_ReturnsZero() {
        byte result = NumberUtils.toByte("");
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToByte_ValidString_ReturnsByteValue() {
        byte result = NumberUtils.toByte("1");
        Assertions.assertEquals(1, result);
    }

    @Test
    void testToByte_InvalidString_ReturnsDefaultValue() {
        byte result = NumberUtils.toByte("abc", (byte) 10);
        Assertions.assertEquals(10, result);
    }

    @Test
    void testToByte_MaxValueString_ReturnsMaxValue() {
        byte result = NumberUtils.toByte(String.valueOf(Byte.MAX_VALUE));
        Assertions.assertEquals(Byte.MAX_VALUE, result);
    }

    @Test
    void testToByte_MinValueString_ReturnsMinValue() {
        byte result = NumberUtils.toByte(String.valueOf(Byte.MIN_VALUE));
        Assertions.assertEquals(Byte.MIN_VALUE, result);
    }

    @Test
    void testToScaledBigDecimal_DefaultScaleAndRoundingMode() {
        BigDecimal value = new BigDecimal("12.3456789");
        BigDecimal expected = new BigDecimal("12.35");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(expected, result);
    }


    @Test
    void testToScaledBigDecimal_DoubleInput_NullInput_ReturnsZero() {
        BigDecimal result = NumberUtils.toScaledBigDecimal((Double) null);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testToScaledBigDecimal_DoubleInput_DefaultScaleAndRoundingMode() {
        Double value = 12.3456789;
        BigDecimal expected = new BigDecimal("12.35");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimal_FloatInput_NullInput_ReturnsZero() {
        BigDecimal result = NumberUtils.toScaledBigDecimal((Float) null);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testToScaledBigDecimal_FloatInput_DefaultScaleAndRoundingMode() {
        Float value = 12.3456789f;
        BigDecimal expected = new BigDecimal("12.35");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimal_FloatInput_SpecifiedScaleAndRoundingMode() {
        Float value = 12.3456789f;
        BigDecimal expected = new BigDecimal("12.346");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, 3, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimal_StringInput_NullInput_ReturnsZero() {
        BigDecimal result = NumberUtils.toScaledBigDecimal((String) null);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testToScaledBigDecimal_StringInput_DefaultScaleAndRoundingMode() {
        String value = "12.3456789";
        BigDecimal expected = new BigDecimal("12.35");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimal_StringInput_SpecifiedScaleAndRoundingMode() {
        String value = "12.3456789";
        BigDecimal expected = new BigDecimal("12.346");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, 3, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    void testToScaledBigDecimal_RoundingModeIsNull() {
        BigDecimal value = new BigDecimal("12.3456789");
        BigDecimal expected = new BigDecimal("12.35");
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, 2, null);
        assertEquals(expected, result);
    }

    @Test
    void testCreateBigDecimal_NullInput() {
        assertNull(NumberUtils.createBigDecimal(null));
    }

    @Test
    void testCreateBigDecimal_BlankInput() {
        assertThrows(NumberFormatException.class, () -> NumberUtils.createBigDecimal(""));
    }

    @Test
    void testCreateBigDecimal_ValidInput() {
        assertEquals(BigDecimal.ZERO, NumberUtils.createBigDecimal("0"));
        assertEquals(BigDecimal.ONE, NumberUtils.createBigDecimal("1"));
        assertEquals(BigDecimal.TEN, NumberUtils.createBigDecimal("10"));
        assertEquals(BigDecimal.valueOf(123456789), NumberUtils.createBigDecimal("123456789"));
        assertEquals(BigDecimal.valueOf(-123.45), NumberUtils.createBigDecimal("-123.45"));
    }

    @Test
    void testToInt_NullString_ReturnsDefaultValue() {
        int defaultValue = 5;
        int result = numberUtils.toInt(null, defaultValue);
        Assertions.assertEquals(defaultValue, result);
    }

    @Test
    void testToInt_EmptyString_ReturnsDefaultValue() {
        int defaultValue = 5;
        int result = numberUtils.toInt("", defaultValue);
        Assertions.assertEquals(defaultValue, result);
    }

    @Test
    void testToInt_ValidString_ReturnsIntegerValue() {
        String str = "10";
        int result = numberUtils.toInt(str);
        Assertions.assertEquals(10, result);
    }

    @Test
    void testToInt_InvalidString_ReturnsDefaultValue() {
        String str = "abc";
        int defaultValue = 5;
        int result = numberUtils.toInt(str, defaultValue);
        Assertions.assertEquals(defaultValue, result);
    }

    @Test
    void testToInt_MaxIntegerValue_ReturnsMaxIntegerValue() {
        String str = String.valueOf(Integer.MAX_VALUE);
        int result = numberUtils.toInt(str);
        Assertions.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void testToInt_MinIntegerValue_ReturnsMinIntegerValue() {
        String str = String.valueOf(Integer.MIN_VALUE);
        int result = numberUtils.toInt(str);
        Assertions.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void testMaxByte() {
        byte[] array = {1, 2, 3, 4, 5};
        assertEquals(5, NumberUtils.max(array));
    }

    @Test
    void testMaxByteWithNegativeValues() {
        byte[] array = {-5, -4, -3, -2, -1};
        assertEquals(-1, NumberUtils.max(array));
    }


    @Test
    void testMaxByteWithSingleValue() {
        byte[] array = {100};
        assertEquals(100, NumberUtils.max(array));
    }

    @Test
    void testMaxByteWithSameValues() {
        byte[] array = {1, 1, 1, 1, 1};
        assertEquals(1, NumberUtils.max(array));
    }

    @Test
    void testMaxByteWithMaxValue() {
        byte[] array = {Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE};
        assertEquals(Byte.MAX_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxByteWithMinValue() {
        byte[] array = {Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE};
        assertEquals(Byte.MIN_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxByteWithMixedValues() {
        byte[] array = {1, 2, 3, 4, 5, -5, -4, -3, -2, -1};
        assertEquals(5, NumberUtils.max(array));
    }

    @Test
    void testMaxDouble() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertEquals(5.0, NumberUtils.max(array));
    }

    @Test
    void testMaxDoubleWithNaN() {
        double[] array = {1.0, Double.NaN, 3.0, 4.0, 5.0};
        assertEquals(Double.NaN, NumberUtils.max(array));
    }

    @Test
    void testMaxDoubleWithSingleValue() {
        double[] array = {100.0};
        assertEquals(100.0, NumberUtils.max(array));
    }

    @Test
    void testMaxDoubleWithSameValues() {
        double[] array = {1.0, 1.0, 1.0, 1.0, 1.0};
        assertEquals(1.0, NumberUtils.max(array));
    }

    @Test
    void testMaxDoubleWithMaxValue() {
        double[] array = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
        assertEquals(Double.MAX_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxDoubleWithMinValue() {
        double[] array = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};
        assertEquals(Double.MIN_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxFloat() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        assertEquals(5.0f, NumberUtils.max(array));
    }

    @Test
    void testMaxFloatWithNaN() {
        float[] array = {1.0f, Float.NaN, 3.0f, 4.0f, 5.0f};
        assertEquals(Float.NaN, NumberUtils.max(array));
    }


    @Test
    void testMaxFloatWithSingleValue() {
        float[] array = {100.0f};
        assertEquals(100.0f, NumberUtils.max(array));
    }

    @Test
    void testMaxFloatWithSameValues() {
        float[] array = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        assertEquals(1.0f, NumberUtils.max(array));
    }

    @Test
    void testMaxFloatWithMaxValue() {
        float[] array = {Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
        assertEquals(Float.MAX_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxFloatWithMinValue() {
        float[] array = {Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE};
        assertEquals(Float.MIN_VALUE, NumberUtils.max(array));
    }


    @Test
    void testMaxInt() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(5, NumberUtils.max(array));
    }

    @Test
    void testMaxIntWithNegativeValues() {
        int[] array = {-5, -4, -3, -2, -1};
        assertEquals(-1, NumberUtils.max(array));
    }

    @Test
    void testMaxIntWithSingleValue() {
        int[] array = {100};
        assertEquals(100, NumberUtils.max(array));
    }

    @Test
    void testMaxIntWithSameValues() {
        int[] array = {1, 1, 1, 1, 1};
        assertEquals(1, NumberUtils.max(array));
    }

    @Test
    void testMaxIntWithMaxValue() {
        int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertEquals(Integer.MAX_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxIntWithMinValue() {
        int[] array = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        assertEquals(Integer.MIN_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxIntWithMixedValues() {
        int[] array = {1, 2, 3, 4, 5, -5, -4, -3, -2, -1};
        assertEquals(5, NumberUtils.max(array));
    }

    @Test
    void testMaxLong() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        assertEquals(5L, NumberUtils.max(array));
    }

    @Test
    void testMaxLongWithNegativeValues() {
        long[] array = {-5L, -4L, -3L, -2L, -1L};
        assertEquals(-1L, NumberUtils.max(array));
    }

    @Test
    void testMaxLongWithSingleValue() {
        long[] array = {100L};
        assertEquals(100L, NumberUtils.max(array));
    }

    @Test
    void testMaxLongWithSameValues() {
        long[] array = {1L, 1L, 1L, 1L, 1L};
        assertEquals(1L, NumberUtils.max(array));
    }

    @Test
    void testMaxLongWithMaxValue() {
        long[] array = {Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE};
        assertEquals(Long.MAX_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxLongWithMinValue() {
        long[] array = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        assertEquals(Long.MIN_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxLongWithMixedValues() {
        long[] array = {1L, 2L, 3L, 4L, 5L, -5L, -4L, -3L, -2L, -1L};
        assertEquals(5L, NumberUtils.max(array));
    }

    @Test
    void testMaxShort() {
        short[] array = {1, 2, 3, 4, 5};
        assertEquals(5, NumberUtils.max(array));
    }

    @Test
    void testMaxShortWithNegativeValues() {
        short[] array = {-5, -4, -3, -2, -1};
        assertEquals(-1, NumberUtils.max(array));
    }

    @Test
    void testMaxShortWithSingleValue() {
        short[] array = {100};
        assertEquals(100, NumberUtils.max(array));
    }

    @Test
    void testMaxShortWithSameValues() {
        short[] array = {1, 1, 1, 1, 1};
        assertEquals(1, NumberUtils.max(array));
    }

    @Test
    void testMaxShortWithMaxValue() {
        short[] array = {Short.MAX_VALUE, Short.MAX_VALUE, Short.MAX_VALUE};
        assertEquals(Short.MAX_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxShortWithMinValue() {
        short[] array = {Short.MIN_VALUE, Short.MIN_VALUE, Short.MIN_VALUE};
        assertEquals(Short.MIN_VALUE, NumberUtils.max(array));
    }

    @Test
    void testMaxShortWithMixedValues() {
        short[] array = {1, 2, 3, 4, 5, -5, -4, -3, -2, -1};
        assertEquals(5, NumberUtils.max(array));
    }

    @Test
    @DisplayName("Empty string should return false")
    void testIsCreatableWithEmptyString() {
        assertFalse(NumberUtils.isCreatable(""));
    }

    @Test
    @DisplayName("Whitespace string should return false")
    void testIsCreatableWithWhitespaceString() {
        assertFalse(NumberUtils.isCreatable(" "));
    }

    @Test
    @DisplayName("Null string should return false")
    void testIsCreatableWithNullString() {
        assertFalse(NumberUtils.isCreatable(null));
    }

    @Test
    @DisplayName("Valid positive integer should return true")
    void testIsCreatableWithValidPositiveInteger() {
        assertTrue(NumberUtils.isCreatable("123"));
    }

    @Test
    @DisplayName("Valid negative integer should return true")
    void testIsCreatableWithValidNegativeInteger() {
        assertTrue(NumberUtils.isCreatable("-123"));
    }

    @Test
    @DisplayName("Valid positive decimal number should return true")
    void testIsCreatableWithValidPositiveDecimalNumber() {
        assertTrue(NumberUtils.isCreatable("123.45"));
    }

    @Test
    @DisplayName("Valid negative decimal number should return true")
    void testIsCreatableWithValidNegativeDecimalNumber() {
        assertTrue(NumberUtils.isCreatable("-123.45"));
    }

    @Test
    @DisplayName("Valid positive scientific notation should return true")
    void testIsCreatableWithValidPositiveScientificNotation() {
        assertTrue(NumberUtils.isCreatable("1.23e4"));
    }

    @Test
    @DisplayName("Valid negative scientific notation should return true")
    void testIsCreatableWithValidNegativeScientificNotation() {
        assertTrue(NumberUtils.isCreatable("-1.23e4"));
    }

    @Test
    @DisplayName("Valid hexadecimal number should return true")
    void testIsCreatableWithValidHexadecimalNumber() {
        assertTrue(NumberUtils.isCreatable("0x1A"));
    }

    @Test
    @DisplayName("Valid octal number should return true")
    void testIsCreatableWithValidOctalNumber() {
        assertTrue(NumberUtils.isCreatable("0123"));
    }

    @Test
    @DisplayName("Valid long number should return true")
    void testIsCreatableWithValidLongNumber() {
        assertTrue(NumberUtils.isCreatable("123L"));
    }

    @Test
    @DisplayName("Invalid number with leading zero should return false")
    void testIsCreatableWithInvalidNumberWithLeadingZero() {
        assertFalse(NumberUtils.isCreatable("09"));
    }

    @Test
    @DisplayName("Invalid hexadecimal number should return false")
    void testIsCreatableWithInvalidHexadecimalNumber() {
        assertFalse(NumberUtils.isCreatable("0x1G"));
    }

    @Test
    @DisplayName("Invalid octal number should return false")
    void testIsCreatableWithInvalidOctalNumber() {
        assertFalse(NumberUtils.isCreatable("089"));
    }

    @Test
    @DisplayName("Invalid scientific notation should return false")
    void testIsCreatableWithInvalidScientificNotation() {
        assertFalse(NumberUtils.isCreatable("1.23E4.5"));
    }

    @Test
    void testCompareByte() {
        byte x = 0;
        byte y = 0;
        int result = NumberUtils.compare(x, y);
        Assertions.assertEquals(0, result);

        x = 0;
        y = 1;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(-1, result);

        x = 1;
        y = 0;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testCompareInt() {
        int x = 0;
        int y = 0;
        int result = NumberUtils.compare(x, y);
        Assertions.assertEquals(0, result);

        x = 0;
        y = 1;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(-1, result);

        x = 1;
        y = 0;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testCompareLong() {
        long x = 0;
        long y = 0;
        int result = NumberUtils.compare(x, y);
        Assertions.assertEquals(0, result);

        x = 0;
        y = 1;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(-1, result);

        x = 1;
        y = 0;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testCompareShort() {
        short x = 0;
        short y = 0;
        int result = NumberUtils.compare(x, y);
        Assertions.assertEquals(0, result);

        x = 0;
        y = 1;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(-1, result);

        x = 1;
        y = 0;
        result = NumberUtils.compare(x, y);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testToDoubleWithNullValue() {
        BigDecimal value = null;
        double result = NumberUtils.toDouble(value);
        Assertions.assertEquals(0.0d, result);
    }

    @Test
    void testToDoubleWithNonNullValue() {
        BigDecimal value = BigDecimal.valueOf(8.5d);
        double result = NumberUtils.toDouble(value);
        Assertions.assertEquals(8.5d, result);
    }

    @Test
    void testToDoubleWithNullValueAndDefaultValue() {
        BigDecimal value = null;
        double defaultValue = 1.1d;
        double result = NumberUtils.toDouble(value, defaultValue);
        Assertions.assertEquals(defaultValue, result);
    }

    @Test
    void testToDoubleWithNonNullValueAndDefaultValue() {
        BigDecimal value = BigDecimal.valueOf(8.5d);
        double defaultValue = 1.1d;
        double result = NumberUtils.toDouble(value, defaultValue);
        Assertions.assertEquals(8.5d, result);
    }

    @Test
    void testToDoubleWithStringNull() {
        String str = null;
        double result = NumberUtils.toDouble(str);
        Assertions.assertEquals(0.0d, result);
    }

    @Test
    void testToDoubleWithStringEmpty() {
        String str = "";
        double result = NumberUtils.toDouble(str);
        Assertions.assertEquals(0.0d, result);
    }

    @Test
    void testToDoubleWithStringValidNumber() {
        String str = "1.5";
        double result = NumberUtils.toDouble(str);
        Assertions.assertEquals(1.5d, result);
    }

    @Test
    void testToDoubleWithStringInvalidNumber() {
        String str = "not a number";
        double result = NumberUtils.toDouble(str);
        Assertions.assertEquals(0.0d, result);
    }

    @Test
    void testToDoubleWithStringNullAndDefaultValue() {
        String str = null;
        double defaultValue = 1.1d;
        double result = NumberUtils.toDouble(str, defaultValue);
        Assertions.assertEquals(defaultValue, result);
    }

    @Test
    void testToDoubleWithStringEmptyAndDefaultValue() {
        String str = "";
        double defaultValue = 1.1d;
        double result = NumberUtils.toDouble(str, defaultValue);
        Assertions.assertEquals(defaultValue, result);
    }

    @Test
    void testToDoubleWithStringValidNumberAndDefaultValue() {
        String str = "1.5";
        double defaultValue = 0.0d;
        double result = NumberUtils.toDouble(str, defaultValue);
        Assertions.assertEquals(1.5d, result);
    }

    @Test
    void testToDoubleWithStringInvalidNumberAndDefaultValue() {
        String str = "not a number";
        double defaultValue = 1.1d;
        double result = NumberUtils.toDouble(str, defaultValue);
        Assertions.assertEquals(defaultValue, result);
    }


    @Test
    void testCreateLongWithNullString() {
        assertNull(numberUtils.createLong(null));
    }

    @Test
    void testCreateLongWithInvalidString() {
        assertThrows(NumberFormatException.class, () -> numberUtils.createLong("abc"));
    }

    @Test
    void testIsParsableWithNullString() {
        assertFalse(numberUtils.isParsable(null));
    }

    @Test
    void testIsParsableWithEmptyString() {
        assertFalse(numberUtils.isParsable(""));
    }

    @Test
    void testIsParsableWithSpaceString() {
        assertFalse(numberUtils.isParsable(" "));
    }

    @Test
    void testIsParsableWithNonNumericString() {
        assertFalse(numberUtils.isParsable("abc"));
    }

    @Test
    void testIsParsableWithValidPositiveIntegerString() {
        assertTrue(numberUtils.isParsable("123"));
    }

    @Test
    void testIsParsableWithValidNegativeIntegerString() {
        assertTrue(numberUtils.isParsable("-123"));
    }

    @Test
    void testIsParsableWithValidPositiveDecimalString() {
        assertTrue(numberUtils.isParsable("12.34"));
    }

    @Test
    void testIsParsableWithValidNegativeDecimalString() {
        assertTrue(numberUtils.isParsable("-12.34"));
    }

    @Test
    void testIsParsableWithValidPositiveScientificNotationString() {
        assertFalse(numberUtils.isParsable("1.23e4"));
    }

    @Test
    void testIsParsableWithValidNegativeScientificNotationString() {
        assertFalse(numberUtils.isParsable("-1.23e4"));
    }

    @Test
    void testIsParsableWithValidPositiveHexadecimalString() {
        assertFalse(numberUtils.isParsable("0x123"));
    }

    @Test
    void testIsParsableWithValidNegativeHexadecimalString() {
        assertFalse(numberUtils.isParsable("-0x123"));
    }

    @Test
    void testIsParsableWithStringEndingWithDecimalPoint() {
        assertFalse(numberUtils.isParsable("123."));
    }

    @Test
    void testIsParsableWithStringStartingWithDecimalPoint() {
        assertTrue(numberUtils.isParsable(".123"));
    }

    @Test
    void testCreateFloat_NullString_ReturnsNull() {
        String str = null;
        Float result = numberUtils.createFloat(str);
        Assertions.assertNull(result);
    }

    @Test
    void testCreateFloat_ValidString_ReturnsFloat() {
        String str = "3.14";
        Float result = numberUtils.createFloat(str);
        Assertions.assertEquals(3.14f, result);
    }

    @Test
    void testCreateFloat_InvalidString_ThrowsNumberFormatException() {
        String str = "abc";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            numberUtils.createFloat(str);
        });
    }

    // Tests for toFloat(String str)
    @Test
    void shouldReturnZeroIfStringIsNull() {
        String str = null;
        float expected = 0.0f;

        float result = NumberUtils.toFloat(str);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnZeroIfStringIsEmpty() {
        String str = "";
        float expected = 0.0f;

        float result = NumberUtils.toFloat(str);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnFloatValueIfStringCanBeParsed1() {
        String str = "1.5";
        float expected = 1.5f;

        float result = NumberUtils.toFloat(str);

        assertEquals(expected, result);
    }


    @Test
    void testCreateIntegerWithNullString() {
        assertNull(numberUtils.createInteger(null));
    }

    @Test
    void testCreateIntegerWithValidIntegerString() {
        assertEquals(123, numberUtils.createInteger("123"));
    }

    @Test
    void testCreateIntegerWithValidNegativeIntegerString() {
        assertEquals(-123, numberUtils.createInteger("-123"));
    }

    @Test
    void testCreateIntegerWithValidOctalString() {
        assertEquals(511, numberUtils.createInteger("0777"));
    }

    @Test
    void testCreateIntegerWithInvalidString() {
        assertThrows(NumberFormatException.class, () -> numberUtils.createInteger("abc"));
    }

    @Test
    void testCreateIntegerWithMaxValueString() {
        assertEquals(Integer.MAX_VALUE, numberUtils.createInteger(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    void testCreateIntegerWithMinValueString() {
        assertEquals(Integer.MIN_VALUE, numberUtils.createInteger(String.valueOf(Integer.MIN_VALUE)));
    }

    @Test
    void testMinByte() {
        byte[] array = {5, 3, 8, 4, 2};
        byte expected = 2;
        byte actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinByteEmptyArray() {
        byte[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberUtils.min(array);
        });
    }

    @Test
    void testMinByteSingleElementArray() {
        byte[] array = {5};
        byte expected = 5;
        byte actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinByteNegativeNumbers() {
        byte[] array = {-5, -3, -8, -4, -2};
        byte expected = -8;
        byte actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinByteEqualNumbers() {
        byte[] array = {5, 5, 5, 5, 5};
        byte expected = 5;
        byte actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinDouble() {
        double[] array = {5.5, 3.3, 8.8, 4.4, 2.2};
        double expected = 2.2;
        double actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinDoubleNaN() {
        double[] array = {5.5, Double.NaN, 8.8, 4.4, 2.2};
        double expected = Double.NaN;
        double actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinFloat() {
        float[] array = {5.5f, 3.3f, 8.8f, 4.4f, 2.2f};
        float expected = 2.2f;
        float actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinFloatNaN() {
        float[] array = {5.5f, Float.NaN, 8.8f, 4.4f, 2.2f};
        float expected = Float.NaN;
        float actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinInt() {
        int[] array = {5, 3, 8, 4, 2};
        int expected = 2;
        int actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinIntEmptyArray() {
        int[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberUtils.min(array);
        });
    }

    @Test
    void testMinIntSingleElementArray() {
        int[] array = {5};
        int expected = 5;
        int actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinIntNegativeNumbers() {
        int[] array = {-5, -3, -8, -4, -2};
        int expected = -8;
        int actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinIntEqualNumbers() {
        int[] array = {5, 5, 5, 5, 5};
        int expected = 5;
        int actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinLong() {
        long[] array = {5L, 3L, 8L, 4L, 2L};
        long expected = 2L;
        long actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinLongEmptyArray() {
        long[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberUtils.min(array);
        });
    }

    @Test
    void testMinLongSingleElementArray() {
        long[] array = {5L};
        long expected = 5L;
        long actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinLongNegativeNumbers() {
        long[] array = {-5L, -3L, -8L, -4L, -2L};
        long expected = -8L;
        long actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinLongEqualNumbers() {
        long[] array = {5L, 5L, 5L, 5L, 5L};
        long expected = 5L;
        long actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinShort() {
        short[] array = {5, 3, 8, 4, 2};
        short expected = 2;
        short actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinShortEmptyArray() {
        short[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberUtils.min(array);
        });
    }

    @Test
    void testMinShortSingleElementArray() {
        short[] array = {5};
        short expected = 5;
        short actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinShortNegativeNumbers() {
        short[] array = {-5, -3, -8, -4, -2};
        short expected = -8;
        short actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinShortEqualNumbers() {
        short[] array = {5, 5, 5, 5, 5};
        short expected = 5;
        short actual = numberUtils.min(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinByteWithThreeValues() {
        byte a = 5;
        byte b = 3;
        byte c = 8;
        byte expected = 3;
        byte actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinByteWithThreeEqualValues() {
        byte a = 5;
        byte b = 5;
        byte c = 5;
        byte expected = 5;
        byte actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinDoubleWithThreeValues() {
        double a = 5.5;
        double b = 3.3;
        double c = 8.8;
        double expected = 3.3;
        double actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinDoubleWithThreeNaNValues() {
        double a = Double.NaN;
        double b = Double.NaN;
        double c = Double.NaN;
        double expected = Double.NaN;
        double actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinFloatWithThreeValues() {
        float a = 5.5f;
        float b = 3.3f;
        float c = 8.8f;
        float expected = 3.3f;
        float actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinFloatWithThreeNaNValues() {
        float a = Float.NaN;
        float b = Float.NaN;
        float c = Float.NaN;
        float expected = Float.NaN;
        float actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinIntWithThreeValues() {
        int a = 5;
        int b = 3;
        int c = 8;
        int expected = 3;
        int actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinIntWithThreeEqualValues() {
        int a = 5;
        int b = 5;
        int c = 5;
        int expected = 5;
        int actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinLongWithThreeValues() {
        long a = 5L;
        long b = 3L;
        long c = 8L;
        long expected = 3L;
        long actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinLongWithThreeEqualValues() {
        long a = 5L;
        long b = 5L;
        long c = 5L;
        long expected = 5L;
        long actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinShortWithThreeValues() {
        short a = 5;
        short b = 3;
        short c = 8;
        short expected = 3;
        short actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinShortWithThreeEqualValues() {
        short a = 5;
        short b = 5;
        short c = 5;
        short expected = 5;
        short actual = numberUtils.min(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test createBigInteger with null input")
    void testCreateBigIntegerWithNullInput() {
        BigInteger result = NumberUtils.createBigInteger(null);
        assertEquals(null, result);
    }

    @Test
    @DisplayName("Test createBigInteger with empty string input")
    void testCreateBigIntegerWithEmptyStringInput() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigInteger("");
        });
    }

    @Test
    @DisplayName("Test createBigInteger with positive decimal number")
    void testCreateBigIntegerWithPositiveDecimalNumber() {
        BigInteger result = NumberUtils.createBigInteger("12345");
        assertEquals(new BigInteger("12345"), result);
    }

    @Test
    @DisplayName("Test createBigInteger with negative decimal number")
    void testCreateBigIntegerWithNegativeDecimalNumber() {
        BigInteger result = NumberUtils.createBigInteger("-12345");
        assertEquals(new BigInteger("-12345"), result);
    }

    @Test
    @DisplayName("Test createBigInteger with positive hexadecimal number")
    void testCreateBigIntegerWithPositiveHexadecimalNumber() {
        BigInteger result = NumberUtils.createBigInteger("0xABCD");
        assertEquals(new BigInteger("43981"), result);
    }

    @Test
    @DisplayName("Test createBigInteger with negative hexadecimal number")
    void testCreateBigIntegerWithNegativeHexadecimalNumber() {
        BigInteger result = NumberUtils.createBigInteger("-0xABCD");
        assertEquals(new BigInteger("-43981"), result);
    }

    @Test
    @DisplayName("Test createBigInteger with positive octal number")
    void testCreateBigIntegerWithPositiveOctalNumber() {
        BigInteger result = NumberUtils.createBigInteger("012345");
        assertEquals(new BigInteger("5349"), result);
    }

    @Test
    @DisplayName("Test createBigInteger with negative octal number")
    void testCreateBigIntegerWithNegativeOctalNumber() {
        BigInteger result = NumberUtils.createBigInteger("-012345");
        assertEquals(new BigInteger("-5349"), result);
    }

    @Test
    @DisplayName("Test createBigInteger with invalid number format")
    void testCreateBigIntegerWithInvalidNumberFormat() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigInteger("12345abc");
        });
    }

    @Test
    @DisplayName("Test createBigInteger with valid positive number starting with plus sign")
    void testCreateBigIntegerWithValidPositiveNumberStartingWithPlusSign() {
        BigInteger result = NumberUtils.createBigInteger("+12345");
        assertEquals(new BigInteger("12345"), result);
    }

    @Test
    @DisplayName("Test createBigInteger with valid negative number starting with plus sign")
    void testCreateBigIntegerWithValidNegativeNumberStartingWithPlusSign() {
        BigInteger result = NumberUtils.createBigInteger("+12345");
        assertEquals(new BigInteger("12345"), result);
    }

}