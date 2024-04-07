import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.annotation.Annotation;

class EqualsTest {

    @Test
    void testEquals_sameAnnotation_returnsTrue() {
        // Arrange
        Annotation annotation1 = createAnnotation();
        Annotation annotation2 = annotation1;

        // Act
        boolean result = AnnotationUtils.equals(annotation1, annotation2);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testEquals_nullAnnotation_returnsFalse() {
        // Arrange
        Annotation annotation1 = createAnnotation();
        Annotation annotation2 = null;

        // Act
        boolean result = AnnotationUtils.equals(annotation1, annotation2);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testEquals_differentAnnotationClass_returnsFalse() {
        // Arrange
        Annotation annotation1 = createAnnotation();
        Annotation annotation2 = createDifferentAnnotation();

        // Act
        boolean result = AnnotationUtils.equals(annotation1, annotation2);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testEquals_differentAnnotationMemberValue_returnsFalse() {
        // Arrange
        Annotation annotation1 = createAnnotation();
        Annotation annotation2 = createAnnotationWithDifferentMemberValue();

        // Act
        boolean result = AnnotationUtils.equals(annotation1, annotation2);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testEquals_equalAnnotation_returnsTrue() {
        // Arrange
        Annotation annotation1 = createAnnotation();
        Annotation annotation2 = createEqualAnnotation();

        // Act
        boolean result = AnnotationUtils.equals(annotation1, annotation2);

        // Assert
        Assertions.assertTrue(result);
    }

    private Annotation createAnnotation() {
        return new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }
        };
    }

    private Annotation createDifferentAnnotation() {
        return new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return DifferentAnnotation.class;
            }
        };
    }

    private Annotation createAnnotationWithDifferentMemberValue() {
        return new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }

            @Override
            public String toString() {
                return "DifferentValue";
            }
        };
    }

    private Annotation createEqualAnnotation() {
        return new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }
        };
    }

}