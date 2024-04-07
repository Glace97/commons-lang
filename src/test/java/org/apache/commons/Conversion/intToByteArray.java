import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class intToByteArrayTest {

    Conversion conversion;

    @BeforeEach
    void setUp() {
        conversion = new Conversion();
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTestCases {

        @Test
        @DisplayName("Test converting int to byte array with nBytes = 1")
        void testIntToByteArrayWithNBytes1() {
            int src = 123;
            int srcPos = 0;
            byte[] dst = new byte[1];
            int dstPos = 0;
            int nBytes = 1;

            byte[] expected = {123};
            byte[] result = conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test converting int to byte array with nBytes = 2")
        void testIntToByteArrayWithNBytes2() {
            int src = 123456;
            int srcPos = 0;
            byte[] dst = new byte[2];
            int dstPos = 0;
            int nBytes = 2;

            byte[] expected = {64, -30};
            byte[] result = conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);

            Assertions.assertArrayEquals(expected, result);
        }

        // Add more positive test cases to cover different scenarios

    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTestCases {

        @Test
        @DisplayName("Test converting int to byte array with nBytes = 0")
        void testIntToByteArrayWithNBytes0() {
            int src = 123;
            int srcPos = 0;
            byte[] dst = new byte[1];
            int dstPos = 0;
            int nBytes = 0;

            byte[] expected = new byte[1];
            byte[] result = conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test converting int to byte array with nBytes exceeding width of input")
        void testIntToByteArrayWithNBytesExceedingWidth() {
            int src = 123;
            int srcPos = 0;
            byte[] dst = new byte[1];
            int dstPos = 0;
            int nBytes = 5;

            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes));
        }

        // Add more negative test cases to cover different scenarios

    }

    @Nested
    @DisplayName("Edge Test Cases")
    class EdgeTestCases {

        @Test
        @DisplayName("Test converting int to byte array with minimum src value")
        void testIntToByteArrayWithMinimumSrcValue() {
            int src = Integer.MIN_VALUE;
            int srcPos = 0;
            byte[] dst = new byte[4];
            int dstPos = 0;
            int nBytes = 4;

            byte[] expected = {-128, 0, 0, 0};
            byte[] result = conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test converting int to byte array with maximum src value")
        void testIntToByteArrayWithMaximumSrcValue() {
            int src = Integer.MAX_VALUE;
            int srcPos = 0;
            byte[] dst = new byte[4];
            int dstPos = 0;
            int nBytes = 4;

            byte[] expected = {127, -1, -1, -1};
            byte[] result = conversion.intToByteArray(src, srcPos, dst, dstPos, nBytes);

            Assertions.assertArrayEquals(expected, result);
        }

        // Add more edge test cases to cover different scenarios

    }
}