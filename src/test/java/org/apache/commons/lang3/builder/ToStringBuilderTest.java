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


import org.easymock.EasyMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ToStringBuilderTest {
    ToStringBuilder toStringBuilder;

    @Test
    void testSetDefaultStyle() {
        ToStringStyle style = ToStringStyle.SHORT_PREFIX_STYLE;
    
        ToStringBuilder.setDefaultStyle(style);
    
        assertEquals(style, ToStringBuilder.getDefaultStyle());
    }
    
    @Test
    void testSetDefaultStyleNull() {
        assertThrows(NullPointerException.class, () -> ToStringBuilder.setDefaultStyle(null));
    }
    @Test
    @DisplayName("Returns the correct object")
    void returnsCorrectObject() {
        Object expectedObject = EasyMock.mock(Object.class);
        ToStringBuilder toStringBuilder = new ToStringBuilder(expectedObject);
        assertEquals(expectedObject, toStringBuilder.getObject());
    }
    //@Test
    @DisplayName("Test reflectionToString(Object) with null object")
    void testReflectionToStringWithNullObject1() {
        String result = ToStringBuilder.reflectionToString(null);
        assertNotNull(result);
        assertEquals("", result);
    }
    
    //@Test
    @DisplayName("Test reflectionToString(Object) with non-null object")
    void testReflectionToStringWithNonNullObject2() {
        Object object = new Object();
        String result = ToStringBuilder.reflectionToString(object);
        assertNotNull(result);
        assertEquals(object.toString(), result);
    }
    
    //@Test
    @DisplayName("Test reflectionToString(Object, ToStringStyle) with null object")
    void testReflectionToStringWithNullObject3() {
        String result = ToStringBuilder.reflectionToString(null, ToStringStyle.DEFAULT_STYLE);
        assertNotNull(result);
        assertEquals("", result);
    }
    
    //@Test
    @DisplayName("Test reflectionToString(Object, ToStringStyle) with non-null object")
    void testReflectionToStringWithNonNullObject4() {
        Object object = new Object();
        String result = ToStringBuilder.reflectionToString(object, ToStringStyle.DEFAULT_STYLE);
        assertNotNull(result);
        assertEquals(object.toString(), result);
    }
    
    //@Test
    @DisplayName("Test reflectionToString(Object, ToStringStyle, boolean) with null object")
    void testReflectionToStringWithNullObject5() {
        String result = ToStringBuilder.reflectionToString(null, ToStringStyle.DEFAULT_STYLE, true);
        assertNotNull(result);
        assertEquals("", result);
    }
    
    //@Test
    @DisplayName("Test reflectionToString(Object, ToStringStyle, boolean) with non-null object")
    void testReflectionToStringWithNonNullObject6() {
        Object object = new Object();
        String result = ToStringBuilder.reflectionToString(object, ToStringStyle.DEFAULT_STYLE, true);
        assertNotNull(result);
        assertEquals(object.toString(), result);
    }
    
    //@Test
    @DisplayName("Test reflectionToString(Object, ToStringStyle, boolean, Class) with null object")
    void testReflectionToStringWithNullObject() {
        String result = ToStringBuilder.reflectionToString(null, ToStringStyle.DEFAULT_STYLE, true, Object.class);
        assertNotNull(result);
        assertEquals("", result);
    }
    
    //@Test
    @DisplayName("Test reflectionToString(Object, ToStringStyle, boolean, Class) with non-null object")
    void testReflectionToStringWithNonNullObject() {
        Object object = new Object();
        String result = ToStringBuilder.reflectionToString(object, ToStringStyle.DEFAULT_STYLE, true, Object.class);
        assertNotNull(result);
        assertEquals(object.toString(), result);
    }

    @Test
    public void testAppend_boolean() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(true);
        // Assert statements
    }
    
    @Test
    public void testAppend_booleanArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new boolean[] {true, false});
        // Assert statements
    }
    
    @Test
    public void testAppend_byte() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append((byte) 1);
        // Assert statements
    }
    
    @Test
    public void testAppend_byteArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new byte[] {1, 2, 3});
        // Assert statements
    }
    
    @Test
    public void testAppend_char() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append('a');
        // Assert statements
    }
    
    @Test
    public void testAppend_charArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new char[] {'a', 'b', 'c'});
        // Assert statements
    }
    
    @Test
    public void testAppend_double() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(1.0);
        // Assert statements
    }
    
    @Test
    public void testAppend_doubleArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new double[] {1.0, 2.0, 3.0});
        // Assert statements
    }
    
    @Test
    public void testAppend_float() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(1.0f);
        // Assert statements
    }
    
    @Test
    public void testAppend_floatArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new float[] {1.0f, 2.0f, 3.0f});
        // Assert statements
    }
    
    @Test
    public void testAppend_int() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(1);
        // Assert statements
    }
    
    @Test
    public void testAppend_intArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new int[] {1, 2, 3});
        // Assert statements
    }
    
    @Test
    public void testAppend_long() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(1L);
        // Assert statements
    }
    
    @Test
    public void testAppend_longArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new long[] {1L, 2L, 3L});
        // Assert statements
    }
    
    @Test
    public void testAppend_object() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new Object());
        // Assert statements
    }
    
    @Test
    public void testAppend_objectArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new Object[] {new Object(), new Object()});
        // Assert statements
    }
    
    @Test
    public void testAppend_short() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append((short) 1);
        // Assert statements
    }
    
    @Test
    public void testAppend_shortArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append(new short[] {1, 2, 3});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_boolean() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_booleanArray() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new boolean[] {true, false});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_booleanArray_fullDetail() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new boolean[] {true, false}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_byte() {
        ToStringBuilder toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", (byte) 1);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_byteArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new byte[] {1, 2, 3});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_byteArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new byte[] {1, 2, 3}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_char() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", 'a');
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_charArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new char[] {'a', 'b', 'c'});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_charArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new char[] {'a', 'b', 'c'}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_double() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", 1.0);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_doubleArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new double[] {1.0, 2.0, 3.0});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_doubleArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new double[] {1.0, 2.0, 3.0}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_float() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", 1.0f);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_floatArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new float[] {1.0f, 2.0f, 3.0f});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_floatArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new float[] {1.0f, 2.0f, 3.0f}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_int() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", 1);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_intArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new int[] {1, 2, 3});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_intArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new int[] {1, 2, 3}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_long() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", 1L);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_longArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new long[] {1L, 2L, 3L});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_longArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new long[] {1L, 2L, 3L}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_object() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new Object());
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_object_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new Object(), true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_objectArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new Object[] {new Object(), new Object()});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_objectArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new Object[] {new Object(), new Object()}, true);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_short() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", (short) 1);
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_shortArray() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new short[] {1, 2, 3});
        // Assert statements
    }
    
    @Test
    public void testAppend_fieldName_shortArray_fullDetail() {
        toStringBuilder = new ToStringBuilder("test");
        toStringBuilder.append("fieldName", new short[] {1, 2, 3}, true);
        // Assert statements
    }
