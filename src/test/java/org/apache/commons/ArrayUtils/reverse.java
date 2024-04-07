import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ReverseTest {

    @Nested
    @DisplayName("Tests for reverse(boolean[])")
    class ReverseBooleanArrayTest {
        
        private boolean[] array;
        
        @BeforeEach
        void setUp() {
            array = new boolean[] {true, false, true};
        }
        
        @Test
        void reverseShouldReverseBooleanArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new boolean[] {true, false, true}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseBooleanArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new boolean[] {false, true, true}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new boolean[] {true, false, true}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(byte[])")
    class ReverseByteArrayTest {
        
        private byte[] array;
        
        @BeforeEach
        void setUp() {
            array = new byte[] {1, 2, 3};
        }
        
        @Test
        void reverseShouldReverseByteArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new byte[] {3, 2, 1}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseByteArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new byte[] {2, 1, 3}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new byte[] {1, 2, 3}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(char[])")
    class ReverseCharArrayTest {
        
        private char[] array;
        
        @BeforeEach
        void setUp() {
            array = new char[] {'a', 'b', 'c'};
        }
        
        @Test
        void reverseShouldReverseCharArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new char[] {'c', 'b', 'a'}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseCharArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new char[] {'b', 'a', 'c'}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new char[] {'a', 'b', 'c'}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(double[])")
    class ReverseDoubleArrayTest {
        
        private double[] array;
        
        @BeforeEach
        void setUp() {
            array = new double[] {1.0, 2.0, 3.0};
        }
        
        @Test
        void reverseShouldReverseDoubleArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new double[] {3.0, 2.0, 1.0}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseDoubleArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new double[] {2.0, 1.0, 3.0}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new double[] {1.0, 2.0, 3.0}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(float[])")
    class ReverseFloatArrayTest {
        
        private float[] array;
        
        @BeforeEach
        void setUp() {
            array = new float[] {1.0f, 2.0f, 3.0f};
        }
        
        @Test
        void reverseShouldReverseFloatArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new float[] {3.0f, 2.0f, 1.0f}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseFloatArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new float[] {2.0f, 1.0f, 3.0f}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new float[] {1.0f, 2.0f, 3.0f}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(int[])")
    class ReverseIntArrayTest {
        
        private int[] array;
        
        @BeforeEach
        void setUp() {
            array = new int[] {1, 2, 3};
        }
        
        @Test
        void reverseShouldReverseIntArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new int[] {3, 2, 1}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseIntArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new int[] {2, 1, 3}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new int[] {1, 2, 3}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(long[])")
    class ReverseLongArrayTest {
        
        private long[] array;
        
        @BeforeEach
        void setUp() {
            array = new long[] {1L, 2L, 3L};
        }
        
        @Test
        void reverseShouldReverseLongArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new long[] {3L, 2L, 1L}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseLongArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new long[] {2L, 1L, 3L}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new long[] {1L, 2L, 3L}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(Object[])")
    class ReverseObjectArrayTest {
        
        private Object[] array;
        
        @BeforeEach
        void setUp() {
            array = new Object[] {1, 2, 3};
        }
        
        @Test
        void reverseShouldReverseObjectArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new Object[] {3, 2, 1}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseObjectArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new Object[] {2, 1, 3}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new Object[] {1, 2, 3}, array);
        }
    }
    
    @Nested
    @DisplayName("Tests for reverse(short[])")
    class ReverseShortArrayTest {
        
        private short[] array;
        
        @BeforeEach
        void setUp() {
            array = new short[] {1, 2, 3};
        }
        
        @Test
        void reverseShouldReverseShortArray() {
            ArrayUtils.reverse(array);
            
            assertArrayEquals(new short[] {3, 2, 1}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArray() {
            array = null;
            ArrayUtils.reverse(array);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldReverseShortArrayInRange() {
            ArrayUtils.reverse(array, 0, 2);
            
            assertArrayEquals(new short[] {2, 1, 3}, array);
        }
        
        @Test
        void reverseShouldDoNothingForNullArrayInRange() {
            array = null;
            ArrayUtils.reverse(array, 0, 2);
            
            assertNull(array);
        }
        
        @Test
        void reverseShouldDoNothingForOutOfRangeIndices() {
            ArrayUtils.reverse(array, -1, 3);
            
            assertArrayEquals(new short[] {1, 2, 3}, array);
        }
    }
}