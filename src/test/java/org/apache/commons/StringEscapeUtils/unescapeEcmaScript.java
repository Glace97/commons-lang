import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class unescapeEcmaScriptTest {

    @Test
    void testUnescapeEcmaScript() {
        StringEscapeUtils stringUtils = new StringEscapeUtils();

        // Test with empty string
        String empty = "";
        assertEquals("", stringUtils.unescapeEcmaScript(empty));

        // Test with string containing only regular characters
        String regular = "abc123";
        assertEquals("abc123", stringUtils.unescapeEcmaScript(regular));

        // Test with string containing escaped characters
        String escaped = "\\\"Hello\\\", \\'World\\'";
        assertEquals("\"Hello\", 'World'", stringUtils.unescapeEcmaScript(escaped));

        // Test with string containing unicode characters
        String unicode = "\\u0048\\u0065\\u006C\\u006C\\u006F";
        assertEquals("Hello", stringUtils.unescapeEcmaScript(unicode));

        // Test with string containing a combination of escaped and regular characters
        String mixed = "abc\\\"123\\'";
        assertEquals("abc\"123'", stringUtils.unescapeEcmaScript(mixed));
    }
}