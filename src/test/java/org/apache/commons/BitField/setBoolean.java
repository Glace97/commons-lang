import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class setBooleanTest {

    @Test
    public void testSetBoolean() {
        BitField bitField = new BitField(0b00000111);
        
        // Test setting the flag to true
        int holder = 0b00000000;
        int expectedResult = 0b00000111;
        int actualResult = bitField.setBoolean(holder, true);
        assertEquals(expectedResult, actualResult);
        
        // Test setting the flag to false
        holder = 0b00000111;
        expectedResult = 0b00000000;
        actualResult = bitField.setBoolean(holder, false);
        assertEquals(expectedResult, actualResult);
        
        // Test setting the flag when the mask is 0
        bitField = new BitField(0);
        holder = 0b11111111;
        expectedResult = 0b11111111;
        actualResult = bitField.setBoolean(holder, true);
        assertEquals(expectedResult, actualResult);
    }
}