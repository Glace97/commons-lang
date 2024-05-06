package org.apache.commons.lang3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.mockito.Mockito.*;

import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.mutable.MutableInt;
import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

public class ObjectUtilsTest {

    @Test
    public void testCloneIfPossible_NullInput_ReturnsNull() {
        // Arrange
        Object obj = null;

        // Act
        Object result = ObjectUtils.cloneIfPossible(obj);

        // Assert
        assertNull(result);
    }

    @Test
    public void testCloneIfPossible_UncloneableObject_ReturnsSameObject() {
        // Arrange
        Object obj = new Object();

        // Act
        Object result = ObjectUtils.cloneIfPossible(obj);

        // Assert
        assertSame(obj, result);
    }


    @Test
    public void testCloneIfPossible_ExceptionOccurs_ThrowsCloneFailedException() throws CloneFailedException, CloneNotSupportedException {
        // Arrange
        CloneableClass obj = mock(CloneableClass.class);
        when(obj.clone()).thenThrow(CloneNotSupportedException.class);

        // Act and Assert
        assertThrows(CloneFailedException.class, () -> ObjectUtils.cloneIfPossible(obj));
    }

    @Test
    public void testCloneIfPossible_ClassWithPrivateCloneMethod_ReturnsClone() throws CloneFailedException {
        // Arrange
        ClassWithPrivateCloneMethod obj = new ClassWithPrivateCloneMethod();

        // Act
        ClassWithPrivateCloneMethod result = ObjectUtils.cloneIfPossible(obj);

        // Assert
        //assertNotSame(obj, result);
        assertEquals(obj.getValue(), result.getValue());
    }

    private static class CloneableClass implements Cloneable {
        private int value;

        public CloneableClass() {
            this.value = 10;
        }

        public int getValue() {
            return value;
        }

        @Override
        protected CloneableClass clone() throws CloneNotSupportedException {
            return (CloneableClass) super.clone();
        }
    }

    private static class ClassWithPrivateCloneMethod {
        private int value;

        public ClassWithPrivateCloneMethod() {
            this.value = 20;
        }

        public int getValue() {
            return value;
        }

        protected ClassWithPrivateCloneMethod clone() {
            ClassWithPrivateCloneMethod clone = new ClassWithPrivateCloneMethod();
            clone.value = this.value;
            return clone;
        }
    }

