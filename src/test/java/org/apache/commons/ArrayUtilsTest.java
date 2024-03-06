package org.apache.commons.lang3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
public class ArrayUtilsTest {
        @Test
        void testAdd_EmptyArray_ReturnsArrayWithElement() {
            boolean[] array = {};
            boolean element = true;
            boolean[] expected = {true};

            boolean[] result = ArrayUtils.add(array, element);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        void testAdd_NonEmptyArray_ReturnsArrayWithElementAppended() {
            boolean[] array = {true, false};
            boolean element = true;
            boolean[] expected = {true, false, true};

            boolean[] result = ArrayUtils.add(array, element);

            Assertions.assertArrayEquals(expected, result);
        }

        @Test
        void testAdd_NullArray_ReturnsArrayWithElement() {
            boolean[] array = null;
            boolean element = true;
            boolean[] expected = {true};

            boolean[] result = ArrayUtils.add(array, element);

            Assertions.assertArrayEquals(expected, result);
        }

    @Test
    void testAdd_NullArray_ReturnsArrayWithElementAtIndexZero() {
        boolean[] array = null;
        int index = 0;
        boolean element = true;
        boolean[] expected = {true};

        boolean[] result = ArrayUtils.add(array, index, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_EmptyArray_ReturnsArrayWithElementAtIndexZero() {
        boolean[] array = {};
        int index = 0;
        boolean element = true;
        boolean[] expected = {true};

        boolean[] result = ArrayUtils.add(array, index, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_IndexZero_ReturnsArrayWithElementAtIndexZero() {
        boolean[] array = {true, false};
        int index = 0;
        boolean element = true;
        boolean[] expected = {true, true, false};

        boolean[] result = ArrayUtils.add(array, index, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_IndexWithinArrayBounds_ReturnsArrayWithElementAtIndex() {
        boolean[] array = {true, false};
        int index = 1;
        boolean element = true;
        boolean[] expected = {true, true, false};

        boolean[] result = ArrayUtils.add(array, index, element);

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testAdd_IndexOutOfBounds_ThrowsIndexOutOfBoundsException() {
        boolean[] array = {true, false};
        int index = 3;
        boolean element = true;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            ArrayUtils.add(array, index, element);
        });
    }

    // Rad: 274
    @Test
    public void testAdd_NullArray_ReturnsNewArrayWithElement() {
        byte[] array = null;
        byte element = 0;
        byte[] result = ArrayUtils.add(array, element);
        assertArrayEquals(new byte[]{0}, result);
    }

    @Test
    public void testAdd_EmptyArray_ReturnsNewArrayWithElement() {
        byte[] array = new byte[]{};
        byte element = 0;
        byte[] result = ArrayUtils.add(array, element);
        assertArrayEquals(new byte[]{0}, result);
    }

    @Test
    public void testAdd_NonEmptyArray_ReturnsNewArrayWithElementAtEnd() {
        byte[] array = new byte[]{1, 2, 3};
        byte element = 4;
        byte[] result = ArrayUtils.add(array, element);
        assertArrayEquals(new byte[]{1, 2, 3, 4}, result);
    }

    @Test
    public void testAdd_EmptyArray_ReturnsDifferentArrayInstance() {
        byte[] array = new byte[]{};
        byte element = 0;
        byte[] result = ArrayUtils.add(array, element);
        assertNotSame(array, result);
    }

    @Test
    public void testAdd_NonEmptyArray_ReturnsDifferentArrayInstance() {
        byte[] array = new byte[]{1, 2, 3};
        byte element = 4;
        byte[] result = ArrayUtils.add(array, element);
        assertNotSame(array, result);
    }

    // Rad: 312
    @Test
    public void testAdd_NullByteArray_ReturnsNewArrayWithElement() {
        byte[] array = null;
        int index = 0;
        byte element = 2;
        byte[] result = ArrayUtils.add(array, index, element);
        assertArrayEquals(new byte[]{2}, result);
    }

    @Test
    public void testAdd_EmptyByteArray_ReturnsNewArrayWithElement() {
        byte[] array = new byte[]{};
        int index = 0;
        byte element = 2;
        byte[] result = ArrayUtils.add(array, index, element);
        assertArrayEquals(new byte[]{2}, result);
    }

    @Test
    public void testAdd_InsertAtBeginning_ReturnsNewArrayWithElementAtCorrectPosition() {
        byte[] array = new byte[]{2, 6};
        int index = 0;
        byte element = 1;
        byte[] result = ArrayUtils.add(array, index, element);
        assertArrayEquals(new byte[]{1, 2, 6}, result);
    }

    @Test
    public void testAdd_InsertInMiddle_ReturnsNewArrayWithElementAtCorrectPosition() {
        byte[] array = new byte[]{2, 6};
        int index = 1;
        byte element = 3;
        byte[] result = ArrayUtils.add(array, index, element);
        assertArrayEquals(new byte[]{2, 3, 6}, result);
    }

    @Test
    public void testAdd_InsertAtEnd_ReturnsNewArrayWithElementAtCorrectPosition() {
        byte[] array = new byte[]{2, 6};
        int index = 2;
        byte element = 3;
        byte[] result = ArrayUtils.add(array, index, element);
        assertArrayEquals(new byte[]{2, 6, 3}, result);
    }

    @Test
    public void testAdd_NullArray_ReturnsDifferentArrayInstance() {
        byte[] array = null;
        int index = 0;
        byte element = 2;
        byte[] result = ArrayUtils.add(array, index, element);
        assertNotSame(array, result);
    }

    @Test
    public void testAdd_EmptyByteArray_ReturnsDifferentArrayInstance() {
        byte[] array = new byte[]{};
        int index = 0;
        byte element = 2;
        byte[] result = ArrayUtils.add(array, index, element);
        assertNotSame(array, result);
    }

    @Test
    public void testAdd_NonEmptyByteArray_ReturnsDifferentArrayInstance() {
        byte[] array = new byte[]{2, 6};
        int index = 1;
        byte element = 3;
        byte[] result = ArrayUtils.add(array, index, element);
        assertNotSame(array, result);
    }

}
