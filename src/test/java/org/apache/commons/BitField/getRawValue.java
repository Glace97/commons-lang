import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class getRawValueTest {

    @Test
    public void testGetRawValue() {
        BitField bitField = new BitField(0b1111); // mask = 15, shiftCount = 0
        
        // Test with holder = 0
        int holder = 0;
        int expected = 0;
        int actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
        
        // Test with holder = 1
        holder = 1;
        expected = 1;
        actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
        
        // Test with holder = 2
        holder = 2;
        expected = 2;
        actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
        
        // Test with holder = 3
        holder = 3;
        expected = 3;
        actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
        
        // Test with holder = 15
        holder = 15;
        expected = 15;
        actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
        
        // Test with holder = 16
        holder = 16;
        expected = 0;
        actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
        
        // Test with holder = 31
        holder = 31;
        expected = 15;
        actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
        
        // Test with holder = -1
        holder = -1;
        expected = 15;
        actual = bitField.getRawValue(holder);
        assertEquals(expected, actual);
    }
}