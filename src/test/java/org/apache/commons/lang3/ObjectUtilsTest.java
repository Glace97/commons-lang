package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.*;
import org.junit.jupiter.api.function.Executable;
import java.util.function.Supplier;
import java.lang.reflect.Method;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ObjectUtilsTest {



    @Test
    public void testWaitWithNullDuration() throws InterruptedException {
        Object mockObject = Mockito.mock(Object.class);
        ObjectUtils.wait(mockObject, null);
        verify(mockObject, times(1)).wait(0L);
    }

    @Test
    public void testWaitWithPositiveDuration() throws InterruptedException {
        Object mockObject = Mockito.mock(Object.class);
        ObjectUtils.wait(mockObject, Duration.ofMillis(1000));
        verify(mockObject, times(1)).wait(1000L);
    }

    @Test
    public void testWaitWithNegativeDuration() {
        Object mockObject = Mockito.mock(Object.class);
        assertThrows(IllegalArgumentException.class, () ->
                ObjectUtils.wait(mockObject, Duration.ofMillis(-1000)));
    }

    @Test
    public void testWaitWithObjectNotOwnedByCurrentThread() {
        Object mockObject = new Object();
        assertThrows(IllegalMonitorStateException.class, () ->
                ObjectUtils.wait(mockObject, Duration.ofMillis(1000)));
    }

    @Test
    public void testWaitWithInterruptedThread() {
        Object mockObject = Mockito.mock(Object.class);
        Thread.currentThread().interrupt();
        assertThrows(InterruptedException.class, () ->
                ObjectUtils.wait(mockObject, Duration.ofMillis(1000)));
        Thread.interrupted(); // Clear interrupted status
    }





    @Test
    public void cloneIfPossible_notCloneableObject_returnsSameObject() {
        Object originalObject = new Object();

        Object result = ObjectUtils.cloneIfPossible(originalObject);

        assertSame(originalObject, result);
    }

    @Test
    public void cloneIfPossible_cloneableObject_returnsClone() {
        CloneableObject originalObject = Mockito.mock(CloneableObject.class);
        CloneableObject clone = Mockito.mock(CloneableObject.class);
        Mockito.when(originalObject.clone()).thenReturn(clone);

        Object result = ObjectUtils.cloneIfPossible(originalObject);

        assertSame(clone, result);
    }

    @Test
    public void cloneIfPossible_cloneThrowsException_returnsSameObject() {
        CloneableObject originalObject = Mockito.mock(CloneableObject.class);
        Mockito.when(originalObject.clone()).thenThrow(new CloneFailedException());

        Object result = ObjectUtils.cloneIfPossible(originalObject);

        assertSame(originalObject, result);
    }

    private interface CloneableObject extends Cloneable {
        CloneableObject clone();
    }







    @Test
    public void testMedianWithComparator() {
        Comparator<Integer> comparator = mock(Comparator.class);
        when(comparator.compare(anyInt(), anyInt())).thenAnswer(i -> ((Integer)i.getArgument(0)).compareTo(i.getArgument(1)));
        
        assertEquals(2, ObjectUtils.median(comparator, 1, 2, 3));
        assertThrows(NullPointerException.class, () -> ObjectUtils.median(null, 1, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(comparator, (Integer[])null));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(comparator, new Integer[0]));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(comparator, 1, null, 3));
    }

    @Test
    public void testMedian() {
        assertEquals(2, ObjectUtils.median(1, 2, 3));
        assertThrows(NullPointerException.class, () -> ObjectUtils.median((Integer[])null));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(new Integer[0]));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(1, null, 3));
    }





    @Test
    public void testCONST_Boolean() {
        boolean testValue = true;
        boolean result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }

    @Test
    public void testCONST_Byte() {
        byte testValue = (byte) 127;
        byte result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }

    @Test
    public void testCONST_Char() {
        char testValue = 'a';
        char result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }

    @Test
    public void testCONST_Double() {
        double testValue = 1.0;
        double result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result, 0.0);
    }

    @Test
    public void testCONST_Float() {
        float testValue = 1.0f;
        float result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result, 0.0f);
    }

    @Test
    public void testCONST_Int() {
        int testValue = 123;
        int result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }

    @Test
    public void testCONST_Long() {
        long testValue = 123L;
        long result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }

    @Test
    public void testCONST_Short() {
        short testValue = (short) 123;
        short result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }

    @Test
    public void testCONST_String() {
        String testValue = "abc";
        String result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }

    @Test
    public void testCONST_Object() {
        Object testValue = new Object();
        Object result = ObjectUtils.CONST(testValue);
        assertEquals(testValue, result);
    }





    @Test
    public void testAllNotNullWithNullArray() {
        // test case with null array
        assertFalse(ObjectUtils.allNotNull((Object[]) null));
    }

    @Test
    public void testAllNotNullWithEmptyArray() {
        // test case with empty array
        assertTrue(ObjectUtils.allNotNull());
    }

    @Test
    public void testAllNotNullWithNonNullArray() {
        // test case with non-null array
        assertTrue(ObjectUtils.allNotNull("test", "test"));
    }

    @Test
    public void testAllNotNullWithArrayContainingNull() {
        // test case with array containing null value
        assertFalse(ObjectUtils.allNotNull("test", null));
    }

    @Test
    public void testAllNotNullWithArrayContainingMultipleNulls() {
        // test case with array containing multiple null values
        assertFalse(ObjectUtils.allNotNull(null, null));
    }

    @Test
    public void testAllNotNullWithArrayContainingNullAndNonNull() {
        // test case with array containing both null and non-null values
        assertFalse(ObjectUtils.allNotNull("test", null, "test"));
    }







    @Test
    public void testToStringWithNullObject() {
        String result = ObjectUtils.toString((Object) null);
        assertEquals("", result);
    }

    @Test
    public void testToStringWithEmptyString() {
        String result = ObjectUtils.toString("");
        assertEquals("", result);
    }

    @Test
    public void testToStringWithRegularString() {
        String result = ObjectUtils.toString("bat");
        assertEquals("bat", result);
    }

    @Test
    public void testToStringWithNullObjectAndNullString() {
        String result = ObjectUtils.toString(null, null);
        assertNull(result);
    }

    @Test
    public void testToStringWithNullObjectAndNonNullString() {
        String result = ObjectUtils.toString(null, "null");
        assertEquals("null", result);
    }

    @Test
    public void testToStringWithSupplierAndNullObject() {
        Supplier<Object> nullSupplier = () -> null;
        Supplier<String> stringSupplier = () -> "Supplier String";
        String result = ObjectUtils.toString(nullSupplier, stringSupplier);
        assertEquals("Supplier String", result);
    }

    @Test
    public void testToStringWithSupplierAndNonNullObject() {
        Supplier<Object> nonNullSupplier = () -> "bat";
        Supplier<String> stringSupplier = () -> "Supplier String";
        String result = ObjectUtils.toString(nonNullSupplier, stringSupplier);
        assertEquals("bat", result);
    }







    @Test
    public void testEquals_BothObjectsAreNull_ShouldReturnTrue() {
        assertTrue(ObjectUtils.equals(null, null));
    }

    @Test
    public void testEquals_FirstObjectIsNull_ShouldReturnFalse() {
        assertFalse(ObjectUtils.equals(null, ""));
    }

    @Test
    public void testEquals_SecondObjectIsNull_ShouldReturnFalse() {
        assertFalse(ObjectUtils.equals("", null));
    }

    @Test
    public void testEquals_BothObjectsAreSameEmptyString_ShouldReturnTrue() {
        assertTrue(ObjectUtils.equals("", ""));
    }

    @Test
    public void testEquals_FirstObjectIsBooleanTrueAndSecondIsNull_ShouldReturnFalse() {
        assertFalse(ObjectUtils.equals(Boolean.TRUE, null));
    }

    @Test
    public void testEquals_FirstObjectIsBooleanTrueAndSecondIsStringTrue_ShouldReturnFalse() {
        assertFalse(ObjectUtils.equals(Boolean.TRUE, "true"));
    }

    @Test
    public void testEquals_BothObjectsAreBooleanTrue_ShouldReturnTrue() {
        assertTrue(ObjectUtils.equals(Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void testEquals_FirstObjectIsBooleanTrueAndSecondIsBooleanFalse_ShouldReturnFalse() {
        assertFalse(ObjectUtils.equals(Boolean.TRUE, Boolean.FALSE));
    }






    @Override
    protected ExceptionInCloneObject clone() {
        throw new RuntimeException("Exception in clone");
    }


    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    protected CloneableObject clone() {
        CloneableObject clone = new CloneableObject();
        clone.setValue(this.value);
        return clone;
    }


    // This class intentionally does not implement the clone() method



    @Test
    public void testClone_NullObject() {
        assertNull(ObjectUtils.clone(null));
    }

    @Test
    public void testClone_NotCloneableObject() {
        String nonCloneable = "Non-cloneable object";
        assertNull(ObjectUtils.clone(nonCloneable));
    }

    @Test
    public void testClone_CloneableObject() {
        CloneableObject original = new CloneableObject();
        original.setValue("Original value");

        CloneableObject clone = ObjectUtils.clone(original);

        assertNotNull(clone);
        assertEquals(original.getValue(), clone.getValue());
        assertNotSame(original, clone);
    }

    @Test
    public void testClone_NoCloneMethod() throws NoSuchMethodException {
        NoCloneMethodObject original = new NoCloneMethodObject();

        assertThrows(CloneFailedException.class, () -> ObjectUtils.clone(original));
    }

    @Test
    public void testClone_ExceptionInClone() throws NoSuchMethodException {
        ExceptionInCloneObject original = new ExceptionInCloneObject();

        assertThrows(CloneFailedException.class, () -> ObjectUtils.clone(original));
    }





    @Test
    public void testMaxWithAllNulls() {
        Integer[] values = {null, null, null};
        Integer result = ObjectUtils.max(values);
        assertNull(result);
    }

    @Test
    public void testMaxWithSomeNulls() {
        Integer[] values = {null, 1, 2, 3, null};
        Integer result = ObjectUtils.max(values);
        assertEquals(3, result);
    }

    @Test
    public void testMaxWithNoNulls() {
        Integer[] values = {1, 2, 3, 4};
        Integer result = ObjectUtils.max(values);
        assertEquals(4, result);
    }

    @Test
    public void testMaxWithEmptyValues() {
        Integer[] values = {};
        Integer result = ObjectUtils.max(values);
        assertNull(result);
    }

    @Test
    public void testMaxWithNegativeValues() {
        Integer[] values = {-1, -2, -3};
        Integer result = ObjectUtils.max(values);
        assertEquals(-1, result);
    }

    @Test
    public void testMaxWithAllEqualValues() {
        Integer[] values = {2, 2, 2};
        Integer result = ObjectUtils.max(values);
        assertEquals(2, result);
    }

    @Test
    public void testMaxWithValuesIsNull() {
        Integer[] values = null;
        Integer result = ObjectUtils.max(values);
        assertNull(result);
    }





    @Test
    public void testNotEqualWithNulls() {
        assertTrue(ObjectUtils.notEqual(null, "test"));
        assertTrue(ObjectUtils.notEqual("test", null));
        assertFalse(ObjectUtils.notEqual(null, null));
    }

    @Test
    public void testNotEqualWithSameInstance() {
        String testString = "test";
        assertFalse(ObjectUtils.notEqual(testString, testString));
    }

    @Test
    public void testNotEqualWithEqualObjects() {
        assertFalse(ObjectUtils.notEqual(new Integer(5), new Integer(5)));
    }

    @Test
    public void testNotEqualWithUnequalObjects() {
        assertTrue(ObjectUtils.notEqual("test1", "test2"));
        assertTrue(ObjectUtils.notEqual(new Integer(5), new Integer(6)));
    }





    @Test
    public void testAnyNullWhenAllNull() {
        Object[] values = {null, null, null};
        assertTrue(ObjectUtils.anyNull(values));
    }

    @Test
    public void testAnyNullWhenSomeNull() {
        Object[] values = {null, new Object(), null};
        assertTrue(ObjectUtils.anyNull(values));
    }

    @Test
    public void testAnyNullWhenNoneNull() {
        Object[] values = {new Object(), new Object(), new Object()};
        assertFalse(ObjectUtils.anyNull(values));
    }

    @Test
    public void testAnyNullWhenEmptyArray() {
        Object[] values = {};
        assertTrue(ObjectUtils.anyNull(values));
    }

    @Test
    public void testAnyNullWhenNullArray() {
        Object[] values = null;
        assertTrue(ObjectUtils.anyNull(values));
    }





    @Test
    public void isArray_whenNullObject_shouldReturnFalse() {
        // Given
        Object object = null;

        // When
        boolean result = ObjectUtils.isArray(object);

        // Then
        assertFalse(result);
    }

    @Test
    public void isArray_whenNotAnArray_shouldReturnFalse() {
        // Given
        Object object = "I am not an array";

        // When
        boolean result = ObjectUtils.isArray(object);

        // Then
        assertFalse(result);
    }

    @Test
    public void isArray_whenEmptyArray_shouldReturnTrue() {
        // Given
        Object object = new int[]{};

        // When
        boolean result = ObjectUtils.isArray(object);

        // Then
        assertTrue(result);
    }

    @Test
    public void isArray_whenNonEmptyArray_shouldReturnTrue() {
        // Given
        Object object = new int[]{1, 2, 3};

        // When
        boolean result = ObjectUtils.isArray(object);

        // Then
        assertTrue(result);
    }









    @Test
    public void testGetFirstNonNullWhenAllSuppliersAreNull() {
        Supplier<String> supplier1 = null;
        Supplier<String> supplier2 = null;
        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);
        assertNull(result);
    }

    @Test
    public void testGetFirstNonNullWhenFirstSupplierReturnsNonNull() {
        Supplier<String> supplier1 = () -> "test";
        Supplier<String> supplier2 = () -> null;
        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);
        assertEquals("test", result);
    }

    @Test
    public void testGetFirstNonNullWhenSecondSupplierReturnsNonNull() {
        Supplier<String> supplier1 = () -> null;
        Supplier<String> supplier2 = () -> "test";
        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);
        assertEquals("test", result);
    }

    @Test
    public void testGetFirstNonNullWhenAllSuppliersReturnNull() {
        Supplier<String> supplier1 = () -> null;
        Supplier<String> supplier2 = () -> null;
        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);
        assertNull(result);
    }

    @Test
    public void testGetFirstNonNullWhenMultipleSuppliersReturnNonNull() {
        Supplier<String> supplier1 = () -> "test1";
        Supplier<String> supplier2 = () -> "test2";
        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);
        assertEquals("test1", result);
    }







    @Test
    public void testAnyNotNull_WithNonNullValues() {
        // No variables need to be instantiated
        // Testing with non-null values
        assertTrue(ObjectUtils.anyNotNull(1, "test", new Object()));
    }

    @Test
    public void testAnyNotNull_WithNullAndNonNullValues() {
        // No variables need to be instantiated
        // Testing with a mix of null and non-null values
        assertTrue(ObjectUtils.anyNotNull(null, "test", new Object()));
    }

    @Test
    public void testAnyNotNull_WithAllNullValues() {
        // No variables need to be instantiated
        // Testing with all null values
        assertFalse(ObjectUtils.anyNotNull(null, null, null));
    }

    @Test
    public void testAnyNotNull_WithEmptyValues() {
        // No variables need to be instantiated
        // Testing with empty input
        assertFalse(ObjectUtils.anyNotNull());
    }

    @Test
    public void testAnyNotNull_WithNullValues() {
        // No variables need to be instantiated
        // Testing with null as an input
        assertFalse(ObjectUtils.anyNotNull((Object[]) null));
    }







    @Test
    public void testModeWithEmptyArray() {
        //Given
        Integer[] items = new Integer[0];
        
        //When
        Integer result = ObjectUtils.mode(items);

        //Then
        assertNull(result);
    }

    @Test
    public void testModeWithSingleItemArray() {
        //Given
        Integer[] items = new Integer[]{1};
        
        //When
        Integer result = ObjectUtils.mode(items);

        //Then
        assertEquals(1, result);
    }

    @Test
    public void testModeWithMultipleItemsArray() {
        //Given
        Integer[] items = new Integer[]{1, 2, 2, 3, 3, 3};
        
        //When
        Integer result = ObjectUtils.mode(items);

        //Then
        assertEquals(3, result);
    }

    @Test
    public void testModeWithMultipleModesInArray() {
        //Given
        Integer[] items = new Integer[]{1, 1, 2, 2};
        
        //When
        Integer result = ObjectUtils.mode(items);

        //Then
        assertNull(result);
    }





    @Test
    public void testFirstNonNullWithNonNullValues() {
        String expectedValue = "Test Value";
        String result = ObjectUtils.firstNonNull(null, expectedValue);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testFirstNonNullWithAllNullValues() {
        String result = ObjectUtils.firstNonNull(null, null, null);
        assertNull(result);
    }

    @Test
    public void testFirstNonNullWithMultipleNonNullValues() {
        String expectedValue = "Test Value";
        String result = ObjectUtils.firstNonNull(expectedValue, "Another Value");
        assertEquals(expectedValue, result);
    }

    @Test
    public void testFirstNonNullWithEmptyValues() {
        String result = ObjectUtils.firstNonNull();
        assertNull(result);
    }

    @Test
    public void testFirstNonNullWithNullArray() {
        String result = ObjectUtils.firstNonNull(null);
        assertNull(result);
    }

    @Test
    public void testFirstNonNullWithNonNullArray() {
        String expectedValue = "Test Value";
        String result = ObjectUtils.firstNonNull(new String[]{null, expectedValue});
        assertEquals(expectedValue, result);
    }

    @Test
    public void testFirstNonNullWithAllNullArray() {
        String result = ObjectUtils.firstNonNull(new String[]{null, null, null});
        assertNull(result);
    }















    @Test
    public void testRequireNonEmptyObject() {
        Assertions.assertThrows(NullPointerException.class, () -> ObjectUtils.requireNonEmpty(null));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty(""));
        
        String str = "Test String";
        Assertions.assertEquals(str, ObjectUtils.requireNonEmpty(str));
    }
    
    @Test
    public void testRequireNonEmptyObjectWithMsg() {
        Assertions.assertThrows(NullPointerException.class, () -> ObjectUtils.requireNonEmpty(null, "Object is null"));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty("", "Object is empty"));
        
        String str = "Test String";
        Assertions.assertEquals(str, ObjectUtils.requireNonEmpty(str, "Object is not null or empty"));
    }
    
    @Test
    public void testRequireNonEmptyList() {
        Assertions.assertThrows(NullPointerException.class, () -> ObjectUtils.requireNonEmpty(null));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty(new ArrayList<>()));
        
        ArrayList<String> list = new ArrayList<>();
        list.add("Test");
        Assertions.assertEquals(list, ObjectUtils.requireNonEmpty(list));
    }
    
    @Test
    public void testRequireNonEmptyMap() {
        Assertions.assertThrows(NullPointerException.class, () -> ObjectUtils.requireNonEmpty(null));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty(new HashMap<>()));
        
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "Test");
        Assertions.assertEquals(map, ObjectUtils.requireNonEmpty(map));
    }





    @Test
    public void getIfNullWhenObjectIsNullAndSupplierIsNull() {
        assertNull(ObjectUtils.getIfNull(null, null));
    }

    @Test
    public void getIfNullWhenObjectIsNullAndSupplierReturnsNull() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn(null);
        assertNull(ObjectUtils.getIfNull(null, mockSupplier));
    }

    @Test
    public void getIfNullWhenObjectIsNullAndSupplierReturnsValue() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("zz");
        assertEquals("zz", ObjectUtils.getIfNull(null, mockSupplier));
    }

    @Test
    public void getIfNullWhenObjectIsNotNull() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        assertEquals("abc", ObjectUtils.getIfNull("abc", mockSupplier));
        verify(mockSupplier, never()).get();    // Supplier should never be invoked when object is not null
    }



    @Test
    public void compare_BothObjectsNull_ReturnsZero() {
        Integer obj1 = null;
        Integer obj2 = null;

        int result = ObjectUtils.compare(obj1, obj2);

        assertEquals(0, result);
    }

    @Test
    public void compare_FirstObjectNull_ReturnsNegative() {
        Integer obj1 = null;
        Integer obj2 = 1;

        int result = ObjectUtils.compare(obj1, obj2);

        assertTrue(result < 0);
    }

    @Test
    public void compare_SecondObjectNull_ReturnsPositive() {
        Integer obj1 = 1;
        Integer obj2 = null;

        int result = ObjectUtils.compare(obj1, obj2);

        assertTrue(result > 0);
    }

    @Test
    public void compare_FirstObjectGreater_ReturnsPositive() {
        Integer obj1 = 2;
        Integer obj2 = 1;

        int result = ObjectUtils.compare(obj1, obj2);

        assertTrue(result > 0);
    }

    @Test
    public void compare_SecondObjectGreater_ReturnsNegative() {
        Integer obj1 = 1;
        Integer obj2 = 2;

        int result = ObjectUtils.compare(obj1, obj2);

        assertTrue(result < 0);
    }

    @Test
    public void compare_ObjectsEqual_ReturnsZero() {
        Integer obj1 = 1;
        Integer obj2 = 1;

        int result = ObjectUtils.compare(obj1, obj2);

        assertEquals(0, result);
    }





    @Test
    public void whenObjectIsNull_returnDefaultValue() {
        String object = null;
        String defaultValue = "default";
        
        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertEquals(defaultValue, result, "Expected default value when object is null");
    }

    @Test
    public void whenObjectIsNotNull_returnObject() {
        String object = "notNull";
        String defaultValue = "default";

        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertEquals(object, result, "Expected object when object is not null");
    }

    @Test
    public void whenObjectAndDefaultValueAreNull_returnNull() {
        String object = null;
        String defaultValue = null;

        String result = ObjectUtils.defaultIfNull(object, defaultValue);

        assertNull(result, "Expected null when object and default value are null");
    }




    @Test
    public void allNull_withNullValues_returnTrue() {
        // Instantiate all necessary variables here
        Object[] values = {null, null, null};
        
        // Write the test code here following the given rules
        assertTrue(ObjectUtils.allNull(values), "Should return true when all values are null.");
    }
    
    @Test
    public void allNull_withOneNotNullValue_returnFalse() {
        // Instantiate all necessary variables here
        Object[] values = {null, "notNull", null};

        // Write the test code here following the given rules
        assertFalse(ObjectUtils.allNull(values), "Should return false when there is at least one non-null value.");
    }

    @Test
    public void allNull_withAllNotNullValue_returnFalse() {
        // Instantiate all necessary variables here
        Object[] values = {"notNull", "notNull"};
        
        // Write the test code here following the given rules
        assertFalse(ObjectUtils.allNull(values), "Should return false when all values are non-null.");
    }

    @Test
    public void allNull_withEmptyArray_returnTrue() {
        // Instantiate all necessary variables here
        Object[] values = {};
        
        // Write the test code here following the given rules
        assertTrue(ObjectUtils.allNull(values), "Should return true when array is empty.");
    }

    @Test
    public void allNull_withNullArray_returnTrue() {
        // Instantiate all necessary variables here
        Object[] values = null;
        
        // Write the test code here following the given rules
        assertTrue(ObjectUtils.allNull(values), "Should return true when array is null.");
    }





    @Test
    public void testIdentityHashCodeHex() {
        // Instantiate all necessary variables here
        Object testObject = new Object();

        // Write the test code here following the given rules
        String expectedHashCodeHex = Integer.toHexString(System.identityHashCode(testObject));
        String actualHashCodeHex = ObjectUtils.identityHashCodeHex(testObject);

        assertEquals(expectedHashCodeHex, actualHashCodeHex, "The returned hashCodeHex should match the expected hashCodeHex");
    }

    @Test
    public void testIdentityHashCodeHexWithNullObject() {
        // Instantiate all necessary variables here
        Object testObject = null;

        // Write the test code here following the given rules
        String expectedHashCodeHex = Integer.toHexString(System.identityHashCode(testObject));
        String actualHashCodeHex = ObjectUtils.identityHashCodeHex(testObject);

        assertEquals(expectedHashCodeHex, actualHashCodeHex, "The returned hashCodeHex should match the expected hashCodeHex even when the object is null");
    }




    @Test
    public void testIsEmpty_WithNullObject() {
        assertTrue(ObjectUtils.isEmpty(null));
    }

    @Test
    public void testIsEmpty_WithEmptyString() {
        assertTrue(ObjectUtils.isEmpty(""));
    }

    @Test
    public void testIsEmpty_WithNonEmptyString() {
        assertFalse(ObjectUtils.isEmpty("Not empty"));
    }

    @Test
    public void testIsEmpty_WithEmptyArray() {
        assertTrue(ObjectUtils.isEmpty(new int[]{}));
    }

    @Test
    public void testIsEmpty_WithNonEmptyArray() {
        assertFalse(ObjectUtils.isEmpty(new int[]{1,2,3}));
    }

    @Test
    public void testIsEmpty_WithEmptyCollection() {
        assertTrue(ObjectUtils.isEmpty(new ArrayList<>()));
    }

    @Test
    public void testIsEmpty_WithNonEmptyCollection() {
        List<String> list = new ArrayList<>();
        list.add("Element");
        assertFalse(ObjectUtils.isEmpty(list));
    }

    @Test
    public void testIsEmpty_WithEmptyMap() {
        assertTrue(ObjectUtils.isEmpty(new HashMap<>()));
    }

    @Test
    public void testIsEmpty_WithNonEmptyMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        assertFalse(ObjectUtils.isEmpty(map));
    }

    @Test
    public void testIsEmpty_WithEmptyOptional() {
        assertTrue(ObjectUtils.isEmpty(Optional.empty()));
    }

    @Test
    public void testIsEmpty_WithNonEmptyOptional() {
        Optional<String> optional = Optional.of("Not empty");
        assertFalse(ObjectUtils.isEmpty(optional));
    }

    @Test
    public void testIsEmpty_WithUnsupportedType() {
        assertFalse(ObjectUtils.isEmpty(new Object()));
    }




    @Test
    public void testConstShort_WithinRange() {
        // Instantiate necessary variables
        int inputValue = 1000;

        // Invoke test method
        short result = ObjectUtils.CONST_SHORT(inputValue);

        // Assert that the result matches the expectation
        assertEquals(inputValue, result);
    }

    @Test
    public void testConstShort_AtLowerBoundary() {
        // Instantiate necessary variables
        int inputValue = -32768;

        // Invoke test method
        short result = ObjectUtils.CONST_SHORT(inputValue);

        // Assert that the result matches the expectation
        assertEquals(inputValue, result);
    }

    @Test
    public void testConstShort_AtUpperBoundary() {
        // Instantiate necessary variables
        int inputValue = 32767;

        // Invoke test method
        short result = ObjectUtils.CONST_SHORT(inputValue);

        // Assert that the result matches the expectation
        assertEquals(inputValue, result);
    }

    @Test
    public void testConstShort_OutsideRange_Negative() {
        // Instantiate necessary variables
        int inputValue = -32769;

        // Assert that an exception of type IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.CONST_SHORT(inputValue));
    }

    @Test
    public void testConstShort_OutsideRange_Positive() {
        // Instantiate necessary variables
        int inputValue = 32768;

        // Assert that an exception of type IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.CONST_SHORT(inputValue));
    }






    @Test
    public void testHashCodeWithNonNullObject() {
        // Instantiate a dummy object
        Object obj = new Object();
        int expectedHash = obj.hashCode();

        // Use the ObjectUtils hashCode method
        int actualHash = ObjectUtils.hashCode(obj);

        // Check if the expected and actual hash codes are equal
        assertEquals(expectedHash, actualHash, "The hash codes should be equal for non-null objects");
    }

    @Test
    public void testHashCodeWithNullObject() {
        // Use the ObjectUtils hashCode method with a null object
        int actualHash = ObjectUtils.hashCode(null);

        // The hash code of a null object should be zero
        assertEquals(0, actualHash, "The hash code of a null object should be zero");
    }





    @Test
    public void shouldReturnOneWhenNullIsPassed() {
        // When
        int result = ObjectUtils.hashCodeMulti((Object[]) null);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnCorrectHashCodeWhenSingleObjectIsPassed() {
        // Given
        Object object = new Object();
        int expected = 31 + object.hashCode();

        // When
        int result = ObjectUtils.hashCodeMulti(object);

        // Then
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnCorrectHashCodeWhenMultipleObjectsArePassed() {
        // Given
        Object object1 = new Object();
        Object object2 = new Object();
        int expected = ((31 + object1.hashCode()) * 31 + object2.hashCode());

        // When
        int result = ObjectUtils.hashCodeMulti(object1, object2);

        // Then
        assertEquals(expected, result);
    }





    @Test
    public void constByte_ValidByte_ReturnsSameByte() {
        // Test the CONST_BYTE function with valid byte
        int v = 100;
        byte result = ObjectUtils.CONST_BYTE(v);
        assertEquals((byte)v, result, "CONST_BYTE does not return the same byte value.");
    }

    @Test
    public void constByte_ValidNegativeByte_ReturnsSameByte() {
        // Test the CONST_BYTE function with valid negative byte
        int v = -100;
        byte result = ObjectUtils.CONST_BYTE(v);
        assertEquals((byte)v, result, "CONST_BYTE does not return the same byte value.");
    }

    @Test
    public void constByte_ByteMinValue_ReturnsMinValue() {
        // Test the CONST_BYTE function with Byte.MIN_VALUE
        int v = Byte.MIN_VALUE;
        byte result = ObjectUtils.CONST_BYTE(v);
        assertEquals((byte)v, result, "CONST_BYTE does not return the minimum byte value.");
    }

    @Test
    public void constByte_ByteMaxValue_ReturnsMaxValue() {
        // Test the CONST_BYTE function with Byte.MAX_VALUE
        int v = Byte.MAX_VALUE;
        byte result = ObjectUtils.CONST_BYTE(v);
        assertEquals((byte)v, result, "CONST_BYTE does not return the maximum byte value.");
    }

    @Test
    public void constByte_ValueTooLarge_ThrowsIllegalArgumentException() {
        // Test the CONST_BYTE function with a value larger than Byte.MAX_VALUE
        int v = Byte.MAX_VALUE + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.CONST_BYTE(v);
        }, "CONST_BYTE should throw an IllegalArgumentException for values larger than Byte.MAX_VALUE.");
    }

    @Test
    public void constByte_ValueTooSmall_ThrowsIllegalArgumentException() {
        // Test the CONST_BYTE function with a value smaller than Byte.MIN_VALUE
        int v = Byte.MIN_VALUE - 1;
        assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.CONST_BYTE(v);
        }, "CONST_BYTE should throw an IllegalArgumentException for values smaller than Byte.MIN_VALUE.");
    }




    @Test
    public void testGetClass_NullObject() {
        // Test case: the input object is null
        // Expected result: the return value is null

        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        Class<?> result = ObjectUtils.getClass(object);

        // Assert
        assertNull(result, "The result should be null when the object is null.");
    }

    @Test
    public void testGetClass_NonNullObject() {
        // Test case: the input object is not null
        // Expected result: the return value is equal to the class of the object

        // Instantiate all necessary variables here
        String object = "Test String";

        // Write the test code here following the given rules
        Class<?> result = ObjectUtils.getClass(object);

        // Assert
        assertEquals(String.class, result, "The result should be equal to the class of the object.");
    }

    @Test
    public void testGetClass_ObjectIsObjectUtils() {
        // Test case: the input object is an instance of ObjectUtils
        // Expected result: the return value is ObjectUtils.class

        // Instantiate all necessary variables here
        ObjectUtils object = new ObjectUtils();

        // Write the test code here following the given rules
        Class<?> result = ObjectUtils.getClass(object);

        // Assert
        assertEquals(ObjectUtils.class, result, "The result should be ObjectUtils.class when the object is an instance of ObjectUtils.");
    }









    @Test
    public void testMin_WithNullValues() {
        Integer[] values = {null, 2, 3, 4};
        Integer min = ObjectUtils.min(values);
        assertEquals(2, min);
    }

    @Test
    public void testMin_WithNonNullValues() {
        Integer[] values = {1, 2, 3, 4};
        Integer min = ObjectUtils.min(values);
        assertEquals(1, min);
    }

    @Test
    public void testMin_WithAllNullValues() {
        Integer[] values = {null, null, null, null};
        Integer min = ObjectUtils.min(values);
        assertNull(min);
    }

    @Test
    public void testMin_WithEmptyValues() {
        Integer[] values = {};
        Integer min = ObjectUtils.min(values);
        assertNull(min);
    }

    @Test
    public void testMin_WithSingleValue() {
        Integer[] values = {1};
        Integer min = ObjectUtils.min(values);
        assertEquals(1, min);
    }





    @Test
    public void shouldReturnFalseWhenObjectIsNull() {
        Object object = null;
        assertFalse(ObjectUtils.isNotEmpty(object));
    }

    @Test
    public void shouldReturnFalseWhenObjectIsEmptyString() {
        Object object = "";
        assertFalse(ObjectUtils.isNotEmpty(object));
    }

    @Test
    public void shouldReturnTrueWhenObjectIsNonEmptyString() {
        Object object = "abc";
        assertTrue(ObjectUtils.isNotEmpty(object));
    }

    @Test
    public void shouldReturnFalseWhenObjectIsEmptyArray() {
        Object object = new int[]{};
        assertFalse(ObjectUtils.isNotEmpty(object));
    }

    @Test
    public void shouldReturnTrueWhenObjectIsNonEmptyArray() {
        Object object = new int[]{1, 2, 3};
        assertTrue(ObjectUtils.isNotEmpty(object));
    }

    @Test
    public void shouldReturnFalseWhenObjectIsEmptyCollection() {
        Collection<Object> collection = new ArrayList<>();
        assertFalse(ObjectUtils.isNotEmpty(collection));
    }

    @Test
    public void shouldReturnTrueWhenObjectIsNonEmptyCollection() {
        Collection<Object> collection = new ArrayList<>();
        collection.add("element");
        assertTrue(ObjectUtils.isNotEmpty(collection));
    }

    @Test
    public void shouldReturnTrueWhenObjectIsInteger() {
        Object object = 1234;
        assertTrue(ObjectUtils.isNotEmpty(object));
    }

    @Test
    public void shouldReturnFalseWhenObjectIsEmptyOptional() {
        Optional<Object> optional = Optional.empty();
        assertFalse(ObjectUtils.isNotEmpty(optional));
    }

    @Test
    public void shouldReturnTrueWhenObjectIsNonEmptyOptional() {
        Optional<Object> optional = Optional.of("element");
        assertTrue(ObjectUtils.isNotEmpty(optional));
    }





    @Test
    public void testHashCodeHexWithNonNullObject() {
        Object mockObject = mock(Object.class);
        when(mockObject.hashCode()).thenReturn(123456);

        String hexCode = ObjectUtils.hashCodeHex(mockObject);

        assertEquals(Integer.toHexString(mockObject.hashCode()), hexCode);
        verify(mockObject).hashCode();
    }

    @Test
    public void testHashCodeHexWithNullObject() {
        String hexCode = ObjectUtils.hashCodeHex(null);
        assertEquals(Integer.toHexString(0), hexCode);
    }

    @Test
    public void testHashCodeHexWithObjectHavingZeroHashCode() {
        Object mockObject = mock(Object.class);
        when(mockObject.hashCode()).thenReturn(0);

        String hexCode = ObjectUtils.hashCodeHex(mockObject);

        assertEquals(Integer.toHexString(mockObject.hashCode()), hexCode);
        verify(mockObject).hashCode();
    }







    @Test
    public void testIdentityToStringWithNullObject() {
        assertNull(ObjectUtils.identityToString(null));
    }

    @Test
    public void testIdentityToStringWithNonNullObject() {
        String expected = "java.lang.String@" + Integer.toHexString(System.identityHashCode("testString"));
        assertEquals(expected, ObjectUtils.identityToString("testString"));
    }

    @Test
    public void testIdentityToStringWithNonNullObjectAppendable() throws IOException {
        StringBuilder builder = new StringBuilder();
        ObjectUtils.identityToString(builder, "testString");
        String expected = "java.lang.String@" + Integer.toHexString(System.identityHashCode("testString"));
        assertEquals(expected, builder.toString());
    }

    @Test
    public void testIdentityToStringWithNullObjectAppendable() {
        StringBuilder builder = new StringBuilder();
        assertThrows(NullPointerException.class, () -> ObjectUtils.identityToString(builder, null));
    }

    @Test
    public void testIdentityToStringWithNonNullObjectStringBuffer() {
        StringBuffer buffer = new StringBuffer();
        ObjectUtils.identityToString(buffer, "testString");
        String expected = "java.lang.String@" + Integer.toHexString(System.identityHashCode("testString"));
        assertEquals(expected, buffer.toString());
    }

    @Test
    public void testIdentityToStringWithNullObjectStringBuffer() {
        StringBuffer buffer = new StringBuffer();
        assertThrows(NullPointerException.class, () -> ObjectUtils.identityToString(buffer, null));
    }



}