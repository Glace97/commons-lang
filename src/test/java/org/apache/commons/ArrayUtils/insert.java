import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class insertTest {

    @Test
    void testInsertWithNullArray() {
        int index = 0;
        boolean[] array = null;
        boolean[] values = {true, false};

        boolean[] result = ArrayUtils.insert(index, array, values);

        assertNull(result);
    }

    @Test
    void testInsertWithEmptyArray() {
        int index = 0;
        boolean[] array = {};
        boolean[] values = {true, false};

        boolean[] result = ArrayUtils.insert(index, array, values);

        assertArrayEquals(values, result);
    }

    @Test
    void testInsertAtIndexZero() {
        int index = 0;
        boolean[] array = {true, false};
        boolean[] values = {true, false};

        boolean[] expected = {true, false, true, false};

        boolean[] result = ArrayUtils.insert(index, array, values);

        assertArrayEquals(expected, result);
    }

    @Test
    void testInsertAtNonZeroIndex() {
        int index = 2;
        boolean[] array = {true, false};
        boolean[] values = {true, false};

        boolean[] expected = {true, false, true, false};

        boolean[] result = ArrayUtils.insert(index, array, values);

        assertArrayEquals(expected, result);
    }

    @Test
    void testInsertAtEndOfArray() {
        int index = 2;
        boolean[] array = {true, false};
        boolean[] values = {true, false};

        boolean[] expected = {true, false, true, false};

        boolean[] result = ArrayUtils.insert(index, array, values);

        assertArrayEquals(expected, result);
    }

    @Test
    void testInsertWithEmptyValues() {
        int index = 2;
        boolean[] array = {true, false};
        boolean[] values = {};

        boolean[] expected = {true, false};

        boolean[] result = ArrayUtils.insert(index, array, values);

        assertArrayEquals(expected, result);
    }

    @Test
    void testInsertWithIndexOutOfBounds() {
        int index = 3;
        boolean[] array = {true, false};
        boolean[] values = {true, false};

        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.insert(index, array, values));
    }
}