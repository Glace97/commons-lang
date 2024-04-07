import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class nullToEmptyTest {

    @Test
    void testNullToEmpty_booleanArray() {
        boolean[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_booleanObjectArray() {
        Boolean[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_byteArray() {
        byte[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_byteObjectArray() {
        Byte[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_charArray() {
        char[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_characterObjectArray() {
        Character[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_classArray() {
        Class<?>[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_doubleArray() {
        double[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_doubleObjectArray() {
        Double[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_floatArray() {
        float[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_FLOAT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_floatObjectArray() {
        Float[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_intArray() {
        int[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_integerObjectArray() {
        Integer[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_longArray() {
        long[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_LONG_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_longObjectArray() {
        Long[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_LONG_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_objectArray() {
        Object[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_shortArray() {
        short[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_SHORT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_shortObjectArray() {
        Short[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array));
    }

    @Test
    void testNullToEmpty_stringArray() {
        String[] array = null;
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, ArrayUtils.nullToEmpty(array));
    }
    
    @Test
    void testNullToEmpty_withTypeArgument() {
        Integer[] array = null;
        Class<Integer[]> type = Integer[].class;
        assertArrayEquals(ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY, ArrayUtils.nullToEmpty(array, type));
    }
}