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

public class CharSetTest {
    // Your Java code here
    
    @Test
    void testHashCode_EmptyCharSet() {
        assertEquals(89, emptyCharSet.hashCode());
    }
    
    @Test
    void testHashCode_AlphaCharSet() {
        assertEquals(89 + CharSet.ASCII_ALPHA.set.hashCode(), alphaCharSet.hashCode());
    }
    
    @Test
    void testHashCode_LowerAlphaCharSet() {
        assertEquals(89 + CharSet.ASCII_ALPHA_LOWER.set.hashCode(), lowerAlphaCharSet.hashCode());
    }
    
    @Test
    void testHashCode_UpperAlphaCharSet() {
        assertEquals(89 + CharSet.ASCII_ALPHA_UPPER.set.hashCode(), upperAlphaCharSet.hashCode());
    }
    
    @Test
    void testHashCode_NumericCharSet() {
        assertEquals(89 + CharSet.ASCII_NUMERIC.set.hashCode(), numericCharSet.hashCode());
    }
    @Test
    void contains_EmptySet_ReturnsFalse() {
        assertFalse(empty.contains('a'));
        assertFalse(empty.contains('A'));
        assertFalse(empty.contains('1'));
    }
    
    @Test
    void contains_AsciiAlpha_ReturnsTrueForAlphabeticCharacters() {
        assertTrue(asciiAlpha.contains('a'));
        assertTrue(asciiAlpha.contains('A'));
        assertFalse(asciiAlpha.contains('1'));
    }
    
    @Test
    void contains_AsciiAlphaLower_ReturnsTrueForLowercaseAlphabeticCharacters() {
        assertTrue(asciiAlphaLower.contains('a'));
        assertFalse(asciiAlphaLower.contains('A'));
        assertFalse(asciiAlphaLower.contains('1'));
    }
    
    @Test
    void contains_AsciiAlphaUpper_ReturnsTrueForUppercaseAlphabeticCharacters() {
        assertFalse(asciiAlphaUpper.contains('a'));
        assertTrue(asciiAlphaUpper.contains('A'));
        assertFalse(asciiAlphaUpper.contains('1'));
    }
    
    @Test
    void contains_AsciiNumeric_ReturnsTrueForNumericCharacters() {
        assertFalse(asciiNumeric.contains('a'));
        assertFalse(asciiNumeric.contains('A'));
        assertTrue(asciiNumeric.contains('1'));
    }
    
    @Test
    void contains_Common_ReturnsTrueForCommonPatterns() {
        // Add test cases for the common patterns you want to cover
    }
    
    @Test
    void contains_CustomSet_ReturnsTrueForCharactersInSet() {
        CharSet customSet = new CharSet("abcd");
        assertTrue(customSet.contains('a'));
        assertTrue(customSet.contains('b'));
        assertTrue(customSet.contains('c'));
        assertTrue(customSet.contains('d'));
        assertFalse(customSet.contains('e'));
        assertFalse(customSet.contains('1'));
    }
    // Your Java code here
    import org.junit.jupiter.api.Test;
    
    class CharSetTest {
    
        @Test
        void testEquals_sameObject() {
            CharSet charSet = new CharSet();
            Assertions.assertEquals(charSet, charSet);
        }
    
        @Test
        void testEquals_equalCharSets() {
            CharSet charSet = new CharSet("a", "b", "c");
            CharSet other = new CharSet(charSet.getCharRanges());
            Assertions.assertEquals(charSet, other);
        }
    
        @Test
        void testEquals_notEqualCharSets() {
            CharSet charSet = new CharSet("a", "b", "c");
            CharSet other = new CharSet();
            Assertions.assertNotEquals(charSet, other);
        }
    
        @Test
        void testEquals_nullObject() {
            CharSet charSet = new CharSet();
            Assertions.assertNotEquals(charSet, null);
        }
    
