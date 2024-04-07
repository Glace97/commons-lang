
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;

class generateBitVectorTest {

    @Nested
    @DisplayName("generateBitVector(Class<E> enumClass, E... values)")
    class GenerateBitVectorArrayTest {

        @Test
        @DisplayName("Should generate correct bit vector for enum values")
        void shouldGenerateCorrectBitVectorForEnumValues() {
            EnumUtils.Color[] colors = {EnumUtils.Color.RED, EnumUtils.Color.GREEN, EnumUtils.Color.BLUE};
            long bitVector = EnumUtils.generateBitVector(EnumUtils.Color.class, colors);
            assertEquals(7, bitVector);
        }

        @Test
        @DisplayName("Should throw NullPointerException if enumClass is null")
        void shouldThrowNullPointerExceptionIfEnumClassIsNull() {
            EnumUtils.Color[] colors = {EnumUtils.Color.RED, EnumUtils.Color.GREEN, EnumUtils.Color.BLUE};
            assertThrows(NullPointerException.class, () -> EnumUtils.generateBitVector(null, colors));
        }

        @Test
        @DisplayName("Should throw NullPointerException if values is null")
        void shouldThrowNullPointerExceptionIfValuesIsNull() {
            assertThrows(NullPointerException.class, () -> EnumUtils.generateBitVector(EnumUtils.Color.class, (EnumUtils.Color[]) null));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if enumClass is not an enum class")
        void shouldThrowIllegalArgumentExceptionIfEnumClassIsNotEnum() {
            EnumUtils.Color[] colors = {EnumUtils.Color.RED, EnumUtils.Color.GREEN, EnumUtils.Color.BLUE};
            assertThrows(IllegalArgumentException.class, () -> EnumUtils.generateBitVector(String.class, colors));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if enumClass has more than 64 values")
        void shouldThrowIllegalArgumentExceptionIfEnumClassHasMoreThan64Values() {
            EnumUtils.Color[] colors = EnumUtils.Color.values();
            assertThrows(IllegalArgumentException.class, () -> EnumUtils.generateBitVector(EnumUtils.Color.class, colors));
        }

    }

    @Nested
    @DisplayName("generateBitVector(Class<E> enumClass, Iterable<? extends E> values)")
    class GenerateBitVectorIterableTest {

        @Test
        @DisplayName("Should generate correct bit vector for enum values")
        void shouldGenerateCorrectBitVectorForEnumValues() {
            EnumSet<EnumUtils.Color> colors = EnumSet.of(EnumUtils.Color.RED, EnumUtils.Color.GREEN, EnumUtils.Color.BLUE);
            long bitVector = EnumUtils.generateBitVector(EnumUtils.Color.class, colors);
            assertEquals(7, bitVector);
        }

        @Test
        @DisplayName("Should throw NullPointerException if enumClass is null")
        void shouldThrowNullPointerExceptionIfEnumClassIsNull() {
            EnumSet<EnumUtils.Color> colors = EnumSet.of(EnumUtils.Color.RED, EnumUtils.Color.GREEN, EnumUtils.Color.BLUE);
            assertThrows(NullPointerException.class, () -> EnumUtils.generateBitVector(null, colors));
        }

        @Test
        @DisplayName("Should throw NullPointerException if values is null")
        void shouldThrowNullPointerExceptionIfValuesIsNull() {
            assertThrows(NullPointerException.class, () -> EnumUtils.generateBitVector(EnumUtils.Color.class, (Iterable<EnumUtils.Color>) null));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if enumClass is not an enum class")
        void shouldThrowIllegalArgumentExceptionIfEnumClassIsNotEnum() {
            EnumSet<EnumUtils.Color> colors = EnumSet.of(EnumUtils.Color.RED, EnumUtils.Color.GREEN, EnumUtils.Color.BLUE);
            assertThrows(IllegalArgumentException.class, () -> EnumUtils.generateBitVector(String.class, colors));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException if enumClass has more than 64 values")
        void shouldThrowIllegalArgumentExceptionIfEnumClassHasMoreThan64Values() {
            EnumSet<EnumUtils.Color> colors = EnumSet.allOf(EnumUtils.Color.class);
            assertThrows(IllegalArgumentException.class, () -> EnumUtils.generateBitVector(EnumUtils.Color.class, colors));
        }

    }

}
