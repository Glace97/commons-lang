import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getShortClassNameTest {

    private AnnotationUtils annotationUtils;

    @BeforeEach
    void setUp() {
        annotationUtils = new AnnotationUtils();
    }

    @Nested
    @DisplayName("getShortClassName method")
    class GetShortClassNameMethodTests {

        @Test
        @DisplayName("should return empty string when class has no implemented interfaces")
        void shouldReturnEmptyStringWhenClassHasNoImplementedInterfaces() {
            // Arrange
            Class<?> cls = MyClass.class;

            // Act
            String result = annotationUtils.getShortClassName(cls);

            // Assert
            assertEquals(StringUtils.EMPTY, result);
        }

        @Test
        @DisplayName("should return empty string when class has implemented interfaces but none are annotations")
        void shouldReturnEmptyStringWhenClassHasImplementedInterfacesButNoneAreAnnotations() {
            // Arrange
            Class<?> cls = MyInterface.class;

            // Act
            String result = annotationUtils.getShortClassName(cls);

            // Assert
            assertEquals(StringUtils.EMPTY, result);
        }

        @Test
        @DisplayName("should return annotation name when class has implemented interfaces and one is an annotation")
        void shouldReturnAnnotationNameWhenClassHasImplementedInterfacesAndOneIsAnAnnotation() {
            // Arrange
            Class<?> cls = MyAnnotatedClass.class;

            // Act
            String result = annotationUtils.getShortClassName(cls);

            // Assert
            assertEquals("@MyAnnotation", result);
        }

        @Test
        @DisplayName("should return annotation name when class has implemented interfaces and multiple are annotations")
        void shouldReturnAnnotationNameWhenClassHasImplementedInterfacesAndMultipleAreAnnotations() {
            // Arrange
            Class<?> cls = MyMultipleAnnotatedClass.class;

            // Act
            String result = annotationUtils.getShortClassName(cls);

            // Assert
            assertEquals("@MyAnnotation1", result);
        }

        @Test
        @DisplayName("should return annotation name when class has implemented interfaces and one is an annotation with inheritance")
        void shouldReturnAnnotationNameWhenClassHasImplementedInterfacesAndOneIsAnAnnotationWithInheritance() {
            // Arrange
            Class<?> cls = MyInheritedAnnotatedClass.class;

            // Act
            String result = annotationUtils.getShortClassName(cls);

            // Assert
            assertEquals("@MyAnnotation", result);
        }

        @Test
        @DisplayName("should return annotation name when class has implemented interfaces and one is an annotation with multiple inheritance")
        void shouldReturnAnnotationNameWhenClassHasImplementedInterfacesAndOneIsAnAnnotationWithMultipleInheritance() {
            // Arrange
            Class<?> cls = MyMultipleInheritedAnnotatedClass.class;

            // Act
            String result = annotationUtils.getShortClassName(cls);

            // Assert
            assertEquals("@MyAnnotation1", result);
        }

    }

    // Test classes
    interface MyInterface {}

    class MyClass {}

    @MyAnnotation
    class MyAnnotatedClass {}

    @MyAnnotation1
    class MyMultipleAnnotatedClass {}

    @MyInheritedAnnotation
    class MyInheritedAnnotatedClass {}

    @MyMultipleInheritedAnnotation
    class MyMultipleInheritedAnnotatedClass {}

    // Test annotations
    @interface MyAnnotation {}

    @interface MyAnnotation1 {}

    @interface MyInheritedAnnotation {}

    @interface MyMultipleInheritedAnnotation {}

}
Note: The test class assumes that the annotations used in the test cases are defined and imported properly.