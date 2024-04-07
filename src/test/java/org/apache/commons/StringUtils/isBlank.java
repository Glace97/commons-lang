import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class isBlankTest {
    
    StringUtils stringUtils = new StringUtils();
    
    @Test
    void testIsBlank_NullString_ReturnsTrue() {
        CharSequence cs = null;
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testIsBlank_EmptyString_ReturnsTrue() {
        CharSequence cs = "";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testIsBlank_WhitespaceString_ReturnsTrue() {
        CharSequence cs = " ";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testIsBlank_NonBlankString_ReturnsFalse() {
        CharSequence cs = "bob";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsBlank_StringWithLeadingAndTrailingWhitespace_ReturnsFalse() {
        CharSequence cs = "  bob  ";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsBlank_StringWithSpecialCharacters_ReturnsFalse() {
        CharSequence cs = "!@#$%^&*()";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsBlank_StringWithTabs_ReturnsFalse() {
        CharSequence cs = "\t\t";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsBlank_StringWithLinefeed_ReturnsFalse() {
        CharSequence cs = "\n\n";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsBlank_StringWithCarriageReturn_ReturnsFalse() {
        CharSequence cs = "\r\r";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsBlank_StringWithMixedWhitespace_ReturnsFalse() {
        CharSequence cs = "  \t\n\r  ";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsBlank_StringWithUnicodeWhitespace_ReturnsFalse() {
        CharSequence cs = "\u2003\u2004\u2005";
        boolean result = StringUtils.isBlank(cs);
        Assertions.assertFalse(result);
    }
}