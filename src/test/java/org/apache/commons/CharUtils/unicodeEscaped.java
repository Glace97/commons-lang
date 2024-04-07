import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class unicodeEscapedTest {

    @Test
    void testUnicodeEscaped_withValidChar() {
        char ch = ' ';
        String expected = "\\u0020";
        
        String result = CharUtils.unicodeEscaped(ch);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    void testUnicodeEscaped_withNullChar() {
        Character ch = null;
        String expected = null;
        
        String result = CharUtils.unicodeEscaped(ch);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    void testUnicodeEscaped_withValidCharacter() {
        Character ch = 'A';
        String expected = "\\u0041";
        
        String result = CharUtils.unicodeEscaped(ch);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    void testUnicodeEscaped_withNullCharacter() {
        Character ch = null;
        String expected = null;
        
        String result = CharUtils.unicodeEscaped(ch);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    void testUnicodeEscaped_withLFCharacter() {
        char ch = '\n';
        String expected = "\\u000a";
        
        String result = CharUtils.unicodeEscaped(ch);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    void testUnicodeEscaped_withCRCharacter() {
        char ch = '\r';
        String expected = "\\u000d";
        
        String result = CharUtils.unicodeEscaped(ch);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    void testUnicodeEscaped_withNULCharacter() {
        char ch = '\0';
        String expected = "\\u0000";
        
        String result = CharUtils.unicodeEscaped(ch);
        
        Assertions.assertEquals(expected, result);
    }
}