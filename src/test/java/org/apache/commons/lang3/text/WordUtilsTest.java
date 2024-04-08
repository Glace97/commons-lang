package org.apache.commons.lang3.text;

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

public class WordUtilsTest {
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    class WordUtilsTestSuite {
    
        @Test
        void testContainsAllWords_NullString_ReturnsFalse() {
            assertFalse(WordUtils.containsAllWords(null, "word1", "word2"));
        }
    
        @Test
        void testContainsAllWords_EmptyString_ReturnsFalse() {
            assertFalse(WordUtils.containsAllWords("", "word1", "word2"));
        }
    
        @Test
        void testContainsAllWords_NullSearchArray_ReturnsFalse() {
            assertFalse(WordUtils.containsAllWords("text", null));
        }
    
        @Test
        void testContainsAllWords_EmptySearchArray_ReturnsFalse() {
            assertFalse(WordUtils.containsAllWords("text"));
        }
    
        @Test
        void testContainsAllWords_NullElementInSearchArray_ReturnsFalse() {
            assertFalse(WordUtils.containsAllWords("text", "word1", null, "word2"));
        }
    
        @Test
        void testContainsAllWords_NoMatchingWordsInString_ReturnsFalse() {
            assertFalse(WordUtils.containsAllWords("text", "word1", "word2"));
        }
    
        @Test
        void testContainsAllWords_AllMatchingWordsInString_ReturnsTrue() {
            assertTrue(WordUtils.containsAllWords("abc def", "def", "abc"));
        }
    
        @Test
        void testContainsAllWords_PartialMatchingWordsInString_ReturnsFalse() {
            assertFalse(WordUtils.containsAllWords("abc def", "abc", "xyz"));
        }
    }
    @Test
    @DisplayName("Test initials with null input")
    void testInitialsWithNullInput() {
        String result = WordUtils.initials(null);
        assertEquals(null, result);
    }
    
