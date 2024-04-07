import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class clearShortTest {

    @Test
    void testClearShort() {
        BitField bitField1 = new BitField(0b11111111);
        BitField bitField2 = new BitField(0b00000000);
        BitField bitField3 = new BitField(0b00001111);
        BitField bitField4 = new BitField(0b11110000);
        BitField bitField5 = new BitField(0b01010101);

        short holder1 = 0b1111111111111111;
        short holder2 = 0b0000000000000000;
        short holder3 = 0b1111000011110000;
        short holder4 = 0b0101010101010101;
        short holder5 = 0b1010101010101010;

        assertEquals(0b0000000000000000, bitField1.clearShort(holder1));
        assertEquals(0b0000000000000000, bitField2.clearShort(holder2));
        assertEquals(0b0000111100001111, bitField3.clearShort(holder3));
        assertEquals(0b0101000000100000, bitField4.clearShort(holder4));
        assertEquals(0b0000000000000000, bitField5.clearShort(holder5));
    }
}