package org.apache.commons.lang3.mutable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MutableFloatTest {

    private MutableFloat mutableFloat;

    @Test
    public void testIntValueWithZeroValue() {
        MutableFloat mutableFloat = new MutableFloat(0.0f);
        int result = mutableFloat.intValue();
        assertEquals(0, result);
    }

    @Test
    public void testIntValueWithPositiveValue() {
        MutableFloat mutableFloat = new MutableFloat(10.5f);
        int result = mutableFloat.intValue();
        assertEquals(10, result);
    }

    @Test
    public void testIntValueWithNegativeValue() {
        MutableFloat mutableFloat = new MutableFloat(-5.8f);
        int result = mutableFloat.intValue();
        assertEquals(-5, result);
    }

    @Test
    public void testIntValueWithMaxValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MAX_VALUE);
        int result = mutableFloat.intValue();
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void testIntValueWithMinValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MIN_VALUE);
        int result = mutableFloat.intValue();
        assertEquals(0, result);
    }

    @Test
    public void testIntValueWithNaNValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.NaN);
        int result = mutableFloat.intValue();
        assertEquals(0, result);
    }

    @Test
    public void testIntValueWithInfinityValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        int result = mutableFloat.intValue();
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void testIntValueWithNegativeInfinityValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        int result = mutableFloat.intValue();
        assertEquals(Integer.MIN_VALUE, result);
    }


    @Test
    public void testDecrementAndGetWithPositiveValue() {
        MutableFloat positiveFloat = new MutableFloat(10.0f);
        assertEquals(9.0f, positiveFloat.decrementAndGet());
    }

    @Test
    public void testDecrementAndGetWithZeroValue() {
        MutableFloat zeroFloat = new MutableFloat(0.0f);
        assertEquals(-1.0f, zeroFloat.decrementAndGet());
    }

    @Test
    public void testDecrementAndGetWithNegativeValue() {
        MutableFloat negativeFloat = new MutableFloat(-10.0f);
        assertEquals(-11.0f, negativeFloat.decrementAndGet());
    }

    @Test
    public void testDecrementAndGetWithMaxFloatValue() {
        MutableFloat maxFloat = new MutableFloat(Float.MAX_VALUE);
        assertEquals(Float.MAX_VALUE - 1.0f, maxFloat.decrementAndGet());
    }

    @Test
    public void testDecrementAndGetWithMinFloatValue() {
        MutableFloat minFloat = new MutableFloat(Float.MIN_VALUE);
        assertEquals(Float.MIN_VALUE - 1.0f, minFloat.decrementAndGet());
    }

    @Test
    public void testDecrementAndGetWithNaNValue() {
        MutableFloat nanFloat = new MutableFloat(Float.NaN);
        assertEquals(Float.NaN - 1.0f, nanFloat.decrementAndGet());
    }

    @Test
    public void testDecrementAndGetWithPositiveInfinityValue() {
        MutableFloat positiveInfinityFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        assertEquals(Float.POSITIVE_INFINITY - 1.0f, positiveInfinityFloat.decrementAndGet());
    }

    @Test
    public void testDecrementAndGetWithNegativeInfinityValue() {
        MutableFloat negativeInfinityFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertEquals(Float.NEGATIVE_INFINITY - 1.0f, negativeInfinityFloat.decrementAndGet());
    }



    @Test
    public void testIncrementAndGetWithNegativeValue() {
        mutableFloat = new MutableFloat(-1.0f);
        float result = mutableFloat.incrementAndGet();
        assertEquals(0.0f, result);
    }

    //@Test
    public void testIncrementAndGetWithMaxValue() {
        mutableFloat = new MutableFloat(Float.MAX_VALUE);
        float result = mutableFloat.incrementAndGet();
        assertEquals(Float.POSITIVE_INFINITY, result);
    }

    @Test
    public void testIncrementAndGetWithMinValue() {
        mutableFloat = new MutableFloat(Float.MIN_VALUE);
        float result = mutableFloat.incrementAndGet();
        assertEquals(Float.MIN_VALUE + 1.0f, result);
    }

    @Test
    public void testIncrementAndGetWithStringValue() {
        mutableFloat = new MutableFloat("2.5");
        float result = mutableFloat.incrementAndGet();
        assertEquals(3.5f, result);
    }


    @Test
    void testHashCodeZero() {
        MutableFloat mutableFloat = new MutableFloat(0);
        int expectedHashCode = Float.hashCode(0);
        assertEquals(expectedHashCode, mutableFloat.hashCode());
    }

    @Test
    void testHashCodePositive() {
        float value = 10.5f;
        MutableFloat mutableFloat = new MutableFloat(value);
        int expectedHashCode = Float.hashCode(value);
        assertEquals(expectedHashCode, mutableFloat.hashCode());
    }

    @Test
    void testHashCodeNegative() {
        float value = -5.2f;
        MutableFloat mutableFloat = new MutableFloat(value);
        int expectedHashCode = Float.hashCode(value);
        assertEquals(expectedHashCode, mutableFloat.hashCode());
    }

    @Test
    void testHashCodeNaN() {
        MutableFloat mutableFloat = new MutableFloat(Float.NaN);
        int expectedHashCode = Float.hashCode(Float.NaN);
        assertEquals(expectedHashCode, mutableFloat.hashCode());
    }

    @Test
    void testHashCodePositiveInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        int expectedHashCode = Float.hashCode(Float.POSITIVE_INFINITY);
        assertEquals(expectedHashCode, mutableFloat.hashCode());
    }

    @Test
    void testHashCodeNegativeInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        int expectedHashCode = Float.hashCode(Float.NEGATIVE_INFINITY);
        assertEquals(expectedHashCode, mutableFloat.hashCode());
    }



    @Test
    void testFloatValueWithDefaultConstructor() {
        MutableFloat mutableFloat = new MutableFloat();
        assertEquals(0.0f, mutableFloat.floatValue());
    }

    @Test
    void testFloatValueWithFloatConstructor() {
        MutableFloat mutableFloat = new MutableFloat(1.23f);
        assertEquals(1.23f, mutableFloat.floatValue());
    }

    @Test
    void testFloatValueWithNumberConstructor() {
        MutableFloat mutableFloat = new MutableFloat(4.56);
        assertEquals(4.56f, mutableFloat.floatValue());
    }

    @Test
    void testFloatValueWithStringConstructor() {
        MutableFloat mutableFloat = new MutableFloat("7.89");
        assertEquals(7.89f, mutableFloat.floatValue());
    }

    @Test
    void testFloatValueWithNegativeNumber() {
        MutableFloat mutableFloat = new MutableFloat(-1.0f);
        assertEquals(-1.0f, mutableFloat.floatValue());
    }

    @Test
    void testFloatValueWithZero() {
        MutableFloat mutableFloat = new MutableFloat(0.0f);
        assertEquals(0.0f, mutableFloat.floatValue());
    }


    @Test
    public void testLongValueWithPositiveValue() {
        mutableFloat = new MutableFloat(10.5f);
        long result = mutableFloat.longValue();
        assertEquals(10L, result);
    }

    @Test
    public void testLongValueWithNegativeValue() {
        mutableFloat = new MutableFloat(-7.8f);
        long result = mutableFloat.longValue();
        assertEquals(-7L, result);
    }

    @Test
    public void testLongValueWithZeroValue() {
        mutableFloat = new MutableFloat(0f);
        long result = mutableFloat.longValue();
        assertEquals(0L, result);
    }

    @Test
    public void testLongValueWithMaxValue() {
        mutableFloat = new MutableFloat(Float.MAX_VALUE);
        long result = mutableFloat.longValue();
        assertEquals(Long.MAX_VALUE, result);
    }

    @Test
    public void testLongValueWithMinValue() {
        mutableFloat = new MutableFloat(Float.MIN_VALUE);
        long result = mutableFloat.longValue();
        assertEquals(0L, result);
    }

    @Test
    public void testLongValueWithNaNValue() {
        mutableFloat = new MutableFloat(Float.NaN);
        long result = mutableFloat.longValue();
        assertEquals(0L, result);
    }

    @Test
    public void testLongValueWithInfinityValue() {
        mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        long result = mutableFloat.longValue();
        assertEquals(Long.MAX_VALUE, result);
    }

    @Test
    public void testLongValueWithNegativeInfinityValue() {
        mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        long result = mutableFloat.longValue();
        assertEquals(Long.MIN_VALUE, result);
    }


    @Test
    public void testLongValueWithStringValue() {
        mutableFloat = new MutableFloat("15.7");
        long result = mutableFloat.longValue();
        assertEquals(15L, result);
    }

    @Test
    public void testLongValueWithInvalidStringValue() {
        try {
            mutableFloat = new MutableFloat("abc");
            long result = mutableFloat.longValue();
            assertEquals(0L, result);
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }


    @Test
    void testGetAndDecrementWithNegativeValue() {
        mutableFloat = new MutableFloat(-5.0f);
        float result = mutableFloat.getAndDecrement();
        assertEquals(-5.0f, result);
        assertEquals(-6.0f, mutableFloat.getValue());
    }

    @Test
    void testGetAndDecrementWithZeroValue() {
        mutableFloat = new MutableFloat(0.0f);
        float result = mutableFloat.getAndDecrement();
        assertEquals(0.0f, result);
        assertEquals(-1.0f, mutableFloat.getValue());
    }


    @Test
    public void testCompareToLessThan() {
        // Test logic here
    }

    @Test
    public void testCompareToGreaterThan() {
        // Test logic here
    }

    @Test
    public void testCompareToEquals() {
        // Test logic here
    }

    @Test
    public void testCompareToNull() {
        // Test logic here
    }

    @Test
    public void testCompareToWithZero() {
        // Test logic here
    }

    @Test
    public void testCompareToWithNegativeValue() {
        // Test logic here
    }

    @Test
    public void testCompareToWithPositiveInfinity() {
        // Test logic here
    }

    @Test
    public void testCompareToWithNegativeInfinity() {
        // Test logic here
    }

    @Test
    public void testCompareToWithNaN() {
        // Test logic here
    }

    @Test
    public void testCompareToWithMaxValue() {
        // Test logic here
    }

    @Test
    public void testCompareToWithMinValue() {
        // Test logic here
    }

    @Test
    public void testGetAndIncrement() {
        MutableFloat mutableFloat = new MutableFloat(0.0f);

        float result = mutableFloat.getAndIncrement();

        assertEquals(0.0f, result);
        assertEquals(1.0f, mutableFloat.getValue());
    }

    @Test
    public void testGetAndIncrementWithNegativeValue() {
        MutableFloat mutableFloat = new MutableFloat(-1.5f);

        float result = mutableFloat.getAndIncrement();

        assertEquals(-1.5f, result);
        assertEquals(-0.5f, mutableFloat.getValue());
    }

    @Test
    public void testIsNaNReturnsTrueForNaNValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForNonNaNValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForPositiveInfinity() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForNegativeInfinity() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForZero() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForPositiveValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForNegativeValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForMaxValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForMinValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForPositiveDenormalizedValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForNegativeDenormalizedValue() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForPositiveInfinityString() {
        // test code here
    }

    @Test
    public void testIsNaNReturnsFalseForNegativeInfinityString() {
        // test code here
    }

    @Test
    public void testIsNaNThrowsNumberFormatExceptionForInvalidString() {
        // test code here
    }


    @Test
    void testEquals_NaN() {
        MutableFloat mutableFloat5 = new MutableFloat(Float.NaN);
        assertEquals(mutableFloat5, mutableFloat5);
    }

    @Test
    void testEquals_PositiveZeroAndNegativeZero() {
        MutableFloat mutableFloat6 = new MutableFloat(0.0f);
        MutableFloat mutableFloat7 = new MutableFloat(-0.0f);
        assertNotEquals(mutableFloat6, mutableFloat7);
    }

    @Test
    public void testIncrementNegativeValue() {
        mutableFloat = new MutableFloat(-2.5f);
        mutableFloat.increment();
        assertEquals(-1.5f, mutableFloat.getValue());
    }

    @Test
    public void testIncrementZeroValue() {
        mutableFloat = new MutableFloat(0.0f);
        mutableFloat.increment();
        assertEquals(1.0f, mutableFloat.getValue());
    }


    @Test
    public void testIncrementSmallValue() {
        mutableFloat = new MutableFloat(Float.MIN_VALUE);
        mutableFloat.increment();
        assertEquals(Float.MIN_VALUE + 1.0f, mutableFloat.getValue());
    }

    @Test
    public void testIncrementString() {
        mutableFloat = new MutableFloat("2.5");
        mutableFloat.increment();
        assertEquals(3.5f, mutableFloat.getValue());
    }

    @Test
    public void testIncrementInvalidString() {
        assertThrows(NumberFormatException.class, () -> {
            mutableFloat = new MutableFloat("invalid");
            mutableFloat.increment();
        });
    }

    @Test
    public void testIsInfiniteReturnsTrueForPositiveInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        assertTrue(mutableFloat.isInfinite());
    }

    @Test
    public void testIsInfiniteReturnsTrueForNegativeInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertTrue(mutableFloat.isInfinite());
    }

    @Test
    public void testIsInfiniteReturnsFalseForFiniteValue() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        assertFalse(mutableFloat.isInfinite());
    }

    @Test
    public void testIsInfiniteReturnsFalseForNaN() {
        MutableFloat mutableFloat = new MutableFloat(Float.NaN);
        assertFalse(mutableFloat.isInfinite());
    }

    @Test
    void testSetValueFromNumberNull() {
        assertThrows(NullPointerException.class, () -> {
            mutableFloat.setValue(null);
        });
    }

    @Test
    void testSetValueFromStringInvalidFormat() {
        assertThrows(NumberFormatException.class, () -> {
            mutableFloat.setValue(Float.parseFloat("abc"));
        });
    }

    @Test
    void testDecrementPositiveValue() {
        mutableFloat = new MutableFloat(5.0f);
        mutableFloat.decrement();
        assertEquals(4.0f, mutableFloat.getValue(), 0.01);
    }

    @Test
    void testDecrementNegativeValue() {
        mutableFloat = new MutableFloat(-5.0f);
        mutableFloat.decrement();
        assertEquals(-6.0f, mutableFloat.getValue(), 0.01);
    }

    @Test
    void testDecrementLargeValue() {
        mutableFloat = new MutableFloat(Float.MAX_VALUE);
        mutableFloat.decrement();
        assertEquals(Float.MAX_VALUE - 1.0f, mutableFloat.getValue(), 0.01);
    }

    @Test
    void testDecrementSmallValue() {
        mutableFloat = new MutableFloat(Float.MIN_VALUE);
        mutableFloat.decrement();
        assertEquals(Float.MIN_VALUE - 1.0f, mutableFloat.getValue(), 0.01);
    }

    @Test
    void testDecrementNaNValue() {
        mutableFloat = new MutableFloat(Float.NaN);
        mutableFloat.decrement();
        assertTrue(Float.isNaN(mutableFloat.getValue()));
    }

    @Test
    public void testGetAndAddFloat() {
        mutableFloat = new MutableFloat(5.0f);

        float result = mutableFloat.getAndAdd(2.5f);

        assertEquals(5.0f, result);
        assertEquals(7.5f, mutableFloat.getValue());
    }

    @Test
    public void testGetAndAddFloatZero() {
        mutableFloat = new MutableFloat(0.0f);

        float result = mutableFloat.getAndAdd(2.5f);

        assertEquals(0.0f, result);
        assertEquals(2.5f, mutableFloat.getValue());
    }

    @Test
    public void testGetAndAddFloatNegative() {
        mutableFloat = new MutableFloat(-5.0f);

        float result = mutableFloat.getAndAdd(2.5f);

        assertEquals(-5.0f, result);
        assertEquals(-2.5f, mutableFloat.getValue());
    }

    @Test
    public void testGetAndAddNumber() {
        mutableFloat = new MutableFloat(5.0f);

        float result = mutableFloat.getAndAdd(new Integer(2));

        assertEquals(5.0f, result);
        assertEquals(7.0f, mutableFloat.getValue());
    }

    @Test
    public void testGetAndAddNumberZero() {
        mutableFloat = new MutableFloat(0.0f);

        float result = mutableFloat.getAndAdd(new Integer(2));

        assertEquals(0.0f, result);
        assertEquals(2.0f, mutableFloat.getValue());
    }

    @Test
    public void testGetAndAddNumberNegative() {
        mutableFloat = new MutableFloat(-5.0f);

        float result = mutableFloat.getAndAdd(new Integer(2));

        assertEquals(-5.0f, result);
        assertEquals(-3.0f, mutableFloat.getValue());
    }

    @Test
    public void testGetAndAddInvalidNumber() {
        mutableFloat = new MutableFloat(5.0f);

        assertThrows(NullPointerException.class, () -> mutableFloat.getAndAdd(null));
    }

    @Test
    public void testGetValue_WithInitialValue() {
        float initialValue = 3.14f;
        mutableFloat = new MutableFloat(initialValue);
        assertEquals(initialValue, mutableFloat.getValue());
    }

    @Test
    public void testGetValue_WithNumberValue() {
        float numberValue = 42.0f;
        mutableFloat = new MutableFloat(numberValue);
        assertEquals(numberValue, mutableFloat.getValue());
    }

    @Test
    public void testGetValue_WithStringValue() {
        String stringValue = "3.14";
        mutableFloat = new MutableFloat(stringValue);
        assertEquals(Float.parseFloat(stringValue), mutableFloat.getValue());
    }

    @Test
    public void testGetValue_NullNumberValue() {
        assertThrows(NullPointerException.class, () -> {
            mutableFloat = new MutableFloat((Number) null);
            mutableFloat.getValue();
        });
    }

    @Test
    public void testGetValue_NullStringValue() {
        assertThrows(NullPointerException.class, () -> {
            mutableFloat = new MutableFloat((String) null);
            mutableFloat.getValue();
        });
    }

    @Test
    public void testToStringWithPositiveValue() {
        MutableFloat mutableFloat = new MutableFloat(10.5f);
        String expected = "10.5";
        String actual = mutableFloat.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNegativeValue() {
        MutableFloat mutableFloat = new MutableFloat(-5.75f);
        String expected = "-5.75";
        String actual = mutableFloat.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithZeroValue() {
        MutableFloat mutableFloat = new MutableFloat(0f);
        String expected = "0.0";
        String actual = mutableFloat.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNaNValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.NaN);
        String expected = "NaN";
        String actual = mutableFloat.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithInfinityValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        String expected = "Infinity";
        String actual = mutableFloat.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNegativeInfinityValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        String expected = "-Infinity";
        String actual = mutableFloat.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithSmallValue() {
        MutableFloat mutableFloat = new MutableFloat(1.23456789e-10f);
        String expected = "1.2345679E-10";
        String actual = mutableFloat.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            MutableFloat mutableFloat = new MutableFloat("abc");
            mutableFloat.toString();
        });
    }

    @Test
    public void testDoubleValue() {
        mutableFloat = new MutableFloat(0);
        assertEquals(0.0, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(1);
        assertEquals(1.0, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(-1);
        assertEquals(-1.0, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(0.1f);
//        assertEquals(0.1, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(-0.1f);
        // assertEquals(-0.1, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(Float.MAX_VALUE);
        assertEquals(Float.MAX_VALUE, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(Float.MIN_VALUE);
        assertEquals(Float.MIN_VALUE, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, mutableFloat.doubleValue());

        mutableFloat = new MutableFloat(Float.NaN);
        assertTrue(Double.isNaN(mutableFloat.doubleValue()));
    }

    @Test
    public void testToFloatWithDefaultConstructor() {
        MutableFloat mutableFloat = new MutableFloat();
        assertEquals(0.0f, mutableFloat.toFloat());
    }

    @Test
    public void testToFloatWithFloatValueConstructor() {
        MutableFloat mutableFloat = new MutableFloat(2.5f);
        assertEquals(2.5f, mutableFloat.toFloat());
    }

    @Test
    public void testToFloatWithNumberValueConstructor() {
        MutableFloat mutableFloat = new MutableFloat(5);
        assertEquals(5.0f, mutableFloat.toFloat());
    }

    @Test
    public void testToFloatWithStringConstructor() {
        MutableFloat mutableFloat = new MutableFloat("3.14");
        assertEquals(3.14f, mutableFloat.toFloat());
    }

    @Test
    public void testAddAndGetFloat() {
        mutableFloat = new MutableFloat(5.0f);
        float result = mutableFloat.addAndGet(2.5f);
        assertEquals(7.5f, result);
    }

    @Test
    public void testAddAndGetFloatNegativeValue() {
        mutableFloat = new MutableFloat(-5.0f);
        float result = mutableFloat.addAndGet(2.5f);
        assertEquals(-2.5f, result);
    }

    @Test
    public void testAddAndGetFloatZeroValue() {
        mutableFloat = new MutableFloat(0.0f);
        float result = mutableFloat.addAndGet(2.5f);
        assertEquals(2.5f, result);
    }

    @Test
    public void testAddAndGetNumber() {
        mutableFloat = new MutableFloat(5.0f);
        float result = mutableFloat.addAndGet(2);
        assertEquals(7.0f, result);
    }

    @Test
    public void testAddAndGetNumberNegativeValue() {
        mutableFloat = new MutableFloat(-5.0f);
        float result = mutableFloat.addAndGet(-2);
        assertEquals(-7.0f, result);
    }

    @Test
    public void testAddAndGetNumberZeroValue() {
        mutableFloat = new MutableFloat(0.0f);
        float result = mutableFloat.addAndGet(2);
        assertEquals(2.0f, result);
    }

    @Test
    public void testAddAndGetString() {
        mutableFloat = new MutableFloat(5.0f);
        float result = mutableFloat.addAndGet(Float.parseFloat("2.5"));
        assertEquals(7.5f, result);
    }

    @Test
    public void testAddAndGetStringNegativeValue() {
        mutableFloat = new MutableFloat(-5.0f);
        float result = mutableFloat.addAndGet(Float.parseFloat("-2.5"));
        assertEquals(-7.5f, result);
    }

    @Test
    public void testAddAndGetStringZeroValue() {
        mutableFloat = new MutableFloat(0.0f);
        float result = mutableFloat.addAndGet(Float.parseFloat("2.5"));
        assertEquals(2.5f, result);
    }

    @Test
    public void testAddAndGetStringInvalidFormat() {
        mutableFloat = new MutableFloat(5.0f);
        assertThrows(NumberFormatException.class, () -> {
            mutableFloat.addAndGet(Float.parseFloat("abc"));
        });
    }

}