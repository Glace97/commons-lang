package org.apache.commons.lang3.exception;

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

public class ContextedExceptionTest {
    @Test
    void addContextValue_shouldAddValueToContext() {
        String label = "label";
        Object value = "value";
    
        exception.addContextValue(label, value);
    
        assertTrue(exception.getExceptionContext().getContextValues().containsKey(label));
        assertEquals(value, exception.getExceptionContext().getContextValues().get(label));
    }
    
    @Test
    void addContextValue_shouldReturnSameInstance() {
        String label = "label";
        Object value = "value";
    
        ContextedException result = exception.addContextValue(label, value);
    
        assertSame(exception, result);
    }
    
    @Test
    void addContextValue_withNullLabel_shouldThrowException() {
        Object value = "value";
    
        assertThrows(NullPointerException.class, () -> exception.addContextValue(null, value));
    }
    
    @Test
    void addContextValue_withEmptyLabel_shouldThrowException() {
        Object value = "value";
    
        assertThrows(IllegalArgumentException.class, () -> exception.addContextValue("", value));
    }
    
    @Test
    void addContextValue_withNullValue_shouldAddNullToContext() {
        String label = "label";
    
        exception.addContextValue(label, null);
    
        assertTrue(exception.getExceptionContext().getContextValues().containsKey(label));
        assertNull(exception.getExceptionContext().getContextValues().get(label));
    }
    
    @Test
    void addContextValue_withSameLabelAndDifferentValues_shouldStoreMultipleValues() {
        String label = "label";
        Object value1 = "value1";
        Object value2 = "value2";
    
        exception.addContextValue(label, value1);
        exception.addContextValue(label, value2);
    
        Set<Object> values = (Set<Object>) exception.getExceptionContext().getContextValues().get(label);
        assertEquals(2, values.size());
        assertTrue(values.contains(value1));
        assertTrue(values.contains(value2));
    }
    
    @Test
    void addContextValue_withSerializableValue_shouldSerializeValueInContext() {
        String label = "label";
        Pair<String, Integer> value = Pair.of("string", 123);
    
        exception.addContextValue(label, value);
    
        assertTrue(exception.getExceptionContext().getContextValues().containsKey(label));
        assertEquals(value, exception.getExceptionContext().getContextValues().get(label));
    }
    @Test
    void testGetContextLabels_EmptyContext() {
        Set<String> expectedLabels = new HashSet<>();
        Set<String> contextLabels = exception.getContextLabels();
    
        assertEquals(expectedLabels, contextLabels);
    }
    
    @Test
    void testGetContextLabels_SingleLabel() {
        Set<String> expectedLabels = new HashSet<>();
        expectedLabels.add("label1");
    
        exception.exceptionContext = mock(ExceptionContext.class);
        when(exception.exceptionContext.getContextLabels()).thenReturn(expectedLabels);
    
        Set<String> contextLabels = exception.getContextLabels();
    
        assertEquals(expectedLabels, contextLabels);
    }
    
    @Test
    void testGetContextLabels_MultipleLabels() {
        Set<String> expectedLabels = new HashSet<>();
        expectedLabels.add("label1");
        expectedLabels.add("label2");
        expectedLabels.add("label3");
    
        exception.exceptionContext = mock(ExceptionContext.class);
        when(exception.exceptionContext.getContextLabels()).thenReturn(expectedLabels);
    
        Set<String> contextLabels = exception.getContextLabels();
    
        assertEquals(expectedLabels, contextLabels);
    }
    
    @Test
    void testGetContextLabels_NullContext() {
        Set<String> expectedLabels = new HashSet<>();
    
        exception.exceptionContext = null;
    
        Set<String> contextLabels = exception.getContextLabels();
    
        assertEquals(expectedLabels, contextLabels);
    }
    @Test
    @DisplayName("should return an empty list when label does not exist")
    void shouldReturnEmptyListWhenLabelDoesNotExist() {
        List<Object> contextValues = exception.getContextValues("nonexistent");
        Assertions.assertTrue(contextValues.isEmpty());
    }
    
    @Test
    @DisplayName("should return the values associated with the given label")
    void shouldReturnValuesAssociatedWithGivenLabel() {
        String label = "label";
        Object value1 = new Object();
        Object value2 = new Object();
        exception.exceptionContext.addContextValue(label, value1);
        exception.exceptionContext.addContextValue(label, value2);
    
        List<Object> contextValues = exception.getContextValues(label);
    
        Assertions.assertEquals(2, contextValues.size());
        Assertions.assertTrue(contextValues.contains(value1));
        Assertions.assertTrue(contextValues.contains(value2));
    }
    
    @Test
    @DisplayName("should return an empty list when no values are associated with the given label")
    void shouldReturnEmptyListWhenNoValuesAssociatedWithGivenLabel() {
        String label = "label";
        Object value1 = new Object();
        exception.exceptionContext.addContextValue(label, value1);
    
        List<Object> contextValues = exception.getContextValues("nonexistent");
    
        Assertions.assertTrue(contextValues.isEmpty());
    }
    @Test
    void testExceptionWithoutMessageOrCause() {
        List<Pair<String, Object>> contextEntries = exceptionWithoutMessageOrCause.getContextEntries();
        assertNotNull(contextEntries);
        assertTrue(contextEntries.isEmpty());
    }
    
    @Test
    void testExceptionWithMessage() {
        List<Pair<String, Object>> contextEntries = exceptionWithMessage.getContextEntries();
        assertNotNull(contextEntries);
        assertTrue(contextEntries.isEmpty());
    }
    
    @Test
    void testExceptionWithCause() {
        List<Pair<String, Object>> contextEntries = exceptionWithCause.getContextEntries();
        assertNotNull(contextEntries);
        assertTrue(contextEntries.isEmpty());
    }
    
