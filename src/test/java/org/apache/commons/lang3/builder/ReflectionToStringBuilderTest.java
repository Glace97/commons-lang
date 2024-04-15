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

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ReflectionToStringBuilderTest {
    private ReflectionToStringBuilder builder;
    private Object object;
    private ReflectionToStringBuilder reflectionToStringBuilder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
        object = new Object();
    }

    @Test
    void testSetUpToClass_withNullClass_shouldNotThrowException() {
        assertDoesNotThrow(() -> builder.setUpToClass(null));
    }

    @Test
    void testSetUpToClass_withValidClass_shouldSetUpToClass() {
        Class<?> clazz = Object.class;
        builder.setUpToClass(clazz);
        assertEquals(clazz, builder.getUpToClass());
    }

    @Test
    void testSetUpToClass_withInvalidClass_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> builder.setUpToClass(String.class));
    }

    @Test
    void testSetUpToClass_withNullObjectAndNullClass_shouldNotThrowException() {
        builder = new ReflectionToStringBuilder(null);
        assertDoesNotThrow(() -> builder.setUpToClass(null));
    }

    @Test
    void testSetIncludeFieldNames_Null() {
        builder.setIncludeFieldNames(null);
        assertNull(builder.includeFieldNames);
    }

    @Test
    void testSetIncludeFieldNames_SingleFieldName() {
        String fieldName = "fieldName";
        builder.setIncludeFieldNames(fieldName);
        assertNotNull(builder.includeFieldNames);
        assertEquals(1, builder.includeFieldNames.length);
        assertEquals(fieldName, builder.includeFieldNames[0]);
    }

    @Test
    void testSetIncludeFieldNames_MultipleFieldNames() {
        String[] fieldNames = {"fieldName1", "fieldName2", "fieldName3"};
        builder.setIncludeFieldNames(fieldNames);
        assertNotNull(builder.includeFieldNames);
        assertEquals(fieldNames.length, builder.includeFieldNames.length);
        assertArrayEquals(fieldNames, builder.includeFieldNames);
    }

    @Test
    @DisplayName("returns correct string when excludeFieldNames contains valid field names")
    void testToStringExcludeWithValidExcludeFieldNames() {
        String[] excludeFieldNames = {"field1", "field2"};
        String result = ReflectionToStringBuilder.toStringExclude(object, excludeFieldNames);
        assertNotNull(result);
        assertNotEquals(object.toString(), result);
        assertFalse(result.contains(excludeFieldNames[0]));
        assertFalse(result.contains(excludeFieldNames[1]));
    }

    @Test
    @DisplayName("returns correct string when excludeFieldNames contains duplicate values")
    void testToStringExcludeWithDuplicateValuesInExcludeFieldNames() {
        String[] excludeFieldNames = {"field1", "field1"};
        String result = ReflectionToStringBuilder.toStringExclude(object, excludeFieldNames);
        assertNotNull(result);
        assertNotEquals(object.toString(), result);
        assertFalse(result.contains(excludeFieldNames[0]));
    }

    @Test
    void testGetIncludeFieldNamesClonedArray() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[]{"field1", "field2"};

        String[] includeFieldNames = builder.getIncludeFieldNames();
        includeFieldNames[0] = "modified";

        assertNotEquals(includeFieldNames[0], builder.getIncludeFieldNames()[0]);
    }

    @Test
    void testGetIncludeFieldNamesImmutable() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[]{"field1", "field2"};

        String[] includeFieldNames = builder.getIncludeFieldNames();
        includeFieldNames[0] = "modified";

        assertNotEquals(includeFieldNames[0], builder.getIncludeFieldNames()[0]);
    }

    @Test
    void testGetIncludeFieldNamesSameOrder() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[]{"field2", "field1"};

        String[] includeFieldNames = builder.getIncludeFieldNames();

        assertEquals(2, includeFieldNames.length);
        assertEquals("field2", includeFieldNames[0]);
        assertEquals("field1", includeFieldNames[1]);
    }

    @Test
    void testGetIncludeFieldNamesDifferentOrder() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[]{"field1", "field2"};

        String[] includeFieldNames = builder.getIncludeFieldNames();

        assertEquals(2, includeFieldNames.length);
        assertEquals("field1", includeFieldNames[0]);
        assertEquals("field2", includeFieldNames[1]);
    }

    class MyClass {
        private String field1;
        private int field2;
    }

    @Test
    void isAppendTransients_ShouldReturnFalseByDefault() {
        assertFalse(builder.isAppendTransients());
    }

    @Test
    void isAppendTransients_ShouldReturnTrueWhenSetToTrue() {
        builder.setAppendTransients(true);
        assertTrue(builder.isAppendTransients());
    }

    @Test
    void isAppendTransients_ShouldReturnFalseWhenSetToFalse() {
        builder.setAppendTransients(false);
        assertFalse(builder.isAppendTransients());
    }

    @Test
    void isAppendTransients_ShouldReturnFalseWhenSetToTrueAndThenFalse() {
        builder.setAppendTransients(true);
        builder.setAppendTransients(false);
        assertFalse(builder.isAppendTransients());
    }

    @Test
    void isAppendTransients_ShouldReturnTrueWhenSetToFalseAndThenTrue() {
        builder.setAppendTransients(false);
        builder.setAppendTransients(true);
        assertTrue(builder.isAppendTransients());
    }

    @Test
    void setExcludeFieldNames_shouldSetExcludeFieldNamesToNull_whenNullPassed() {
        // Arrange
        reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());

        // Act
        reflectionToStringBuilder.setExcludeFieldNames(null);

        // Assert
        assertNull(reflectionToStringBuilder.excludeFieldNames);
    }

    @Test
    void setExcludeFieldNames_shouldSetExcludeFieldNamesToEmptyArray_whenEmptyArrayPassed() {
        // Arrange
        reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());

        // Act
        reflectionToStringBuilder.setExcludeFieldNames(new String[0]);

        // Assert
        assertArrayEquals(new String[0], reflectionToStringBuilder.excludeFieldNames);
    }

    @Test
    void setExcludeFieldNames_shouldSetExcludeFieldNamesToSortedArray_whenArrayPassed() {
        // Arrange
        reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());

        // Act
        reflectionToStringBuilder.setExcludeFieldNames("field1", "field2", "field3");

        // Assert
        assertArrayEquals(new String[]{"field1", "field2", "field3"}, reflectionToStringBuilder.excludeFieldNames);
    }

    @Test
    void setExcludeFieldNames_shouldSortExcludeFieldNamesArray_whenArrayPassed() {
        // Arrange
        reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());

        // Act
        reflectionToStringBuilder.setExcludeFieldNames("field3", "field1", "field2");

        // Assert
        assertArrayEquals(new String[]{"field1", "field2", "field3"}, reflectionToStringBuilder.excludeFieldNames);
    }


    @Test
    void testIsExcludeNullValuesDefault() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        assertFalse(builder.isExcludeNullValues());
    }

    @Test
    void testSetExcludeNullValuesMultipleTimes() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        builder.setExcludeNullValues(true);
        assertTrue(builder.isExcludeNullValues());
        builder.setExcludeNullValues(false);
        assertFalse(builder.isExcludeNullValues());
    }

    @Test
    void shouldSetExcludeNullValuesToTrue() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        builder.setExcludeNullValues(true);
        assertTrue(builder.isExcludeNullValues());
    }

    @Test
    void shouldSetExcludeNullValuesToFalse() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        builder.setExcludeNullValues(false);
        assertFalse(builder.isExcludeNullValues());
    }

    @Test
    @DisplayName("Should return empty array when collection is null")
    void shouldReturnEmptyArrayWhenCollectionIsNull() {
        // Arrange
        Collection<String> collection = null;

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);

        // Assert
        assertArrayEquals(new String[0], result);
    }

    @Test
    @DisplayName("Should return empty array when collection is empty")
    void shouldReturnEmptyArrayWhenCollectionIsEmpty() {
        // Arrange
        Collection<String> collection = new ArrayList<>();

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);

        // Assert
        assertArrayEquals(new String[0], result);
    }

    @Test
    @DisplayName("Should return array with non-null elements when collection has non-null elements")
    void shouldReturnArrayWithNonNullElementsWhenCollectionHasNonNullElements() {
        // Arrange
        Collection<String> collection = Arrays.asList("a", "b", "c");

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);

        // Assert
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    @DisplayName("Should return array with non-null elements when collection has null elements")
    void shouldReturnArrayWithNonNullElementsWhenCollectionHasNullElements() {
        // Arrange
        Collection<String> collection = Arrays.asList("a", null, "c");

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);

        // Assert
        assertArrayEquals(new String[]{"a", "c"}, result);
    }

    @Test
    @DisplayName("Should return empty array when array is null")
    void shouldReturnEmptyArrayWhenArrayIsNull() {
        // Arrange
        Object[] array = null;

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);

        // Assert
        assertArrayEquals(new String[0], result);
    }

    @Test
    @DisplayName("Should return empty array when array is empty")
    void shouldReturnEmptyArrayWhenArrayIsEmpty() {
        // Arrange
        Object[] array = new Object[0];

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);

        // Assert
        assertArrayEquals(new String[0], result);
    }

    @Test
    @DisplayName("Should return array with non-null elements when array has non-null elements")
    void shouldReturnArrayWithNonNullElementsWhenArrayHasNonNullElements() {
        // Arrange
        Object[] array = new Object[]{"a", "b", "c"};

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);

        // Assert
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    @DisplayName("Should return array with non-null elements when array has null elements")
    void shouldReturnArrayWithNonNullElementsWhenArrayHasNullElements() {
        // Arrange
        Object[] array = new Object[]{"a", null, "c"};

        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);

        // Assert
        assertArrayEquals(new String[]{"a", "c"}, result);
    }

    @Test
    void shouldReturnFalseByDefault() {
        assertFalse(builder.isAppendStatics());
    }

    @Test
    void shouldReturnTrueAfterSettingToTrue() {
        builder.setAppendStatics(true);
        assertTrue(builder.isAppendStatics());
    }

    @Test
    void shouldReturnFalseAfterSettingToFalse() {
        builder.setAppendStatics(true);
        builder.setAppendStatics(false);
        assertFalse(builder.isAppendStatics());
    }

    @Test
    void setAppendStatics_shouldSetAppendStaticsToTrue() {
        builder.setAppendStatics(true);
        assertTrue(builder.isAppendStatics());
    }

    @Test
    void setAppendStatics_shouldSetAppendStaticsToFalse() {
        builder.setAppendStatics(false);
        assertFalse(builder.isAppendStatics());
    }

    @Test
    void reflectionAppendArray_shouldAppendArrayToToString() {
        // test code here
    }

    @Test
    void reflectionAppendArray_shouldAppendEmptyArrayToToString() {
        // test code here
    }

    @Test
    void reflectionAppendArray_shouldAppendNullArrayToToString() {
        // test code here
    }

    @Test
    void reflectionAppendArray_shouldAppendSingleValueArrayToToString() {
        // test code here
    }

    @Test
    void setAppendTransients_True() {
        builder.setAppendTransients(true);
        assertTrue(builder.isAppendTransients());
    }

    @Test
    void setAppendTransients_False() {
        builder.setAppendTransients(false);
        assertFalse(builder.isAppendTransients());
    }

    @Test
    void setAppendTransients_DefaultValue() {
        assertFalse(builder.isAppendTransients());
    }

}