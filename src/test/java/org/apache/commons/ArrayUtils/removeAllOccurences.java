
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveAllOccurencesTest {

    @Test
    void testRemoveAllOccurences_booleanArray() {
        boolean[] array = {true, false, true, false, true};
        boolean element = true;
        boolean[] expected = {false, false};

        boolean[] result = ArrayUtils.removeAllOccurences(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurences_byteArray() {
        byte[] array = {1, 2, 3, 4, 5};
        byte element = 3;
        byte[] expected = {1, 2, 4, 5};

        byte[] result = ArrayUtils.removeAllOccurences(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    // Add tests for other primitive types and Object arrays

    @Test
    void testRemoveAllOccurences_nullArray() {
        int[] array = null;
        int element = 1;
        int[] expected = null;

        int[] result = ArrayUtils.removeAllOccurences(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testRemoveAllOccurences_emptyArray() {
        int[] array = {};
        int element = 1;
        int[] expected = {};

        int[] result = ArrayUtils.removeAllOccurences(array, element);

        Assertions.assertArrayEquals(expected, result);
    }
}
