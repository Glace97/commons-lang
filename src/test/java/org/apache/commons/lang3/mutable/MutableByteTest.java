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

    @Test
    void testSetValueFromNullNumber() {
        assertThrows(NullPointerException.class, () -> mutableByte.setValue(null));
    }

    @Test
    void testSetValueFromInvalidString() {
        assertThrows(NumberFormatException.class, () -> mutableByte.setValue(Byte.parseByte("abc")));
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
    void testGetValueWithStringValue() {
        MutableByte mutableByte = new MutableByte("5");

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

}