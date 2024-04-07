
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToObjectTest {

    @Test
    void testToObject_withNullArray_shouldReturnNull() {
        boolean[] array = null;
        assertNull(ArrayUtils.toObject(array));
    }

    @Test
    void testToObject_withEmptyBooleanArray_shouldReturnEmptyBooleanObjectArray() {
        boolean[] array = {};
        Boolean[] expected = {};
        assertArrayEquals(expected, ArrayUtils.toObject(array));
    }

    @Test
    void testToObject_withBooleanArray_shouldReturnBooleanObjectArray() {
        boolean[] array = {true, false, true};
        Boolean[] expected = {true, false, true};
        assertArrayEquals(expected, ArrayUtils.toObject(array));
    }

    @Test
    void testToObject_withEmptyByteArray_shouldReturnEmptyByteObjectArray() {
        byte[] array = {};
        Byte[] expected = {};
        assertArrayEquals(expected, ArrayUtils.toObject(array));
    }

    // Add tests for other primitive types

    // ...

}
