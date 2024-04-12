package org.apache.commons.lang3;

import static org.easymock.EasyMock.mock;
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
import static org.mockito.Mockito.when;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationUtilsTest {

    //@Test
    void testHashCode() {
        // Test case 1: Empty annotation
        Annotation emptyAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return this.getClass();
            }
        };
        assertEquals(0, AnnotationUtils.hashCode(emptyAnnotation));

        // Test case 2: Annotation with one member
        Annotation annotationWithOneMember = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return this.getClass();
            }

            public String value() {
                return "test";
            }
        };
        assertEquals(115276, AnnotationUtils.hashCode(annotationWithOneMember));

        // Test case 3: Annotation with multiple members
        Annotation annotationWithMultipleMembers = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return this.getClass();
            }

            public String value() {
                return "test";
            }

            public int count() {
                return 10;
            }

            public boolean active() {
                return true;
            }
        };
        assertEquals(115387, AnnotationUtils.hashCode(annotationWithMultipleMembers));

        // Test case 4: Annotation with null member value
        Annotation annotationWithNullMemberValue = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return this.getClass();
            }

            public String value() {
                return null;
            }
        };
        assertThrows(IllegalStateException.class, () -> AnnotationUtils.hashCode(annotationWithNullMemberValue));

        // Test case 5: Annotation with array member
        Annotation annotationWithArrayMember = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return this.getClass();
            }

            public String[] values() {
                return new String[]{"test1", "test2"};
            }
        };
        assertEquals(235490, AnnotationUtils.hashCode(annotationWithArrayMember));
    }


    //Manual test
    @Test
    void testIsValidAnnotationMemberType_Primitive() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(double.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(boolean.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(char.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(byte.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(float.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(long.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(short.class));
    }

    @Test
    void testIsValidAnnotationMemberType_Enum() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(SampleEnum.class));
    }

    @Test
    void testIsValidAnnotationMemberType_Annotation() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(SampleAnnotation.class));
    }

    @Test
    void testIsValidAnnotationMemberType_String() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String.class));
    }

    @Test
    void testIsValidAnnotationMemberType_Class() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Class.class));
    }

    @Test
    void testIsValidAnnotationMemberType_Array() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int[].class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(SampleEnum[].class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(SampleAnnotation[].class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String[].class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Class[].class));
    }

    @Test
    void testIsValidAnnotationMemberType_NonAnnotationType() {
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(Object.class));
    }
//
//    @Test
//    void testMemberEquals_Primitive() {
//        assertTrue(AnnotationUtils.memberEquals(int.class, 10, 10));
//        assertFalse(AnnotationUtils.memberEquals(int.class, 10, 20));
//    }
//
//    @Test
//    void testMemberEquals_String() {
//        assertTrue(AnnotationUtils.memberEquals(String.class, "test", "test"));
//        assertFalse(AnnotationUtils.memberEquals(String.class, "test", "other"));
//    }
//
//    @Test
//    void testMemberEquals_Enum() {
//        assertTrue(AnnotationUtils.memberEquals(SampleEnum.class, SampleEnum.VALUE1, SampleEnum.VALUE1));
//        assertFalse(AnnotationUtils.memberEquals(SampleEnum.class, SampleEnum.VALUE1, SampleEnum.VALUE2));
//    }
//
//    @Test
//    void testMemberEquals_Annotation() {
//        SampleAnnotation annotation1 = new SampleAnnotation() {
//            @Override
//            public String value() {
//                return "value1";
//            }
//        };
//        SampleAnnotation annotation2 = new SampleAnnotation() {
//            @Override
//            public String value() {
//                return "value1";
//            }
//        };
//        assertTrue(AnnotationUtils.memberEquals(SampleAnnotation.class, annotation1, annotation2));
//    }

    // Enum for testing
    enum SampleEnum {
        VALUE1, VALUE2
    }

    // Sample annotation for testing
    @interface SampleAnnotation {
        String value();
    }

