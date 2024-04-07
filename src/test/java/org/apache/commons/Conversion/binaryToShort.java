
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class binaryToShortTest {

    private Conversion conversion;

    @BeforeAll
    void setUp() {
        conversion = new Conversion();
    }

    @Test
    void testBinaryToShort_ZeroLengthSrc_ReturnsDstInit() {
        boolean[] src = {};
        int srcPos = 0;
        short dstInit = 123;
        int dstPos = 0;
        int nBools = 0;

        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(dstInit, result);
    }

    @Test
    void testBinaryToShort_ZeroNBools_ReturnsDstInit() {
        boolean[] src = {true, false, true};
        int srcPos = 0;
        short dstInit = 123;
        int dstPos = 0;
        int nBools = 0;

        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(dstInit, result);
    }

    @Test
    void testBinaryToShort_InvalidDstPos_ThrowsIllegalArgumentException() {
        boolean[] src = {true, false, true};
        int srcPos = 0;
        short dstInit = 123;
        int dstPos = 14;
        int nBools = 2;

        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
        });
    }

    @Test
    void testBinaryToShort_InvalidSrcPos_ThrowsArrayIndexOutOfBoundsException() {
        boolean[] src = {true, false, true};
        int srcPos = 2;
        short dstInit = 123;
        int dstPos = 0;
        int nBools = 2;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
        });
    }

    @Test
    void testBinaryToShort_ConvertsBinaryToShort() {
        boolean[] src = {true, false, true, false};
        int srcPos = 1;
        short dstInit = 0;
        int dstPos = 1;
        int nBools = 2;

        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(6, result);
    }
}
