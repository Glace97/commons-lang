import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GetValueTest {
    private BitField bitField;

    @BeforeEach
    void setUp() {
        bitField = new BitField(0b1111); // Example mask value
    }

    @Test
    void testGetValue_ShouldReturnShiftedValue() {
        int holder = 0b10101010; // Example holder value
        int expectedValue = 0b1010; // Expected shifted value

        int result = bitField.getValue(holder);

        assertEquals(expectedValue, result);
    }

    @Test
    void testGetValue_ShouldReturnZero_WhenHolderIsZero() {
        int holder = 0;

        int result = bitField.getValue(holder);

        assertEquals(0, result);
    }

    @Test
    void testGetValue_ShouldReturnZero_WhenMaskIsZero() {
        BitField zeroMaskBitField = new BitField(0);

        int holder = 0b10101010; // Example holder value

        int result = zeroMaskBitField.getValue(holder);

        assertEquals(0, result);
    }

    // Add more test cases to cover edge cases and achieve high coverage
}