    @Test
    @DisplayName("Test initials with empty input")
    void testInitialsWithEmptyInput() {
        String result = WordUtils.initials("");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Test initials with valid input")
    void testInitialsWithValidInput() {
        String result = WordUtils.initials("Ben John Lee");
        assertEquals("BJL", result);
    }
    
    @Test
    @DisplayName("Test initials with valid input containing special characters")
    void testInitialsWithValidInputContainingSpecialCharacters() {
        String result = WordUtils.initials("Ben J.Lee");
        assertEquals("BJ", result);
    }
    
    @Test
    @DisplayName("Test initials with valid input and custom delimiters")
    void testInitialsWithValidInputAndCustomDelimiters() {
        String result = WordUtils.initials("Ben J.Lee", ' ', '.');
        assertEquals("BJL", result);
    }
    
    @Test
    @DisplayName("Test initials with valid input and empty delimiter array")
    void testInitialsWithValidInputAndEmptyDelimiterArray() {
        String result = WordUtils.initials("Ben J.Lee", new char[0]);
        assertEquals("", result);
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    
    class WordUtilsTestSuite {
    
        @Nested
        @DisplayName("Positive Test Cases")
        class PositiveTests {
    
            @Test
            @DisplayName("Test swapCase with all lowercase characters")
            void testSwapCaseAllLowercase() {
                String input = "the quick brown fox";
                String expected = "THE QUICK BROWN FOX";
    
                String result = WordUtils.swapCase(input);
    
                assertEquals(expected, result);
            }
    
            @Test
            @DisplayName("Test swapCase with all uppercase characters")
            void testSwapCaseAllUppercase() {
                String input = "THE QUICK BROWN FOX";
                String expected = "the quick brown fox";
    
                String result = WordUtils.swapCase(input);
    
                assertEquals(expected, result);
            }
    
            @Test
            @DisplayName("Test swapCase with mixed case characters")
            void testSwapCaseMixedCase() {
                String input = "ThE qUicK BrOWn foX";
                String expected = "tHe QuICk bRoWN FOx";
    
                String result = WordUtils.swapCase(input);
    
                assertEquals(expected, result);
            }
    
            @Test
            @DisplayName("Test swapCase with title case characters")
            void testSwapCaseTitleCase() {
                String input = "The Quick Brown Fox";
                String expected = "tHE qUICK bROWN fOX";
    
                String result = WordUtils.swapCase(input);
    
                assertEquals(expected, result);
            }
    
            @Test
            @DisplayName("Test swapCase with whitespace characters")
            void testSwapCaseWhitespace() {
                String input = "The quick brown fox";
                String expected = "tHE QUICK BROWN FOX";
    
                String result = WordUtils.swapCase(input);
    
                assertEquals(expected, result);
            }
    
            @Test
            @DisplayName("Test swapCase with special characters")
            void testSwapCaseSpecialCharacters() {
                String input = "The quick brown fox!";
                String expected = "tHE QUICK BROWN FOX!";
    
                String result = WordUtils.swapCase(input);
    
                assertEquals(expected, result);
            }
        }
    }
    import org.junit.jupiter.api.Test;
    
    class WordUtilsTest {
    
        @Test
        void shouldReturnNullWhenInputIsNull() {
            // Arrange
            String input = null;
            int wrapLength = 20;
    
            // Act
            String result = WordUtils.wrap(input, wrapLength);
    
            // Assert
            Assertions.assertNull(result);
        }
    
        @Test
        void shouldReturnEmptyStringWhenInputIsEmpty() {
            // Arrange
            String input = "";
            int wrapLength = 20;
    
            // Act
            String result = WordUtils.wrap(input, wrapLength);
    
            // Assert
            Assertions.assertEquals("", result);
        }
    
        @Test
        void shouldWrapTextAtWrapLength() {
            // Arrange
            String input = "Here is one line of text that is going to be wrapped after 20 columns.";
            int wrapLength = 20;
            String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns.";
    
            // Act
            String result = WordUtils.wrap(input, wrapLength);
    
            // Assert
            Assertions.assertEquals(expected, result);
        }
    
        @Test
        void shouldWrapLongWordsIfWrapLongWordsIsTrue() {
            // Arrange
            String input = "Click here to jump to the commons website - https://commons.apache.org";
            int wrapLength = 20;
            String expected = "Click here to jump\nto the commons\nwebsite -\nhttps://commons.apach\ne.org";
    
            // Act
            String result = WordUtils.wrap(input, wrapLength, null, true);
    
            // Assert
            Assertions.assertEquals(expected, result);
        }
    
        @Test
        void shouldNotWrapLongWordsIfWrapLongWordsIsFalse() {
            // Arrange
            String input = "Click here to jump to the commons website - https://commons.apache.org";
            int wrapLength = 20;
            String expected = "Click here to jump\nto the commons\nwebsite -\nhttps://commons.apache.org";
    
            // Act
            String result = WordUtils.wrap(input, wrapLength, null, false);
    
            // Assert
            Assertions.assertEquals(expected, result);
        }
    
        @Test
        void shouldUseSystemLineSeparatorIfNewLineStrIsNull() {
            // Arrange
            String input = "Here is one line of text that is going to be wrapped after 20 columns.";
            int wrapLength = 20;
            String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns.";
    
            // Act
            String result = WordUtils.wrap(input, wrapLength, null, false);
    
            // Assert
            Assertions.assertEquals(expected, result);
        }
    
        @Test
        void shouldUseSpecifiedNewLineString() {
            // Arrange
            String input = "Here is one line of text that is going to be wrapped after 20 columns.";
            int wrapLength = 20;
            String newLineStr = "<br />";
            String expected = "Here is one line of<br />text that is going<br />to be wrapped after<br />20 columns.";
    
            // Act
            String result = WordUtils.wrap(input, wrapLength, newLineStr, false);
    
            // Assert
            Assertions.assertEquals(expected, result);
        }
    
        @Test
        void shouldUseSpaceAsDefaultWrapOnCharacterIfWrapOnIsBlank() {
            // Arrange
            String input = "Here is one line of text that is going to be wrapped after 20 columns.";
            int wrapLength = 20;
            String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns.";
    
            // Act
            String result = WordUtils.wrap(input, wrapLength, null, false, "");
    
            // Assert
            Assertions.assertEquals(expected, result);
        }
    
        @Test
        void shouldUseSpecifiedWrapOnCharacter() {
            // Arrange
            String input = "flammable/inflammable";
            int wrapLength = 20;
            String wrapOn = "/";
            String expected = "flammable\ninflammable";
    
            // Act
            String result = WordUtils.wrap(input, wrapLength, null, false, wrapOn);
    
            // Assert
            Assertions.assertEquals(expected, result);
        }
    
    }
    @Test
    void testCapitalizeFully_NullInput() {
        assertNull(wordUtils.capitalizeFully(null));
    }
    
    @Test
    void testCapitalizeFully_EmptyStringInput() {
        assertEquals("", wordUtils.capitalizeFully(""));
    }
    
    @Test
    void testCapitalizeFully_AllLowercaseInput() {
        assertEquals("I Am Fine", wordUtils.capitalizeFully("i am fine"));
    }
    
    @Test
    void testCapitalizeFully_AllUppercaseInput() {
        assertEquals("I Am Fine", wordUtils.capitalizeFully("I AM FINE"));
    }
    
    @Test
    void testCapitalizeFully_MixedCaseInput() {
        assertEquals("I Am Fine", wordUtils.capitalizeFully("i aM fInE"));
    }
    
    @Test
    void testCapitalizeFully_DelimiterSet_NullInput() {
        assertNull(wordUtils.capitalizeFully(null, '.'));
    }
    
    @Test
    void testCapitalizeFully_DelimiterSet_EmptyStringInput() {
        assertEquals("", wordUtils.capitalizeFully("", '.'));
    }
    
    @Test
    void testCapitalizeFully_DelimiterSet_AllLowercaseInput() {
        assertEquals("I am.Fine", wordUtils.capitalizeFully("i am.fine", '.'));
    }
    
    @Test
    void testCapitalizeFully_DelimiterSet_AllUppercaseInput() {
        assertEquals("I am.Fine", wordUtils.capitalizeFully("I AM.FINE", '.'));
    }
    
    @Test
    void testCapitalizeFully_DelimiterSet_MixedCaseInput() {
        assertEquals("I am.Fine", wordUtils.capitalizeFully("i aM.fIne", '.'));
    }
    
    @Test
    void testCapitalizeFully_DelimiterSet_NullDelimiters() {
        assertEquals("I Am Fine", wordUtils.capitalizeFully("i am fine", null));
    }
    
    @Test
    void testCapitalizeFully_DelimiterSet_EmptyDelimiters() {
        assertEquals("I Am Fine", wordUtils.capitalizeFully("i am fine", new char[0]));
    }
    @Test
    void testUncapitalizeWithNullString() {
        String result = WordUtils.uncapitalize(null);
        Assertions.assertNull(result);
    }
    
    @Test
    void testUncapitalizeWithEmptyString() {
        String result = WordUtils.uncapitalize("");
        Assertions.assertEquals("", result);
    }
    
    @Test
    void testUncapitalizeWithNoDelimiters() {
        String result = WordUtils.uncapitalize("I Am FINE");
        Assertions.assertEquals("i am fINE", result);
    }
    
    @Test
    void testUncapitalizeWithNullDelimiters() {
        String result = WordUtils.uncapitalize("I AM.FINE", null);
        Assertions.assertEquals("i am.fINE", result);
    }
    
    @Test
    void testUncapitalizeWithEmptyDelimiters() {
        String result = WordUtils.uncapitalize("I AM.FINE", new char[0]);
        Assertions.assertEquals("i am.fINE", result);
    }
    
    @Test
    void testUncapitalizeWithSingleDelimiter() {
        String result = WordUtils.uncapitalize("I AM.FINE", '.');
        Assertions.assertEquals("i AM.fINE", result);
    }
    
    @Test
    void testUncapitalizeWithMultipleDelimiters() {
        String result = WordUtils.uncapitalize("I AM.VERY FINE", '.', ' ');
        Assertions.assertEquals("i aM.vERY fINE", result);
    }
    
    @Test
    void testUncapitalizeWithMixedCaseString() {
        String result = WordUtils.uncapitalize("i aM.fINE");
        Assertions.assertEquals("i aM.fINE", result);
    }
    
    @Test
    void testUncapitalizeWithMixedCaseStringAndDelimiters() {
        String result = WordUtils.uncapitalize("i AM.FINE", '.');
        Assertions.assertEquals("i aM.fINE", result);
    }
    @Test
    @DisplayName("Test capitalize with null input")
    void testCapitalizeWithNull() {
        Assertions.assertNull(WordUtils.capitalize(null));
    }
    
    @Test
    @DisplayName("Test capitalize with empty input")
    void testCapitalizeWithEmpty() {
        Assertions.assertEquals("", WordUtils.capitalize(""));
    }
    
    @Test
    @DisplayName("Test capitalize with all lowercase words")
    void testCapitalizeWithLowercaseWords() {
        Assertions.assertEquals("I Am Fine", WordUtils.capitalize("i am fine"));
    }
    
    @Test
    @DisplayName("Test capitalize with words separated by whitespace")
    void testCapitalizeWithWhitespaceDelimiter() {
        Assertions.assertEquals("I Am Fine", WordUtils.capitalize("i am fine"));
    }
    
    @Test
    @DisplayName("Test capitalize with words separated by custom delimiter")
    void testCapitalizeWithCustomDelimiter() {
        Assertions.assertEquals("I aM.Fine", WordUtils.capitalize("i aM.fine", '.'));
    }

}