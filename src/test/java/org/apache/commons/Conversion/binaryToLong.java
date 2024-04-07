import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class binaryToLongTest {

    @Test
    void testBinaryToLong_emptySrcAndSrcPosZero() {
        boolean[] src = {};
        int srcPos = 0;
        long dstInit = 10L;
        int dstPos = 0;
        int nBools = 0;

        long result = Conversion.binaryToLong(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(dstInit, result);
    }

    @Test
    void testBinaryToLong_emptySrcAndSrcPosNonZero() {
        boolean[] src = {};
        int srcPos = 2;
        long dstInit = 10L;
        int dstPos = 0;
        int nBools = 0;

        long result = Conversion.binaryToLong(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(dstInit, result);
    }

    @Test
    void testBinaryToLong_nBoolsZero() {
        boolean[] src = {true, true, true, true};
        int srcPos = 0;
        long dstInit = 10L;
        int dstPos = 0;
        int nBools = 0;

        long result = Conversion.binaryToLong(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(dstInit, result);
    }

    @Test
    void testBinaryToLong_nBoolsGreaterThan64() {
        boolean[] src = {true, true, true, true};
        int srcPos = 0;
        long dstInit = 10L;
        int dstPos = 0;
        int nBools = 65;

        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToLong(src, srcPos, dstInit, dstPos, nBools);
        });
    }

    @Test
    void testBinaryToLong_singleBit() {
        boolean[] src = {true, false, false, false};
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = 0;
        int nBools = 1;

        long result = Conversion.binaryToLong(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(1L, result);
    }

    @Test
    void testBinaryToLong_multipleBits() {
        boolean[] src = {true, false, false, true};
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = 0;
        int nBools = 4;

        long result = Conversion.binaryToLong(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(9L, result);
    }
}