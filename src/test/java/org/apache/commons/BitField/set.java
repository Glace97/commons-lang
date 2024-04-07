import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class setTest {

    @Test
    void testSet() {
        // Test with mask = 0
        BitField bitField1 = new BitField(0);
        int result1 = bitField1.set(10);
        assertEquals(10, result1);

        // Test with mask = 1
        BitField bitField2 = new BitField(1);
        int result2 = bitField2.set(10);
        assertEquals(11, result2);

        // Test with mask = 2
        BitField bitField3 = new BitField(2);
        int result3 = bitField3.set(10);
        assertEquals(10, result3);

        // Test with mask = 3
        BitField bitField4 = new BitField(3);
        int result4 = bitField4.set(10);
        assertEquals(11, result4);

        // Test with mask = 15
        BitField bitField5 = new BitField(15);
        int result5 = bitField5.set(10);
        assertEquals(15, result5);

        // Test with mask = -1
        BitField bitField6 = new BitField(-1);
        int result6 = bitField6.set(10);
        assertEquals(-1, result6);
        
        // Test with mask = Integer.MAX_VALUE
        BitField bitField7 = new BitField(Integer.MAX_VALUE);
        int result7 = bitField7.set(10);
        assertEquals(Integer.MAX_VALUE, result7);
    }
}