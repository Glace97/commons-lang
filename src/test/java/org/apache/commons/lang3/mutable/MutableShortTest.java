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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MutableShortTest {


    private MutableShort mutableShort;

    @BeforeEach
    void setUp() {
        mutableShort = new MutableShort();
    }


    @Test
    @DisplayName("Returns the default value of zero")
    void returnsDefaultValue1() {
        assertEquals(0, mutableShort.intValue());
    }

    @Test
    @DisplayName("Returns the value set in the constructor")
    void returnsConstructorValue1() {
        MutableShort constructorValue = new MutableShort((short) 10);
        assertEquals(10, constructorValue.intValue());
    }

    @Test
    @DisplayName("Returns the value parsed from a string")
    void returnsParsedValue1() {
        MutableShort parsedValue = new MutableShort("20");
        assertEquals(20, parsedValue.intValue());
    }

    // Only @Test functions

    @Test
    @DisplayName("Returns the default value of zero")
    void returnsDefaultValue() {
        assertEquals(0, mutableShort.intValue());
    }

    @Test
    @DisplayName("Returns the value set in the constructor")
    void returnsConstructorValue() {
        MutableShort constructorValue = new MutableShort((short) 10);
        assertEquals(10, constructorValue.intValue());
    }

    @Test
    @DisplayName("Returns the value parsed from a string")
    void returnsParsedValue() {
        MutableShort parsedValue = new MutableShort("20");
        assertEquals(20, parsedValue.intValue());
    }


    @Test
    void decrementAndGet_shouldDecrementValueByOne() {
        MutableShort mutableShort = new MutableShort((short) 10);
        short result = mutableShort.decrementAndGet();

        assertEquals(9, result);
    }

    @Test
    void decrementAndGet_shouldReturnUpdatedValue() {
        MutableShort mutableShort = new MutableShort((short) 10);
        short result = mutableShort.decrementAndGet();

        assertEquals(result, mutableShort.getValue());
    }

    @Test
    void decrementAndGet_shouldHandleMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
        short result = mutableShort.decrementAndGet();

        assertEquals(Short.MAX_VALUE, result);
    }

    @Test
    void decrementAndGet_shouldHandleMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
        short result = mutableShort.decrementAndGet();

        assertEquals(Short.MAX_VALUE - 1, result);
    }


//    @Test
//    void testDefaultConstructor() {
//        MutableShort mutableShort = new MutableShort();
//        assertEquals(0, mutableShort.toShort());
//    }

//    @Test
//    void testValueConstructor() {
//        MutableShort mutableShort = new MutableShort((short) 42);
//        assertEquals(42, mutableShort.toShort());
////    }
//
//    @Test
//    void testNumberConstructor() {
//        MutableShort mutableShort = new MutableShort(new Integer(42));
//        assertEquals(42, mutableShort.toShort());
//    }
//
//    @Test
//    void testStringConstructor() {
//        MutableShort mutableShort = new MutableShort("42");
//        assertEquals(42, mutableShort.toShort());
//    }

    @Test
    void testInvalidStringConstructor() {
        assertThrows(NumberFormatException.class, () -> new MutableShort("abc"));
    }

