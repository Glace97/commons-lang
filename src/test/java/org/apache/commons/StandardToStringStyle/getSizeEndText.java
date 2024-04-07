import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getSizeEndTextTest {

    @Test
    void testGetSizeEndText() {
        StandardToStringStyle style = new StandardToStringStyle();
        
        // Test when size end text is not set
        assertNull(style.getSizeEndText());
        
        // Test when size end text is set
        String expected = " items";
        style.setSizeEndText(expected);
        assertEquals(expected, style.getSizeEndText());
        
        // Test when size end text is set to empty string
        expected = "";
        style.setSizeEndText(expected);
        assertEquals(expected, style.getSizeEndText());
        
        // Test when size end text is set to null
        expected = null;
        style.setSizeEndText(expected);
        assertEquals(expected, style.getSizeEndText());
    }
}