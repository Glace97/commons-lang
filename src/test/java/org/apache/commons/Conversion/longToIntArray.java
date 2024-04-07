import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class longToIntArrayTest {

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        @Test
        @DisplayName("Test converting long to int array with nInts = 1")
        void testLongToIntArrayWithNInts1() {
            long src = 1234567890L;
            int srcPos = 0;
            int[] dst = new int[1];
            int dstPos = 0;
            int nInts = 1;

            int[] expected = new int[]{1234567890};
            int[] result = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test converting long to int array with nInts > 1")
        void testLongToIntArrayWithNIntsGreaterThan1() {
            long src = 9876543210L;
            int srcPos = 0;
            int[] dst = new int[3];
            int dstPos = 1;
            int nInts = 2;

            int[] expected = new int[]{0, 9876543210, 0};
            int[] result = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);

            Assertions.assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTests {

        @Test
        @DisplayName("Test with nInts = 0")
        void testLongToIntArrayWithNInts0() {
            long src = 1234567890L;
            int srcPos = 0;
            int[] dst = new int[1];
            int dstPos = 0;
            int nInts = 0;

            int[] expected = new int[1];
            int[] result = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with invalid input: (nInts-1)*32+srcPos >= 64")
        void testLongToIntArrayWithInvalidInput() {
            long src = 1234567890L;
            int srcPos = 63;
            int[] dst = new int[2];
            int dstPos = 0;
            int nInts = 2;

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);
            });
        }

        @Test
        @DisplayName("Test with dstPos + nInts > dst.length")
        void testLongToIntArrayWithInvalidDstLength() {
            long src = 1234567890L;
            int srcPos = 0;
            int[] dst = new int[2];
            int dstPos = 1;
            int nInts = 2;

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);
            });
        }
    }

    @Nested
    @DisplayName("Edge Test Cases")
    class EdgeTests {

        @Test
        @DisplayName("Test with minimum src value")
        void testLongToIntArrayWithMinSrcValue() {
            long src = Long.MIN_VALUE;
            int srcPos = 0;
            int[] dst = new int[1];
            int dstPos = 0;
            int nInts = 1;

            int[] expected = new int[]{0};
            int[] result = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with maximum src value")
        void testLongToIntArrayWithMaxSrcValue() {
            long src = Long.MAX_VALUE;
            int srcPos = 0;
            int[] dst = new int[2];
            int dstPos = 0;
            int nInts = 2;

            int[] expected = new int[]{2147483647, -1};
            int[] result = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test with maximum nInts value")
        void testLongToIntArrayWithMaxNIntsValue() {
            long src = 1234567890L;
            int srcPos = 0;
            int[] dst = new int[Integer.MAX_VALUE];
            int dstPos = 0;
            int nInts = Integer.MAX_VALUE;

            int[] expected = new int[Integer.MAX_VALUE];
            Arrays.fill(expected, 1234567890);
            int[] result = Conversion.longToIntArray(src, srcPos, dst, dstPos, nInts);

            Assertions.assertArrayEquals(expected, result);
        }
    }
}