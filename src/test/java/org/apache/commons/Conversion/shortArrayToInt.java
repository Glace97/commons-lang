import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class shortArrayToIntTest {

    @Test
    void testShortArrayToInt_emptySrcArray() {
        short[] src = {};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 0;

        int result = Conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(dstInit, result);
    }

    @Test
    void testShortArrayToInt_zeroNShorts() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 0;

        int result = Conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(dstInit, result);
    }

    @Test
    void testShortArrayToInt_invalidDstPos() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 32;
        int nShorts = 2;

        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);
        });
    }

    @Test
    void testShortArrayToInt_srcPosOutOfRange() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 5;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 2;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);
        });
    }

    @Test
    void testShortArrayToInt_positiveScenario() {
        short[] src = {1, 2, 3, 4};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 2;

        int result = Conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(258, result);
    }
}