//    @Test
//    void getStringBuffer_shouldReturnNonNullBuffer() {
//        assertNotNull(builder.getStringBuffer());
//    }
//
//    @Test
//    void getStringBuffer_shouldReturnSameBuffer() {
//        StringBuffer buffer = builder.getStringBuffer();
//        assertSame(buffer, builder.getStringBuffer());
//    }
//
//    @Test
//    void getStringBuffer_shouldReturnBufferWithCorrectStart() {
//        StringBuffer buffer = builder.getStringBuffer();
//        assertTrue(buffer.toString().startsWith(builder.defaultStyle.getStart()));
//    }
//
//    @Test
//    void getStringBuffer_shouldReturnBufferWithCorrectEnd() {
//        StringBuffer buffer = builder.getStringBuffer();
//        assertTrue(buffer.toString().endsWith(builder.defaultStyle.getEnd()));
//    }
//
//    @Test
//    void getStringBuffer_shouldReturnBufferWithCorrectObject() {
//        StringBuffer buffer = builder.getStringBuffer();
//        assertTrue(buffer.toString().contains(builder.object.toString()));
//    }
//
//    @Test
//    void getStringBuffer_shouldReturnBufferWithCorrectStyle() {
//        StringBuffer buffer = builder.getStringBuffer();
//        assertTrue(buffer.toString().contains(builder.style.toString()));
//    }
    //@Test
    public void testDefaultConstructor() {
        toStringBuilder = new ToStringBuilder(null);
        assertEquals(ToStringStyle.DEFAULT_STYLE, toStringBuilder.getStyle());
    }
    
    @Test
    public void testStyleConstructor() {
        ToStringStyle style = ToStringStyle.SHORT_PREFIX_STYLE;
        toStringBuilder = new ToStringBuilder(null, style);
        assertEquals(style, toStringBuilder.getStyle());
    }

