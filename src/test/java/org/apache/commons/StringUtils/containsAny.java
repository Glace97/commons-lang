
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainsAnyTest {

    @Test
    void testContainsAny_WithNullCharSequence_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny(null, 'a', 'b', 'c'));
    }

    @Test
    void testContainsAny_WithEmptyCharSequence_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("", 'a', 'b', 'c'));
    }

    @Test
    void testContainsAny_WithNullSearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("abc", null));
    }

    @Test
    void testContainsAny_WithEmptySearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("abc", new char[] {}));
    }

    @Test
    void testContainsAny_WithNoMatchingChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("abc", 'd', 'e', 'f'));
    }

    @Test
    void testContainsAny_WithMatchingCharsInBasicMultilingualPlane_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.containsAny("abc", 'a', 'b', 'c'));
    }

    @Test
    void testContainsAny_WithMatchingCharsInSupplementaryPlane_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.containsAny("😀😁😂", '😀', '😁', '😂'));
    }

    @Test
    void testContainsAny_WithMissingLowSurrogate_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.containsAny("😀😁😂", '😁', '😂'));
    }

    @Test
    void testContainsAny_WithMatchingCharsInDifferentOrder_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.containsAny("abc", 'c', 'b', 'a'));
    }

    @Test
    void testContainsAny_WithMultipleOccurrencesOfMatchingChar_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.containsAny("zzabyycdxx", 'z', 'a'));
    }

    @Test
    void testContainsAny_WithNullCharSequenceAndSearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny(null, (char[]) null));
    }

    @Test
    void testContainsAny_WithEmptyCharSequenceAndSearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("", (char[]) null));
    }

    @Test
    void testContainsAny_WithNullCharSequenceAndNullSearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny(null, (CharSequence[]) null));
    }

    @Test
    void testContainsAny_WithEmptyCharSequenceAndEmptySearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("", (CharSequence[]) null));
    }

    @Test
    void testContainsAny_WithNullCharSequenceAndNonNullSearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny(null, "abc", "def"));
    }

    @Test
    void testContainsAny_WithNonNullCharSequenceAndNullSearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("abc", (CharSequence[]) null));
    }

    @Test
    void testContainsAny_WithNonNullCharSequenceAndEmptySearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("abc", new CharSequence[] {}));
    }

    @Test
    void testContainsAny_WithNonNullCharSequenceAndNoMatchingSearchChars_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.containsAny("abc", "def", "ghi"));
    }

    @Test
    void testContainsAny_WithNonNullCharSequenceAndMatchingSearchChars_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.containsAny("abc", "ab", "cd"));
    }

    @Test
    void testContainsAny_WithNonNullCharSequenceAndMultipleOccurrencesOfMatchingSearchChars_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.containsAny("abc", "ab", "cd", "abc"));
    }
}
