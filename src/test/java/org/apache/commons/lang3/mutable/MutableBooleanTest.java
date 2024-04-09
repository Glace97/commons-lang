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


import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MutableBooleanTest {

    private MutableBoolean mutableBoolean;
    MutableBoolean mutableBooleanTrue = new MutableBoolean(true);
    MutableBoolean mutableBooleanFalse = new MutableBoolean(false);
    @BeforeEach
    void setUp() {
        mutableBoolean = new MutableBoolean();
    }

    @Test
    void testIsFalse() {
        assertFalse(mutableBooleanTrue.isFalse());
        assertTrue(mutableBooleanFalse.isFalse());
    }

    @Test
    void setTrue_shouldSetTheValueToTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        mutableBoolean.setTrue();
        assertEquals(true, mutableBoolean.getValue());
    }
    // Your Java code here

    @Test
    void testSetFalse() {
        mutableBoolean = new MutableBoolean(true);
        mutableBoolean.setFalse();
        assertFalse(mutableBoolean.getValue());

        mutableBoolean = new MutableBoolean(false);
        mutableBoolean.setFalse();
        assertFalse(mutableBoolean.getValue());
    }

    @Test
    public void testIsTrueWithDefaultFalseValue() {
        assertFalse(mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueWithTrueValue() {
        mutableBoolean = new MutableBoolean(true);
        assertTrue(mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueWithFalseValue() {
        mutableBoolean = new MutableBoolean(false);
        assertFalse(mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueWithBooleanTrueValue() {
        mutableBoolean = new MutableBoolean(Boolean.TRUE);
        assertTrue(mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueWithBooleanFalseValue() {
        mutableBoolean = new MutableBoolean(Boolean.FALSE);
        assertFalse(mutableBoolean.isTrue());
    }

    @Test
    void testHashCodeWithTrueValue() {
        mutableBoolean = new MutableBoolean(true);
        assertEquals(Boolean.TRUE.hashCode(), mutableBoolean.hashCode());
    }

    @Test
    void testHashCodeWithFalseValue() {
        mutableBoolean = new MutableBoolean(false);
        assertEquals(Boolean.FALSE.hashCode(), mutableBoolean.hashCode());
    }

    @Test
    void testHashCodeWithNullValue() {
        mutableBoolean = new MutableBoolean((Boolean) null);
        assertEquals(Boolean.FALSE.hashCode(), mutableBoolean.hashCode());
    }

    @Test
    void testHashCodeForSameTrueValue() {
        mutableBoolean = new MutableBoolean(true);
        MutableBoolean anotherMutableBoolean = new MutableBoolean(true);
        assertEquals(mutableBoolean.hashCode(), anotherMutableBoolean.hashCode());
    }

    @Test
    void testHashCodeForSameFalseValue() {
        mutableBoolean = new MutableBoolean(false);
        MutableBoolean anotherMutableBoolean = new MutableBoolean(false);
        assertEquals(mutableBoolean.hashCode(), anotherMutableBoolean.hashCode());
    }

    @Test
    void testHashCodeForDifferentValues() {
        mutableBoolean = new MutableBoolean(true);
        MutableBoolean anotherMutableBoolean = new MutableBoolean(false);
        assertNotEquals(mutableBoolean.hashCode(), anotherMutableBoolean.hashCode());
    }

    @Test
    void testCompareTo_LessThan() {
        MutableBoolean mutable1 = new MutableBoolean(false);
        MutableBoolean mutable2 = new MutableBoolean(true);

        int result = mutable1.compareTo(mutable2);

        assertTrue(result < 0);
    }

    @Test
    void testCompareTo_GreaterThan() {
        MutableBoolean mutable1 = new MutableBoolean(true);
        MutableBoolean mutable2 = new MutableBoolean(false);

        int result = mutable1.compareTo(mutable2);

        assertTrue(result > 0);
    }

    @Test
    void testCompareTo_Equal() {
        MutableBoolean mutable1 = new MutableBoolean(true);
        MutableBoolean mutable2 = new MutableBoolean(true);

        int result = mutable1.compareTo(mutable2);

        assertEquals(0, result);
    }

    @Test
    void testCompareTo_SameInstance() {
        MutableBoolean mutable1 = new MutableBoolean(true);

        int result = mutable1.compareTo(mutable1);

        assertEquals(0, result);
    }

    @Test
    public void testEqualsWithSameObject() {
        assertTrue(mutableBooleanTrue.equals(mutableBooleanTrue));
    }

    @Test
    public void testEqualsWithDifferentObjects() {
        assertFalse(mutableBooleanTrue.equals(mutableBooleanFalse));
    }

//    @Test
//    public void testEqualsWithNullObject() {
//        assertFalse(mutableBooleanTrue.equals(mutableBooleanNull));
//    }

    @Test
    public void testEqualsWithDifferentClassObject() {
        assertFalse(mutableBooleanTrue.equals("true"));
    }

//    @Test
//    public void testEqualsWithCopyOfSameObject() {
//        assertTrue(mutableBooleanTrue.equals(mutableBooleanTrueCopy));
//    }
//
//    @Test
//    public void testEqualsWithCopyOfDifferentObject() {
//        assertTrue(mutableBooleanFalse.equals(mutableBooleanFalseCopy));
//    }


    @Test
    @DisplayName("Test booleanValue() method for default value")
    void testBooleanValueForDefaultValue() {
        assertFalse(mutableBoolean.booleanValue());
    }

    @Test
    @DisplayName("Test booleanValue() method for true value")
    void testBooleanValueForTrueValue() {
        mutableBoolean = new MutableBoolean(true);
        assertTrue(mutableBoolean.booleanValue());
    }

    @Test
    @DisplayName("Test booleanValue() method for false value")
    void testBooleanValueForFalseValue() {
        mutableBoolean = new MutableBoolean(false);
        assertFalse(mutableBoolean.booleanValue());
    }

    @Test
    @DisplayName("Test booleanValue() method for null value")
    void testBooleanValueForNullValue() {
        assertThrows(NullPointerException.class, () -> new MutableBoolean(null));
    }
    // Your Java code here

    @Test
    @DisplayName("should set the value to true")
    void shouldSetValueToTrue1() {
        mutableBoolean.setValue(true);
        assertEquals(true, mutableBoolean.getValue());
    }

    @Test
    @DisplayName("should set the value to false")
    void shouldSetValueToFalse1() {
        mutableBoolean.setValue(false);
        assertEquals(false, mutableBoolean.getValue());
    }

    @Test
    @DisplayName("should set the value to true when Boolean value is true")
    void shouldSetValueToTrue2() {
        mutableBoolean.setValue(Boolean.TRUE);
        assertEquals(true, mutableBoolean.getValue());
    }

    @Test
    @DisplayName("should set the value to false when Boolean value is false")
    void shouldSetValueToFalse2() {
        mutableBoolean.setValue(Boolean.FALSE);
        assertEquals(false, mutableBoolean.getValue());
    }

    @Test
    @DisplayName("should throw NullPointerException when Boolean value is null")
    void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> mutableBoolean.setValue((Boolean) null));
    }

    @Test
    @DisplayName("should return Boolean.FALSE when value is false")
    void shouldReturnFalse() {
        mutableBoolean = new MutableBoolean(false);
        assertEquals(Boolean.FALSE, mutableBoolean.toBoolean());
    }

    @Test
    @DisplayName("should return Boolean.TRUE when value is true")
    void shouldReturnTrue() {
        mutableBoolean = new MutableBoolean(true);
        assertEquals(Boolean.TRUE, mutableBoolean.toBoolean());
    }

    @Test
    public void testGetValueDefault() {
        assertFalse(mutableBoolean.getValue());
    }

    @Test
    public void testGetValueTrue() {
        mutableBoolean = new MutableBoolean(true);
        assertTrue(mutableBoolean.getValue());
    }

    @Test
    public void testGetValueFalse() {
        mutableBoolean = new MutableBoolean(false);
        assertFalse(mutableBoolean.getValue());
    }

    @Test
    public void testGetValueBooleanTrue() {
        mutableBoolean = new MutableBoolean(Boolean.TRUE);
        assertTrue(mutableBoolean.getValue());
    }

    @Test
    public void testGetValueBooleanFalse() {
        mutableBoolean = new MutableBoolean(Boolean.FALSE);
        assertFalse(mutableBoolean.getValue());
    }

    @Test
    public void testGetValueNull() {
        assertThrows(NullPointerException.class, () -> {
            mutableBoolean = new MutableBoolean(null);
            mutableBoolean.getValue();
        });
    }

    @Test
    public void testGetValueSerialization() {
        mutableBoolean = new MutableBoolean(true);
        MutableBoolean deserialized = (MutableBoolean) SerializationUtils.deserialize(SerializationUtils.serialize(mutableBoolean));
        assertEquals(mutableBoolean.getValue(), deserialized.getValue());
    }

    @Test
    void testToStringWithTrueValue() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        assertEquals("true", mutableBoolean.toString());
    }

    @Test
    void testToStringWithFalseValue() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        assertEquals("false", mutableBoolean.toString());
    }

    @Test
    void testToStringWithNullValue() {
        MutableBoolean mutableBoolean = new MutableBoolean((Boolean) null);
        assertEquals("false", mutableBoolean.toString());
    }

}