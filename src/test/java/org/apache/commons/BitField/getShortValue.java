import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getShortValueTest {
    private BitField bitField;

    @BeforeEach
    void setUp() {
        bitField = new BitField(0b1111);
    }

    @Test
    void testGetShortValue() {
        short holder = 0b1111000000001111;
        short expected = 0b11110000;
        short actual = bitField.getShortValue(holder);
        assertEquals(expected, actual);
    }

    @Test
    void testGetShortValueWithZeroMask() {
        BitField bitFieldWithZeroMask = new BitField(0);
        short holder = 0b1111000000001111;
        short expected = 0;
        short actual = bitFieldWithZeroMask.getShortValue(holder);
        assertEquals(expected, actual);
    }
}