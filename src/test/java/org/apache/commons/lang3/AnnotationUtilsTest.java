package org.apache.commons.lang3;

import static org.mockito.Mockito.when;

import org.apache.commons.lang3.exception.UncheckedException;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;
import org.apache.commons.lang3.AnnotationUtils;
import java.lang.reflect.Method;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.annotation.Retention;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnnotationUtilsTest {



    @Test
    public void testIsValidAnnotationMemberType_Array() {
        Class<?> arrayClass = new String[]{}.getClass();
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(arrayClass));
    }

    @Test
    public void testIsValidAnnotationMemberType_Primitive() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int.class));
    }

    @Test
    public void testIsValidAnnotationMemberType_Enum() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Thread.State.class));
    }

    @Test
    public void testIsValidAnnotationMemberType_Annotation() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Override.class));
    }

    @Test
    public void testIsValidAnnotationMemberType_String() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String.class));
    }

    @Test
    public void testIsValidAnnotationMemberType_Class() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Class.class));
    }

    @Test
    public void testIsValidAnnotationMemberType_Null() {
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(null));
    }

    @Test
    public void testIsValidAnnotationMemberType_OtherType() {
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(Object.class));
    }

    @Test
    public void testEqualsSameInstance() throws Exception {
        Annotation annotation = mock(Annotation.class);
        assertTrue(AnnotationUtils.equals(annotation, annotation));
    }

    @Test
    public void testEqualsBothNull() throws Exception {
        assertTrue(AnnotationUtils.equals(null, null));
    }

    @Test
    public void testEqualsFirstNull() throws Exception {
        Annotation annotation = mock(Annotation.class);
        assertFalse(AnnotationUtils.equals(null, annotation));
    }

    @Test
    public void testEqualsSecondNull() throws Exception {
        Annotation annotation = mock(Annotation.class);
        assertFalse(AnnotationUtils.equals(annotation, null));
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface TestAnnotation1 {
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface TestAnnotation2 {
        String value() default "";
    }


}