    @Test
    void testExceptionWithMessageAndCause() {
        List<Pair<String, Object>> contextEntries = exceptionWithMessageAndCause.getContextEntries();
        assertNotNull(contextEntries);
        assertTrue(contextEntries.isEmpty());
    }
    
    @Test
    void testExceptionWithCustomContext() {
        List<Pair<String, Object>> contextEntries = exceptionWithCustomContext.getContextEntries();
        assertNotNull(contextEntries);
        assertEquals(1, contextEntries.size());
        Pair<String, Object> entry = contextEntries.get(0);
        assertEquals("Custom Context Entry", entry.getLeft());
        assertEquals("Custom Context Value", entry.getRight());
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class ContextedExceptionTest {
    
        @Test
        void setContextValue_shouldSetContextValue() {
            String label = "label";
            Object value = "value";
    
            // Test logic here
        }
    
        @Test
        void setContextValue_shouldOverrideExistingValue() {
            String label = "label";
            Object value1 = "value1";
            Object value2 = "value2";
    
            // Test logic here
        }
    
        @Test
        void setContextValue_shouldReturnSameInstance() {
            String label = "label";
            Object value = "value";
    
            // Test logic here
        }
    }
    @Test
    void testGetFirstContextValue_ReturnsNullWhenLabelNotFound() {
        String label = "label";
        when(mockContext.getFirstContextValue(label)).thenReturn(null);
    
        Object result = exception.getFirstContextValue(label);
    
        assertNull(result);
        verify(mockContext).getFirstContextValue(label);
    }
    
    @Test
    void testGetFirstContextValue_ReturnsValueWhenLabelFound() {
        String label = "label";
        Object value = new Object();
        when(mockContext.getFirstContextValue(label)).thenReturn(value);
    
        Object result = exception.getFirstContextValue(label);
    
        assertEquals(value, result);
        verify(mockContext).getFirstContextValue(label);
    }
    
    @Test
    void testGetFirstContextValue_CallsMockContextWithCorrectLabel() {
        String label = "label";
    
        exception.getFirstContextValue(label);
    
        verify(mockContext).getFirstContextValue(label);
    }
    
    @Test
    void testGetFirstContextValue_UsesDefaultExceptionContextWhenContextIsNull() {
        exception.exceptionContext = null;
        String label = "label";
    
        exception.getFirstContextValue(label);
    
        assertNotNull(exception.exceptionContext);
    }
    ```java
    import org.junit.jupiter.api.Test;
    
    class ContextedExceptionTest {
    
        @Test
        void shouldReturnFormattedExceptionMessage() {
            // Test implementation here
        }
    }
    ```
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.Test;
    
    class ContextedExceptionTest {
    
        @Test
        void shouldReturnMessageWithoutContext() {
            String message = "Test Message";
            ContextedException exception = new ContextedException(message);
    
            String result = exception.getRawMessage();
    
            assertEquals(message, result);
        }
    
        @Test
        void shouldReturnMessageWithoutContextAndCause() {
            String message = "Test Message";
            Throwable cause = mock(Throwable.class);
            ContextedException exception = new ContextedException(message, cause);
    
            String result = exception.getRawMessage();
    
            assertEquals(message, result);
        }
    
        @Test
        void shouldReturnMessageWithoutContextAndCauseAndCustomContext() {
            String message = "Test Message";
            Throwable cause = mock(Throwable.class);
            ExceptionContext context = mock(ExceptionContext.class);
            ContextedException exception = new ContextedException(message, cause, context);
    
            String result = exception.getRawMessage();
    
            assertEquals(message, result);
        }
    
        @Test
        void shouldReturnMessageWithoutContextAndCustomContext() {
            String message = "Test Message";
            ExceptionContext context = mock(ExceptionContext.class);
            ContextedException exception = new ContextedException(message, context);
    
            String result = exception.getRawMessage();
    
            assertEquals(message, result);
        }
    
        @Test
        void shouldReturnSuperClassMessage() {
            String message = "Test Message";
            ContextedException exception = new ContextedException() {
                @Override
                public String getMessage() {
                    return message;
                }
            };
    
            String result = exception.getRawMessage();
    
            assertEquals(message, result);
        }
    
    }
    
    @Test
    void testGetMessageWithoutMessageOrCause() {
        contextedException = new ContextedException();
        assertEquals("", contextedException.getMessage());
    }
    
    @Test
    void testGetMessageWithMessageWithoutCause() {
        String message = "Test message";
        contextedException = new ContextedException(message);
        assertEquals(message, contextedException.getMessage());
    }
    
    @Test
    void testGetMessageWithMessageAndCause() {
        String message = "Test message";
        Throwable cause = new Throwable("Test cause");
        contextedException = new ContextedException(message, cause);
        String expectedMessage = message + "\nCaused by: " + cause.toString();
        assertEquals(expectedMessage, contextedException.getMessage());
    }
    
    @Test
    void testGetMessageWithMessageCauseAndContext() {
        String message = "Test message";
        Throwable cause = new Throwable("Test cause");
        ExceptionContext context = new DefaultExceptionContext();
        contextedException = new ContextedException(message, cause, context);
        String expectedMessage = message + "\nCaused by: " + cause.toString();
        assertEquals(expectedMessage, contextedException.getMessage());
    }
    
    @Test
    void testGetMessageWithCauseWithoutMessage() {
        Throwable cause = new Throwable("Test cause");
        contextedException = new ContextedException(cause);
        String expectedMessage = "Caused by: " + cause.toString();
        assertEquals(expectedMessage, contextedException.getMessage());
    }

}