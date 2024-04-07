import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class replaceEachTest {

    private StringUtils stringUtils;

    @Test
    void replaceEach_shouldReturnNullWhenTextIsNull() {
        String[] searchList = {"a"};
        String[] replacementList = {"b"};
        assertNull(StringUtils.replaceEach(null, searchList, replacementList));
    }

    @Test
    void replaceEach_shouldReturnEmptyStringWhenTextIsEmpty() {
        String[] searchList = {"a"};
        String[] replacementList = {"b"};
        assertEquals("", StringUtils.replaceEach("", searchList, replacementList));
    }

    @Test
    void replaceEach_shouldReturnTextWhenSearchListIsNull() {
        String text = "aba";
        String[] replacementList = {"b"};
        assertEquals(text, StringUtils.replaceEach(text, null, replacementList));
    }

    @Test
    void replaceEach_shouldReturnTextWhenReplacementListIsNull() {
        String text = "aba";
        String[] searchList = {"a"};
        assertEquals(text, StringUtils.replaceEach(text, searchList, null));
    }

    @Test
    void replaceEach_shouldReturnTextWhenSearchListAndReplacementListAreEmpty() {
        String text = "aba";
        String[] searchList = {};
        String[] replacementList = {};
        assertEquals(text, StringUtils.replaceEach(text, searchList, replacementList));
    }

    @Test
    void replaceEach_shouldReturnTextWhenSearchListAndReplacementListHaveDifferentLengths() {
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = {"b", "c"};
        assertEquals(text, StringUtils.replaceEach(text, searchList, replacementList));
    }

    @Test
    void replaceEach_shouldReturnTextWhenNoMatchesFound() {
        String text = "abcde";
        String[] searchList = {"x", "y"};
        String[] replacementList = {"w", "t"};
        assertEquals(text, StringUtils.replaceEach(text, searchList, replacementList));
    }

    @Test
    void replaceEach_shouldReplaceMatchesInText() {
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"w", "t"};
        assertEquals("wcte", StringUtils.replaceEach(text, searchList, replacementList));
    }

    @Test
    void replaceEach_shouldNotRepeatReplacements() {
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"d", "t"};
        assertEquals("dcte", StringUtils.replaceEach(text, searchList, replacementList));
    }

    @ParameterizedTest
    @MethodSource("edgeCaseProvider")
    void replaceEach_shouldHandleEdgeCases(String text, String[] searchList, String[] replacementList, String expected) {
        assertEquals(expected, StringUtils.replaceEach(text, searchList, replacementList));
    }

    private Stream<Object[]> edgeCaseProvider() {
        return Stream.of(
                new Object[] { null, new String[] {"a"}, new String[] {"b"}, null },
                new Object[] { "", new String[] {"a"}, new String[] {"b"}, "" },
                new Object[] { "aba", null, new String[] {"b"}, "aba" },
                new Object[] { "aba", new String[] {"a"}, null, "aba" },
                new Object[] { "aba", new String[] {}, new String[] {}, "aba" },
                new Object[] { "aba", new String[] {"a"}, new String[] {"b", "c"}, "aba" },
                new Object[] { "abcde", new String[] {"x", "y"}, new String[] {"w", "t"}, "abcde" },
                new Object[] { "abcde", new String[] {"ab", "d"}, new String[] {"w", "t"}, "wcte" },
                new Object[] { "abcde", new String[] {"ab", "d"}, new String[] {"d", "t"}, "dcte" }
        );
    }
}