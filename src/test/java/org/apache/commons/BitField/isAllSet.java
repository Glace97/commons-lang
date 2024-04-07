import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class isAllSetTest {
    private BitField bitField;
    
    @BeforeEach
    void setUp() {
        bitField = new BitField(0b1111); // Change the mask value according to your needs
    }
    
    @Test
    void testIsAllSet_ReturnsTrue_WhenAllBitsSet() {
        assertTrue(bitField.isAllSet(0b1111));
    }
    
    @Test
    void testIsAllSet_ReturnsFalse_WhenNotAllBitsSet() {
        assertFalse(bitField.isAllSet(0b1100));
    }
    
    @Test
    void testIsAllSet_ReturnsFalse_WhenNoBitsSet() {
        assertFalse(bitField.isAllSet(0b0000));
    }
    
    // Additional test cases to cover edge cases and achieve high coverage
    
    @Test
    void testIsAllSet_ReturnsTrue_WhenMaskIsZero() {
        bitField = new BitField(0); // Change the mask value according to your needs
        assertTrue(bitField.isAllSet(0));
    }
    
    @Test
    void testIsAllSet_ReturnsTrue_WhenMaskIsNegative() {
        bitField = new BitField(-1); // Change the mask value according to your needs
        assertTrue(bitField.isAllSet(-1));
    }
    
    @Test
    void testIsAllSet_ReturnsFalse_WhenHolderIsZero() {
        assertFalse(bitField.isAllSet(0));
    }
    
    @Test
    void testIsAllSet_ReturnsFalse_WhenHolderIsNegative() {
        assertFalse(bitField.isAllSet(-1));
    }
    
    @Test
    void testIsAllSet_ReturnsFalse_WhenMaskDoesNotCoverAllBits() {
        bitField = new BitField(0b1100); // Change the mask value according to your needs
        assertFalse(bitField.isAllSet(0b1111));
    }
}