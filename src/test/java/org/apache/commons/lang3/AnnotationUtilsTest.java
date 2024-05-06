package org.apache.commons.lang3;

import static org.mockito.Mockito.*;

import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotationUtilsTest {

    @Test
    public void equals_WhenBothAnnotationsAreNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        Annotation a1 = null;
        Annotation a2 = null;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.equals(a1, a2);

        assertTrue(result);
    }

    @Test
    public void equals_WhenOnlyOneAnnotationIsNull_ReturnsFalse() {
        // Instantiate all necessary variables here
        Annotation a1 = null;
        Annotation a2 = mock(Annotation.class);

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.equals(a1, a2);

        assertFalse(result);
    }


    private interface OtherAnnotation extends Annotation {
    }


    @Test
    public void testIsValidAnnotationMemberType_WithPrimitiveType_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> type = int.class;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertTrue(result);
    }

    @Test
    public void testIsValidAnnotationMemberType_WithEnumType_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> type = MyEnum.class;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertTrue(result);
    }

    @Test
    public void testIsValidAnnotationMemberType_WithAnnotationType_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> type = MyAnnotation.class;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertTrue(result);
    }

    @Test
    public void testIsValidAnnotationMemberType_WithStringType_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> type = String.class;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertTrue(result);
    }

    @Test
    public void testIsValidAnnotationMemberType_WithClassType_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> type = Class.class;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertTrue(result);
    }

    @Test
    public void testIsValidAnnotationMemberType_WithArrayOfType_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> type = String[].class;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertTrue(result);
    }

    @Test
    public void testIsValidAnnotationMemberType_WithNullType_ReturnsFalse() {
        // Instantiate all necessary variables here
        Class<?> type = null;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertFalse(result);
    }

    enum MyEnum {
        VALUE1, VALUE2
    }

    @interface MyAnnotation {
        String value();
    }

}