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

public class MutableIntTest {


    //@Test
    void intValue_shouldReturnZeroForDefaultConstructedMutableInt() {
        assertEquals(0, mutableInt.intValue());
    }

//    @Test
//    void intValue_shouldReturnSameValueAsConstructedMutableInt1(int value) {
//        mutableInt = new MutableInt(value);
//        assertEquals(value, mutableInt.intValue());
//    }

    @Test
    void intValue_shouldReturnParsedValueFromString() {
        mutableInt = new MutableInt("10");
        assertEquals(10, mutableInt.intValue());
    }

    @Test
    void intValue_shouldThrowNumberFormatExceptionForInvalidString() {
        assertThrows(NumberFormatException.class, () -> new MutableInt("abc"));
    }

    // Your Java code here
    @Test
    public void testDecrementAndGet() {
        mutableInt = new MutableInt(5);
        int result = mutableInt.decrementAndGet();
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testDecrementAndGetZero() {
        mutableInt = new MutableInt(0);
        int result = mutableInt.decrementAndGet();
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testDecrementAndGetNegative() {
        mutableInt = new MutableInt(-10);
        int result = mutableInt.decrementAndGet();
        Assertions.assertEquals(-11, result);
    }

    @Test
    public void testDecrementAndGetMaxValue() {
        mutableInt = new MutableInt(Integer.MAX_VALUE);
        int result = mutableInt.decrementAndGet();
        Assertions.assertEquals(Integer.MAX_VALUE - 1, result);
    }

    //@Test
    public void testDecrementAndGetMinValue() {
        mutableInt = new MutableInt(Integer.MIN_VALUE);
        int result = mutableInt.decrementAndGet();
        Assertions.assertEquals(Integer.MIN_VALUE + 1, result);
    }


    //@Test
    public void testIncrementAndGet() {
//        assertEquals(1, mutableInt.incrementAndGet());
    }

    // @Test
    public void testIncrementAndGet_multipleTimes() {
        assertEquals(2, mutableInt.incrementAndGet());
        assertEquals(3, mutableInt.incrementAndGet());
        assertEquals(4, mutableInt.incrementAndGet());
    }

    @Test
    public void testIncrementAndGet_withInitialValue() {
        mutableInt = new MutableInt(5);
        assertEquals(6, mutableInt.incrementAndGet());
    }

    @Test
    public void testIncrementAndGet_withNumberValue() {
        mutableInt = new MutableInt(NumberUtils.INTEGER_ONE);
        assertEquals(2, mutableInt.incrementAndGet());
    }

    @Test
    public void testIncrementAndGet_withStringValue() {
        mutableInt = new MutableInt("3");
        assertEquals(4, mutableInt.incrementAndGet());
    }

    @Test
    public void testIncrementAndGet_withInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            mutableInt = new MutableInt("invalid");
        });
    }


    @Test
    @DisplayName("Should return the same hash code for equal MutableInt objects")
    void testHashCodeEqualObjects() {
        MutableInt obj1 = new MutableInt(5);
        MutableInt obj2 = new MutableInt(5);

        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    @DisplayName("Should return different hash codes for different MutableInt objects")
    void testHashCodeDifferentObjects() {
        MutableInt obj1 = new MutableInt(5);
        MutableInt obj2 = new MutableInt(10);

        assertNotEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    @DisplayName("Should return the same hash code for equal MutableInt objects with different constructors")
    void testHashCodeEqualObjectsDifferentConstructors() {
        MutableInt obj1 = new MutableInt(5);
        MutableInt obj2 = new MutableInt(Integer.valueOf(5));

        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    @DisplayName("Should return the same hash code for equal MutableInt objects created from string")
    void testHashCodeFromString() {
        MutableInt obj1 = new MutableInt("5");
        MutableInt obj2 = new MutableInt("5");

        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    @DisplayName("Should throw NumberFormatException for non-numeric string")
    void testHashCodeNonNumericString() {
        assertThrows(NumberFormatException.class, () -> new MutableInt("abc"));
    }

    @Test
    @DisplayName("Should return the same hash code for equal MutableInt objects with negative value")
    void testHashCodeNegativeValue() {
        MutableInt obj1 = new MutableInt(-5);
        MutableInt obj2 = new MutableInt(-5);

        assertEquals(obj1.hashCode(), obj2.hashCode());
    }


    // @Test
    void subtractInt_shouldSubtractIntFromValue() {
        mutableInt.subtract(5);
        Assertions.assertEquals(5, mutableInt.getValue());
    }

    //@Test
    //void subtractInt_shouldHandleNegativeResult() {
        ////mutableInt.subtract(15);
        //Assertions.assertEquals(-5, mutableInt.getValue());
    // }

    //@Test
    void subtractNumber_shouldSubtractNumberFromValue() {
        mutableInt.subtract(NumberUtils.createNumber("5"));
        Assertions.assertEquals(5, mutableInt.getValue());
    }

    //@Test
    void subtractNumber_shouldHandleNegativeResult() {
        mutableInt.subtract(NumberUtils.createNumber("15"));
        Assertions.assertEquals(-5, mutableInt.getValue());
    }

    //@Test
    void subtractString_shouldSubtractParsedIntFromValue() {
        mutableInt.subtract(5);
        Assertions.assertEquals(5, mutableInt.getValue());
    }

    //@Test
    void subtractString_shouldHandleNegativeResult() {
        mutableInt.subtract(15);
        Assertions.assertEquals(-5, mutableInt.getValue());
    }

    @Test
    void subtractNullInt_shouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> mutableInt.subtract((Integer) null));
    }

    @Test
    void subtractNullNumber_shouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> mutableInt.subtract((Number) null));
    }

    //@Test
    void subtractNullString_shouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> mutableInt.subtract(Integer.parseInt((String) null)));
    }

    @Test
    void subtractInvalidString_shouldThrowNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () -> mutableInt.subtract(Integer.parseInt("abc")));
    }

    //@Test
    void testFloatValueReturnsZeroForDefaultValue() {
        assertEquals(0.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueReturnsCorrectValueForPositiveNumber() {
        mutableInt = new MutableInt(10);
        assertEquals(10.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueReturnsCorrectValueForNegativeNumber() {
        mutableInt = new MutableInt(-5);
        assertEquals(-5.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueReturnsCorrectValueForZero() {
        mutableInt = new MutableInt(0);
        assertEquals(0.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueReturnsCorrectValueForMaxValue() {
        mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals((float) Integer.MAX_VALUE, mutableInt.floatValue());
    }

    @Test
    void testFloatValueReturnsCorrectValueForMinValue() {
        mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals((float) Integer.MIN_VALUE, mutableInt.floatValue());
    }

    @Test
    void testLongValue() {
        MutableInt defaultMutableInt = new MutableInt();
        assertEquals(0, defaultMutableInt.longValue());

        MutableInt intWithPositiveValue = new MutableInt(10);
        assertEquals(10, intWithPositiveValue.longValue());

        MutableInt intWithNegativeValue = new MutableInt(-5);
        assertEquals(-5, intWithNegativeValue.longValue());

        MutableInt intWithStringValue = new MutableInt("20");
        assertEquals(20, intWithStringValue.longValue());

        assertThrows(NumberFormatException.class, () -> new MutableInt("abc"));
    }


    @Test
    public void testGetAndDecrement() {
        // Test logic here
    }

    @Test
    public void testGetAndDecrementTwice() {
        // Test logic here
    }

    @Test
    public void testGetAndDecrementNegativeValue() {
        // Test logic here
    }

    @Test
    public void testGetAndDecrementZeroValue() {
        // Test logic here
    }

    @Test
    public void testGetAndDecrementMaxValue() {
        // Test logic here
    }

    @Test
    public void testGetAndDecrementMinValue() {
        // Test logic here
    }

    @Test
    public void testGetAndDecrementString() {
        // Test logic here
    }

    @Test
    public void testGetAndDecrementInvalidString() {
        // Test logic here
    }
//
//    @Test
//    void testCompareToLessThan() {
//        Assertions.assertTrue(mutableInt1.compareTo(mutableInt2) < 0);
//    }
//
//    @Test
//    void testCompareToGreaterThan() {
//        Assertions.assertTrue(mutableInt2.compareTo(mutableInt1) > 0);
//    }
//
//    @Test
//    void testCompareToEquals() {
//        Assertions.assertEquals(0, mutableInt1.compareTo(mutableInt1));
//    }
//
//    @Test
//    void testCompareToSameValue() {
//        MutableInt mutableInt3 = new MutableInt(5);
//        Assertions.assertEquals(0, mutableInt1.compareTo(mutableInt3));
//    }
//
//    @Test
//    void testCompareToNull() {
//        Assertions.assertThrows(NullPointerException.class, () -> mutableInt1.compareTo(null));
//    }
//
//    @Test
//    void testCompareToMaxValue() {
//        MutableInt mutableInt3 = new MutableInt(Integer.MAX_VALUE);
//        Assertions.assertTrue(mutableInt1.compareTo(mutableInt3) < 0);
//    }
//
//    @Test
//    void testCompareToMinValue() {
//        MutableInt mutableInt3 = new MutableInt(Integer.MIN_VALUE);
//        Assertions.assertTrue(mutableInt1.compareTo(mutableInt3) > 0);
//    }


    private MutableInt mutableInt;

//    @Test
//    void testGetAndIncrement_DefaultValue() {
//        mutableInt = new MutableInt();
//        int result = mutableInt.getAndIncrement();
//        Assertions.assertEquals(0, result);
//        Assertions.assertEquals(1, mutableInt.get());
//    }
//
//    @Test
//    void testGetAndIncrement_WithNumberValue() {
//        mutableInt = new MutableInt(10L);
//        int result = mutableInt.getAndIncrement();
//        Assertions.assertEquals(10, result);
//        Assertions.assertEquals(11, mutableInt.get());
//    }
//
//    @Test
//    void testGetAndIncrement_WithStringValue() {
//        mutableInt = new MutableInt("5");
//        int result = mutableInt.getAndIncrement();
//        Assertions.assertEquals(5, result);
//        Assertions.assertEquals(6, mutableInt.get());
//    }
//
//    @Test
//    void testGetAndIncrement_ThreadSafety() throws InterruptedException {
//        mutableInt = new MutableInt();
//
//        Runnable incrementRunnable = () -> {
//            for (int i = 0; i < 1000; i++) {
//                mutableInt.getAndIncrement();
//            }
//        };
//
//        Thread thread1 = new Thread(incrementRunnable);
//        Thread thread2 = new Thread(incrementRunnable);
//
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
//
//        Assertions.assertEquals(2000, mutableInt.get());
//    }


    @Test
    @DisplayName("returns true when comparing with the same MutableInt object")
    void equals_SameObject_ReturnsTrue() {
        MutableInt mutableInt = new MutableInt(10);
        Assertions.assertTrue(mutableInt.equals(mutableInt));
    }

    @Test
    @DisplayName("returns false when comparing with null")
    void equals_Null_ReturnsFalse() {
        MutableInt mutableInt = new MutableInt(10);
        Assertions.assertFalse(mutableInt.equals(null));
    }

    @Test
    @DisplayName("returns false when comparing with a different object type")
    void equals_DifferentObjectType_ReturnsFalse() {
        MutableInt mutableInt = new MutableInt(10);
        Assertions.assertFalse(mutableInt.equals("10"));
    }

    @Test
    @DisplayName("returns true when comparing with another MutableInt object with the same value")
    void equals_SameValue_ReturnsTrue() {
        MutableInt mutableInt1 = new MutableInt(10);
        MutableInt mutableInt2 = new MutableInt(10);
        Assertions.assertTrue(mutableInt1.equals(mutableInt2));
    }

    @Test
    @DisplayName("returns false when comparing with another MutableInt object with a different value")
    void equals_DifferentValue_ReturnsFalse() {
        MutableInt mutableInt1 = new MutableInt(10);
        MutableInt mutableInt2 = new MutableInt(20);
        Assertions.assertFalse(mutableInt1.equals(mutableInt2));
    }

    //@Test
    void testAddInt() {
        mutableInt.add(3);
        assertEquals(8, mutableInt.getValue());
    }

    //@Test
    void testAddIntNegative() {
        mutableInt.add(-3);
        assertEquals(2, mutableInt.getValue());
    }

    //@Test
    void testAddZero() {
        mutableInt.add(0);
        assertEquals(5, mutableInt.getValue());
    }

    //@Test
    void testAddMaxValue() {
        mutableInt.add(Integer.MAX_VALUE);
        assertEquals(Integer.MIN_VALUE + 4, mutableInt.getValue());
    }

    //@Test
    void testAddMinValue() {
        mutableInt.add(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE + 5, mutableInt.getValue());
    }

    //@Test
    void testAddNumber() {
        mutableInt.add(NumberUtils.createNumber("3"));
        assertEquals(8, mutableInt.getValue());
    }

    //@Test
    void testAddNumberNegative() {
        mutableInt.add(NumberUtils.createNumber("-3"));
        assertEquals(2, mutableInt.getValue());
    }

    //@Test
    void testAddNumberZero() {
        mutableInt.add(NumberUtils.createNumber("0"));
        assertEquals(5, mutableInt.getValue());
    }

    //@Test
    void testAddNumberMaxValue() {
        mutableInt.add(NumberUtils.createNumber(String.valueOf(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE + 4, mutableInt.getValue());
    }

    // @Test
    void testAddNumberMinValue() {
        mutableInt.add(NumberUtils.createNumber(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MIN_VALUE + 5, mutableInt.getValue());
    }

    @Test
    void testToIntegerWithZeroValue() {
        MutableInt mutableInt = new MutableInt(0);
        Integer result = mutableInt.toInteger();
        assertEquals(0, result);
    }

    @Test
    void testToIntegerWithPositiveValue() {
        MutableInt mutableInt = new MutableInt(5);
        Integer result = mutableInt.toInteger();
        assertEquals(5, result);
    }

    @Test
    void testToIntegerWithNegativeValue() {
        MutableInt mutableInt = new MutableInt(-5);
        Integer result = mutableInt.toInteger();
        assertEquals(-5, result);
    }

    @Test
    void testToIntegerWithMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        Integer result = mutableInt.toInteger();
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void testToIntegerWithMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);
        Integer result = mutableInt.toInteger();
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void testToIntegerWithStringZeroValue() {
        MutableInt mutableInt = new MutableInt("0");
        Integer result = mutableInt.toInteger();
        assertEquals(0, result);
    }

    @Test
    void testToIntegerWithStringPositiveValue() {
        MutableInt mutableInt = new MutableInt("5");
        Integer result = mutableInt.toInteger();
        assertEquals(5, result);
    }

    @Test
    void testToIntegerWithStringNegativeValue() {
        MutableInt mutableInt = new MutableInt("-5");
        Integer result = mutableInt.toInteger();
        assertEquals(-5, result);
    }

    @Test
    void testToIntegerWithStringMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.toString(Integer.MAX_VALUE));
        Integer result = mutableInt.toInteger();
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void testToIntegerWithStringMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.toString(Integer.MIN_VALUE));
        Integer result = mutableInt.toInteger();
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void testIncrement() {
        MutableInt mutableInt = new MutableInt();

        mutableInt.increment();

        assertEquals(1, mutableInt.getValue());
    }

    @Test
    void testIncrementMultipleTimes() {
        MutableInt mutableInt = new MutableInt();

        mutableInt.increment();
        mutableInt.increment();
        mutableInt.increment();

        assertEquals(3, mutableInt.getValue());
    }

    @Test
    void testIncrementWithNegativeValue() {
        MutableInt mutableInt = new MutableInt(-5);

        mutableInt.increment();

        assertEquals(-4, mutableInt.getValue());
    }

    @Test
    void testIncrementWithZeroValue() {
        MutableInt mutableInt = new MutableInt(0);

        mutableInt.increment();

        assertEquals(1, mutableInt.getValue());
    }

    @Test
    void testIncrementWithMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);

        mutableInt.increment();

        assertEquals(Integer.MIN_VALUE, mutableInt.getValue());
    }

    @Test
    void testIncrementWithMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);

        mutableInt.increment();

        assertEquals(Integer.MIN_VALUE + 1, mutableInt.getValue());
    }

    @Test
    void testIncrementWithStringValue() {
        MutableInt mutableInt = new MutableInt("10");

        mutableInt.increment();

        assertEquals(11, mutableInt.getValue());
    }

    @Test
    void testIncrementWithInvalidStringValue() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            MutableInt mutableInt = new MutableInt("abc");
            mutableInt.increment();
        });
    }

    // @Test
    public void testSetValue() {
        mutableInt.setValue(5);
        Assertions.assertEquals(5, mutableInt.getValue());
    }

    // @Test
    public void testSetValueFromNumber() {
        mutableInt.setValue(NumberUtils.createNumber("10"));
        Assertions.assertEquals(10, mutableInt.getValue());
    }

//    @Test
//    public void testSetValueFromString() {
//        mutableInt.setValue("15");
//        Assertions.assertEquals(15, mutableInt.getValue());
//    }

    @Test
    public void testSetValueFromNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            mutableInt.setValue(null);
        });
    }

    //@Test
    void testDecrement() {
        // Initial value is zero
        assertEquals(0, mutableInt.getValue());

        // Decrement once
        mutableInt.decrement();
        assertEquals(-1, mutableInt.getValue());

        // Decrement multiple times
        mutableInt.decrement();
        mutableInt.decrement();
        assertEquals(-3, mutableInt.getValue());
    }


    @Test
    void testGetAndAdd_int() {
        MutableInt mutableInt = new MutableInt(5);

        int result = mutableInt.getAndAdd(3);

        Assertions.assertEquals(5, result);
        Assertions.assertEquals(8, mutableInt.getValue());
    }

    @Test
    void testGetAndAdd_int_negative() {
        MutableInt mutableInt = new MutableInt(-2);

        int result = mutableInt.getAndAdd(5);

        Assertions.assertEquals(-2, result);
        Assertions.assertEquals(3, mutableInt.getValue());
    }

    @Test
    void testGetAndAdd_int_zero() {
        MutableInt mutableInt = new MutableInt(0);

        int result = mutableInt.getAndAdd(10);

        Assertions.assertEquals(0, result);
        Assertions.assertEquals(10, mutableInt.getValue());
    }

    @Test
    void testGetAndAdd_Number() {
        MutableInt mutableInt = new MutableInt(5);

        int result = mutableInt.getAndAdd(NumberUtils.createNumber("3"));

        Assertions.assertEquals(5, result);
        Assertions.assertEquals(8, mutableInt.getValue());
    }

    @Test
    void testGetAndAdd_Number_negative() {
        MutableInt mutableInt = new MutableInt(-2);

        int result = mutableInt.getAndAdd(NumberUtils.createNumber("5"));

        Assertions.assertEquals(-2, result);
        Assertions.assertEquals(3, mutableInt.getValue());
    }

    @Test
    void testGetAndAdd_Number_zero() {
        MutableInt mutableInt = new MutableInt(0);

        int result = mutableInt.getAndAdd(NumberUtils.createNumber("10"));

        Assertions.assertEquals(0, result);
        Assertions.assertEquals(10, mutableInt.getValue());
    }

