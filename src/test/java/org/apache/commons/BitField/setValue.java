import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setValueTest {

    @Test
    void testSetValue() {
        // Test case 1: mask = 0
        BitField bitField1 = new BitField(0);
        int result1 = bitField1.setValue(0, 5);
        assertEquals(5, result1);

        // Test case 2: mask = 1
        BitField bitField2 = new BitField(1);
        int result2 = bitField2.setValue(0, 1);
        assertEquals(1, result2);

        // Test case 3: mask = 2
        BitField bitField3 = new BitField(2);
        int result3 = bitField3.setValue(0, 3);
        assertEquals(2, result3);

        // Test case 4: mask = 3
        BitField bitField4 = new BitField(3);
        int result4 = bitField4.setValue(0, 7);
        assertEquals(7, result4);

        // Test case 5: mask = 4
        BitField bitField5 = new BitField(4);
        int result5 = bitField5.setValue(0, 10);
        assertEquals(8, result5);

        // Test case 6: mask = 5
        BitField bitField6 = new BitField(5);
        int result6 = bitField6.setValue(0, 15);
        assertEquals(9, result6);

        // Test case 7: mask = 6
        BitField bitField7 = new BitField(6);
        int result7 = bitField7.setValue(0, 20);
        assertEquals(16, result7);

        // Test case 8: mask = 7
        BitField bitField8 = new BitField(7);
        int result8 = bitField8.setValue(0, 31);
        assertEquals(23, result8);
    }
}