
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringAfterLastTest {

    @Nested
    @DisplayName("Tests for substringAfterLast(String, int)")
    class SubstringAfterLastWithIntTest {

        @Test
        void shouldReturnNullWhenStringIsNull() {
            assertNull(StringUtils.substringAfterLast(null, 'a'));
        }

        @Test
        void shouldReturnEmptyStringWhenStringIsEmpty() {
            assertEquals("", StringUtils.substringAfterLast("", 'a'));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorNotFound() {
            assertEquals("", StringUtils.substringAfterLast("abc", 'd'));
        }

        @Test
        void shouldReturnSubstringAfterLastSeparator() {
            assertEquals("bc", StringUtils.substringAfterLast("abc", 'a'));
            assertEquals("bc", StringUtils.substringAfterLast("abc", 'b'));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorIsLastCharacter() {
            assertEquals("", StringUtils.substringAfterLast("abc", 'c'));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorIsSpaceCharacter() {
            assertEquals("", StringUtils.substringAfterLast("abc", ' '));
        }

    }

    @Nested
    @DisplayName("Tests for substringAfterLast(String, String)")
    class SubstringAfterLastWithStringTest {

        @Test
        void shouldReturnNullWhenStringIsNull() {
            assertNull(StringUtils.substringAfterLast(null, "a"));
        }

        @Test
        void shouldReturnEmptyStringWhenStringIsEmpty() {
            assertEquals("", StringUtils.substringAfterLast("", "a"));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorIsNull() {
            assertEquals("", StringUtils.substringAfterLast("abc", null));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorIsEmpty() {
            assertEquals("", StringUtils.substringAfterLast("abc", ""));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorNotFound() {
            assertEquals("", StringUtils.substringAfterLast("abc", "d"));
        }

        @Test
        void shouldReturnSubstringAfterLastSeparator() {
            assertEquals("bc", StringUtils.substringAfterLast("abc", "a"));
            assertEquals("a", StringUtils.substringAfterLast("abcba", "b"));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorIsLastSubstring() {
            assertEquals("", StringUtils.substringAfterLast("abc", "c"));
        }

        @Test
        void shouldReturnEmptyStringWhenSeparatorIsSpaceCharacter() {
            assertEquals("", StringUtils.substringAfterLast("abc", " "));
        }
    }
}
