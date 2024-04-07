import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.BitSet;

class indexesOfTest {

    @Test
    void testIndexesOfBooleanArray() {
        boolean[] array = {true, false, true, true, false};
        boolean valueToFind = true;
        BitSet expected = new BitSet();
        expected.set(0);
        expected.set(2);
        expected.set(3);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfBooleanArrayWithStartIndex() {
        boolean[] array = {true, false, true, true, false};
        boolean valueToFind = true;
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(2);
        expected.set(3);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyBooleanArray() {
        boolean[] array = {};
        boolean valueToFind = true;
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfByteArray() {
        byte[] array = {1, 2, 3, 1, 2, 3};
        byte valueToFind = 2;
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfByteArrayWithStartIndex() {
        byte[] array = {1, 2, 3, 1, 2, 3};
        byte valueToFind = 2;
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyByteArray() {
        byte[] array = {};
        byte valueToFind = 2;
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfCharArray() {
        char[] array = {'a', 'b', 'c', 'a', 'b', 'c'};
        char valueToFind = 'b';
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfCharArrayWithStartIndex() {
        char[] array = {'a', 'b', 'c', 'a', 'b', 'c'};
        char valueToFind = 'b';
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyCharArray() {
        char[] array = {};
        char valueToFind = 'b';
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfDoubleArray() {
        double[] array = {1.0, 2.0, 3.0, 1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfDoubleArrayWithStartIndex() {
        double[] array = {1.0, 2.0, 3.0, 1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyDoubleArray() {
        double[] array = {};
        double valueToFind = 2.0;
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfFloatArray() {
        float[] array = {1.0f, 2.0f, 3.0f, 1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfFloatArrayWithStartIndex() {
        float[] array = {1.0f, 2.0f, 3.0f, 1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyFloatArray() {
        float[] array = {};
        float valueToFind = 2.0f;
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfIntArray() {
        int[] array = {1, 2, 3, 1, 2, 3};
        int valueToFind = 2;
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfIntArrayWithStartIndex() {
        int[] array = {1, 2, 3, 1, 2, 3};
        int valueToFind = 2;
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyIntArray() {
        int[] array = {};
        int valueToFind = 2;
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfLongArray() {
        long[] array = {1L, 2L, 3L, 1L, 2L, 3L};
        long valueToFind = 2L;
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfLongArrayWithStartIndex() {
        long[] array = {1L, 2L, 3L, 1L, 2L, 3L};
        long valueToFind = 2L;
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyLongArray() {
        long[] array = {};
        long valueToFind = 2L;
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfObjectArray() {
        Object[] array = {"a", "b", "c", "a", "b", "c"};
        Object valueToFind = "b";
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfObjectArrayWithStartIndex() {
        Object[] array = {"a", "b", "c", "a", "b", "c"};
        Object valueToFind = "b";
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyObjectArray() {
        Object[] array = {};
        Object valueToFind = "b";
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfShortArray() {
        short[] array = {1, 2, 3, 1, 2, 3};
        short valueToFind = 2;
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfShortArrayWithStartIndex() {
        short[] array = {1, 2, 3, 1, 2, 3};
        short valueToFind = 2;
        int startIndex = 2;
        BitSet expected = new BitSet();
        expected.set(4);
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testIndexesOfEmptyShortArray() {
        short[] array = {};
        short valueToFind = 2;
        BitSet expected = new BitSet();
        BitSet result = ArrayUtils.indexesOf(array, valueToFind);
        Assertions.assertEquals(expected, result);
    }
}