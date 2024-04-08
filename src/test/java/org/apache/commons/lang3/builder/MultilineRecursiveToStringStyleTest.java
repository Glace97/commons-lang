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

public class MultilineRecursiveToStringStyleTest {
    @Test
    void testAppendDetail_booleanArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        boolean[] array = {true, false, true};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [true, false, true]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_byteArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        byte[] array = {1, 2, 3};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [1, 2, 3]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_charArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        char[] array = {'a', 'b', 'c'};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [a, b, c]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_doubleArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        double[] array = {1.0, 2.0, 3.0};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [1.0, 2.0, 3.0]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_floatArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        float[] array = {1.0f, 2.0f, 3.0f};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [1.0, 2.0, 3.0]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_intArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        int[] array = {1, 2, 3};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [1, 2, 3]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_longArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        long[] array = {1L, 2L, 3L};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [1, 2, 3]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_objectArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        Object[] array = {"a", "b", "c"};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [a, b, c]", buffer.toString());
    }
    
    @Test
    void testAppendDetail_shortArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        short[] array = {1, 2, 3};
        
        style.appendDetail(buffer, fieldName, array);
        
        // Assert the expected output
        assertEquals("array = [1, 2, 3]", buffer.toString());
    }
    @Test
    void testReflectionAppendArrayDetail() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        Object array = new Object[] {1, 2, 3};
    
        style.reflectionAppendArrayDetail(buffer, fieldName, array);
    
        String expected = "array={1,2,3}";
        assertEquals(expected, buffer.toString());
    }
    
    @Test
    void testReflectionAppendArrayDetailWithEmptyArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        Object array = new Object[0];
    
        style.reflectionAppendArrayDetail(buffer, fieldName, array);
    
        String expected = "array={}";
        assertEquals(expected, buffer.toString());
    }
    
    @Test
    void testReflectionAppendArrayDetailWithNullArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        Object array = null;
    
        style.reflectionAppendArrayDetail(buffer, fieldName, array);
    
        String expected = "array=null";
        assertEquals(expected, buffer.toString());
    }
    
    @Test
    void testReflectionAppendArrayDetailWithNestedArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        Object array = new Object[] {new Object[] {1, 2}, new Object[] {3, 4}};
    
        style.reflectionAppendArrayDetail(buffer, fieldName, array);
    
        String expected = "array={{1,2},{3,4}}";
        assertEquals(expected, buffer.toString());
    }

}