//    private AnnotationUtils annotationUtils;
//    @BeforeEach
//    void setUp() {
//        annotationUtils = new AnnotationUtils();
//    }
//
//    @interface DummyAnnotation2{
//        String value();
//
//        OtherAnnotation otherAnnotation() default @OtherAnnotation(value = "defaultValue");
//        String[] array() default {};
//
//    }
//
//    @interface OtherAnnotation {
//        String value();
//    }
//
//    @DummyAnnotation(value = "dummyValue")
//    private class DummyClass {
//
//    }
//
//    @interface DummyAnnotation {
//        String value();
//
//        OtherAnnotation otherAnnotation() default @OtherAnnotation(value = "defaultValue");
//
//        String[] array() default {};
//
//        String methodWithParameters(int param);
//    }
//
//    @interface OtherAnnotation extends Annotation{
//        String value();
//    }
//
//    @Test
//    public void testAppendDetail_withAnnotation_shouldReturnToStringRepresentation() {
//        // Arrange
//        Annotation annotation = createDummyAnnotation();
//
//        // Act
//        String result = annotationUtils.appendDetail(new StringBuffer(), "fieldName", annotation).toString();
//
//        // Assert
//        Assertions.assertTrue(result.contains("@DummyAnnotation"));
//    }
//
////    @Test
////    public void testAppendDetail_withNonAnnotationValue_shouldReturnDefaultValue() {
////        // Arrange
////        Object value = "dummyValue";
////
////        // Act
////        String result = annotationUtils.appendDetail(new StringBuffer(), "fieldName", value).toString();
////
////        // Assert
////        Assertions.assertTrue(result.contains("fieldName=" + value));
////    }
////
////    @Test
////    public void testAppendDetail_withNullValue_shouldReturnDefaultValue() {
////        // Arrange
////        Object value = null;
////
////        // Act
////        String result = annotationUtils.appendDetail(new StringBuffer(), "fieldName", value).toString();
////
////        // Assert
////        Assertions.assertTrue(result.contains("fieldName=null"));
////    }
////
////    @Test
////    public void testAppendDetail_withArrayValue_shouldReturnArrayRepresentation() {
////        // Arrange
////        Object value = new int[]{1, 2, 3};
////
////        // Act
////        String result = annotationUtils.appendDetail(new StringBuffer(), "fieldName", value).toString();
////
////        // Assert
////        Assertions.assertTrue(result.contains("fieldName=[1, 2, 3]"));
////    }
////
////    @Test
////    public void testAppendDetail_withEmptyArrayValue_shouldReturnArrayRepresentation() {
////        // Arrange
////        Object value = new int[]{};
////
////        // Act
////        String result = annotationUtils.appendDetail(new StringBuffer(), "fieldName", value).toString();
////
////        // Assert
////        Assertions.assertTrue(result.contains("fieldName=[]"));
////    }
////
////    @Test
////    public void testAppendDetail_withClassValue_shouldReturnClassName() {
////        // Arrange
////        Object value = AnnotationUtilsTestSuite.class;
////
////        // Act
////        String result = annotationUtils.appendDetail(new StringBuffer(), "fieldName", value).toString();
////
////        // Assert
////        Assertions.assertTrue(result.contains("fieldName=AnnotationUtilsTestSuite"));
////    }
////
////    @Test
////    public void testAppendDetail_withInterfaceValue_shouldReturnInterfaceName() {
////        // Arrange
////        Object value = Runnable.class;
////
////        // Act
////        String result = annotationUtils.appendDetail(new StringBuffer(), "fieldName", value).toString();
////
////        // Assert
////        Assertions.assertTrue(result.contains("fieldName=@java.lang.FunctionalInterface"));
////    }
//
//    private Annotation createDummyAnnotation() {
//        return new Annotation() {
//            @Override
//            public Class<? extends Annotation> annotationType() {
//                return DummyAnnotation.class;
//            }
//        };
//    }
//
////
////    @Test
////    @DisplayName("should return empty string if class has no interfaces implementing Annotation")
////    void testGetShortClassName_NoAnnotationInterface() {
////        // Arrange
////        Class<?> cls = String.class;
////        AnnotationUtils annotationUtils = new AnnotationUtils();
////
////        // Act
////        String result = annotationUtils.getShortClassName(cls);
////
////        // Assert
////        Assertions.assertEquals("", result);
////    }
////
////    @Test
////    @DisplayName("should return '@AnnotationInterface' if class has an interface implementing Annotation")
////    void testGetShortClassName_OneAnnotationInterface() {
////        // Arrange
////        Class<?> cls = TestAnnotation.class;
////        AnnotationUtils annotationUtils = new AnnotationUtils();
////
////        // Act
////        String result = annotationUtils.getShortClassName(cls);
////
////        // Assert
////        Assertions.assertEquals("@TestAnnotation", result);
////    }
////
////    @Test
////    @DisplayName("should return the first found interface implementing Annotation")
////    void testGetShortClassName_MultipleAnnotationInterfaces() {
////        // Arrange
////        Class<?> cls = MultipleAnnotationsClass.class;
////        AnnotationUtils annotationUtils = new AnnotationUtils();
////
////        // Act
////        String result = annotationUtils.getShortClassName(cls);
////
////        // Assert
////        Assertions.assertEquals("@Annotation1", result);
////    }
////
////    @Test
////    @DisplayName("should return the empty string if class is null")
////    void testGetShortClassName_NullClass() {
////        // Arrange
////        Class<?> cls = null;
////        AnnotationUtils annotationUtils = new AnnotationUtils();
////
////        // Act
////        String result = annotationUtils.getShortClassName(cls);
////
////        // Assert
////        Assertions.assertEquals("", result);
////    }
////
////    @Test
////    void testToString_withAnnotation_returnsExpectedString() {
////        // Arrange
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.value()).thenReturn("dummyValue");
////
////        // Act
////        String result = annotationUtils.toString(annotation);
////
////        // Assert
////        assertEquals("@DummyAnnotation(value=dummyValue)", result);
////    }
////
////    @Test
////    void testToString_withAnnotationContainingOtherAnnotations_returnsExpectedString() {
////        // Arrange
////        OtherAnnotation otherAnnotation = mock(OtherAnnotation.class);
////        when(otherAnnotation.annotationType()).thenReturn(OtherAnnotation.class);
////        when(otherAnnotation.value()).thenReturn("otherValue");
////
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.otherAnnotation()).thenReturn(otherAnnotation);
////        when(annotation.value()).thenReturn("dummyValue");
////
////        // Act
////        String result = annotationUtils.toString(annotation);
////
////        // Assert
////        assertEquals("@DummyAnnotation(value=dummyValue, otherAnnotation=@OtherAnnotation(value=otherValue))", result);
////    }
////
////    @Test
////    void testToString_withAnnotationContainingArray_returnsExpectedString() {
////        // Arrange
////        String[] array = {"item1", "item2"};
////
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.array()).thenReturn(array);
////
////        // Act
////        String result = annotationUtils.toString(annotation);
////
////        // Assert
////        assertEquals("@DummyAnnotation(array=[item1, item2])", result);
////    }
////
////    @Test
////    void testToString_withAnnotationContainingEmptyArray_returnsExpectedString() {
////        // Arrange
////        String[] array = {};
////
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.array()).thenReturn(array);
////
////        // Act
////        String result = annotationUtils.toString(annotation);
////
////        // Assert
////        assertEquals("@DummyAnnotation(array=[])", result);
////    }
////
////    @Test
////    void testToString_withAnnotationContainingNull_returnsExpectedString() {
////        // Arrange
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.value()).thenReturn(null);
////
////        // Act
////        String result = annotationUtils.toString(annotation);
////
////        // Assert
////        assertEquals("@DummyAnnotation(value=null)", result);
////    }
////
////    @Test
////    void testToString_withAnnotationContainingMethodWithParameters_ignoresMethod() {
////        // Arrange
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.methodWithParameters(anyInt())).thenReturn("ignored");
////
////        // Act
////        String result = annotationUtils.toString(annotation);
////
////        // Assert
////        assertEquals("@DummyAnnotation()", result);
////    }
////
////    @Test
////    void testToString_withReflectiveOperationException_throwsUncheckedException() throws Exception {
////        // Arrange
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.value()).thenThrow(new Exception());
////
////        // Act & Assert
////        assertThrows(UncheckedException.class, () -> annotationUtils.toString(annotation));
////    }
////
////    @Test
////    void testToString_withDefaultToStringStyle_returnsExpectedString() {
////        // Arrange
////        ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
////
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.value()).thenReturn("dummyValue");
////
////        // Act
////        String result = ToStringBuilder.reflectionToString(annotation, defaultStyle);
////
////        // Assert
////        assertEquals("@DummyAnnotation(value=dummyValue)", result);
////    }
////
////    @Test
////    void testToString_withCustomToStringStyle_returnsExpectedString() {
////        // Arrange
////        ToStringStyle customStyle = new ToStringStyle() {
////            private static final long serialVersionUID = 1L;
////
////            {
////                setDefaultFullDetail(true);
////                setUseClassName(true);
////                setUseIdentityHashCode(false);
////                setContentStart("(");
////                setContentEnd(")");
////                setFieldSeparator(", ");
////            }
////
////            @Override
////            protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
////                if (value instanceof Annotation) {
////                    value = annotationUtils.toString((Annotation) value);
////                }
////                super.appendDetail(buffer, fieldName, value);
////            }
////        };
////
////        DummyAnnotation annotation = mock(DummyAnnotation.class);
////        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
////        when(annotation.value()).thenReturn("dummyValue");
////
////        // Act
////        String result = ToStringBuilder.reflectionToString(annotation, customStyle);
////
////        // Assert
////        assertEquals("@DummyAnnotation(value=dummyValue)", result);
////    }
////
////    @Test
////    void testToString_withClassImplementingAnnotation_returnsExpectedString() {
////        // Arrange
////        DummyClass dummyClass = new DummyClass();
////
////        // Act
////        String result = annotationUtils.toString(dummyClass);
////
////        // Assert
////        assertEquals("@DummyAnnotation(value=dummyValue)", result);
////    }
//
//
//    @Test
//    void testToString_withAnnotation_returnsExpectedString() {
//        // Arrange
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.value()).thenReturn("dummyValue");
//
//        // Act
//        String result = annotationUtils.toString(annotation);
//
//        // Assert
//        assertEquals("@DummyAnnotation(value=dummyValue)", result);
//    }
//
//    @Test
//    void testToString_withAnnotationContainingOtherAnnotations_returnsExpectedString() {
//        // Arrange
//        OtherAnnotation otherAnnotation = mock(OtherAnnotation.class);
//        when(otherAnnotation.annotationType()).thenReturn(OtherAnnotation.class);
//        when(otherAnnotation.value()).thenReturn("otherValue");
//
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.otherAnnotation()).thenReturn(otherAnnotation);
//        when(annotation.value()).thenReturn("dummyValue");
//
//        // Act
//        String result = annotationUtils.toString(annotation);
//
//        // Assert
//        assertEquals("@DummyAnnotation(value=dummyValue, otherAnnotation=@OtherAnnotation(value=otherValue))", result);
//    }
//
//    @Test
//    void testToString_withAnnotationContainingArray_returnsExpectedString() {
//        // Arrange
//        String[] array = {"item1", "item2"};
//
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.array()).thenReturn(array);
//
//        // Act
//        String result = annotationUtils.toString(annotation);
//
//        // Assert
//        assertEquals("@DummyAnnotation(array=[item1, item2])", result);
//    }
//
//    @Test
//    void testToString_withAnnotationContainingEmptyArray_returnsExpectedString() {
//        // Arrange
//        String[] array = {};
//
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.array()).thenReturn(array);
//
//        // Act
//        String result = annotationUtils.toString(annotation);
//
//        // Assert
//        assertEquals("@DummyAnnotation(array=[])", result);
//    }
//
//    @Test
//    void testToString_withAnnotationContainingNull_returnsExpectedString() {
//        // Arrange
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.value()).thenReturn(null);
//
//        // Act
//        String result = annotationUtils.toString(annotation);
//
//        // Assert
//        assertEquals("@DummyAnnotation(value=null)", result);
//    }
//
//    @Test
//    void testToString_withAnnotationContainingMethodWithParameters_ignoresMethod() {
//        // Arrange
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.methodWithParameters(anyInt())).thenReturn("ignored");
//
//        // Act
//        String result = annotationUtils.toString(annotation);
//
//        // Assert
//        assertEquals("@DummyAnnotation()", result);
//    }
//
//    @Test
//    void testToString_withReflectiveOperationException_throwsUncheckedException() throws Exception {
//        // Arrange
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.value()).thenThrow(new Exception());
//
//        // Act & Assert
//        assertThrows(UncheckedException.class, () -> annotationUtils.toString(annotation));
//    }
//
//    @Test
//    void testToString_withDefaultToStringStyle_returnsExpectedString() {
//        // Arrange
//        ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
//
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.value()).thenReturn("dummyValue");
//
//        // Act
//        String result = ToStringBuilder.reflectionToString(annotation, defaultStyle);
//
//        // Assert
//        assertEquals("@DummyAnnotation(value=dummyValue)", result);
//    }
//
//    @Test
//    void testToString_withCustomToStringStyle_returnsExpectedString() {
//        // Arrange
//        ToStringStyle customStyle = new ToStringStyle() {
//            private static final long serialVersionUID = 1L;
//
//            {
//                setDefaultFullDetail(true);
//                setUseClassName(true);
//                setUseIdentityHashCode(false);
//                setContentStart("(");
//                setContentEnd(")");
//                setFieldSeparator(", ");
//            }
//
//            @Override
//            protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
//                if (value instanceof Annotation) {
//                    value = annotationUtils.toString((Annotation) value);
//                }
//                super.appendDetail(buffer, fieldName, value);
//            }
//        };
//
//        DummyAnnotation annotation = mock(DummyAnnotation.class);
//        when(annotation.annotationType()).thenReturn(DummyAnnotation.class);
//        when(annotation.value()).thenReturn("dummyValue");
//
//        // Act
//        String result = ToStringBuilder.reflectionToString(annotation, customStyle);
//
//        // Assert
//        assertEquals("@DummyAnnotation(value=dummyValue)", result);
//    }
//
//    @Test
//    void testToString_withClassImplementingAnnotation_returnsExpectedString() {
//        // Arrange
//        DummyClass dummyClass = new DummyClass();
//
//        // Act
//        String result = annotationUtils.toString(dummyClass);
//
//        // Assert
//        assertEquals("@DummyAnnotation(value=dummyValue)", result);
//    }

}