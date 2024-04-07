import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

class StringUtilsTest {

    @Nested
    @DisplayName("stripAll method")
    class StripAllMethod {

        @Test
        @DisplayName("should return null when input array is null")
        void testStripAllWithNullArray() {
            String[] result = StringUtils.stripAll(null);
            assertNull(result);
        }

        @Test
        @DisplayName("should return empty array when input array is empty")
        void testStripAllWithEmptyArray() {
            String[] result = StringUtils.stripAll(new String[]{});
            assertEquals(0, result.length);
        }

        @Test
        @DisplayName("should return array with stripped strings")
        void testStripAllWithArray() {
            String[] input = {"abc", "  abc"};
            String[] expected = {"abc", "abc"};
            String[] result = StringUtils.stripAll(input);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("should return array with stripped strings and null values")
        void testStripAllWithArrayAndNullValues() {
            String[] input = {"abc  ", null};
            String[] expected = {"abc", null};
            String[] result = StringUtils.stripAll(input);
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("should return array with stripped strings and specified strip characters")
        void testStripAllWithArrayAndStripChars() {
            String[] input = {"abc  ", null};
            String[] expected = {"abc  ", null};
            String[] result = StringUtils.stripAll(input, "yz");
            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("should return array with stripped strings and specified strip characters")
        void testStripAllWithArrayAndStripChars2() {
            String[] input = {"yabcz", null};
            String[] expected = {"abc", null};
            String[] result = StringUtils.stripAll(input, "yz");
            assertArrayEquals(expected, result);
        }
    }
}