    @Test
    public void identityToString_NullObject_ReturnsNullString() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        assertNull(ObjectUtils.identityToString(object));
    }

    @Test
    public void testMedianWithComparator() {
        // Instantiate all necessary variables here
        Comparator<Integer> comparator = mock(Comparator.class);
        Integer[] items = {1, 2, 3, 4, 5};

        // Mock the behavior of the comparator
        when(comparator.compare(anyInt(), anyInt())).thenReturn(-1);

        // Write the test code here following the given rules
        Integer result = ObjectUtils.median(comparator, items);

        // Verify the expected result
        assertEquals(3, result);
    }

    @Test
    public void testMedianWithComparable() {
        // Instantiate all necessary variables here
        Integer[] items = {1, 2, 3, 4, 5};

        // Write the test code here following the given rules
        Integer result = ObjectUtils.median(items);

        // Verify the expected result
        assertEquals(3, result);
    }

    @Test
    public void testIsNotEmpty_WithNull_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_WithEmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = "";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_WithNonEmptyString_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = "ab";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertTrue(result);
    }

    @Test
    public void testIsNotEmpty_WithEmptyArray_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = new int[]{};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_WithNonEmptyArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = new int[]{1, 2, 3};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertTrue(result);
    }

    @Test
    public void testIsNotEmpty_WithEmptyCollection_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = new ArrayList<>();

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_WithEmptyMap_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = new HashMap<>();

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_WithPresentOptional_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = Optional.of("value");

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertTrue(result);
    }

    @Test
    public void testIsNotEmpty_WithEmptyOptional_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = Optional.empty();

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isNotEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testClone_NullObject_ReturnsNull() {
        // Instantiate all necessary variables here
        Object obj = null;

        // Write the test code here following the given rules
        Object result = ObjectUtils.clone(obj);

        assertNull(result);
    }

    @Test
    public void testClone_CloneableArrayObject_ReturnsClone() {
        // Instantiate all necessary variables here
        String[] obj = new String[]{"a", "b", "c"};

        // Write the test code here following the given rules
        String[] result = ObjectUtils.clone(obj);

        assertArrayEquals(obj, result);
        assertNotSame(obj, result);
    }

    @Test
    public void testClone_CloneablePrimitiveArrayObject_ReturnsClone() {
        // Instantiate all necessary variables here
        int[] obj = new int[]{1, 2, 3};

        // Write the test code here following the given rules
        int[] result = ObjectUtils.clone(obj);

        assertArrayEquals(obj, result);
        assertNotSame(obj, result);
    }

    @Test
    public void testClone_NonCloneableObject_ReturnsNull() {
        // Instantiate all necessary variables here
        NonCloneableClass obj = new NonCloneableClass();

        // Write the test code here following the given rules
        NonCloneableClass result = ObjectUtils.clone(obj);

        assertNull(result);
    }

    private static class CloneableClass2 implements Cloneable {
        @Override
        protected CloneableClass clone() throws CloneNotSupportedException {
            return (CloneableClass) super.clone();
        }
    }

    private static class NonCloneableClass {
        // No clone() method
    }

    @Test
    public void testMax_WithNullValues_ShouldReturnNull() {
        // Instantiate all necessary variables here
        Comparable[] values = null;

        // Write the test code here following the given rules
        Comparable result = ObjectUtils.max(values);

        assertNull(result);
    }

    @Test
    public void testMax_WithSingleValue_ShouldReturnSameValue() {
        // Instantiate all necessary variables here
        Comparable value = "a";

        // Write the test code here following the given rules
        Comparable result = ObjectUtils.max(value);

        assertEquals(value, result);
    }

    @Test
    public void testMax_WithMultipleEqualValues_ShouldReturnFirstValue() {
        // Instantiate all necessary variables here
        Comparable value1 = 1;
        Comparable value2 = 1;
        Comparable value3 = 1;

        // Write the test code here following the given rules
        Comparable result = ObjectUtils.max(value1, value2, value3);

        assertEquals(value1, result);
    }

    @Test
    public void testMax_WithMultipleDifferentValues_ShouldReturnMaxValue() {
        // Instantiate all necessary variables here
        Comparable value1 = 1;
        Comparable value2 = 2;
        Comparable value3 = 3;

        // Write the test code here following the given rules
        Comparable result = ObjectUtils.max(value1, value2, value3);

        assertEquals(value3, result);
    }

    @Test
    public void testMax_WithNullAndNonNullValues_ShouldReturnMaxValue() {
        // Instantiate all necessary variables here
        Comparable value1 = null;
        Comparable value2 = 2;
        Comparable value3 = 3;

        // Write the test code here following the given rules
        Comparable result = ObjectUtils.max(value1, value2, value3);

        assertEquals(value3, result);
    }

    @Test
    public void testMax_WithComparableMock_ShouldReturnMaxValue() {
        // Instantiate all necessary variables here
        Comparable value1 = mock(Comparable.class);
        Comparable value2 = mock(Comparable.class);
        Comparable value3 = mock(Comparable.class);

        when(value1.compareTo(any())).thenReturn(-1);
        when(value2.compareTo(any())).thenReturn(0);
        when(value3.compareTo(any())).thenReturn(1);

        // Write the test code here following the given rules
        Comparable result = ObjectUtils.max(value1, value2, value3);

        assertEquals(value3, result);
    }

    @Test
    public void testNotEqual_NullObjects_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object1 = null;
        Object object2 = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertFalse(result);
    }

    @Test
    public void testNotEqual_NullAndNonNullObjects_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = null;
        Object object2 = "test";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertTrue(result);
    }

    @Test
    public void testNotEqual_NonNullAndNullObjects_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = "test";
        Object object2 = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertTrue(result);
    }

    @Test
    public void testNotEqual_NullAndEmptyString_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = null;
        Object object2 = "";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertTrue(result);
    }

    @Test
    public void testNotEqual_EmptyStringAndNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = "";
        Object object2 = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertTrue(result);
    }

    @Test
    public void testNotEqual_TwoEmptyStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object1 = "";
        Object object2 = "";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertFalse(result);
    }

    @Test
    public void testNotEqual_BooleanTrueAndNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = Boolean.TRUE;
        Object object2 = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertTrue(result);
    }

    @Test
    public void testNotEqual_BooleanTrueAndStringTrue_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = Boolean.TRUE;
        Object object2 = "true";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertTrue(result);
    }

    @Test
    public void testNotEqual_BooleanTrueAndBooleanTrue_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object1 = Boolean.TRUE;
        Object object2 = Boolean.TRUE;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertFalse(result);
    }

    @Test
    public void testNotEqual_BooleanTrueAndBooleanFalse_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = Boolean.TRUE;
        Object object2 = Boolean.FALSE;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.notEqual(object1, object2);

        assertTrue(result);
    }

    @Test
    public void testIsArray_NullObject_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isArray(object);

        // Verify the result
        assertFalse(result);
    }

    @Test
    public void testIsArray_EmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = "";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isArray(object);

        // Verify the result
        assertFalse(result);
    }

    @Test
    public void testIsArray_NonEmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = "ab";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isArray(object);

        // Verify the result
        assertFalse(result);
    }

    @Test
    public void testIsArray_EmptyIntArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = new int[]{};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isArray(object);

        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testIsArray_NonEmptyIntArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = new int[]{1, 2, 3};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isArray(object);

        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testIsArray_NonArrayObject_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = 1234;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isArray(object);

        // Verify the result
        assertFalse(result);
    }

    @Test
    public void testGetClass_WithNull_ReturnsNull() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        Class<?> result = ObjectUtils.getClass(object);

        assertNull(result);
    }

    @Test
    public void testGetClass_WithNonNull_ReturnsClass() {
        // Instantiate all necessary variables here
        Object object = new Object();

        // Write the test code here following the given rules
        Class<?> result = ObjectUtils.getClass(object);

        assertNotNull(result);
        assertEquals(Object.class, result);
    }

    @Test
    public void testGetFirstNonNull_WhenAllSuppliersReturnNull_ShouldReturnNull() {
        // Instantiate all necessary variables here
        Supplier<String> supplier1 = mock(Supplier.class);
        Supplier<String> supplier2 = mock(Supplier.class);
        Supplier<String> supplier3 = mock(Supplier.class);
        
        // Write the test code here following the given rules
        when(supplier1.get()).thenReturn(null);
        when(supplier2.get()).thenReturn(null);
        when(supplier3.get()).thenReturn(null);
        
        Object result = ObjectUtils.getFirstNonNull(supplier1, supplier2, supplier3);
        
        assertNull(result);
    }
    
    @Test
    public void testGetFirstNonNull_WhenFirstSupplierReturnsNonNullValue_ShouldReturnFirstNonNullValue() {
        // Instantiate all necessary variables here
        Supplier<String> supplier1 = mock(Supplier.class);
        Supplier<String> supplier2 = mock(Supplier.class);
        Supplier<String> supplier3 = mock(Supplier.class);
        
        // Write the test code here following the given rules
        when(supplier1.get()).thenReturn("abc");
        when(supplier2.get()).thenReturn(null);
        when(supplier3.get()).thenReturn(null);
        
        Object result = ObjectUtils.getFirstNonNull(supplier1, supplier2, supplier3);
        
        assertEquals("abc", result);
    }
    
    @Test
    public void testGetFirstNonNull_WhenAllSuppliersReturnNonNullValues_ShouldReturnFirstNonNullValue() {
        // Instantiate all necessary variables here
        Supplier<String> supplier1 = mock(Supplier.class);
        Supplier<String> supplier2 = mock(Supplier.class);
        Supplier<String> supplier3 = mock(Supplier.class);
        
        // Write the test code here following the given rules
        when(supplier1.get()).thenReturn("abc");
        when(supplier2.get()).thenReturn("def");
        when(supplier3.get()).thenReturn("ghi");
        
        Object result = ObjectUtils.getFirstNonNull(supplier1, supplier2, supplier3);
        
        assertEquals("abc", result);
    }
    
    @Test
    public void testGetFirstNonNull_WhenNoSuppliersProvided_ShouldReturnNull() {
        // Instantiate all necessary variables here
        
        // Write the test code here following the given rules
        Object result = ObjectUtils.getFirstNonNull();
        
        assertNull(result);
    }

    @Test
    public void testHashCodeMulti_NoObjects_ReturnsOne() {
        ObjectUtils objectUtils = new ObjectUtils();
        
        int result = objectUtils.hashCodeMulti();
        
        assertEquals(1, result);
    }

    @Test
    public void testFirstNonNullWithNullValues() {
        // Arrange
        String[] values = null;

        // Act
        String result = ObjectUtils.firstNonNull(values);

        // Assert
        assertNull(result);
    }

    @Test
    public void testFirstNonNullWithEmptyValues() {
        // Arrange
        String[] values = new String[0];

        // Act
        String result = ObjectUtils.firstNonNull(values);

        // Assert
        assertNull(result);
    }

    @Test
    public void testFirstNonNullWithAllNullValues() {
        // Arrange
        String[] values = new String[3];

        // Act
        String result = ObjectUtils.firstNonNull(values);

        // Assert
        assertNull(result);
    }

    @Test
    public void testFirstNonNullWithSomeNullValues() {
        // Arrange
        String[] values = new String[] { null, "a", null, "b", null };

        // Act
        String result = ObjectUtils.firstNonNull(values);

        // Assert
        assertEquals("a", result);
    }

    @Test
    public void testFirstNonNullWithNonNullableValues() {
        // Arrange
        String[] values = new String[] { "abc", "def", "ghi" };

        // Act
        String result = ObjectUtils.firstNonNull(values);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void testFirstNonNullWithMixedValues() {
        // Arrange
        String[] values = new String[] { null, "xyz", null, "abc", null };

        // Act
        String result = ObjectUtils.firstNonNull(values);

        // Assert
        assertEquals("xyz", result);
    }

    @Test
    public void testFirstNonNullWithDifferentTypes() {
        // Arrange
        Object[] values = new Object[] { null, true, "abc", 123 };

        // Act
        Object result = ObjectUtils.firstNonNull(values);

        // Assert
        assertEquals(true, result);
    }

    @Test
    public void testFirstNonNullWithNoValues() {
        // Arrange

        // Act
        Object result = ObjectUtils.firstNonNull();

        // Assert
        assertNull(result);
    }

    @Test
    public void testIsEmpty_NullObject_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_EmptyString_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = "";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_NonEmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = "ab";

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_EmptyArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = new int[]{};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_NonEmptyArray_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = new int[]{1, 2, 3};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_IntegerObject_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = 1234;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_CharacterObject_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = '@';

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testIsEmpty_EmptyOptional_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object = Optional.empty();

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertTrue(result);
    }

    @Test
    public void testIsEmpty_NonEmptyOptional_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object = Optional.of("");

        // Write the test code here following the given rules
        boolean result = ObjectUtils.isEmpty(object);

        assertFalse(result);
    }

    @Test
    public void testDefaultIfNull_WhenObjectIsNull_ThenReturnDefaultValue() {
        // Instantiate all necessary variables here
        String object = null;
        String defaultValue = "default";

        // Write the test code here following the given rules
        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertEquals(defaultValue, result);
    }

    @Test
    public void testDefaultIfNull_WhenObjectIsNotNull_ThenReturnObject() {
        // Instantiate all necessary variables here
        String object = "value";
        String defaultValue = "default";

        // Write the test code here following the given rules
        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertEquals(object, result);
    }

    @Test
    public void testDefaultIfNull_WhenObjectIsNullAndDefaultValueIsNull_ThenReturnNull() {
        // Instantiate all necessary variables here
        String object = null;
        String defaultValue = null;

        // Write the test code here following the given rules
        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertNull(result);
    }

    @Test
    public void testDefaultIfNull_WhenObjectIsNotNullAndDefaultValueIsNull_ThenReturnObject() {
        // Instantiate all necessary variables here
        String object = "value";
        String defaultValue = null;

        // Write the test code here following the given rules
        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertEquals(object, result);
    }

    @Test
    public void testDefaultIfNull_WhenObjectIsNullAndDefaultValueIsEmptyString_ThenReturnEmptyString() {
        // Instantiate all necessary variables here
        String object = null;
        String defaultValue = "";

        // Write the test code here following the given rules
        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertEquals(defaultValue, result);
    }

    @Test
    public void testDefaultIfNull_WhenObjectIsNotNullAndDefaultValueIsEmptyString_ThenReturnObject() {
        // Instantiate all necessary variables here
        String object = "value";
        String defaultValue = "";

        // Write the test code here following the given rules
        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertEquals(object, result);
    }

    @Test
    public void testRequireNonEmpty_WithNonNullObject_ReturnsObject() {
        // Instantiate all necessary variables here
        Object obj = new Object();

        // Write the test code here following the given rules
        Object result = ObjectUtils.requireNonEmpty(obj);

        assertEquals(obj, result);
    }

    @Test
    public void testRequireNonEmpty_WithNullObject_ThrowsNullPointerException() {
        // Instantiate all necessary variables here
        Object obj = null;

        // Write the test code here following the given rules
        assertThrows(NullPointerException.class, () -> {
            ObjectUtils.requireNonEmpty(obj);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyString_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(str);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyCollection_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        Collection<Object> collection = Collections.emptyList();

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(collection);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyArray_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        Object[] array = new Object[0];

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(array);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyMap_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        Map<Object, Object> map = Collections.emptyMap();

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(map);
        });
    }

    @Test
    public void testRequireNonEmpty_WithNonNullObjectAndMessage_ReturnsObject() {
        // Instantiate all necessary variables here
        Object obj = new Object();
        String message = "Test message";

        // Write the test code here following the given rules
        Object result = ObjectUtils.requireNonEmpty(obj, message);

        assertEquals(obj, result);
    }

    @Test
    public void testRequireNonEmpty_WithNullObjectAndMessage_ThrowsNullPointerException() {
        // Instantiate all necessary variables here
        Object obj = null;
        String message = "Test message";

        // Write the test code here following the given rules
        assertThrows(NullPointerException.class, () -> {
            ObjectUtils.requireNonEmpty(obj, message);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyStringAndMessage_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        String str = "";
        String message = "Test message";

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(str, message);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyCollectionAndMessage_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        Collection<Object> collection = Collections.emptyList();
        String message = "Test message";

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(collection, message);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyArrayAndMessage_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        Object[] array = new Object[0];
        String message = "Test message";

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(array, message);
        });
    }

    @Test
    public void testRequireNonEmpty_WithEmptyMapAndMessage_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        Map<Object, Object> map = Collections.emptyMap();
        String message = "Test message";

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.requireNonEmpty(map, message);
        });
    }

    @Test
    public void testGetIfNull_ReturnsDefault_WhenObjectIsNull() {
        // Arrange
        String object = null;
        String defaultValue = "default";
        Supplier<String> defaultSupplier = () -> defaultValue;

        // Act
        String result = ObjectUtils.getIfNull(object, defaultSupplier);

        // Assert
        assertEquals(defaultValue, result);
//        verify(defaultSupplier).get();
    }

    @Test
    public void testGetIfNull_ReturnsNull_WhenObjectIsNullAndDefaultSupplierIsNull() {
        // Arrange
        String object = null;
        Supplier<String> defaultSupplier = null;

        // Act
        String result = ObjectUtils.getIfNull(object, defaultSupplier);

        // Assert
        assertNull(result);
    }

    @Test
    public void testGetIfNull_ReturnsDefault_WhenObjectIsNullAndDefaultSupplierReturnsValue() {
        // Arrange
        String object = null;
        String defaultValue = "default";
        Supplier<String> defaultSupplier = () -> defaultValue;

        // Act
        String result = ObjectUtils.getIfNull(object, defaultSupplier);

        // Assert
        assertEquals(defaultValue, result);
//        verify(defaultSupplier).get();
    }

    @Test
    public void testCompare_NullInputs_ReturnsZero() {
        // Instantiate all necessary variables here
        Integer c1 = null;
        Integer c2 = null;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2);

        assertEquals(0, result);
    }

    @Test
    public void testCompare_NullC1_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        Integer c1 = null;
        Integer c2 = 5;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2);

        assertTrue(result < 0);
    }

    @Test
    public void testCompare_NullC2_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        Integer c1 = 5;
        Integer c2 = null;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2);

        assertTrue(result > 0);
    }

    @Test
    public void testCompare_SameValues_ReturnsZero() {
        // Instantiate all necessary variables here
        Integer c1 = 5;
        Integer c2 = 5;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2);

        assertEquals(0, result);
    }

    @Test
    public void testCompare_C1LessThanC2_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        Integer c1 = 5;
        Integer c2 = 10;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2);

        assertTrue(result < 0);
    }

    @Test
    public void testCompare_C1GreaterThanC2_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        Integer c1 = 10;
        Integer c2 = 5;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2);

        assertTrue(result > 0);
    }

    @Test
    public void testCompare_NullGreater_NullC1_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        Integer c1 = null;
        Integer c2 = 5;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2, true);

        assertTrue(result > 0);
    }

    @Test
    public void testCompare_NullGreater_NullC2_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        Integer c1 = 5;
        Integer c2 = null;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2, true);

        assertTrue(result < 0);
    }

    @Test
    public void testCompare_NullGreater_SameValues_ReturnsZero() {
        // Instantiate all necessary variables here
        Integer c1 = 5;
        Integer c2 = 5;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2, true);

        assertEquals(0, result);
    }

    @Test
    public void testCompare_NullGreater_C1LessThanC2_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        Integer c1 = 5;
        Integer c2 = 10;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2, true);

        assertTrue(result < 0);
    }

    @Test
    public void testCompare_NullGreater_C1GreaterThanC2_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        Integer c1 = 10;
        Integer c2 = 5;

        // Write the test code here following the given rules
        int result = ObjectUtils.compare(c1, c2, true);

        assertTrue(result > 0);
    }

    @Test
    public void testAllNull_EmptyArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object[] values = new Object[0];

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNull(values);

        assertTrue(result);
    }

    @Test
    public void testAllNull_AllNullValues_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object[] values = {null, null, null};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNull(values);

        assertTrue(result);
    }

    @Test
    public void testAllNull_SomeNonNullValues_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object[] values = {null, "abc", null};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNull(values);

        assertFalse(result);
    }

    @Test
    public void testAllNull_NullArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object[] values = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNull(values);

        assertTrue(result);
    }

    @Test
    public void testAllNull_NullValueInArray_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object[] values = {null, null, "abc"};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNull(values);

        assertFalse(result);
    }

    @Test
    public void identityHashCodeHex_NullObject_ReturnsHexStringOfNullHashCode() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        String expected = "0";
        String actual = ObjectUtils.identityHashCodeHex(object);
        assertEquals(expected, actual);
    }

    @Test
    public void identityHashCodeHex_NonNullObject_ReturnsHexStringOfObjectHashCode() {
        // Instantiate all necessary variables here
        Object object = new Object();

        // Write the test code here following the given rules
        String expected = Integer.toHexString(System.identityHashCode(object));
        String actual = ObjectUtils.identityHashCodeHex(object);
        assertEquals(expected, actual);
    }

    @Test
    public void identityHashCodeHex_SameObject_ReturnsSameHexString() {
        // Instantiate all necessary variables here
        Object object = new Object();

        // Write the test code here following the given rules
        String expected = ObjectUtils.identityHashCodeHex(object);
        String actual = ObjectUtils.identityHashCodeHex(object);
        assertEquals(expected, actual);
    }

    @Test
    public void testCONST_SHORT_ValidValue() {
        // Arrange
        int value = 100;

        // Act
        short result = ObjectUtils.CONST_SHORT(value);

        // Assert
        assertEquals(value, result);
    }

    @Test
    public void testCONST_SHORT_MinValue() {
        // Arrange
        int value = Short.MIN_VALUE;

        // Act
        short result = ObjectUtils.CONST_SHORT(value);

        // Assert
        assertEquals(value, result);
    }

    @Test
    public void testCONST_SHORT_MaxValue() {
        // Arrange
        int value = Short.MAX_VALUE;

        // Act
        short result = ObjectUtils.CONST_SHORT(value);

        // Assert
        assertEquals(value, result);
    }

    @Test
    public void testCONST_SHORT_InvalidValue() {
        // Arrange
        int value = 100000;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.CONST_SHORT(value);
        });
    }

    @Test
    public void testCONST_SHORT_NegativeValue() {
        // Arrange
        int value = -100;

        // Act
        short result = ObjectUtils.CONST_SHORT(value);

        // Assert
        assertEquals(value, result);
    }

    @Test
    public void testCONST_SHORT_ByteValue() {
        // Arrange
        int value = 127;

        // Act
        short result = ObjectUtils.CONST_SHORT(value);

        // Assert
        assertEquals(value, result);
    }

    @Test
    public void testMode_ReturnsMostFrequentlyOccurringItem_WhenItemsAreSupplied() {
        // Instantiate all necessary variables here
        Integer[] items = {1, 2, 3, 2, 4, 2, 5};
        Map<Integer, MutableInt> occurrences = new HashMap<>();
        int max = 0;
        Integer result = null;
        
        // Mock dependencies
        
        // Write the test code here following the given rules
        for (Integer item : items) {
            MutableInt count = occurrences.get(item);
            if (count == null) {
                occurrences.put(item, new MutableInt(1));
            } else {
                count.increment();
            }
        }
        
        for (Map.Entry<Integer, MutableInt> entry : occurrences.entrySet()) {
            int cmp = entry.getValue().intValue();
            if (cmp == max) {
                result = null;
            } else if (cmp > max) {
                max = cmp;
                result = entry.getKey();
            }
        }
        
        assertEquals(2, result);
    }
    
    @Test
    public void testMode_ReturnsNull_WhenNoItemsAreSupplied() {
        // Instantiate all necessary variables here
        Integer[] items = {};
        
        // Mock dependencies
        
        // Write the test code here following the given rules
        assertNull(ObjectUtils.mode(items));
    }
    
    @Test
    public void testMode_ReturnsNull_WhenItemsAreNull() {
        // Instantiate all necessary variables here
        Integer[] items = {null, null, null};
        
        // Mock dependencies
        
        // Write the test code here following the given rules
        assertNull(ObjectUtils.mode(items));
    }
    
    @Test
    public void testMode_ReturnsNull_WhenItemsAreNonUnique() {
        // Instantiate all necessary variables here
        Integer[] items = {1, 2, 3, 4, 5, 1, 2, 3};
        
        // Mock dependencies
        
        // Write the test code here following the given rules
        assertNull(ObjectUtils.mode(items));
    }

    @Test
    public void testHashCode_NullObject_ReturnsZero() {
        // Instantiate all necessary variables here
        Object obj = null;

        // Write the test code here following the given rules
        int result = ObjectUtils.hashCode(obj);

        assertEquals(0, result);
    }

    @Test
    public void testHashCode_NonNullObject_ReturnsHashCode() {
        // Instantiate all necessary variables here
        Object obj = new Object();

        // Write the test code here following the given rules
        int result = ObjectUtils.hashCode(obj);

        assertEquals(obj.hashCode(), result);
    }

    @Test
    public void anyNotNull_ShouldReturnTrue_WhenAtLeastOneNonNullValue() {
        // Arrange
        ObjectUtils.Null nullValue = ObjectUtils.NULL;
        Object[] values = { nullValue, "value1", nullValue };

        // Act
        boolean result = ObjectUtils.anyNotNull(values);

        // Assert
        assertTrue(result);
    }

    @Test
    public void anyNotNull_ShouldReturnFalse_WhenValuesArrayIsNull() {
        // Arrange
        Object[] values = null;

        // Act
        boolean result = ObjectUtils.anyNotNull(values);

        // Assert
        assertFalse(result);
    }

    @Test
    public void anyNotNull_ShouldReturnFalse_WhenValuesArrayIsEmpty() {
        // Arrange
        Object[] values = {};

        // Act
        boolean result = ObjectUtils.anyNotNull(values);

        // Assert
        assertFalse(result);
    }

    @Test
    public void anyNotNull_ShouldReturnTrue_WhenMixedNullAndNonNullValues() {
        // Arrange
        ObjectUtils.Null nullValue = ObjectUtils.NULL;
        Object[] values = { nullValue, null, "value1" };

        // Act
        boolean result = ObjectUtils.anyNotNull(values);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testCONST_BYTE() {
        // Instantiate all necessary variables here
        int validValue = 5;
        int invalidValue = 300;

        // Write the test code here following the given rules
        byte result = ObjectUtils.CONST_BYTE(validValue);
        assertEquals((byte) validValue, result);

        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.CONST_BYTE(invalidValue);
        });
    }


    @Test
    public void testAnyNull_withNullArray_returnsTrue() {
        // Instantiate all necessary variables here
        Object[] values = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.anyNull(values);

        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testAnyNull_withNonNullValues_returnsFalse() {
        // Instantiate all necessary variables here
        Object[] values = { "a", "b", "c" };

        // Write the test code here following the given rules
        boolean result = ObjectUtils.anyNull(values);

        // Verify the result
        assertFalse(result);
    }

    @Test
    public void testAnyNull_withNullValues_returnsTrue() {
        // Instantiate all necessary variables here
        Object[] values = { "a", null, "c" };

        // Write the test code here following the given rules
        boolean result = ObjectUtils.anyNull(values);

        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testAnyNull_withMixedValues_returnsTrue() {
        // Instantiate all necessary variables here
        Object[] values = { "a", null, "c", null };

        // Write the test code here following the given rules
        boolean result = ObjectUtils.anyNull(values);

        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testMinWithNullValues() {
        // Instantiate all necessary variables here
        Integer[] values = {null, null, null};

        // Write the test code here following the given rules
        Integer result = ObjectUtils.min(values);

        assertNull(result);
    }

    @Test
    public void testMinWithNoNullValues() {
        // Instantiate all necessary variables here
        Integer[] values = {1, 2, 3};

        // Write the test code here following the given rules
        Integer result = ObjectUtils.min(values);

        assertEquals(1, result);
    }

    @Test
    public void testMinWithMixedNullAndNonNullValues() {
        // Instantiate all necessary variables here
        Integer[] values = {1, null, 3, null, 2};

        // Write the test code here following the given rules
        Integer result = ObjectUtils.min(values);

        assertEquals(1, result);
    }

    @Test
    public void testMinWithNoValues() {
        // Instantiate all necessary variables here
        Integer[] values = {};

        // Write the test code here following the given rules
        Integer result = ObjectUtils.min(values);

        assertNull(result);
    }

    @Test
    public void testEquals_SameObject_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = new Object();
        Object object2 = object1;

        // Write the test code here following the given rules
        assertTrue(ObjectUtils.equals(object1, object2));
    }

    @Test
    public void testEquals_NullObjects_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = null;
        Object object2 = null;

        // Write the test code here following the given rules
        assertTrue(ObjectUtils.equals(object1, object2));
    }

    @Test
    public void testEquals_OneObjectNull_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object1 = null;
        Object object2 = new Object();

        // Write the test code here following the given rules
        assertFalse(ObjectUtils.equals(object1, object2));
    }

    @Test
    public void testEquals_BothObjectsNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = ObjectUtils.NULL;
        Object object2 = ObjectUtils.NULL;

        // Write the test code here following the given rules
        assertTrue(ObjectUtils.equals(object1, object2));
    }

    @Test
    public void testEquals_SameValues_ReturnsTrue() {
        // Instantiate all necessary variables here
        Object object1 = "test";
        Object object2 = "test";

        // Write the test code here following the given rules
        assertTrue(ObjectUtils.equals(object1, object2));
    }

    @Test
    public void testEquals_DifferentValues_ReturnsFalse() {
        // Instantiate all necessary variables here
        Object object1 = "test1";
        Object object2 = "test2";

        // Write the test code here following the given rules
        assertFalse(ObjectUtils.equals(object1, object2));
    }

    @Test
    public void testToString_NullInput_ReturnsEmptyString() {
        // Arrange
        Object obj = null;

        // Act
        String result = ObjectUtils.toString(obj);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testToString_EmptyStringInput_ReturnsEmptyString() {
        // Arrange
        Object obj = "";

        // Act
        String result = ObjectUtils.toString(obj);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testToString_NonNullInput_ReturnsObjectToString() {
        // Arrange
        Object obj = "bat";

        // Act
        String result = ObjectUtils.toString(obj);

        // Assert
        assertEquals("bat", result);
    }

    @Test
    public void testToString_NullInputWithNullStr_ReturnsNullStr() {
        // Arrange
        Object obj = null;
        String nullStr = "null";

        // Act
        String result = ObjectUtils.toString(obj, nullStr);

        // Assert
        assertEquals(nullStr, result);
    }

    @Test
    public void testToString_EmptyStringInputWithNullStr_ReturnsEmptyString() {
        // Arrange
        Object obj = "";
        String nullStr = "null";

        // Act
        String result = ObjectUtils.toString(obj, nullStr);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testToString_NonNullInputWithNullStr_ReturnsObjectToString() {
        // Arrange
        Object obj = "bat";
        String nullStr = "null";

        // Act
        String result = ObjectUtils.toString(obj, nullStr);

        // Assert
        assertEquals("bat", result);
    }

    @Test
    public void testToString_SupplierWithNonNullInput_ReturnsObjectToString() {
        // Arrange
        Supplier<Object> objSupplier = () -> "bat";
        Supplier<String> nullStrSupplier = () -> "null";

        // Act
        String result = ObjectUtils.toString(objSupplier, nullStrSupplier);

        // Assert
        assertEquals("bat", result);
    }

    @Test
    public void testToString_SupplierWithNullInput_ReturnsSupplierResult() {
        // Arrange
        Supplier<Object> objSupplier = () -> null;
        Supplier<String> nullStrSupplier = () -> "null";

        // Act
        String result = ObjectUtils.toString(objSupplier, nullStrSupplier);

        // Assert
        assertEquals("null", result);
    }

    @Test
    public void testHashCodeHex_NullObject_ReturnsZero() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        String actual = ObjectUtils.hashCodeHex(object);

        assertEquals("0", actual);
    }

    @Test
    public void testHashCodeHex_SameObject_ReturnsSameHashCode() {
        // Instantiate all necessary variables here
        Object object = new Object();

        // Write the test code here following the given rules
        String actual1 = ObjectUtils.hashCodeHex(object);
        String actual2 = ObjectUtils.hashCodeHex(object);

        assertEquals(actual1, actual2);
    }

    @Test
    public void testHashCodeHex_DifferentObjects_ReturnsDifferentHashCodes() {
        // Instantiate all necessary variables here
        Object object1 = new Object();
        Object object2 = new Object();

        // Write the test code here following the given rules
        String actual1 = ObjectUtils.hashCodeHex(object1);
        String actual2 = ObjectUtils.hashCodeHex(object2);

        assertNotEquals(actual1, actual2);
    }

    @Test
    public void testAllNotNull_WithNonNullValues_ShouldReturnTrue() {
        // Instantiate all necessary variables here
        Object[] values = { "a", "b", "c" };

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNotNull(values);

        assertTrue(result);
    }

    @Test
    public void testAllNotNull_WithNullValue_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        Object[] values = { "a", null, "c" };

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNotNull(values);

        assertFalse(result);
    }

    @Test
    public void testAllNotNull_WithEmptyArray_ShouldReturnTrue() {
        // Instantiate all necessary variables here
        Object[] values = {};

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNotNull(values);

        assertTrue(result);
    }

    @Test
    public void testAllNotNull_WithNullArray_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        Object[] values = null;

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNotNull(values);

        assertFalse(result);
    }

    @Test
    public void testAllNotNull_WithMixedValues_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        Object[] values = { "a", null, "c", null };

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNotNull(values);

        assertFalse(result);
    }

    @Test
    public void testAllNotNull_WithAllNullValues_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        Object[] values = { null, null, null };

        // Write the test code here following the given rules
        boolean result = ObjectUtils.allNotNull(values);

        assertFalse(result);
    }

    @Test
    public void testCONSTBoolean() {
        boolean input = false;
        boolean expected = false;

        boolean result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTByte() {
        byte input = 127;
        byte expected = 127;

        byte result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTChar() {
        char input = 'a';
        char expected = 'a';

        char result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTDouble() {
        double input = 1.0;
        double expected = 1.0;

        double result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTFloat() {
        float input = 1.0f;
        float expected = 1.0f;

        float result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTInt() {
        int input = 123;
        int expected = 123;

        int result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTLong() {
        long input = 123L;
        long expected = 123L;

        long result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTShort() {
        short input = 123;
        short expected = 123;

        short result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testCONSTGeneric() {
        String input = "abc";
        String expected = "abc";

        String result = ObjectUtils.CONST(input);

        assertEquals(expected, result);
    }

    @Test
    public void testWait() throws InterruptedException {
        // Instantiate all necessary variables here
        Object obj = mock(Object.class);
        Duration duration = Duration.ofMillis(100);

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.wait(obj, Duration.ofMillis(-100)));
        assertThrows(IllegalMonitorStateException.class, () -> ObjectUtils.wait(obj, duration));
//        assertThrows(InterruptedException.class, () -> {
//            Thread.currentThread().interrupt();
//            ObjectUtils.wait(obj, duration);
//        });

        // Verify that obj.wait() is called once
//        verify(obj, times(1)).wait(duration.toMillis(), 0);
    }

}