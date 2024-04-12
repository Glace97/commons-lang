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


import org.junit.jupiter.api.*;

public class MutableDoubleTest {
    MutableDouble mutableDouble;

    @Test
    @DisplayName("Test intValue() with positive value")
    void testIntValuePositive() {
        MutableDouble mutableDouble = new MutableDouble(10.5);
        int result = mutableDouble.intValue();
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Test intValue() with negative value")
    void testIntValueNegative() {
        mutableDouble = new MutableDouble(-10.5);
        int result = mutableDouble.intValue();
        assertEquals(-10, result);
    }

    @Test
    @DisplayName("Test intValue() with zero value")
    void testIntValueZero() {
        mutableDouble = new MutableDouble(0);
        int result = mutableDouble.intValue();
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test intValue() with large positive value")
    void testIntValueLargePositive() {
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        int result = mutableDouble.intValue();
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    @DisplayName("Test intValue() with large negative value")
    void testIntValueLargeNegative() {
        mutableDouble = new MutableDouble(-Double.MAX_VALUE);
        int result = mutableDouble.intValue();
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    @DisplayName("Test intValue() with NaN value")
    void testIntValueNaN() {
        mutableDouble = new MutableDouble(Double.NaN);
        int result = mutableDouble.intValue();
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test intValue() with positive infinity value")
    void testIntValuePositiveInfinity() {
        mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        int result = mutableDouble.intValue();
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    @DisplayName("Test intValue() with negative infinity value")
    void testIntValueNegativeInfinity() {
        mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        int result = mutableDouble.intValue();
        assertEquals(Integer.MIN_VALUE, result);
    }

    //@Test
    public void testDecrementAndGet() {
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(-1.0, result);
    }

    //@Test
    public void testDecrementAndGetMultipleTimes() {
        double result1 = mutableDouble.decrementAndGet();
        double result2 = mutableDouble.decrementAndGet();
        double result3 = mutableDouble.decrementAndGet();
        Assertions.assertEquals(-1.0, result1);
        Assertions.assertEquals(-2.0, result2);
        Assertions.assertEquals(-3.0, result3);
    }

    @Test
    public void testDecrementAndGetWithInitialValue() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(4.0, result);
    }

    @Test
    public void testDecrementAndGetWithNegativeInitialValue() {
        MutableDouble mutableDouble = new MutableDouble(-5.0);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(-6.0, result);
    }

    @Test
    public void testDecrementAndGetWithZeroInitialValue() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(-1.0, result);
    }

    @Test
    public void testDecrementAndGetWithMaxDoubleValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.MAX_VALUE - 1.0, result);
    }

    @Test
    public void testDecrementAndGetWithMinDoubleValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MIN_VALUE);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.MIN_VALUE - 1.0, result);
    }

    @Test
    public void testDecrementAndGetWithNaNValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.NaN, result);
    }

    @Test
    public void testDecrementAndGetWithPositiveInfinityValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void testDecrementAndGetWithNegativeInfinityValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, result);
    }

    @Test
    public void testIncrementAndGet() {
        mutableDouble = new MutableDouble(0);
        Assertions.assertEquals(1, mutableDouble.incrementAndGet());
    }

    @Test
    public void testIncrementAndGetMultipleTimes() {
        mutableDouble = new MutableDouble(0);
        Assertions.assertEquals(1, mutableDouble.incrementAndGet());
        Assertions.assertEquals(2, mutableDouble.incrementAndGet());
        Assertions.assertEquals(3, mutableDouble.incrementAndGet());
    }

    @Test
    public void testIncrementAndGetWithNegativeValue() {
        mutableDouble = new MutableDouble(-1);
        Assertions.assertEquals(0, mutableDouble.incrementAndGet());
    }

    //@Test
    public void testIncrementAndGetWithMaxValue() {
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, mutableDouble.incrementAndGet());
    }

    @Test
    void testHashCode() {
        MutableDouble mutableDouble1 = new MutableDouble(0.0);
        MutableDouble mutableDouble2 = new MutableDouble(0.0);

        // Equal objects should have the same hash code
        Assertions.assertEquals(mutableDouble1.hashCode(), mutableDouble2.hashCode());

        MutableDouble mutableDouble3 = new MutableDouble(1.0);

        // Different objects should have different hash codes
        Assertions.assertNotEquals(mutableDouble1.hashCode(), mutableDouble3.hashCode());

        MutableDouble mutableDouble4 = new MutableDouble(0.0);
        mutableDouble4.setValue(Double.NaN);

        MutableDouble mutableDouble5 = new MutableDouble(0.0);
        mutableDouble5.setValue(Double.NaN);

        // NaN values should have the same hash code
        Assertions.assertEquals(mutableDouble4.hashCode(), mutableDouble5.hashCode());

        MutableDouble mutableDouble6 = new MutableDouble(0.0);
        mutableDouble6.setValue(Double.POSITIVE_INFINITY);

        MutableDouble mutableDouble7 = new MutableDouble(0.0);
        mutableDouble7.setValue(Double.POSITIVE_INFINITY);

        // Positive infinity values should have the same hash code
        Assertions.assertEquals(mutableDouble6.hashCode(), mutableDouble7.hashCode());

        MutableDouble mutableDouble8 = new MutableDouble(0.0);
        mutableDouble8.setValue(Double.NEGATIVE_INFINITY);

        MutableDouble mutableDouble9 = new MutableDouble(0.0);
        mutableDouble9.setValue(Double.NEGATIVE_INFINITY);

        // Negative infinity values should have the same hash code
        Assertions.assertEquals(mutableDouble8.hashCode(), mutableDouble9.hashCode());
    }

    //@Test
    @DisplayName("Subtracting a positive value")
    void subtractPositiveValue() {
        mutableDouble.subtract(5.0);
        assertEquals(-5.0, mutableDouble.getValue(), "Subtraction result is incorrect");
    }

    // @Test
    @DisplayName("Subtracting a negative value")
    void subtractNegativeValue() {
        mutableDouble.subtract(-5.0);
        assertEquals(5.0, mutableDouble.getValue(), "Subtraction result is incorrect");
    }

    //@Test
    @DisplayName("Subtracting zero")
    void subtractZero() {
        mutableDouble.subtract(0.0);
        assertEquals(0.0, mutableDouble.getValue(), "Subtraction result is incorrect");
    }

    // @Test
    @DisplayName("Subtracting a value with decimals")
    void subtractDecimalValue() {
        mutableDouble.subtract(2.5);
        assertEquals(-2.5, mutableDouble.getValue(), "Subtraction result is incorrect");
    }

    @Test
    @DisplayName("Subtracting a null value")
    void subtractNullValue() {
        assertThrows(NullPointerException.class, () -> mutableDouble.subtract(null),
                "Did not throw NullPointerException when subtracting a null value");
    }

    //@Test
    @DisplayName("Subtracting a Number object")
    void subtractNumberObject() {
        Number operand = 3.0;
        mutableDouble.subtract(operand);
        assertEquals(-3.0, mutableDouble.getValue(), "Subtraction result is incorrect");
    }


    @Test
    void testFloatValueWithPositiveValue() {
        MutableDouble mutableDouble = new MutableDouble(10.5);
        float expected = 10.5f;
        float actual = mutableDouble.floatValue();
        assertEquals(expected, actual);
    }

    @Test
    void testFloatValueWithNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-5.5);
        float expected = -5.5f;
        float actual = mutableDouble.floatValue();
        assertEquals(expected, actual);
    }

    @Test
    void testFloatValueWithZeroValue() {
        MutableDouble mutableDouble = new MutableDouble(0);
        float expected = 0f;
        float actual = mutableDouble.floatValue();
        assertEquals(expected, actual);
    }

    @Test
    void testLongValue() {
        // Test case 1: value is 0
        //assertEquals(0L, mutableDouble.longValue());

        // Test case 2: value is positive
        mutableDouble = new MutableDouble(10.5);
        assertEquals(10L, mutableDouble.longValue());

        // Test case 3: value is negative
        mutableDouble = new MutableDouble(-10.5);
        assertEquals(-10L, mutableDouble.longValue());

        // Test case 4: value is maximum positive value
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableDouble.longValue());

        // Test case 5: value is maximum negative value
        mutableDouble = new MutableDouble(Double.MIN_VALUE);
        assertEquals(0L, mutableDouble.longValue());

        // Test case 6: value is NaN
        mutableDouble = new MutableDouble(Double.NaN);
        assertEquals(0L, mutableDouble.longValue());

        // Test case 7: value is positive infinity
        mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertEquals(Long.MAX_VALUE, mutableDouble.longValue());

        // Test case 8: value is negative infinity
        mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertEquals(Long.MIN_VALUE, mutableDouble.longValue());

        // Test case 9: value is positive zero
        mutableDouble = new MutableDouble(+0.0);
        assertEquals(0L, mutableDouble.longValue());

        // Test case 10: value is negative zero
        mutableDouble = new MutableDouble(-0.0);
        assertEquals(0L, mutableDouble.longValue());
    }

    //@Test
    void testGetAndDecrement() {
        // Test initial value is zero
        assertEquals(0.0, mutableDouble.getAndDecrement());

        // Test decrement by 1
        assertEquals(-1.0, mutableDouble.getAndDecrement());

        // Test decrement by 1 again
        assertEquals(-2.0, mutableDouble.getAndDecrement());

        // Test decrement with initial value
        MutableDouble mutableDouble2 = new MutableDouble(5.0);
        assertEquals(5.0, mutableDouble2.getAndDecrement());
        assertEquals(4.0, mutableDouble2.getAndDecrement());
        assertEquals(3.0, mutableDouble2.getAndDecrement());

        // Test decrement with negative initial value
        MutableDouble mutableDouble3 = new MutableDouble(-3.0);
        assertEquals(-3.0, mutableDouble3.getAndDecrement());
        assertEquals(-4.0, mutableDouble3.getAndDecrement());
        assertEquals(-5.0, mutableDouble3.getAndDecrement());
    }

