
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class unescapeJavaTest {

    @Test
    void testUnescapeJava() {
        // Test with null input
        Assertions.assertNull(unescapeJava(null));

        // Test with empty input
        Assertions.assertEquals("", unescapeJava(""));

        // Test with normal input
        Assertions.assertEquals("Hello, World!", unescapeJava("Hello, World!"));

        // Test with escaped characters
        Assertions.assertEquals("\"Hello, World!\"", unescapeJava("\\\"Hello, World!\\\""));
        Assertions.assertEquals("\\Hello, World!\\", unescapeJava("\\\\Hello, World!\\\\"));
        Assertions.assertEquals("\nHello, World!\n", unescapeJava("\\nHello, World!\\n"));
        Assertions.assertEquals("\rHello, World!\r", unescapeJava("\\rHello, World!\\r"));
        Assertions.assertEquals("\tHello, World!\t", unescapeJava("\\tHello, World!\\t"));
        Assertions.assertEquals("\bHello, World!\b", unescapeJava("\\bHello, World!\\b"));
        Assertions.assertEquals("\fHello, World!\f", unescapeJava("\\fHello, World!\\f"));

        // Test with unicode characters
        Assertions.assertEquals("Hello, World!", unescapeJava("\\u0048\\u0065\\u006c\\u006c\\u006f\\u002c\\u0020\\u0057\\u006f\\u0072\\u006c\\u0064\\u0021"));

        // Test with invalid escape sequences
        Assertions.assertEquals("\\Hello, World!\\", unescapeJava("\\Hello, World!\\"));
        Assertions.assertEquals("Hello, World!\\", unescapeJava("Hello, World!\\"));

        // Test with mixed escape sequences
        Assertions.assertEquals("\"Hello, World!\\n\\t\"", unescapeJava("\\\"Hello, World!\\n\\t\\\""));
    }
}
