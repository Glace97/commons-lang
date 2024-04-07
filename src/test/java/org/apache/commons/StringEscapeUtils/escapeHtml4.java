import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class escapeHtml4Test {
    
    private StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();
    
    @Test
    void testEscapeHtml4() {
        // Test for null input
        assertEquals(null, stringEscapeUtils.escapeHtml4(null));
        
        // Test for empty input
        assertEquals("", stringEscapeUtils.escapeHtml4(""));
        
        // Test for input without special characters
        assertEquals("Hello world!", stringEscapeUtils.escapeHtml4("Hello world!"));
        
        // Test for input with special characters
        assertEquals("&lt;script&gt;alert('XSS');&lt;/script&gt;", stringEscapeUtils.escapeHtml4("<script>alert('XSS');</script>"));
        
        // Test for input with ampersand
        assertEquals("AT&amp;T", stringEscapeUtils.escapeHtml4("AT&T"));
        
        // Test for input with double quotes
        assertEquals("&quot;Hello&quot;", stringEscapeUtils.escapeHtml4("\"Hello\""));
        
        // Test for input with single quotes
        assertEquals("I&apos;m happy", stringEscapeUtils.escapeHtml4("I'm happy"));
        
        // Test for input with less than and greater than symbols
        assertEquals("&lt;tag&gt;", stringEscapeUtils.escapeHtml4("<tag>"));
    }
}