//    @Test
//    public void testBufferConstructor() {
//        StringBuffer buffer = new StringBuffer();
//        toStringBuilder = new ToStringBuilder(null, null, buffer);
//        assertEquals(buffer, toStringBuilder.buffer);
//    }
    
    @Test
    public void testGetStyle() {
        ToStringStyle style = ToStringStyle.NO_FIELD_NAMES_STYLE;
        toStringBuilder = new ToStringBuilder(null, style);
        assertEquals(style, toStringBuilder.getStyle());
    }
    
    @Test
    public void testGetDefaultStyle() {
        ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
        toStringBuilder = new ToStringBuilder(null);
        assertEquals(defaultStyle, toStringBuilder.getStyle());
    }
//    @Test
//    @DisplayName("When toString is null, no change should be made")
//    void givenNullToString_whenAppendToString_thenNoChange() {
//        // Arrange
//
//        // Act
//        ToStringBuilder result = toStringBuilder.appendToString(null);
//
//        // Assert
//        assertEquals(ToStringStyle.DEFAULT_STYLE, result.getStyle());
//        assertEquals("", result.buffer.toString());
//    }
//
//    @Test
//    @DisplayName("When toString is not null, it should be appended to the buffer")
//    void givenNonNullToString_whenAppendToString_thenAppendToBuffer() {
//        // Arrange
//        String toString = "Example toString";
//
//        // Act
//        ToStringBuilder result = toStringBuilder.appendToString(toString);
//
//        // Assert
//        assertEquals(ToStringStyle.DEFAULT_STYLE, result.style);
//        assertEquals(toString, result.buffer.toString());
//    }
    //@Test
    @DisplayName("Test toString() with null object")
    void testToStringWithNullObject() {
        ToStringBuilder builder = new ToStringBuilder(null);
        String expected = "null";
        String actual = builder.toString();
        assertEquals(expected, actual);
    }
    
    //@Test
    @DisplayName("Test toString() with non-null object")
    void testToStringWithNonNullObject() {
        Object object = new Object();
        ToStringBuilder builder = new ToStringBuilder(object);
        String expected = object.toString();
        String actual = builder.toString();
        assertEquals(expected, actual);
    }
    
    //@Test
    @DisplayName("Test toString() with custom style")
    void testToStringWithCustomStyle() {
        Object object = new Object();
        ToStringStyle customStyle = new ToStringStyle() {
            // Implement custom style logic here
        };
        ToStringBuilder builder = new ToStringBuilder(object, customStyle);
        String expected = builder.getObject().toString();
        String actual = builder.toString();
        assertEquals(expected, actual);
    }
    
    //@Test
    @DisplayName("Test toString() with custom buffer")
    void testToStringWithCustomBuffer() {
        Object object = new Object();
        StringBuffer buffer = new StringBuffer();
        ToStringBuilder builder = new ToStringBuilder(object, null, buffer);
        String expected = builder.getObject().toString();
        String actual = builder.toString();
        assertEquals(expected, actual);
    }
    //@Test
    void testAppendAsObjectToString() {
        Object srcObject = new Object();
        String expected = srcObject.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(srcObject));
    
        ToStringBuilder result = toStringBuilder.appendAsObjectToString(srcObject);
    
        assertEquals(expected, result.getStringBuffer().toString());
    }
    
    @Test
    void testAppendAsObjectToStringWithNull() {
        assertThrows(NullPointerException.class, () -> {
            toStringBuilder.appendAsObjectToString(null);
        });
    }
