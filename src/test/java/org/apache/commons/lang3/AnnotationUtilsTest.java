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
    public void testToString() {
        Annotation annotation = mock(Annotation.class);
        Method method = mock(Method.class);
        Class<? extends Annotation> annotationClass = annotation.annotationType();
        when(annotationClass.getDeclaredMethods()).thenReturn(new Method[] {method});

        try (MockedStatic<Class> classMock = Mockito.mockStatic(Class.class)) {
            classMock.when(() -> Class.forName(anyString())).thenReturn(annotationClass);
            try {
                when(method.invoke(any())).thenReturn("mockValue");
                when(method.getName()).thenReturn("mockName");
                when(method.getParameterTypes()).thenReturn(new Class[0]);

                String result = AnnotationUtils.toString(annotation);
                assertTrue(result.contains("mockName=mockValue"));

            } catch (Exception e) {
                fail("Test failed due to exception: " + e.getMessage());
            }
        }
    }

    @Test
    public void testToString_WhenException() {
        Annotation annotation = mock(Annotation.class);
        Method method = mock(Method.class);
        Class<? extends Annotation> annotationClass = annotation.annotationType();
        when(annotationClass.getDeclaredMethods()).thenReturn(new Method[] {method});

        try (MockedStatic<Class> classMock = Mockito.mockStatic(Class.class)) {
            classMock.when(() -> Class.forName(anyString())).thenReturn(annotationClass);
            try {
                when(method.invoke(any())).thenThrow(new ReflectiveOperationException("Mock exception"));

                assertThrows(UncheckedException.class, () -> AnnotationUtils.toString(annotation));

            } catch (Exception e) {
                fail("Test failed due to exception: " + e.getMessage());
            }
        }
    }

    @Test
    public void testToString_WhenMethodHasParameters() {
        Annotation annotation = mock(Annotation.class);
        Method method = mock(Method.class);
        Class<? extends Annotation> annotationClass = annotation.annotationType();
        when(annotationClass.getDeclaredMethods()).thenReturn(new Method[] {method});

        try (MockedStatic<Class> classMock = Mockito.mockStatic(Class.class)) {
            classMock.when(() -> Class.forName(anyString())).thenReturn(annotationClass);
            try {
                when(method.getParameterTypes()).thenReturn(new Class[1]);

                String result = AnnotationUtils.toString(annotation);
                assertEquals("@" + annotationClass.getName() + "()", result);

            } catch (Exception e) {
                fail("Test failed due to exception: " + e.getMessage());
            }
        }
    }





    @Test
    public void testHashCode() throws Exception {
        // Instantiate all necessary variables here
        Annotation mockAnnotation = mock(Annotation.class);
        Class<? extends Annotation> annotationType = mockAnnotation.annotationType();
        Method mockMethod1 = mock(Method.class);
        Method mockMethod2 = mock(Method.class);
        Method[] methods = { mockMethod1, mockMethod2 };

        // Mock necessary method calls
        when(mockAnnotation.annotationType()).thenReturn((Class) Annotation.class);
        when(Annotation.class.getDeclaredMethods()).thenReturn(methods);
        when(mockMethod1.invoke(mockAnnotation)).thenReturn("value1");
        when(mockMethod2.invoke(mockAnnotation)).thenReturn("value2");
        when(mockMethod1.getName()).thenReturn("method1");
        when(mockMethod2.getName()).thenReturn("method2");

        // Execute the method to test
        int hashCode = AnnotationUtils.hashCode(mockAnnotation);

        // Verify the results
        assertNotEquals(0, hashCode);
    }

    @Test
    public void testHashCode_WhenAnnotationMethodReturnsNull() throws Exception {
        // Instantiate all necessary variables here
        Annotation mockAnnotation = mock(Annotation.class);
        Class<? extends Annotation> annotationType = mockAnnotation.annotationType();
        Method mockMethod = mock(Method.class);
        Method[] methods = { mockMethod };

        // Mock necessary method calls
        when(mockAnnotation.annotationType()).thenReturn((Class) Annotation.class);
        when(Annotation.class.getDeclaredMethods()).thenReturn(methods);
        when(mockMethod.invoke(mockAnnotation)).thenReturn(null);

        // Execute the method and assert an IllegalStateException is thrown
        assertThrows(IllegalStateException.class, () -> AnnotationUtils.hashCode(mockAnnotation));
    }

    @Test
    public void testHashCode_WhenAnnotationMethodThrowsException() throws Exception {
        // Instantiate all necessary variables here
        Annotation mockAnnotation = mock(Annotation.class);
        Class<? extends Annotation> annotationType = mockAnnotation.annotationType();
        Method mockMethod = mock(Method.class);
        Method[] methods = { mockMethod };

        // Mock necessary method calls
        when(mockAnnotation.annotationType()).thenReturn((Class) Annotation.class);
        when(Annotation.class.getDeclaredMethods()).thenReturn(methods);
        when(mockMethod.invoke(mockAnnotation)).thenThrow(new Exception());

        // Execute the method and assert a RuntimeException is thrown
        assertThrows(RuntimeException.class, () -> AnnotationUtils.hashCode(mockAnnotation));
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

    @Test
    public void testEqualsDifferentTypes() throws Exception {
        Annotation annotation1 = mock(TestAnnotation1.class);
        Annotation annotation2 = mock(TestAnnotation2.class);
        assertFalse(AnnotationUtils.equals(annotation1, annotation2));
    }

    @Test
    public void testEqualsSameTypeDifferentValues() throws Exception {
        TestAnnotation1 annotation1 = mock(TestAnnotation1.class);
        TestAnnotation1 annotation2 = mock(TestAnnotation1.class);

        when(annotation1.value()).thenReturn("value1");
        when(annotation2.value()).thenReturn("value2");

        assertFalse(AnnotationUtils.equals(annotation1, annotation2));
    }

    @Test
    public void testEqualsSameTypeSameValues() throws Exception {
        TestAnnotation1 annotation1 = mock(TestAnnotation1.class);
        TestAnnotation1 annotation2 = mock(TestAnnotation1.class);

        when(annotation1.value()).thenReturn("value");
        when(annotation2.value()).thenReturn("value");

        assertTrue(AnnotationUtils.equals(annotation1, annotation2));
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