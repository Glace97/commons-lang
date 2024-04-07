import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class escapeHtml3Test {

    @Test
    void testEscapeHtml3() {
        StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();
        
        // Test input without any special characters
        String input1 = "Hello World";
        String expected1 = "Hello World";
        String actual1 = stringEscapeUtils.escapeHtml3(input1);
        Assertions.assertEquals(expected1, actual1);
        
        // Test input with special characters
        String input2 = "<script>alert('XSS')</script>";
        String expected2 = "&lt;script&gt;alert(&#39;XSS&#39;)&lt;/script&gt;";
        String actual2 = stringEscapeUtils.escapeHtml3(input2);
        Assertions.assertEquals(expected2, actual2);
        
        // Test input with all HTML 3.0 entities
        String input3 = "< > \" ' &";
        String expected3 = "&lt; &gt; &quot; &apos; &amp;";
        String actual3 = stringEscapeUtils.escapeHtml3(input3);
        Assertions.assertEquals(expected3, actual3);
        
        // Test input with mixed characters
        String input4 = "Hello <script>alert('XSS')</script> World";
        String expected4 = "Hello &lt;script&gt;alert(&#39;XSS&#39;)&lt;/script&gt; World";
        String actual4 = stringEscapeUtils.escapeHtml3(input4);
        Assertions.assertEquals(expected4, actual4);
        
        // Test input with empty string
        String input5 = "";
        String expected5 = "";
        String actual5 = stringEscapeUtils.escapeHtml3(input5);
        Assertions.assertEquals(expected5, actual5);
    }
}