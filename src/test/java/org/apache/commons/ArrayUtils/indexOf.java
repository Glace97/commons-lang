
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class indexOfTest {

    private static final boolean[] BOOLEAN_ARRAY = {true, false, true};
    private static final byte[] BYTE_ARRAY = {1, 2, 3};
    private static final char[] CHAR_ARRAY = {'a', 'b', 'c'};
    private static final double[] DOUBLE_ARRAY = {1.0, 2.0, 3.0};
    private static final float[] FLOAT_ARRAY = {1.0f, 2.0f, 3.0f};
    private static final int[] INT_ARRAY = {1, 2, 3};
    private static final long[] LONG_ARRAY = {1L, 2L, 3L};
    private static final Object[] OBJECT_ARRAY = {"a", "b", "c"};
    private static final short[] SHORT_ARRAY = {1, 2, 3};

    @Test
    void testIndexOfBooleanArray() {
        assertEquals(0, ArrayUtils.indexOf(BOOLEAN_ARRAY, true));
        assertEquals(1, ArrayUtils.indexOf(BOOLEAN_ARRAY, false));
        assertEquals(-1, ArrayUtils.indexOf(BOOLEAN_ARRAY, true, 1));
    }

    @Test
    void testIndexOfByteArray() {
        assertEquals(0, ArrayUtils.indexOf(BYTE_ARRAY, (byte) 1));
        assertEquals(1, ArrayUtils.indexOf(BYTE_ARRAY, (byte) 2));
        assertEquals(-1, ArrayUtils.indexOf(BYTE_ARRAY, (byte) 1, 1));
    }

    @Test
    void testIndexOfCharArray() {
        assertEquals(0, ArrayUtils.indexOf(CHAR_ARRAY, 'a'));
        assertEquals(1, ArrayUtils.indexOf(CHAR_ARRAY, 'b'));
        assertEquals(-1, ArrayUtils.indexOf(CHAR_ARRAY, 'a', 1));
    }

    @Test
    void testIndexOfDoubleArray() {
        assertEquals(0, ArrayUtils.indexOf(DOUBLE_ARRAY, 1.0));
        assertEquals(1, ArrayUtils.indexOf(DOUBLE_ARRAY, 2.0));
        assertEquals(-1, ArrayUtils.indexOf(DOUBLE_ARRAY, 1.0, 1));
    }

    @Test
    void testIndexOfFloatArray() {
        assertEquals(0, ArrayUtils.indexOf(FLOAT_ARRAY, 1.0f));
        assertEquals(1, ArrayUtils.indexOf(FLOAT_ARRAY, 2.0f));
        assertEquals(-1, ArrayUtils.indexOf(FLOAT_ARRAY, 1.0f, 1));
    }

    @Test
    void testIndexOfIntArray() {
        assertEquals(0, ArrayUtils.indexOf(INT_ARRAY, 1));
        assertEquals(1, ArrayUtils.indexOf(INT_ARRAY, 2));
        assertEquals(-1, ArrayUtils.indexOf(INT_ARRAY, 1, 1));
    }

    @Test
    void testIndexOfLongArray() {
        assertEquals(0, ArrayUtils.indexOf(LONG_ARRAY, 1L));
        assertEquals(1, ArrayUtils.indexOf(LONG_ARRAY, 2L));
        assertEquals(-1, ArrayUtils.indexOf(LONG_ARRAY, 1L, 1));
    }

    @Test
    void testIndexOfObjectArray() {
        assertEquals(0, ArrayUtils.indexOf(OBJECT_ARRAY, "a"));
        assertEquals(1, ArrayUtils.indexOf(OBJECT_ARRAY, "b"));
        assertEquals(-1, ArrayUtils.indexOf(OBJECT_ARRAY, "a", 1));
    }

    @Test
    void testIndexOfShortArray() {
        assertEquals(0, ArrayUtils.indexOf(SHORT_ARRAY, (short) 1));
        assertEquals(1, ArrayUtils.indexOf(SHORT_ARRAY, (short) 2));
        assertEquals(-1, ArrayUtils.indexOf(SHORT_ARRAY, (short) 1, 1));
    }
}
