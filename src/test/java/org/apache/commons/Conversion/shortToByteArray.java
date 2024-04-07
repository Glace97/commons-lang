import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class shortToByteArrayTest {

    Conversion conversion = new Conversion();
    byte[] dst = new byte[4];

    @Test
    void testShortToByteArray_ZeroBytes() {
        assertArrayEquals(dst, conversion.shortToByteArray((short) 10, 0, dst, 0, 0));
    }

    @Test
    void testShortToByteArray_PositiveCase() {
        byte[] expected = { 0x0A, 0x00, 0x00, 0x00 };
        assertArrayEquals(expected, conversion.shortToByteArray((short) 10, 0, dst, 0, 4));
    }

    @Test
    void testShortToByteArray_InvalidNBytes() {
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.shortToByteArray((short) 10, 0, dst, 0, 5);
        });
    }

    @Test
    void testShortToByteArray_NBytesGreaterThanSrcPos() {
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.shortToByteArray((short) 10, 8, dst, 0, 2);
        });
    }

    @Test
    void testShortToByteArray_NullDestinationArray() {
        assertThrows(NullPointerException.class, () -> {
            conversion.shortToByteArray((short) 10, 0, null, 0, 2);
        });
    }

    @Test
    void testShortToByteArray_ArrayIndexOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.shortToByteArray((short) 10, 0, dst, 2, 3);
        });
    }

    @ParameterizedTest
    @CsvSource({ "10, 0, 0, 0, 4", "20, 8, 1, 2, 3", "30, 4, 2, 1, 2" })
    void testShortToByteArray_Parameterized(short src, int srcPos, int dstPos, int nBytes, int expectedLength) {
        byte[] result = conversion.shortToByteArray(src, srcPos, dst, dstPos, nBytes);
        assertEquals(expectedLength, result.length);
    }
}