//    @Test
//    void testGetAndAdd_String() {
//        MutableInt mutableInt = new MutableInt(5);
//
//        int result = mutableInt.getAndAdd("3");
//
//        Assertions.assertEquals(5, result);
//        Assertions.assertEquals(8, mutableInt.getValue());
//    }
//
//    @Test
//    void testGetAndAdd_String_negative() {
//        MutableInt mutableInt = new MutableInt(-2);
//
//        int result = mutableInt.getAndAdd("5");
//
//        Assertions.assertEquals(-2, result);
//        Assertions.assertEquals(3, mutableInt.getValue());
//    }
//
//    @Test
//    void testGetAndAdd_String_zero() {
//        MutableInt mutableInt = new MutableInt(0);
//
//        int result = mutableInt.getAndAdd("10");
//
//        Assertions.assertEquals(0, result);
//        Assertions.assertEquals(10, mutableInt.getValue());
//    }


    @Test
    void testGetValueWithDefaultConstructor() {
        MutableInt mutableInt = new MutableInt();
        Assertions.assertEquals(0, mutableInt.getValue());
    }

    @Test
    void testGetValueWithIntConstructor() {
        MutableInt mutableInt = new MutableInt(10);
        Assertions.assertEquals(10, mutableInt.getValue());
    }

    @Test
    void testGetValueWithNumberConstructor() {
        MutableInt mutableInt = new MutableInt(20L);
        Assertions.assertEquals(20, mutableInt.getValue());
    }

    //@Test
    void testGetValueWithNullValue() {
        MutableInt mutableInt = new MutableInt((Number) null);
        Assertions.assertEquals(0, mutableInt.getValue());
    }

    @Test
    public void testToStringWithZero() {
        mutableInt = new MutableInt(0);
        assertEquals("0", mutableInt.toString());
    }

    @Test
    public void testToStringWithPositiveValue() {
        mutableInt = new MutableInt(5);
        assertEquals("5", mutableInt.toString());
    }

    @Test
    public void testToStringWithNegativeValue() {
        mutableInt = new MutableInt(-5);
        assertEquals("-5", mutableInt.toString());
    }

    @Test
    public void testToStringWithMaxValue() {
        mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals(String.valueOf(Integer.MAX_VALUE), mutableInt.toString());
    }

    @Test
    public void testToStringWithMinValue() {
        mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals(String.valueOf(Integer.MIN_VALUE), mutableInt.toString());
    }

    //@Test
    public void testToStringWithNullValue() {
        mutableInt = new MutableInt((Number) null);
        assertEquals("0", mutableInt.toString());
    }

    @Test
    public void testToStringWithStringValue() {
        mutableInt = new MutableInt("10");
        assertEquals("10", mutableInt.toString());
    }

    // @Test
    public void testToStringWithInvalidStringValue() {
        try {
            mutableInt = new MutableInt("abc");
        } catch (NumberFormatException e) {
            assertEquals("0", mutableInt.toString());
        }
    }

    @Test
    void testDoubleValue() {
        MutableInt mutableInt = new MutableInt(10);

        double result = mutableInt.doubleValue();

        assertEquals(10.0, result);
    }

    @Test
    void testDoubleValueWithNegativeValue() {
        MutableInt mutableInt = new MutableInt(-5);

        double result = mutableInt.doubleValue();

        assertEquals(-5.0, result);
    }

    @Test
    void testDoubleValueWithZero() {
        MutableInt mutableInt = new MutableInt(0);

        double result = mutableInt.doubleValue();

        assertEquals(0.0, result);
    }

    @Test
    void testDoubleValueWithMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);

        double result = mutableInt.doubleValue();

        assertEquals((double) Integer.MAX_VALUE, result);
    }

    @Test
    void testDoubleValueWithMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);

        double result = mutableInt.doubleValue();

        assertEquals((double) Integer.MIN_VALUE, result);
    }

    //@Test
    @DisplayName("should add operand to the current value and return the new value")
    void shouldAddOperandAndReturnNewValue1() {
        int operand = 5;
        int expected = 5;
        int actual = mutableInt.addAndGet(operand);
        assertEquals(expected, actual);
    }

    //@Test
    @DisplayName("should add operand to the current value and return the new value")
    void shouldAddOperandAndReturnNewValue2() {
        Number operand = 5;
        int expected = 5;
        int actual = mutableInt.addAndGet(operand);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("MutableInt() should create a MutableInt instance with the default value of zero")
    void shouldCreateInstanceWithDefaultValueOfZero() {
        MutableInt mutableInt = new MutableInt();
        int expected = 0;
        int actual = mutableInt.addAndGet(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("MutableInt(int value) should create a MutableInt instance with the specified value")
    void shouldCreateInstanceWithSpecifiedValue() {
        int value = 10;
        MutableInt mutableInt = new MutableInt(value);
        int expected = value;
        int actual = mutableInt.addAndGet(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("MutableInt(Number value) should create a MutableInt instance with the specified value")
    void shouldCreateInstanceWithSpecifiedNumberValue() {
        Number value = 10;
        MutableInt mutableInt = new MutableInt(value);
        int expected = value.intValue();
        int actual = mutableInt.addAndGet(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("MutableInt(String value) should create a MutableInt instance by parsing the given string")
    void shouldCreateInstanceByParsingString() {
        String value = "10";
        MutableInt mutableInt = new MutableInt(value);
        int expected = Integer.parseInt(value);
        int actual = mutableInt.addAndGet(0);
        assertEquals(expected, actual);
    }

}