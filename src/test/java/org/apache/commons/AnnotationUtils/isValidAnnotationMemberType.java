
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class isValidAnnotationMemberTypeTest {

    @Test
    @DisplayName("Test with primitive type")
    void testWithPrimitiveType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(boolean.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(double.class));
    }

    @Test
    @DisplayName("Test with enum type")
    void testWithEnumType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(EnumType.class));
    }

    @Test
    @DisplayName("Test with annotation type")
    void testWithAnnotationType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(AnnotationType.class));
    }

    @Test
    @DisplayName("Test with String type")
    void testWithStringType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String.class));
    }

    @Test
    @DisplayName("Test with Class type")
    void testWithClassType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Class.class));
    }

    @Test
    @DisplayName("Test with array of primitive type")
    void testWithArrayOfPrimitiveType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int[].class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(boolean[].class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(double[].class));
    }

    @Test
    @DisplayName("Test with array of enum type")
    void testWithArrayOfEnumType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(EnumType[].class));
    }

    @Test
    @DisplayName("Test with array of annotation type")
    void testWithArrayOfAnnotationType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(AnnotationType[].class));
    }

    @Test
    @DisplayName("Test with array of String type")
    void testWithArrayOfStringType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String[].class));
    }

    @Test
    @DisplayName("Test with array of Class type")
    void testWithArrayOfClassType() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Class[].class));
    }

    @Test
    @DisplayName("Test with null type")
    void testWithNullType() {
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(null));
    }

    @Test
    @DisplayName("Test with unsupported type")
    void testWithUnsupportedType() {
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(Object.class));
    }

    enum EnumType {
        VALUE1, VALUE2
    }

    @interface AnnotationType {
    }

}
