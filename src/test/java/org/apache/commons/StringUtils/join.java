import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class joinTest {

    @Test
    void testJoinWithBooleanArray() {
        boolean[] array = {true, false, true};
        char delimiter = ';';
        String expected = "true;false;true";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithBooleanArrayAndRange() {
        boolean[] array = {true, false, true, false};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "false;true";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithByteArray() {
        byte[] array = {1, 2, 3};
        char delimiter = ';';
        String expected = "1;2;3";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithByteArrayAndRange() {
        byte[] array = {1, 2, 3, 4};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "2;3";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithCharArray() {
        char[] array = {'a', 'b', 'c'};
        char delimiter = ';';
        String expected = "a;b;c";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithCharArrayAndRange() {
        char[] array = {'a', 'b', 'c', 'd'};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "b;c";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithDoubleArray() {
        double[] array = {1.0, 2.0, 3.0};
        char delimiter = ';';
        String expected = "1.0;2.0;3.0";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithDoubleArrayAndRange() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "2.0;3.0";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithFloatArray() {
        float[] array = {1.0f, 2.0f, 3.0f};
        char delimiter = ';';
        String expected = "1.0;2.0;3.0";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithFloatArrayAndRange() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "2.0;3.0";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithIntArray() {
        int[] array = {1, 2, 3};
        char delimiter = ';';
        String expected = "1;2;3";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithIntArrayAndRange() {
        int[] array = {1, 2, 3, 4};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "2;3";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithIterable() {
        List<String> list = Arrays.asList("a", "b", "c");
        char delimiter = ';';
        String expected = "a;b;c";
        String result = StringUtils.join(list, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithIterator() {
        List<String> list = Arrays.asList("a", "b", "c");
        char delimiter = ';';
        String expected = "a;b;c";
        String result = StringUtils.join(list.iterator(), delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithList() {
        List<String> list = Arrays.asList("a", "b", "c");
        char delimiter = ';';
        String expected = "a;b;c";
        String result = StringUtils.join(list, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithListAndRange() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "b;c";
        String result = StringUtils.join(list, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithObjectArray() {
        String[] array = {"a", "b", "c"};
        char delimiter = ';';
        String expected = "a;b;c";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithObjectArrayAndRange() {
        String[] array = {"a", "b", "c", "d"};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "b;c";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithLongArray() {
        long[] array = {1L, 2L, 3L};
        char delimiter = ';';
        String expected = "1;2;3";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithLongArrayAndRange() {
        long[] array = {1L, 2L, 3L, 4L};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "2;3";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithShortArray() {
        short[] array = {1, 2, 3};
        char delimiter = ';';
        String expected = "1;2;3";
        String result = StringUtils.join(array, delimiter);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithShortArrayAndRange() {
        short[] array = {1, 2, 3, 4};
        char delimiter = ';';
        int startIndex = 1;
        int endIndex = 3;
        String expected = "2;3";
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(expected, result);
    }

    @Test
    void testJoinWithVarargs() {
        String expected = "a;b;c";
        String result = StringUtils.join("a", "b", "c");
        assertEquals(expected, result);
    }
}