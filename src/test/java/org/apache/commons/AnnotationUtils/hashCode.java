import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashCodeTest {
    @Test
    void testHashCode() {
        // Test case 1: Empty annotation
        Annotation emptyAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }
        };
        assertEquals(0, AnnotationUtils.hashCode(emptyAnnotation));

        // Test case 2: Annotation with one method returning a non-null value
        Annotation annotationWithNonNullValue = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }

            @Override
            public String toString() {
                return "AnnotationWithNonNullValue";
            }

            @Override
            public int hashCode() {
                return 123;
            }
        };
        assertEquals(123, AnnotationUtils.hashCode(annotationWithNonNullValue));

        // Test case 3: Annotation with one method returning a null value
        Annotation annotationWithNullValue = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }

            @Override
            public String toString() {
                return "AnnotationWithNullValue";
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Object methodWithNullValue() {
                return null;
            }
        };
        assertThrows(IllegalStateException.class, () -> AnnotationUtils.hashCode(annotationWithNullValue));

        // Test case 4: Annotation with multiple methods
        Annotation annotationWithMultipleMethods = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }

            @Override
            public String toString() {
                return "AnnotationWithMultipleMethods";
            }

            @Override
            public int hashCode() {
                return 456;
            }

            @Override
            public String method1() {
                return "value1";
            }

            @Override
            public int method2() {
                return 789;
            }

            @Override
            public boolean method3() {
                return true;
            }
        };
        assertEquals(456 + 31 * ("value1".hashCode() + 31 * (789 + 31 * Boolean.hashCode(true))), AnnotationUtils.hashCode(annotationWithMultipleMethods));
    }
}