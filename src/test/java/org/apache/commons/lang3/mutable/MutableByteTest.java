package org.apache.commons.lang3.mutable;

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


import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MutableByteTest {

    private MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte();
    }

    @Test
    @DisplayName("Should return zero")
    void shouldReturnZero() {
        assertEquals(0, mutableByte.intValue());
    }

    @Test
    @DisplayName("Should return the positive value")
    void shouldReturnPositiveValue() {
        assertEquals(42, mutableByte.intValue());
    }

    @Test
    @DisplayName("Should return the negative value")
    void shouldReturnNegativeValue() {
        assertEquals(-42, mutableByte.intValue());
    }

    @Test
    @DisplayName("Should throw NumberFormatException")
    void shouldThrowNumberFormatException1() {
        assertThrows(NumberFormatException.class, mutableByte::intValue);
    }

    @Test
    @DisplayName("Should throw NullPointerException")
    void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, mutableByte::intValue);
    }

    @Test
    @DisplayName("Should throw NumberFormatException")
    void shouldThrowNumberFormatException2() {
        assertThrows(NumberFormatException.class, mutableByte::intValue);
    }

    @Test
    void testDecrementAndGetFromZero() {
        byte result = mutableByte.decrementAndGet();
        assertEquals(-1, result);
    }

    @Test
    void testDecrementAndGetFromPositiveValue() {
        mutableByte = new MutableByte((byte) 5);
        byte result = mutableByte.decrementAndGet();
        assertEquals(4, result);
    }

    @Test
    void testDecrementAndGetFromNegativeValue() {
        mutableByte = new MutableByte((byte) -5);
        byte result = mutableByte.decrementAndGet();
        assertEquals(-6, result);
    }

    @Test
    void testDecrementAndGetWhenValueIsByteMinValue() {
        mutableByte = new MutableByte(Byte.MIN_VALUE);
        byte result = mutableByte.decrementAndGet();
        assertEquals(Byte.MAX_VALUE, result);
    }

    @Test
    void testDecrementAndGetWhenValueIsByteMaxValue() {
        mutableByte = new MutableByte(Byte.MAX_VALUE);
        byte result = mutableByte.decrementAndGet();
        assertEquals(Byte.MAX_VALUE - 1, result);
    }

    @Test
    @DisplayName("should increment value by 1 and return incremented value")
    void shouldIncrementValueAndReturnIncrementedValue() {
        byte result = mutableByte.incrementAndGet();
        assertEquals(1, result);
    }

    @Test
    @DisplayName("should increment value by 1 multiple times and return incremented value")
    void shouldIncrementValueMultipleTimesAndReturnIncrementedValue() {
        byte result = mutableByte.incrementAndGet();
        assertEquals(1, result);
        result = mutableByte.incrementAndGet();
        assertEquals(2, result);
        result = mutableByte.incrementAndGet();
        assertEquals(3, result);
    }

