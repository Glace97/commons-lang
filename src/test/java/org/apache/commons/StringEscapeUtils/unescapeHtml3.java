import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class unescapeHtml3Test {

    @Test
    void testUnescapeHtml3() {
        StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();
        
        // Test for basic HTML entities
        String input1 = "&lt;Fran&ccedil;ais&gt;";
        String expected1 = "<Français>";
        assertEquals(expected1, stringEscapeUtils.unescapeHtml3(input1));
        
        // Test for unrecognized entities
        String input2 = "&gt;&zzzz;x";
        String expected2 = ">&zzzz;x";
        assertEquals(expected2, stringEscapeUtils.unescapeHtml3(input2));
        
        // Test for numerical \\u Unicode codes
        String input3 = "&#65;&#66;&#67;";
        String expected3 = "ABC";
        assertEquals(expected3, stringEscapeUtils.unescapeHtml3(input3));
        
        // Test for null input
        String input4 = null;
        String expected4 = null;
        assertEquals(expected4, stringEscapeUtils.unescapeHtml3(input4));
        
        // Test for empty input
        String input5 = "";
        String expected5 = "";
        assertEquals(expected5, stringEscapeUtils.unescapeHtml3(input5));
    }
}