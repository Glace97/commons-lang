
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class setShortBooleanTest {
    private BitField bitField;

    @BeforeAll
    public void setup() {
        // Initialize the BitField instance with a specific mask
        bitField = new BitField(0b1111);
    }

    @Test
    public void testSetShortBoolean_SetFlag() {
        short holder = 0b0000;
        boolean flag = true;

        short result = bitField.setShortBoolean(holder, flag);

        // Verify that the specified bits are set
        Assertions.assertEquals(0b1111, result);
    }

    @Test
    public void testSetShortBoolean_ClearFlag() {
        short holder = 0b1111;
        boolean flag = false;

        short result = bitField.setShortBoolean(holder, flag);

        // Verify that the specified bits are cleared
        Assertions.assertEquals(0b0000, result);
    }

    @Test
    public void testSetShortBoolean_NoMask() {
        // Initialize a BitField instance with a mask of 0
        BitField bitFieldNoMask = new BitField(0b0000);

        short holder = 0b1111;
        boolean flag = true;

        short result = bitFieldNoMask.setShortBoolean(holder, flag);

        // Verify that the result is the same as the original holder value
        Assertions.assertEquals(holder, result);
    }

    @Test
    public void testSetShortBoolean_HighBitMask() {
        // Initialize a BitField instance with a mask having the highest bit set
        BitField bitFieldHighBitMask = new BitField(0b1000000000000000);

        short holder = 0b0000;
        boolean flag = true;

        short result = bitFieldHighBitMask.setShortBoolean(holder, flag);

        // Verify that the highest bit is set
        Assertions.assertEquals(0b1000000000000000, result);
    }

    @Test
    public void testSetShortBoolean_LowBitMask() {
        // Initialize a BitField instance with a mask having the lowest bit set
        BitField bitFieldLowBitMask = new BitField(0b0000000000000001);

        short holder = 0b0000;
        boolean flag = true;

        short result = bitFieldLowBitMask.setShortBoolean(holder, flag);

        // Verify that the lowest bit is set
        Assertions.assertEquals(0b0000000000000001, result);
    }
}
