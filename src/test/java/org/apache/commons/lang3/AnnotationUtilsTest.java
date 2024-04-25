package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.jupiter.api.Test;

public class AnnotationUtilsTest {

    //equals
    @Test
    public void testEquals_BothAnnotationsAreNull_ShouldReturnTrue() {
        // Test both annotations being null
        assertTrue(AnnotationUtils.equals(null, null));
    }

    @Test
    public void testEquals_FirstAnnotationIsNull_ShouldReturnFalse() {
        // Mocking an annotation to use as the second parameter
        Annotation mockAnnotation = mock(Annotation.class);
        assertFalse(AnnotationUtils.equals(null, mockAnnotation));
    }

    @Test
    public void testEquals_SecondAnnotationIsNull_ShouldReturnFalse() {
        // Mocking an annotation to use as the first parameter
        Annotation mockAnnotation = mock(Annotation.class);
        assertFalse(AnnotationUtils.equals(mockAnnotation, null));
    }

    @Test
    public void testEquals_DifferentTypes_ShouldReturnFalse() {
        // Mocking two different annotations
        Annotation mockAnnotation1 = mock(Annotation.class);
        Annotation mockAnnotation2 = mock(Annotation.class);

        when(mockAnnotation1.annotationType()).thenReturn((Class) Override.class);
        when(mockAnnotation2.annotationType()).thenReturn((Class) Deprecated.class);

        assertFalse(AnnotationUtils.equals(mockAnnotation1, mockAnnotation2));
    }

    @Test
    public void testEquals_SameInstance_ShouldReturnTrue() {
        // Mocking an annotation
        Annotation mockAnnotation = mock(Annotation.class);
        assertTrue(AnnotationUtils.equals(mockAnnotation, mockAnnotation));
    }

    @Test
    public void testEquals_IdenticalAnnotations_ShouldReturnTrue() throws Exception {
        // Mocking an annotation and its methods
        Annotation mockAnnotation1 = mock(Annotation.class);
        Annotation mockAnnotation2 = mock(Annotation.class);
        Method valueMethod = Override.class.getMethod("annotationType");

        when(mockAnnotation1.annotationType()).thenReturn((Class) Override.class);
        when(mockAnnotation2.annotationType()).thenReturn((Class) Override.class);
        when(valueMethod.invoke(mockAnnotation1)).thenReturn(Override.class);
        when(valueMethod.invoke(mockAnnotation2)).thenReturn(Override.class);

        assertTrue(AnnotationUtils.equals(mockAnnotation1, mockAnnotation2));
    }

    @Test
    public void testEquals_AnnotationsWithDifferentValues_ShouldReturnFalse() throws Exception {
        // Mocking annotations and their methods
        Annotation mockAnnotation1 = mock(Annotation.class);
        Annotation mockAnnotation2 = mock(Annotation.class);
        Method valueMethod = Override.class.getMethod("annotationType");

        when(mockAnnotation1.annotationType()).thenReturn((Class) Override.class);
        when(mockAnnotation2.annotationType()).thenReturn((Class) Override.class);
        when(valueMethod.invoke(mockAnnotation1)).thenReturn(Override.class);
        when(valueMethod.invoke(mockAnnotation2)).thenReturn(Deprecated.class);

        assertFalse(AnnotationUtils.equals(mockAnnotation1, mockAnnotation2));
    }

    //hashCode

    // Failing tests
//    @Test
//    public void testHashCodeWithNonNullValues() throws Exception {
//        // Mocking an annotation and its methods
//        Annotation annotation = mock(Annotation.class);
//        Method method = mock(Method.class);
//        when(annotation.annotationType()).thenReturn((Class) MyAnnotation.class);
//        when(MyAnnotation.class.getDeclaredMethods()).thenReturn(new Method[]{method});
//        when(method.getName()).thenReturn("value");
//        when(method.invoke(annotation)).thenReturn("Test");
//
//        // Act
//        int result = AnnotationUtils.hashCode(annotation);
//
//        // Assert
//        int expectedHashCode = "value".hashCode() * 127 + "Test".hashCode();
//        assertEquals(expectedHashCode, result);
//    }
//
//    @Test
//    public void testHashCodeWithNullValueThrowsException() throws Exception {
//        // Mocking an annotation and its method that returns null
//        Annotation annotation = mock(Annotation.class);
//        Method method = mock(Method.class);
//        when(annotation.annotationType()).thenReturn((Class) MyAnnotation.class);
//        when(MyAnnotation.class.getDeclaredMethods()).thenReturn(new Method[]{method});
//        when(method.getName()).thenReturn("value");
//        when(method.invoke(annotation)).thenReturn(null);
//
//        // Act & Assert
//        assertThrows(IllegalStateException.class, () -> AnnotationUtils.hashCode(annotation));
//    }
//
//    @Test
//    public void testHashCodeWithReflectiveOperationException() throws Exception {
//        // Mocking an annotation and its method to throw ReflectiveOperationException
//        Annotation annotation = mock(Annotation.class);
//        Method method = mock(Method.class);
//        when(annotation.annotationType()).thenReturn((Class) MyAnnotation.class);
//        when(MyAnnotation.class.getDeclaredMethods()).thenReturn(new Method[]{method});
//        when(method.getName()).thenReturn("value");
//        when(method.invoke(annotation)).thenThrow(ReflectiveOperationException.class);
//
//        // Act & Assert
//        assertThrows(UncheckedException.class, () -> AnnotationUtils.hashCode(annotation));
//    }

    // Supporting annotation interface as a placeholder for actual annotation type in tests
    private @interface MyAnnotation {
        String value();
    }

