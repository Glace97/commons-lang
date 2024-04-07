import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class uncapitalizeTest {
    
    @Test
    void testUncapitalizeNullInput() {
        String result = WordUtils.uncapitalize(null);
        assertEquals(null, result);
    }
    
    @Test
    void testUncapitalizeEmptyStringInput() {
        String result = WordUtils.uncapitalize("");
        assertEquals("", result);
    }
    
    @Test
    void testUncapitalizeAllUppercase() {
        String result = WordUtils.uncapitalize("I AM FINE");
        assertEquals("i aM fINE", result);
    }
    
    @Test
    void testUncapitalizeWithDelimiters() {
        String result = WordUtils.uncapitalize("I AM.FINE", '.');
        assertEquals("i aM.fINE", result);
    }
    
    @Test
    void testUncapitalizeWithMultipleDelimiters() {
        String result = WordUtils.uncapitalize("I AM!FINE,", ' ', '!', ',');
        assertEquals("i aM!fINE,", result);
    }
    
    @Test
    void testUncapitalizeWithEmptyDelimiters() {
        String result = WordUtils.uncapitalize("I AM FINE", new char[0]);
        assertEquals("i aM fINE", result);
    }
    
    @Test
    void testUncapitalizeWithNullDelimiters() {
        String result = WordUtils.uncapitalize("I AM FINE", null);
        assertEquals("i aM fINE", result);
    }
    
    @Test
    void testUncapitalizeWithWhitespaceDelimiters() {
        String result = WordUtils.uncapitalize("I AM FINE", ' ');
        assertEquals("i aM fINE", result);
    }
    
    @Test
    void testUncapitalizeWithSpecialCharacters() {
        String result = WordUtils.uncapitalize("I AM FINE!", ' ');
        assertEquals("i aM fINE!", result);
    }
    
    @Test
    void testUncapitalizeWithUnicodeCharacters() {
        String result = WordUtils.uncapitalize("HÉLLO WÖRLD", ' ');
        assertEquals("hÉLLO wÖRLD", result);
    }
    
    @Test
    void testUncapitalizeWithMixedCaseDelimiters() {
        String result = WordUtils.uncapitalize("I AM FINE", ' ', 'A', 'M');
        assertEquals("i aM fINE", result);
    }
    
    @Test
    void testUncapitalizeWithNonWhitespaceDelimiters() {
        String result = WordUtils.uncapitalize("I AM.FINE", '.');
        assertEquals("i aM.fINE", result);
    }
}