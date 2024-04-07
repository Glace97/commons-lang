import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;

class newInstanceTest {

    @Test
    void testEmptyBooleanArray() {
        boolean[] array = ArrayUtils.newInstance(boolean.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyBooleanObjectArray() {
        Boolean[] array = ArrayUtils.newInstance(Boolean.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyByteArray() {
        byte[] array = ArrayUtils.newInstance(byte.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyByteObjectArray() {
        Byte[] array = ArrayUtils.newInstance(Byte.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyCharArray() {
        char[] array = ArrayUtils.newInstance(char.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyCharacterObjectArray() {
        Character[] array = ArrayUtils.newInstance(Character.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyClassArray() {
        Class<?>[] array = ArrayUtils.newInstance(Class.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyDoubleArray() {
        double[] array = ArrayUtils.newInstance(double.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyDoubleObjectArray() {
        Double[] array = ArrayUtils.newInstance(Double.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyFieldArray() {
        Field[] array = ArrayUtils.newInstance(Field.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyFloatArray() {
        float[] array = ArrayUtils.newInstance(float.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyFloatObjectArray() {
        Float[] array = ArrayUtils.newInstance(Float.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyIntArray() {
        int[] array = ArrayUtils.newInstance(int.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyIntegerObjectArray() {
        Integer[] array = ArrayUtils.newInstance(Integer.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyLongArray() {
        long[] array = ArrayUtils.newInstance(long.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyLongObjectArray() {
        Long[] array = ArrayUtils.newInstance(Long.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyMethodArray() {
        Method[] array = ArrayUtils.newInstance(Method.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyObjectArray() {
        Object[] array = ArrayUtils.newInstance(Object.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyShortArray() {
        short[] array = ArrayUtils.newInstance(short.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyShortObjectArray() {
        Short[] array = ArrayUtils.newInstance(Short.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyStringArray() {
        String[] array = ArrayUtils.newInstance(String.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyThrowableArray() {
        Throwable[] array = ArrayUtils.newInstance(Throwable.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testEmptyTypeArray() {
        Type[] array = ArrayUtils.newInstance(Type.class, 0);
        assertEquals(0, array.length);
    }

    @Test
    void testIndexNotFound() {
        int[] array = ArrayUtils.newInstance(int.class, ArrayUtils.INDEX_NOT_FOUND);
        assertEquals(ArrayUtils.INDEX_NOT_FOUND, array.length);
    }
}