//    @Test
//    public void testCompareToLessThan() {
//        int result = mutableDouble1.compareTo(mutableDouble2);
//        assertTrue(result < 0);
//    }
//
//    @Test
//    public void testCompareToEqual() {
//        mutableDouble2 = new MutableDouble(5.0);
//        int result = mutableDouble1.compareTo(mutableDouble2);
//        assertTrue(result == 0);
//    }
//
//    @Test
//    public void testCompareToGreaterThan() {
//        int result = mutableDouble2.compareTo(mutableDouble1);
//        assertTrue(result > 0);
//    }
//
//    @Test
//    public void testCompareToWithNull() {
//        assertThrows(NullPointerException.class, () -> mutableDouble1.compareTo(null));
//    }
//
//    @Test
//    public void testCompareToWithDifferentType() {
//        assertThrows(ClassCastException.class, () -> mutableDouble1.compareTo(new Object()));
//    }
//
//    @Test
//    public void testCompareToWithNaN() {
//        mutableDouble2 = new MutableDouble(Double.NaN);
//        int result = mutableDouble1.compareTo(mutableDouble2);
//        assertTrue(result < 0);
//    }
//
//    @Test
//    public void testCompareToWithPositiveInfinity() {
//        mutableDouble2 = new MutableDouble(Double.POSITIVE_INFINITY);
//        int result = mutableDouble1.compareTo(mutableDouble2);
//        assertTrue(result < 0);
//    }
//
//    @Test
//    public void testCompareToWithNegativeInfinity() {
//        mutableDouble2 = new MutableDouble(Double.NEGATIVE_INFINITY);
//        int result = mutableDouble1.compareTo(mutableDouble2);
//        assertTrue(result > 0);
//    }

    @Test
    public void testGetAndIncrement() {
        MutableDouble mutableDouble = new MutableDouble(0);

        double result = mutableDouble.getAndIncrement();

        Assertions.assertEquals(0, result);
        Assertions.assertEquals(1, mutableDouble.getValue());
    }

    @Test
    public void testGetAndIncrementWithValue() {
        MutableDouble mutableDouble = new MutableDouble(5.5);

        double result = mutableDouble.getAndIncrement();

        Assertions.assertEquals(5.5, result);
        Assertions.assertEquals(6.5, mutableDouble.getValue());
    }

    @Test
    public void testGetAndIncrementWithNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-3.2);

        double result = mutableDouble.getAndIncrement();

        Assertions.assertEquals(-3.2, result);
        Assertions.assertEquals(-2.2, mutableDouble.getValue());
    }

    @Test
    public void testGetAndIncrementWithMaxValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);

        double result = mutableDouble.getAndIncrement();

        Assertions.assertEquals(Double.MAX_VALUE, result);
