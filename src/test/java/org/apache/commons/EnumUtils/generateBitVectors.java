
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

class generateBitVectorsTest {

    @Nested
    @DisplayName("Tests for generateBitVectors(Class<E> enumClass, E... values)")
    class GenerateBitVectorsArrayTest {

        private Class<TestEnum> enumClass;
        private TestEnum[] values;

        @BeforeEach
        void setUp() {
            enumClass = TestEnum.class;
            values = TestEnum.values();
        }

        @Test
        @DisplayName("Should generate bit vectors for enum values")
        void shouldGenerateBitVectorsForEnumValues() {
            long[] bitVectors = EnumUtils.generateBitVectors(enumClass, values);
            Assertions.assertNotNull(bitVectors);
            Assertions.assertEquals(1, bitVectors.length);
            Assertions.assertNotEquals(0, bitVectors[0]);
        }

        @Test
        @DisplayName("Should throw NullPointerException if enumClass is null")
        void shouldThrowNullPointerExceptionIfEnumClassIsNull() {
            Assertions.assertThrows(NullPointerException.class, () ->
                    EnumUtils.generateBitVectors(null, values));
        }

        @Test
        @DisplayName("Should throw NullPointerException if values is null")
        void shouldThrowNullPointerExceptionIfValuesIsNull() {
            Assertions.assertThrows(NullPointerException.class, () ->
                    EnumUtils.generateBitVectors(enumClass, (TestEnum[]) null));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if enumClass is not an enum class")
        void shouldThrowIllegalArgumentExceptionIfEnumClassIsNotEnumClass() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    EnumUtils.generateBitVectors(String.class, values));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if values contain null")
        void shouldThrowIllegalArgumentExceptionIfValuesContainNull() {
            values[0] = null;
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    EnumUtils.generateBitVectors(enumClass, values));
        }

    }

    @Nested
    @DisplayName("Tests for generateBitVectors(Class<E> enumClass, Iterable<? extends E> values)")
    class GenerateBitVectorsIterableTest {

        private Class<TestEnum> enumClass;
        private EnumSet<TestEnum> values;

        @BeforeEach
        void setUp() {
            enumClass = TestEnum.class;
            values = EnumSet.allOf(enumClass);
        }

        @Test
        @DisplayName("Should generate bit vectors for enum values")
        void shouldGenerateBitVectorsForEnumValues() {
            long[] bitVectors = EnumUtils.generateBitVectors(enumClass, values);
            Assertions.assertNotNull(bitVectors);
            Assertions.assertEquals(1, bitVectors.length);
            Assertions.assertNotEquals(0, bitVectors[0]);
        }

        @Test
        @DisplayName("Should throw NullPointerException if enumClass is null")
        void shouldThrowNullPointerExceptionIfEnumClassIsNull() {
            Assertions.assertThrows(NullPointerException.class, () ->
                    EnumUtils.generateBitVectors(null, values));
        }

        @Test
        @DisplayName("Should throw NullPointerException if values is null")
        void shouldThrowNullPointerExceptionIfValuesIsNull() {
            Assertions.assertThrows(NullPointerException.class, () ->
                    EnumUtils.generateBitVectors(enumClass, null));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if enumClass is not an enum class")
        void shouldThrowIllegalArgumentExceptionIfEnumClassIsNotEnumClass() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    EnumUtils.generateBitVectors(String.class, values));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if values contain null")
        void shouldThrowIllegalArgumentExceptionIfValuesContainNull() {
            values.add(null);
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    EnumUtils.generateBitVectors(enumClass, values));
        }

    }

    enum TestEnum {
        VALUE1, VALUE2, VALUE3
    }

}
