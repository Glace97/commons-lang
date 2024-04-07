
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class shortArrayToLongTest {

    @Test
    void testShortArrayToLong_withEmptyArrayAndZeroLength_shouldReturnDstInit() {
        short[] src = {};
        int srcPos = 0;
        long dstInit = 12345L;
        int dstPos = 0;
        int nShorts = 0;

        long result = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(dstInit, result);
    }

    @Test
    void testShortArrayToLong_withEmptyArrayAndNonZeroLength_shouldThrowException() {
        short[] src = {};
        int srcPos = 0;
        long dstInit = 12345L;
        int dstPos = 0;
        int nShorts = 1;

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts));
    }

    @Test
    void testShortArrayToLong_withValidInput_shouldReturnExpectedResult() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nShorts = 4;

        long result = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(0x0000000100020003L, result);
    }

    @Test
    void testShortArrayToLong_withInvalidDstPos_shouldThrowException() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 48;
        int nShorts = 2;

        assertThrows(IllegalArgumentException.class, () ->
                Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts));
    }

    @Test
    void testShortArrayToLong_withInvalidLength_shouldThrowException() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nShorts = 3;

        assertThrows(IllegalArgumentException.class, () ->
                Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts));
    }

    @Test
    void testShortArrayToLong_withValidInputAndNonZeroDstInit_shouldReturnExpectedResult() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0x8000000000000000L;
        int dstPos = 0;
        int nShorts = 4;

        long result = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(0x8000000100020003L, result);
    }

}
