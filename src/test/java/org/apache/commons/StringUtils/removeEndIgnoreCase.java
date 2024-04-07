import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RemoveEndIgnoreCaseTest {
    private StringUtils utils = new StringUtils();

    @Nested
    @DisplayName("Tests for removeEndIgnoreCase method")
    class RemoveEndIgnoreCaseMethodTests {
        @Test
        @DisplayName("Test removing null string from null source string")
        void testRemoveNullFromNull() {
            String result = utils.removeEndIgnoreCase(null, null);
            Assertions.assertNull(result);
        }

        @Test
        @DisplayName("Test removing empty string from null source string")
        void testRemoveEmptyFromNull() {
            String result = utils.removeEndIgnoreCase(null, "");
            Assertions.assertNull(result);
        }

        @Test
        @DisplayName("Test removing null string from empty source string")
        void testRemoveNullFromEmpty() {
            String result = utils.removeEndIgnoreCase("", null);
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Test removing empty string from empty source string")
        void testRemoveEmptyFromEmpty() {
            String result = utils.removeEndIgnoreCase("", "");
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Test removing null string from non-null source string")
        void testRemoveNullFromNonNull() {
            String source = "www.domain.com";
            String result = utils.removeEndIgnoreCase(source, null);
            Assertions.assertEquals(source, result);
        }

        @Test
        @DisplayName("Test removing empty string from non-null source string")
        void testRemoveEmptyFromNonNull() {
            String source = "www.domain.com";
            String result = utils.removeEndIgnoreCase(source, "");
            Assertions.assertEquals(source, result);
        }

        @Test
        @DisplayName("Test removing non-matching string from source string")
        void testRemoveNonMatchingString() {
            String source = "www.domain.com";
            String remove = "example";
            String result = utils.removeEndIgnoreCase(source, remove);
            Assertions.assertEquals(source, result);
        }

        @Test
        @DisplayName("Test removing matching string from source string")
        void testRemoveMatchingString() {
            String source = "www.domain.com";
            String remove = ".com";
            String expected = "www.domain";
            String result = utils.removeEndIgnoreCase(source, remove);
            Assertions.assertEquals(expected, result);
        }

        @Test
        @DisplayName("Test removing matching string with different case from source string")
        void testRemoveMatchingStringWithDifferentCase() {
            String source = "www.domain.com";
            String remove = ".COM";
            String expected = "www.domain";
            String result = utils.removeEndIgnoreCase(source, remove);
            Assertions.assertEquals(expected, result);
        }

        @Test
        @DisplayName("Test removing empty string from non-empty source string")
        void testRemoveEmptyFromString() {
            String source = "abc";
            String result = utils.removeEndIgnoreCase(source, "");
            Assertions.assertEquals(source, result);
        }
    }
}