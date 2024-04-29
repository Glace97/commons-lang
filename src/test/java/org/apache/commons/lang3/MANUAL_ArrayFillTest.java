//package org.apache.commons.lang3;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MANUAL_ArrayFillTest {
//
//    @Test
//    public void testFillByteArray() {
//        byte[] array = new byte[5];
//        byte value = 10;
//        byte[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new byte[]{10, 10, 10, 10, 10}, result, "The byte array should be filled with the value 10");
//    }
//
//    @Test
//    public void testFillCharArray() {
//        char[] array = new char[3];
//        char value = 'x';
//        char[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new char[]{'x', 'x', 'x'}, result, "The char array should be filled with 'x'");
//    }
//
//    @Test
//    public void testFillDoubleArray() {
//        double[] array = new double[4];
//        double value = 1.1;
//        double[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new double[]{1.1, 1.1, 1.1, 1.1}, result, "The double array should be filled with 1.1");
//    }
//
//    @Test
//    public void testFillFloatArray() {
//        float[] array = new float[2];
//        float value = 2.2f;
//        float[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new float[]{2.2f, 2.2f}, result, "The float array should be filled with 2.2f");
//    }
//
//    @Test
//    public void testFillIntArray() {
//        int[] array = new int[3];
//        int value = 3;
//        int[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new int[]{3, 3, 3}, result, "The int array should be filled with 3");
//    }
//
//    @Test
//    public void testFillLongArray() {
//        long[] array = new long[1];
//        long value = 999L;
//        long[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new long[]{999L}, result, "The long array should be filled with 999L");
//    }
//
//    @Test
//    public void testFillShortArray() {
//        short[] array = new short[2];
//        short value = 20;
//        short[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new short[]{20, 20}, result, "The short array should be filled with 20");
//    }
//
//    @Test
//    public void testFillObjectArray() {
//        String[] array = new String[3];
//        String value = "test";
//        String[] result = ArrayFill.fill(array, value);
//        assertArrayEquals(new String[]{"test", "test", "test"}, result, "The Object array should be filled with 'test'");
//    }
//
//    @Test
//    public void testFillEmptyArray() {
//        int[] array = new int[0];
//        int[] result = ArrayFill.fill(array, 5);
//        assertArrayEquals(new int[]{}, result, "An empty array should remain empty after fill operation");
//    }
//}
