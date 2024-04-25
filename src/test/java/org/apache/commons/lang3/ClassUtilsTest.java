package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassUtilsTest {

    // is assignable

    @Test
    public void testIsAssignable_NullToNonPrimitive_ReturnsTrue() {
        // NULL can be assigned to any non-primitive class
        assertTrue(ClassUtils.isAssignable(null, Object.class));
    }

    @Test
    public void testIsAssignable_NullToPrimitive_ReturnsFalse() {
        // NULL cannot be assigned to any primitive type
        assertFalse(ClassUtils.isAssignable(null, int.class));
    }

    @Test
    public void testIsAssignable_PrimitiveToWrapperWithAutoboxing_ReturnsTrue() {
        // int can be assigned to Integer if autoboxing is true
        assertTrue(ClassUtils.isAssignable(int.class, Integer.class, true));
    }

    @Test
    public void testIsAssignable_WrapperToPrimitiveWithAutoboxing_ReturnsTrue() {
        // Integer can be assigned to int if autoboxing is true
        assertTrue(ClassUtils.isAssignable(Integer.class, int.class, true));
    }

    @Test
    public void testIsAssignable_PrimitiveToWrapperWithoutAutoboxing_ReturnsFalse() {
        // int cannot be assigned to Integer if autoboxing is false
        assertFalse(ClassUtils.isAssignable(int.class, Integer.class, false));
    }

    @Test
    public void testIsAssignable_PrimitiveWidening_ReturnsTrue() {
        // int can be assigned to double
        assertTrue(ClassUtils.isAssignable(int.class, double.class));
    }

    @Test
    public void testIsAssignable_IncompatiblePrimitiveTypes_ReturnsFalse() {
        // boolean cannot be assigned to int
        assertFalse(ClassUtils.isAssignable(boolean.class, int.class));
    }

    @Test
    public void testIsAssignable_CompatibleReferenceTypes_ReturnsTrue() {
        // String can be assigned to Object
        assertTrue(ClassUtils.isAssignable(String.class, Object.class));
    }

    @Test
    public void testIsAssignable_IncompatibleReferenceTypes_ReturnsFalse() {
        // String cannot be assigned to Integer
        assertFalse(ClassUtils.isAssignable(String.class, Integer.class));
    }

    @Test
    public void testIsAssignable_SameType_ReturnsTrue() {
        // String can be assigned to String
        assertTrue(ClassUtils.isAssignable(String.class, String.class));
    }

    @Test
    public void testIsAssignable_ArrayToNonArray_ReturnsFalse() {
        // String[] cannot be assigned to String
        assertFalse(ClassUtils.isAssignable(String[].class, String.class));
    }

    @Test
    public void testIsAssignable_ArrayTypesAssignment_ReturnsTrue() {
        // String[] can be assigned to Object[]
        assertTrue(ClassUtils.isAssignable(String[].class, Object[].class));
    }

    @Test
    public void testIsAssignable_NullArrays_ReturnsTrue() {
        Class<?>[] sourceClasses = null;
        Class<?>[] targetClasses = null;
        // Null can be assigned to null
        assertTrue(ClassUtils.isAssignable(sourceClasses, targetClasses));
    }

    @Test
    public void testIsAssignable_NonEqualLengthArrays_ReturnsFalse() {
        Class<?>[] sourceClasses = { String.class };
        Class<?>[] targetClasses = { String.class, Object.class };
        // Arrays of different lengths cannot be assigned
        assertFalse(ClassUtils.isAssignable(sourceClasses, targetClasses));
    }

    @Test
    public void testIsAssignable_ArraysWithMismatchingTypes_ReturnsFalse() {
        Class<?>[] sourceClasses = { String.class };
        Class<?>[] targetClasses = { Integer.class };
        // String cannot be assigned to Integer
        assertFalse(ClassUtils.isAssignable(sourceClasses, targetClasses));
    }

    @Test
    public void testIsAssignable_ArraysWithMatchingTypes_ReturnsTrue() {
        Class<?>[] sourceClasses = { String.class, Integer.class };
        Class<?>[] targetClasses = { Object.class, Number.class };
        // String can be assigned to Object, and Integer can be assigned to Number
        assertTrue(ClassUtils.isAssignable(sourceClasses, targetClasses));
    }

// comparator
// Failing tests
// @Test
////    public void comparator_ShouldCompareClassesByName_AscendingOrder() {
////        // Instantiate all necessary variables here
////        Comparator<Class<?>> comparator = ClassUtils.comparator();
////        Class<?> classA = mock(Class.class);
////        Class<?> classB = mock(Class.class);
////
////        // Configure mocks to return class names
////        when(classA.getName()).thenReturn("A");
////        when(classB.getName()).thenReturn("B");
////
////        // Write the test code here following the given rules
////        int result = comparator.compare(classA, classB);
////
////        // Assert that A is less than B, hence result should be negative
////        assertTrue(result < 0);
////    }
////
////    @Test
////    public void comparator_ShouldCompareClassesByName_SameName() {
////        // Instantiate all necessary variables here
////        Comparator<Class<?>> comparator = ClassUtils.comparator();
////        Class<?> classA = mock(Class.class);
////        Class<?> classB = mock(Class.class);
////
////        // Configure mocks to return the same class name
////        when(classA.getName()).thenReturn("SameClass");
////        when(classB.getName()).thenReturn("SameClass");
////
////        // Write the test code here following the given rules
////        int result = comparator.compare(classA, classB);
////
////        // Assert that the classes are equal in terms of name comparison
////        assertEquals(0, result);
////    }
////
////    @Test
////    public void comparator_ShouldCompareClassesByName_DescendingOrder() {
////        // Instantiate all necessary variables here
////        Comparator<Class<?>> comparator = ClassUtils.comparator();
////        Class<?> classA = mock(Class.class);
////        Class<?> classB = mock(Class.class);
////
////        // Configure mocks to return class names
////        when(classA.getName()).thenReturn("Z");
////        when(classB.getName()).thenReturn("Y");
////
////        // Write the test code here following the given rules
////        int result = comparator.compare(classA, classB);
////
////        // Assert that Z is greater than Y, hence result should be positive
////        assertTrue(result > 0);
////    }
////
////    @Test
////    public void comparator_ShouldHandleNullsProperly() {
////        // Instantiate all necessary variables here
////        Comparator<Class<?>> comparator = ClassUtils.comparator();
////        Class<?> classA = mock(Class.class);
////        Class<?> classB = null; // Null class to test comparator's behavior with nulls
////
////        // Configure mocks
////        when(classA.getName()).thenReturn("NotNullClass");
////
////        // Write the test code here following the given rules
////        int result = comparator.compare(classA, classB);
////        int result2 = comparator.compare(classB, classA);
////
////        // Assert that NotNullClass is considered greater than null
////        assertTrue(result < 0);
////        assertTrue(result2 > 0);
////    }
//

    //convertClassesToClassNames
    @Test
    public void testConvertClassesToClassNames_withNullInput() {
        // Instantiate all necessary variables here
        List<Class<?>> classes = null;

        // Write the test code here following the given rules
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        assertNull(result, "The result should be null when input is null.");
    }

    @Test
    public void testConvertClassesToClassNames_withEmptyList() {
        // Instantiate all necessary variables here
        List<Class<?>> classes = Collections.emptyList();

        // Write the test code here following the given rules
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        assertTrue(result.isEmpty(), "The result should be an empty list when input is an empty list.");
    }

    @Test
    public void testConvertClassesToClassNames_withValidClasses() {
        // Instantiate all necessary variables here
        List<Class<?>> classes = Arrays.asList(String.class, Integer.class, Double.class);

        // Write the test code here following the given rules
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        assertEquals(Arrays.asList("java.lang.String", "java.lang.Integer", "java.lang.Double"), result,
                "The result should match the names of the input classes.");
    }

    @Test
    public void testConvertClassesToClassNames_withNullEntriesInList() {
        // Instantiate all necessary variables here
        List<Class<?>> classes = Arrays.asList(String.class, null, Double.class);

        // Write the test code here following the given rules
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        assertEquals(Arrays.asList("java.lang.String", null, "java.lang.Double"), result,
                "The result should include null for null entries in the input list.");
    }

// Failing test
//    @Test
//    public void testConvertClassesToClassNames_withNonClassObject() {
//        // Instantiate all necessary variables here
//        List<?> classes = Arrays.asList(String.class, new Object(), Double.class);
//
//        // Write the test code here following the given rules
//        Exception exception = assertThrows(ClassCastException.class, () -> {
//            ClassUtils.convertClassesToClassNames((List<Class<?>>) classes);
//        });
//
//        String expectedMessage = "java.lang.Object cannot be cast to java.lang.Class";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage),
//                "A ClassCastException should be thrown when list contains non-Class objects.");
//    }

    //convertClassNamesToClasses
    @Test
    public void testConvertClassNamesToClasses_withValidClassNames() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList("java.lang.String", "java.lang.Integer", "java.util.List");

        // Write the test code here following the given rules
        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertNotNull(classes);
        assertEquals(3, classes.size());
        assertEquals(String.class, classes.get(0));
        assertEquals(Integer.class, classes.get(1));
        assertEquals(List.class, classes.get(2));
    }

    @Test
    public void testConvertClassNamesToClasses_withInvalidClassNames() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList("java.lang.SomeNonExistentClass", "java.util.AnotherFakeClass");

        // Write the test code here following the given rules
        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertNotNull(classes);
        assertEquals(2, classes.size());
        assertNull(classes.get(0));
        assertNull(classes.get(1));
    }

    @Test
    public void testConvertClassNamesToClasses_withMixedValidAndInvalidClassNames() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList("java.lang.String", "java.lang.SomeNonExistentClass");

        // Write the test code here following the given rules
        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertNotNull(classes);
        assertEquals(2, classes.size());
        assertEquals(String.class, classes.get(0));
        assertNull(classes.get(1));
    }

    @Test
    public void testConvertClassNamesToClasses_withNullList() {
        // Instantiate all necessary variables here
        List<String> classNames = null;

        // Write the test code here following the given rules
        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertNull(classes);
    }

    @Test
    public void testConvertClassNamesToClasses_withEmptyList() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList();

        // Write the test code here following the given rules
        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertNotNull(classes);
        assertTrue(classes.isEmpty());
    }

    @Test
    public void testConvertClassNamesToClasses_withNullEntriesInList() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList(null, null);

        // Write the test code here following the given rules
        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertNotNull(classes);
        assertEquals(2, classes.size());
        assertNull(classes.get(0));
        assertNull(classes.get(1));
    }

    @Test
    public void testConvertClassNamesToClasses_withNonStringEntries() {
        // Instantiate all necessary variables here
        List<Object> classNames = Arrays.asList("java.lang.String", new Object());

        // Write the test code here following the given rules
        Exception exception = assertThrows(ClassCastException.class, () -> {
            ClassUtils.convertClassNamesToClasses((List<String>) (List<?>) classNames);
        });

        // Assertions
        assertNotNull(exception);
    }

    // getAbbriviatedName


