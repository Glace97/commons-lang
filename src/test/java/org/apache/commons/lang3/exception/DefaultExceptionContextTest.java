package org.apache.commons.lang3.exception;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DefaultExceptionContextTest {
    // Filtered code:

//    @Test
//    void testAddContextValue_shouldAddLabelValuePair() {
//        // Arrange
//        String label = "label";
//        Object value = "value";
//
//        // Act
//        DefaultExceptionContext result = exceptionContext.addContextValue(label, value);
//
//        // Assert
//        assertEquals(1, result.contextValues.size());
//        assertEquals(label, result.contextValues.get(0).getKey());
//        assertEquals(value, result.contextValues.get(0).getValue());
//    }

    private final String label = "label";
    private final String value1 = "value1";
    private final String value2 = "value2";
    @Test
    void testAddContextValue_shouldReturnSameInstance() {
        // Arrange
        String label = "label";
        Object value = "value";

        // Act
        DefaultExceptionContext result = exceptionContext.addContextValue(label, value);

        // Assert
        assertEquals(exceptionContext, result);
    }

    @Test
    @DisplayName("Test getContextLabels method with empty contextValues")
    void testGetContextLabelsEmpty() {
        DefaultExceptionContext context = new DefaultExceptionContext();
        Set<String> labels = context.getContextLabels();
        assertTrue(labels.isEmpty());
    }
//
//    @Test
//    @DisplayName("Test getContextLabels method with non-empty contextValues")
//    void testGetContextLabelsNonEmpty() {
//        DefaultExceptionContext context = new DefaultExceptionContext();
//        context.contextValues.add(new ImmutablePair<String, Object>("label1", "data1"));
//        context.contextValues.add(new ImmutablePair<String, Object>("label2", "data2"));
//        Set<String> labels = context.getContextLabels();
//        assertEquals(2, labels.size());
//        assertTrue(labels.contains("label1"));
//        assertTrue(labels.contains("label2"));
//    }

//    @Test
//    @DisplayName("Test getContextLabels method with duplicated labels")
//    void testGetContextLabelsDuplicatedLabels() {
//        DefaultExceptionContext context = new DefaultExceptionContext();
//        context.contextValues.add(new ImmutablePair<String, Object>("label1", "data1"));
//        context.contextValues.add(new ImmutablePair<String, Object>("label1", "data2"));
//        Set<String> labels = context.getContextLabels();
//        assertEquals(1, labels.size());
//        assertTrue(labels.contains("label1"));
//    }
//
//    @Test
//    @DisplayName("Test getContextLabels method with null labels")
//    void testGetContextLabelsNullLabels() {
//        context = new DefaultExceptionContext();
//        context.contextValues.add(new ImmutablePair<String, Object>(null, "data1"));
//        context.contextValues.add(new ImmutablePair<String, Object>(null, "data2"));
//        Set<String> labels = context.getContextLabels();
//        assertEquals(1, labels.size());
//        assertTrue(labels.contains(null));
//    }
//
//    @Test
//    @DisplayName("Test getContextLabels method with null values")
//    void testGetContextLabelsNullValues() {
//        context = new DefaultExceptionContext();
//        context.contextValues.add(new ImmutablePair<String, Object>("label1", null));
//        context.contextValues.add(new ImmutablePair<String, Object>("label2", null));
//        Set<String> labels = context.getContextLabels();
//        assertEquals(2, labels.size());
//        assertTrue(labels.contains("label1"));
//        assertTrue(labels.contains("label2"));
//    }
//
//    @Test
//    @DisplayName("Test getContextLabels method with empty values")
//    void testGetContextLabelsEmptyValues() {
//        context = new DefaultExceptionContext();
//        context.contextValues.add(new ImmutablePair<String, Object>("label1", ""));
//        context.contextValues.add(new ImmutablePair<String, Object>("label2", ""));
//        Set<String> labels = context.getContextLabels();
//        assertEquals(2, labels.size());
//        assertTrue(labels.contains("label1"));
//        assertTrue(labels.contains("label2"));
//    }

    @Test
    void testGetContextValues_ReturnsEmptyList_WhenNoValuesAdded() {
        List<Object> values = exceptionContext.getContextValues("label");
        assertTrue(values.isEmpty());
    }

//    @Test
//    void testGetContextValues_ReturnsCorrectValues_WhenAddedValues() {
//        exceptionContext.contextValues.add(new ImmutablePair<>("label", "value1"));
//        exceptionContext.contextValues.add(new ImmutablePair<>("label", "value2"));
//
//        List<Object> values = exceptionContext.getContextValues("label");
//        assertEquals(2, values.size());
//        assertTrue(values.contains("value1"));
//        assertTrue(values.contains("value2"));
//    }
//
//    @Test
//    void testGetContextValues_ReturnsEmptyList_WhenDifferentLabel() {
//        exceptionContext.contextValues.add(new ImmutablePair<>("label1", "value1"));
//        exceptionContext.contextValues.add(new ImmutablePair<>("label2", "value2"));
//
//        List<Object> values = exceptionContext.getContextValues("label");
//        assertTrue(values.isEmpty());
//    }
//
//    @Test
//    void testGetContextValues_ReturnsEmptyList_WhenNullLabel() {
//        exceptionContext.contextValues.add(new ImmutablePair<>("label", "value1"));
//
//        List<Object> values = exceptionContext.getContextValues(null);
//        assertTrue(values.isEmpty());
//    }
//
//    @Test
//    void testGetContextValues_ReturnsEmptyList_WhenEmptyLabel() {
//        exceptionContext.contextValues.add(new ImmutablePair<>("label", "value1"));
//
//        List<Object> values = exceptionContext.getContextValues("");
//        assertTrue(values.isEmpty());
//    }
//
//    @Test
//    void testGetContextValues_ReturnsEmptyList_WhenCaseSensitiveLabel() {
//        exceptionContext.contextValues.add(new ImmutablePair<>("label", "value1"));
//
//        List<Object> values = exceptionContext.getContextValues("Label");
//        assertTrue(values.isEmpty());
//    }


    private DefaultExceptionContext exceptionContext;

//    @BeforeEach
//    void setUp() {
//        exceptionContext = new DefaultExceptionContext();
//    }


    @Test
    @DisplayName("returns an empty list when no entries are added")
    void returnsEmptyListWhenNoEntriesAdded() {
        List<Pair<String, Object>> entries = exceptionContext.getContextEntries();
        assertTrue(entries.isEmpty());
    }

//    @Test
//    @DisplayName("returns a list with the added entries")
//    void returnsListWithAddedEntries() {
//        exceptionContext.contextValues.add(new ImmutablePair<>("key1", "value1"));
//        exceptionContext.contextValues.add(new ImmutablePair<>("key2", "value2"));
//
//        List<Pair<String, Object>> entries = exceptionContext.getContextEntries();
//
//        assertEquals(2, entries.size());
//        assertEquals("key1", entries.get(0).getKey());
//        assertEquals("value1", entries.get(0).getValue());
//        assertEquals("key2", entries.get(1).getKey());
//        assertEquals("value2", entries.get(1).getValue());
//    }

    @Test
    @DisplayName("returns a new list instance each time")
    void returnsNewListInstanceEachTime() {
        List<Pair<String, Object>> entries1 = exceptionContext.getContextEntries();
        List<Pair<String, Object>> entries2 = exceptionContext.getContextEntries();

        assertNotSame(entries1, entries2);
    }

    @Test
    void test1() {
        // test function 1
    }

    @Test
    void test2() {
        // test function 2
    }

    // @Test test functions

//    @Test
//    void shouldAddContextValue() {
//        // Arrange
//        String label = "testLabel";
//        Object value = "testValue";
//
//        // Act
//        exceptionContext.setContextValue(label, value);
//
//        // Assert
//        List<Pair<String, Object>> contextValues = exceptionContext.getContextValues();
//        assertEquals(1, contextValues.size());
//        assertEquals(label, contextValues.get(0).getKey());
//        assertEquals(value, contextValues.get(0).getValue());
//    }
//
//    @Test
//    void shouldUpdateContextValueForExistingLabel() {
//        // Arrange
//        String label = "testLabel";
//        Object oldValue = "oldValue";
//        Object newValue = "newValue";
//        exceptionContext.addContextValue(label, oldValue);
//
//        // Act
//        exceptionContext.setContextValue(label, newValue);
//
//        // Assert
//        List<Pair<String, Object>> contextValues = exceptionContext.getContextValues();
//        assertEquals(1, contextValues.size());
//        assertEquals(label, contextValues.get(0).getKey());
//        assertEquals(newValue, contextValues.get(0).getValue());
//    }
//
//    @Test
//    void shouldRemoveContextValueForExistingLabel() {
//        // Arrange
//        String label = "testLabel";
//        Object value = "testValue";
//        exceptionContext.addContextValue(label, value);
//
//        // Act
//        exceptionContext.setContextValue(label, null);
//
//        // Assert
//        List<Pair<String, Object>> contextValues = exceptionContext.getContextValues();
//        assertEquals(0, contextValues.size());
//    }
//
//    @Test
//    void shouldNotRemoveContextValueIfLabelDoesNotExist() {
//        // Arrange
//        String label = "testLabel";
//
//        // Act
//        exceptionContext.setContextValue(label, null);
//
//        // Assert
//        List<Pair<String, Object>> contextValues = exceptionContext.getContextValues();
//        assertEquals(0, contextValues.size());
//    }

    @Test
    void shouldReturnSameInstance() {
        // Arrange
        String label = "testLabel";
        Object value = "testValue";

        // Act
        DefaultExceptionContext result = exceptionContext.setContextValue(label, value);

        // Assert
        assertSame(exceptionContext, result);
    }


    @Test
    @DisplayName("Should return null")
    void testGetFirstContextValue1() {
        assertNull(exceptionContext.getFirstContextValue("label"));
    }


//            @BeforeEach
//            void setUp() {
//                exceptionContext.contextValues.add(new ImmutablePair<>(label, value));
//            }

//    @Test
//    @DisplayName("Should return the value")
//    void testGetFirstContextValue() {
//        assertEquals(value, exceptionContext.getFirstContextValue(label));
//    }
//



//        @BeforeEach
//        void setUp() {
//            exceptionContext.contextValues.add(new ImmutablePair<>(label, value1));
//            exceptionContext.contextValues.add(new ImmutablePair<>(label, value2));
//        }

    @Test
    @DisplayName("Should return the first value")
    void testGetFirstContextValue2() {
        assertEquals(value1, exceptionContext.getFirstContextValue(label));
    }


//        @BeforeEach
//        void setUp() {
//            exceptionContext.contextValues.add(new ImmutablePair<>(label1, value));
//            exceptionContext.contextValues.add(new ImmutablePair<>(label2, value));
//        }

    @Test
    @DisplayName("Should return null")
    void testGetFirstContextValue3() {
        assertNull(exceptionContext.getFirstContextValue("label"));
    }

    @Test
    void testExample1() {
        // Test case code here
    }

    @Test
    void testExample2() {
        // Test case code here
    }

    @Test
    @DisplayName("should return base message when context values are empty")
    void shouldReturnBaseMessageWhenContextValuesAreEmpty() {
        String baseMessage = "Base Message";
        String formattedMessage = exceptionContext.getFormattedExceptionMessage(baseMessage);

        assertEquals(baseMessage, formattedMessage);
    }

//    @Test
//    @DisplayName("should return base message with context information appended")
//    void shouldReturnBaseMessageWithContextInformationAppended() {
//        String baseMessage = "Base Message";
//        Pair<String, Object> contextValue = new ImmutablePair<>("Context Key", "Context Value");
//        exceptionContext.contextValues.add(contextValue);
//
//        String expectedMessage = baseMessage + "\n" +
//                "Exception Context:\n" +
//                "\t[1:Context Key=Context Value]\n" +
//                "---------------------------------";
//        String formattedMessage = exceptionContext.getFormattedExceptionMessage(baseMessage);
//
//        assertEquals(expectedMessage, formattedMessage);
//    }
//
//    @Test
//    @DisplayName("should handle null base message")
//    void shouldHandleNullBaseMessage() {
//        Pair<String, Object> contextValue = new ImmutablePair<>("Context Key", "Context Value");
//        exceptionContext.contextValues.add(contextValue);
//
//        String expectedMessage = "Exception Context:\n" +
//                "\t[1:Context Key=Context Value]\n" +
//                "---------------------------------";
//        String formattedMessage = exceptionContext.getFormattedExceptionMessage(null);
//
//        assertEquals(expectedMessage, formattedMessage);
//    }
//
//    @Test
//    @DisplayName("should handle null context values")
//    void shouldHandleNullContextValues() {
//        String baseMessage = "Base Message";
//        exceptionContext.contextValues = null;
//
//        String expectedMessage = baseMessage;
//        String formattedMessage = exceptionContext.getFormattedExceptionMessage(baseMessage);
//
//        assertEquals(expectedMessage, formattedMessage);
//    }
//
//    @Test
//    @DisplayName("should handle null context value")
//    void shouldHandleNullContextValue() {
//        String baseMessage = "Base Message";
//        Pair<String, Object> contextValue = new ImmutablePair<>("Context Key", null);
//        exceptionContext.contextValues.add(contextValue);
//
//        String expectedMessage = baseMessage + "\n" +
//                "Exception Context:\n" +
//                "\t[1:Context Key=null]\n" +
//                "---------------------------------";
//        String formattedMessage = exceptionContext.getFormattedExceptionMessage(baseMessage);
//
//        assertEquals(expectedMessage, formattedMessage);
//    }
//
//    @Test
//    @DisplayName("should handle exception thrown on toString() of context value")
//    void shouldHandleExceptionThrownOnToString() {
//        String baseMessage = "Base Message";
//        Pair<String, Object> contextValue = new ImmutablePair<>("Context Key", new Object() {
//            @Override
//            public String toString() {
//                throw new RuntimeException("Exception in toString()");
//            }
//        });
//        exceptionContext.contextValues.add(contextValue);
//
//        String expectedMessage = baseMessage + "\n" +
//                "Exception Context:\n" +
//                "\t[1:Context Key=Exception thrown on toString(): java.lang.RuntimeException: Exception in toString()]\n" +
//                "---------------------------------";
//        String formattedMessage = exceptionContext.getFormattedExceptionMessage(baseMessage);
//
//        assertEquals(expectedMessage, formattedMessage);
//    }

}