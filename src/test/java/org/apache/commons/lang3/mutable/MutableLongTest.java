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
import org.junit.jupiter.api.*;

public class MutableLongTest {

    MutableLong mutableLong;

    @Test
    void testIntValue_PositiveValue() {
        mutableLong = new MutableLong(10);
        assertEquals(10, mutableLong.intValue());
    }
    
    @Test
    void testIntValue_NegativeValue() {
        mutableLong = new MutableLong(-10);
        assertEquals(-10, mutableLong.intValue());
    }


    @Test
    void testIntValue_StringValue() {
        mutableLong = new MutableLong("100");
        assertEquals(100, mutableLong.intValue());
    }
    
    @Test
    void testIntValue_StringValueInvalidFormat() {
        assertThrows(NumberFormatException.class, () -> new MutableLong("abc").intValue());
    }

    @Test
    void testToLongWithPositiveValue() {
        mutableLong = new MutableLong(10L);
        assertEquals(10L, mutableLong.toLong());
    }
    
    @Test
    void testToLongWithNegativeValue() {
        mutableLong = new MutableLong(-5L);
        assertEquals(-5L, mutableLong.toLong());
    }
    
    @Test
    void testToLongWithMaxValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableLong.toLong());
    }
    
    @Test
    void testToLongWithMinValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, mutableLong.toLong());
    }
    
    @Test
    void testToLongWithStringValue() {
        mutableLong = new MutableLong("100");
        assertEquals(100L, mutableLong.toLong());
    }
    
    @Test
    void testToLongWithStringValueThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> new MutableLong("abc").toLong());
    }

    @Test
    public void testDecrementAndGet() {
        mutableLong = new MutableLong(0);
        assertEquals(-1, mutableLong.decrementAndGet());
    }
    
    @Test
    public void testDecrementAndGetWithPositiveValue() {
        mutableLong = new MutableLong(10);
        assertEquals(9, mutableLong.decrementAndGet());
    }
    
    @Test
    public void testDecrementAndGetWithNegativeValue() {
        mutableLong = new MutableLong(-1);
        assertEquals(-2, mutableLong.decrementAndGet());
    }
    
    @Test
    public void testDecrementAndGetWithMaxValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE - 1, mutableLong.decrementAndGet());
    }
    
    @Test
    public void testDecrementAndGetWithMinValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE - 1, mutableLong.decrementAndGet());
    }
    @Test
    public void testIncrementAndGet() {
        mutableLong = new MutableLong();
        assertEquals(1, mutableLong.incrementAndGet());
    }
    
    @Test
    public void testIncrementAndGet_withPositiveValue() {
        mutableLong = new MutableLong(5);
        assertEquals(6, mutableLong.incrementAndGet());
    }
    
    @Test
    public void testIncrementAndGet_withNegativeValue() {
        mutableLong = new MutableLong(-5);
        assertEquals(-4, mutableLong.incrementAndGet());
    }
    
    @Test
    public void testIncrementAndGet_withZeroValue() {
        mutableLong = new MutableLong(0);
        assertEquals(1, mutableLong.incrementAndGet());
    }
    
    @Test
    public void testIncrementAndGet_withMaxLongValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MIN_VALUE, mutableLong.incrementAndGet());
    }
    
    @Test
    public void testIncrementAndGet_withMinLongValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE + 1, mutableLong.incrementAndGet());
    }
    
    @Test
    public void testIncrementAndGet_withString() {
        mutableLong = new MutableLong("10");
        assertEquals(11, mutableLong.incrementAndGet());
    }
    
    @Test
    public void testIncrementAndGet_withInvalidString() {
        assertThrows(NumberFormatException.class, () -> new MutableLong("abc").incrementAndGet());
    }
    @Test
    void testHashCodeWithZeroValue() {
        mutableLong = new MutableLong(0);
        int expectedHashCode = 0;
        assertEquals(expectedHashCode, mutableLong.hashCode());
    }
    
    @Test
    void testHashCodeWithPositiveValue() {
        mutableLong = new MutableLong(123456789);
        int expectedHashCode = 123456789;
        assertEquals(expectedHashCode, mutableLong.hashCode());
    }

    @Test
    void testHashCodeWithMaxValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        int expectedHashCode = (int) (Long.MAX_VALUE ^ Long.MAX_VALUE >>> 32);
        assertEquals(expectedHashCode, mutableLong.hashCode());
    }
    
    @Test
    void testHashCodeWithMinValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        int expectedHashCode = (int) (Long.MIN_VALUE ^ Long.MIN_VALUE >>> 32);
        assertEquals(expectedHashCode, mutableLong.hashCode());
    }
    
    @Test
    void testHashCodeWithStringValue() {
        String value = "123456789";
        mutableLong = new MutableLong(value);
        int expectedHashCode = Integer.parseInt(value);
        assertEquals(expectedHashCode, mutableLong.hashCode());
    }
    
    @Test
    void testHashCodeWithInvalidStringValue() {
        String value = "abc";
        assertThrows(NumberFormatException.class, () -> new MutableLong(value));
    }

    @Test
    public void testFloatValueWithZeroValue() {
        mutableLong = new MutableLong(0);
        assertEquals(0.0f, mutableLong.floatValue());
    }
    
    @Test
    public void testFloatValueWithPositiveValue() {
        mutableLong = new MutableLong(10);
        assertEquals(10.0f, mutableLong.floatValue());
    }
    
    @Test
    public void testFloatValueWithNegativeValue() {
        mutableLong = new MutableLong(-10);
        assertEquals(-10.0f, mutableLong.floatValue());
    }
    
    @Test
    public void testFloatValueWithMaxLongValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals((float) Long.MAX_VALUE, mutableLong.floatValue());
    }
    
    @Test
    public void testFloatValueWithMinLongValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals((float) Long.MIN_VALUE, mutableLong.floatValue());
    }
    
    @Test
    public void testFloatValueWithStringValue() {
        mutableLong = new MutableLong("10");
        assertEquals(10.0f, mutableLong.floatValue());
    }
    
    @Test
    public void testFloatValueWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> new MutableLong("abc").floatValue());
    }

    @Test
    @DisplayName("should return the initialized value")
    void shouldReturnInitializedValue() {
        mutableLong = new MutableLong(10L);
        assertEquals(10L, mutableLong.longValue());
    }
    
    @Test
    @DisplayName("should return the value from Number object")
    void shouldReturnValueFromNumber() {
        mutableLong = new MutableLong(10);
        assertEquals(10L, mutableLong.longValue());
    }
    
    @Test
    @DisplayName("should return the parsed value from string")
    void shouldReturnParsedValueFromString() {
        mutableLong = new MutableLong("10");
        assertEquals(10L, mutableLong.longValue());
    }
    @Test
    void testGetAndDecrement() {
        MutableLong mutableLong = new MutableLong(5);
        assertEquals(5, mutableLong.getAndDecrement());
        assertEquals(4, mutableLong.getAndDecrement());
        assertEquals(3, mutableLong.getAndDecrement());
    }
    
    @Test
    void testGetAndDecrementWithZeroValue() {
        MutableLong mutableLong = new MutableLong(0);
        assertEquals(0, mutableLong.getAndDecrement());
        assertEquals(-1, mutableLong.getAndDecrement());
        assertEquals(-2, mutableLong.getAndDecrement());
    }
    
    @Test
    void testGetAndDecrementWithNegativeValue() {
        MutableLong mutableLong = new MutableLong(-5);
        assertEquals(-5, mutableLong.getAndDecrement());
        assertEquals(-6, mutableLong.getAndDecrement());
        assertEquals(-7, mutableLong.getAndDecrement());
    }
    
    @Test
    void testGetAndDecrementWithLargeValue() {
        MutableLong mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableLong.getAndDecrement());
        assertEquals(Long.MAX_VALUE - 1, mutableLong.getAndDecrement());
        assertEquals(Long.MAX_VALUE - 2, mutableLong.getAndDecrement());
    }
    @Test
    void testCompareTo_lessThan() {
        MutableLong long1 = new MutableLong(5);
        MutableLong long2 = new MutableLong(10);
    
        int result = long1.compareTo(long2);
    
        assertTrue(result < 0);
    }
    
    @Test
    void testCompareTo_greaterThan() {
        MutableLong long1 = new MutableLong(10);
        MutableLong long2 = new MutableLong(5);
    
        int result = long1.compareTo(long2);
    
        assertTrue(result > 0);
    }
    
    @Test
    void testCompareTo_equal() {
        MutableLong long1 = new MutableLong(5);
        MutableLong long2 = new MutableLong(5);
    
        int result = long1.compareTo(long2);
    
        assertEquals(0, result);
    }
    
    @Test
    void testCompareTo_edgeCase_minValue() {
        MutableLong long1 = new MutableLong(Long.MIN_VALUE);
        MutableLong long2 = new MutableLong(0);
    
        int result = long1.compareTo(long2);
    
        assertTrue(result < 0);
    }
    
    @Test
    void testCompareTo_edgeCase_maxValue() {
        MutableLong long1 = new MutableLong(Long.MAX_VALUE);
        MutableLong long2 = new MutableLong(0);
    
        int result = long1.compareTo(long2);
    
        assertTrue(result > 0);
    }
    
    @Test
    void testCompareTo_edgeCase_sameValue() {
        MutableLong long1 = new MutableLong(Long.MAX_VALUE);
        MutableLong long2 = new MutableLong(Long.MAX_VALUE);
    
        int result = long1.compareTo(long2);
    
        assertEquals(0, result);
    }
    
    @Test
    void testCompareTo_edgeCase_negativeValue() {
        MutableLong long1 = new MutableLong(-5);
        MutableLong long2 = new MutableLong(10);
    
        int result = long1.compareTo(long2);
    
        assertTrue(result < 0);
    }

    @Test
    void testGetAndIncrementWithInitialValue() {
        MutableLong initialValue = new MutableLong(5);
        assertEquals(5, initialValue.getAndIncrement());
        assertEquals(6, initialValue.getAndIncrement());
    }
    
    @Test
    void testGetAndIncrementWithNumberValue() {
        MutableLong numberValue = new MutableLong(NumberUtils.LONG_ONE);
        assertEquals(1, numberValue.getAndIncrement());
        assertEquals(2, numberValue.getAndIncrement());
    }
    
    @Test
    void testGetAndIncrementWithStringValue() {
        MutableLong stringValue = new MutableLong("10");
        assertEquals(10, stringValue.getAndIncrement());
        assertEquals(11, stringValue.getAndIncrement());
    }
    
    @Test
    void testGetAndIncrementWithNegativeValue() {
        MutableLong negativeValue = new MutableLong(-5);
        assertEquals(-5, negativeValue.getAndIncrement());
        assertEquals(-4, negativeValue.getAndIncrement());
    }
    
    @Test
    void testGetAndIncrementWithZeroValue() {
        MutableLong zeroValue = new MutableLong(0);
        assertEquals(0, zeroValue.getAndIncrement());
        assertEquals(1, zeroValue.getAndIncrement());
    }
    
    @Test
    void testGetAndIncrementWithMaxValue() {
        MutableLong maxValue = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, maxValue.getAndIncrement());
        assertEquals(Long.MIN_VALUE, maxValue.getAndIncrement());
    }
    
    @Test
    void testGetAndIncrementWithMinValue() {
        MutableLong minValue = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, minValue.getAndIncrement());
        assertEquals(Long.MIN_VALUE + 1, minValue.getAndIncrement());
    }

    @Test
    void testAdd_null() {
        assertThrows(NullPointerException.class, () -> mutableLong.add(null));
    }
    @Test
    @DisplayName("Should increment the value by 1")
    void shouldIncrementValueByOne() {
        MutableLong mutableLong = new MutableLong(5);
        mutableLong.increment();
        Assertions.assertEquals(6, mutableLong.getValue());
    }
    
    @Test
    @DisplayName("Should increment the value when initialized with zero")
    void shouldIncrementValueWhenInitializedWithZero() {
        MutableLong mutableLong = new MutableLong();
        mutableLong.increment();
        Assertions.assertEquals(1, mutableLong.getValue());
    }
    
    @Test
    @DisplayName("Should increment the value when initialized with a number")
    void shouldIncrementValueWhenInitializedWithNumber() {
        MutableLong mutableLong = new MutableLong(NumberUtils.LONG_ONE);
        mutableLong.increment();
        Assertions.assertEquals(2, mutableLong.getValue());
    }
    
    @Test
    @DisplayName("Should increment the value when initialized with a string")
    void shouldIncrementValueWhenInitializedWithString() {
        MutableLong mutableLong = new MutableLong("10");
        mutableLong.increment();
        Assertions.assertEquals(11, mutableLong.getValue());
    }
    
    @Test
    @DisplayName("Should increment the value by 1 multiple times")
    void shouldIncrementValueMultipleTimes() {
        MutableLong mutableLong = new MutableLong();
        mutableLong.increment();
        mutableLong.increment();
        mutableLong.increment();
        Assertions.assertEquals(3, mutableLong.getValue());
    }

    @Test
    void testDecrementFromPositiveValue() {
      mutableLong = new MutableLong(5);
      mutableLong.decrement();
      assertEquals(4, mutableLong.getValue());
    }
    
    @Test
    void testDecrementFromNegativeValue() {
      mutableLong = new MutableLong(-5);
      mutableLong.decrement();
      assertEquals(-6, mutableLong.getValue());
    }
    
    @Test
    void testDecrementFromMaxValue() {
      mutableLong = new MutableLong(Long.MAX_VALUE);
      mutableLong.decrement();
      assertEquals(Long.MAX_VALUE - 1, mutableLong.getValue());
    }

    @Test
    void testDecrementMultipleTimes() {
      mutableLong = new MutableLong(10);
      for (int i = 0; i < 5; i++) {
        mutableLong.decrement();
      }
      assertEquals(5, mutableLong.getValue());
    }


    @Test
    void testGetValue() {
        MutableLong mutableLong = new MutableLong(5);
        Assertions.assertEquals(5L, mutableLong.getValue());
    }
    
    @Test
    void testGetValueWithZero() {
        MutableLong mutableLong = new MutableLong(0);
        Assertions.assertEquals(0L, mutableLong.getValue());
    }
    
    @Test
    void testGetValueWithNegativeValue() {
        MutableLong mutableLong = new MutableLong(-10);
        Assertions.assertEquals(-10L, mutableLong.getValue());
    }
    
    @Test
    void testGetValueFromString() {
        MutableLong mutableLong = new MutableLong("15");
        Assertions.assertEquals(15L, mutableLong.getValue());
    }
    
    @Test
    void testGetValueFromInvalidString() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            MutableLong mutableLong = new MutableLong("abc");
            mutableLong.getValue();
        });
    }
    
    @Test
    void testGetValueFromNullNumber() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            MutableLong mutableLong = new MutableLong((Number) null);
            mutableLong.getValue();
        });
    }
    @Test
    public void testToString() {
        MutableLong mutableLong = new MutableLong();
        Assertions.assertEquals("0", mutableLong.toString());
    
        mutableLong = new MutableLong(10);
        Assertions.assertEquals("10", mutableLong.toString());
    
        mutableLong = new MutableLong(10L);
        Assertions.assertEquals("10", mutableLong.toString());
    
        mutableLong = new MutableLong(10.5);
        Assertions.assertEquals("10", mutableLong.toString());
    
        mutableLong = new MutableLong(NumberUtils.LONG_ZERO);
        Assertions.assertEquals("0", mutableLong.toString());
    
        mutableLong = new MutableLong("10");
        Assertions.assertEquals("10", mutableLong.toString());
    
        mutableLong = new MutableLong(String.valueOf(Long.MAX_VALUE));
        Assertions.assertEquals(String.valueOf(Long.MAX_VALUE), mutableLong.toString());
    
        mutableLong = new MutableLong(String.valueOf(Long.MIN_VALUE));
        Assertions.assertEquals(String.valueOf(Long.MIN_VALUE), mutableLong.toString());
    }

    
    @Test
    void testDoubleValueWithValueConstructor() {
        mutableLong = new MutableLong(10);
        assertEquals(10.0, mutableLong.doubleValue());
    }
    
    @Test
    void testDoubleValueWithNumberConstructor() {
        mutableLong = new MutableLong(5L);
        assertEquals(5.0, mutableLong.doubleValue());
    }
    
    @Test
    void testDoubleValueWithStringConstructor() {
        mutableLong = new MutableLong("15");
        assertEquals(15.0, mutableLong.doubleValue());
    }
    
    @Test
    void testDoubleValueWithInvalidStringConstructor() {
        assertThrows(NumberFormatException.class, () -> new MutableLong("abc").doubleValue());
    }
    
    @Test
    void testDoubleValueWithNegativeValue() {
        mutableLong = new MutableLong(-10);
        assertEquals(-10.0, mutableLong.doubleValue());
    }
    
    @Test
    void testDoubleValueWithMaxValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals((double) Long.MAX_VALUE, mutableLong.doubleValue());
    }
    
    @Test
    void testDoubleValueWithMinValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals((double) Long.MIN_VALUE, mutableLong.doubleValue());
    }

    @Test
    @DisplayName("should throw NullPointerException when operand is null")
    void shouldThrowNullPointerExceptionWhenOperandIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> mutableLong.addAndGet(null));
    }

}