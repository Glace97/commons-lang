import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class longToShortArrayTest {

    @Test
    void testLongToShortArray() {
        Conversion conversion = new Conversion();

        // Test with empty destination array
        short[] emptyDst = new short[0];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.longToShortArray(123456789, 0, emptyDst, 0, 1);
        });

        // Test with null destination array
        short[] nullDst = null;
        assertThrows(NullPointerException.class, () -> {
            conversion.longToShortArray(987654321, 0, nullDst, 0, 1);
        });

        // Test with negative srcPos
        short[] negativeSrcPosDst = new short[1];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.longToShortArray(123456789, -1, negativeSrcPosDst, 0, 1);
        });

        // Test with invalid nShorts
        short[] invalidNShortsDst = new short[2];
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.longToShortArray(987654321, 0, invalidNShortsDst, 0, 3);
        });

        // Test with nShorts = 0
        short[] zeroNShortsDst = new short[2];
        assertArrayEquals(zeroNShortsDst, conversion.longToShortArray(123456789, 0, zeroNShortsDst, 0, 0));

        // Test with valid parameters
        short[] validDst = new short[2];
        short[] expectedValidDst = {2213, 1};
        assertArrayEquals(expectedValidDst, conversion.longToShortArray(987654321, 0, validDst, 0, 2));
    }

}