
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class replaceOnceTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ReplaceOnceTests {

        @ParameterizedTest
        @ValueSource(strings = {"", "abc", "def", "xyz"})
        void testReplaceOnce_withSearchStringNotFound(String text) {
            String result = stringUtils.replaceOnce(text, "notfound", "replacement");
            assertEquals(text, result);
        }

        @Test
        void testReplaceOnce_withNullText() {
            String result = stringUtils.replaceOnce(null, "search", "replacement");
            assertEquals(null, result);
        }

        @Test
        void testReplaceOnce_withNullSearchString() {
            String result = stringUtils.replaceOnce("text", null, "replacement");
            assertEquals("text", result);
        }

        @Test
        void testReplaceOnce_withNullReplacement() {
            String result = stringUtils.replaceOnce("text", "search", null);
            assertEquals("text", result);
        }

        @Test
        void testReplaceOnce_withEmptySearchString() {
            String result = stringUtils.replaceOnce("text", "", "replacement");
            assertEquals("text", result);
        }

        @Test
        void testReplaceOnce_withEmptyText() {
            String result = stringUtils.replaceOnce("", "search", "replacement");
            assertEquals("", result);
        }

        @Test
        void testReplaceOnce_withEmptyReplacement() {
            String result = stringUtils.replaceOnce("text", "search", "");
            assertEquals("text", result);
        }

        @Test
        void testReplaceOnce_withSingleReplacement() {
            String result = stringUtils.replaceOnce("text", "search", "replacement");
            assertEquals("treplacementxt", result);
        }

        @Test
        void testReplaceOnce_withMultipleReplacements() {
            String result = stringUtils.replaceOnce("textsearchtextsearch", "search", "replacement");
            assertEquals("textreplacementtextsearch", result);
        }
    }
}
