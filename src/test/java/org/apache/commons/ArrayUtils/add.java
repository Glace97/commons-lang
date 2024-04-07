import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class addTest {

    @Test
    void testAdd_booleanArrayWithElement_returnsNewArrayWithElementAdded() {
        boolean[] array = {true, false};
        boolean element = true;
        boolean[] expected = {true, false, true};

        boolean[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_booleanArrayWithNullElement_returnsNewArrayWithNullElementAdded() {
        boolean[] array = {true, false};
        boolean element = false;
        boolean[] expected = {true, false, false};

        boolean[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_emptyBooleanArrayWithElement_returnsNewArrayWithElement() {
        boolean[] array = {};
        boolean element = true;
        boolean[] expected = {true};

        boolean[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_emptyBooleanArrayWithNullElement_returnsNewArrayWithNullElement() {
        boolean[] array = {};
        boolean element = false;
        boolean[] expected = {false};

        boolean[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_byteArrayWithElement_returnsNewArrayWithElementAdded() {
        byte[] array = {1, 2};
        byte element = 3;
        byte[] expected = {1, 2, 3};

        byte[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_byteArrayWithNullElement_returnsNewArrayWithNullElementAdded() {
        byte[] array = {1, 2};
        byte element = 0;
        byte[] expected = {1, 2, 0};

        byte[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_emptyByteArrayWithElement_returnsNewArrayWithElement() {
        byte[] array = {};
        byte element = 1;
        byte[] expected = {1};

        byte[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_emptyByteArrayWithNullElement_returnsNewArrayWithNullElement() {
        byte[] array = {};
        byte element = 0;
        byte[] expected = {0};

        byte[] result = ArrayUtils.add(array, element);

        Assertions.assertArrayEquals(expected, result);
    }

    // Repeat the same tests for char, double, float, int, long, short, and object arrays
    // ...

}