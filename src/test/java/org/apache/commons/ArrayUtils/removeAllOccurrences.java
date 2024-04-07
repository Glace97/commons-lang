import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class removeAllOccurrencesTest {

    @Test
    void testRemoveAllOccurrences_booleanArray() {
        boolean[] array = {true, false, true, true, false};
        boolean[] expected = {false, false};
        boolean[] result = ArrayUtils.removeAllOccurrences(array, true);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyBooleanArray() {
        boolean[] array = {};
        boolean[] expected = {};
        boolean[] result = ArrayUtils.removeAllOccurrences(array, true);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_byteArray() {
        byte[] array = {1, 2, 3, 4, 5};
        byte[] expected = {2, 3, 4, 5};
        byte[] result = ArrayUtils.removeAllOccurrences(array, (byte) 1);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyByteArray() {
        byte[] array = {};
        byte[] expected = {};
        byte[] result = ArrayUtils.removeAllOccurrences(array, (byte) 1);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_charArray() {
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        char[] expected = {'b', 'c', 'd', 'e'};
        char[] result = ArrayUtils.removeAllOccurrences(array, 'a');
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyCharArray() {
        char[] array = {};
        char[] expected = {};
        char[] result = ArrayUtils.removeAllOccurrences(array, 'a');
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_doubleArray() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] expected = {2.0, 3.0, 4.0, 5.0};
        double[] result = ArrayUtils.removeAllOccurrences(array, 1.0);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyDoubleArray() {
        double[] array = {};
        double[] expected = {};
        double[] result = ArrayUtils.removeAllOccurrences(array, 1.0);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_floatArray() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        float[] expected = {2.0f, 3.0f, 4.0f, 5.0f};
        float[] result = ArrayUtils.removeAllOccurrences(array, 1.0f);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyFloatArray() {
        float[] array = {};
        float[] expected = {};
        float[] result = ArrayUtils.removeAllOccurrences(array, 1.0f);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_intArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5};
        int[] result = ArrayUtils.removeAllOccurrences(array, 1);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyIntArray() {
        int[] array = {};
        int[] expected = {};
        int[] result = ArrayUtils.removeAllOccurrences(array, 1);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_longArray() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        long[] expected = {2L, 3L, 4L, 5L};
        long[] result = ArrayUtils.removeAllOccurrences(array, 1L);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyLongArray() {
        long[] array = {};
        long[] expected = {};
        long[] result = ArrayUtils.removeAllOccurrences(array, 1L);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_shortArray() {
        short[] array = {1, 2, 3, 4, 5};
        short[] expected = {2, 3, 4, 5};
        short[] result = ArrayUtils.removeAllOccurrences(array, (short) 1);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyShortArray() {
        short[] array = {};
        short[] expected = {};
        short[] result = ArrayUtils.removeAllOccurrences(array, (short) 1);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_objectArray() {
        String[] array = {"a", "b", "c", "d", "e"};
        String[] expected = {"b", "c", "d", "e"};
        String[] result = ArrayUtils.removeAllOccurrences(array, "a");
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurrences_emptyObjectArray() {
        String[] array = {};
        String[] expected = {};
        String[] result = ArrayUtils.removeAllOccurrences(array, "a");
        assertArrayEquals(expected, result);
    }

}