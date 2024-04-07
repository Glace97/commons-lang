import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class stripAccentsTest {

    @Test
    void testStripAccents_withNullInput_shouldReturnNull() {
        String input = null;
        String result = StringUtils.stripAccents(input);
        assertNull(result);
    }

    @Test
    void testStripAccents_withEmptyString_shouldReturnEmptyString() {
        String input = "";
        String result = StringUtils.stripAccents(input);
        assertEquals("", result);
    }

    @Test
    void testStripAccents_withNoAccents_shouldReturnSameString() {
        String input = "control";
        String result = StringUtils.stripAccents(input);
        assertEquals("control", result);
    }

    @Test
    void testStripAccents_withAccentedCharacters_shouldRemoveAccents() {
        String input = "&eacute;clair";
        String result = StringUtils.stripAccents(input);
        assertEquals("eclair", result);
    }

    @Test
    void testStripAccents_withAccentedCharactersAndLigatures_shouldRemoveAccentsAndLeaveLigatures() {
        String input = "àœ";
        String result = StringUtils.stripAccents(input);
        assertEquals("aeu", result);
    }
}