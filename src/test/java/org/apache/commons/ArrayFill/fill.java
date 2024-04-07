import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class FillTest {
    
    @Test
    void testFillByte() {
        byte[] a = new byte[5];
        byte val = 1;
        byte[] expected = {1, 1, 1, 1, 1};
        byte[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    void testFillChar() {
        char[] a = new char[5];
        char val = 'a';
        char[] expected = {'a', 'a', 'a', 'a', 'a'};
        char[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    void testFillDouble() {
        double[] a = new double[5];
        double val = 1.5;
        double[] expected = {1.5, 1.5, 1.5, 1.5, 1.5};
        double[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    void testFillFloat() {
        float[] a = new float[5];
        float val = 1.5f;
        float[] expected = {1.5f, 1.5f, 1.5f, 1.5f, 1.5f};
        float[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    void testFillInt() {
        int[] a = new int[5];
        int val = 5;
        int[] expected = {5, 5, 5, 5, 5};
        int[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    void testFillLong() {
        long[] a = new long[5];
        long val = 10L;
        long[] expected = {10L, 10L, 10L, 10L, 10L};
        long[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    void testFillShort() {
        short[] a = new short[5];
        short val = 2;
        short[] expected = {2, 2, 2, 2, 2};
        short[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
    
    @Test
    void testFillGeneric() {
        Integer[] a = new Integer[5];
        Integer val = 3;
        Integer[] expected = {3, 3, 3, 3, 3};
        Integer[] result = ArrayFill.fill(a, val);
        Assertions.assertArrayEquals(expected, result);
    }
}