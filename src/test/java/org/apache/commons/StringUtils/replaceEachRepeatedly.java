import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Nested
    class ReplaceEachRepeatedlyTest {
        private StringUtils stringUtils;

        @BeforeEach
        void setUp() {
            stringUtils = new StringUtils();
        }

        @Test
        void testReplaceEachRepeatedly_withNullText_shouldReturnNull() {
            String[] searchList = {"a", "b"};
            String[] replacementList = {"x", "y"};
            String result = stringUtils.replaceEachRepeatedly(null, searchList, replacementList);
            assertEquals(null, result);
        }

        @Test
        void testReplaceEachRepeatedly_withEmptyText_shouldReturnEmptyText() {
            String[] searchList = {"a", "b"};
            String[] replacementList = {"x", "y"};
            String result = stringUtils.replaceEachRepeatedly("", searchList, replacementList);
            assertEquals("", result);
        }

        @Test
        void testReplaceEachRepeatedly_withNullSearchList_shouldReturnSameText() {
            String text = "aba";
            String[] replacementList = {"x", "y"};
            String result = stringUtils.replaceEachRepeatedly(text, null, replacementList);
            assertEquals("aba", result);
        }

        @Test
        void testReplaceEachRepeatedly_withNullReplacementList_shouldReturnSameText() {
            String text = "aba";
            String[] searchList = {"a", "b"};
            String result = stringUtils.replaceEachRepeatedly(text, searchList, null);
            assertEquals("aba", result);
        }

        @Test
        void testReplaceEachRepeatedly_withEmptySearchList_shouldReturnSameText() {
            String text = "aba";
            String[] searchList = {};
            String[] replacementList = {"x", "y"};
            String result = stringUtils.replaceEachRepeatedly(text, searchList, replacementList);
            assertEquals("aba", result);
        }

        @Test
        void testReplaceEachRepeatedly_withEmptyReplacementList_shouldReturnSameText() {
            String text = "aba";
            String[] searchList = {"a", "b"};
            String[] replacementList = {};
            String result = stringUtils.replaceEachRepeatedly(text, searchList, replacementList);
            assertEquals("aba", result);
        }

        @Test
        void testReplaceEachRepeatedly_withSingleSearchAndReplacement_shouldReplaceOccurrences() {
            String text = "aba";
            String[] searchList = {"a"};
            String[] replacementList = {"x"};
            String result = stringUtils.replaceEachRepeatedly(text, searchList, replacementList);
            assertEquals("xbx", result);
        }

        @Test
        void testReplaceEachRepeatedly_withRepeatedSearchAndReplacement_shouldReplaceOccurrences() {
            String text = "abcde";
            String[] searchList = {"ab", "d"};
            String[] replacementList = {"w", "t"};
            String result = stringUtils.replaceEachRepeatedly(text, searchList, replacementList);
            assertEquals("wcte", result);
        }

        @Test
        void testReplaceEachRepeatedly_withRepeatedSearchAndReplacement_shouldThrowIllegalStateException() {
            String text = "abcde";
            String[] searchList = {"ab", "d"};
            String[] replacementList = {"d", "ab"};
            assertThrows(IllegalStateException.class, () -> {
                stringUtils.replaceEachRepeatedly(text, searchList, replacementList);
            });
        }
    }
}