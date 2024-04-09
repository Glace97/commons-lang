package org.apache.commons.lang3.builder;

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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectionTest {
//    @Test
//    void testGetUnchecked() throws NoSuchFieldException {
//        // Create an object for testing
//        TestObject testObject = new TestObject();
//        testObject.publicField = "publicField";
//        setPrivateField(testObject, "privateField", "privateFieldValue");
//
//        // Test public field
//        Field publicField = testObject.getClass().getField("publicField");
//        Object result1 = Reflection.getUnchecked(publicField, testObject);
//        assertEquals("publicField", result1);
//
//        // Test private field
//        Field privateField = testObject.getClass().getDeclaredField("privateField");
//        privateField.setAccessible(true);
//        Object result2 = Reflection.getUnchecked(privateField, testObject);
//        assertEquals("privateFieldValue", result2);
//    }
//
//    @Test
//    void testGetUncheckedWithNullField() {
//        assertThrows(NullPointerException.class, () ->
//                Reflection.getUnchecked(null, new TestObject()));
//    }
//
//    @Test
//    void testGetUncheckedWithNullObject() throws NoSuchFieldException {
//        Field field = TestObject.class.getField("publicField");
//        Assertions.assertThrows(NullPointerException.class, () ->
//                Reflection.getUnchecked(field, null));
//    }
//
//    @Test
//    void testGetUncheckedWithIllegalAccess() throws NoSuchFieldException {
//        Field privateField = TestObject.class.getDeclaredField("privateField");
//        Assertions.assertThrows(IllegalArgumentException.class, () ->
//                Reflection.getUnchecked(privateField, new TestObject()));
//    }

}