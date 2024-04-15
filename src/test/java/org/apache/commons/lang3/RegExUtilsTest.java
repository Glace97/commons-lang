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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtilsTest {

    @Test
    @DisplayName("Should return the text itself if pattern is empty")
    void removeFirst_shouldReturnText_ifPatternIsEmpty() {
        String result = RegExUtils.removeFirst("any", Pattern.compile(""));
        assertEquals("any", result);
    }
    
    @Test
    @DisplayName("Should return null if text is null")
    void removeFirst_shouldReturnNull_ifTextIsNull1() {
        String result = RegExUtils.removeFirst(null, "abc");
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should return the text itself if regex is empty")
    void removeFirst_shouldReturnText_ifRegexIsEmpty() {
        String result = RegExUtils.removeFirst("any", "");
        assertEquals("any", result);
    }
    
    @Test
    @DisplayName("Should remove the first matching substring")
    void removeFirst_shouldRemoveFirstMatchingSubstring1() {
        String result = RegExUtils.removeFirst("abcabcabc", "abc");
        assertEquals("abcabc", result);
    }

    @Test
    public void testReplaceFirstWithNullText() {
        String result = RegExUtils.replaceFirst(null, Pattern.compile("pattern"), "replacement");
        assertNull(result);
    }
    
    @Test
    public void testReplaceFirstWithNullReplacement() {
        String result = RegExUtils.replaceFirst("text", Pattern.compile("pattern"), null);
        assertEquals("text", result);
    }
    
    @Test
    public void testReplaceFirstWithEmptyTextAndEmptyPattern() {
        String result = RegExUtils.replaceFirst("", Pattern.compile(""), "replacement");
        assertEquals("replacement", result);
    }
    
    @Test
    public void testReplaceFirstWithEmptyTextAndAnyPattern() {
        String result = RegExUtils.replaceFirst("", Pattern.compile(".*"), "replacement");
        assertEquals("replacement", result);
    }
    
    @Test
    public void testReplaceFirstWithEmptyTextAndNonEmptyPattern() {
        String result = RegExUtils.replaceFirst("", Pattern.compile(".+"), "replacement");
        assertEquals("", result);
    }
    
    @Test
    public void testReplaceFirstWithNonEmptyTextAndEmptyPattern() {
        String result = RegExUtils.replaceFirst("abc", Pattern.compile(""), "replacement");
        assertEquals("replacementabc", result);
    }
    
    @Test
    public void testReplaceFirstWithNonEmptyTextAndPattern() {
        String result = RegExUtils.replaceFirst("<__>\n<__>", Pattern.compile("<.*>"), "replacement");
        assertEquals("replacement\n<__>", result);
    }
    
    @Test
    public void testReplaceFirstWithNonEmptyTextAndPatternWithSingleLineMode() {
        String result = RegExUtils.replaceFirst("<__>\n<__>", Pattern.compile("(?s)<.*>"), "replacement");
        assertEquals("replacement", result);
    }
    
    @Test
    public void testReplaceFirstWithNonEmptyTextAndPatternWithCharacterSet() {
        String result = RegExUtils.replaceFirst("ABCabc123", Pattern.compile("[a-z]"), "_");
        assertEquals("ABC_bc123", result);
    }
    
    @Test
    public void testReplaceFirstWithNonEmptyTextAndPatternWithNegatedCharacterSet() {
        String result = RegExUtils.replaceFirst("ABCabc123abc", Pattern.compile("[^A-Z0-9]+"), "_");
        assertEquals("ABC_123abc", result);
    }
    
    @Test
    public void testReplaceFirstWithNonEmptyTextAndPatternWithNegatedCharacterSetAndEmptyReplacement() {
        String result = RegExUtils.replaceFirst("ABCabc123abc", Pattern.compile("[^A-Z0-9]+"), "");
        assertEquals("ABC123abc", result);
    }
    
    @Test
    public void testReplaceFirstWithNonEmptyTextAndPatternWithGroups() {
        String result = RegExUtils.replaceFirst("Lorem ipsum  dolor   sit", Pattern.compile("( +)([a-z]+)"), "_$2");
        assertEquals("Lorem_ipsum  dolor   sit", result);
    }


    @Test
    public void testReplaceFirstWithStringPatternAndNullText() {
        String result = RegExUtils.replaceFirst(null, "pattern", "replacement");
        assertNull(result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNullReplacement() {
        String result = RegExUtils.replaceFirst("text", "pattern", null);
        assertEquals("text", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndEmptyTextAndEmptyPattern() {
        String result = RegExUtils.replaceFirst("", "", "replacement");
        assertEquals("replacement", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndEmptyTextAndAnyPattern() {
        String result = RegExUtils.replaceFirst("", ".*", "replacement");
        assertEquals("replacement", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndEmptyTextAndNonEmptyPattern() {
        String result = RegExUtils.replaceFirst("", ".+", "replacement");
        assertEquals("", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNonEmptyTextAndEmptyPattern() {
        String result = RegExUtils.replaceFirst("abc", "", "replacement");
        assertEquals("replacementabc", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNonEmptyTextAndPattern() {
        String result = RegExUtils.replaceFirst("<__>\n<__>", "<.*>", "replacement");
        assertEquals("replacement\n<__>", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNonEmptyTextAndPatternWithSingleLineMode() {
        String result = RegExUtils.replaceFirst("<__>\n<__>", "(?s)<.*>", "replacement");
        assertEquals("replacement", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNonEmptyTextAndPatternWithCharacterSet() {
        String result = RegExUtils.replaceFirst("ABCabc123", "[a-z]", "_");
        assertEquals("ABC_bc123", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNonEmptyTextAndPatternWithNegatedCharacterSet() {
        String result = RegExUtils.replaceFirst("ABCabc123abc", "[^A-Z0-9]+", "_");
        assertEquals("ABC_123abc", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNonEmptyTextAndPatternWithNegatedCharacterSetAndEmptyReplacement() {
        String result = RegExUtils.replaceFirst("ABCabc123abc", "[^A-Z0-9]+", "");
        assertEquals("ABC123abc", result);
    }
    
    @Test
    public void testReplaceFirstWithStringPatternAndNonEmptyTextAndPatternWithGroups() {
        String result = RegExUtils.replaceFirst("Lorem ipsum  dolor   sit", "( +)([a-z]+)", "_$2");
        assertEquals("Lorem_ipsum  dolor   sit", result);
    }

    @Test
    void testRemoveAll_nullText() {
        String result = RegExUtils.removeAll(null, Pattern.compile(".*"));
        assertNull(result);
    }
    
    @Test
    void testRemoveAll_nullRegex() {
        String result = RegExUtils.removeAll("any", (Pattern) null);
        assertEquals("any", result);
    }
    
    @Test
    void testRemoveAll_emptyRegex() {
        String result = RegExUtils.removeAll("any", Pattern.compile(""));
        assertEquals("any", result);
    }
    
    @Test
    void testRemoveAll_noMatch() {
        String result = RegExUtils.removeAll("any", Pattern.compile("foo"));
        assertEquals("any", result);
    }
    
    @Test
    void testRemoveAll_singleMatch() {
        String result = RegExUtils.removeAll("any", Pattern.compile(".+"));
        assertEquals("", result);
    }
    
    @Test
    void testRemoveAll_multipleMatches() {
        String result = RegExUtils.removeAll("abc", Pattern.compile(".?"));
        assertEquals("", result);
    }
    
    @Test
    void testRemoveAll_specialCharacters() {
        String result = RegExUtils.removeAll("A&lt;__&gt;\n&lt;__&gt;B", Pattern.compile("&lt;.*&gt;"));
        assertEquals("A\nB", result);
    }
    
    @Test
    void testRemoveAll_specialCharactersWithDotAll() {
        String result = RegExUtils.removeAll("A&lt;__&gt;\n&lt;__&gt;B", Pattern.compile("(?s)&lt;.*&gt;"));
        assertEquals("AB", result);
    }
    
    @Test
    void testRemoveAll_caseSensitive() {
        String result = RegExUtils.removeAll("ABCabc123abc", Pattern.compile("[a-z]"));
        assertEquals("ABC123", result);
    }
    
    @Test
    void testRemoveAll_nullTextWithStringRegex() {
        String result = RegExUtils.removeAll(null, ".*");
        assertNull(result);
    }
    
    @Test
    void testRemoveAll_nullRegexWithStringRegex() {
        String result = RegExUtils.removeAll("any", (String) null);
        assertEquals("any", result);
    }
    
    @Test
    void testRemoveAll_emptyStringRegex() {
        String result = RegExUtils.removeAll("any", "");
        assertEquals("any", result);
    }
    
    @Test
    void testRemoveAll_noMatchWithStringRegex() {
        String result = RegExUtils.removeAll("any", "foo");
        assertEquals("any", result);
    }
    
    @Test
    void testRemoveAll_singleMatchWithStringRegex() {
        String result = RegExUtils.removeAll("any", ".+");
        assertEquals("", result);
    }
    
    @Test
    void testRemoveAll_multipleMatchesWithStringRegex() {
        String result = RegExUtils.removeAll("abc", ".?");
        assertEquals("", result);
    }
    
    @Test
    void testRemoveAll_specialCharactersWithStringRegex() {
        String result = RegExUtils.removeAll("A&lt;__&gt;\n&lt;__&gt;B", "&lt;.*&gt;");
        assertEquals("A\nB", result);
    }
    
    @Test
    void testRemoveAll_specialCharactersWithDotAllWithStringRegex() {
        String result = RegExUtils.removeAll("A&lt;__&gt;\n&lt;__&gt;B", "(?s)&lt;.*&gt;");
        assertEquals("AB", result);
    }
    
    @Test
    void testRemoveAll_caseSensitiveWithStringRegex() {
        String result = RegExUtils.removeAll("ABCabc123abc", "[a-z]");
        assertEquals("ABC123", result);
    }

    
    @Test
    void testRemovePatternWithNullInput() {
        String result = RegExUtils.removePattern(null, ".*");
        assertNull(result);
    }
    
    @Test
    void testRemovePatternWithNullRegex() {
        String result = RegExUtils.removePattern("abc", null);
        assertEquals("abc", result);
    }

    @Test
    void testNullInput() {
        assertNull(RegExUtils.replacePattern(null, "regex", "replacement"));
    }
    
    @Test
    void testNullRegex() {
        assertEquals("text", RegExUtils.replacePattern("text", null, "replacement"));
    }
    
    @Test
    void testNullReplacement() {
        assertEquals("text", RegExUtils.replacePattern("text", "regex", null));
    }
    
    @Test
    void testEmptyInputAndRegex() {
        assertEquals("zzz", RegExUtils.replacePattern("", "", "zzz"));
    }
    
    @Test
    void testEmptyInputAndRegexDotAll() {
        assertEquals("zzz", RegExUtils.replacePattern("", ".*", "zzz"));
    }
    
    @Test
    void testEmptyInputAndRegexOneOrMore() {
        assertEquals("", RegExUtils.replacePattern("", ".+", "zzz"));
    }
    
    @Test
    void testReplacePattern() {
        assertEquals("z", RegExUtils.replacePattern("<__>\n<__>", "<.*>", "z"));
    }
    
    @Test
    void testReplacePatternLowercase() {
        assertEquals("ABC___123", RegExUtils.replacePattern("ABCabc123", "[a-z]", "_"));
    }
    
    @Test
    void testReplacePatternNonAlphanumeric() {
        assertEquals("ABC_123", RegExUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", "_"));
    }
    
    @Test
    void testReplacePatternNonAlphanumericEmptyReplacement() {
        assertEquals("ABC123", RegExUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", ""));
    }
    
    @Test
    void testReplacePatternMultipleSpaces() {
        assertEquals("Lorem_ipsum_dolor_sit", RegExUtils.replacePattern("Lorem ipsum  dolor   sit", "( +)([a-z]+)", "_$2"));
    }
    @Test
    void replaceAll_withNullText_returnsNull() {
        String text = null;
        Pattern regex = Pattern.compile("");
        String replacement = "";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals(null, result);
    }
    
    @Test
    void replaceAll_withNullRegex_returnsOriginalText() {
        String text = "any";
        Pattern regex = null;
        String replacement = "";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("any", result);
    }
    
    @Test
    void replaceAll_withNullReplacement_returnsOriginalText() {
        String text = "any";
        Pattern regex = Pattern.compile("");
        String replacement = null;
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("any", result);
    }
    
    @Test
    void replaceAll_withEmptyTextAndEmptyRegex_returnsReplacement() {
        String text = "";
        Pattern regex = Pattern.compile("");
        String replacement = "zzz";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("zzz", result);
    }
    
    @Test
    void replaceAll_withEmptyTextAndAnyRegex_returnsReplacement() {
        String text = "";
        Pattern regex = Pattern.compile(".*");
        String replacement = "zzz";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("zzz", result);
    }
    
    @Test
    void replaceAll_withEmptyTextAndNonEmptyRegex_returnsEmptyText() {
        String text = "";
        Pattern regex = Pattern.compile(".+");
        String replacement = "zzz";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("", result);
    }
    
    @Test
    void replaceAll_withNonEmptyTextAndEmptyRegex_returnsTextWithReplacement() {
        String text = "abc";
        Pattern regex = Pattern.compile("");
        String replacement = "ZZ";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("ZZaZZbZZcZZ", result);
    }
    
    @Test
    void replaceAll_withTextContainingMultipleMatches_returnsTextWithMatchesReplaced() {
        String text = "<__>\n<__>";
        Pattern regex = Pattern.compile("<.*>");
        String replacement = "z";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("z\nz", result);
    }
    
    @Test
    void replaceAll_withTextContainingMultipleMatchesAndDotAllFlag_returnsTextWithMatchesReplaced() {
        String text = "<__>\n<__>";
        Pattern regex = Pattern.compile("<.*>", Pattern.DOTALL);
        String replacement = "z";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("z", result);
    }
    
    @Test
    void replaceAll_withTextContainingMultipleMatchesAndDotAllPattern_returnsTextWithMatchesReplaced() {
        String text = "<__>\n<__>";
        Pattern regex = Pattern.compile("(?s)<.*>");
        String replacement = "z";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("z", result);
    }
    
    @Test
    void replaceAll_withTextContainingLowercaseLetters_replacesLettersWithUnderscore() {
        String text = "ABCabc123";
        Pattern regex = Pattern.compile("[a-z]");
        String replacement = "_";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("ABC___123", result);
    }
    
    @Test
    void replaceAll_withTextContainingNonAlphanumericCharacters_replacesNonAlphanumericCharactersWithUnderscore() {
        String text = "ABCabc123";
        Pattern regex = Pattern.compile("[^A-Z0-9]+");
        String replacement = "_";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("ABC_123", result);
    }
    
    @Test
    void replaceAll_withTextContainingNonAlphanumericCharactersAndEmptyReplacement_removesNonAlphanumericCharacters() {
        String text = "ABCabc123";
        Pattern regex = Pattern.compile("[^A-Z0-9]+");
        String replacement = "";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("ABC123", result);
    }
    
    @Test
    void replaceAll_withTextContainingWhitespace_replacesWhitespaceWithUnderscore() {
        String text = "Lorem ipsum  dolor   sit";
        Pattern regex = Pattern.compile("( +)([a-z]+)");
        String replacement = "_$2";
    
        String result = RegExUtils.replaceAll(text, regex, replacement);
    
        assertEquals("Lorem_ipsum_dolor_sit", result);
    }
    
    @Test
    void replaceAll_withFullTextAndRegexStrings_returnSameResult() {
        String text = "Lorem ipsum  dolor   sit";
        String regex = "( +)([a-z]+)";
        String replacement = "_$2";
    
        String result1 = RegExUtils.replaceAll(text, regex, replacement);
        String result2 = text.replaceAll(regex, replacement);
    
        assertEquals(result2, result1);
    }

}