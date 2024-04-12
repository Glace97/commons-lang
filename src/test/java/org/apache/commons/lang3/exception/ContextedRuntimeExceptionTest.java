package org.apache.commons.lang3.exception;

import static javax.management.Query.times;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.verify;
import java.util.List;
import static org.easymock.bytebuddy.matcher.ElementMatchers.any;
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


import org.apache.commons.lang3.tuple.Pair;
import org.easymock.Mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ContextedRuntimeExceptionTest {
    Mock exceptionContextMock = createMock(ContextedRuntimeException.class);
    ContextedRuntimeException exception;


    @BeforeEach
    void setUp(){
        exception = new ContextedRuntimeException();
    }

    //@Test
    void testAddContextValue_ValidLabelAndValue_ReturnsThis() {
        ContextedRuntimeException result = exception.addContextValue("label", "value");

        assertEquals(exception, result);
    }

    //@Test
    void testAddContextValue_NullLabelAndValue_ReturnsThis() {
        ContextedRuntimeException result = exception.addContextValue(null, null);

        assertEquals(exception, result);
    }

//    @Test
//    void testAddContextValue_NullLabelAndValidValue_CallsAddContextValueWithNullLabel() {
//        exception.addContextValue(null, "value");
//
//        verify(exceptionContextMock, times(1)).addContextValue(null, "value");
//    }
//
//    @Test
//    void testAddContextValue_ValidLabelAndNullValue_CallsAddContextValueWithNullValue() {
//        exception.addContextValue("label", null);
//
//        verify(exceptionContextMock, times(1)).addContextValue("label", null);
//    }
//
//    @Test
//    void testAddContextValue_ValidLabelAndValue_CallsAddContextValueWithLabelAndValue() {
//        exception.addContextValue("label", "value");
//
//        verify(exceptionContextMock, times(1)).addContextValue("label", "value");
//    }

//    @Test
//    void testAddContextValue_MultipleCallsWithSameLabel_CallsAddContextValueMultipleTimes() {
//        exception.addContextValue("label", "value1");
//        exception.addContextValue("label", "value2");
//
//        verify(exceptionContextMock, times(2)).addContextValue("label", any());
//    }

    //@Test
    void testGetContextLabels_EmptyContext() {
        // Test code here
    }

    //@Test
    void testGetContextLabels_SingleLabel() {
        // Test code here
    }

    //@Test
    void testGetContextLabels_MultipleLabels() {
        // Test code here
    }

    //@Test
    void testGetContextLabels_DuplicateLabels() {
        // Test code here
    }

    //@Test
    void testGetContextLabels_NullContext() {
        // Test code here
    }

    //@Test
    void testGetContextLabels_CustomContext() {
        // Test code here
    }

    //@Test
    void testGetContextValues_ReturnsEmptyList_WhenLabelDoesNotExist() {
        List<Object> values = exception.getContextValues("nonexistent");
        assertTrue(values.isEmpty());
    }
//
//    @Test
//    void testGetContextValues_ReturnsValues_WhenLabelExists() {
//        String label = "label";
//        Object value1 = new Object();
//        Object value2 = new Object();
//        exception.exceptionContext.addContextValue(label, value1);
//        exception.exceptionContext.addContextValue(label, value2);
//
//        List<Object> values = exception.getContextValues(label);
//
//        Assertions.assertEquals(2, values.size());
//        Assertions.assertTrue(values.contains(value1));
//        Assertions.assertTrue(values.contains(value2));
//    }

    //@Test
    void testGetContextValues_ReturnsEmptyList_WhenNoValuesAdded() {
        String label = "label";

        List<Object> values = exception.getContextValues(label);

        assertTrue(values.isEmpty());
    }

//    @Test
//    void testGetContextEntries() {
//        List<Pair<String, Object>> entries = List.of(Pair.of("key1", "value1"), Pair.of("key2", "value2"));
//        when(context.getContextEntries()).thenReturn(entries);
//
//        List<Pair<String, Object>> result = exception.getContextEntries();
//
//        assertEquals(entries, result);
//        verify(context).getContextEntries();
//    }

//    @Test
//    void testGetContextEntriesDefaultImplementation() {
//        exception = new ContextedRuntimeException("Test message", new RuntimeException());
//
//        List<Pair<String, Object>> result = exception.getContextEntries();
//
//        assertEquals(List.of(), result);
//    }

//    // Test functions:
//    @Test
//    void testSetContextValue_setsValue() {
//        exception = new ContextedRuntimeException();
//        exception.setContextValue("label", "value");
//
//        assertEquals("value", exception.exceptionContext.getContextValue("label"));
//    }
//
//    @Test
//    void testSetContextValue_overridesExistingValue() {
//        exception = new ContextedRuntimeException();
//        exception.setContextValue("label", "value1");
//        exception.setContextValue("label", "value2");
//
//        assertEquals("value2", exception.exceptionContext.getContextValue("label"));
//    }

    //@Test
    void testSetContextValue_returnsThis() {
        exception = new ContextedRuntimeException();
        ContextedRuntimeException result = exception.setContextValue("label", "value");

        assertEquals(exception, result);
    }

//    @Test
//    void testSetContextValue_handlesNullLabel() {
//        exception = new ContextedRuntimeException();
//        exception.setContextValue(null, "value");
//
//        assertNull(exception.exceptionContext.getContextValue(null));
//    }
//
//    @Test
//    void testSetContextValue_handlesNullValue() {
//        exception = new ContextedRuntimeException();
//        exception.setContextValue("label", null);
//
//        assertNull(exception.exceptionContext.getContextValue("label"));
//    }
//
//    @Test
//    void testSetContextValue_handlesSerializableValues() {
//        exception = new ContextedRuntimeException();
//        exception.setContextValue("label", Pair.of("key", "value"));
//
//        assertEquals(Pair.of("key", "value"), exception.exceptionContext.getContextValue("label"));
//    }
//
//    @Test
//    void testGetFirstContextValue() {
//        // Test with empty label
//        assertNull(exception.getFirstContextValue(""));
//
//        // Test with non-existent label
//        assertNull(exception.getFirstContextValue("non-existent-label"));
//
//        // Test with label that exists
//        String label = "label";
//        Object value = "value";
//        exception.exceptionContext.addContextValue(label, value);
//        assertEquals(value, exception.getFirstContextValue(label));
//
//        // Test with multiple values for the same label
//        String label2 = "label2";
//        Object value2 = "value2";
//        exception.exceptionContext.addContextValue(label, value2);
//        assertEquals(value, exception.getFirstContextValue(label));
//
//        // Test with multiple labels
//        exception.exceptionContext.addContextValue(label2, value);
//        assertEquals(value, exception.getFirstContextValue(label2));
//    }



    //@Test
    void withNullBaseMessage() {
        String formattedMessage = exception.getFormattedExceptionMessage(null);
        assertNull(formattedMessage);
    }

    //@Test
    void withEmptyBaseMessage() {
        String formattedMessage = exception.getFormattedExceptionMessage("");
        assertNull(formattedMessage);
    }

    //@Test
    void withNonEmptyBaseMessage() {
        String baseMessage = "Base Message";
        String formattedMessage = exception.getFormattedExceptionMessage(baseMessage);
        assertNotNull(formattedMessage);
        assertTrue(formattedMessage.contains(baseMessage));
    }

//
//    //@Test
//    void testGetRawMessageWithNullMessage() {
//        ContextedRuntimeException exception = new ContextedRuntimeException(null);
//        assertNull(exception.getRawMessage());
//    }

    //@Test
    void testGetRawMessageWithEmptyMessage() {
        ContextedRuntimeException exception = new ContextedRuntimeException("");
        assertEquals("", exception.getRawMessage());
    }

    //@Test
    void testGetRawMessageWithNonNullMessage() {
        String message = "Test Exception";
        ContextedRuntimeException exception = new ContextedRuntimeException(message);
        assertEquals(message, exception.getRawMessage());
    }

    //@Test
    void testGetMessage_NullMessage_ReturnsFormattedMessage() {
        assertNull(exception.getMessage());
    }

    //@Test
    void testGetMessage_EmptyMessage_ReturnsFormattedMessage() {
        exception = new ContextedRuntimeException("");
        assertEquals("", exception.getMessage());
    }

    //@Test
    void testGetMessage_Message_ReturnsFormattedMessage() {
        exception = new ContextedRuntimeException("Test message");
        assertEquals("Test message", exception.getMessage());
    }

    //@Test
    void testGetMessage_WithCause_ReturnsFormattedMessage() {
        exception = new ContextedRuntimeException("Test message", new RuntimeException());
        assertEquals("Test message", exception.getMessage());
    }
//
//    //@Test
//    void testGetMessage_WithCauseAndContext_ReturnsFormattedMessage() {
//        exception = new ContextedRuntimeException("Test message", new RuntimeException(), new ExceptionContext());
//        assertEquals("Test message", exception.getMessage());
//    }

    //@Test
    void testGetMessage_WithCauseAndNullContext_ReturnsFormattedMessage() {
        exception = new ContextedRuntimeException("Test message", new RuntimeException(), null);
        assertEquals("Test message", exception.getMessage());
    }

//    @Test
//    void testGetMessage_WithNullCause_ReturnsFormattedMessage() {
//        exception = new ContextedRuntimeException(null);
//        assertNull(exception.getMessage());
//    }

}