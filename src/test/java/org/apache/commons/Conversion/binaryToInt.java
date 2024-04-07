import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class binaryToIntTest {

    @Test
    void testEmptyBinary() {
        boolean[] emptyBinary = {};
        int result = Conversion.binaryToInt(emptyBinary, 0, 0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    void testZeroBools() {
        boolean[] binary = {true, true, true, true};
        int result = Conversion.binaryToInt(binary, 0, 0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    void testInvalidPosition() {
        boolean[] binary = {true, true, true, true};
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToInt(binary, 0, 0, 32, 4);
        });
    }

    @Test
    void testOutOfRange() {
        boolean[] binary = {true, true, true, true};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.binaryToInt(binary, 0, 0, 0, 5);
        });
    }

    @Test
    void testFullBinary() {
        boolean[] binary = {true, true, true, true};
        int result = Conversion.binaryToInt(binary, 0, 0, 0, 4);
        assertEquals(15, result);
    }

    @Test
    void testPartialBinary() {
        boolean[] binary = {true, true, true, true};
        int result = Conversion.binaryToInt(binary, 1, 0, 0, 3);
        assertEquals(7, result);
    }

    @Test
    void testDifferentInitialValue() {
        boolean[] binary = {true, true, true, true};
        int result = Conversion.binaryToInt(binary, 0, 10, 0, 4);
        assertEquals(25, result);
    }

    @Test
    void testDifferentBitPosition() {
        boolean[] binary = {true, true, true, true};
        int result = Conversion.binaryToInt(binary, 0, 0, 2, 4);
        assertEquals(60, result);
    }
}