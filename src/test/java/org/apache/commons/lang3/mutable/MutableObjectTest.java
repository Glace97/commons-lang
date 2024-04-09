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

public class MutableObjectTest {
    @Test
    void testHashCodeNullValue() {
        MutableObject obj = new MutableObject();
        assertEquals(0, obj.hashCode());
    }
    
    @Test
    void testHashCodeNonNullValue() {
        MutableObject obj = new MutableObject("test");
        assertNotEquals(0, obj.hashCode());
    }
    
    @Test
    void testHashCodeEqualObjects() {
        MutableObject obj1 = new MutableObject("test");
        MutableObject obj2 = new MutableObject("test");
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }
    
    @Test
    void testHashCodeDifferentObjects() {
        MutableObject obj1 = new MutableObject("test1");
        MutableObject obj2 = new MutableObject("test2");
        assertNotEquals(obj1.hashCode(), obj2.hashCode());
    }
    
    @Test
    void testHashCodeEqualObjectsWithNullValue() {
        MutableObject obj1 = new MutableObject();
        MutableObject obj2 = new MutableObject();
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }
//    @Test
//    public void testEqualsWithSameObject() {
//        Assertions.assertTrue(mutableObject.equals(mutableObject));
//    }
//
//    @Test
//    public void testEqualsWithNull() {
//        Assertions.assertFalse(mutableObject.equals(null));
//    }
//
//    @Test
//    public void testEqualsWithDifferentClass() {
//        Assertions.assertFalse(mutableObject.equals(new Object()));
//    }
//
//
//
//    @Test
//    public void testEqualsWithSameValue() {
//        MutableObject<Integer> otherMutableObject = new MutableObject<>(mutableObject.getValue());
//        Assertions.assertTrue(mutableObject.equals(otherMutableObject));
//    }
//
//    @Test
//    public void testEqualsWithDifferentValue() {
//        MutableObject<Integer> otherMutableObject = new MutableObject<>(5);
//        Assertions.assertFalse(mutableObject.equals(otherMutableObject));
//    }
//
//    @Test
//    public void testEqualsWithNullValue() {
//        MutableObject<Integer> otherMutableObject = new MutableObject<>(null);
//        Assertions.assertFalse(mutableObject.equals(otherMutableObject));
//    }
//
//    @Test
//    public void testEqualsWithDifferentGenericType() {
//        MutableObject<String> otherMutableObject = new MutableObject<>("test");
//        Assertions.assertFalse(mutableObject.equals(otherMutableObject));
//    }
//    @Test
//    @DisplayName("Set value with non-null input")
//    void testSetValueWithNonNullInput() {
//        mutableObject.setValue("Test");
//        assertEquals("Test", mutableObject.getValue());
//    }
//
//    @Test
//    @DisplayName("Set value with null input")
//    void testSetValueWithNullInput() {
//        mutableObject.setValue(null);
//        assertNull(mutableObject.getValue());
//    }
    @Test
    void shouldReturnNullWhenValueIsNull() {
        MutableObject<String> obj = new MutableObject<>(null);
        assertNull(obj.getValue());
    }
    
    @Test
    void shouldReturnValueWhenValueIsNotNull() {
        MutableObject<String> obj = new MutableObject<>("test");
        assertEquals("test", obj.getValue());
    }
    
    @Test
    void shouldReturnValueAfterSettingValue() {
        MutableObject<String> obj = new MutableObject<>();
        obj.setValue("test");
        assertEquals("test", obj.getValue());
    }
//    @Test
//    @DisplayName("Test toString with null value")
//    void testToStringWithNullValue() {
//        String expected = "null";
//        String actual = mutableObject.toString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Test toString with non-null value")
//    void testToStringWithNonNullValue() {
//        String expected = "Hello";
//        mutableObject = new MutableObject<>("Hello");
//        String actual = mutableObject.toString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Test toString with custom object value")
//    void testToStringWithCustomObjectValue() {
//        String expected = "CustomObject";
//        MutableObject<CustomObject> customObjectMutableObject = new MutableObject<>(new CustomObject());
//        String actual = customObjectMutableObject.toString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Test toString with empty string value")
//    void testToStringWithEmptyStringValue() {
//        String expected = "";
//        mutableObject = new MutableObject<>("");
//        String actual = mutableObject.toString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Test toString with long value")
//    void testToStringWithLongValue() {
//        String expected = "100";
//        mutableObject = new MutableObject<>(100L);
//        String actual = mutableObject.toString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Test toString with double value")
//    void testToStringWithDoubleValue() {
//        String expected = "3.14";
//        mutableObject = new MutableObject<>(3.14);
//        String actual = mutableObject.toString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Test toString with boolean value")
//    void testToStringWithBooleanValue() {
//        String expected = "true";
//        mutableObject = new MutableObject<>(true);
//        String actual = mutableObject.toString();
//        assertEquals(expected, actual);
//    }

}