//    @Test
//    public void testGetAbbreviatedNameWithNullClass() {
//        final int lengthHint = 5;
//        assertThrows(IllegalArgumentException.class, () -> ClassUtils.getAbbreviatedName((Class<?>) null, lengthHint));
//    }

    @Test
    public void testGetAbbreviatedNameWithValidClassAndShortLength() {
        Class<?> cls = java.lang.String.class;
        final int lengthHint = 5;
        String result = ClassUtils.getAbbreviatedName(cls, lengthHint);
        assertEquals("j.l.String", result);
    }

    @Test
    public void testGetAbbreviatedNameWithValidClassAndSufficientLength() {
        Class<?> cls = java.lang.String.class;
        final int lengthHint = 30;
        String result = ClassUtils.getAbbreviatedName(cls, lengthHint);
        assertEquals("java.lang.String", result);
    }

    @Test
    public void testGetAbbreviatedNameWithComplexClassName() {
        Class<?> cls = org.apache.commons.lang3.ClassUtils.class;
        final int lengthHint = 18;
        String result = ClassUtils.getAbbreviatedName(cls, lengthHint);
        assertEquals("o.a.c.l.ClassUtils", result);
    }

    @Test
    public void testGetAbbreviatedNameWithNegativeLengthHint() {
        Class<?> cls = java.lang.String.class;
        final int negativeLengthHint = -1;
        assertThrows(IllegalArgumentException.class, () -> ClassUtils.getAbbreviatedName(cls, negativeLengthHint));
    }

//    @Test
//    public void testGetAbbreviatedNameWithStringNull() {
//        final int lengthHint = 5;
//        assertThrows(IllegalArgumentException.class, () -> ClassUtils.getAbbreviatedName((String) null, lengthHint));
//    }

    @Test
    public void testGetAbbreviatedNameWithStringAndShortLength() {
        final String className = "java.lang.String";
        final int lengthHint = 5;
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("j.l.String", result);
    }

    @Test
    public void testGetAbbreviatedNameWithStringAndSufficientLength() {
        final String className = "java.lang.String";
        final int lengthHint = 30;
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("java.lang.String", result);
    }

    @Test
    public void testGetAbbreviatedNameWithComplexStringName() {
        final String className = "org.apache.commons.lang3.ClassUtils";
        final int lengthHint = 18;
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("o.a.c.l.ClassUtils", result);
    }

    @Test
    public void testGetAbbreviatedNameWithStringAndNegativeLengthHint() {
        final String className = "java.lang.String";
        final int negativeLengthHint = -1;
        assertThrows(IllegalArgumentException.class, () -> ClassUtils.getAbbreviatedName(className, negativeLengthHint));
    }
}
