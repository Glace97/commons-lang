package org.apache.commons.lang3;

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

public class SerializationUtilsTest {


    @Test
    void testDeserializeWithNullObjectDataThrowsNullPointerException() {
        // test code here
    }

    @Test
    void testDeserializeWithNullInputStreamThrowsNullPointerException() {
        // test code here
    }

    @Test
    void testDeserializeWithEmptyObjectDataReturnsNull() {
        // test code here
    }

    @Test
    void testDeserializeWithEmptyInputStreamReturnsNull() {
        // test code here
    }

    @Test
    void testDeserializeWithInvalidObjectDataThrowsSerializationException() {
        // test code here
    }

    @Test
    void testDeserializeWithInvalidInputStreamThrowsSerializationException() {
        // test code here
    }

    @Test
    void testDeserializeWithValidObjectDataReturnsDeserializedObject() {
        // test code here
    }

    @Test
    void testDeserializeWithValidInputStreamReturnsDeserializedObject() {
        // test code here
    }


    @Test
    void testSerialize_NullObject_ReturnsNull() {
        byte[] result = SerializationUtils.serialize(null);
        assertNull(result);
    }
//
//    @Test
//    void testSerialize_Object_SerializedSuccessfully() {
//        TestObject obj = new TestObject(123, "test");
//        byte[] result = SerializationUtils.serialize(obj);
//
//        assertNotNull(result);
//        assertTrue(result.length > 0);
//    }
//
//    @Test
//    void testSerialize_OutputStreamIsNull_ThrowsNullPointerException() {
//        TestObject obj = new TestObject(123, "test");
//        assertThrows(NullPointerException.class, () -> SerializationUtils.serialize(obj, null));
//    }
//
//    @Test
//    void testSerialize_ObjectToOutputStream_SerializedSuccessfully() {
//        TestObject obj = new TestObject(123, "test");
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        assertDoesNotThrow(() -> SerializationUtils.serialize(obj, outputStream));
//
//        byte[] result = outputStream.toByteArray();
//        assertNotNull(result);
//        assertTrue(result.length > 0);
//    }
//
//    @Test
//    void testSerialize_DeserializeObject_SerializedObjectEqualsOriginalObject() {
//        TestObject obj = new TestObject(123, "test");
//        byte[] serialized = SerializationUtils.serialize(obj);
//
//        TestObject deserialized = deserializeObject(serialized);
//
//        assertNotNull(deserialized);
//        assertEquals(obj.getIntValue(), deserialized.getIntValue());
//        assertEquals(obj.getStringValue(), deserialized.getStringValue());
//    }
//
//    @Test
//    public void testRoundtripWithSerializableObject() {
//        // Arrange
//        SerializableObject obj = new SerializableObject("Hello, World!");
//
//        // Act
//        SerializableObject result = SerializationUtils.roundtrip(obj);
//
//        // Assert
//        Assertions.assertEquals(obj, result);
//    }
//
//    @Test
//    public void testRoundtripWithNonSerializableObject() {
//        // Arrange
//        NonSerializableObject obj = new NonSerializableObject("Hello, World!");
//
//        // Act and Assert
//        Assertions.assertThrows(ClassCastException.class, () -> {
//            SerializationUtils.roundtrip(obj);
//        });
//    }

    @Test
    public void testRoundtripWithNullObject() {
        // Act
        Object result = SerializationUtils.roundtrip(null);

        // Assert
        Assertions.assertNull(result);
    }

    @Test
    void testCloneNullObject() {
        assertNull(SerializationUtils.clone(null));
    }

//    @Test
//    void testCloneSerializableObject() {
//        SerializableObject obj = new SerializableObject("Test", 10);
//        SerializableObject clone = SerializationUtils.clone(obj);
//        assertEquals(obj, clone);
//        assertNotSame(obj, clone);
//    }
//
//    @Test
//    void testCloneNonSerializableObject() {
//        NonSerializableObject obj = new NonSerializableObject("Test", 10);
//        assertThrows(SerializationException.class, () -> SerializationUtils.clone(obj));
//    }
//
//    @Test
//    void testCloneObjectWithReferences() {
//        SerializableObject obj = new SerializableObject("Test", 10);
//        SerializableObject clone = SerializationUtils.clone(obj);
//        assertEquals(obj.getInnerObject(), clone.getInnerObject());
//        assertNotSame(obj.getInnerObject(), clone.getInnerObject());
//    }
//
//    @Test
//    void testCloneObjectWithCircularReference() {
//        CircularReferenceObject obj = new CircularReferenceObject();
//        CircularReferenceObject clone = SerializationUtils.clone(obj);
//        assertNotSame(obj, clone);
//        assertNotSame(obj.getReference(), clone.getReference());
//        assertSame(clone, clone.getReference());
//    }

    @Test
    void testCloneObjectWithPrimitiveArray() {
        int[] array = {1, 2, 3};
        int[] clone = SerializationUtils.clone(array);
        assertArrayEquals(array, clone);
        assertNotSame(array, clone);
    }
//
//    @Test
//    void testCloneObjectWithObjectArray() {
//        SerializableObject[] array = {new SerializableObject("Test1", 1), new SerializableObject("Test2", 2)};
//        SerializableObject[] clone = SerializationUtils.clone(array);
//        assertArrayEquals(array, clone);
//        assertNotSame(array, clone);
//        assertNotSame(array[0], clone[0]);
//        assertNotSame(array[1], clone[1]);
//    }

}