//    @ParameterizedTest
//    @ValueSource(bytes = {Byte.MIN_VALUE, 0, Byte.MAX_VALUE})
//    @DisplayName("should increment value by 1 and return incremented value for all possible byte values")
//    void shouldIncrementValueAndReturnIncrementedValueForAllPossibleByteValues(byte value) {
//        mutableByte = new MutableByte(value);
//        byte result = mutableByte.incrementAndGet();
//        assertEquals(value + 1, result);
//    }

    @Test
    void testToByteWithDefaultValue() {
        assertEquals(0, Optional.ofNullable(mutableByte.toByte()));
    }

    @Test
    void testToByteWithValue() {
        mutableByte = new MutableByte((byte) 10);
        assertEquals(10, Optional.ofNullable(mutableByte.toByte()));
    }

    @Test
    void testToByteWithNumber() {
        mutableByte = new MutableByte(NumberUtils.BYTE_ONE);
        assertEquals(1, Optional.ofNullable(mutableByte.toByte()));
    }

    @Test
    void testToByteWithString() {
        mutableByte = new MutableByte("20");
        assertEquals(20, Optional.ofNullable(mutableByte.toByte()));
    }

    @Test
    void testToByteWithInvalidString() {
        assertThrows(NumberFormatException.class, () -> new MutableByte("abc").toByte());
    }

    @Test
    void testHashCodeDefaultValue() {
        mutableByte = new MutableByte();
        assertEquals(0, mutableByte.hashCode());
    }

    @Test
    void testHashCodePositiveValue() {
        mutableByte = new MutableByte((byte) 10);
        assertEquals(10, mutableByte.hashCode());
    }

    @Test
    void testHashCodeNegativeValue() {
        mutableByte = new MutableByte((byte) -5);
        assertEquals(-5, mutableByte.hashCode());
    }

    @Test
    void testHashCodeFromNumber() {
        mutableByte = new MutableByte(NumberUtils.BYTE_ONE);
        assertEquals(1, mutableByte.hashCode());
    }

    @Test
    void testHashCodeFromString() {
        mutableByte = new MutableByte("5");
        assertEquals(5, mutableByte.hashCode());
    }

    @Test
    void testHashCodeFromStringWithLeadingZeros() {
        mutableByte = new MutableByte("0005");
        assertEquals(5, mutableByte.hashCode());
    }

    @Test
    void testHashCodeFromStringWithNegativeValue() {
        mutableByte = new MutableByte("-5");
        assertEquals(-5, mutableByte.hashCode());
    }

    @Test
    void testHashCodeFromStringWithInvalidValue() {
        assertThrows(NumberFormatException.class, () -> new MutableByte("abc"));
    }

    @Test
    void testSubtract_byte() {
        mutableByte.subtract((byte) 2);
        assertEquals(-2, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_byte_negativeResult() {
        mutableByte.subtract((byte) 5);
        assertEquals(-5, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_byte_zeroResult() {
        mutableByte.subtract((byte) 0);
        assertEquals(0, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_byte_maxValue() {
        mutableByte.subtract(Byte.MAX_VALUE);
        assertEquals(Byte.MIN_VALUE + 1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_byte_minValue() {
        mutableByte.subtract(Byte.MIN_VALUE);
        assertEquals(Byte.MAX_VALUE, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_Number() {
        mutableByte.subtract(NumberUtils.createNumber("3"));
        assertEquals(-3, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_Number_negativeResult() {
        mutableByte.subtract(NumberUtils.createNumber("7"));
        assertEquals(-7, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_Number_zeroResult() {
        mutableByte.subtract(NumberUtils.createNumber("0"));
        assertEquals(0, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_Number_maxValue() {
        mutableByte.subtract(NumberUtils.createNumber(String.valueOf(Byte.MAX_VALUE)));
        assertEquals(Byte.MIN_VALUE + 1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSubtract_Number_minValue() {
        mutableByte.subtract(NumberUtils.createNumber(String.valueOf(Byte.MIN_VALUE)));
        assertEquals(Byte.MAX_VALUE, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void floatValue_shouldReturnZeroByDefault() {
        MutableByte mutableByte = new MutableByte();
        assertEquals(0.0f, mutableByte.floatValue());
    }

    @Test
    void floatValue_shouldReturnInitialValue() {
        byte initialValue = 42;
        MutableByte mutableByte = new MutableByte(initialValue);
        assertEquals(initialValue, mutableByte.floatValue());
    }

    @Test
    void floatValue_shouldReturnByteValueFromNumber() {
        byte byteValue = 42;
        MutableByte mutableByte = new MutableByte(byteValue);
        assertEquals(byteValue, mutableByte.floatValue());
    }

    @Test
    void floatValue_shouldParseStringValue() {
        String stringValue = "42";
        MutableByte mutableByte = new MutableByte(stringValue);
        assertEquals(Byte.parseByte(stringValue), mutableByte.floatValue());
    }

//    @Test
//    void floatValue_shouldThrowNumberFormatExceptionForInvalidString() {
//        String invalidValue = "abc";
//        MutableByte mutableByte = new MutableByte();
//
//        try {
//            mutableByte = new MutableByte(invalidValue);
//        } catch (NumberFormatException e) {
//            assertEquals(0.0f, mutableByte.floatValue());
//            return;
//        }
//
//        assertEquals("NumberFormatException not thrown", 0.0f, mutableByte.floatValue());
//    }

    @Test
    void testLongValue() {
        MutableByte mutableByte = new MutableByte((byte) 10);
        assertEquals(10L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithZero() {
        MutableByte mutableByte = new MutableByte((byte) 0);
        assertEquals(0L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithNegativeValue() {
        MutableByte mutableByte = new MutableByte((byte) -5);
        assertEquals(-5L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        assertEquals(Byte.MAX_VALUE, mutableByte.longValue());
    }

    @Test
    void testLongValueWithMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
        assertEquals(Byte.MIN_VALUE, mutableByte.longValue());
    }

//    @Test
//    void testLongValueWithNullValue() {
//        MutableByte mutableByte = new MutableByte((byte) 10);
//        mutableByte = null;
//        assertThrows(NullPointerException.class, () -> mutableByte.longValue());
//    }

    @Test
    void testLongValueWithString() {
        MutableByte mutableByte = new MutableByte("10");
        assertEquals(10L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithStringNegativeValue() {
        MutableByte mutableByte = new MutableByte("-5");
        assertEquals(-5L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithStringMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.toString(Byte.MAX_VALUE));
        assertEquals(Byte.MAX_VALUE, mutableByte.longValue());
    }

    @Test
    void testLongValueWithStringMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.toString(Byte.MIN_VALUE));
        assertEquals(Byte.MIN_VALUE, mutableByte.longValue());
    }

    @Test
    void testLongValueWithInvalidString() {
        MutableByte mutableByte = new MutableByte("abc");
        assertThrows(NumberFormatException.class, mutableByte::longValue);
    }

    @Test
    @DisplayName("should decrement the value by 1 and return the original value")
    void shouldDecrementAndReturnValue() {
        MutableByte mutableByte = new MutableByte((byte) 5);
        byte result = mutableByte.getAndDecrement();
        assertEquals(5, result);
        assertEquals(4, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    @DisplayName("should decrement the value by 1 and return the original value for negative values")
    void shouldDecrementAndReturnValueForNegativeValues() {
        MutableByte mutableByte = new MutableByte((byte) -3);
        byte result = mutableByte.getAndDecrement();
        assertEquals(-3, result);
        assertEquals(-4, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    @DisplayName("should decrement the value by 1 and return the original value for minimum byte value")
    void shouldDecrementAndReturnValueForMinimumByteValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
        byte result = mutableByte.getAndDecrement();
        assertEquals(Byte.MIN_VALUE, result);
        assertEquals(Byte.MIN_VALUE - 1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    @DisplayName("should decrement the value by 1 and return the original value for maximum byte value")
    void shouldDecrementAndReturnValueForMaximumByteValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        byte result = mutableByte.getAndDecrement();
        assertEquals(Byte.MAX_VALUE, result);
        assertEquals(Byte.MAX_VALUE - 1, Optional.ofNullable(mutableByte.getValue()));
    }

//    @Test
//    void testCompareToLessThan() {
//        int result = byte1.compareTo(byte2);
//        assertTrue(result < 0);
//    }

//    @Test
//    void testCompareToGreaterThan() {
//        int result = byte2.compareTo(byte1);
//        assertTrue(result > 0);
//    }
//
//    @Test
//    void testCompareToEqual() {
//        int result = byte1.compareTo(byte3);
//        assertEquals(0, result);
//    }
//
//    @Test
//    void testCompareToEqualValueDifferentObject() {
//        MutableByte byte4 = new MutableByte((byte) 10);
//        int result = byte1.compareTo(byte4);
//        assertEquals(0, result);
//    }

//    @Test
//    void testCompareToNull() {
//        assertThrows(NullPointerException.class, () -> {
//            byte1.compareTo(null);
//        });
//    }

//    @Test
//    void testCompareToMaxValue() {
//        MutableByte byte5 = new MutableByte(Byte.MAX_VALUE);
//        int result = byte1.compareTo(byte5);
//        assertTrue(result < 0);
//    }
//
//    @Test
//    void testCompareToMinValue() {
//        MutableByte byte6 = new MutableByte(Byte.MIN_VALUE);
//        int result = byte1.compareTo(byte6);
//        assertTrue(result > 0);
//    }
//
//    @Test
//    void testCompareToNegativeValue() {
//        MutableByte byte7 = new MutableByte((byte) -5);
//        int result = byte1.compareTo(byte7);
//        assertTrue(result > 0);
//    }
//
//    @Test
//    void testCompareToZeroValue() {
//        MutableByte byte8 = new MutableByte((byte) 0);
//        int result = byte1.compareTo(byte8);
//        assertTrue(result > 0);
//    }


    @Test
    @DisplayName("should increment value by 1 and return previous value")
    void shouldIncrementValueAndReturnPreviousValue() {
        byte result = mutableByte.getAndIncrement();
        assertEquals(0, result);
        assertEquals(1, Optional.ofNullable(mutableByte.getValue()));
    }

    // Test functions
    @Test
    void testEqualsWithEqualObjects() {
        mutableByte = new MutableByte((byte) 5);
        MutableByte other = new MutableByte((byte) 5);

        assertTrue(mutableByte.equals(other));
    }

    @Test
    void testEqualsWithDifferentObjects() {
        mutableByte = new MutableByte((byte) 5);
        MutableByte other = new MutableByte((byte) 10);

        assertFalse(mutableByte.equals(other));
    }

    @Test
    void testEqualsWithNullObject() {
        mutableByte = new MutableByte((byte) 5);

        assertFalse(mutableByte.equals(null));
    }

    @Test
    void testEqualsWithNonMutableByteObject() {
        mutableByte = new MutableByte((byte) 5);
        Object obj = new Object();

        assertFalse(mutableByte.equals(obj));
    }

    @Test
    void testEqualsWithSameMutableByteObject() {
        mutableByte = new MutableByte((byte) 5);

        assertTrue(mutableByte.equals(mutableByte));
    }

//    @Test
//    void testEqualsWithDifferentMutableByteClass() {
//        mutableByte = new MutableByte((byte) 5);
//        MutableByteChild other = new MutableByteChild((byte) 5);
//
//        assertFalse(mutableByte.equals(other));
//    }

    @Test
    void testEqualsWithDifferentValues() {
        mutableByte = new MutableByte((byte) 5);
        MutableByte other = new MutableByte((byte) 10);

        assertFalse(mutableByte.equals(other));
    }

    @Test
    void testEqualsWithEqualValuesDifferentConstructors() {
        MutableByte byte1 = new MutableByte((byte) 5);
        MutableByte byte2 = new MutableByte(5);
        MutableByte byte3 = new MutableByte("5");

        assertTrue(byte1.equals(byte2));
        assertTrue(byte1.equals(byte3));
        assertTrue(byte2.equals(byte3));
    }

//    @Test
//    void testEqualsWithEqualValuesDifferentConstructorsAndTypes() {
//        MutableByte byte1 = new MutableByte((byte) 5);
//        MutableByteChild byte2 = new MutableByteChild(5);
//        MutableByte byte3 = new MutableByte("5");
//
//        assertFalse(byte1.equals(byte2));
//        assertFalse(byte2.equals(byte3));
//        assertFalse(byte3.equals(byte1));
//    }


    @Test
    @DisplayName("should add positive byte value")
    void shouldAddPositiveByteValue() {
        mutableByte.add((byte) 5);
        assertEquals(5, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    @DisplayName("should add negative byte value")
    void shouldAddNegativeByteValue() {
        mutableByte.add((byte) -3);
        assertEquals(-3, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    @DisplayName("should add zero byte value")
    void shouldAddZeroByteValue() {
        mutableByte.add((byte) 0);
        assertEquals(0, Optional.ofNullable(mutableByte.getValue()));
    }


    @Test
    @DisplayName("should add positive number value")
    void shouldAddPositiveNumberValue() {
        mutableByte.add((byte) 5);
        assertEquals(5, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    @DisplayName("should add negative number value")
    void shouldAddNegativeNumberValue() {
        mutableByte.add((byte) -3);
        assertEquals(-3, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    @DisplayName("should add zero number value")
    void shouldAddZeroNumberValue() {
        mutableByte.add((byte) 0);
        assertEquals(0, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testIncrement() {
        assertEquals(0, Optional.ofNullable(mutableByte.getValue()));
        mutableByte.increment();
        assertEquals(1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testIncrementMultipleTimes() {
        assertEquals(0, Optional.ofNullable(mutableByte.getValue()));
        mutableByte.increment();
        mutableByte.increment();
        mutableByte.increment();
        assertEquals(3, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testIncrementEdgeCases() {
        mutableByte = new MutableByte(Byte.MIN_VALUE);
        mutableByte.increment();
        assertEquals(Byte.MIN_VALUE + 1, Optional.ofNullable(mutableByte.getValue()));

        mutableByte = new MutableByte(Byte.MAX_VALUE);
        mutableByte.increment();
        assertEquals(Byte.MIN_VALUE, Optional.ofNullable(mutableByte.getValue()));

        mutableByte = new MutableByte((byte) 0);
        mutableByte.increment();
        assertEquals(1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSetValue() {
        mutableByte.setValue((byte) 10);
        assertEquals(10, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSetValueFromNumber() {
        mutableByte.setValue(NumberUtils.BYTE_ONE);
        assertEquals(1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSetValueFromNullNumber() {
        assertThrows(NullPointerException.class, () -> mutableByte.setValue(null));
    }

    @Test
    void testSetValueFromString() {
        mutableByte.setValue(Byte.parseByte("5"));
        assertEquals(5, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testSetValueFromInvalidString() {
        assertThrows(NumberFormatException.class, () -> mutableByte.setValue(Byte.parseByte("abc")));
    }

    @Test
    void decrementFromZero() {
        mutableByte.decrement();
        assertEquals(-1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void decrementFromPositiveValue() {
        mutableByte = new MutableByte((byte) 5);
        mutableByte.decrement();
        assertEquals(4, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void decrementFromNegativeValue() {
        mutableByte = new MutableByte((byte) -5);
        mutableByte.decrement();
        assertEquals(-6, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void constructorWithByteValue() {
        MutableByte mutableByte = new MutableByte((byte) 10);
        assertEquals(10, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void constructorWithNumberValue() {
        MutableByte mutableByte = new MutableByte(NumberUtils.BYTE_ONE);
        assertEquals(1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void constructorWithStringValue() {
        MutableByte mutableByte = new MutableByte("5");
        assertEquals(5, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void constructorWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> new MutableByte("abc"));
    }

    @Test
    void testGetAndAddByte() {
        assertEquals(0, mutableByte.getAndAdd((byte) 5));
        assertEquals(5, mutableByte.getAndAdd((byte) 2));
        assertEquals(7, mutableByte.getAndAdd((byte) -3));
    }

    @Test
    void testGetAndAddNumber() {
        assertEquals(0, mutableByte.getAndAdd(NumberUtils.BYTE_ONE));
        assertEquals(1, mutableByte.getAndAdd(NumberUtils.BYTE_ZERO));
        assertEquals(1, mutableByte.getAndAdd(NumberUtils.BYTE_MINUS_ONE));
    }

    @Test
    void testGetAndAddNull() {
        assertThrows(NullPointerException.class, () -> mutableByte.getAndAdd((Number) null));
    }

    @Test
    void testGetAndAddOverflow() {
        mutableByte = new MutableByte((byte) 127);
        assertEquals(127, mutableByte.getAndAdd((byte) 1));
        assertEquals(-128, mutableByte.getAndAdd((byte) 1));
    }

    @Test
    void testGetAndAddUnderflow() {
        mutableByte = new MutableByte((byte) -128);
        assertEquals(-128, mutableByte.getAndAdd((byte) -1));
        assertEquals(127, mutableByte.getAndAdd((byte) -1));
    }

    @Test
    void testGetValue() {
        MutableByte mutableByte = new MutableByte((byte) 5);

        Byte value = mutableByte.getValue();

        assertEquals((byte) 5, value);
    }

    @Test
    void testGetValueWithZeroValue() {
        MutableByte mutableByte = new MutableByte((byte) 0);

        Byte value = mutableByte.getValue();

        assertEquals((byte) 0, value);
    }

    @Test
    void testGetValueWithNegativeValue() {
        MutableByte mutableByte = new MutableByte((byte) -5);

        Byte value = mutableByte.getValue();

        assertEquals((byte) -5, value);
    }

    @Test
    void testGetValueWithMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);

        Byte value = mutableByte.getValue();

        assertEquals(Byte.MAX_VALUE, value);
    }

    @Test
    void testGetValueWithMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);

        Byte value = mutableByte.getValue();

        assertEquals(Byte.MIN_VALUE, value);
    }

    @Test
    void testGetValueWithNullValue() {
        MutableByte mutableByte = new MutableByte((byte) 5);

        mutableByte.setValue(null);

        Byte value = mutableByte.getValue();

        assertEquals((byte) 0, value);
    }

    @Test
    void testGetValueWithStringValue() {
        MutableByte mutableByte = new MutableByte("5");

        Byte value = mutableByte.getValue();

        assertEquals((byte) 5, value);
    }

    @Test
    void testGetValueWithStringValueContainingWhitespace() {
        MutableByte mutableByte = new MutableByte(" 5 ");

        Byte value = mutableByte.getValue();

        assertEquals((byte) 5, value);
    }

    @Test
    void testGetValueWithStringValueContainingNonNumericCharacters() {
        assertThrows(NumberFormatException.class, () -> {
            MutableByte mutableByte = new MutableByte("abc");

            Byte value = mutableByte.getValue();
        });
    }

    @Test
    @DisplayName("should return '0' for default initialized MutableByte")
    void shouldReturnZeroForDefaultInitializedMutableByte() {
        MutableByte mutableByte = new MutableByte();
        assertEquals("0", mutableByte.toString());
    }

    @Test
    @DisplayName("should return the same value as the byte value for initialized MutableByte")
    void shouldReturnSameValueAsByteValueForInitializedMutableByte() {
        byte value = 10;
        MutableByte mutableByte = new MutableByte(value);
        assertEquals(String.valueOf(value), mutableByte.toString());
    }

    @Test
    @DisplayName("should return the same value as the byte value for initialized MutableByte with Number")
    void shouldReturnSameValueAsByteValueForInitializedMutableByteWithNumber() {
        byte value = 10;
        MutableByte mutableByte = new MutableByte((Number) value);
        assertEquals(String.valueOf(value), mutableByte.toString());
    }

    @Test
    @DisplayName("should return the same value as the parsed byte value for initialized MutableByte with String")
    void shouldReturnSameValueAsParsedByteValueForInitializedMutableByteWithString() {
        String value = "10";
        MutableByte mutableByte = new MutableByte(value);
        assertEquals(value, mutableByte.toString());
    }


    @Test
    void testDoubleValueWithDefaultConstructor() {
        assertEquals(0.0, mutableByte.doubleValue());
    }

    @Test
    void testDoubleValueWithByteConstructor() {
        MutableByte byteValue = new MutableByte((byte) 5);
        assertEquals(5.0, byteValue.doubleValue());
    }

    @Test
    void testDoubleValueWithNumberConstructor() {
        MutableByte numberValue = new MutableByte((byte) 10);
        assertEquals(10.0, numberValue.doubleValue());
    }

    @Test
    void testDoubleValueWithStringConstructor() {
        MutableByte stringValue = new MutableByte("15");
        assertEquals(15.0, stringValue.doubleValue());
    }

    @Test
    void testDoubleValueWithInvalidStringConstructor() {
        assertThrows(NumberFormatException.class, () -> new MutableByte("abc").doubleValue());
    }

    @Test
    void testDoubleValueWithNegativeValue() {
        MutableByte negativeValue = new MutableByte((byte) -20);
        assertEquals(-20.0, negativeValue.doubleValue());
    }

    @Test
    void testDoubleValueWithMaxValue() {
        MutableByte maxValue = new MutableByte((byte) 127);
        assertEquals(127.0, maxValue.doubleValue());
    }

    @Test
    void testDoubleValueWithMinValue() {
        MutableByte minValue = new MutableByte((byte) -128);
        assertEquals(-128.0, minValue.doubleValue());
    }

    @Test
    void testAddAndGetByte() {
        mutableByte.addAndGet((byte) 5);
        assertEquals(5, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testAddAndGetNumber() {
        mutableByte.addAndGet(NumberUtils.BYTE_ONE);
        assertEquals(1, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testAddAndGetNegativeByte() {
        mutableByte.addAndGet((byte) -3);
        assertEquals(-3, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testAddAndGetZero() {
        mutableByte.addAndGet((byte) 0);
        assertEquals(0, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testAddAndGetMaxValue() {
        mutableByte.addAndGet(Byte.MAX_VALUE);
        assertEquals(Byte.MAX_VALUE, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testAddAndGetMinValue() {
        mutableByte.addAndGet(Byte.MIN_VALUE);
        assertEquals(Byte.MIN_VALUE, Optional.ofNullable(mutableByte.getValue()));
    }

    @Test
    void testAddAndGetByteOverflow() {
        mutableByte.addAndGet((byte) 200);
        assertEquals((byte) 200, Optional.ofNullable(mutableByte.getValue()));
    }

//    @Test
//    void testAddAndGetNumberOverflow() {
//        mutableByte.addAndGet(NumberUtils.BYTE_MAX);
//        assertEquals(NumberUtils.BYTE_MAX, Optional.ofNullable(mutableByte.getValue()));
//    }

}