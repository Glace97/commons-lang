package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class CharRangeTest {
    @Test
    @DisplayName("Test hasNext() returns true when there are more characters in the range")
    void testHasNextReturnsTrue() {
        CharRange.CharacterIterator iterator = charRange.iterator();
        assertTrue(iterator.hasNext());
    }
    
    @Test
    @DisplayName("Test hasNext() returns false when there are no more characters in the range")
    void testHasNextReturnsFalse() {
        CharRange.CharacterIterator iterator = charRange.iterator();
        for (int i = 0; i < 5; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }
    
    @Test
    @DisplayName("Test next() returns the next character in the range")
    void testNextReturnsNextCharacter() {
        CharRange.CharacterIterator iterator = charRange.iterator();
        assertEquals('a', iterator.next());
        assertEquals('b', iterator.next());
        assertEquals('c', iterator.next());
        assertEquals('d', iterator.next());
        assertEquals('e', iterator.next());
    }
    
    @Test
    @DisplayName("Test next() throws NoSuchElementException when there are no more characters in the range")
    void testNextThrowsNoSuchElementException() {
        CharRange.CharacterIterator iterator = charRange.iterator();
        for (int i = 0; i < 5; i++) {
            iterator.next();
        }
        assertThrows(NoSuchElementException.class, iterator::next);
    }
    
    @Test
    @DisplayName("Test remove() throws UnsupportedOperationException")
    void testRemoveThrowsUnsupportedOperationException() {
        CharRange.CharacterIterator iterator = charRange.iterator();
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
    
    @Test
    @DisplayName("Test isNot() returns a CharRange object with negated set to true")
    void testIsNotReturnsNegatedCharRange() {
        CharRange negatedCharRange = CharRange.isNot('a');
        assertTrue(negatedCharRange.negated);
    }
    @Test
    void testGetEndInRange() {
        range = new CharRange('a', 'z', false);
        assertEquals('z', range.getEnd());
    }
    
    @Test
    void testGetEndInNegatedRange() {
        range = new CharRange('a', 'z', true);
        assertEquals('z', range.getEnd());
    }
    
    @Test
    void testGetEndWithReversedRange() {
        range = new CharRange('z', 'a', false);
        assertEquals('z', range.getEnd());
    }
    
    @Test
    void testGetEndWithNegatedReversedRange() {
        range = new CharRange('z', 'a', true);
        assertEquals('z', range.getEnd());
    }
    
    @Test
    void testGetEndWithSingleCharacterRange() {
        range = new CharRange('a', 'a', false);
        assertEquals('a', range.getEnd());
    }
    
    @Test
    void testGetEndWithNegatedSingleCharacterRange() {
        range = new CharRange('a', 'a', true);
        assertEquals('a', range.getEnd());
    }
    
    @Test
    void testGetEndWithEmptyRange() {
        range = new CharRange('z', 'a', false);
        assertEquals('a', range.getEnd());
    }
    
    @Test
    void testGetEndWithNegatedEmptyRange() {
        range = new CharRange('z', 'a', true);
        assertEquals('a', range.getEnd());
    }
    
    @Test
    void testGetEndWithSpecialCharacters() {
        range = new CharRange('!', '@', false);
        assertEquals('@', range.getEnd());
    }
    
    @Test
    void testGetEndWithNegatedSpecialCharacters() {
        range = new CharRange('!', '@', true);
        assertEquals('@', range.getEnd());
    }
    @Test
    @DisplayName("should return true if there is a next character")
    void testHasNext() {
        CharRange charRange = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = charRange.new CharacterIterator(charRange);
        Assertions.assertTrue(iterator.hasNext());
    }
    
    @Test
    @DisplayName("should return false if there is no next character")
    void testHasNextFalse() {
        CharRange charRange = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = charRange.new CharacterIterator(charRange);
        Assertions.assertFalse(iterator.hasNext());
    }
    
    @Test
    @DisplayName("should return the next character in the iteration")
    void testNext() {
        CharRange charRange = new CharRange('a', 'c', false);
        CharRange.CharacterIterator iterator = charRange.new CharacterIterator(charRange);
        Assertions.assertEquals('a', iterator.next());
        Assertions.assertEquals('b', iterator.next());
        Assertions.assertEquals('c', iterator.next());
    }
    
    @Test
    @DisplayName("should throw NoSuchElementException if there is no next character")
    void testNextNoSuchElement() {
        CharRange charRange = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = charRange.new CharacterIterator(charRange);
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }
    
    @Test
    @DisplayName("should throw UnsupportedOperationException when remove() is called")
    void testRemove() {
        CharRange charRange = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = charRange.new CharacterIterator(charRange);
        Assertions.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
    
    @Test
    @DisplayName("should construct a CharRange with correct start, end, and negated values")
    void testCharRangeConstructor() {
        CharRange charRange = new CharRange('a', 'z', false);
        Assertions.assertEquals('a', charRange.start);
        Assertions.assertEquals('z', charRange.end);
        Assertions.assertFalse(charRange.negated);
    }
    
    @Test
    @DisplayName("should reverse start and end values if start > end")
    void testCharRangeConstructorReverseValues() {
        CharRange charRange = new CharRange('z', 'a', false);
        Assertions.assertEquals('a', charRange.start);
        Assertions.assertEquals('z', charRange.end);
        Assertions.assertFalse(charRange.negated);
    }
    
    @Test
    @DisplayName("should return the next character in the iteration")
    void testNext() {
        CharRange charRange = new CharRange('a', 'c', false);
        Assertions.assertEquals('a', charRange.next());
        Assertions.assertEquals('b', charRange.next());
        Assertions.assertEquals('c', charRange.next());
    }
    
    @Test
    @DisplayName("should throw NoSuchElementException if there is no next character")
    void testNextNoSuchElement() {
        CharRange charRange = new CharRange('a', 'a', false);
        Assertions.assertThrows(NoSuchElementException.class, charRange::next);
    }
    @Test
    void testCharacterIteratorHasNext() {
        CharRange range = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
    
        range = new CharRange('a', 'a', false);
        iterator = range.iterator();
        assertTrue(iterator.hasNext());
    
        range = new CharRange('a', 'a', true);
        iterator = range.iterator();
        assertFalse(iterator.hasNext());
    }
    
    @Test
    void testCharacterIteratorNext() {
        CharRange range = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = range.iterator();
    
        for (char c = 'a'; c <= 'z'; c++) {
            assertEquals(Character.valueOf(c), iterator.next());
        }
    
        assertThrows(NoSuchElementException.class, iterator::next);
    }
    
    @Test
    void testCharacterIteratorRemove() {
        CharRange range = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = range.iterator();
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
    
    @Test
    void testCharRangeConstructor() {
        CharRange range = new CharRange('a', 'z', false);
        assertEquals('a', range.start);
        assertEquals('z', range.end);
        assertFalse(range.negated);
    
        range = new CharRange('z', 'a', false);
        assertEquals('a', range.start);
        assertEquals('z', range.end);
        assertFalse(range.negated);
    
        range = new CharRange('a', 'a', true);
        assertEquals('a', range.start);
        assertEquals('a', range.end);
        assertTrue(range.negated);
    }
    
    @Test
    void testCharRangeToString() {
        CharRange range = new CharRange('a', 'z', false);
        assertEquals("CharRange['a'..'z']", range.toString());
    
        range = new CharRange('a', 'a', false);
        assertEquals("CharRange['a']", range.toString());
    
        range = new CharRange('a', 'a', true);
        assertEquals("CharRange[^'a']", range.toString());
    }
    @Test
    @DisplayName("Should return the same hashCode for equal CharRange objects")
    void shouldReturnSameHashCodeForEqualObjects() {
        CharRange equalCharRange = new CharRange('a', 'z', false);
        assertEquals(charRange.hashCode(), equalCharRange.hashCode());
    }
    
    @Test
    @DisplayName("Should return different hashCode for different start character")
    void shouldReturnDifferentHashCodeForDifferentStartCharacter() {
        CharRange differentCharRange = new CharRange('b', 'z', false);
        assertNotEquals(charRange.hashCode(), differentCharRange.hashCode());
    }
    
    @Test
    @DisplayName("Should return different hashCode for different end character")
    void shouldReturnDifferentHashCodeForDifferentEndCharacter() {
        CharRange differentCharRange = new CharRange('a', 'y', false);
        assertNotEquals(charRange.hashCode(), differentCharRange.hashCode());
    }
    
    @Test
    @DisplayName("Should return different hashCode for negated CharRange")
    void shouldReturnDifferentHashCodeForNegatedCharRange() {
        CharRange negatedCharRange = new CharRange('a', 'z', true);
        assertNotEquals(charRange.hashCode(), negatedCharRange.hashCode());
    }
    // Your Java code here
    
    @Test
    @DisplayName("should construct CharRange with start and end characters equal to ch")
    void testIs_constructor() {
        // Arrange
        char ch = 'a';
    
        // Act
        CharRange range = CharRange.is(ch);
    
        // Assert
        Assertions.assertEquals(ch, range.start);
        Assertions.assertEquals(ch, range.end);
        Assertions.assertFalse(range.negated);
    }
    
    
    @Test
    @DisplayName("should return true if the iterator has yet to reach the character range")
    void testHasNext() {
        // Arrange
        CharRange range = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);
    
        // Act & Assert
        Assertions.assertTrue(iterator.hasNext());
    }
    
    @Test
    @DisplayName("should return false if the iterator has reached the end character")
    void testHasNext_reachedEnd() {
        // Arrange
        CharRange range = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);
    
        // Act & Assert
        Assertions.assertFalse(iterator.hasNext());
    }
    
    @Test
    @DisplayName("should throw NoSuchElementException when calling next() after reaching the end character")
    void testNext_reachedEnd() {
        // Arrange
        CharRange range = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);
    
        // Act & Assert
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }
    
    @Test
    @DisplayName("should return the next character in the iteration")
    void testNext() {
        // Arrange
        CharRange range = new CharRange('a', 'c', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);
    
        // Act & Assert
        Assertions.assertEquals('a', iterator.next());
        Assertions.assertEquals('b', iterator.next());
        Assertions.assertEquals('c', iterator.next());
    }
    
    @Test
    @DisplayName("should throw UnsupportedOperationException when calling remove()")
    void testRemove() {
        // Arrange
        CharRange range = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);
    
        // Act & Assert
        Assertions.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
    import org.junit.jupiter.api.Test;
    
    class CharRangeTest {
    
        @Test
        void hasNextReturnsFalseForEmptyRange() {
            CharRange range = new CharRange('a', 'a', false);
            CharRange.CharacterIterator iterator = range.iterator();
            assertFalse(iterator.hasNext());
        }
    
        @Test
        void hasNextReturnsTrueForNonEmptyRange() {
            CharRange range = new CharRange('a', 'b', false);
            CharRange.CharacterIterator iterator = range.iterator();
            assertTrue(iterator.hasNext());
        }
    
        @Test
        void hasNextReturnsFalseAtEndOfRange() {
            CharRange range = new CharRange('a', 'b', false);
            CharRange.CharacterIterator iterator = range.iterator();
            iterator.next();
            assertTrue(iterator.hasNext());
            iterator.next();
            assertFalse(iterator.hasNext());
        }
    
        @Test
        void nextReturnsCorrectCharacters() {
            CharRange range = new CharRange('a', 'c', false);
            CharRange.CharacterIterator iterator = range.iterator();
            assertEquals('a', iterator.next());
            assertEquals('b', iterator.next());
            assertEquals('c', iterator.next());
        }
    
        @Test
        void nextThrowsNoSuchElementExceptionAtEndOfRange() {
            CharRange range = new CharRange('a', 'a', false);
            CharRange.CharacterIterator iterator = range.iterator();
            iterator.next();
            assertThrows(NoSuchElementException.class, iterator::next);
        }
    
        @Test
        void removeThrowsUnsupportedOperationException() {
            CharRange range = new CharRange('a', 'a', false);
            CharRange.CharacterIterator iterator = range.iterator();
            assertThrows(UnsupportedOperationException.class, iterator::remove);
        }
    }
    @Test
    void contains_singleCharacterInRange_returnTrue() {}
    
    @Test
    void contains_singleCharacterNotInRange_returnFalse() {}
    
    @Test
    void contains_singleCharacterInNegatedRange_returnFalse() {}
    
    @Test
    void contains_singleCharacterNotInNegatedRange_returnTrue() {}
    
    @Test
    void contains_rangeContainedInRange_returnTrue() {}
    
    @Test
    void contains_rangeNotContainedInRange_returnFalse() {}
    
    @Test
    void contains_rangeContainedInNegatedRange_returnFalse() {}
    
    @Test
    void contains_rangeNotContainedInNegatedRange_returnTrue() {}
    
    @Test
    void contains_nullRange_throwNullPointerException() {}
    
    @Test
    void contains_rangeWithStartGreaterThanEnd_reorderStartAndEnd() {}
    
    @Test
    void contains_rangeWithStartAndEndEqualToRange_returnTrue() {}
    
    @Test
    void contains_rangeWithStartAndEndEqualToRangeInNegatedRange_returnFalse() {}
    
    @Test
    void contains_rangeWithStartAndEndEqualToRangeInNegatedRange_returnTrue() {}
    @Test
    void testGetStart() {
        assertEquals('A', range.getStart());
    }
    
    @Test
    void testGetStartWithNegatedRange() {
        CharRange negatedRange = new CharRange('A', 'Z', true);
        assertEquals('A', negatedRange.getStart());
    }
    
    @Test
    void testGetStartWithReversedRange() {
        CharRange reversedRange = new CharRange('Z', 'A', false);
        assertEquals('A', reversedRange.getStart());
    }
    
    @Test
    void testGetStartWithSingleCharacterRange() {
        CharRange singleCharacterRange = new CharRange('A', 'A', false);
        assertEquals('A', singleCharacterRange.getStart());
    }
    
    @Test
    void testGetStartWithEmptyRange() {
        CharRange emptyRange = new CharRange('Z', 'A', false);
        assertEquals('A', emptyRange.getStart());
    }
    
    @Test
    void testGetStartWithMaxValueRange() {
        CharRange maxValueRange = new CharRange(Character.MAX_VALUE, Character.MAX_VALUE, false);
        assertEquals(Character.MAX_VALUE, maxValueRange.getStart());
    }
    @Test
    void testEquals_SameObject_ReturnsTrue() {
        assertTrue(range1.equals(range1));
    }
    
    @Test
    void testEquals_NullObject_ReturnsFalse() {
        assertFalse(range1.equals(null));
    }
    
    @Test
    void testEquals_DifferentType_ReturnsFalse() {
        assertFalse(range1.equals("a-e"));
    }
    
    @Test
    void testEquals_SameRange_ReturnsTrue() {
        assertTrue(range1.equals(range4));
    }
    
    @Test
    void testEquals_SameRangeDifferentNegated_ReturnsFalse() {
        assertFalse(range1.equals(range3));
    }
    
    @Test
    void testEquals_DifferentRange_ReturnsFalse() {
        assertFalse(range1.equals(range2));
    }
    
    @Test
    void testEquals_DifferentRangeDifferentNegated_ReturnsFalse() {
        assertFalse(range1.equals(range5));
    }
    @Test
    void testIterator_EmptyRange() {
        charRange = new CharRange('a', 'a', false);
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_SingleCharacterRange() {
        charRange = new CharRange('a', 'a', false);
        assertTrue(charRange.iterator().hasNext());
        assertEquals('a', charRange.iterator().next());
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_NegatedSingleCharacterRange() {
        charRange = new CharRange('a', 'a', true);
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_SingleCharacterNegatedRange() {
        charRange = new CharRange('a', 'z', true);
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_SingleCharacterRangeWithNegatedFlag() {
        charRange = new CharRange('a', 'a', true);
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_SingleCharacterNegatedRangeWithNegatedFlag() {
        charRange = new CharRange('a', 'z', true);
        assertTrue(charRange.iterator().hasNext());
        assertEquals('a', charRange.iterator().next());
        assertTrue(charRange.iterator().hasNext());
        assertEquals('z', charRange.iterator().next());
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_RangeWithMultipleCharacters() {
        charRange = new CharRange('a', 'z', false);
        assertTrue(charRange.iterator().hasNext());
        assertEquals('a', charRange.iterator().next());
        assertTrue(charRange.iterator().hasNext());
        assertEquals('b', charRange.iterator().next());
        assertTrue(charRange.iterator().hasNext());
        assertEquals('z', charRange.iterator().next());
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_NegatedRangeWithMultipleCharacters() {
        charRange = new CharRange('a', 'z', true);
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_RangeWithMultipleCharactersWithNegatedFlag() {
        charRange = new CharRange('a', 'z', false);
        assertTrue(charRange.iterator().hasNext());
        assertEquals('a', charRange.iterator().next());
        assertTrue(charRange.iterator().hasNext());
        assertEquals('b', charRange.iterator().next());
        assertTrue(charRange.iterator().hasNext());
        assertEquals('z', charRange.iterator().next());
        assertFalse(charRange.iterator().hasNext());
    }
    
    @Test
    void testIterator_NegatedRangeWithMultipleCharactersWithNegatedFlag() {
        charRange = new CharRange('a', 'z', true);
        assertTrue(charRange.iterator().hasNext());
        assertEquals('a', charRange.iterator().next());
        assertTrue(charRange.iterator().hasNext());
        assertEquals('z', charRange.iterator().next());
        assertFalse(charRange.iterator().hasNext());
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    import java.util.NoSuchElementException;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class CharRangeTestSuite {
    
        private CharRange charRange;
    
        @Test
        void testIsNegated() {
            charRange = new CharRange('a', 'e', false);
            assertFalse(charRange.isNegated());
    
            charRange = new CharRange('e', 'a', false);
            assertFalse(charRange.isNegated());
    
            charRange = new CharRange('a', 'e', true);
            assertTrue(charRange.isNegated());
    
            charRange = new CharRange('e', 'a', true);
            assertTrue(charRange.isNegated());
        }
    
        @Test
        void testCharacterIterator() {
            charRange = new CharRange('a', 'e', false);
            CharRange.CharacterIterator iterator = charRange.new CharacterIterator(charRange);
            assertTrue(iterator.hasNext());
            assertEquals('a', iterator.next());
            assertEquals('b', iterator.next());
            assertEquals('c', iterator.next());
            assertEquals('d', iterator.next());
            assertEquals('e', iterator.next());
            assertFalse(iterator.hasNext());
    
            charRange = new CharRange('e', 'a', false);
            iterator = charRange.new CharacterIterator(charRange);
            assertTrue(iterator.hasNext());
            assertEquals('a', iterator.next());
            assertEquals('b', iterator.next());
            assertEquals('c', iterator.next());
            assertEquals('d', iterator.next());
            assertEquals('e', iterator.next());
            assertFalse(iterator.hasNext());
    
            charRange = new CharRange('a', 'e', true);
            iterator = charRange.new CharacterIterator(charRange);
            assertTrue(iterator.hasNext());
            assertEquals('f', iterator.next());
            assertEquals('g', iterator.next());
            assertEquals('h', iterator.next());
            assertEquals('i', iterator.next());
            assertEquals('j', iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(Character.MAX_VALUE, iterator.next());
            assertFalse(iterator.hasNext());
    
            charRange = new CharRange('e', 'a', true);
            iterator = charRange.new CharacterIterator(charRange);
            assertTrue(iterator.hasNext());
            assertEquals('f', iterator.next());
            assertEquals('g', iterator.next());
            assertEquals('h', iterator.next());
            assertEquals('i', iterator.next());
            assertEquals('j', iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(Character.MAX_VALUE, iterator.next());
            assertFalse(iterator.hasNext());
        }
    
        @Test
        void testCharacterIteratorEmptyRange() {
            charRange = new CharRange('e', 'e', false);
            CharRange.CharacterIterator iterator = charRange.new CharacterIterator(charRange);
            assertFalse(iterator.hasNext());
            assertThrows(NoSuchElementException.class, iterator::next);
    
            charRange = new CharRange('e', 'e', true);
            iterator = charRange.new CharacterIterator(charRange);
            assertTrue(iterator.hasNext());
            assertEquals(Character.MIN_VALUE, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(Character.MAX_VALUE, iterator.next());
            assertFalse(iterator.hasNext());
        }
    }
    @Test
    @DisplayName("should return correct string representation for non-negated range")
    void shouldReturnCorrectStringForNonNegatedRange() {
        assertEquals("a-e", charRange.toString());
    }
    
    @Test
    @DisplayName("should return correct string representation for negated range")
    void shouldReturnCorrectStringForNegatedRange() {
        charRange = new CharRange('a', 'e', true);
        assertEquals("^a-e", charRange.toString());
    }
    
    @Test
    @DisplayName("should return correct string representation for single character range")
    void shouldReturnCorrectStringForSingleCharacterRange() {
        charRange = new CharRange('a', 'a', false);
        assertEquals("a", charRange.toString());
    }
    
    @Test
    @DisplayName("should return correct string representation for empty range")
    void shouldReturnCorrectStringForEmptyRange() {
        charRange = new CharRange('e', 'a', false);
        assertEquals("", charRange.toString());
    }
    @Test
    @DisplayName("Test isIn method with character in range")
    void testIsInWithCharacterInRange() {
        assertTrue(range.isIn('c'));
    }
    
    @Test
    @DisplayName("Test isIn method with character not in range")
    void testIsInWithCharacterNotInRange() {
        assertFalse(range.isIn('1'));
    }
    
    @Test
    @DisplayName("Test isIn method with start character")
    void testIsInWithStartCharacter() {
        assertTrue(range.isIn('a'));
    }
    
    @Test
    @DisplayName("Test isIn method with end character")
    void testIsInWithEndCharacter() {
        assertTrue(range.isIn('z'));
    }
    
    @Test
    @DisplayName("Test isIn method with negated range")
    void testIsInWithNegatedRange() {
        CharRange negatedRange = new CharRange('a', 'z', true);
        assertFalse(negatedRange.isIn('c'));
    }
    @Test
    void testIsNotIn_NegatedRange() {
        CharRange range = CharRange.isNotIn('a', 'e');
        assertFalse(range.negated);
    }
    
    @Test
    void testIsNotIn_ReversedRange() {
        CharRange range = CharRange.isNotIn('e', 'a');
        assertEquals('a', range.start);
        assertEquals('e', range.end);
    }
    
    @Test
    void testIsNotIn_SameStartEnd() {
        CharRange range = CharRange.isNotIn('a', 'a');
        assertFalse(range.negated);
        assertEquals('a', range.start);
        assertEquals('a', range.end);
    }
    
    @Test
    void testIsNotIn_EmptyRange() {
        CharRange range = CharRange.isNotIn('a', 'a');
        assertFalse(range.negated);
        assertEquals('a', range.start);
        assertEquals('a', range.end);
    }
    
    @Test
    void testIsNotIn_PositiveRange_HasNext() {
        CharRange range = CharRange.isNotIn('a', 'e');
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
    }
    
    @Test
    void testIsNotIn_PositiveRange_Next() {
        CharRange range = CharRange.isNotIn('a', 'e');
        CharRange.CharacterIterator iterator = range.iterator();
        assertEquals('a', iterator.next());
        assertEquals('b', iterator.next());
        assertEquals('c', iterator.next());
        assertEquals('d', iterator.next());
        assertEquals('e', iterator.next());
    }
    
    @Test
    void testIsNotIn_PositiveRange_Remove() {
        CharRange range = CharRange.isNotIn('a', 'e');
        CharRange.CharacterIterator iterator = range.iterator();
        assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
    }
    
    @Test
    void testIsNotIn_PositiveRange_NoNext() {
        CharRange range = CharRange.isNotIn('a', 'e');
        CharRange.CharacterIterator iterator = range.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }
    
    @Test
    void testIsNotIn_NegatedRange_HasNext() {
        CharRange range = CharRange.isNotIn('e', 'a');
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
    }
    
    @Test
    void testIsNotIn_NegatedRange_Next() {
        CharRange range = CharRange.isNotIn('e', 'a');
        CharRange.CharacterIterator iterator = range.iterator();
        assertEquals('a', iterator.next());
        assertEquals('b', iterator.next());
        assertEquals('c', iterator.next());
        assertEquals('d', iterator.next());
        assertEquals('e', iterator.next());
    }
    
    @Test
    void testIsNotIn_NegatedRange_NoNext() {
        CharRange range = CharRange.isNotIn('e', 'a');
        CharRange.CharacterIterator iterator = range.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }
    
    @Test
    void testIsNotIn_NegatedRange_Remove() {
        CharRange range = CharRange.isNotIn('e', 'a');
        CharRange.CharacterIterator iterator = range.iterator();
        assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
    }

}