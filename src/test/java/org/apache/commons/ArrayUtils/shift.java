import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShiftTest {

    @Test
    void testShiftBooleanArray() {
        boolean[] array = {true, false, true, false};
        ArrayUtils.shift(array, 2);
        boolean[] expected = {true, false, false, true};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyBooleanArray() {
        boolean[] array = {};
        ArrayUtils.shift(array, 2);
        boolean[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftByteArray() {
        byte[] array = {1, 2, 3, 4};
        ArrayUtils.shift(array, 2);
        byte[] expected = {3, 4, 1, 2};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyByteArray() {
        byte[] array = {};
        ArrayUtils.shift(array, 2);
        byte[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftCharArray() {
        char[] array = {'a', 'b', 'c', 'd'};
        ArrayUtils.shift(array, 2);
        char[] expected = {'c', 'd', 'a', 'b'};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyCharArray() {
        char[] array = {};
        ArrayUtils.shift(array, 2);
        char[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftDoubleArray() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        ArrayUtils.shift(array, 2);
        double[] expected = {3.0, 4.0, 1.0, 2.0};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyDoubleArray() {
        double[] array = {};
        ArrayUtils.shift(array, 2);
        double[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftFloatArray() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        ArrayUtils.shift(array, 2);
        float[] expected = {3.0f, 4.0f, 1.0f, 2.0f};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyFloatArray() {
        float[] array = {};
        ArrayUtils.shift(array, 2);
        float[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftIntArray() {
        int[] array = {1, 2, 3, 4};
        ArrayUtils.shift(array, 2);
        int[] expected = {3, 4, 1, 2};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyIntArray() {
        int[] array = {};
        ArrayUtils.shift(array, 2);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftLongArray() {
        long[] array = {1L, 2L, 3L, 4L};
        ArrayUtils.shift(array, 2);
        long[] expected = {3L, 4L, 1L, 2L};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyLongArray() {
        long[] array = {};
        ArrayUtils.shift(array, 2);
        long[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftObjectArray() {
        Object[] array = {1, 2, 3, 4};
        ArrayUtils.shift(array, 2);
        Object[] expected = {3, 4, 1, 2};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyObjectArray() {
        Object[] array = {};
        ArrayUtils.shift(array, 2);
        Object[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftShortArray() {
        short[] array = {1, 2, 3, 4};
        ArrayUtils.shift(array, 2);
        short[] expected = {3, 4, 1, 2};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShiftEmptyShortArray() {
        short[] array = {};
        ArrayUtils.shift(array, 2);
        short[] expected = {};
        Assertions.assertArrayEquals(expected, array);
    }
}