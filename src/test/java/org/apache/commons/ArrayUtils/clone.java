import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class cloneTest {

    private boolean[] booleanArray;
    private byte[] byteArray;
    private char[] charArray;
    private double[] doubleArray;
    private float[] floatArray;
    private int[] intArray;
    private long[] longArray;
    private short[] shortArray;
    private String[] stringArray;

    @BeforeEach
    void setUp() {
        booleanArray = new boolean[]{true, false};
        byteArray = new byte[]{1, 2, 3};
        charArray = new char[]{'a', 'b', 'c'};
        doubleArray = new double[]{1.0, 2.0, 3.0};
        floatArray = new float[]{1.0f, 2.0f, 3.0f};
        intArray = new int[]{1, 2, 3};
        longArray = new long[]{1L, 2L, 3L};
        shortArray = new short[]{1, 2, 3};
        stringArray = new String[]{"hello", "world"};
    }

    @Test
    void testClone_booleanArray() {
        boolean[] clonedArray = ArrayUtils.clone(booleanArray);
        assertArrayEquals(booleanArray, clonedArray);
        assertNotSame(booleanArray, clonedArray);
    }

    @Test
    void testClone_byteArray() {
        byte[] clonedArray = ArrayUtils.clone(byteArray);
        assertArrayEquals(byteArray, clonedArray);
        assertNotSame(byteArray, clonedArray);
    }

    @Test
    void testClone_charArray() {
        char[] clonedArray = ArrayUtils.clone(charArray);
        assertArrayEquals(charArray, clonedArray);
        assertNotSame(charArray, clonedArray);
    }

    @Test
    void testClone_doubleArray() {
        double[] clonedArray = ArrayUtils.clone(doubleArray);
        assertArrayEquals(doubleArray, clonedArray);
        assertNotSame(doubleArray, clonedArray);
    }

    @Test
    void testClone_floatArray() {
        float[] clonedArray = ArrayUtils.clone(floatArray);
        assertArrayEquals(floatArray, clonedArray);
        assertNotSame(floatArray, clonedArray);
    }

    @Test
    void testClone_intArray() {
        int[] clonedArray = ArrayUtils.clone(intArray);
        assertArrayEquals(intArray, clonedArray);
        assertNotSame(intArray, clonedArray);
    }

    @Test
    void testClone_longArray() {
        long[] clonedArray = ArrayUtils.clone(longArray);
        assertArrayEquals(longArray, clonedArray);
        assertNotSame(longArray, clonedArray);
    }

    @Test
    void testClone_shortArray() {
        short[] clonedArray = ArrayUtils.clone(shortArray);
        assertArrayEquals(shortArray, clonedArray);
        assertNotSame(shortArray, clonedArray);
    }

    @Test
    void testClone_stringArray() {
        String[] clonedArray = ArrayUtils.clone(stringArray);
        assertArrayEquals(stringArray, clonedArray);
        assertNotSame(stringArray, clonedArray);
    }

    @Test
    void testClone_nullArray() {
        boolean[] booleanArray = null;
        boolean[] clonedArray = ArrayUtils.clone(booleanArray);
        assertNull(clonedArray);
    }
}