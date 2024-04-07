
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class isNotInTest {

    @Test
    void testIsNotInWithInRange() {
        CharRange charRange = CharRange.isNotIn('a', 'e');
        assertFalse(charRange.negated);
        assertEquals('a', charRange.start);
        assertEquals('e', charRange.end);
    }

    @Test
    void testIsNotInWithReversedRange() {
        CharRange charRange = CharRange.isNotIn('e', 'a');
        assertFalse(charRange.negated);
        assertEquals('a', charRange.start);
        assertEquals('e', charRange.end);
    }

    @Test
    void testIsNotInWithNegatedRange() {
        CharRange charRange = CharRange.isNotIn('a', 'e');
        assertTrue(charRange.negated);
        assertEquals('a', charRange.start);
        assertEquals('e', charRange.end);
    }

    @Test
    void testIsNotInWithSingleCharacterRange() {
        CharRange charRange = CharRange.isNotIn('a', 'a');
        assertFalse(charRange.negated);
        assertEquals('a', charRange.start);
        assertEquals('a', charRange.end);
    }

    @Test
    void testIsNotInWithEmptyRange() {
        CharRange charRange = CharRange.isNotIn(Character.MAX_VALUE, Character.MAX_VALUE);
        assertFalse(charRange.negated);
        assertEquals(Character.MAX_VALUE, charRange.start);
        assertEquals(Character.MAX_VALUE, charRange.end);
    }

    @Test
    void testIsNotInWithNegatedEmptyRange() {
        CharRange charRange = CharRange.isNotIn(0, Character.MAX_VALUE);
        assertTrue(charRange.negated);
        assertEquals(0, charRange.start);
        assertEquals(Character.MAX_VALUE, charRange.end);
    }
}