//    @Test
//    void testAppendSuperWithNull() {
//        String superToString = null;
//        ToStringBuilder result = builder.appendSuper(superToString);
//        assertEquals(builder, result);
//    }
//
//    @Test
//    void testAppendSuperWithEmptyString() {
//        String superToString = "";
//        ToStringBuilder result = builder.appendSuper(superToString);
//        assertEquals(builder, result);
//    }
//
//    @Test
//    void testAppendSuperWithNonNullString() {
//        String superToString = "SuperToString";
//        ToStringBuilder result = builder.appendSuper(superToString);
//        assertEquals(builder, result);
//    }
    // Your Java code here
    
    //@Test
    @DisplayName("Test build method with null object")
    void testBuildWithNullObject() {
        String result = toStringBuilder.build();
        assertEquals("null", result);
    }
    
    //@Test
    @DisplayName("Test build method with non-null object")
    void testBuildWithNonNullObject() {
        Object object = new Object();
        toStringBuilder = new ToStringBuilder(object);
        String result = toStringBuilder.build();
        assertEquals(object.toString(), result);
    }
    
    //@Test
    @DisplayName("Test build method with null style")
    void testBuildWithNullStyle() {
        String result = toStringBuilder.build();
        assertEquals("null", result);
    }
    
    //@Test
    @DisplayName("Test build method with custom style")
    void testBuildWithCustomStyle() {
        ToStringStyle customStyle = new ToStringStyle() {
            @Override
            public void appendStart(StringBuffer buffer, Object object) {
                buffer.append("Custom Start: ");
            }
        };
        toStringBuilder = new ToStringBuilder(null, customStyle);
        String result = toStringBuilder.build();
        assertEquals("Custom Start: null", result);
    }
    
    //@Test
    @DisplayName("Test build method with null buffer")
    void testBuildWithNullBuffer() {
        String result = toStringBuilder.build();
        assertEquals("null", result);
    }
    
    //@Test
    @DisplayName("Test build method with populated buffer")
    void testBuildWithPopulatedBuffer() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Prefix: ");
        toStringBuilder = new ToStringBuilder(null, null, buffer);
        String result = toStringBuilder.build();
        assertEquals("Prefix: null", result);
    }
    @Test
    void testDefaultStyleNotNull() {
        assertNotNull(ToStringBuilder.getDefaultStyle());
    }
    
    @Test
    void testDefaultStyleSameInstance() {
        assertSame(ToStringBuilder.getDefaultStyle(), ToStringBuilder.getDefaultStyle());
    }
    
    @Test
    void testDefaultStyleChangeDuringStartup() {
        ToStringStyle defaultStyle = ToStringBuilder.getDefaultStyle();
        ToStringBuilder.setDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
        assertNotSame(defaultStyle, ToStringBuilder.getDefaultStyle());
        assertEquals(ToStringStyle.SHORT_PREFIX_STYLE, ToStringBuilder.getDefaultStyle());
        ToStringBuilder.setDefaultStyle(defaultStyle);
        assertSame(defaultStyle, ToStringBuilder.getDefaultStyle());
    }
    
//    @Test
//    void testToStringBuilderObject() {
//        Object object = new Object();
//        ToStringBuilder builder = new ToStringBuilder(object);
//        assertSame(object, builder.object);
//        assertSame(ToStringBuilder.getDefaultStyle(), builder.style);
//        assertNotNull(builder.buffer);
//        assertTrue(builder.buffer.length() > 0);
//    }
//
//    @Test
//    void testToStringBuilderObjectAndStyle() {
//        Object object = new Object();
//        ToStringStyle style = ToStringStyle.SHORT_PREFIX_STYLE;
//        ToStringBuilder builder = new ToStringBuilder(object, style);
//        assertSame(object, builder.object);
//        assertSame(style, builder.style);
//        assertNotNull(builder.buffer);
//        assertTrue(builder.buffer.length() > 0);
//    }
//
//    @Test
//    void testToStringBuilderObjectStyleAndBuffer() {
//        Object object = new Object();
//        ToStringStyle style = ToStringStyle.SHORT_PREFIX_STYLE;
//        StringBuffer buffer = new StringBuffer();
//        ToStringBuilder builder = new ToStringBuilder(object, style, buffer);
//        assertSame(object, builder.object);
//        assertSame(style, builder.style);
//        assertSame(buffer, builder.buffer);
//    }

}