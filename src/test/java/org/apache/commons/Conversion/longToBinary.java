import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class longToBinaryTest {

    Conversion conversion;

    @BeforeEach
    void setUp() {
        conversion = new Conversion();
    }

    @Nested
    @DisplayName("Test longToBinary method")
    class TestLongToBinary {

        @Test
        @DisplayName("Test conversion of positive long")
        void testPositiveLongConversion() {
            long src = 10;
            int srcPos = 0;
            boolean[] dst = new boolean[4];
            int dstPos = 0;
            int nBools = 4;

            boolean[] expected = {false, true, false, true};
            boolean[] result = conversion.longToBinary(src, srcPos, dst, dstPos, nBools);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test conversion of negative long")
        void testNegativeLongConversion() {
            long src = -10;
            int srcPos = 0;
            boolean[] dst = new boolean[4];
            int dstPos = 0;
            int nBools = 4;

            boolean[] expected = {true, false, true, false};
            boolean[] result = conversion.longToBinary(src, srcPos, dst, dstPos, nBools);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test conversion with srcPos > 0")
        void testConversionWithSrcPos() {
            long src = 10;
            int srcPos = 2;
            boolean[] dst = new boolean[4];
            int dstPos = 0;
            int nBools = 4;

            boolean[] expected = {true, false, true, false};
            boolean[] result = conversion.longToBinary(src, srcPos, dst, dstPos, nBools);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test conversion with dstPos > 0")
        void testConversionWithDstPos() {
            long src = 10;
            int srcPos = 0;
            boolean[] dst = new boolean[6];
            int dstPos = 2;
            int nBools = 4;

            boolean[] expected = {false, false, false, true, false, true};
            boolean[] result = conversion.longToBinary(src, srcPos, dst, dstPos, nBools);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test conversion with nBools = 0")
        void testConversionWithZeroNBools() {
            long src = 10;
            int srcPos = 0;
            boolean[] dst = new boolean[4];
            int dstPos = 0;
            int nBools = 0;

            boolean[] expected = new boolean[4];
            boolean[] result = conversion.longToBinary(src, srcPos, dst, dstPos, nBools);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test conversion with nBools > width of input")
        void testConversionWithLargeNBools() {
            long src = 10;
            int srcPos = 0;
            boolean[] dst = new boolean[4];
            int dstPos = 0;
            int nBools = 8;

            assertThrows(IllegalArgumentException.class, () -> {
                conversion.longToBinary(src, srcPos, dst, dstPos, nBools);
            });
        }

        @Test
        @DisplayName("Test conversion with dstPos + nBools > dst.length")
        void testConversionWithInvalidDstPos() {
            long src = 10;
            int srcPos = 0;
            boolean[] dst = new boolean[4];
            int dstPos = 2;
            int nBools = 4;

            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                conversion.longToBinary(src, srcPos, dst, dstPos, nBools);
            });
        }
    }
}