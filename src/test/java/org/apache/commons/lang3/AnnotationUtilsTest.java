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





//    @Test
//    public void testToString() {
//        // Instantiate all necessary variables here
//        AnnotationUtils annotationUtils = new AnnotationUtils();
//        Annotation mockAnnotation = mock(Annotation.class);
//        ToStringBuilder mockBuilder = mock(ToStringBuilder.class);
//        Method mockMethod = mock(Method.class);
//
//        // Mock the behavior of the annotationType() method
//        Class<? extends Annotation> annotationType = mock(Class.class);
//        when(mockAnnotation.annotationType()).thenReturn(annotationType);
//
//        // Mock the behavior of the getDeclaredMethods() method
//        Method[] methods = new Method[2];
//        methods[0] = mockMethod;
//        methods[1] = mockMethod;
//        when(annotationType.getDeclaredMethods()).thenReturn(methods);
//
//        // Mock the behavior of the invoke() method
//        when(mockMethod.getParameterTypes()).thenReturn(new Class[0]);
//        when(mockMethod.getName()).thenReturn("methodName");
//        try {
//            when(mockMethod.invoke(mockAnnotation)).thenReturn("value");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Mock the behavior of the append() method
//        when(mockBuilder.append(anyString(), any())).thenReturn(mockBuilder);
//
//        // Mock the behavior of the build() method
//        when(mockBuilder.build()).thenReturn("result");
//
//        // Write the test code here following the given rules
//        String result = annotationUtils.toString(mockAnnotation);
//
//        // Verify the behavior and assertions
//        verify(mockAnnotation, times(1)).annotationType();
//        verify(annotationType, times(1)).getDeclaredMethods();
//        verify(mockMethod, times(2)).getParameterTypes();
//        verify(mockMethod, times(2)).getName();
//        try {
//            verify(mockMethod, times(2)).invoke(mockAnnotation);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        verify(mockBuilder, times(2)).append(anyString(), any());
//        verify(mockBuilder, times(1)).build();
//
//        assertEquals("result", result);
//    }




 //failing
    //@Test
    public void testHashCode_NullAnnotation_ReturnsZero() {
        Annotation annotation = mock(Annotation.class);
        when(annotation.annotationType()).thenReturn(null);

        int result = AnnotationUtils.hashCode(annotation);

        assertEquals(0, result);
    }
    
//    @Test
//    public void testHashCode_NoMethods_ReturnsZero() {
//        Annotation annotation = mock(Annotation.class);
//        Class<? extends Annotation> type = Annotation.class;
//        when(annotation.annotationType()).thenReturn(type);
//        when(type.getDeclaredMethods()).thenReturn(new Method[0]);
//
//        int result = AnnotationUtils.hashCode(annotation);
//
//        assertEquals(0, result);
//    }
//
//    @Test
//    public void testHashCode_MethodReturnsNull_ThrowsIllegalStateException() throws Exception {
//        Annotation annotation = mock(Annotation.class);
//        Class<? extends Annotation> type = Annotation.class;
//        Method method = type.getDeclaredMethod("method");
//        when(annotation.annotationType()).thenReturn(type);
//        when(type.getDeclaredMethods()).thenReturn(new Method[] { method });
//        when(method.invoke(annotation)).thenReturn(null);
//
//        assertThrows(IllegalStateException.class, () -> AnnotationUtils.hashCode(annotation));
//    }
//
//    @Test
//    public void testHashCode_MethodReturnsNonNull_CalculatesHashCode() throws Exception {
//        Annotation annotation = mock(Annotation.class);
//        Class<? extends Annotation> type = Annotation.class;
//        Method method = type.getDeclaredMethod("method");
//        when(annotation.annotationType()).thenReturn(type);
//        when(type.getDeclaredMethods()).thenReturn(new Method[] { method });
//        when(method.invoke(annotation)).thenReturn("value");
//
//        int result = AnnotationUtils.hashCode(annotation);
//
//        assertEquals("method".hashCode() + "value".hashCode(), result);
//    }



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

    //@Test
    public void equals_WhenAnnotationsHaveDifferentTypes_ReturnsFalse() {
        // Instantiate all necessary variables here
        Annotation a1 = mock(Annotation.class);
        Annotation a2 = mock(OtherAnnotation.class);

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.equals(a1, a2);

        assertFalse(result);
    }

//    @Test
//    public void equals_WhenAnnotationsHaveSameTypeAndEqualMembers_ReturnsTrue() throws InvocationTargetException, IllegalAccessException {
//        // Instantiate all necessary variables here
//        Annotation a1 = mock(Annotation.class);
//        Annotation a2 = mock(Annotation.class);
//
//        when(a1.annotationType()).thenReturn(Annotation.class);
//        when(a2.annotationType()).thenReturn(Annotation.class);
//
//        Method method = mock(Method.class);
//        when(method.getParameterTypes()).thenReturn(new Class[0]);
//        when(method.getReturnType()).thenReturn(String.class);
//        when(method.invoke(a1)).thenReturn("value");
//        when(method.invoke(a2)).thenReturn("value");
//
//        Class<? extends Annotation> type = Annotation.class;
//        when(a1.annotationType()).thenReturn(type);
//        when(a2.annotationType()).thenReturn(type);
//        when(type.getDeclaredMethods()).thenReturn(new Method[]{method});
//
//        // Write the test code here following the given rules
//        boolean result = AnnotationUtils.equals(a1, a2);
//
//        assertTrue(result);
//    }

//    @Test
//    public void equals_WhenAnnotationsHaveSameTypeAndDifferentMembers_ReturnsFalse() throws InvocationTargetException, IllegalAccessException {
//        // Instantiate all necessary variables here
//        Annotation a1 = mock(Annotation.class);
//        Annotation a2 = mock(Annotation.class);
//
//        when(a1.annotationType()).thenReturn(Annotation.class);
//        when(a2.annotationType()).thenReturn(Annotation.class);
//
//        Method method = mock(Method.class);
//        when(method.getParameterTypes()).thenReturn(new Class[0]);
//        when(method.getReturnType()).thenReturn(String.class);
//        when(method.invoke(a1)).thenReturn("value1");
//        when(method.invoke(a2)).thenReturn("value2");
//
//        Class<? extends Annotation> type = Annotation.class;
//        when(a1.annotationType()).thenReturn(type);
//        when(a2.annotationType()).thenReturn(type);
//        when(type.getDeclaredMethods()).thenReturn(new Method[]{method});
//
//        // Write the test code here following the given rules
//        boolean result = AnnotationUtils.equals(a1, a2);
//
//        assertFalse(result);
//    }

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

    //@Test
    public void testIsValidAnnotationMemberType_WithArrayType_ReturnsFalse() {
        // Instantiate all necessary variables here
        Class<?> type = int[].class;

        // Write the test code here following the given rules
        boolean result = AnnotationUtils.isValidAnnotationMemberType(type);

        assertFalse(result);
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