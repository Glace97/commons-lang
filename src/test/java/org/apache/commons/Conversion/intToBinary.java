import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class intToBinaryTest {

    private Conversion conversion;

    @BeforeEach
    void setUp() {
        conversion = new Conversion();
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTestCases {

        @Test
        @DisplayName("Test converting 0 to binary")
        void testIntToBinaryWithZero() {
            int src = 0;
            int srcPos = 0;
            int nBools = 4;
            boolean[] dst = new boolean[nBools];
            boolean[] expected = {false, false, false, false};
            boolean[] result = conversion.intToBinary(src, srcPos, dst, 0, nBools);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test converting positive non-zero number to binary")
        void testIntToBinaryWithPositiveNumber() {
            int src = 10;
            int srcPos = 0;
            int nBools = 4;
            boolean[] dst = new boolean[nBools];
            boolean[] expected = {false, true, false, true};
            boolean[] result = conversion.intToBinary(src, srcPos, dst, 0, nBools);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test converting negative number to binary")
        void testIntToBinaryWithNegativeNumber() {
            int src = -5;
            int srcPos = 0;
            int nBools = 4;
            boolean[] dst = new boolean[nBools];
            boolean[] expected = {true, true, true, true};
            boolean[] result = conversion.intToBinary(src, srcPos, dst, 0, nBools);
            assertArrayEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTestCases {

        @Test
        @DisplayName("Test converting with invalid nBools")
        void testIntToBinaryWithInvalidNBools() {
            int src = 5;
            int srcPos = 0;
            int nBools = 5;
            boolean[] dst = new boolean[4];
            assertThrows(IllegalArgumentException.class, () -> {
                conversion.intToBinary(src, srcPos, dst, 0, nBools);
            });
        }

        @Test
        @DisplayName("Test converting with null destination array")
        void testIntToBinaryWithNullDestinationArray() {
            int src = 5;
            int srcPos = 0;
            int nBools = 4;
            boolean[] dst = null;
            assertThrows(NullPointerException.class, () -> {
                conversion.intToBinary(src, srcPos, dst, 0, nBools);
            });
        }

        @Test
        @DisplayName("Test converting with array index out of bounds")
        void testIntToBinaryWithArrayIndexOutOfBounds() {
            int src = 5;
            int srcPos = 0;
            int nBools = 4;
            boolean[] dst = new boolean[3];
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                conversion.intToBinary(src, srcPos, dst, 0, nBools);
            });
        }

    }
}