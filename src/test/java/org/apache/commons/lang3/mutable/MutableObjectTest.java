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

}