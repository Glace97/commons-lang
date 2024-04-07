import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("CharRange hashCode Test")
class hashCodeTest {

    @Nested
    @DisplayName("Positive Cases")
    class PositiveCases {
        
        @Test
        @DisplayName("Same CharRanges should have the same hashCode")
        void testSameCharRanges() {
            CharRange range1 = new CharRange('a', 'z', false);
            CharRange range2 = new CharRange('a', 'z', false);
            
            assertEquals(range1.hashCode(), range2.hashCode());
        }

        @Test
        @DisplayName("CharRanges with different start should have different hashCodes")
        void testDifferentStart() {
            CharRange range1 = new CharRange('a', 'z', false);
            CharRange range2 = new CharRange('b', 'z', false);
            
            assertNotEquals(range1.hashCode(), range2.hashCode());
        }

        @Test
        @DisplayName("CharRanges with different end should have different hashCodes")
        void testDifferentEnd() {
            CharRange range1 = new CharRange('a', 'z', false);
            CharRange range2 = new CharRange('a', 'y', false);
            
            assertNotEquals(range1.hashCode(), range2.hashCode());
        }

        @Test
        @DisplayName("CharRanges with different negated should have different hashCodes")
        void testDifferentNegated() {
            CharRange range1 = new CharRange('a', 'z', false);
            CharRange range2 = new CharRange('a', 'z', true);
            
            assertNotEquals(range1.hashCode(), range2.hashCode());
        }
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCases {
        
        @Test
        @DisplayName("Empty CharRange should have a specific hashCode")
        void testEmptyCharRange() {
            CharRange range = new CharRange('a', 'a', false);
            
            assertEquals(84, range.hashCode());
        }

        @Test
        @DisplayName("CharRange with start as 0 should have a specific hashCode")
        void testCharRangeWithStartAsZero() {
            CharRange range = new CharRange((char) 0, 'z', false);
            
            assertEquals(7 * 'z' + 1, range.hashCode());
        }

        @Test
        @DisplayName("CharRange with end as Character.MAX_VALUE should have a specific hashCode")
        void testCharRangeWithEndAsMaxValue() {
            CharRange range = new CharRange('a', Character.MAX_VALUE, false);
            
            assertEquals('a' + 7 * Character.MAX_VALUE, range.hashCode());
        }

        @Test
        @DisplayName("CharRange with negated as true should have a specific hashCode")
        void testCharRangeWithNegatedTrue() {
            CharRange range = new CharRange('a', 'z', true);
            
            assertEquals(83 + 'a' + 7 * 'z' + 1, range.hashCode());
        }
    }
}