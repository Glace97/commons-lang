
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEqualsWithSameObject() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        assertTrue(format.equals(format));
    }
    
    @Test
    void testEqualsWithNullObject() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        assertFalse(format.equals(null));
    }
    
    @Test
    void testEqualsWithDifferentClass() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        assertFalse(format.equals("pattern"));
    }
    
    @Test
    void testEqualsWithDifferentPattern() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern1");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern2");
        assertFalse(format1.equals(format2));
    }
    
    @Test
    void testEqualsWithDifferentRegistry() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern", null);
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern", Map.of());
        assertFalse(format1.equals(format2));
    }
    
    @Test
    void testEqualsWithSamePatternAndRegistry() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern", Map.of());
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern", Map.of());
        assertTrue(format1.equals(format2));
    }
    
}
