import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setContentStartTest {
    
    private StandardToStringStyle style;
    
    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }
    
    @Test
    void testSetContentStartWithNonNullString() {
        String contentStart = "Start";
        style.setContentStart(contentStart);
        assertEquals(contentStart, style.getContentStart());
    }
    
    @Test
    void testSetContentStartWithNullString() {
        String contentStart = null;
        style.setContentStart(contentStart);
        assertEquals("", style.getContentStart());
    }
    
    @Test
    void testSetContentStartWithEmptyString() {
        String contentStart = "";
        style.setContentStart(contentStart);
        assertEquals(contentStart, style.getContentStart());
    }
    
}