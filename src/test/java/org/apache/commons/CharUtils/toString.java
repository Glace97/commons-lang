import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    @Nested
    @DisplayName("Testing toString(char)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ToStringCharTests {

        CharUtils charUtils;

        @BeforeAll
        void setUp() {
            charUtils = new CharUtils();
        }

        @Test
        @DisplayName("Testing toString(char) with ASCII characters")
        void testToStringWithAsciiCharacters() {
            // Test all ASCII characters from 0 to 127
            for (int i = 0; i < 128; i++) {
                char ch = (char) i;
                String expected = String.valueOf(ch);
                String actual = charUtils.toString(ch);
                assertEquals(expected, actual);
            }
        }

        @Test
        @DisplayName("Testing toString(char) with non-ASCII characters")
        void testToStringWithNonAsciiCharacters() {
            // Test non-ASCII characters
            char[] nonAsciiChars = {'\u00A2', '\u0192', '\u20AC', '\u2603'};
            String[] expected = {"\u00A2", "\u0192", "\u20AC", "\u2603"};
            for (int i = 0; i < nonAsciiChars.length; i++) {
                String actual = charUtils.toString(nonAsciiChars[i]);
                assertEquals(expected[i], actual);
            }
        }
    }

    @Nested
    @DisplayName("Testing toString(Character)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ToStringCharacterTests {

        CharUtils charUtils;

        @BeforeAll
        void setUp() {
            charUtils = new CharUtils();
        }

        @Test
        @DisplayName("Testing toString(Character) with non-null character")
        void testToStringWithNonNullCharacter() {
            Character ch = 'A';
            String expected = "A";
            String actual = charUtils.toString(ch);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Testing toString(Character) with null character")
        void testToStringWithNullCharacter() {
            Character ch = null;
            String expected = null;
            String actual = charUtils.toString(ch);
            assertEquals(expected, actual);
        }
    }
}