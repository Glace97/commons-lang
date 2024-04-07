
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEquals_WithEqualObjects_ReturnsTrue() {
        CharRange range1 = new CharRange('a', 'z', false);
        CharRange range2 = new CharRange('a', 'z', false);
        assertTrue(range1.equals(range2));
    }

    @Test
    void testEquals_WithDifferentStart_ReturnsFalse() {
        CharRange range1 = new CharRange('a', 'z', false);
        CharRange range2 = new CharRange('A', 'z', false);
        assertFalse(range1.equals(range2));
    }

    @Test
    void testEquals_WithDifferentEnd_ReturnsFalse() {
        CharRange range1 = new CharRange('a', 'z', false);
        CharRange range2 = new CharRange('a', 'Z', false);
        assertFalse(range1.equals(range2));
    }

    @Test
    void testEquals_WithDifferentNegated_ReturnsFalse() {
        CharRange range1 = new CharRange('a', 'z', false);
        CharRange range2 = new CharRange('a', 'z', true);
        assertFalse(range1.equals(range2));
    }

    @Test
    void testEquals_WithDifferentObjectType_ReturnsFalse() {
        CharRange range = new CharRange('a', 'z', false);
        String str = "test";
        assertFalse(range.equals(str));
    }

    @Test
    void testEquals_WithSameObject_ReturnsTrue() {
        CharRange range = new CharRange('a', 'z', false);
        assertTrue(range.equals(range));
    }

    @Test
    void testEquals_WithNullObject_ReturnsFalse() {
        CharRange range = new CharRange('a', 'z', false);
        assertFalse(range.equals(null));
    }
}
