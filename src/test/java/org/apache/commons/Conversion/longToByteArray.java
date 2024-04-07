import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class longToByteArrayTest {

    @Test
    void testLongToByteArray_ZeroBytes() {
        byte[] dst = new byte[8];
        long src = 123456789;
        int srcPos = 0;
        int dstPos = 0;
        int nBytes = 0;

        byte[] result = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        assertArrayEquals(new byte[8], result);
    }

    @Test
    void testLongToByteArray_AllBytes() {
        byte[] dst = new byte[8];
        long src = 123456789;
        int srcPos = 0;
        int dstPos = 0;
        int nBytes = 8;

        byte[] result = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        byte[] expected = {21, -92, 91, 7, 0, 0, 0, 0};
        assertArrayEquals(expected, result);
    }

    @Test
    void testLongToByteArray_InvalidNBytes() {
        byte[] dst = new byte[8];
        long src = 123456789;
        int srcPos = 0;
        int dstPos = 0;
        int nBytes = 9;

        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);
        });
    }

    @Test
    void testLongToByteArray_InvalidSrcPos() {
        byte[] dst = new byte[8];
        long src = 123456789;
        int srcPos = 64;
        int dstPos = 0;
        int nBytes = 4;

        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);
        });
    }

    @Test
    void testLongToByteArray_InvalidDstPos() {
        byte[] dst = new byte[8];
        long src = 123456789;
        int srcPos = 0;
        int dstPos = 5;
        int nBytes = 4;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);
        });
    }

    @Test
    void testLongToByteArray_SingleByte() {
        byte[] dst = new byte[8];
        long src = 123456789;
        int srcPos = 8;
        int dstPos = 0;
        int nBytes = 1;

        byte[] result = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        byte[] expected = {0, 0, 0, 0, 0, 0, 0, 21};
        assertArrayEquals(expected, result);
    }

    @Test
    void testLongToByteArray_LargeSrc() {
        byte[] dst = new byte[8];
        long src = 987654321012345678L;
        int srcPos = 0;
        int dstPos = 0;
        int nBytes = 8;

        byte[] result = Conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        byte[] expected = {10, 120, -100, -34, -84, -39, -39, 82};
        assertArrayEquals(expected, result);
    }
}