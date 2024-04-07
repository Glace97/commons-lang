
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SortTest {

    @Nested
    class ByteArraySortTest {

        private byte[] array;

        @BeforeEach
        void setUp() {
            array = new byte[] { 4, 2, 6, 1, 3 };
        }

        @Test
        void testSort() {
            byte[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new byte[] { 1, 2, 3, 4, 6 }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class CharArraySortTest {

        private char[] array;

        @BeforeEach
        void setUp() {
            array = new char[] { 'd', 'b', 'f', 'a', 'c' };
        }

        @Test
        void testSort() {
            char[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new char[] { 'a', 'b', 'c', 'd', 'f' }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class DoubleArraySortTest {

        private double[] array;

        @BeforeEach
        void setUp() {
            array = new double[] { 4.2, 2.1, 6.7, 1.5, 3.9 };
        }

        @Test
        void testSort() {
            double[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new double[] { 1.5, 2.1, 3.9, 4.2, 6.7 }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class FloatArraySortTest {

        private float[] array;

        @BeforeEach
        void setUp() {
            array = new float[] { 4.2f, 2.1f, 6.7f, 1.5f, 3.9f };
        }

        @Test
        void testSort() {
            float[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new float[] { 1.5f, 2.1f, 3.9f, 4.2f, 6.7f }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class IntArraySortTest {

        private int[] array;

        @BeforeEach
        void setUp() {
            array = new int[] { 4, 2, 6, 1, 3 };
        }

        @Test
        void testSort() {
            int[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new int[] { 1, 2, 3, 4, 6 }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class LongArraySortTest {

        private long[] array;

        @BeforeEach
        void setUp() {
            array = new long[] { 4L, 2L, 6L, 1L, 3L };
        }

        @Test
        void testSort() {
            long[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new long[] { 1L, 2L, 3L, 4L, 6L }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class ShortArraySortTest {

        private short[] array;

        @BeforeEach
        void setUp() {
            array = new short[] { 4, 2, 6, 1, 3 };
        }

        @Test
        void testSort() {
            short[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new short[] { 1, 2, 3, 4, 6 }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class ObjectArraySortTest {

        private String[] array;

        @BeforeEach
        void setUp() {
            array = new String[] { "d", "b", "f", "a", "c" };
        }

        @Test
        void testSort() {
            String[] sortedArray = ArraySorter.sort(array);
            assertArrayEquals(new String[] { "a", "b", "c", "d", "f" }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

    @Nested
    class ObjectArraySortWithComparatorTest {

        private Integer[] array;

        @BeforeEach
        void setUp() {
            array = new Integer[] { 4, 2, 6, 1, 3 };
        }

        @Test
        void testSort() {
            Integer[] sortedArray = ArraySorter.sort(array, Comparator.reverseOrder());
            assertArrayEquals(new Integer[] { 6, 4, 3, 2, 1 }, sortedArray);
        }

        // Add more tests to cover edge cases and different scenarios

    }

}
