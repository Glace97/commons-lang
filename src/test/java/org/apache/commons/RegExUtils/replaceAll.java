
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class replaceAllTest {

    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    private String initialText;

    @BeforeEach
    void setUp() {
        initialText = TEXT;
    }

    @Test
    void testReplaceAll_withNullText_shouldReturnNull() {
        String result = RegExUtils.replaceAll(null, Pattern.compile("ipsum"), "replacement");
        assertNull(result);
    }

    @Test
    void testReplaceAll_withNullRegex_shouldReturnSameText() {
        String result = RegExUtils.replaceAll(initialText, null, "replacement");
        assertEquals(initialText, result);
    }

    @Test
    void testReplaceAll_withNullReplacement_shouldReturnSameText() {
        String result = RegExUtils.replaceAll(initialText, Pattern.compile("ipsum"), null);
        assertEquals(initialText, result);
    }

    @Test
    void testReplaceAll_withEmptyTextAndEmptyRegex_shouldReturnEmptyText() {
        String result = RegExUtils.replaceAll("", Pattern.compile(""), "replacement");
        assertEquals("", result);
    }

    @Test
    void testReplaceAll_withEmptyTextAndAnyRegex_shouldReturnSameText() {
        String result = RegExUtils.replaceAll("", Pattern.compile(".*"), "replacement");
        assertEquals("", result);
    }

    @Test
    void testReplaceAll_withEmptyTextAndNonEmptyRegex_shouldReturnEmptyText() {
        String result = RegExUtils.replaceAll("", Pattern.compile(".+"), "replacement");
        assertEquals("", result);
    }

    @Test
    void testReplaceAll_withNonEmptyTextAndEmptyRegex_shouldReturnTextWithReplacements() {
        String result = RegExUtils.replaceAll(initialText, Pattern.compile(""), "replacement");
        assertEquals("replacementLreplacementoreplacementremplacement replacementireplacementpreplacementsum replacementdreplacementoreplacementsreplacementlreplacementor replacementsreplacementitreplacement replacementametreplacementt, replacementcreplacementoreplacementnreplacementsecreplacementtreplacementtur replacementadipiscingreplacement replacementelitreplacement.", result);
    }

    @Test
    void testReplaceAll_withNonEmptyTextAndRegex_shouldReturnTextWithReplacements() {
        String result = RegExUtils.replaceAll(initialText, Pattern.compile("ipsum"), "replacement");
        assertEquals("Lorem replacement dolor sit amet, consectetur adipiscing elit.", result);
    }
}
