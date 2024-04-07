import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class intToShortArrayTest {

    private short[] dst;

    @BeforeEach
    void setUp() {
        dst = new short[4];
    }

    // Test case for converting 0 to short array
    @Test
    void testIntToShortArray_Zero() {
        Conversion.intToShortArray(0, 0, dst, 0, 4);
        assertArrayEquals(new short[]{0, 0, 0, 0}, dst);
    }

    // Test case for converting positive integer to short array
    @Test
    void testIntToShortArray_Positive() {
        Conversion.intToShortArray(65535, 0, dst, 0, 4);
        assertArrayEquals(new short[]{65535, 0, 0, 0}, dst);
    }

    // Test case for converting negative integer to short array
    @Test
    void testIntToShortArray_Negative() {
        Conversion.intToShortArray(-65535, 0, dst, 0, 4);
        assertArrayEquals(new short[]{-1, 0, 0, 0}, dst);
    }

    // Test case for converting integer with srcPos = 0
    @Test
    void testIntToShortArray_SrcPosZero() {
        Conversion.intToShortArray(65535, 0, dst, 0, 2);
        assertArrayEquals(new short[]{65535, 0, 0, 0}, dst);
    }

    // Test case for converting integer with srcPos > 0
    @Test
    void testIntToShortArray_SrcPosGreaterThanZero() {
        Conversion.intToShortArray(65535, 16, dst, 0, 2);
        assertArrayEquals(new short[]{0, 65535, 0, 0}, dst);
    }

    // Test case for converting integer with nShorts = 0
    @Test
    void testIntToShortArray_NShortsZero() {
        Conversion.intToShortArray(65535, 0, dst, 0, 0);
        assertArrayEquals(new short[]{0, 0, 0, 0}, dst);
    }

    // Test case for converting integer with nShorts > 0
    @Test
    void testIntToShortArray_NShortsGreaterThanZero() {
        Conversion.intToShortArray(65535, 0, dst, 0, 2);
        assertArrayEquals(new short[]{65535, 0, 0, 0}, dst);
    }

    // Test case for converting integer with nShorts = width of input
    @Test
    void testIntToShortArray_NShortsEqualToWidthOfInput() {
        Conversion.intToShortArray(65535, 0, dst, 0, 4);
        assertArrayEquals(new short[]{65535, 0, 0, 0}, dst);
    }

    // Test case for converting integer with nShorts > width of input
    @Test
    void testIntToShortArray_NShortsGreaterThanWidthOfInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToShortArray(65535, 0, dst, 0, 5);
        });
    }

    // Test case for converting integer with dstPos = 0
    @Test
    void testIntToShortArray_DstPosZero() {
        Conversion.intToShortArray(65535, 0, dst, 0, 2);
        assertArrayEquals(new short[]{65535, 0, 0, 0}, dst);
    }

    // Test case for converting integer with dstPos > 0
    @Test
    void testIntToShortArray_DstPosGreaterThanZero() {
        Conversion.intToShortArray(65535, 0, dst, 2, 2);
        assertArrayEquals(new short[]{0, 0, 65535, 0}, dst);
    }

    // Test case for converting integer with dstPos + nShorts > dst.length
    @Test
    void testIntToShortArray_DstPosPlusNShortsGreaterThanDstLength() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.intToShortArray(65535, 0, dst, 1, 4);
        });
    }

}
