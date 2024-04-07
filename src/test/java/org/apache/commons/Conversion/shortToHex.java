import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class shortToHexTest {

    @Test
    void testShortToHex_WithValidInput_ReturnsExpectedResult() {
        String expected = "0x1234";
        String actual = Conversion.shortToHex((short) 4660, 0, "0x0000", 2, 4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testShortToHex_WithZeroNHexs_ReturnsDstInit() {
        String expected = "0x0000";
        String actual = Conversion.shortToHex((short) 4660, 0, "0x0000", 2, 0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testShortToHex_WithInvalidNHexs_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.shortToHex((short) 4660, 0, "0x0000", 2, 5);
        });
    }

    @Test
    void testShortToHex_WithInvalidDstPos_ThrowsStringIndexOutOfBoundsException() {
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Conversion.shortToHex((short) 4660, 0, "0x0000", 10, 4);
        });
    }

    @Test
    void testShortToHex_WithSrcPosEqualToDstPos_ReturnsExpectedResult() {
        String expected = "0x1234";
        String actual = Conversion.shortToHex((short) 4660, 2, "0x0000", 2, 4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testShortToHex_WithNegativeSrcPos_ReturnsExpectedResult() {
        String expected = "0x1234";
        String actual = Conversion.shortToHex((short) 4660, -2, "0x0000", 2, 4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testShortToHex_WithNegativeDstPos_ReturnsExpectedResult() {
        String expected = "0x1234";
        String actual = Conversion.shortToHex((short) 4660, 0, "0x0000", -2, 4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testShortToHex_WithMaxNHexs_ReturnsExpectedResult() {
        String expected = "0x0000";
        String actual = Conversion.shortToHex((short) 4660, 0, "0x0000", 0, 4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testShortToHex_WithEmptyDstInit_ReturnsExpectedResult() {
        String expected = "0x1234";
        String actual = Conversion.shortToHex((short) 4660, 0, "", 0, 4);
        Assertions.assertEquals(expected, actual);
    }
}