import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class equalsTest {
    
    CharSet emptySet = CharSet.EMPTY;
    CharSet asciiAlphaSet = CharSet.ASCII_ALPHA;
    CharSet asciiAlphaLowerSet = CharSet.ASCII_ALPHA_LOWER;
    CharSet asciiAlphaUpperSet = CharSet.ASCII_ALPHA_UPPER;
    CharSet asciiNumericSet = CharSet.ASCII_NUMERIC;
    
    @Test
    void testEquals_WhenSameObject_ShouldReturnTrue() {
        CharSet set1 = new CharSet("a");
        assertTrue(set1.equals(set1));
    }
    
    @Test
    void testEquals_WhenDifferentObjectType_ShouldReturnFalse() {
        CharSet set1 = new CharSet("a");
        assertFalse(set1.equals("a"));
    }
    
    @Test
    void testEquals_WhenDifferentCharSet_ShouldReturnFalse() {
        CharSet set1 = new CharSet("a");
        CharSet set2 = new CharSet("b");
        assertFalse(set1.equals(set2));
    }
    
    @Test
    void testEquals_WhenSameCharSet_ShouldReturnTrue() {
        CharSet set1 = new CharSet("a");
        CharSet set2 = new CharSet("a");
        assertTrue(set1.equals(set2));
    }
    
    @Test
    void testEquals_WhenEmptySet_ShouldReturnTrue() {
        assertTrue(emptySet.equals(emptySet));
    }
    
    @Test
    void testEquals_WhenAsciiAlphaSet_ShouldReturnTrue() {
        assertTrue(asciiAlphaSet.equals(asciiAlphaSet));
    }
    
    @Test
    void testEquals_WhenAsciiAlphaLowerSet_ShouldReturnTrue() {
        assertTrue(asciiAlphaLowerSet.equals(asciiAlphaLowerSet));
    }
    
    @Test
    void testEquals_WhenAsciiAlphaUpperSet_ShouldReturnTrue() {
        assertTrue(asciiAlphaUpperSet.equals(asciiAlphaUpperSet));
    }
    
    @Test
    void testEquals_WhenAsciiNumericSet_ShouldReturnTrue() {
        assertTrue(asciiNumericSet.equals(asciiNumericSet));
    }
    
    @Test
    void testEquals_WhenEqualCharSet_ShouldReturnTrue() {
        CharSet set1 = new CharSet("a", "b");
        CharSet set2 = new CharSet("b", "a");
        assertTrue(set1.equals(set2));
    }
    
    @Test
    void testEquals_WhenDifferentSizeCharSet_ShouldReturnFalse() {
        CharSet set1 = new CharSet("a", "b");
        CharSet set2 = new CharSet("a");
        assertFalse(set1.equals(set2));
    }
    
    @Test
    void testEquals_WhenEqualCharSetButDifferentOrder_ShouldReturnFalse() {
        CharSet set1 = new CharSet("a", "b");
        CharSet set2 = new CharSet("b", "c", "a");
        assertFalse(set1.equals(set2));
    }
    
    @Test
    void testEquals_WhenEqualCharSetButDifferentCase_ShouldReturnFalse() {
        CharSet set1 = new CharSet("a", "b");
        CharSet set2 = new CharSet("A", "B");
        assertFalse(set1.equals(set2));
    }
    
    @Test
    void testEquals_WhenEqualCharSetButDifferentCharRange_ShouldReturnFalse() {
        CharSet set1 = new CharSet("a", "b");
        CharSet set2 = new CharSet("a-z");
        assertFalse(set1.equals(set2));
    }
}