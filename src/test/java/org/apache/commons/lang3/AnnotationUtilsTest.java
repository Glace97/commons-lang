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

    // Enum for testing
    enum SampleEnum {
        VALUE1, VALUE2
    }

    // Sample annotation for testing
    @interface SampleAnnotation {
        String value();
    }


}