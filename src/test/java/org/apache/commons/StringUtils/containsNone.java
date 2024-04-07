
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContainsNoneTest {

    private StringUtils stringUtils = new StringUtils();

    @Test
    void testContainsNoneWithNullCharSequenceAndNullSearchChars() {
        CharSequence cs = null;
        char[] searchChars = null;
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithNullCharSequence() {
        CharSequence cs = null;
        char[] searchChars = {'a', 'b'};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithNullSearchChars() {
        CharSequence cs = "ab";
        char[] searchChars = null;
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithEmptyCharSequenceAndEmptySearchChars() {
        CharSequence cs = "";
        char[] searchChars = {};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithEmptyCharSequence() {
        CharSequence cs = "";
        char[] searchChars = {'a', 'b'};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithEmptySearchChars() {
        CharSequence cs = "ab";
        char[] searchChars = {};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithValidCharSequenceAndValidSearchChars() {
        CharSequence cs = "abz";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertFalse(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithValidCharSequenceAndInvalidSearchChars() {
        CharSequence cs = "ab1";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithValidCharSequenceAndInvalidSearchCharsAtEnd() {
        CharSequence cs = "abz";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertFalse(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithValidCharSequenceAndInvalidSearchCharsInBetween() {
        CharSequence cs = "ab1";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithValidCharSequenceAndInvalidSearchCharsAtStart() {
        CharSequence cs = "zab";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertFalse(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithSurrogatePairCharSequenceAndValidSearchChars() {
        CharSequence cs = "a\uD835\uDCABz";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertFalse(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithSurrogatePairCharSequenceAndInvalidSearchChars() {
        CharSequence cs = "a\uD835\uDCAB1";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithSurrogatePairCharSequenceAndInvalidSearchCharsAtEnd() {
        CharSequence cs = "a\uD835\uDCABz";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertFalse(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithSurrogatePairCharSequenceAndInvalidSearchCharsInBetween() {
        CharSequence cs = "a\uD835\uDCAB1";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertTrue(StringUtils.containsNone(cs, searchChars));
    }

    @Test
    void testContainsNoneWithSurrogatePairCharSequenceAndInvalidSearchCharsAtStart() {
        CharSequence cs = "z\uD835\uDCABa";
        char[] searchChars = {'x', 'y', 'z'};
        Assertions.assertFalse(StringUtils.containsNone(cs, searchChars));
    }

    @ParameterizedTest
    @MethodSource("provideCharSequencesAndSearchChars")
    void testContainsNoneWithParameterizedCharSequencesAndSearchChars(CharSequence cs, char[] searchChars, boolean expected) {
        Assertions.assertEquals(expected, StringUtils.containsNone(cs, searchChars));
    }

    private static Stream<Object[]> provideCharSequencesAndSearchChars() {
        return Stream.of(
                new Object[]{null, null, true},
                new Object[]{null, new char[]{'a', 'b'}, true},
                new Object[]{"ab", null, true},
                new Object[]{"", new char[]{}, true},
                new Object[]{"", new char[]{'a', 'b'}, true},
                new Object[]{"abz", new char[]{'x', 'y', 'z'}, false},
                new Object[]{"ab1", new char[]{'x', 'y', 'z'}, true},
                new Object[]{"abz", new char[]{'x', 'y', 'z'}, false},
                new Object[]{"ab1", new char[]{'x', 'y', 'z'}, true},
                new Object[]{"zab", new char[]{'x', 'y', 'z'}, false},
                new Object[]{"a\uD835\uDCABz", new char[]{'x', 'y', 'z'}, false},
                new Object[]{"a\uD835\uDCAB1", new char[]{'x', 'y', 'z'}, true},
                new Object[]{"a\uD835\uDCABz", new char[]{'x', 'y', 'z'}, false},
                new Object[]{"a\uD835\uDCAB1", new char[]{'x', 'y', 'z'}, true},
                new Object[]{"z\uD835\uDCABa", new char[]{'x', 'y', 'z'}, false}
        );
    }
}
