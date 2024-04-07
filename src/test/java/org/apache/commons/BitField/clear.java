import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClearTest {

    private BitField bitField;

    @Test
    void testClearWithZeroMask() {
        bitField = new BitField(0);
        int holder = 0b10101010;
        int result = bitField.clear(holder);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testClearWithNonZeroMask() {
        bitField = new BitField(0b1111);
        int holder = 0b10101010;
        int result = bitField.clear(holder);
        Assertions.assertEquals(0b10100000, result);
    }

    @Test
    void testClearWithAllOnesMask() {
        bitField = new BitField(0xFFFFFFFF);
        int holder = 0b10101010;
        int result = bitField.clear(holder);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testClearWithNegativeHolderValue() {
        bitField = new BitField(0b1111);
        int holder = -42;
        int result = bitField.clear(holder);
        Assertions.assertEquals(-48, result);
    }
}