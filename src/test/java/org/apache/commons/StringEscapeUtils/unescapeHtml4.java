import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class unescapeHtml4Test {

    @Test
    void testUnescapeHtml4() {
        StringEscapeUtils utils = new StringEscapeUtils();
        
        // Test unescaping null input
        assertEquals(null, utils.unescapeHtml4(null));
        
        // Test unescaping an empty string
        assertEquals("", utils.unescapeHtml4(""));
        
        // Test unescaping a string without any HTML entities
        assertEquals("Hello, world!", utils.unescapeHtml4("Hello, world!"));
        
        // Test unescaping a string with HTML entities
        assertEquals("Hello, world!", utils.unescapeHtml4("Hello, &#44; world&#33;"));
        
        // Test unescaping a string with multiple HTML entities
        assertEquals("Hello, world!", utils.unescapeHtml4("Hello, &lt;b&gt;world&lt;/b&gt;!"));
        
        // Test unescaping a string with unrecognized HTML entities
        assertEquals("Hello, &unknown;", utils.unescapeHtml4("Hello, &unknown;"));
        
        // Test unescaping a string with invalid HTML entities
        assertEquals("Hello, &amp;lt;", utils.unescapeHtml4("Hello, &amp;lt;"));
    }
}