import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class setByteTest {

    @Test
    public void testSetByte() {
        // Create a BitField instance with mask = 0
        BitField bitField1 = new BitField(0);
        byte holder1 = 0b00000000;
        byte expected1 = 0b00000000;
        assertEquals(expected1, bitField1.setByte(holder1));

        // Create a BitField instance with mask = 1
        BitField bitField2 = new BitField(1);
        byte holder2 = 0b00000000;
        byte expected2 = 0b00000001;
        assertEquals(expected2, bitField2.setByte(holder2));

        // Create a BitField instance with mask = 2
        BitField bitField3 = new BitField(2);
        byte holder3 = 0b00000000;
        byte expected3 = 0b00000010;
        assertEquals(expected3, bitField3.setByte(holder3));

        // Create a BitField instance with mask = 3
        BitField bitField4 = new BitField(3);
        byte holder4 = 0b00000000;
        byte expected4 = 0b00000011;
        assertEquals(expected4, bitField4.setByte(holder4));

        // Create a BitField instance with mask = 255
        BitField bitField5 = new BitField(255);
        byte holder5 = 0b00000000;
        byte expected5 = 0b11111111;
        assertEquals(expected5, bitField5.setByte(holder5));

        // Create a BitField instance with mask = 128
        BitField bitField6 = new BitField(128);
        byte holder6 = 0b00000000;
        byte expected6 = 0b10000000;
        assertEquals(expected6, bitField6.setByte(holder6));

        // Create a BitField instance with mask = 64
        BitField bitField7 = new BitField(64);
        byte holder7 = 0b00000000;
        byte expected7 = 0b01000000;
        assertEquals(expected7, bitField7.setByte(holder7));

        // Create a BitField instance with mask = 32
        BitField bitField8 = new BitField(32);
        byte holder8 = 0b00000000;
        byte expected8 = 0b00100000;
        assertEquals(expected8, bitField8.setByte(holder8));
    }
}