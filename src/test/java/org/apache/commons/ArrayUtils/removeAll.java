```
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class removeAllTest {

    private ArrayUtils arrayUtils;

    @BeforeEach
    void setUp() {
        arrayUtils = new ArrayUtils();
    }

    @Test
    void testRemoveAll_booleanArray() {
        boolean[] input = {true, false, true};
        boolean[] expected = {false};
        boolean[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_byteArray() {
        byte[] input = {1, 2, 3};
        byte[] expected = {2};
        byte[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_charArray() {
        char[] input = {'a', 'b', 'c'};
        char[] expected = {'b'};
        char[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_doubleArray() {
        double[] input = {1.0, 2.0, 3.0};
        double[] expected = {2.0};
        double[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_floatArray() {
        float[] input = {1.0f, 2.0f, 3.0f};
        float[] expected = {2.0f};
        float[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_intArray() {
        int[] input = {1, 2, 3};
        int[] expected = {2};
        int[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_longArray() {
        long[] input = {1L, 2L, 3L};
        long[] expected = {2L};
        long[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_shortArray() {
        short[] input = {1, 2, 3};
        short[] expected = {2};
        short[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAll_objectArray() {
        String[] input = {"a", "b", "c"};
        String[] expected = {"b"};
        String[] result = arrayUtils.removeAll(input, 0, 2);
        assertArrayEquals(expected, result);
    }
}
```
Note: The test class `removeAllTest` assumes that the `ArrayUtils` class is in the same package. If it is in a different package, make sure to import the `ArrayUtils` class properly.