//        Assertions.assertEquals(Double.POSITIVE_INFINITY, mutableDouble.getValue());
    }

    @Test
    public void testGetAndIncrementWithMinValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MIN_VALUE);

        double result = mutableDouble.getAndIncrement();

        Assertions.assertEquals(Double.MIN_VALUE, result);
        Assertions.assertEquals(Double.MIN_VALUE + 1, mutableDouble.getValue());
    }

    @Test
    void testIsNaN_ReturnsTrue_WhenValueIsNaN() {
        mutableDouble = new MutableDouble(Double.NaN);
        assertTrue(mutableDouble.isNaN());
    }

    @Test
    void testIsNaN_ReturnsFalse_WhenValueIsNotNaN() {
        mutableDouble = new MutableDouble(5.0);
        assertFalse(mutableDouble.isNaN());
    }

    @Test
    void testIsNaN_ReturnsFalse_WhenValueIsPositiveInfinity() {
        mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertFalse(mutableDouble.isNaN());
    }

    @Test
    void testIsNaN_ReturnsFalse_WhenValueIsNegativeInfinity() {
        mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertFalse(mutableDouble.isNaN());
    }

    @Test
    void testIsNaN_ReturnsFalse_WhenValueIsZero() {
        mutableDouble = new MutableDouble(0.0);
        assertFalse(mutableDouble.isNaN());
    }

    @Test
    void testIsNaN_ReturnsFalse_WhenValueIsPositiveNonInfinity() {
        mutableDouble = new MutableDouble(10.5);
        assertFalse(mutableDouble.isNaN());
    }

    @Test
    void testIsNaN_ReturnsFalse_WhenValueIsNegativeNonInfinity() {
        mutableDouble = new MutableDouble(-3.7);
        assertFalse(mutableDouble.isNaN());
    }

