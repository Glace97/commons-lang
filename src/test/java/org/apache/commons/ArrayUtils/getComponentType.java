import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

class getComponentTypeTest {

    @Test
    void testEmptyBooleanArray() {
        boolean[] array = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        Class<Boolean> expectedType = Boolean.TYPE;
        Class<Boolean> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyBooleanObjectArray() {
        Boolean[] array = ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
        Class<Boolean> expectedType = Boolean.class;
        Class<Boolean> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyByteArray() {
        byte[] array = ArrayUtils.EMPTY_BYTE_ARRAY;
        Class<Byte> expectedType = Byte.TYPE;
        Class<Byte> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyByteObjectArray() {
        Byte[] array = ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        Class<Byte> expectedType = Byte.class;
        Class<Byte> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyCharArray() {
        char[] array = ArrayUtils.EMPTY_CHAR_ARRAY;
        Class<Character> expectedType = Character.TYPE;
        Class<Character> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyCharacterObjectArray() {
        Character[] array = ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY;
        Class<Character> expectedType = Character.class;
        Class<Character> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyClassArray() {
        Class<?>[] array = ArrayUtils.EMPTY_CLASS_ARRAY;
        Class<Class<?>> expectedType = Class.class;
        Class<Class<?>> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyDoubleArray() {
        double[] array = ArrayUtils.EMPTY_DOUBLE_ARRAY;
        Class<Double> expectedType = Double.TYPE;
        Class<Double> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyDoubleObjectArray() {
        Double[] array = ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY;
        Class<Double> expectedType = Double.class;
        Class<Double> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyFieldArray() {
        Field[] array = ArrayUtils.EMPTY_FIELD_ARRAY;
        Class<Field> expectedType = Field.class;
        Class<Field> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyFloatArray() {
        float[] array = ArrayUtils.EMPTY_FLOAT_ARRAY;
        Class<Float> expectedType = Float.TYPE;
        Class<Float> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyFloatObjectArray() {
        Float[] array = ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY;
        Class<Float> expectedType = Float.class;
        Class<Float> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyIntArray() {
        int[] array = ArrayUtils.EMPTY_INT_ARRAY;
        Class<Integer> expectedType = Integer.TYPE;
        Class<Integer> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyIntegerObjectArray() {
        Integer[] array = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        Class<Integer> expectedType = Integer.class;
        Class<Integer> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyLongArray() {
        long[] array = ArrayUtils.EMPTY_LONG_ARRAY;
        Class<Long> expectedType = Long.TYPE;
        Class<Long> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyLongObjectArray() {
        Long[] array = ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
        Class<Long> expectedType = Long.class;
        Class<Long> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyMethodArray() {
        Method[] array = ArrayUtils.EMPTY_METHOD_ARRAY;
        Class<Method> expectedType = Method.class;
        Class<Method> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyObjectArray() {
        Object[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
        Class<Object> expectedType = Object.class;
        Class<Object> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyShortArray() {
        short[] array = ArrayUtils.EMPTY_SHORT_ARRAY;
        Class<Short> expectedType = Short.TYPE;
        Class<Short> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyShortObjectArray() {
        Short[] array = ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY;
        Class<Short> expectedType = Short.class;
        Class<Short> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyStringArray() {
        String[] array = ArrayUtils.EMPTY_STRING_ARRAY;
        Class<String> expectedType = String.class;
        Class<String> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyThrowableArray() {
        Throwable[] array = ArrayUtils.EMPTY_THROWABLE_ARRAY;
        Class<Throwable> expectedType = Throwable.class;
        Class<Throwable> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }

    @Test
    void testEmptyTypeArray() {
        Type[] array = ArrayUtils.EMPTY_TYPE_ARRAY;
        Class<Type> expectedType = Type.class;
        Class<Type> actualType = ArrayUtils.getComponentType(array);
        assertEquals(expectedType, actualType);
    }
}