        @Test
        void testEquals_differentObjectType() {
            CharSet charSet = new CharSet();
            Assertions.assertNotEquals(charSet, "not a CharSet object");
        }
    }
    import org.junit.jupiter.api.Test;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    class CharSetTest {
    
        @Test
        void testAdd_EmptySet() {
            CharSet charSet = new CharSet();
            charSet.add("a");
            assertEquals(1, charSet.set.size());
            assertTrue(charSet.set.contains(CharRange.is('a')));
        }
    
        @Test
        void testAdd_NullString() {
            CharSet charSet = new CharSet();
            charSet.add(null);
            assertEquals(0, charSet.set.size());
        }
    
        @Test
        void testAdd_NegatedRange() {
            CharSet charSet = new CharSet();
            charSet.add("^a-b");
            assertEquals(1, charSet.set.size());
            assertTrue(charSet.set.contains(CharRange.isNotIn('a', 'b')));
        }
    
        @Test
        void testAdd_Range() {
            CharSet charSet = new CharSet();
            charSet.add("a-z");
            assertEquals(1, charSet.set.size());
            assertTrue(charSet.set.contains(CharRange.isIn('a', 'z')));
        }
    
        @Test
        void testAdd_NegatedChar() {
            CharSet charSet = new CharSet();
            charSet.add("^a");
            assertEquals(1, charSet.set.size());
            assertTrue(charSet.set.contains(CharRange.isNot('a')));
        }
    
        @Test
        void testAdd_Char() {
            CharSet charSet = new CharSet();
            charSet.add("a");
            assertEquals(1, charSet.set.size());
            assertTrue(charSet.set.contains(CharRange.is('a')));
        }
    
        @Test
        void testGetCharRanges() {
            CharSet charSet = new CharSet();
            charSet.add("a");
            charSet.add("b-c");
            charSet.add("^d");
            CharRange[] charRanges = charSet.getCharRanges();
            assertEquals(3, charRanges.length);
            assertTrue(charSet.set.contains(CharRange.is('a')));
            assertTrue(charSet.set.contains(CharRange.isIn('b', 'c')));
            assertTrue(charSet.set.contains(CharRange.isNot('d')));
        }
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    
    class CharSetTest {
    
        private CharSet charSet;
    
        @BeforeEach
        void setUp() {
            charSet = new CharSet("a-z", "0-9");
        }
    
        @Nested
        @DisplayName("toString method")
        class ToStringMethod {
    
            @Test
            @DisplayName("should return a string representation of the set")
            void shouldReturnStringRepresentationOfSet() {
                String expected = "[CharRange [start=97, end=122], CharRange [start=48, end=57]]";
                assertEquals(expected, charSet.toString());
            }
        }
    }
    @Test
    void testGetInstance_NullInput() {
      CharSet charSet = CharSet.getInstance(null);
      assertNull(charSet);
    }
    
    @Test
    void testGetInstance_EmptyInput() {
      CharSet charSet = CharSet.getInstance("");
      assertNotNull(charSet);
      assertTrue(charSet.set.isEmpty());
    }
    
    @Test
    void testGetInstance_SingleCharacter() {
      CharSet charSet = CharSet.getInstance("a");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('a')));
    }
    
    @Test
    void testGetInstance_MultiCharacter() {
      CharSet charSet = CharSet.getInstance("a-e");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('a', 'e')));
    }
    
    @Test
    void testGetInstance_NegatedSingleCharacter() {
      CharSet charSet = CharSet.getInstance("^a");
      assertNotNull(charSet);
      assertFalse(charSet.set.contains(new CharRange('a')));
    }
    
    @Test
    void testGetInstance_NegatedMultiCharacter() {
      CharSet charSet = CharSet.getInstance("^a-e");
      assertNotNull(charSet);
      assertFalse(charSet.set.contains(new CharRange('a', 'e')));
    }
    
    @Test
    void testGetInstance_Combinations() {
      CharSet charSet = CharSet.getInstance("abe-g");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('a')));
      assertTrue(charSet.set.contains(new CharRange('b')));
      assertTrue(charSet.set.contains(new CharRange('e', 'g')));
    }
    
    @Test
    void testGetInstance_DuplicateRanges() {
      CharSet charSet = CharSet.getInstance("a-e", "c-d");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('a', 'e')));
      assertFalse(charSet.set.contains(new CharRange('c', 'd')));
    }
    
    @Test
    void testGetInstance_ReversedRanges() {
      CharSet charSet = CharSet.getInstance("a-e", "e-a");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('a', 'e')));
    }
    
    @Test
    void testGetInstance_NegationCharacterAsLastCharacter() {
      CharSet charSet = CharSet.getInstance("a-z^");
      assertNotNull(charSet);
      assertFalse(charSet.set.contains(new CharRange('a', 'z')));
    }
    
    @Test
    void testGetInstance_NegationCharacterAsSeparateElement() {
      CharSet charSet = CharSet.getInstance("^", "a-z");
      assertNotNull(charSet);
      assertFalse(charSet.set.contains(new CharRange('a', 'z')));
    }
    
    @Test
    void testGetInstance_NegationCharacterInMiddle() {
      CharSet charSet = CharSet.getInstance("^^a-c");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('^')));
      assertTrue(charSet.set.contains(new CharRange('a', 'c')));
    }
    
    @Test
    void testGetInstance_NegationCharacterOnly() {
      CharSet charSet = CharSet.getInstance("^");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('^')));
    }
    
    @Test
    void testGetInstance_NegationCharacterInSet() {
      CharSet charSet = CharSet.getInstance("^a-cd-f");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('^')));
      assertTrue(charSet.set.contains(new CharRange('a', 'c')));
      assertTrue(charSet.set.contains(new CharRange('d', 'f')));
    }
    
    @Test
    void testGetInstance_NegationCharacterInSetReversed() {
      CharSet charSet = CharSet.getInstance("a-c^");
      assertNotNull(charSet);
      assertTrue(charSet.set.contains(new CharRange('^')));
      assertTrue(charSet.set.contains(new CharRange('a', 'c')));
    }
    
    @Test
    void testGetInstance_EmptySet() {
      CharSet charSet = CharSet.getInstance();
      assertNotNull(charSet);
      assertTrue(charSet.set.isEmpty());
    }

}