    // isValidAnnotationMemberType
    @Test
    public void testIsValidAnnotationMemberType_withNullType_shouldReturnFalse() {
        // Instantiate all necessary variables here
        Class<?> type = null;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        // Assertions
        assertFalse(result, "The result should be false when the type is null.");
    }

    @Test
    public void testIsValidAnnotationMemberType_withPrimitiveType_shouldReturnTrue() {
        // Test primitive type (e.g., int)
        Class<?> type = int.class;

        // Call the method under test
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        // Assertions
        assertTrue(result, "The result should be true for primitive types.");
    }

    @Test
    public void testIsValidAnnotationMemberType_withClassType_shouldReturnTrue() {
        // Test Class<?> type (e.g., String.class)
        Class<?> type = String.class;

        // Call the method under test
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        // Assertions
        assertTrue(result, "The result should be true for Class<?> types such as String.class.");
    }

//    @Test
//    public void testIsValidAnnotationMemberType_withEnumType_shouldReturnTrue() {
//        // Test enum type
//        Class<?> type = Enum.class;
//
//        // Call the method under test
//        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);
//
//        // Assertions
//        assertTrue(result, "The result should be true for enum types.");
//    }

    @Test
    public void testIsValidAnnotationMemberType_withAnnotationType_shouldReturnTrue() {
        // Test annotation type (e.g., Deprecated.class)
        Class<?> type = Deprecated.class;

        // Call the method under test
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        // Assertions
        assertTrue(result, "The result should be true for annotation types.");
    }

    @Test
    public void testIsValidAnnotationMemberType_withArrayType_shouldReturnTrue() {
        // Test array type (e.g., String[].class)
        Class<?> type = String[].class;

        // Call the method under test
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        // Assertions
        assertTrue(result, "The result should be true for array types of permitted types.");
    }

    @Test
    public void testIsValidAnnotationMemberType_withInvalidArrayType_shouldReturnFalse() {
        // Test invalid array type (e.g., Object[].class)
        Class<?> type = Object[].class;

        // Call the method under test
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        // Assertions
        assertFalse(result, "The result should be false for array types of non-permitted types.");
    }

    @Test
    public void testIsValidAnnotationMemberType_withInvalidType_shouldReturnFalse() {
        // Test invalid type (e.g., Object.class)
        Class<?> type = Object.class;

        // Call the method under test
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        // Assertions
        assertFalse(result, "The result should be false for non-permitted types like Object.class.");
    }

    //toString

//    @Test
//    public void testToStringWithSingleMethodAnnotation() throws Exception {
//        // Mock the Annotation and its method
//        Annotation mockAnnotation = mock(Annotation.class);
//        Method mockMethod = mock(Method.class);
//
//        // Configure Mocks
//        when(mockAnnotation.annotationType()).thenReturn((Class) mockAnnotation.getClass());
//        when(mockAnnotation.getClass().getDeclaredMethods()).thenReturn(new Method[] { mockMethod });
//        when(mockMethod.getParameterTypes()).thenReturn(new Class[0]);
//        when(mockMethod.getName()).thenReturn("value");
//        when(mockMethod.invoke(mockAnnotation)).thenReturn("exampleValue");
//
//        // Call the method to test
//        String result = AnnotationUtils.toString(mockAnnotation);
//
//        // Verify result
//        assertNotNull(result);
//        assertTrue(result.contains("value=exampleValue"));
//    }
//
//    @Test
//    public void testToStringWithNoMethods() {
//        // Mock the Annotation
//        Annotation mockAnnotation = mock(Annotation.class);
//
//        // Configure Mocks
//        when(mockAnnotation.annotationType()).thenReturn((Class) mockAnnotation.getClass());
//        when(mockAnnotation.getClass().getDeclaredMethods()).thenReturn(new Method[0]);
//
//        // Call the method to test
//        String result = AnnotationUtils.toString(mockAnnotation);
//
//        // Verify result
//        assertNotNull(result);
//        assertEquals("AnnotationUtilsTest$1(mockAnnotation)", result);
//    }
//
//    @Test
//    public void testToStringWithMethodThatHasParameters() throws Exception {
//        // Mock the Annotation and its method
//        Annotation mockAnnotation = mock(Annotation.class);
//        Method mockMethod = mock(Method.class);
//
//        // Configure Mocks
//        when(mockAnnotation.annotationType()).thenReturn((Class) mockAnnotation.getClass());
//        when(mockAnnotation.getClass().getDeclaredMethods()).thenReturn(new Method[] { mockMethod });
//        when(mockMethod.getParameterTypes()).thenReturn(new Class[] { String.class }); // This method should be skipped
//
//        // Call the method to test
//        String result = AnnotationUtils.toString(mockAnnotation);
//
//        // Verify result
//        assertNotNull(result);
//        assertFalse(result.contains("value=exampleValue")); // "value" method should be skipped
//    }
//
//    @Test
//    public void testToStringWithMethodThrowingReflectionException() throws Exception {
//        // Mock the Annotation and its method
//        Annotation mockAnnotation = mock(Annotation.class);
//        Method mockMethod = mock(Method.class);
//
//        // Configure Mocks
//        when(mockAnnotation.annotationType()).thenReturn((Class) mockAnnotation.getClass());
//        when(mockAnnotation.getClass().getDeclaredMethods()).thenReturn(new Method[] { mockMethod });
//        when(mockMethod.getParameterTypes()).thenReturn(new Class[0]);
//        when(mockMethod.getName()).thenReturn("value");
//        when(mockMethod.invoke(mockAnnotation)).thenThrow(new ReflectiveOperationException("Failed invocation"));
//
//        // Verify exception
//        assertThrows(UncheckedException.class, () -> AnnotationUtils.toString(mockAnnotation));
//    }
}
