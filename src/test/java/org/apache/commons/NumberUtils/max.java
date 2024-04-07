
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaxTest {
    @Test
    void testMaxWithBytes() {
        byte[] array = {1, 2, 3, 4, 5};
        byte max = NumberUtils.max(array);
        Assertions.assertEquals(5, max);
    }

    @Test
    void testMaxWithDoubles() {
        double[] array = {1.5, 2.3, 4.1, 3.7};
        double max = NumberUtils.max(array);
        Assertions.assertEquals(4.1, max, 0.0001);
    }

    @Test
    void testMaxWithFloats() {
        float[] array = {1.5f, 2.3f, 4.1f, 3.7f};
        float max = NumberUtils.max(array);
        Assertions.assertEquals(4.1f, max, 0.0001);
    }

    @Test
    void testMaxWithIntegers() {
        int[] array = {1, 2, 3, 4, 5};
        int max = NumberUtils.max(array);
        Assertions.assertEquals(5, max);
    }

    @Test
    void testMaxWithLongs() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        long max = NumberUtils.max(array);
        Assertions.assertEquals(5L, max);
    }

    @Test
    void testMaxWithShorts() {
        short[] array = {1, 2, 3, 4, 5};
        short max = NumberUtils.max(array);
        Assertions.assertEquals(5, max);
    }

    @ParameterizedTest
    @ValueSource(bytes = {1, 2, 3})
    void testMaxWithThreeBytes(byte a) {
        byte b = 7;
        byte c = 4;
        byte max = NumberUtils.max(a, b, c);
        Assertions.assertEquals(7, max);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.5, 2.3, 4.1})
    void testMaxWithThreeDoubles(double a) {
        double b = 3.7;
        double c = 2.1;
        double max = NumberUtils.max(a, b, c);
        Assertions.assertEquals(4.1, max, 0.0001);
    }

    @ParameterizedTest
    @ValueSource(floats = {1.5f, 2.3f, 4.1f})
    void testMaxWithThreeFloats(float a) {
        float b = 3.7f;
        float c = 2.1f;
        float max = NumberUtils.max(a, b, c);
        Assertions.assertEquals(4.1f, max, 0.0001);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testMaxWithThreeIntegers(int a) {
        int b = 7;
        int c = 4;
        int max = NumberUtils.max(a, b, c);
        Assertions.assertEquals(7, max);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void testMaxWithThreeLongs(long a) {
        long b = 7L;
        long c = 4L;
        long max = NumberUtils.max(a, b, c);
        Assertions.assertEquals(7L, max);
    }

    @ParameterizedTest
    @ValueSource(shorts = {1, 2, 3})
    void testMaxWithThreeShorts(short a) {
        short b = 7;
        short c = 4;
        short max = NumberUtils.max(a, b, c);
        Assertions.assertEquals(7, max);
    }
}