//    @Test
//    void testToShort() {
//        MutableShort mutableShort = new MutableShort((short) 42);
//        assertEquals(42, mutableShort.toShort());
//    }

    @Test
    void testShortValue() {
        // Test default value
        assertEquals((short) 0, mutableShort.shortValue());

        // Test value set using Number constructor
        mutableShort = new MutableShort((short) 10);
        assertEquals((short) 10, mutableShort.shortValue());

        // Test value set using short constructor
        mutableShort = new MutableShort((short) -5);
        assertEquals((short) -5, mutableShort.shortValue());

        // Test value set using string constructor
        mutableShort = new MutableShort("15");
        assertEquals((short) 15, mutableShort.shortValue());

        // Test value set using string constructor with leading zeros
        mutableShort = new MutableShort("00020");
        assertEquals((short) 20, mutableShort.shortValue());

        // Test value set using string constructor with negative value
        mutableShort = new MutableShort("-10");
        assertEquals((short) -10, mutableShort.shortValue());
    }

    @Test
    void testIncrementAndGet() {
        mutableShort = new MutableShort((short) 0);
        assertEquals(1, mutableShort.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithNegativeValue() {
        mutableShort = new MutableShort((short) -1);
        assertEquals(0, mutableShort.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithMaxValue() {
        mutableShort = new MutableShort(Short.MAX_VALUE);
        assertEquals(Short.MIN_VALUE, mutableShort.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithMinValue() {
        mutableShort = new MutableShort(Short.MIN_VALUE);
        assertEquals((short) (Short.MIN_VALUE + 1), mutableShort.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithStringValue() {
        mutableShort = new MutableShort("0");
        assertEquals(1, mutableShort.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> new MutableShort("abc"));
    }

//    @Test
//    void testIncrementAndGetWithNullValue() {
//        assertThrows(NullPointerException.class, () -> new MutableShort(null));
//    }

    @Test
    void testIncrementAndGetMultipleTimes() {
        mutableShort = new MutableShort((short) 0);
        assertEquals(1, mutableShort.incrementAndGet());
        assertEquals(2, mutableShort.incrementAndGet());
        assertEquals(3, mutableShort.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithMultipleInstances() {
        mutableShort = new MutableShort((short) 0);
        MutableShort otherMutableShort = new MutableShort((short) 10);
        assertEquals(1, mutableShort.incrementAndGet());
        assertEquals(11, otherMutableShort.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithThreadSafety() throws InterruptedException {
        mutableShort = new MutableShort((short) 0);
        List<Thread> threads = Arrays.asList(
                new Thread(() -> {
                    for (int i = 0; i < 1000; i++) {
                        mutableShort.incrementAndGet();
                    }
                }),
                new Thread(() -> {
                    for (int i = 0; i < 1000; i++) {
                        mutableShort.incrementAndGet();
                    }
                })
        );
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        assertEquals(2000, mutableShort.incrementAndGet());
    }

    @Test
    void testHashCode() {
        MutableShort zero = new MutableShort((short) 0);
        MutableShort one = new MutableShort((short) 1);
        MutableShort max = new MutableShort(Short.MAX_VALUE);
        MutableShort min = new MutableShort(Short.MIN_VALUE);

        assertEquals(0, zero.hashCode());
        assertEquals(1, one.hashCode());
        assertEquals(Short.MAX_VALUE, max.hashCode());
        assertEquals(Short.MIN_VALUE, min.hashCode());

        MutableShort zeroFromString = new MutableShort("0");
        MutableShort oneFromString = new MutableShort("1");
        MutableShort maxFromString = new MutableShort(String.valueOf(Short.MAX_VALUE));
        MutableShort minFromString = new MutableShort(String.valueOf(Short.MIN_VALUE));

        assertEquals(0, zeroFromString.hashCode());
        assertEquals(1, oneFromString.hashCode());
        assertEquals(Short.MAX_VALUE, maxFromString.hashCode());
        assertEquals(Short.MIN_VALUE, minFromString.hashCode());
    }

//    @Test
//    void testSubtractWithNumberOperand() {
//        mutableShort.subtract(NumberUtils.INTEGER_ONE);
//        assertEquals(9, mutableShort.getValue());
//    }
//
//    @Test
//    void testSubtractWithShortOperand() {
//        mutableShort.subtract((short) 2);
//        assertEquals(8, mutableShort.getValue());
//    }
//
//    @Test
//    void testSubtractWithZeroOperand() {
//        mutableShort.subtract(NumberUtils.INTEGER_ZERO);
//        assertEquals(10, mutableShort.getValue());
//    }
//
//    @Test
//    void testSubtractWithNegativeNumberOperand() {
//        mutableShort.subtract(NumberUtils.INTEGER_MINUS_ONE);
//        assertEquals(11, mutableShort.getValue());
//    }
//
//    @Test
//    void testSubtractWithMaxShortOperand() {
//        mutableShort.subtract(Short.MAX_VALUE);
//        assertEquals(-32757, mutableShort.getValue());
//    }
//
//    @Test
//    void testSubtractWithMinShortOperand() {
//        mutableShort.subtract(Short.MIN_VALUE);
//        assertEquals(32777, mutableShort.getValue());
//    }

    @Test
    void testFloatValueWithZeroValue() {
        mutableShort = new MutableShort((short) 0);
        assertEquals(0f, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithPositiveValue() {
        mutableShort = new MutableShort((short) 100);
        assertEquals(100f, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithNegativeValue() {
        mutableShort = new MutableShort((short) -100);
        assertEquals(-100f, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithMaxValue() {
        mutableShort = new MutableShort(Short.MAX_VALUE);
        assertEquals((float) Short.MAX_VALUE, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithMinValue() {
        mutableShort = new MutableShort(Short.MIN_VALUE);
        assertEquals((float) Short.MIN_VALUE, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithFloatMaxValue() {
        mutableShort = new MutableShort(Float.MAX_VALUE);
        assertEquals(Float.MAX_VALUE, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithFloatMinValue() {
        mutableShort = new MutableShort(Float.MIN_VALUE);
        assertEquals(Float.MIN_VALUE, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithStringValue() {
        mutableShort = new MutableShort("100");
        assertEquals(100f, mutableShort.floatValue());
    }

    @Test
    void testFloatValueWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> new MutableShort("abc").floatValue());
    }

    @Test
    public void testLongValue() {
        // Test default value
        Assertions.assertEquals(0L, mutableShort.longValue());

        // Test positive value
        mutableShort = new MutableShort((short) 100);
        Assertions.assertEquals(100L, mutableShort.longValue());

        // Test negative value
        mutableShort = new MutableShort((short) -100);
        Assertions.assertEquals(-100L, mutableShort.longValue());

        // Test edge cases
        mutableShort = new MutableShort(Short.MAX_VALUE);
        Assertions.assertEquals((long) Short.MAX_VALUE, mutableShort.longValue());

        mutableShort = new MutableShort(Short.MIN_VALUE);
        Assertions.assertEquals((long) Short.MIN_VALUE, mutableShort.longValue());
    }

    @Test
    void testGetAndDecrement() {
        assertEquals(10, mutableShort.getAndDecrement());
        assertEquals(9, mutableShort.getAndDecrement());
    }

    @Test
    void testGetAndDecrementEdgeCases() {
        mutableShort = new MutableShort(Short.MIN_VALUE);
        assertEquals(Short.MIN_VALUE, mutableShort.getAndDecrement());

        mutableShort = new MutableShort(Short.MAX_VALUE);
        assertEquals(Short.MAX_VALUE, mutableShort.getAndDecrement());
    }

    @Test
    void testGetAndDecrementWithZeroValue() {
        mutableShort = new MutableShort(0);
        assertEquals(0, mutableShort.getAndDecrement());
        assertEquals(-1, mutableShort.getAndDecrement());
    }

    @Test
    void testGetAndDecrementWithStringValue() {
        mutableShort = new MutableShort("10");
        assertEquals(10, mutableShort.getAndDecrement());

        mutableShort = new MutableShort("-5");
        assertEquals(-5, mutableShort.getAndDecrement());
    }

//    @Test
//    void testGetAndDecrementWithNullValue() {
//        assertThrows(NullPointerException.class, () -> {
//            mutableShort = new MutableShort(null);
//            mutableShort.getAndDecrement();
//        });
//    }
//
//    @Test
//    void testCompareTo_LessThan() {
//        assertTrue(mutableShort1.compareTo(mutableShort2) < 0);
//    }
//
//    @Test
//    void testCompareTo_GreaterThan() {
//        assertTrue(mutableShort2.compareTo(mutableShort1) > 0);
//    }
//
//    @Test
//    void testCompareTo_Equal() {
//        assertEquals(0, mutableShort1.compareTo(mutableShort3));
//    }
//
//    @Test
//    void testCompareTo_Null() {
//        assertThrows(NullPointerException.class, () -> mutableShort1.compareTo(null));
//    }
//
//    @Test
//    void testCompareTo_SameObject() {
//        assertEquals(0, mutableShort1.compareTo(mutableShort1));
//    }
//// Your Java code here

    @Test
    @DisplayName("should increment the value and return the previous value")
    void shouldIncrementValueAndReturnPreviousValue() {
        assertEquals(0, mutableShort.getAndIncrement());
        assertEquals(1, mutableShort.getAndIncrement());
        assertEquals(2, mutableShort.getAndIncrement());
    }

    @Test
    @DisplayName("should increment the value from a negative starting point")
    void shouldIncrementValueFromNegativeStartingPoint() {
        mutableShort = new MutableShort((short) -5);
        assertEquals(-5, mutableShort.getAndIncrement());
        assertEquals(-4, mutableShort.getAndIncrement());
        assertEquals(-3, mutableShort.getAndIncrement());
    }

    @Test
    @DisplayName("should increment the value from a non-zero starting point")
    void shouldIncrementValueFromNonZeroStartingPoint() {
        mutableShort = new MutableShort((short) 10);
        assertEquals(10, mutableShort.getAndIncrement());
        assertEquals(11, mutableShort.getAndIncrement());
        assertEquals(12, mutableShort.getAndIncrement());
    }

    @Test
    @DisplayName("should increment the value multiple times")
    void shouldIncrementValueMultipleTimes() {
        assertEquals(0, mutableShort.getAndIncrement());
        assertEquals(1, mutableShort.getAndIncrement());
        assertEquals(2, mutableShort.getAndIncrement());
        assertEquals(3, mutableShort.getAndIncrement());
        assertEquals(4, mutableShort.getAndIncrement());
    }

    @Test
    void testEquals_sameObject() {
        MutableShort mutableShort = new MutableShort((short) 5);
        assertTrue(mutableShort.equals(mutableShort));
    }

    @Test
    void testEquals_nullObject() {
        MutableShort mutableShort = new MutableShort((short) 5);
        assertFalse(mutableShort.equals(null));
    }

    @Test
    void testEquals_differentClass() {
        MutableShort mutableShort = new MutableShort((short) 5);
        assertFalse(mutableShort.equals("test"));
    }

    @Test
    void testEquals_sameValue() {
        MutableShort mutableShort1 = new MutableShort((short) 5);
        MutableShort mutableShort2 = new MutableShort((short) 5);
        assertTrue(mutableShort1.equals(mutableShort2));
    }

    @Test
    void testEquals_differentValue() {
        MutableShort mutableShort1 = new MutableShort((short) 5);
        MutableShort mutableShort2 = new MutableShort((short) 10);
        assertFalse(mutableShort1.equals(mutableShort2));
    }

    @Test
    void testEquals_sameValueDifferentTypes() {
        MutableShort mutableShort1 = new MutableShort((short) 5);
        MutableShort mutableShort2 = new MutableShort((byte) 5);
        assertFalse(mutableShort1.equals(mutableShort2));
    }

    @Test
    void testEquals_differentValueDifferentTypes() {
        MutableShort mutableShort1 = new MutableShort((short) 5);
        MutableShort mutableShort2 = new MutableShort((byte) 10);
        assertFalse(mutableShort1.equals(mutableShort2));
    }

//    @Test
//    void testAddNumber() {
//        mutableShort.add(NumberUtils.LONG_ONE);
//        assertEquals(1, mutableShort.getValue());
//    }
//
//    @Test
//    void testAddShort() {
//        mutableShort.add((short) 5);
//        assertEquals(5, mutableShort.getValue());
//    }
//
//    @Test
//    void testAddZero() {
//        mutableShort.add(NumberUtils.LONG_ZERO);
//        assertEquals(0, mutableShort.getValue());
//    }
//
//    @Test
//    void testAddNegativeNumber() {
//        mutableShort.add(NumberUtils.LONG_MINUS_ONE);
//        assertEquals(-1, mutableShort.getValue());
//    }

    @Test
    void testAddMaxValue() {
        mutableShort.add(Short.MAX_VALUE);
        assertEquals(Short.MAX_VALUE, mutableShort.getValue());
    }

    @Test
    void testAddMinValue() {
        mutableShort.add(Short.MIN_VALUE);
        assertEquals(Short.MIN_VALUE, mutableShort.getValue());
    }

//    @Test
//    void testAddString() {
//        assertThrows(NumberFormatException.class, () -> mutableShort.add("abc"));
//    }
//
//    @Test
//    void testIncrement() {
//        mutableShort.increment();
//        assertEquals(1, mutableShort.getValue());
//    }
//
//    @Test
//    void testIncrementMultipleTimes() {
//        mutableShort.increment();
//        mutableShort.increment();
//        mutableShort.increment();
//        assertEquals(3, mutableShort.getValue());
//    }
//
//    @Test
//    void testIncrementWithNegativeValue() {
//        mutableShort = new MutableShort(-1);
//        mutableShort.increment();
//        assertEquals(0, mutableShort.getValue());
//    }

    @Test
    void testIncrementMaxValue() {
        mutableShort = new MutableShort(Short.MAX_VALUE);
        mutableShort.increment();
        assertEquals(Short.MIN_VALUE, mutableShort.getValue());
    }

//    @Test
//    void testIncrementMinValue() {
//        mutableShort = new MutableShort(Short.MIN_VALUE);
//        mutableShort.increment();
//        assertEquals(Short.MIN_VALUE + 1, mutableShort.getValue());
//    }

//    @Test
//    void testIncrementWithStringValue() {
//        mutableShort = new MutableShort("5");
//        mutableShort.increment();
//        assertEquals(6, mutableShort.getValue());
//    }

    @Test
    void testIncrementWithNonNumericStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            mutableShort = new MutableShort("abc");
            mutableShort.increment();
        });
    }

    @Test
    void testIncrementWithNullValue() {
        assertThrows(NullPointerException.class, () -> {
            mutableShort = new MutableShort((Number) null);
            mutableShort.increment();
        });
    }

//    @Test
//    void testSetValueWithNumber() {
//        mutableShort.setValue(10);
//        assertEquals(10, mutableShort.getValue());
//
//        mutableShort.setValue(0);
//        assertEquals(0, mutableShort.getValue());
//
//        mutableShort.setValue(-10);
//        assertEquals(-10, mutableShort.getValue());
//    }

    @Test
    void testSetValueWithShort() {
        short value = 10;
        mutableShort.setValue(value);
        assertEquals(value, mutableShort.getValue());

        value = 0;
        mutableShort.setValue(value);
        assertEquals(value, mutableShort.getValue());

        value = -10;
        mutableShort.setValue(value);
        assertEquals(value, mutableShort.getValue());
    }

//    @Test
//    void testSetValueWithString() {
//        String value = "10";
//        mutableShort.setValue(value);
//        assertEquals(10, mutableShort.getValue());
//
//        value = "0";
//        mutableShort.setValue(value);
//        assertEquals(0, mutableShort.getValue());
//
//        value = "-10";
//        mutableShort.setValue(value);
//        assertEquals(-10, mutableShort.getValue());
//    }

    @Test
    void testSetValueWithNull() {
        assertThrows(NullPointerException.class, () -> mutableShort.setValue((Number) null));
    }

//    @Test
//    void testSetValueWithInvalidString() {
//        String value = "abc";
//        assertThrows(NumberFormatException.class, () -> mutableShort.setValue(value));
//    }
//
//    @Test
//    void decrement_shouldDecrementValueByOne() {
//        mutableShort.decrement();
//        assertEquals(9, mutableShort.getValue());
//    }

    @Test
    void decrement_shouldHandleMinValue() {
        mutableShort = new MutableShort(Short.MIN_VALUE);
        mutableShort.decrement();
        assertEquals(Short.MAX_VALUE, mutableShort.getValue());
    }

//    @Test
//    void decrement_shouldHandleMaxValue() {
//        mutableShort = new MutableShort(Short.MAX_VALUE);
//        mutableShort.decrement();
//        assertEquals(Short.MAX_VALUE - 1, mutableShort.getValue());
//    }
//
//    @Test
//    void decrement_shouldHandleZeroValue() {
//        mutableShort = new MutableShort(0);
//        mutableShort.decrement();
//        assertEquals(-1, mutableShort.getValue());
//    }
//
//    @Test
//    void decrement_shouldHandleNegativeValue() {
//        mutableShort = new MutableShort(-10);
//        mutableShort.decrement();
//        assertEquals(-11, mutableShort.getValue());
//    }
//
//    @Test
//    void decrement_shouldHandleStringRepresentation() {
//        mutableShort = new MutableShort("10");
//        mutableShort.decrement();
//        assertEquals(9, mutableShort.getValue());
//    }

    @Test
    void decrement_shouldThrowNumberFormatExceptionForInvalidString() {
        mutableShort = new MutableShort("abc");
        assertThrows(NumberFormatException.class, () -> mutableShort.decrement());
    }

//    @Test
//    void testGetAndAddWithPositiveOperand() {
//        mutableShort = new MutableShort((short) 10);
//
//        short result1 = mutableShort.getAndAdd((short) 5);
//        assertEquals(10, result1);
//        assertEquals(15, mutableShort.getValue());
//
//        short result2 = mutableShort.getAndAdd((short) 2);
//        assertEquals(15, result2);
//        assertEquals(17, mutableShort.getValue());
//    }
//
//    @Test
//    void testGetAndAddWithNegativeOperand() {
//        mutableShort = new MutableShort((short) 10);
//
//        short result1 = mutableShort.getAndAdd((short) -5);
//        assertEquals(10, result1);
//        assertEquals(5, mutableShort.getValue());
//
//        short result2 = mutableShort.getAndAdd((short) -2);
//        assertEquals(5, result2);
//        assertEquals(3, mutableShort.getValue());
//    }
//
//    @Test
//    void testGetAndAddWithZeroOperand() {
//        mutableShort = new MutableShort((short) 10);
//
//        short result1 = mutableShort.getAndAdd((short) 0);
//        assertEquals(10, result1);
//        assertEquals(10, mutableShort.getValue());
//
//        short result2 = mutableShort.getAndAdd((short) 0);
//        assertEquals(10, result2);
//        assertEquals(10, mutableShort.getValue());
//    }

    @Test
    void testGetAndAddWithMaxValueOperand() {
        mutableShort = new MutableShort(Short.MAX_VALUE);

        short result = mutableShort.getAndAdd((short) 1);
        assertEquals(Short.MAX_VALUE, result);
        assertEquals(Short.MIN_VALUE, mutableShort.getValue());
    }

    @Test
    void testGetAndAddWithMinValueOperand() {
        mutableShort = new MutableShort(Short.MIN_VALUE);

        short result = mutableShort.getAndAdd((short) -1);
        assertEquals(Short.MIN_VALUE, result);
        assertEquals(Short.MAX_VALUE, mutableShort.getValue());
    }

    @Test
    @DisplayName("Test getValue() method with default value")
    void testGetValueWithDefaultValue() {
        Short expected = 0;
        assertEquals(expected, mutableShort.getValue());
    }

    @Test
    @DisplayName("Test getValue() method with Number value")
    void testGetValueWithNumberValue() {
        Number value = 10;
        mutableShort = new MutableShort(value);
        Short expected = 10;
        assertEquals(expected, mutableShort.getValue());
    }

    @Test
    @DisplayName("Test getValue() method with short value")
    void testGetValueWithShortValue() {
        short value = 20;
        mutableShort = new MutableShort(value);
        Short expected = 20;
        assertEquals(expected, mutableShort.getValue());
    }

    @Test
    @DisplayName("Test getValue() method with string value")
    void testGetValueWithStringValue() {
        String value = "30";
        mutableShort = new MutableShort(value);
        Short expected = 30;
        assertEquals(expected, mutableShort.getValue());
    }

    @Test
    @DisplayName("Test getValue() method with invalid string value")
    void testGetValueWithInvalidStringValue() {
        String value = "abc";
        assertThrows(NumberFormatException.class, () -> new MutableShort(value));
    }

//    @Test
//    @DisplayName("toString() should return '0' for a newly created MutableShort object")
//    void testToString() {
//        MutableShort mutableShort = new MutableShort();
//        assertEquals("0", mutableShort.toString());
//    }
//
//    @Test
//    @DisplayName("toString() should return the string representation of the given Number parameter")
//    void testToString() {
//        MutableShort mutableShort = new MutableShort((short) 10);
//        assertEquals("10", mutableShort.toString());
//    }
//
//    @Test
//    @DisplayName("toString() should throw NullPointerException if the Number parameter is null")
//    void testToStringWithNull() {
//        assertThrows(NullPointerException.class, () -> new MutableShort(null));
//    }

    @Test
    @DisplayName("toString() should return the string representation of the given short parameter")
    void testToString1() {
        MutableShort mutableShort = new MutableShort((short) -5);
        assertEquals("-5", mutableShort.toString());
    }

    @Test
    @DisplayName("toString() should return the string representation of the parsed short value")
    void testToString2() {
        MutableShort mutableShort = new MutableShort("20");
        assertEquals("20", mutableShort.toString());
    }

    @Test
    @DisplayName("toString() should throw NumberFormatException if the string cannot be parsed into a short")
    void testToStringWithInvalidString() {
        assertThrows(NumberFormatException.class, () -> new MutableShort("abc"));
    }

    @Test
    void testDoubleValueWithZeroValue() {
        mutableShort = new MutableShort((short) 0);
        assertEquals(0.0, mutableShort.doubleValue());
    }

    @Test
    void testDoubleValueWithPositiveValue() {
        mutableShort = new MutableShort((short) 10);
        assertEquals(10.0, mutableShort.doubleValue());
    }

    @Test
    void testDoubleValueWithNegativeValue() {
        mutableShort = new MutableShort((short) -5);
        assertEquals(-5.0, mutableShort.doubleValue());
    }

    @Test
    void testDoubleValueWithMaxValue() {
        mutableShort = new MutableShort(Short.MAX_VALUE);
        assertEquals(32767.0, mutableShort.doubleValue());
    }

    @Test
    void testDoubleValueWithMinValue() {
        mutableShort = new MutableShort(Short.MIN_VALUE);
        assertEquals(-32768.0, mutableShort.doubleValue());
    }

    @Test
    void testDoubleValueWithStringValue() {
        mutableShort = new MutableShort("15");
        assertEquals(15.0, mutableShort.doubleValue());
    }

    @Test
    void testDoubleValueWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> new MutableShort("abc").doubleValue());
    }

//    @Test
//    void testAddAndGetWithNumber() {
//        MutableShort mutableShort = new MutableShort();
//        short result = mutableShort.addAndGet(NumberUtils.BYTE_ONE);
//        assertEquals(NumberUtils.BYTE_ONE, result);
//    }
//
//    @Test
//    void testAddAndGetWithShort() {
//        MutableShort mutableShort = new MutableShort();
//        short result = mutableShort.addAndGet(NumberUtils.BYTE_ONE);
//        assertEquals(NumberUtils.BYTE_ONE, result);
//    }
//
//    @Test
//    void testAddAndGetWithZero() {
//        MutableShort mutableShort = new MutableShort();
//        short result = mutableShort.addAndGet(NumberUtils.BYTE_ZERO);
//        assertEquals(NumberUtils.BYTE_ZERO, result);
//    }
//
//    @Test
//    void testAddAndGetWithNegativeNumber() {
//        MutableShort mutableShort = new MutableShort();
//        short result = mutableShort.addAndGet(NumberUtils.BYTE_MINUS_ONE);
//        assertEquals(Optional.of(NumberUtils.BYTE_MINUS_ONE), result);
//    }

    @Test
    void testAddAndGetWithMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
        short result = mutableShort.addAndGet(NumberUtils.BYTE_ONE);
        assertEquals(Short.MIN_VALUE, result);
    }

    @Test
    void testAddAndGetWithMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
        short result = mutableShort.addAndGet(NumberUtils.BYTE_MINUS_ONE);
        assertEquals(Short.MAX_VALUE, result);
    }

//    @Test
//    void testAddAndGetWithMaxValueAndOverflow() {
//        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
//        short result = mutableShort.addAndGet(NumberUtils.BYTE_MAX);
//        assertEquals(Short.MIN_VALUE, result);
//    }
//
//    @Test
//    void testAddAndGetWithMinValueAndUnderflow() {
//        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
//        short result = mutableShort.addAndGet(NumberUtils.BYTE_MIN);
//        assertEquals(Short.MAX_VALUE, result);
//    }

}