import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class compareToTest {
    
    @Test
    void testCompareToLessThan() {
        MutableLong mutable1 = new MutableLong(5);
        MutableLong mutable2 = new MutableLong(10);
        assertTrue(mutable1.compareTo(mutable2) < 0);
    }
    
    @Test
    void testCompareToGreaterThan() {
        MutableLong mutable1 = new MutableLong(15);
        MutableLong mutable2 = new MutableLong(10);
        assertTrue(mutable1.compareTo(mutable2) > 0);
    }
    
    @Test
    void testCompareToEquals() {
        MutableLong mutable1 = new MutableLong(10);
        MutableLong mutable2 = new MutableLong(10);
        assertEquals(0, mutable1.compareTo(mutable2));
    }
    
    @Test
    void testCompareToWithNull() {
        MutableLong mutable1 = new MutableLong(10);
        assertNull(mutable1.compareTo(null));
    }
    
    @Test
    void testCompareToWithNegativeValues() {
        MutableLong mutable1 = new MutableLong(-5);
        MutableLong mutable2 = new MutableLong(-10);
        assertTrue(mutable1.compareTo(mutable2) > 0);
    }
    
    @Test
    void testCompareToWithLargeValues() {
        MutableLong mutable1 = new MutableLong(Long.MAX_VALUE);
        MutableLong mutable2 = new MutableLong(Long.MIN_VALUE);
        assertTrue(mutable1.compareTo(mutable2) > 0);
    }
    
    @Test
    void testCompareToWithEqualValuesButDifferentTypes() {
        MutableLong mutable1 = new MutableLong(10L);
        MutableLong mutable2 = new MutableLong(10);
        assertEquals(0, mutable1.compareTo(mutable2));
    }
    
    @Test
    void testCompareToWithEqualValuesButDifferentObjects() {
        MutableLong mutable1 = new MutableLong(10);
        MutableLong mutable2 = new MutableLong(10);
        assertEquals(0, mutable1.compareTo(mutable2));
        assertEquals(0, mutable2.compareTo(mutable1));
    }
    
    @Test
    void testCompareToWithEqualValuesButDifferentStringRepresentations() {
        MutableLong mutable1 = new MutableLong("10");
        MutableLong mutable2 = new MutableLong("10");
        assertEquals(0, mutable1.compareTo(mutable2));
        assertEquals(0, mutable2.compareTo(mutable1));
    }
    
    @Test
    void testCompareToWithInvalidStringRepresentation() {
        MutableLong mutable1 = new MutableLong("abc");
        assertThrows(NumberFormatException.class, () -> mutable1.compareTo(new MutableLong("def")));
    }
}