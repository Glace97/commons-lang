import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class minTest {

    // Test for byte array
    @Test
    @DisplayName("Test min() method with byte array")
    void testMinByteArray() {
        byte[] array = {3, 1, 4, 2};
        byte expected = 1;
        byte actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for empty byte array
    @Test
    @DisplayName("Test min() method with empty byte array")
    void testMinEmptyByteArray() {
        byte[] array = {};
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(array);
        });
    }

    // Test for single element byte array
    @Test
    @DisplayName("Test min() method with single element byte array")
    void testMinSingleElementByteArray() {
        byte[] array = {5};
        byte expected = 5;
        byte actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for byte values
    @Test
    @DisplayName("Test min() method with byte values")
    void testMinByteValues() {
        byte a = 3;
        byte b = 1;
        byte c = 4;
        byte expected = 1;
        byte actual = NumberUtils.min(a, b, c);
        assertEquals(expected, actual);
    }

    // Test for double array
    @Test
    @DisplayName("Test min() method with double array")
    void testMinDoubleArray() {
        double[] array = {3.5, 1.2, 4.8, 2.1};
        double expected = 1.2;
        double actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for empty double array
    @Test
    @DisplayName("Test min() method with empty double array")
    void testMinEmptyDoubleArray() {
        double[] array = {};
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(array);
        });
    }

    // Test for single element double array
    @Test
    @DisplayName("Test min() method with single element double array")
    void testMinSingleElementDoubleArray() {
        double[] array = {5.7};
        double expected = 5.7;
        double actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for double values
    @Test
    @DisplayName("Test min() method with double values")
    void testMinDoubleValues() {
        double a = 3.5;
        double b = 1.2;
        double c = 4.8;
        double expected = 1.2;
        double actual = NumberUtils.min(a, b, c);
        assertEquals(expected, actual);
    }

    // Test for float array
    @Test
    @DisplayName("Test min() method with float array")
    void testMinFloatArray() {
        float[] array = {3.5f, 1.2f, 4.8f, 2.1f};
        float expected = 1.2f;
        float actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for empty float array
    @Test
    @DisplayName("Test min() method with empty float array")
    void testMinEmptyFloatArray() {
        float[] array = {};
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(array);
        });
    }

    // Test for single element float array
    @Test
    @DisplayName("Test min() method with single element float array")
    void testMinSingleElementFloatArray() {
        float[] array = {5.7f};
        float expected = 5.7f;
        float actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for float values
    @Test
    @DisplayName("Test min() method with float values")
    void testMinFloatValues() {
        float a = 3.5f;
        float b = 1.2f;
        float c = 4.8f;
        float expected = 1.2f;
        float actual = NumberUtils.min(a, b, c);
        assertEquals(expected, actual);
    }

    // Test for int array
    @Test
    @DisplayName("Test min() method with int array")
    void testMinIntArray() {
        int[] array = {3, 1, 4, 2};
        int expected = 1;
        int actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for empty int array
    @Test
    @DisplayName("Test min() method with empty int array")
    void testMinEmptyIntArray() {
        int[] array = {};
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(array);
        });
    }

    // Test for single element int array
    @Test
    @DisplayName("Test min() method with single element int array")
    void testMinSingleElementIntArray() {
        int[] array = {5};
        int expected = 5;
        int actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for int values
    @Test
    @DisplayName("Test min() method with int values")
    void testMinIntValues() {
        int a = 3;
        int b = 1;
        int c = 4;
        int expected = 1;
        int actual = NumberUtils.min(a, b, c);
        assertEquals(expected, actual);
    }

    // Test for long array
    @Test
    @DisplayName("Test min() method with long array")
    void testMinLongArray() {
        long[] array = {3, 1, 4, 2};
        long expected = 1;
        long actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for empty long array
    @Test
    @DisplayName("Test min() method with empty long array")
    void testMinEmptyLongArray() {
        long[] array = {};
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(array);
        });
    }

    // Test for single element long array
    @Test
    @DisplayName("Test min() method with single element long array")
    void testMinSingleElementLongArray() {
        long[] array = {5};
        long expected = 5;
        long actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for long values
    @Test
    @DisplayName("Test min() method with long values")
    void testMinLongValues() {
        long a = 3;
        long b = 1;
        long c = 4;
        long expected = 1;
        long actual = NumberUtils.min(a, b, c);
        assertEquals(expected, actual);
    }

    // Test for short array
    @Test
    @DisplayName("Test min() method with short array")
    void testMinShortArray() {
        short[] array = {3, 1, 4, 2};
        short expected = 1;
        short actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for empty short array
    @Test
    @DisplayName("Test min() method with empty short array")
    void testMinEmptyShortArray() {
        short[] array = {};
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.min(array);
        });
    }

    // Test for single element short array
    @Test
    @DisplayName("Test min() method with single element short array")
    void testMinSingleElementShortArray() {
        short[] array = {5};
        short expected = 5;
        short actual = NumberUtils.min(array);
        assertEquals(expected, actual);
    }

    // Test for short values
    @Test
    @DisplayName("Test min() method with short values")
    void testMinShortValues() {
        short a = 3;
        short b = 1;
        short c = 4;
        short expected = 1;
        short actual = NumberUtils.min(a, b, c);
        assertEquals(expected, actual);
    }
}