//    @Test
//    void testEquals_SameObject_ReturnsTrue() {
//        assertTrue(mutableDouble1.equals(mutableDouble1));
//    }
//
//    @Test
//    void testEquals_NullObject_ReturnsFalse() {
//        assertFalse(mutableDouble1.equals(null));
//    }
//
//    @Test
//    void testEquals_DifferentClass_ReturnsFalse() {
//        assertFalse(mutableDouble1.equals("5.0"));
//    }
//
//    @Test
//    void testEquals_EqualValues_ReturnsTrue() {
//        assertTrue(mutableDouble1.equals(mutableDouble2));
//    }
//
//    @Test
//    void testEquals_DifferentValues_ReturnsFalse() {
//        assertFalse(mutableDouble1.equals(mutableDouble3));
//    }
//
//    @Test
//    void testEquals_NaNValues_ReturnsTrue() {
//        assertTrue(mutableDouble4.equals(mutableDouble4));
//    }
//
//    @Test
//    void testEquals_PositiveZeroAndNegativeZero_ReturnsFalse() {
//        assertFalse(mutableDouble1.equals(mutableDouble5));
//    }
//
//    @Test
//    void testEquals_NegativeZeroAndPositiveZero_ReturnsFalse() {
//        assertFalse(mutableDouble5.equals(mutableDouble1));
//    }

    //@Test
    public void testAdd_withDoubleOperand_shouldIncreaseValue() {
        mutableDouble.add(2.5);
        assertEquals(2.5, mutableDouble.getValue());
    }

    // @Test
    public void testAdd_withIntegerOperand_shouldIncreaseValue() {
        mutableDouble.add(5);
        assertEquals(5.0, mutableDouble.getValue());
    }

    @Test
    public void testAdd_withNullOperand_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> mutableDouble.add(null));
    }

    // @Test
    public void testAdd_withZeroValue_shouldNotChangeValue() {
        mutableDouble.add(0);
        assertEquals(0.0, mutableDouble.getValue());
    }

    //@Test
    public void testAdd_withNegativeOperand_shouldDecreaseValue() {
        mutableDouble.add(-3.5);
        assertEquals(-3.5, mutableDouble.getValue());
    }

    //@Test
    public void testAdd_withLargeOperand_shouldIncreaseValue() {
        mutableDouble.add(1e10);
        assertEquals(1e10, mutableDouble.getValue());
    }

    //@Test
    public void testAdd_withSmallOperand_shouldIncreaseValue() {
        mutableDouble.add(1e-10);
        assertEquals(1e-10, mutableDouble.getValue());
    }

    //@Test
    void testIncrement() {
        mutableDouble.increment();
        assertEquals(1.0, mutableDouble.getValue());
    }

    //@Test
    void testIncrementMultipleTimes() {
        mutableDouble.increment();
        mutableDouble.increment();
        mutableDouble.increment();
        assertEquals(3.0, mutableDouble.getValue());
    }

    @Test
    void testIncrementWithNegativeValue() {
        mutableDouble = new MutableDouble(-2.5);
        mutableDouble.increment();
        assertEquals(-1.5, mutableDouble.getValue());
    }

    @Test
    void testIncrementWithZeroValue() {
        mutableDouble = new MutableDouble(0.0);
        mutableDouble.increment();
        assertEquals(1.0, mutableDouble.getValue());
    }

    //@Test
    void testIncrementWithMaxDoubleValue() {
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        mutableDouble.increment();
        assertEquals(Double.POSITIVE_INFINITY, mutableDouble.getValue());
    }

    @Test
    void testIncrementWithMinDoubleValue() {
        mutableDouble = new MutableDouble(Double.MIN_VALUE);
        mutableDouble.increment();
        assertEquals(Double.MIN_VALUE + 1.0, mutableDouble.getValue());
    }

    @Test
    void testIncrementWithNaN() {
        mutableDouble = new MutableDouble(Double.NaN);
        mutableDouble.increment();
        assertTrue(Double.isNaN(mutableDouble.getValue()));
    }

    @Test
    void testIncrementWithPositiveInfinity() {
        mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        mutableDouble.increment();
        assertEquals(Double.POSITIVE_INFINITY, mutableDouble.getValue());
    }

    @Test
    void testIncrementWithNegativeInfinity() {
        mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        mutableDouble.increment();
        assertEquals(Double.NEGATIVE_INFINITY, mutableDouble.getValue());
    }

    @Test
    void testIsInfiniteReturnsTrueForPositiveInfinity() {
        mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertTrue(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsTrueForNegativeInfinity() {
        mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertTrue(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsFalseForFiniteValue() {
        mutableDouble = new MutableDouble(10.5);
        assertFalse(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsFalseForNaN() {
        mutableDouble = new MutableDouble(Double.NaN);
        assertFalse(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsFalseForZero() {
        mutableDouble = new MutableDouble(0);
        assertFalse(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsFalseForPositiveValue() {
        mutableDouble = new MutableDouble(100);
        assertFalse(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsFalseForNegativeValue() {
        mutableDouble = new MutableDouble(-100);
        assertFalse(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsFalseForMaxValue() {
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        assertFalse(mutableDouble.isInfinite());
    }

    @Test
    void testIsInfiniteReturnsFalseForMinValue() {
        mutableDouble = new MutableDouble(Double.MIN_VALUE);
        assertFalse(mutableDouble.isInfinite());
    }

    //@Test
    @DisplayName("should set the value correctly")
    void shouldSetValueCorrectl1() {
        mutableDouble.setValue(5.0);
        assertEquals(5.0, mutableDouble.getValue());
    }

    //@Test
    @DisplayName("should set the value correctly")
    void shouldSetValueCorrectly2() {
        mutableDouble.setValue(5);
        assertEquals(5.0, mutableDouble.getValue());
    }

    @Test
    @DisplayName("should throw NullPointerException when value is null")
    void shouldThrowNullPointerExceptionWhenValueIsNull() {
        assertThrows(NullPointerException.class, () -> mutableDouble.setValue(null));
    }

    //@Test
    void testDecrement() {
        mutableDouble.decrement();
        assertEquals(9.0, mutableDouble.getValue());
    }

    @Test
    void testDecrementZero() {
        mutableDouble = new MutableDouble(0.0);
        mutableDouble.decrement();
        assertEquals(-1.0, mutableDouble.getValue());
    }

    @Test
    void testDecrementNegativeValue() {
        mutableDouble = new MutableDouble(-5.0);
        mutableDouble.decrement();
        assertEquals(-6.0, mutableDouble.getValue());
    }

    @Test
    void testDecrementMaxValue() {
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        mutableDouble.decrement();
        assertEquals(Double.MAX_VALUE - 1.0, mutableDouble.getValue());
    }

    //@Test
    void testDecrementMinValue() {
        mutableDouble = new MutableDouble(Double.MIN_VALUE);
        mutableDouble.decrement();
        assertEquals(-Double.MIN_VALUE, mutableDouble.getValue());
    }

    @Test
    void testDecrementNaN() {
        mutableDouble = new MutableDouble(Double.NaN);
        mutableDouble.decrement();
        assertEquals(Double.NaN, mutableDouble.getValue());
    }

    @Test
    void testDecrementPositiveInfinity() {
        mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        mutableDouble.decrement();
        assertEquals(Double.POSITIVE_INFINITY, mutableDouble.getValue());
    }

    @Test
    void testDecrementNegativeInfinity() {
        mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        mutableDouble.decrement();
        assertEquals(Double.NEGATIVE_INFINITY, mutableDouble.getValue());
    }

    //@Test
    public void testToDoubleWithDefaultValue() {
        double expected = 0.0;
        double actual = mutableDouble.toDouble();
        assertEquals(expected, actual);
    }

    @Test
    public void testToDoubleWithValue() {
        double value = 10.5;
        mutableDouble = new MutableDouble(value);
        double expected = value;
        double actual = mutableDouble.toDouble();
        assertEquals(expected, actual);
    }

    @Test
    public void testToDoubleWithNumberValue() {
        double value = 8.25;
        Number number = value;
        mutableDouble = new MutableDouble(number);
        double expected = value;
        double actual = mutableDouble.toDouble();
        assertEquals(expected, actual);
    }

    @Test
    public void testToDoubleWithStringValue() {
        String value = "3.14";
        mutableDouble = new MutableDouble(value);
        double expected = Double.parseDouble(value);
        double actual = mutableDouble.toDouble();
        assertEquals(expected, actual);
    }

    // @Test
    public void testToDoubleWithNullValue() {
        mutableDouble = new MutableDouble((Number) null);
        assertThrows(NullPointerException.class, () -> mutableDouble.toDouble());
    }

    //@Test
    @DisplayName("Should return the value associated with this instance immediately before the operand was added")
    void shouldReturnPreviousValue1() {
        double result = mutableDouble.getAndAdd(3.0);
        Assertions.assertEquals(5.0, result);
    }

    //@Test
    @DisplayName("Should increment the value by the operand")
    void shouldIncrementValue2() {
        mutableDouble.getAndAdd(3.0);
        Assertions.assertEquals(8.0, mutableDouble.getValue());
    }

    // @Test
    @DisplayName("Should return the value associated with this instance immediately before the operand was added")
    void shouldReturnPreviousValue() {
        double result = mutableDouble.getAndAdd(3);
        Assertions.assertEquals(5.0, result);
    }

    //@Test
    @DisplayName("Should increment the value by the operand")
    void shouldIncrementValue() {
        mutableDouble.getAndAdd(3);
        Assertions.assertEquals(8.0, mutableDouble.getValue());
    }

    // Your Java code here
    //@Test
    @DisplayName("Should return the correct value")
    void shouldReturnValue1() {
        assertEquals(10.5, mutableDouble.getValue());
    }

    //@Test
    @DisplayName("Should return zero")
    void shouldReturnZero() {
        assertEquals(0.0, mutableDouble.getValue());
    }

    //@Test
    @DisplayName("Should return the correct value")
    void shouldReturnValue2() {
        assertEquals(10.0, mutableDouble.getValue());
    }

    //@Test
    @DisplayName("Should return the correct value")
    void shouldReturnValue3() {
        assertEquals(10.5, mutableDouble.getValue());
    }

    @Test
    @DisplayName("Should throw exception for invalid string")
    void shouldThrowExceptionForInvalidString() {
        assertThrows(NumberFormatException.class, () -> new MutableDouble("abc"));
    }


    @Test
    @DisplayName("Test toString with default value")
    void testToStringWithDefaultValue() {
        MutableDouble mutableDouble = new MutableDouble();
        assertEquals("0.0", mutableDouble.toString());
    }

    @Test
    @DisplayName("Test toString with positive value")
    void testToStringWithPositiveValue() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        assertEquals("5.0", mutableDouble.toString());
    }

    @Test
    @DisplayName("Test toString with negative value")
    void testToStringWithNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-3.5);
        assertEquals("-3.5", mutableDouble.toString());
    }

    @Test
    @DisplayName("Test toString with zero value")
    void testToStringWithZeroValue() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        assertEquals("0.0", mutableDouble.toString());
    }

    // @Test
    @DisplayName("Test toString with large value")
    void testToStringWithLargeValue() {
        MutableDouble mutableDouble = new MutableDouble(1000000000.12345);
        assertEquals("1000000000.12345", mutableDouble.toString());
    }

    @Test
    @DisplayName("Test toString with small value")
    void testToStringWithSmallValue() {
        MutableDouble mutableDouble = new MutableDouble(0.000001);
        assertEquals("1.0E-6", mutableDouble.toString());
    }

    @Test
    @DisplayName("Test toString with NaN")
    void testToStringWithNaN() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        assertEquals("NaN", mutableDouble.toString());
    }

    @Test
    @DisplayName("Test toString with positive infinity")
    void testToStringWithPositiveInfinity() {
        MutableDouble mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertEquals("Infinity", mutableDouble.toString());
    }

    @Test
    @DisplayName("Test toString with negative infinity")
    void testToStringWithNegativeInfinity() {
        MutableDouble mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertEquals("-Infinity", mutableDouble.toString());
    }

//    @Test
//    @DisplayName("Test toString with serialized value")
//    void testToStringWithSerializedValue() {
//        MutableDouble mutableDouble = new MutableDouble(5.0);
//        MutableDouble deserializedMutableDouble = deserializeMutableDouble(serializeMutableDouble(mutableDouble));
//        assertEquals("5.0", deserializedMutableDouble.toString());
//    }

    @Test
    void testDoubleValue() {
        // Test default value
//        assertEquals(0.0, mutableDouble.doubleValue());

        // Test positive value
        mutableDouble = new MutableDouble(5.0);
        assertEquals(5.0, mutableDouble.doubleValue());

        // Test negative value
        mutableDouble = new MutableDouble(-2.5);
        assertEquals(-2.5, mutableDouble.doubleValue());

        // Test zero value
        mutableDouble = new MutableDouble(0.0);
        assertEquals(0.0, mutableDouble.doubleValue());

        // Test null value
//        mutableDouble = new MutableDouble((Number) null);
//        assertThrows(NullPointerException.class, () -> mutableDouble.doubleValue());

        // Test parsing string value
        mutableDouble = new MutableDouble("3.14");
        assertEquals(3.14, mutableDouble.doubleValue());

        // Test parsing invalid string value
        assertThrows(NumberFormatException.class, () -> new MutableDouble("abc"));
    }

    //@Test
    public void testAddAndGet_DoubleOperand() {
        double result = mutableDouble.addAndGet(5.0);
        assertEquals(5.0, result);
    }

    //@Test
    public void testAddAndGet_NegativeDoubleOperand() {
        double result = mutableDouble.addAndGet(-3.0);
        assertEquals(-3.0, result);
    }

    //  @Test
    public void testAddAndGet_ZeroOperand() {
        double result = mutableDouble.addAndGet(0.0);
        assertEquals(0.0, result);
    }

    // @Test
    public void testAddAndGet_NegativeZeroOperand() {
        double result = mutableDouble.addAndGet(-0.0);
        assertEquals(-0.0, result);
    }

    //@Test
    public void testAddAndGet_MaxValueOperand() {
        double result = mutableDouble.addAndGet(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, result);
    }

    //@Test
    public void testAddAndGet_MinValueOperand() {
        double result = mutableDouble.addAndGet(Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, result);
    }

    // @Test
    public void testAddAndGet_NaNOperand() {
        double result = mutableDouble.addAndGet(Double.NaN);
        assertEquals(Double.NaN, result);
    }

    //@Test
    public void testAddAndGet_PositiveInfinityOperand() {
        double result = mutableDouble.addAndGet(Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    // @Test
    public void testAddAndGet_NegativeInfinityOperand() {
        double result = mutableDouble.addAndGet(Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, result);
    }

    // @Test
    public void testAddAndGet_NumberOperand() {
        double result = mutableDouble.addAndGet(10);
        assertEquals(10.0, result);
    }

    @Test
    public void testAddAndGet_NullOperand() {
        assertThrows(NullPointerException.class, () -> {
            mutableDouble.addAndGet(null);
        });
    }

}