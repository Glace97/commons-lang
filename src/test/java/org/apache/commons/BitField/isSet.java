import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isSetTest {

    @Test
    void testIsSetReturnsTrueWhenBitIsSet() {
        BitField bitField = new BitField(1);
        assertTrue(bitField.isSet(1));
    }

    @Test
    void testIsSetReturnsFalseWhenBitIsNotSet() {
        BitField bitField = new BitField(1);
        assertFalse(bitField.isSet(0));
    }
    
    @Test
    void testIsSetReturnsTrueForMultiBitFieldWhenAnyBitIsSet() {
        BitField bitField = new BitField(3);
        assertTrue(bitField.isSet(1));
        assertTrue(bitField.isSet(2));
        assertTrue(bitField.isSet(3));
    }
    
    @Test
    void testIsSetReturnsFalseForMultiBitFieldWhenNoBitIsSet() {
        BitField bitField = new BitField(3);
        assertFalse(bitField.isSet(0));
    }
    
    @Test
    void testIsSetReturnsFalseForZeroMask() {
        BitField bitField = new BitField(0);
        assertFalse(bitField.isSet(1));
        assertFalse(bitField.isSet(0));
    }
    
    @Test
    void testIsSetReturnsTrueForNegativeHolder() {
        BitField bitField = new BitField(1);
        assertTrue(bitField.isSet(-1));
    }
    
    @Test
    void testIsSetReturnsFalseForNegativeHolder() {
        BitField bitField = new BitField(1);
        assertFalse(bitField.isSet(-2));
    }
}