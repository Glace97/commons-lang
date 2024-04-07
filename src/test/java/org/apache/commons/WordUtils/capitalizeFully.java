import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class capitalizeFullyTest {
    
    @Test
    void testNullInput() {
        String result = WordUtils.capitalizeFully(null);
        assertEquals(null, result);
    }
    
    @Test
    void testEmptyInput() {
        String result = WordUtils.capitalizeFully("");
        assertEquals("", result);
    }
    
    @Test
    void testAllLowercase() {
        String result = WordUtils.capitalizeFully("i am fine");
        assertEquals("I Am Fine", result);
    }
    
    @Test
    void testMixedCase() {
        String result = WordUtils.capitalizeFully("i aM.fine", '.');
        assertEquals("I Am.Fine", result);
    }
    
    @Test
    void testWhitespaceDelimiters() {
        String result = WordUtils.capitalizeFully("i am fine", ' ');
        assertEquals("I Am Fine", result);
    }
    
    @Test
    void testMultipleDelimiters() {
        String result = WordUtils.capitalizeFully("i aM.fine", ' ', '.');
        assertEquals("I Am.Fine", result);
    }
    
    @Test
    void testNoDelimiters() {
        String result = WordUtils.capitalizeFully("i aM.fine", new char[0]);
        assertEquals("I AM.FINE", result);
    }
    
}