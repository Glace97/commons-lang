import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class dotAllTest {

    @Test
    void testDotAllWithValidRegex() {
        String regex = ".*";
        Pattern pattern = RegExUtils.dotAll(regex);
        assertNotNull(pattern);
        assertEquals(regex, pattern.pattern());
        assertEquals(Pattern.DOTALL, pattern.flags());
    }

    @Test
    void testDotAllWithNullRegex() {
        Pattern pattern = RegExUtils.dotAll(null);
        assertNotNull(pattern);
        assertEquals("", pattern.pattern());
        assertEquals(Pattern.DOTALL, pattern.flags());
    }

    @Test
    void testDotAllWithEmptyRegex() {
        String regex = "";
        Pattern pattern = RegExUtils.dotAll(regex);
        assertNotNull(pattern);
        assertEquals(regex, pattern.pattern());
        assertEquals(Pattern.DOTALL, pattern.flags());
    }

    @Test
    void testDotAllWithRegexContainingSpecialCharacters() {
        String regex = "[a-zA-Z0-9]*";
        Pattern pattern = RegExUtils.dotAll(regex);
        assertNotNull(pattern);
        assertEquals(regex, pattern.pattern());
        assertEquals(Pattern.DOTALL, pattern.flags());
    }

    // Add more test cases for edge cases if necessary

}